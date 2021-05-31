package Main;

// Librerias Creadas
import Exit.ExitEditor;
import Judge.ReemplazarCodigo;
import Services.RecursosService;
import WindowJudge.Runtime_Window;
import WindowJudge.Compilation_Window;
import CustomComponents.CustomScrollBarUI;
import Judge.CompileAndRun.InputStreamConsumer;

// Librerias Externas
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.CodeTemplateManager;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.rsyntaxtextarea.templates.CodeTemplate;
import org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate;

// Librerias Default
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionListener;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JFileChooser;
import javax.swing.UnsupportedLookAndFeelException;

public class CodeEditor extends javax.swing.JFrame implements ClipboardOwner {

    // Instancias
    private final RecursosService sRecursos;
    private final ExitEditor Exit = new ExitEditor();
    private final JFileChooser seleccion = new JFileChooser();
    private final RSyntaxTextArea textArea = new RSyntaxTextArea();

    // Variables
    private File archivo_abrir;
    private FileInputStream entrada;
    private FileOutputStream salida, out;
    private boolean aux = false;

    // Ventanas informativas de ejecucion
    static Compilation_Window ce = new Compilation_Window();
    static Runtime_Window rt = new Runtime_Window();

    public CodeEditor() {
        sRecursos = RecursosService.getService();
        initComponents();
        configureWindow();
        confirmClosing();
        editorConfiguration();
    }

    // Agregar configuracion inicial al Editor
    private void editorConfiguration() {
        configureScrollBar();
        configureLabels();
        configureRSyntax();
    }

