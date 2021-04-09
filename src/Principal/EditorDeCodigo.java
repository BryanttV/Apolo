package Principal;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static Judge.CompileAndRun.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.Ostermiller.Syntax.HighlightedDocument;
import java.awt.BorderLayout;
import java.awt.Color;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.autocomplete.ShorthandCompletion;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

public class EditorDeCodigo extends javax.swing.JFrame implements ClipboardOwner {

    JFileChooser seleccion = new JFileChooser();
    RSyntaxTextArea textArea = new RSyntaxTextArea();
    File archivo_abrir, codigo_modificado;
    FileInputStream entrada, in;
    FileOutputStream salida, out;

    public EditorDeCodigo() {
        initComponents();
        editor();
        plantilla();
    }

    private void editor() {
        RTextScrollPane sp = new RTextScrollPane(textArea);
        sp.getViewport();
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setBackground(new Color(237, 234, 243));
        textArea.setAntiAliasingEnabled(true);
        textArea.setCodeFoldingEnabled(true);
        Pnl_Codigo.add(sp);
        CompletionProvider provider = createCompletionProvider();
        AutoCompletion ac = new AutoCompletion(provider);
        ac.install(textArea);
        setTitle("Editor de Código");
    }

    private CompletionProvider createCompletionProvider() {

        DefaultCompletionProvider provider = new DefaultCompletionProvider();

        provider.addCompletion(new BasicCompletion(provider, "abstract"));
        provider.addCompletion(new BasicCompletion(provider, "assert"));
        provider.addCompletion(new BasicCompletion(provider, "break"));
        provider.addCompletion(new BasicCompletion(provider, "case"));
        provider.addCompletion(new BasicCompletion(provider, "transient"));
        provider.addCompletion(new BasicCompletion(provider, "try"));
        provider.addCompletion(new BasicCompletion(provider, "void"));
        provider.addCompletion(new BasicCompletion(provider, "volatile"));
        provider.addCompletion(new BasicCompletion(provider, "while"));

        provider.addCompletion(new ShorthandCompletion(provider, "sout",
                "System.out.println(", "System.out.println("));
        provider.addCompletion(new ShorthandCompletion(provider, "serr",
                "System.err.println(", "System.err.println("));

        return provider;
    }

    private void plantilla() {
        textArea.setText("public class Main {\n"
                + "    public static void main(String[] args) {\n"
                + "	System.out.println(\"Hello World\");\n"
                + "    } \n"
                + "}");
    }

    public String openFile(File archivo) {

        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while ((ascci = entrada.read()) != -1) {
                char caracter = (char) ascci;
                documento += caracter;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir" + e);
        }
        return documento;
    }

    public String saveFile(File archivo, String documento) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "Codigo Guardado exitosamente";
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar" + e);
        }
        return mensaje;
    }

    public void clipBoard(String texto) {
        StringSelection txt = new StringSelection(texto);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(txt, this);
    }

    private void guardar() {
        if (seleccion.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo_abrir = seleccion.getSelectedFile();
            if (archivo_abrir.getName().endsWith(".java")) {
                String documento = textArea.getText();
                String mensaje = saveFile(archivo_abrir, documento);
                if (mensaje != null) {
                    JOptionPane.showMessageDialog(null, mensaje);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no compatible.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Guardar Codigo Java");
            }
        }
    }

    public int compilar(String ruta) throws IOException, InterruptedException {
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

    public int ejecutar(String clase, String ruta) throws IOException, InterruptedException {

        List<String> cmds = new ArrayList<>();
        cmds.add("java");
        cmds.add(clase);

        ProcessBuilder pb = new ProcessBuilder(cmds);
        pb.redirectError();
        pb.redirectInput(new File(System.getProperty("user.dir") + "\\src\\Editor", "output.txt"));

        pb.directory(new File("src"));

        Process p = pb.start();
        InputStreamConsumer consumer = new InputStreamConsumer(p.getInputStream());
        consumer.start();
        int result = p.waitFor();
        consumer.join();

        String writteable = consumer.getOutput().toString();

        Txa_Salida.setText(writteable);

        try (FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\src\\Editor\\output.txt")) {
            fw.write(writteable);
        }

        return result;
    }

    private void entrada() {
        String documento = Txa_Entrada.getText();
        try {
            out = new FileOutputStream(System.getProperty("user.dir") + "\\src\\Editor\\input.txt");
            byte[] bytxt = documento.getBytes();
            out.write(bytxt);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Principal = new javax.swing.JPanel();
        Pnl_Botones = new javax.swing.JPanel();
        Btn_Limpiar = new javax.swing.JButton();
        Btn_Copiar = new javax.swing.JButton();
        Btn_Abrir = new javax.swing.JButton();
        Btn_Guardar = new javax.swing.JButton();
        Btn_Plantilla = new javax.swing.JButton();
        Btn_Ejecutar = new javax.swing.JButton();
        Pnl_Codigo = new javax.swing.JPanel();
        Pnl_EntradaSalida = new javax.swing.JPanel();
        Scp_Salida = new javax.swing.JScrollPane();
        Txa_Salida = new javax.swing.JTextArea();
        Lbl_Salida = new javax.swing.JLabel();
        Scp_Entrada = new javax.swing.JScrollPane();
        Txa_Entrada = new javax.swing.JTextArea();
        Lbl_Entrada = new javax.swing.JLabel();
        Lbl_TituloEntrada = new javax.swing.JLabel();
        Lbl_TituloSalida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(856, 700));
        setResizable(false);

        Pnl_Principal.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Principal.setMaximumSize(new java.awt.Dimension(850, 705));
        Pnl_Principal.setMinimumSize(new java.awt.Dimension(850, 705));
        Pnl_Principal.setPreferredSize(new java.awt.Dimension(850, 705));
        Pnl_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Botones.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Botones.setMaximumSize(new java.awt.Dimension(850, 60));
        Pnl_Botones.setMinimumSize(new java.awt.Dimension(850, 60));
        Pnl_Botones.setPreferredSize(new java.awt.Dimension(850, 60));
        Pnl_Botones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Limpiar_Off.png"))); // NOI18N
        Btn_Limpiar.setMnemonic('d');
        Btn_Limpiar.setBorder(null);
        Btn_Limpiar.setBorderPainted(false);
        Btn_Limpiar.setContentAreaFilled(false);
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
        Pnl_Botones.add(Btn_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 132, 40));

        Btn_Copiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Copiar_Off.png"))); // NOI18N
        Btn_Copiar.setMnemonic('c');
        Btn_Copiar.setBorderPainted(false);
        Btn_Copiar.setContentAreaFilled(false);
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
        Pnl_Botones.add(Btn_Copiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 132, 40));

        Btn_Abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Abrir_Off.png"))); // NOI18N
        Btn_Abrir.setMnemonic('o');
        Btn_Abrir.setBorderPainted(false);
        Btn_Abrir.setContentAreaFilled(false);
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
        Pnl_Botones.add(Btn_Abrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 132, 40));

        Btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Guardar_Off.png"))); // NOI18N
        Btn_Guardar.setMnemonic('s');
        Btn_Guardar.setBorderPainted(false);
        Btn_Guardar.setContentAreaFilled(false);
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
        Pnl_Botones.add(Btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 132, 40));

        Btn_Plantilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Plantilla_Off.png"))); // NOI18N
        Btn_Plantilla.setMnemonic('p');
        Btn_Plantilla.setBorder(null);
        Btn_Plantilla.setBorderPainted(false);
        Btn_Plantilla.setContentAreaFilled(false);
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
        Pnl_Botones.add(Btn_Plantilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 132, 40));

        Btn_Ejecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Programar/Ejecutar_Off.png"))); // NOI18N
        Btn_Ejecutar.setMnemonic('n');
        Btn_Ejecutar.setBorderPainted(false);
        Btn_Ejecutar.setContentAreaFilled(false);
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
        Pnl_Botones.add(Btn_Ejecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 132, 40));

        Pnl_Principal.add(Pnl_Botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 60));

        Pnl_Codigo.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Codigo.setMaximumSize(new java.awt.Dimension(850, 430));
        Pnl_Codigo.setMinimumSize(new java.awt.Dimension(850, 430));
        Pnl_Codigo.setLayout(new java.awt.CardLayout());
        Pnl_Principal.add(Pnl_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 930, 370));

        Pnl_EntradaSalida.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_EntradaSalida.setMaximumSize(new java.awt.Dimension(850, 215));
        Pnl_EntradaSalida.setMinimumSize(new java.awt.Dimension(850, 215));
        Pnl_EntradaSalida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Scp_Salida.setBorder(null);
        Scp_Salida.getVerticalScrollBar().setUI(new CustomScrollBarUI());

        Txa_Salida.setEditable(false);
        Txa_Salida.setBackground(new java.awt.Color(237, 234, 243));
        Txa_Salida.setColumns(20);
        Txa_Salida.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        Txa_Salida.setLineWrap(true);
        Txa_Salida.setRows(5);
        Txa_Salida.setWrapStyleWord(true);
        Scp_Salida.setViewportView(Txa_Salida);

        Pnl_EntradaSalida.add(Scp_Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 430, 195));

        Lbl_Salida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        Pnl_EntradaSalida.add(Lbl_Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 450, 215));

        Scp_Entrada.setBorder(null);
        Scp_Entrada.getVerticalScrollBar().setUI(new CustomScrollBarUI());

        Txa_Entrada.setBackground(new java.awt.Color(237, 234, 243));
        Txa_Entrada.setColumns(20);
        Txa_Entrada.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        Txa_Entrada.setLineWrap(true);
        Txa_Entrada.setRows(5);
        Txa_Entrada.setWrapStyleWord(true);
        Scp_Entrada.setViewportView(Txa_Entrada);

        Pnl_EntradaSalida.add(Scp_Entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 470, 195));

        Lbl_Entrada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        Pnl_EntradaSalida.add(Lbl_Entrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 490, 215));

        Lbl_TituloEntrada.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        Lbl_TituloEntrada.setText("Entrada");
        Pnl_EntradaSalida.add(Lbl_TituloEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Lbl_TituloSalida.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        Lbl_TituloSalida.setText("Salida");
        Pnl_EntradaSalida.add(Lbl_TituloSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        Pnl_Principal.add(Pnl_EntradaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 435, 970, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarActionPerformed
        guardar();
    }//GEN-LAST:event_Btn_GuardarActionPerformed

    private void Btn_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AbrirActionPerformed
        if (seleccion.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo_abrir = seleccion.getSelectedFile();
            if (archivo_abrir.canRead()) {
                if (archivo_abrir.getName().endsWith("java")) {
                    String documento = openFile(archivo_abrir);
                    textArea.setText(documento);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no compatible.");
                }
            }
        }
    }//GEN-LAST:event_Btn_AbrirActionPerformed

    private void Btn_EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EjecutarActionPerformed
        guardar();
        entrada();
        try {

            String code = textArea.getText(); // Codigo Modificado
            String codeModificado = ReemplazarCodigo.reemplazar(code, 1);

            try {
                out = new FileOutputStream(System.getProperty("user.dir") + "\\src\\Editor\\Main.java");
                byte[] bytxt = codeModificado.getBytes();
                out.write(bytxt);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar" + e);
            }

            String ruta = System.getProperty("user.dir") + "\\src\\Editor\\Main.java";  // Ruta donde se guarda el archivo

            int result = compilar(ruta);  // Compila el archivo
            // Confirmar compilacion exitosa
            if (result != 0) {
                JOptionPane.showMessageDialog(null, "Compilation Error");
                System.out.println("Numero: " + result);
            }

            result = ejecutar("editor.Main", ruta); // Ejecuta el archivo
            // Confirmar ejecucion exitosa
            if (result != 0) {
                System.out.println("Numero: " + result);
                JOptionPane.showMessageDialog(null, "Runtime Error");
            }

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(EditorDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_EjecutarActionPerformed

    private void Btn_CopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CopiarActionPerformed
        clipBoard(textArea.getText());
    }//GEN-LAST:event_Btn_CopiarActionPerformed

    private void Btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LimpiarActionPerformed
        textArea.setText("");
    }//GEN-LAST:event_Btn_LimpiarActionPerformed

    private void Btn_PlantillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PlantillaActionPerformed
        plantilla();
    }//GEN-LAST:event_Btn_PlantillaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new EditorDeCodigo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Abrir;
    private javax.swing.JButton Btn_Copiar;
    private javax.swing.JButton Btn_Ejecutar;
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JButton Btn_Limpiar;
    private javax.swing.JButton Btn_Plantilla;
    private javax.swing.JLabel Lbl_Entrada;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