    // Verificar la pulsacion de boton
    private class buttonPressedListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Exit.Btn_Si) {
                save();
                Exit.dispose();
                dispose();
            } else if (e.getSource() == Exit.Btn_No) {
                Exit.dispose();
                dispose();
            } else if (e.getSource() == Exit.Btn_Cancelar) {
                setEnabled(true);
                Exit.dispose();
            }
        }
    }

    // Confirmar el cierre de la Aplicacion
    private void confirmClosing() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    close();
                }
            });
        } catch (Exception e) {
            System.out.println("Error al salir " + e);
        }
    }

    // Llamado a JFrame de ExitEditor
    private void close() {
        this.setEnabled(false);
        Exit.setVisible(true);
        Exit.Btn_Si.addActionListener(new buttonPressedListener());
        Exit.Btn_No.addActionListener(new buttonPressedListener());
        Exit.Btn_Cancelar.addActionListener(new buttonPressedListener());
    }

    private void configureScrollBar() {
        // ScrollBar de Entrada
        Scp_Entrada.getVerticalScrollBar().setUI(new CustomScrollBarUI(
                sRecursos.getColorDrag(), sRecursos.getColorThumbOn(), sRecursos.getColorThumbOff()));
        Scp_Entrada.getHorizontalScrollBar().setUI(new CustomScrollBarUI(
                sRecursos.getColorDrag(), sRecursos.getColorThumbOn(), sRecursos.getColorThumbOff()));
        Scp_Entrada.getVerticalScrollBar().setBackground(sRecursos.getColorBgScroll());
        Scp_Entrada.getHorizontalScrollBar().setBackground(sRecursos.getColorBgScroll());

        // ScrollBar de Salida
        Scp_Salida.getVerticalScrollBar().setUI(new CustomScrollBarUI(
                sRecursos.getColorDrag(), sRecursos.getColorThumbOn(), sRecursos.getColorThumbOff()));
        Scp_Salida.getHorizontalScrollBar().setUI(new CustomScrollBarUI(
                sRecursos.getColorDrag(), sRecursos.getColorThumbOn(), sRecursos.getColorThumbOff()));
        Scp_Salida.getVerticalScrollBar().setBackground(sRecursos.getColorBgScroll());
        Scp_Salida.getHorizontalScrollBar().setBackground(sRecursos.getColorBgScroll());
    }

    // Configuracion general de la ventana
    private void configureWindow() {
        setTitle("Editor de Código | Apolo");
        this.setLocationRelativeTo(null);
        this.setExtendedState(((int) sRecursos.getDScreen().getHeight() == 768) ? 6 : 0);
        this.setResizable((int) sRecursos.getDScreen().getHeight() == 768);
        // Agregar icono de Apolo
        setIconImage(new ImageIcon(getClass().getResource(
                "/Resources/General/Apolo_Icono_Blanco_40px.png")).getImage()); // Agregar icono de Apolo
    }

    private void configureLabels() {
        Lbl_TituloEntrada.setFont(sRecursos.getFTitleEditor());
        Lbl_TituloSalida.setFont(sRecursos.getFTitleEditor());
    }

    // Configuracion del Area de codigo con RSyntax
    private void configureRSyntax() {
        addTemplate();
        addSnippets();
        loadTheme();

        RSyntaxTextArea.setTemplatesEnabled(true);
        RTextScrollPane sp = new RTextScrollPane(textArea);

        // Configuracion del ScrollBar
        sp.getHorizontalScrollBar().setBackground(sRecursos.getColorBgScroll());
        sp.getVerticalScrollBar().setBackground(sRecursos.getColorBgScroll());
        sp.getHorizontalScrollBar().setUI(new CustomScrollBarUI(
                sRecursos.getColorDrag(),
                sRecursos.getColorThumbOn(),
                sRecursos.getColorThumbOff()));
        sp.getVerticalScrollBar().setUI(new CustomScrollBarUI(
                sRecursos.getColorDrag(),
                sRecursos.getColorThumbOn(),
                sRecursos.getColorThumbOff()));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.getViewport();

        // Edicion del RSyntax
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setBackground(sRecursos.getColorBgScroll());
        textArea.setFont(sRecursos.getFEditor());
        textArea.revalidate();

        Pnl_Codigo.add(sp);
    }

    // Cargar plantilla HelloWorld en el Area de Texto
    private void addTemplate() {
        textArea.setText("/*\n"
                + "Notas: \n"
                + "1. Para la ejecución en este editor la\n"
                + "clase principal siempre debe llamarse (Main) \n"
                + "2. Si el programa pide entradas por teclado,\n"
                + "ingréselas primero antes de hacer la ejecución.\n"
                + " */\n"
                + "\n"
                + "public class Main {\n"
                + "\n"
                + "    public static void main(String[] args) {\n"
                + "        System.out.println(\"Hello World\");\n"
                + "    }\n"
                + "}");
    }

    // Cargar tema preestablecido por xml en RSyntaxTextArea
    private void loadTheme() {
        try {
            String t = "/org/fife/ui/rsyntaxtextarea/themes/monokai.xml";
            Theme theme = Theme.load(getClass().getResourceAsStream(t));
            theme.apply(textArea);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    // Snippets en el editor de codigo
    // Ctrl + Shift + Espacio
    private void addSnippets() {
        CompletionProvider provider = createCompletionProvider();
        AutoCompletion ac = new AutoCompletion(provider);
        CodeTemplateManager ctm = RSyntaxTextArea.getCodeTemplateManager();
        CodeTemplate ct = new StaticCodeTemplate("for", "for (int i = 0; i < ", "; i++) {\n\t\n}\n");
        ctm.addTemplate(ct);
        ct = new StaticCodeTemplate("switch", "switch(", "variable) {\n"
                + "  case x:\n"
                + "    // codigo\n"
                + "    break;\n"
                + "  default:\n"
                + "    // codigo\n"
                + "}");
        ctm.addTemplate(ct);
        ct = new StaticCodeTemplate("fore", "for(tipo", " variable: array){\n\t\n}");
        ctm.addTemplate(ct);
        ct = new StaticCodeTemplate("if", "if(", "){\n\t\n}");
        ctm.addTemplate(ct);
        ct = new StaticCodeTemplate("ifel", "if(", "){\n\t\n}else{\n}");
        ctm.addTemplate(ct);
        ct = new StaticCodeTemplate("while", "while(", "){\n\t\n}");
        ctm.addTemplate(ct);
        ct = new StaticCodeTemplate("do", "do {\n\t", "\n} while (true);");
        ctm.addTemplate(ct);
        ct = new StaticCodeTemplate("try", "try {\n\t", "\n} catch (Exception e){\n}");
        ctm.addTemplate(ct);
        ct = new StaticCodeTemplate("sout", "System.out.println(\"", "\");");
        ctm.addTemplate(ct);
        ct = new StaticCodeTemplate("void", "static void ", "(){\n\t\n}");
        ctm.addTemplate(ct);
        pack();
        ac.install(textArea);
    }

    // Creacion de cuadro de autocompletado
    // con palabras reservadas y métodos útiles
    // Ctrl + Espacio
    private CompletionProvider createCompletionProvider() {

        DefaultCompletionProvider provider = new DefaultCompletionProvider();

        provider.addCompletion(new BasicCompletion(provider, "boolean"));
        provider.addCompletion(new BasicCompletion(provider, "break"));
        provider.addCompletion(new BasicCompletion(provider, "byte"));
        provider.addCompletion(new BasicCompletion(provider, "case"));
        provider.addCompletion(new BasicCompletion(provider, "catch"));
        provider.addCompletion(new BasicCompletion(provider, "char"));
        provider.addCompletion(new BasicCompletion(provider, "continue"));
        provider.addCompletion(new BasicCompletion(provider, "default"));
        provider.addCompletion(new BasicCompletion(provider, "double"));
        provider.addCompletion(new BasicCompletion(provider, "do"));
        provider.addCompletion(new BasicCompletion(provider, "else"));
        provider.addCompletion(new BasicCompletion(provider, "false"));
        provider.addCompletion(new BasicCompletion(provider, "final"));
        provider.addCompletion(new BasicCompletion(provider, "finally"));
        provider.addCompletion(new BasicCompletion(provider, "float"));
        provider.addCompletion(new BasicCompletion(provider, "for"));
        provider.addCompletion(new BasicCompletion(provider, "if"));
        provider.addCompletion(new BasicCompletion(provider, "isEmpty()"));
        provider.addCompletion(new BasicCompletion(provider, "import"));
        provider.addCompletion(new BasicCompletion(provider, "int"));
        provider.addCompletion(new BasicCompletion(provider, "java.util.Scanner;"));
        provider.addCompletion(new BasicCompletion(provider, "long"));
        provider.addCompletion(new BasicCompletion(provider, "new"));
        provider.addCompletion(new BasicCompletion(provider, "nextInt();"));
        provider.addCompletion(new BasicCompletion(provider, "nextLong();"));
        provider.addCompletion(new BasicCompletion(provider, "next();"));
        provider.addCompletion(new BasicCompletion(provider, "null"));
        provider.addCompletion(new BasicCompletion(provider, "length"));
        provider.addCompletion(new BasicCompletion(provider, "offer("));
        provider.addCompletion(new BasicCompletion(provider, "package"));
        provider.addCompletion(new BasicCompletion(provider, "pop()"));
        provider.addCompletion(new BasicCompletion(provider, "poll()"));
        provider.addCompletion(new BasicCompletion(provider, "private"));
        provider.addCompletion(new BasicCompletion(provider, "public"));
        provider.addCompletion(new BasicCompletion(provider, "peek()"));
        provider.addCompletion(new BasicCompletion(provider, "push("));
        provider.addCompletion(new BasicCompletion(provider, "put("));
        provider.addCompletion(new BasicCompletion(provider, "return"));
        provider.addCompletion(new BasicCompletion(provider, "remove()"));
        provider.addCompletion(new BasicCompletion(provider, "Scanner"));
        provider.addCompletion(new BasicCompletion(provider, "size()"));
        provider.addCompletion(new BasicCompletion(provider, "static"));
        provider.addCompletion(new BasicCompletion(provider, "switch"));
        provider.addCompletion(new BasicCompletion(provider, "System.in"));
        provider.addCompletion(new BasicCompletion(provider, "true"));
        provider.addCompletion(new BasicCompletion(provider, "try"));
        provider.addCompletion(new BasicCompletion(provider, "void"));
        provider.addCompletion(new BasicCompletion(provider, "while"));

        return provider;
    }

    // Copiar texto en portapapeles
    private void setClipboard(String texto) {
        StringSelection txt = new StringSelection(texto);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(txt, this);
    }

    // Abrir archivo Java
    private String openFile(File archivo) throws IOException {
        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while ((ascci = entrada.read()) != -1) {
                char caracter = (char) ascci;
                documento += caracter;
            }
            entrada.close();
        } catch (IOException e) {
            ErrorWindow ew = new ErrorWindow(this, true, "Error al abrir", "/Resources/Ventanas/Error.png");
            ew.setVisible(true);
        }
        return documento;
    }

    // Guardar archivo Java
    private String saveFile(File archivo, String documento) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "¡Código guardado exitosamente!";
            salida.close();
        } catch (IOException e) {
            ErrorWindow ew = new ErrorWindow(this, true, "Error al guardar", "/Resources/Ventanas/Error.png");
            ew.setVisible(true);
        }
        return mensaje;
    }

    // Guardar archivo ejecutado anteriormente
    protected void saveExecution() {
        String documento = textArea.getText();
        saveFile(archivo_abrir, documento);
    }

    // Guardar archivo usando Buscador JFileChooser
    protected void save() {
        aux = true;
        if (seleccion.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            String nombre_code;
            if (seleccion.getSelectedFile().toString().endsWith(".java")) {
                nombre_code = seleccion.getSelectedFile().toString();
            } else {
                nombre_code = seleccion.getSelectedFile().toString();
                try {
                    nombre_code = nombre_code.substring(0, nombre_code.indexOf('.')) + ".java";
                } catch (StringIndexOutOfBoundsException e) {
                    nombre_code += ".java";
                }
            }
            archivo_abrir = new File(nombre_code);
            String documento = textArea.getText();
            String mensaje = saveFile(archivo_abrir, documento);
            if (mensaje != null) {
                ErrorWindow ew = new ErrorWindow(this, true, mensaje, "/Resources/Ventanas/Success.png");
                ew.setVisible(true);
            } else {
                ErrorWindow ew = new ErrorWindow(this, true, "Archivo no compatible", "/Resources/Ventanas/Error.png");
                ew.setVisible(true);
            }
        }
    }

    // Obtener el texto de Entrada en el editor
    private void input() {
        String documento = Txa_Entrada.getText();
        try {
            byte[] bytxt = documento.getBytes();
            out = new FileOutputStream("C:\\Apolo\\src\\ioeditor\\input.txt");
            out.write(bytxt);
            out.close();
        } catch (IOException e) {
            ErrorWindow ew = new ErrorWindow(this, true, "Error al guardar", "/Resources/Ventanas/Error.png");
            ew.setVisible(true);
        }
    }

    // Compilar archivo 
    private int compile(String ruta) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("javac", ruta);
        pb.redirectError();

        String[] partesRuta = ruta.split("\\\\");

        String rutaNueva = "";

        for (int i = 0; i < partesRuta.length - 1; i++) {
            if (i < partesRuta.length - 2) {
                rutaNueva += partesRuta[i] + "\\\\";
            } else {
                rutaNueva += partesRuta[i];
            }
        }

        pb.directory(new File(rutaNueva));
        Process p = pb.start();
        InputStreamConsumer consumer = new InputStreamConsumer(p.getInputStream());
        consumer.start();
        int result = p.waitFor();
        consumer.join();
        System.out.println(consumer.getOutput());
        return result;
    }

    // Ejecutar archivo
    private int execute(String clase) throws IOException, InterruptedException {

        List<String> cmds = new ArrayList<>();
        cmds.add("java");
        cmds.add(clase);

        ProcessBuilder pb = new ProcessBuilder(cmds);
        pb.redirectError();
        pb.redirectInput(new File("C:\\Apolo\\src\\ioeditor", "output.txt"));

        pb.directory(new File("src"));

        Process p = pb.start();
        InputStreamConsumer consumer = new InputStreamConsumer(p.getInputStream());
        consumer.start();
        int result = p.waitFor();
        consumer.join();

        String writteable = consumer.getOutput().toString();

        Txa_Salida.setText(writteable);

        try (FileWriter fw = new FileWriter("C:\\Apolo\\src\\ioeditor\\output.txt")) {
            fw.write(writteable);
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Principal = new javax.swing.JPanel();
        Lbl_Icono = new javax.swing.JLabel();
        Lbl_Codigo = new javax.swing.JLabel();
        Pnl_Botones = new javax.swing.JPanel();
        Btn_Limpiar = new javax.swing.JButton();
        Btn_Copiar = new javax.swing.JButton();
        Btn_Abrir = new javax.swing.JButton();
        Btn_Guardar = new javax.swing.JButton();
        Btn_Ejecutar = new javax.swing.JButton();
        Btn_Plantilla = new javax.swing.JButton();
        Pnl_Codigo = new javax.swing.JPanel();
        Pnl_EntradaSalida = new javax.swing.JPanel();
        Scp_Salida = new javax.swing.JScrollPane();
        Txa_Salida = new javax.swing.JTextArea();
        Lbl_Salida = new javax.swing.JLabel();
        Lbl_TituloSalida = new javax.swing.JLabel();
        Scp_Entrada = new javax.swing.JScrollPane();
        Txa_Entrada = new javax.swing.JTextArea();
        Lbl_Entrada = new javax.swing.JLabel();
        Lbl_TituloEntrada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(53, 54, 58));
        setMinimumSize(new java.awt.Dimension(1366, 705));
        setSize(new java.awt.Dimension(1366, 705));

        Pnl_Principal.setBackground(new java.awt.Color(34, 34, 34));
        Pnl_Principal.setMaximumSize(new java.awt.Dimension(1366, 705));
        Pnl_Principal.setMinimumSize(new java.awt.Dimension(1366, 705));
        Pnl_Principal.setPreferredSize(new java.awt.Dimension(1366, 705));
        Pnl_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Icono_Blanco_x2.png"))); // NOI18N
        Pnl_Principal.add(Lbl_Icono, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 70, 90));

        Lbl_Codigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 85, 22), 1, true));
        Lbl_Codigo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Pnl_Principal.add(Lbl_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 850, 620));

        Pnl_Botones.setBackground(new java.awt.Color(34, 34, 34));
        Pnl_Botones.setMaximumSize(new java.awt.Dimension(850, 60));
        Pnl_Botones.setMinimumSize(new java.awt.Dimension(850, 60));
        Pnl_Botones.setPreferredSize(new java.awt.Dimension(850, 60));
        Pnl_Botones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Limpiar_Off.png"))); // NOI18N
        Btn_Limpiar.setMnemonic('d');
        Btn_Limpiar.setToolTipText("Alt + d");
        Btn_Limpiar.setBorder(null);
        Btn_Limpiar.setBorderPainted(false);
        Btn_Limpiar.setContentAreaFilled(false);
        Btn_Limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Limpiar.setFocusPainted(false);
        Btn_Limpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Limpiar.setMaximumSize(new java.awt.Dimension(132, 40));
        Btn_Limpiar.setMinimumSize(new java.awt.Dimension(132, 40));
        Btn_Limpiar.setPreferredSize(new java.awt.Dimension(132, 40));
        Btn_Limpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Limpiar_On.png"))); // NOI18N
        Btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LimpiarActionPerformed(evt);
            }
        });
        Pnl_Botones.add(Btn_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 132, 40));

        Btn_Copiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Copiar_Off.png"))); // NOI18N
        Btn_Copiar.setMnemonic('c');
        Btn_Copiar.setToolTipText("Alt + c");
        Btn_Copiar.setBorderPainted(false);
        Btn_Copiar.setContentAreaFilled(false);
        Btn_Copiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Copiar.setFocusPainted(false);
        Btn_Copiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Copiar.setMaximumSize(new java.awt.Dimension(132, 40));
        Btn_Copiar.setMinimumSize(new java.awt.Dimension(132, 40));
        Btn_Copiar.setPreferredSize(new java.awt.Dimension(132, 40));
        Btn_Copiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Copiar_On.png"))); // NOI18N
        Btn_Copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CopiarActionPerformed(evt);
            }
        });
        Pnl_Botones.add(Btn_Copiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 132, 40));

        Btn_Abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Abrir_Off.png"))); // NOI18N
        Btn_Abrir.setMnemonic('o');
        Btn_Abrir.setToolTipText("Alt + o");
        Btn_Abrir.setBorderPainted(false);
        Btn_Abrir.setContentAreaFilled(false);
        Btn_Abrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Abrir.setFocusPainted(false);
        Btn_Abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Abrir.setMaximumSize(new java.awt.Dimension(132, 40));
        Btn_Abrir.setMinimumSize(new java.awt.Dimension(132, 40));
        Btn_Abrir.setPreferredSize(new java.awt.Dimension(132, 40));
        Btn_Abrir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Abrir_On.png"))); // NOI18N
        Btn_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AbrirActionPerformed(evt);
            }
        });
        Pnl_Botones.add(Btn_Abrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 132, 40));

        Btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Guardar_Off.png"))); // NOI18N
        Btn_Guardar.setMnemonic('s');
        Btn_Guardar.setToolTipText("Alt + s");
        Btn_Guardar.setBorder(null);
        Btn_Guardar.setBorderPainted(false);
        Btn_Guardar.setContentAreaFilled(false);
        Btn_Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Guardar.setFocusPainted(false);
        Btn_Guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Guardar.setMaximumSize(new java.awt.Dimension(132, 40));
        Btn_Guardar.setMinimumSize(new java.awt.Dimension(132, 40));
        Btn_Guardar.setPreferredSize(new java.awt.Dimension(132, 40));
        Btn_Guardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Guardar_On.png"))); // NOI18N
        Btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GuardarActionPerformed(evt);
            }
        });
        Pnl_Botones.add(Btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 132, 40));

        Btn_Ejecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Ejecutar_Off.png"))); // NOI18N
        Btn_Ejecutar.setMnemonic('n');
        Btn_Ejecutar.setToolTipText("Alt + n");
        Btn_Ejecutar.setBorder(null);
        Btn_Ejecutar.setBorderPainted(false);
        Btn_Ejecutar.setContentAreaFilled(false);
        Btn_Ejecutar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Ejecutar.setFocusPainted(false);
        Btn_Ejecutar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Ejecutar.setMaximumSize(new java.awt.Dimension(132, 40));
        Btn_Ejecutar.setMinimumSize(new java.awt.Dimension(132, 40));
        Btn_Ejecutar.setPreferredSize(new java.awt.Dimension(132, 40));
        Btn_Ejecutar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Ejecutar_On.png"))); // NOI18N
        Btn_Ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EjecutarActionPerformed(evt);
            }
        });
        Pnl_Botones.add(Btn_Ejecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 132, 40));

        Btn_Plantilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Plantilla_Off.png"))); // NOI18N
        Btn_Plantilla.setMnemonic('p');
        Btn_Plantilla.setToolTipText("Alt + p");
        Btn_Plantilla.setBorder(null);
        Btn_Plantilla.setBorderPainted(false);
        Btn_Plantilla.setContentAreaFilled(false);
        Btn_Plantilla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Plantilla.setFocusPainted(false);
        Btn_Plantilla.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Plantilla.setMaximumSize(new java.awt.Dimension(132, 40));
        Btn_Plantilla.setMinimumSize(new java.awt.Dimension(132, 40));
        Btn_Plantilla.setPreferredSize(new java.awt.Dimension(132, 40));
        Btn_Plantilla.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Plantilla_On.png"))); // NOI18N
        Btn_Plantilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PlantillaActionPerformed(evt);
            }
        });
        Pnl_Botones.add(Btn_Plantilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 132, 40));

        Pnl_Principal.add(Pnl_Botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        Pnl_Codigo.setBackground(new java.awt.Color(34, 34, 34));
        Pnl_Codigo.setMaximumSize(new java.awt.Dimension(850, 430));
        Pnl_Codigo.setMinimumSize(new java.awt.Dimension(850, 430));
        Pnl_Codigo.setLayout(new java.awt.CardLayout());
        Pnl_Principal.add(Pnl_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 850, 620));

        Pnl_EntradaSalida.setBackground(new java.awt.Color(34, 34, 34));
        Pnl_EntradaSalida.setMaximumSize(new java.awt.Dimension(850, 215));
        Pnl_EntradaSalida.setMinimumSize(new java.awt.Dimension(850, 215));
        Pnl_EntradaSalida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Scp_Salida.setBorder(null);

        Txa_Salida.setEditable(false);
        Txa_Salida.setBackground(new java.awt.Color(34, 34, 34));
        Txa_Salida.setColumns(20);
        Txa_Salida.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        Txa_Salida.setForeground(new java.awt.Color(255, 255, 255));
        Txa_Salida.setLineWrap(true);
        Txa_Salida.setRows(5);
        Txa_Salida.setWrapStyleWord(true);
        Txa_Salida.setBorder(null);
        Txa_Salida.setCaretColor(new java.awt.Color(255, 255, 255));
        Txa_Salida.setSelectionColor(new java.awt.Color(56, 58, 56));
        Scp_Salida.setViewportView(Txa_Salida);

        Pnl_EntradaSalida.add(Scp_Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 440, 255));

        Lbl_Salida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 85, 22), 1, true));
        Pnl_EntradaSalida.add(Lbl_Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 460, 275));

        Lbl_TituloSalida.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        Lbl_TituloSalida.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_TituloSalida.setText("Salida");
        Pnl_EntradaSalida.add(Lbl_TituloSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        Scp_Entrada.setBorder(null);

        Txa_Entrada.setBackground(new java.awt.Color(34, 34, 34));
        Txa_Entrada.setColumns(20);
        Txa_Entrada.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        Txa_Entrada.setForeground(new java.awt.Color(255, 255, 255));
        Txa_Entrada.setLineWrap(true);
        Txa_Entrada.setRows(5);
        Txa_Entrada.setWrapStyleWord(true);
        Txa_Entrada.setBorder(null);
        Txa_Entrada.setCaretColor(new java.awt.Color(255, 255, 255));
        Txa_Entrada.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Txa_Entrada.setSelectionColor(new java.awt.Color(56, 58, 56));
        Scp_Entrada.setViewportView(Txa_Entrada);

        Pnl_EntradaSalida.add(Scp_Entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 440, 255));

        Lbl_Entrada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 85, 22), 1, true));
        Pnl_EntradaSalida.add(Lbl_Entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 460, 275));

        Lbl_TituloEntrada.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        Lbl_TituloEntrada.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_TituloEntrada.setText("Entrada");
        Pnl_EntradaSalida.add(Lbl_TituloEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        Pnl_Principal.add(Pnl_EntradaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 65, 500, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_PlantillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PlantillaActionPerformed
        addTemplate();
    }//GEN-LAST:event_Btn_PlantillaActionPerformed

    private void Btn_EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EjecutarActionPerformed
        if (!aux) {
            save();
            aux = true;
        } else {
            saveExecution();
        }
        input();
        try {
            String code = textArea.getText(); // Codigo Modificado
            String codeModificado = ReemplazarCodigo.reemplazar(code, "ioeditor", "ioeditor", "");

            try {
                out = new FileOutputStream("C:\\Apolo\\src\\IOEditor\\Main.java");
                byte[] bytxt = codeModificado.getBytes();
                out.write(bytxt);
                out.close();
            } catch (IOException e) {
                ErrorWindow ew = new ErrorWindow(this, true, "Archivo al guardar", "/Resources/Ventanas/Error.png");
                ew.setVisible(true);
            }

            // Ruta donde se guarda el archivo
            String ruta = "C:\\Apolo\\src\\IOEditor\\Main.java";

            int result = compile(ruta);  // Compila el archivo

            // Confirmar compilacion exitosa
            if (result != 0) {
                ce.setVisible(true);
            }

            result = execute("ioeditor.Main"); // Ejecuta el archivo
            // Confirmar ejecucion exitosa
            if (result != 0) {
                rt.setVisible(true);
            }

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(CodeEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_EjecutarActionPerformed

    private void Btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarActionPerformed
        save();
    }//GEN-LAST:event_Btn_GuardarActionPerformed

    private void Btn_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AbrirActionPerformed
        aux = true;
        if (seleccion.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo_abrir = seleccion.getSelectedFile();
            if (archivo_abrir.canRead()) {
                if (archivo_abrir.getName().endsWith("java")) {
                    String documento = null;
                    try {
                        documento = openFile(archivo_abrir);
                        entrada.close();
                    } catch (IOException ex) {
                        Logger.getLogger(CodeEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    textArea.setText(documento);
                } else {
                    ErrorWindow ew = new ErrorWindow(this, true, "Archivo no compatible", "/Resources/Ventanas/Error.png");
                    ew.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_Btn_AbrirActionPerformed

    private void Btn_CopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CopiarActionPerformed
        setClipboard(textArea.getText());
    }//GEN-LAST:event_Btn_CopiarActionPerformed

    private void Btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LimpiarActionPerformed
        textArea.setText("");
    }//GEN-LAST:event_Btn_LimpiarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(CodeEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
            new CodeEditor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Abrir;
    private javax.swing.JButton Btn_Copiar;
    private javax.swing.JButton Btn_Ejecutar;
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JButton Btn_Limpiar;
    private javax.swing.JButton Btn_Plantilla;
    private javax.swing.JLabel Lbl_Codigo;
    private javax.swing.JLabel Lbl_Entrada;
    private javax.swing.JLabel Lbl_Icono;
    private javax.swing.JLabel Lbl_Salida;
    private javax.swing.JLabel Lbl_TituloEntrada;
    private javax.swing.JLabel Lbl_TituloSalida;
    private javax.swing.JPanel Pnl_Botones;
    private javax.swing.JPanel Pnl_Codigo;
    private javax.swing.JPanel Pnl_EntradaSalida;
    private javax.swing.JPanel Pnl_Principal;
    private javax.swing.JScrollPane Scp_Entrada;
    private javax.swing.JScrollPane Scp_Salida;
    private javax.swing.JTextArea Txa_Entrada;
    private javax.swing.JTextArea Txa_Salida;
    // End of variables declaration//GEN-END:variables

    @Override
    public void lostOwnership(Clipboard clpbrd, Transferable t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
