package Principal;

// Librerias externas y paquetes
import Tipografias.Fuentes;

// Librerias por Default
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Component;
import java.awt.Font;
import java.awt.Container;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;

public class HomeApolo extends javax.swing.JFrame {

    static public VentanaAjustes Ajustes = new VentanaAjustes();
    static public ConfirmarSalida Confirmar = new ConfirmarSalida();
    static public Tips tp;
    private final Color verde = new Color(0, 37, 26); // Color principal de la Seccion de Aprender
    private final Color azul = new Color(0, 47, 108); // Color principal de la Seccion de Historia
    private final Color drag = new Color(32, 30, 33); // Color Drag del ScrollBar
    private final Color thumb_on = new Color(32, 30, 33); // Color del Thumb_on del ScrollBar
    private final Color thumb_off = new Color(50, 50, 50); // Color del Thumb_off del ScrollBar
    private final RSyntaxTextArea syntaxCode = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxSolution = new RSyntaxTextArea();

    // Crear Tipo de Fuente
    Fuentes Euclid = new Fuentes();
    Font Regular14p = Euclid.fuente(Euclid.EUCR, 0, 14);
    Font Regular20p = Euclid.fuente(Euclid.EUCR, 0, 20);
    Font Bold30p = Euclid.fuente(Euclid.EUCB, 0, 30);
    Font SegoeRegular = new Font("Segoe UI Emoji", Font.PLAIN, 20);
    Font SegoeBold = new Font("Segoe UI SemiBold", Font.BOLD, 26);
    private int contador = 0;
    private int aux = 1;

    // Constructor
    public HomeApolo() {
        initComponents();
        cargarFuente();
        configurarVentana();
        configurarBarraDesplazamiento();
        ocultarComponentes();
        confirmarCierre();
        resaltarCodigo();
    }

    // Agregar RSyntaxTextArea a Codigo y Solucion
    private void agregarRSyntax(JPanel p, RSyntaxTextArea rta, RTextScrollPane tsp) {
        rta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        tsp = new RTextScrollPane(rta);

        // Agregar tema personalizado
        changeStyleViaThemeXml(rta);

        // Personalizar ScrollBar Horizontal y Vertical
        int horizontalPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        int verticalPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
        tsp.setHorizontalScrollBarPolicy(horizontalPolicy);
        tsp.setVerticalScrollBarPolicy(verticalPolicy);
        tsp.getHorizontalScrollBar().setUI(new CustomScrollBarUI(drag, thumb_on, thumb_off));
        tsp.getVerticalScrollBar().setUI(new CustomScrollBarUI(drag, thumb_on, thumb_off));
        tsp.setBorder(null);

        // Personalizar Area de Texto
        rta.setText("// Pega aquí tu código...");
        rta.setBackground(new Color(237, 234, 243));
        rta.setAntiAliasingEnabled(true);
        rta.setFont(new Font("Consolas", Font.PLAIN, 14));
        rta.revalidate();

        // Agregar Area de Texto al Panel
        p.add(tsp);
    }

    private void resaltarCodigo() {
        // Creacion de Resaltado de Sintaxis para Codigo y Solucion en CodeStorm
        RTextScrollPane tspCode = new RTextScrollPane();
        RTextScrollPane tspSolution = new RTextScrollPane();
        agregarRSyntax(Pnl_SyntaxCode, syntaxCode, tspCode);
        agregarRSyntax(Pnl_SyntaxSolution, syntaxSolution, tspSolution);
        syntaxSolution.setEditable(false);
    }

    // Cargar tema preestablecido
    private void changeStyleViaThemeXml(RSyntaxTextArea rta) {
        try {
            String tema_xml = "/org/fife/ui/rsyntaxtextarea/themes/eclipse.xml";
            Theme theme = Theme.load(getClass().getResourceAsStream(tema_xml));
            theme.apply(rta);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    // Cargar fuente personalizada del paquete Tipografias
    private void cargarFuente() {

        // Lista de Componentes de la Seccion de Aprender
        List<Component> aprenderList = getAllComponents(Pnl_Aprender);
        for (Component componente : aprenderList) {
            if (componente instanceof JLabel) {
                JLabel lbl = (JLabel) componente;
                lbl.setFont(Bold30p);
                lbl.setForeground(verde);
            }
        }

        // Lista de Componentes de la Seccion de Historia 
        List<Component> historiaList = getAllComponents(Pnl_Historia);
        for (Component componente : historiaList) {
            if (componente instanceof JLabel) {
                componente.setFont(SegoeBold);
                componente.setForeground(azul);
            }
            if (componente instanceof JTextArea) {
                componente.setFont(SegoeRegular);
                componente.setForeground(Color.BLACK);
            }
        }
    }

    // Personalizar la Barra de Desplazamiento de todos los ScrollPane
    private void configurarBarraDesplazamiento() {
        List<Component> compList = getAllComponents(this);
        for (Component componente : compList) {
            if (componente instanceof JScrollPane) {
                JScrollPane scp = (JScrollPane) componente;
                // Agregar Barra de Desplazamiento Personalizada a los ScrollPane
                scp.getVerticalScrollBar().setUI(new CustomScrollBarUI(drag, thumb_on, thumb_off));
                // Quitar borde por defecto
                scp.setBorder(null);
            }
        }
    }

    // Obtener todos los componentes del JFrame ¨**IMPORTANTE**
    private List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container) {
                compList.addAll(getAllComponents((Container) comp));
            }
        }
        return compList;
    }

    // Configurar las Caracteristicas de la Ventana Principal
    private void configurarVentana() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar Ventana
        this.getContentPane().setBackground(Color.red); // Color de Fondo del JFrame
        setIconImage(new ImageIcon(getClass().getResource(
                "/Resources/Apolo_Icono_Blanco_40px.png")).getImage()); // Agregar icono de Apolo
    }

    // Confirmar el cierre de la Aplicacion
    private void confirmarCierre() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Confirmar.setVisible(true);
                }
            });
        } catch (Exception e) {
            System.out.println("Error al salir " + e);
        }
    }

    // Deseleccionar Botones y Componentes de Secciones Principales
    private void apagarSecciones(int boton) {
        switch (boton) {
            case 1:
                Btn_Programar.setSelected(false);
                Btn_CodeStorm.setSelected(false);
                Btn_Historia.setSelected(false);
                for (Component cmp : Pnl_Principal.getComponents()) {
                    cmp.setVisible(false);
                }
                break;
            case 2:
                Btn_Aprender.setSelected(false);
                Btn_CodeStorm.setSelected(false);
                Btn_Historia.setSelected(false);
//                for (Component cmp : Pnl_Principal.getComponents()) {
//                    cmp.setVisible(false);
//                }
                break;
            case 3:
                Btn_Aprender.setSelected(false);
                Btn_Programar.setSelected(false);
                Btn_Historia.setSelected(false);
                break;
            case 4:
                Btn_Aprender.setSelected(false);
                Btn_Programar.setSelected(false);
                Btn_CodeStorm.setSelected(false);
                break;
            default:
                break;
        }
    }

    // Deshabilitar botones de los Ejercicios según Eleccion
    private void DeshabilitarBotonesCodeStorm(int opcion) {
        switch (opcion) {
            case 0:
                Btn_Codigo.setSelected(false);
                Btn_Solucion.setSelected(false);
                break;
            case 1:
                Btn_Ejercicio.setSelected(false);
                Btn_Solucion.setSelected(false);
                break;
            case 2:
                Btn_Ejercicio.setSelected(false);
                Btn_Codigo.setSelected(false);
                break;
            default:
                break;
        }
    }

    // Habilitar botones de la Seccion de Aprender
    private void habilitarBotonesAprender() {
        for (Component component : Pnl_Aprender.getComponents()) {
            component.setVisible(true);
        }
    }

    // Habilitar botones de la Seccion de CodeStorm
    private void habilitarBotonesCodeStorm() {
        for (Component component : Pnl_CodeStorm.getComponents()) {
            if (component instanceof JButton || component instanceof JToggleButton) {
                component.setVisible(true);
            }
        }
    }

    // Habilitar botones de la Seccion de Historia
    private void habilitarBotonesHistoria() {
        for (Component component : Pnl_Historia.getComponents()) {
            component.setVisible(true);
        }
    }

    // Ocultar Componentes de todas las Secciones
    private void ocultarComponentes() {
        for (Component component : Pnl_Aprender.getComponents()) {
            component.setVisible(false);
        }
        for (Component component : Pnl_CodeStorm.getComponents()) {
            component.setVisible(false);
        }

        for (Component component : Pnl_Historia.getComponents()) {
            component.setVisible(false);
        }
    }

    // Inicializar botones según navegacion en seccion de CodeStorm
    private void inicializarBotonesCodeStorm() {
        Btn_Ejercicio.doClick();
        Btn_Ejercicio.setSelected(true);
        Btn_Codigo.setSelected(false);
        Btn_Solucion.setSelected(false);
    }

    // Habilitar o Deshabilitar botones de Siguiente y Anterior en CodeStorm
    private void contador() {
        if (contador == 0) {
            Btn_Anterior.setEnabled(false);
        } else {
            Btn_Anterior.setEnabled(true);
        }
        if (contador == 19) {
            Btn_Siguiente.setEnabled(false);
        } else {
            Btn_Siguiente.setEnabled(true);
        }
    }

    // Deshabilitar paneles comunes de la seccion de CodeStorm
    private void paneles_ON_OFF() {
        Pnl_General.setVisible(true);
        Pnl_Main.setVisible(true);
        Pnl_ListadoEjercicios.setVisible(false);
        inicializarBotonesCodeStorm();
        contador();
    }

    // Asignar titulo a los paneles en CodeStorm
    private void asignarTitulo(JPanel p) {
        p.setBorder(new TitledBorder(
                new LineBorder(new Color(204, 0, 0), 2, true),
                " Nivel " + (int) Math.ceil(((double) contador + 1) / 4) + " | Ejercicio " + (aux) + " ",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Tahoma", 1, 30),
                new Color(204, 0, 0)));
    }

    // Validar que ejercicio se encuentra activo en el momento
    private void validarEjercicioActivo() {
        if (aux > 4) {
            aux = 1;
        } else if (aux == 0) {
            aux = 4;
        }
        asignarTitulo(Pnl_EjercicioFull);
        asignarTitulo(Pnl_CodigoFull);
        asignarTitulo(Pnl_SolucionFull);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Bar_Buttons = new javax.swing.JPanel();
        Btn_Aprender = new javax.swing.JToggleButton();
        Btn_CodeStorm = new javax.swing.JToggleButton();
        Btn_Programar = new javax.swing.JToggleButton();
        Btn_Ajustes = new javax.swing.JToggleButton();
        Btn_Historia = new javax.swing.JToggleButton();
        Lbl_HomeButttons = new javax.swing.JLabel();
        Pnl_Principal = new javax.swing.JPanel();
        Pnl_Home = new javax.swing.JPanel();
        Lbl_Home_Fondo = new javax.swing.JLabel();
        Pnl_Aprender = new javax.swing.JPanel();
        Pnl_Mapa = new javax.swing.JPanel();
        Btn_Aprender_Tema1 = new javax.swing.JButton();
        Btn_Aprender_Tema2 = new javax.swing.JButton();
        Btn_Aprender_Tema3 = new javax.swing.JButton();
        Btn_Aprender_Tema4 = new javax.swing.JButton();
        Btn_Aprender_Tema5 = new javax.swing.JButton();
        Btn_Aprender_Tema6 = new javax.swing.JButton();
        Btn_Aprender_Tema7 = new javax.swing.JButton();
        Btn_Aprender_Tema8 = new javax.swing.JButton();
        Btn_Aprender_Tema9 = new javax.swing.JButton();
        Btn_Aprender_Tema10 = new javax.swing.JButton();
        Btn_Aprender_Tema11 = new javax.swing.JButton();
        Btn_Aprender_Tema12 = new javax.swing.JButton();
        Btn_Aprender_Tema13 = new javax.swing.JButton();
        Btn_Aprender_Tema14 = new javax.swing.JButton();
        Btn_Aprender_Ejercicio1 = new javax.swing.JButton();
        Btn_Aprender_Ejercicio2 = new javax.swing.JButton();
        Btn_Aprender_EjercicioFinal = new javax.swing.JButton();
        Lbl_Aprender_Mapa = new javax.swing.JLabel();
        Scp_Tema1 = new javax.swing.JScrollPane();
        Pnl_Tema1 = new javax.swing.JPanel();
        Btn_Siguiente_Cuestionario1 = new javax.swing.JButton();
        Lbl_Header_Aprender = new javax.swing.JLabel();
        Lbl_HelloWorld = new javax.swing.JLabel();
        Btn_Atras = new javax.swing.JButton();
        Scp_Cuestionario1 = new javax.swing.JScrollPane();
        Pnl_Cuestionario1 = new javax.swing.JPanel();
        Btn_Anterior_HelloWord = new javax.swing.JButton();
        Btn_Siguiente_Comentarios = new javax.swing.JButton();
        Lbl_Header_Aprender1 = new javax.swing.JLabel();
        Lbl_Cuestionario1 = new javax.swing.JLabel();
        Scp_Tema2 = new javax.swing.JScrollPane();
        Pnl_Tema2 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario1 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario2 = new javax.swing.JButton();
        Lbl_Header_Aprender2 = new javax.swing.JLabel();
        Lbl_Comentarios = new javax.swing.JLabel();
        Scp_Cuestionario2 = new javax.swing.JScrollPane();
        Pnl_Cuestionario2 = new javax.swing.JPanel();
        Btn_Anterior_Comentarios = new javax.swing.JButton();
        Btn_Siguiente_TiposdeDatos = new javax.swing.JButton();
        Lbl_Header_Aprender3 = new javax.swing.JLabel();
        Lbl_Cuestionario2 = new javax.swing.JLabel();
        Scp_Tema3 = new javax.swing.JScrollPane();
        Pnl_Tema3 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario2 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario3 = new javax.swing.JButton();
        Lbl_Header_Aprender4 = new javax.swing.JLabel();
        Lbl_TiposdeDatos = new javax.swing.JLabel();
        Scp_Cuestionario3 = new javax.swing.JScrollPane();
        Pnl_Cuestionario3 = new javax.swing.JPanel();
        Btn_Anterior_TiposdeDatos = new javax.swing.JButton();
        Btn_Siguiente_OperadoresAritmeticos = new javax.swing.JButton();
        Lbl_Header_Aprender5 = new javax.swing.JLabel();
        Lbl_Cuestionario3 = new javax.swing.JLabel();
        Scp_Tema4 = new javax.swing.JScrollPane();
        Pnl_Tema4 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario3 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario4 = new javax.swing.JButton();
        Lbl_Header_Aprender6 = new javax.swing.JLabel();
        Lbl_OperadoresAritmeticos = new javax.swing.JLabel();
        Scp_Cuestionario4 = new javax.swing.JScrollPane();
        Pnl_Cuestionario4 = new javax.swing.JPanel();
        Btn_Anterior_OperadoresAritmeticos = new javax.swing.JButton();
        Btn_Siguiente_LecturaeImpresion = new javax.swing.JButton();
        Lbl_Header_Aprender7 = new javax.swing.JLabel();
        Lbl_Cuestionario4 = new javax.swing.JLabel();
        Scp_Tema5 = new javax.swing.JScrollPane();
        Pnl_Tema5 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario4 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario5 = new javax.swing.JButton();
        Lbl_Header_Aprender8 = new javax.swing.JLabel();
        Lbl_LecturaeImpresion = new javax.swing.JLabel();
        Scp_Cuestionario5 = new javax.swing.JScrollPane();
        Pnl_Cuestionario5 = new javax.swing.JPanel();
        Btn_Anterior_LecturaeImpresion = new javax.swing.JButton();
        Btn_Siguiente_Ejercicio1 = new javax.swing.JButton();
        Lbl_Header_Aprender10 = new javax.swing.JLabel();
        Lbl_Cuestionario5 = new javax.swing.JLabel();
        Scp_Ejercicio1 = new javax.swing.JScrollPane();
        Pnl_Ejercicio1_Aprender = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario5 = new javax.swing.JButton();
        Btn_Siguiente_OperadoresdeRelacion = new javax.swing.JButton();
        Lbl_Header_Aprender33 = new javax.swing.JLabel();
        Lbl_Ejercicio1_Principiante = new javax.swing.JLabel();
        Scp_Tema6 = new javax.swing.JScrollPane();
        Pnl_Tema6 = new javax.swing.JPanel();
        Btn_Anterior_Ejercicio1_Principiante = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario6 = new javax.swing.JButton();
        Lbl_Header_Aprender15 = new javax.swing.JLabel();
        Lbl_OperadoresdeRelacion = new javax.swing.JLabel();
        Scp_Cuestionario6 = new javax.swing.JScrollPane();
        Pnl_Cuestionario6 = new javax.swing.JPanel();
        Btn_Anterior_OperadoresdeRelacion = new javax.swing.JButton();
        Btn_Siguiente_OperadoresLogicos = new javax.swing.JButton();
        Lbl_Header_Aprender16 = new javax.swing.JLabel();
        Lbl_Cuestionario6 = new javax.swing.JLabel();
        Scp_Tema7 = new javax.swing.JScrollPane();
        Pnl_Tema7 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario6 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario7 = new javax.swing.JButton();
        Lbl_Header_Aprender17 = new javax.swing.JLabel();
        Lbl_OperadoresLogicos = new javax.swing.JLabel();
        Scp_Cuestionario7 = new javax.swing.JScrollPane();
        Pnl_Cuestionario7 = new javax.swing.JPanel();
        Btn_Anterior_OperadoresLogicos = new javax.swing.JButton();
        Btn_Siguiente_Condicionales = new javax.swing.JButton();
        Lbl_Header_Aprender18 = new javax.swing.JLabel();
        Lbl_Cuestionario7 = new javax.swing.JLabel();
        Scp_Tema8 = new javax.swing.JScrollPane();
        Pnl_Tema8 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario7 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario8 = new javax.swing.JButton();
        Lbl_Header_Aprender19 = new javax.swing.JLabel();
        Lbl_Condicionales = new javax.swing.JLabel();
        Scp_Cuestionario8 = new javax.swing.JScrollPane();
        Pnl_Cuestionario8 = new javax.swing.JPanel();
        Btn_Anterior_Condicionales = new javax.swing.JButton();
        Btn_Siguiente_Bucles = new javax.swing.JButton();
        Lbl_Header_Aprender20 = new javax.swing.JLabel();
        Lbl_Cuestionario8 = new javax.swing.JLabel();
        Scp_Tema9 = new javax.swing.JScrollPane();
        Pnl_Tema9 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario8 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario9 = new javax.swing.JButton();
        Lbl_Header_Aprender21 = new javax.swing.JLabel();
        Lbl_Bucles = new javax.swing.JLabel();
        Scp_Cuestionario9 = new javax.swing.JScrollPane();
        Pnl_Cuestionario9 = new javax.swing.JPanel();
        Btn_Anterior_Bucles = new javax.swing.JButton();
        Btn_Siguiente_Ejercicio2_Intermedio = new javax.swing.JButton();
        Lbl_Header_Aprender22 = new javax.swing.JLabel();
        Lbl_Cuestionario9 = new javax.swing.JLabel();
        Scp_Ejercicio2 = new javax.swing.JScrollPane();
        Pnl_Ejercicio2_Aprender = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario9 = new javax.swing.JButton();
        Btn_Siguiente_FuncionesyProc = new javax.swing.JButton();
        Lbl_Header_Aprender34 = new javax.swing.JLabel();
        Lbl_Ejercicio2_Intermedio = new javax.swing.JLabel();
        Scp_Tema10 = new javax.swing.JScrollPane();
        Pnl_Tema10 = new javax.swing.JPanel();
        Btn_Anterior_Ejercicio2_Intermedio = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario10 = new javax.swing.JButton();
        Lbl_Header_Aprender23 = new javax.swing.JLabel();
        Lbl_FuncionesyProcs = new javax.swing.JLabel();
        Scp_Cuestionario10 = new javax.swing.JScrollPane();
        Pnl_Cuestionario10 = new javax.swing.JPanel();
        Btn_Anterior_FuncyProc = new javax.swing.JButton();
        Btn_Siguiente_Recursion = new javax.swing.JButton();
        Lbl_Header_Aprender24 = new javax.swing.JLabel();
        Lbl_Cuestionario10 = new javax.swing.JLabel();
        Scp_Tema11 = new javax.swing.JScrollPane();
        Pnl_Tema11 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario10 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario11 = new javax.swing.JButton();
        Lbl_Header_Aprender25 = new javax.swing.JLabel();
        Lbl_Recursion = new javax.swing.JLabel();
        Scp_Cuestionario11 = new javax.swing.JScrollPane();
        Pnl_Cuestionario11 = new javax.swing.JPanel();
        Btn_Anterior_Recursion = new javax.swing.JButton();
        Btn_Siguiente_EDDBasicas = new javax.swing.JButton();
        Lbl_Header_Aprender26 = new javax.swing.JLabel();
        Lbl_Cuestionario11 = new javax.swing.JLabel();
        Scp_Tema12 = new javax.swing.JScrollPane();
        Pnl_Tema12 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario11 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario12 = new javax.swing.JButton();
        Lbl_Header_Aprender27 = new javax.swing.JLabel();
        Lbl_EDDBasicas = new javax.swing.JLabel();
        Scp_Cuestionario12 = new javax.swing.JScrollPane();
        Pnl_Cuestionario12 = new javax.swing.JPanel();
        Btn_Anterior_EDDBasicas = new javax.swing.JButton();
        Btn_Siguiente_EDDAvanzadas = new javax.swing.JButton();
        Lbl_Header_Aprender28 = new javax.swing.JLabel();
        Lbl_Cuestionario12 = new javax.swing.JLabel();
        Scp_Tema13 = new javax.swing.JScrollPane();
        Pnl_Tema13 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario12 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario13 = new javax.swing.JButton();
        Lbl_Header_Aprender29 = new javax.swing.JLabel();
        Lbl_EDDAvanzadas = new javax.swing.JLabel();
        Scp_Cuestionario13 = new javax.swing.JScrollPane();
        Pnl_Cuestionario13 = new javax.swing.JPanel();
        Btn_Anterior_EDDAvanzadas = new javax.swing.JButton();
        Btn_Siguiente_PrimerosAlgoritmos = new javax.swing.JButton();
        Lbl_Header_Aprender30 = new javax.swing.JLabel();
        Lbl_Cuestionario13 = new javax.swing.JLabel();
        Scp_Tema14 = new javax.swing.JScrollPane();
        Pnl_Tema14 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario13 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario14 = new javax.swing.JButton();
        Lbl_Header_Aprender31 = new javax.swing.JLabel();
        Lbl_PrimerosAlgoritmos = new javax.swing.JLabel();
        Scp_Cuestionario14 = new javax.swing.JScrollPane();
        Pnl_Cuestionario14 = new javax.swing.JPanel();
        Btn_Anterior_PrimerosAlgoritmos = new javax.swing.JButton();
        Btn_Siguiente_EjercicioFinal = new javax.swing.JButton();
        Lbl_Header_Aprender32 = new javax.swing.JLabel();
        Lbl_Cuestionario14 = new javax.swing.JLabel();
        Scp_Ejercicio3 = new javax.swing.JScrollPane();
        Pnl_Ejercicio3_Aprender = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario14 = new javax.swing.JButton();
        Lbl_Header_Aprender35 = new javax.swing.JLabel();
        Lbl_EjercicioFinal = new javax.swing.JLabel();
        Pnl_CodeStorm = new javax.swing.JPanel();
        Pnl_ListadoEjercicios = new javax.swing.JPanel();
        Lbl_Header_CodeStorm = new javax.swing.JLabel();
        Btn_Introduccion = new javax.swing.JButton();
        Btn_Nivel1_Ejercicio1 = new javax.swing.JButton();
        Btn_Nivel1_Ejercicio2 = new javax.swing.JButton();
        Btn_Nivel1_Ejercicio3 = new javax.swing.JButton();
        Btn_Nivel1_Ejercicio4 = new javax.swing.JButton();
        Btn_Nivel2_Ejercicio1 = new javax.swing.JButton();
        Btn_Nivel2_Ejercicio2 = new javax.swing.JButton();
        Btn_Nivel2_Ejercicio3 = new javax.swing.JButton();
        Btn_Nivel2_Ejercicio4 = new javax.swing.JButton();
        Btn_Nivel3_Ejercicio1 = new javax.swing.JButton();
        Btn_Nivel3_Ejercicio2 = new javax.swing.JButton();
        Btn_Nivel3_Ejercicio3 = new javax.swing.JButton();
        Btn_Nivel3_Ejercicio4 = new javax.swing.JButton();
        Btn_Nivel4_Ejercicio1 = new javax.swing.JButton();
        Btn_Nivel4_Ejercicio2 = new javax.swing.JButton();
        Btn_Nivel4_Ejercicio3 = new javax.swing.JButton();
        Btn_Nivel4_Ejercicio4 = new javax.swing.JButton();
        Btn_Nivel5_Ejercicio1 = new javax.swing.JButton();
        Btn_Nivel5_Ejercicio2 = new javax.swing.JButton();
        Btn_Nivel5_Ejercicio3 = new javax.swing.JButton();
        Btn_Nivel5_Ejercicio4 = new javax.swing.JButton();
        Lbl_Nivel1 = new javax.swing.JLabel();
        Lbl_Nivel2 = new javax.swing.JLabel();
        Lbl_Nivel3 = new javax.swing.JLabel();
        Lbl_Nivel4 = new javax.swing.JLabel();
        Lbl_Nivel5 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel1_0 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel1_1 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel1_2 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel1_3 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel1_4 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel2_0 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel2_1 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel2_2 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel2_3 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel2_4 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel3_0 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel3_1 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel3_2 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel3_3 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel3_4 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel4_0 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel4_1 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel4_2 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel4_3 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel4_4 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel5_0 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel5_1 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel5_2 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel5_3 = new javax.swing.JLabel();
        Lbl_BarraProgreso_Nivel5_4 = new javax.swing.JLabel();
        Lbl_CodeStorm_Fondo = new javax.swing.JLabel();
        Scp_Introduccion = new javax.swing.JScrollPane();
        Pnl_Introduccion = new javax.swing.JPanel();
        Lbl_Header_CodeStorm1 = new javax.swing.JLabel();
        Btn_Introduccion_Siguiente = new javax.swing.JButton();
        Pnl_General = new javax.swing.JPanel();
        Pnl_Header = new javax.swing.JPanel();
        Lbl_Header_CodeStorm2 = new javax.swing.JLabel();
        Pnl_BotonesPrincipales = new javax.swing.JPanel();
        Btn_Ejercicio = new javax.swing.JToggleButton();
        Btn_Codigo = new javax.swing.JToggleButton();
        Btn_Enviar = new javax.swing.JToggleButton();
        Btn_Solucion = new javax.swing.JToggleButton();
        Btn_Atras_CodeStorm = new javax.swing.JButton();
        Pnl_Navegacion = new javax.swing.JPanel();
        Btn_Siguiente = new javax.swing.JButton();
        Btn_Anterior = new javax.swing.JButton();
        Pnl_Main = new javax.swing.JPanel();
        Pnl_EjercicioFull = new javax.swing.JPanel();
        Scp_EjerciciosFull = new javax.swing.JScrollPane();
        Lbl_Ejercicio1 = new javax.swing.JLabel();
        Pnl_CodigoFull = new javax.swing.JPanel();
        Pnl_SyntaxCode = new javax.swing.JPanel();
        Pnl_SolucionFull = new javax.swing.JPanel();
        Pnl_SyntaxSolution = new javax.swing.JPanel();
        Pnl_Historia = new javax.swing.JPanel();
        Pnl_Pagina1 = new javax.swing.JPanel();
        Lbl_Header_Aprender11 = new javax.swing.JLabel();
        Lbl_QueEs = new javax.swing.JLabel();
        Scp_QueEs = new javax.swing.JScrollPane();
        Txa_QueEs = new javax.swing.JTextArea();
        Lbl_Competencias = new javax.swing.JLabel();
        Scp_Competencias = new javax.swing.JScrollPane();
        Txa_Competencias = new javax.swing.JTextArea();
        Pnl_Pagina2 = new javax.swing.JPanel();
        Lbl_Header_Aprender12 = new javax.swing.JLabel();
        Pnl_Pagina3 = new javax.swing.JPanel();
        Lbl_Header_Aprender13 = new javax.swing.JLabel();
        Pnl_Pagina4 = new javax.swing.JPanel();
        Lbl_Header_Aprender14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1366, 705));
        setSize(new java.awt.Dimension(1366, 705));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Bar_Buttons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Aprender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Apolo_Aprender_Button_Off.png"))); // NOI18N
        Btn_Aprender.setToolTipText("");
        Btn_Aprender.setBorder(null);
        Btn_Aprender.setBorderPainted(false);
        Btn_Aprender.setContentAreaFilled(false);
        Btn_Aprender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Aprender.setFocusPainted(false);
        Btn_Aprender.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Apolo_Aprender_Button_On.png"))); // NOI18N
        Btn_Aprender.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Apolo_Aprender_Button_On.png"))); // NOI18N
        Btn_Aprender.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Apolo_Aprender_Button_Enabled.png"))); // NOI18N
        Btn_Aprender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AprenderActionPerformed(evt);
            }
        });
        Pnl_Bar_Buttons.add(Btn_Aprender, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 170, 55));

        Btn_CodeStorm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Apolo_CodeStormButton_Off.png"))); // NOI18N
        Btn_CodeStorm.setBorder(null);
        Btn_CodeStorm.setBorderPainted(false);
        Btn_CodeStorm.setContentAreaFilled(false);
        Btn_CodeStorm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_CodeStorm.setFocusPainted(false);
        Btn_CodeStorm.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Apolo_CodeStormButton_On.png"))); // NOI18N
        Btn_CodeStorm.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Apolo_CodeStormButton_On.png"))); // NOI18N
        Btn_CodeStorm.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Apolo_CodeStormButton_Enabled.png"))); // NOI18N
        Btn_CodeStorm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CodeStormActionPerformed(evt);
            }
        });
        Pnl_Bar_Buttons.add(Btn_CodeStorm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 170, 55));

        Btn_Programar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_ProgramaButton_Off.png"))); // NOI18N
        Btn_Programar.setBorder(null);
        Btn_Programar.setBorderPainted(false);
        Btn_Programar.setContentAreaFilled(false);
        Btn_Programar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Programar.setFocusPainted(false);
        Btn_Programar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_ProgramaButton_On.png"))); // NOI18N
        Btn_Programar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_ProgramaButton_On.png"))); // NOI18N
        Btn_Programar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_ProgramaButton_Enabled.png"))); // NOI18N
        Btn_Programar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ProgramarActionPerformed(evt);
            }
        });
        Pnl_Bar_Buttons.add(Btn_Programar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 170, 55));

        Btn_Ajustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_AjustesButton_Off.png"))); // NOI18N
        Btn_Ajustes.setBorderPainted(false);
        Btn_Ajustes.setContentAreaFilled(false);
        Btn_Ajustes.setFocusPainted(false);
        Btn_Ajustes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Ajustes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_AjustesButton_On.png"))); // NOI18N
        Btn_Ajustes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_AjustesButton_On.png"))); // NOI18N
        Btn_Ajustes.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_AjustesButton_Enabled.png"))); // NOI18N
        Btn_Ajustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AjustesActionPerformed(evt);
            }
        });
        Pnl_Bar_Buttons.add(Btn_Ajustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 170, 55));

        Btn_Historia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_HistoriaButton_Off.png"))); // NOI18N
        Btn_Historia.setBorder(null);
        Btn_Historia.setBorderPainted(false);
        Btn_Historia.setContentAreaFilled(false);
        Btn_Historia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Historia.setFocusPainted(false);
        Btn_Historia.setFocusable(false);
        Btn_Historia.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_HistoriaButton_On.png"))); // NOI18N
        Btn_Historia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_HistoriaButton_On.png"))); // NOI18N
        Btn_Historia.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_HistoriaButton_Enabled.png"))); // NOI18N
        Btn_Historia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_HistoriaActionPerformed(evt);
            }
        });
        Pnl_Bar_Buttons.add(Btn_Historia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 170, 55));

        Lbl_HomeButttons.setBackground(new java.awt.Color(0, 255, 0));
        Lbl_HomeButttons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_FondoButtons.png"))); // NOI18N
        Lbl_HomeButttons.setOpaque(true);
        Pnl_Bar_Buttons.add(Lbl_HomeButttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 705));

        getContentPane().add(Pnl_Bar_Buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 710));

        Pnl_Principal.setMinimumSize(new java.awt.Dimension(1366, 705));
        Pnl_Principal.setPreferredSize(new java.awt.Dimension(1366, 705));
        Pnl_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Home.setMaximumSize(new java.awt.Dimension(1176, 705));
        Pnl_Home.setMinimumSize(new java.awt.Dimension(1176, 705));
        Pnl_Home.setPreferredSize(new java.awt.Dimension(1176, 705));
        Pnl_Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Home_Fondo.setBackground(new java.awt.Color(0, 204, 0));
        Lbl_Home_Fondo.setForeground(new java.awt.Color(0, 204, 204));
        Lbl_Home_Fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Home_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Home_Fondo.png"))); // NOI18N
        Lbl_Home_Fondo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lbl_Home_Fondo.setMaximumSize(new java.awt.Dimension(1176, 705));
        Lbl_Home_Fondo.setMinimumSize(new java.awt.Dimension(1176, 705));
        Lbl_Home_Fondo.setOpaque(true);
        Lbl_Home_Fondo.setPreferredSize(new java.awt.Dimension(1176, 705));
        Pnl_Home.add(Lbl_Home_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Principal.add(Pnl_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1176, -1));

        Pnl_Aprender.setMaximumSize(new java.awt.Dimension(1176, 705));
        Pnl_Aprender.setMinimumSize(new java.awt.Dimension(1176, 705));
        Pnl_Aprender.setPreferredSize(new java.awt.Dimension(1176, 705));
        Pnl_Aprender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Mapa.setMaximumSize(new java.awt.Dimension(1176, 705));
        Pnl_Mapa.setMinimumSize(new java.awt.Dimension(1176, 705));
        Pnl_Mapa.setPreferredSize(new java.awt.Dimension(1176, 705));
        Pnl_Mapa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Aprender_Tema1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema1_Off.png"))); // NOI18N
        Btn_Aprender_Tema1.setBorderPainted(false);
        Btn_Aprender_Tema1.setContentAreaFilled(false);
        Btn_Aprender_Tema1.setFocusPainted(false);
        Btn_Aprender_Tema1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema1_On.png"))); // NOI18N
        Btn_Aprender_Tema1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema1ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 88, 81));
        Btn_Aprender_Tema1.getAccessibleContext().setAccessibleDescription("");

        Btn_Aprender_Tema2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema2_Off.png"))); // NOI18N
        Btn_Aprender_Tema2.setBorderPainted(false);
        Btn_Aprender_Tema2.setContentAreaFilled(false);
        Btn_Aprender_Tema2.setFocusPainted(false);
        Btn_Aprender_Tema2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema2_On.png"))); // NOI18N
        Btn_Aprender_Tema2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema2ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 88, 81));

        Btn_Aprender_Tema3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema3_Off.png"))); // NOI18N
        Btn_Aprender_Tema3.setBorderPainted(false);
        Btn_Aprender_Tema3.setContentAreaFilled(false);
        Btn_Aprender_Tema3.setFocusPainted(false);
        Btn_Aprender_Tema3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema3_On.png"))); // NOI18N
        Btn_Aprender_Tema3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema3ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 88, 81));

        Btn_Aprender_Tema4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema4_Off.png"))); // NOI18N
        Btn_Aprender_Tema4.setBorderPainted(false);
        Btn_Aprender_Tema4.setContentAreaFilled(false);
        Btn_Aprender_Tema4.setFocusPainted(false);
        Btn_Aprender_Tema4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema4_On.png"))); // NOI18N
        Btn_Aprender_Tema4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema4ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, 88, 81));

        Btn_Aprender_Tema5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema5_Off.png"))); // NOI18N
        Btn_Aprender_Tema5.setBorderPainted(false);
        Btn_Aprender_Tema5.setContentAreaFilled(false);
        Btn_Aprender_Tema5.setFocusPainted(false);
        Btn_Aprender_Tema5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema5_On.png"))); // NOI18N
        Btn_Aprender_Tema5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema5ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 190, 88, 81));

        Btn_Aprender_Tema6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema6_Off.png"))); // NOI18N
        Btn_Aprender_Tema6.setBorderPainted(false);
        Btn_Aprender_Tema6.setContentAreaFilled(false);
        Btn_Aprender_Tema6.setFocusPainted(false);
        Btn_Aprender_Tema6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema6_On.png"))); // NOI18N
        Btn_Aprender_Tema6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema6ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 88, 81));

        Btn_Aprender_Tema7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema7_Off.png"))); // NOI18N
        Btn_Aprender_Tema7.setBorderPainted(false);
        Btn_Aprender_Tema7.setContentAreaFilled(false);
        Btn_Aprender_Tema7.setFocusPainted(false);
        Btn_Aprender_Tema7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema7_On.png"))); // NOI18N
        Btn_Aprender_Tema7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema7ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 88, 81));

        Btn_Aprender_Tema8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema8_Off.png"))); // NOI18N
        Btn_Aprender_Tema8.setBorderPainted(false);
        Btn_Aprender_Tema8.setContentAreaFilled(false);
        Btn_Aprender_Tema8.setFocusPainted(false);
        Btn_Aprender_Tema8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema8_On.png"))); // NOI18N
        Btn_Aprender_Tema8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema8ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 88, 81));

        Btn_Aprender_Tema9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema9_Off.png"))); // NOI18N
        Btn_Aprender_Tema9.setBorderPainted(false);
        Btn_Aprender_Tema9.setContentAreaFilled(false);
        Btn_Aprender_Tema9.setFocusPainted(false);
        Btn_Aprender_Tema9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema9_On.png"))); // NOI18N
        Btn_Aprender_Tema9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema9ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 88, 81));

        Btn_Aprender_Tema10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema10_Off.png"))); // NOI18N
        Btn_Aprender_Tema10.setBorderPainted(false);
        Btn_Aprender_Tema10.setContentAreaFilled(false);
        Btn_Aprender_Tema10.setFocusPainted(false);
        Btn_Aprender_Tema10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema10_On.png"))); // NOI18N
        Btn_Aprender_Tema10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema10ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema10, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 390, 88, 81));

        Btn_Aprender_Tema11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema11_Off.png"))); // NOI18N
        Btn_Aprender_Tema11.setBorderPainted(false);
        Btn_Aprender_Tema11.setContentAreaFilled(false);
        Btn_Aprender_Tema11.setFocusPainted(false);
        Btn_Aprender_Tema11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema11_On.png"))); // NOI18N
        Btn_Aprender_Tema11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema11ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 390, 88, 81));

        Btn_Aprender_Tema12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema12_Off.png"))); // NOI18N
        Btn_Aprender_Tema12.setBorderPainted(false);
        Btn_Aprender_Tema12.setContentAreaFilled(false);
        Btn_Aprender_Tema12.setFocusPainted(false);
        Btn_Aprender_Tema12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema12_On.png"))); // NOI18N
        Btn_Aprender_Tema12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema12ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 570, 88, 81));

        Btn_Aprender_Tema13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema13_Off.png"))); // NOI18N
        Btn_Aprender_Tema13.setBorderPainted(false);
        Btn_Aprender_Tema13.setContentAreaFilled(false);
        Btn_Aprender_Tema13.setFocusPainted(false);
        Btn_Aprender_Tema13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema13_On.png"))); // NOI18N
        Btn_Aprender_Tema13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema13ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 570, 88, 81));

        Btn_Aprender_Tema14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema14_Off.png"))); // NOI18N
        Btn_Aprender_Tema14.setBorderPainted(false);
        Btn_Aprender_Tema14.setContentAreaFilled(false);
        Btn_Aprender_Tema14.setFocusPainted(false);
        Btn_Aprender_Tema14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema14_On.png"))); // NOI18N
        Btn_Aprender_Tema14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema14ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 570, 88, 81));

        Btn_Aprender_Ejercicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Ejercicio1_Off.png"))); // NOI18N
        Btn_Aprender_Ejercicio1.setBorderPainted(false);
        Btn_Aprender_Ejercicio1.setContentAreaFilled(false);
        Btn_Aprender_Ejercicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Ejercicio1.setMaximumSize(new java.awt.Dimension(71, 123));
        Btn_Aprender_Ejercicio1.setMinimumSize(new java.awt.Dimension(71, 123));
        Btn_Aprender_Ejercicio1.setPreferredSize(new java.awt.Dimension(71, 123));
        Btn_Aprender_Ejercicio1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Ejercicio1_On.png"))); // NOI18N
        Btn_Aprender_Ejercicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Ejercicio1ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 71, 123));

        Btn_Aprender_Ejercicio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Ejercicio2_Off.png"))); // NOI18N
        Btn_Aprender_Ejercicio2.setBorderPainted(false);
        Btn_Aprender_Ejercicio2.setContentAreaFilled(false);
        Btn_Aprender_Ejercicio2.setMaximumSize(new java.awt.Dimension(90, 140));
        Btn_Aprender_Ejercicio2.setMinimumSize(new java.awt.Dimension(90, 140));
        Btn_Aprender_Ejercicio2.setPreferredSize(new java.awt.Dimension(90, 140));
        Btn_Aprender_Ejercicio2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Ejercicio2_On.png"))); // NOI18N
        Btn_Aprender_Ejercicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Ejercicio2ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Ejercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 338, 90, 140));

        Btn_Aprender_EjercicioFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/EjercicioFinal_Off.png"))); // NOI18N
        Btn_Aprender_EjercicioFinal.setBorderPainted(false);
        Btn_Aprender_EjercicioFinal.setContentAreaFilled(false);
        Btn_Aprender_EjercicioFinal.setMaximumSize(new java.awt.Dimension(121, 184));
        Btn_Aprender_EjercicioFinal.setMinimumSize(new java.awt.Dimension(121, 184));
        Btn_Aprender_EjercicioFinal.setPreferredSize(new java.awt.Dimension(121, 184));
        Btn_Aprender_EjercicioFinal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/EjercicioFinal_On.png"))); // NOI18N
        Btn_Aprender_EjercicioFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_EjercicioFinalActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_EjercicioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 121, 184));

        Lbl_Aprender_Mapa.setBackground(new java.awt.Color(255, 255, 0));
        Lbl_Aprender_Mapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Aprender_Mapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Mapa.png"))); // NOI18N
        Lbl_Aprender_Mapa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lbl_Aprender_Mapa.setMaximumSize(new java.awt.Dimension(1176, 705));
        Lbl_Aprender_Mapa.setMinimumSize(new java.awt.Dimension(1176, 705));
        Lbl_Aprender_Mapa.setOpaque(true);
        Lbl_Aprender_Mapa.setPreferredSize(new java.awt.Dimension(1176, 705));
        Pnl_Mapa.add(Lbl_Aprender_Mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Pnl_Aprender.add(Pnl_Mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Scp_Tema1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema1.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema1.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema1.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema1.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema1.setMaximumSize(new java.awt.Dimension(1155, 1000));
        Pnl_Tema1.setMinimumSize(new java.awt.Dimension(1155, 1000));
        Pnl_Tema1.setPreferredSize(new java.awt.Dimension(1155, 1000));
        Pnl_Tema1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Siguiente_Cuestionario1.setBackground(null);
        Btn_Siguiente_Cuestionario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario1_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario1.setBorderPainted(false);
        Btn_Siguiente_Cuestionario1.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario1.setFocusPainted(false);
        Btn_Siguiente_Cuestionario1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario1.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario1.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario1.setOpaque(true);
        Btn_Siguiente_Cuestionario1.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario1_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario1ActionPerformed(evt);
            }
        });
        Pnl_Tema1.add(Btn_Siguiente_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 910, 254, 64));

        Lbl_Header_Aprender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema1.add(Lbl_Header_Aprender, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_HelloWorld.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_HelloWorld.setText("Hello World");
        Pnl_Tema1.add(Lbl_HelloWorld, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 190, 30));

        Btn_Atras.setText("Atras");
        Btn_Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AtrasActionPerformed(evt);
            }
        });
        Pnl_Tema1.add(Btn_Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 100, 110, 40));

        Scp_Tema1.setViewportView(Pnl_Tema1);

        Pnl_Aprender.add(Scp_Tema1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));
        Scp_Tema1.getAccessibleContext().setAccessibleDescription("");

        Scp_Cuestionario1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario1.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario1.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario1.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario1.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario1.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario1.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario1.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_HelloWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_HelloWorld_Off.png"))); // NOI18N
        Btn_Anterior_HelloWord.setBorderPainted(false);
        Btn_Anterior_HelloWord.setContentAreaFilled(false);
        Btn_Anterior_HelloWord.setFocusPainted(false);
        Btn_Anterior_HelloWord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_HelloWord.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_HelloWord.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_HelloWord.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_HelloWord.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_HelloWorld_On.png"))); // NOI18N
        Btn_Anterior_HelloWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_HelloWordActionPerformed(evt);
            }
        });
        Pnl_Cuestionario1.add(Btn_Anterior_HelloWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Comentarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Comentarios_Off.png"))); // NOI18N
        Btn_Siguiente_Comentarios.setBorderPainted(false);
        Btn_Siguiente_Comentarios.setContentAreaFilled(false);
        Btn_Siguiente_Comentarios.setFocusPainted(false);
        Btn_Siguiente_Comentarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Comentarios.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Comentarios.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Comentarios.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Comentarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Comentarios_On.png"))); // NOI18N
        Btn_Siguiente_Comentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_ComentariosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario1.add(Btn_Siguiente_Comentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario1.add(Lbl_Header_Aprender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario1.setText("Hello World | Cuestionario");
        Pnl_Cuestionario1.add(Lbl_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 420, 30));

        Scp_Cuestionario1.setViewportView(Pnl_Cuestionario1);

        Pnl_Aprender.add(Scp_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema2.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema2.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema2.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema2.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema2.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema2.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema2.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario1_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario1.setBorderPainted(false);
        Btn_Anterior_Cuestionario1.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario1.setFocusPainted(false);
        Btn_Anterior_Cuestionario1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario1.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario1.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario1.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario1_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario1ActionPerformed(evt);
            }
        });
        Pnl_Tema2.add(Btn_Anterior_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario2_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario2.setBorderPainted(false);
        Btn_Siguiente_Cuestionario2.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario2.setFocusPainted(false);
        Btn_Siguiente_Cuestionario2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario2.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario2.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario2.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario2_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario2ActionPerformed(evt);
            }
        });
        Pnl_Tema2.add(Btn_Siguiente_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema2.add(Lbl_Header_Aprender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Comentarios.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Comentarios.setText("Comentarios");
        Pnl_Tema2.add(Lbl_Comentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 190, 30));

        Scp_Tema2.setViewportView(Pnl_Tema2);

        Pnl_Aprender.add(Scp_Tema2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario2.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario2.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario2.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario2.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario2.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario2.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario2.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Comentarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Comentarios_Off.png"))); // NOI18N
        Btn_Anterior_Comentarios.setBorderPainted(false);
        Btn_Anterior_Comentarios.setContentAreaFilled(false);
        Btn_Anterior_Comentarios.setFocusPainted(false);
        Btn_Anterior_Comentarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Comentarios.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Comentarios.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Comentarios.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Comentarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Comentarios_On.png"))); // NOI18N
        Btn_Anterior_Comentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_ComentariosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario2.add(Btn_Anterior_Comentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_TiposdeDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_TiposdeDatos_Off.png"))); // NOI18N
        Btn_Siguiente_TiposdeDatos.setBorderPainted(false);
        Btn_Siguiente_TiposdeDatos.setContentAreaFilled(false);
        Btn_Siguiente_TiposdeDatos.setFocusPainted(false);
        Btn_Siguiente_TiposdeDatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_TiposdeDatos.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_TiposdeDatos.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_TiposdeDatos.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_TiposdeDatos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_TiposdeDatos_On.png"))); // NOI18N
        Btn_Siguiente_TiposdeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_TiposdeDatosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario2.add(Btn_Siguiente_TiposdeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario2.add(Lbl_Header_Aprender3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario2.setText("Comentarios | Cuestionario");
        Pnl_Cuestionario2.add(Lbl_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 440, 30));

        Scp_Cuestionario2.setViewportView(Pnl_Cuestionario2);

        Pnl_Aprender.add(Scp_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema3.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema3.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema3.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema3.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema3.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema3.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema3.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario2_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario2.setBorderPainted(false);
        Btn_Anterior_Cuestionario2.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario2.setFocusPainted(false);
        Btn_Anterior_Cuestionario2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario2.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario2.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario2.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario2_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario2ActionPerformed(evt);
            }
        });
        Pnl_Tema3.add(Btn_Anterior_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario3_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario3.setBorderPainted(false);
        Btn_Siguiente_Cuestionario3.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario3.setFocusPainted(false);
        Btn_Siguiente_Cuestionario3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario3.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario3.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario3.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario3_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario3ActionPerformed(evt);
            }
        });
        Pnl_Tema3.add(Btn_Siguiente_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema3.add(Lbl_Header_Aprender4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_TiposdeDatos.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_TiposdeDatos.setText("Tipos de Datos");
        Pnl_Tema3.add(Lbl_TiposdeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 230, 30));

        Scp_Tema3.setViewportView(Pnl_Tema3);

        Pnl_Aprender.add(Scp_Tema3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario3.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario3.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario3.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario3.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario3.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario3.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario3.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_TiposdeDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_TiposdeDatos_Off.png"))); // NOI18N
        Btn_Anterior_TiposdeDatos.setBorderPainted(false);
        Btn_Anterior_TiposdeDatos.setContentAreaFilled(false);
        Btn_Anterior_TiposdeDatos.setFocusPainted(false);
        Btn_Anterior_TiposdeDatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_TiposdeDatos.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_TiposdeDatos.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_TiposdeDatos.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_TiposdeDatos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_TiposdeDatos_On.png"))); // NOI18N
        Btn_Anterior_TiposdeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_TiposdeDatosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario3.add(Btn_Anterior_TiposdeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_OperadoresAritmeticos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresAritmeticos_Off.png"))); // NOI18N
        Btn_Siguiente_OperadoresAritmeticos.setBorderPainted(false);
        Btn_Siguiente_OperadoresAritmeticos.setContentAreaFilled(false);
        Btn_Siguiente_OperadoresAritmeticos.setFocusPainted(false);
        Btn_Siguiente_OperadoresAritmeticos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_OperadoresAritmeticos.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_OperadoresAritmeticos.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_OperadoresAritmeticos.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_OperadoresAritmeticos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresAritmeticos_On.png"))); // NOI18N
        Btn_Siguiente_OperadoresAritmeticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_OperadoresAritmeticosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario3.add(Btn_Siguiente_OperadoresAritmeticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario3.add(Lbl_Header_Aprender5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario3.setText("Tipos de Datos | Cuestionario");
        Pnl_Cuestionario3.add(Lbl_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 430, 30));

        Scp_Cuestionario3.setViewportView(Pnl_Cuestionario3);

        Pnl_Aprender.add(Scp_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema4.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema4.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema4.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema4.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema4.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema4.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema4.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario3_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario3.setBorderPainted(false);
        Btn_Anterior_Cuestionario3.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario3.setFocusPainted(false);
        Btn_Anterior_Cuestionario3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario3.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario3.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario3.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario3_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario3ActionPerformed(evt);
            }
        });
        Pnl_Tema4.add(Btn_Anterior_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario4_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario4.setBorderPainted(false);
        Btn_Siguiente_Cuestionario4.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario4.setFocusPainted(false);
        Btn_Siguiente_Cuestionario4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario4.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario4.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario4.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario4_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario4ActionPerformed(evt);
            }
        });
        Pnl_Tema4.add(Btn_Siguiente_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema4.add(Lbl_Header_Aprender6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_OperadoresAritmeticos.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_OperadoresAritmeticos.setText("Operadores Aritméticos");
        Pnl_Tema4.add(Lbl_OperadoresAritmeticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 350, 30));

        Scp_Tema4.setViewportView(Pnl_Tema4);

        Pnl_Aprender.add(Scp_Tema4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario4.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario4.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario4.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario4.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario4.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario4.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario4.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_OperadoresAritmeticos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresAritmeticos_Off.png"))); // NOI18N
        Btn_Anterior_OperadoresAritmeticos.setBorderPainted(false);
        Btn_Anterior_OperadoresAritmeticos.setContentAreaFilled(false);
        Btn_Anterior_OperadoresAritmeticos.setFocusPainted(false);
        Btn_Anterior_OperadoresAritmeticos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_OperadoresAritmeticos.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_OperadoresAritmeticos.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_OperadoresAritmeticos.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_OperadoresAritmeticos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresAritmeticos_On.png"))); // NOI18N
        Btn_Anterior_OperadoresAritmeticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_OperadoresAritmeticosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario4.add(Btn_Anterior_OperadoresAritmeticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_LecturaeImpresion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_LecturaeImpresion_Off.png"))); // NOI18N
        Btn_Siguiente_LecturaeImpresion.setBorderPainted(false);
        Btn_Siguiente_LecturaeImpresion.setContentAreaFilled(false);
        Btn_Siguiente_LecturaeImpresion.setFocusPainted(false);
        Btn_Siguiente_LecturaeImpresion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_LecturaeImpresion.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_LecturaeImpresion.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_LecturaeImpresion.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_LecturaeImpresion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_LecturaeImpresion_On.png"))); // NOI18N
        Btn_Siguiente_LecturaeImpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_LecturaeImpresionActionPerformed(evt);
            }
        });
        Pnl_Cuestionario4.add(Btn_Siguiente_LecturaeImpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario4.add(Lbl_Header_Aprender7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario4.setText("Operadores Aritméticos | Cuestionario");
        Pnl_Cuestionario4.add(Lbl_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 30));

        Scp_Cuestionario4.setViewportView(Pnl_Cuestionario4);

        Pnl_Aprender.add(Scp_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema5.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema5.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema5.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema5.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema5.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema5.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema5.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario4_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario4.setBorderPainted(false);
        Btn_Anterior_Cuestionario4.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario4.setFocusPainted(false);
        Btn_Anterior_Cuestionario4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario4.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario4.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario4.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario4_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario4ActionPerformed(evt);
            }
        });
        Pnl_Tema5.add(Btn_Anterior_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario5_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario5.setBorderPainted(false);
        Btn_Siguiente_Cuestionario5.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario5.setFocusPainted(false);
        Btn_Siguiente_Cuestionario5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario5.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario5.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario5.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario5_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario5ActionPerformed(evt);
            }
        });
        Pnl_Tema5.add(Btn_Siguiente_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema5.add(Lbl_Header_Aprender8, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_LecturaeImpresion.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_LecturaeImpresion.setText("Lectura e Impresión");
        Pnl_Tema5.add(Lbl_LecturaeImpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 40));

        Scp_Tema5.setViewportView(Pnl_Tema5);

        Pnl_Aprender.add(Scp_Tema5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario5.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario5.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario5.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario5.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario5.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario5.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario5.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_LecturaeImpresion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_LecturaeImpresion_Off.png"))); // NOI18N
        Btn_Anterior_LecturaeImpresion.setBorderPainted(false);
        Btn_Anterior_LecturaeImpresion.setContentAreaFilled(false);
        Btn_Anterior_LecturaeImpresion.setFocusPainted(false);
        Btn_Anterior_LecturaeImpresion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_LecturaeImpresion.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_LecturaeImpresion.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_LecturaeImpresion.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_LecturaeImpresion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_LecturaeImpresion_On.png"))); // NOI18N
        Btn_Anterior_LecturaeImpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_LecturaeImpresionActionPerformed(evt);
            }
        });
        Pnl_Cuestionario5.add(Btn_Anterior_LecturaeImpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Ejercicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Ejercicio1_Off.png"))); // NOI18N
        Btn_Siguiente_Ejercicio1.setBorder(null);
        Btn_Siguiente_Ejercicio1.setBorderPainted(false);
        Btn_Siguiente_Ejercicio1.setContentAreaFilled(false);
        Btn_Siguiente_Ejercicio1.setFocusPainted(false);
        Btn_Siguiente_Ejercicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Ejercicio1.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Ejercicio1.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Ejercicio1.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Ejercicio1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Ejercicio1_On.png"))); // NOI18N
        Btn_Siguiente_Ejercicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Ejercicio1ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario5.add(Btn_Siguiente_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario5.add(Lbl_Header_Aprender10, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario5.setText("Lectura e Impresión | Cuestionario");
        Pnl_Cuestionario5.add(Lbl_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 30));

        Scp_Cuestionario5.setViewportView(Pnl_Cuestionario5);

        Pnl_Aprender.add(Scp_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Ejercicio1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Ejercicio1.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Ejercicio1.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Ejercicio1.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Ejercicio1_Aprender.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Ejercicio1_Aprender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Ejercicio1_Aprender.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Ejercicio1_Aprender.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Ejercicio1_Aprender.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Ejercicio1_Aprender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario5_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario5.setBorder(null);
        Btn_Anterior_Cuestionario5.setBorderPainted(false);
        Btn_Anterior_Cuestionario5.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario5.setFocusPainted(false);
        Btn_Anterior_Cuestionario5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario5.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario5.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario5.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario5_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario5ActionPerformed(evt);
            }
        });
        Pnl_Ejercicio1_Aprender.add(Btn_Anterior_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_OperadoresdeRelacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresdeRelacion_Off.png"))); // NOI18N
        Btn_Siguiente_OperadoresdeRelacion.setBorder(null);
        Btn_Siguiente_OperadoresdeRelacion.setBorderPainted(false);
        Btn_Siguiente_OperadoresdeRelacion.setContentAreaFilled(false);
        Btn_Siguiente_OperadoresdeRelacion.setFocusPainted(false);
        Btn_Siguiente_OperadoresdeRelacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_OperadoresdeRelacion.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_OperadoresdeRelacion.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_OperadoresdeRelacion.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_OperadoresdeRelacion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresdeRelacion_On.png"))); // NOI18N
        Btn_Siguiente_OperadoresdeRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_OperadoresdeRelacionActionPerformed(evt);
            }
        });
        Pnl_Ejercicio1_Aprender.add(Btn_Siguiente_OperadoresdeRelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Ejercicio1_Aprender.add(Lbl_Header_Aprender33, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Ejercicio1_Principiante.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Ejercicio1_Principiante.setText("Ejercicio 1 | Principiante");
        Pnl_Ejercicio1_Aprender.add(Lbl_Ejercicio1_Principiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 40));

        Scp_Ejercicio1.setViewportView(Pnl_Ejercicio1_Aprender);

        Pnl_Aprender.add(Scp_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema6.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema6.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema6.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema6.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema6.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema6.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema6.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Ejercicio1_Principiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Ejercicio1_Off.png"))); // NOI18N
        Btn_Anterior_Ejercicio1_Principiante.setBorder(null);
        Btn_Anterior_Ejercicio1_Principiante.setBorderPainted(false);
        Btn_Anterior_Ejercicio1_Principiante.setContentAreaFilled(false);
        Btn_Anterior_Ejercicio1_Principiante.setFocusPainted(false);
        Btn_Anterior_Ejercicio1_Principiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Ejercicio1_Principiante.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Ejercicio1_Principiante.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Ejercicio1_Principiante.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Ejercicio1_Principiante.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Ejercicio1_On.png"))); // NOI18N
        Btn_Anterior_Ejercicio1_Principiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Ejercicio1_PrincipianteActionPerformed(evt);
            }
        });
        Pnl_Tema6.add(Btn_Anterior_Ejercicio1_Principiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario6_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario6.setBorderPainted(false);
        Btn_Siguiente_Cuestionario6.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario6.setFocusPainted(false);
        Btn_Siguiente_Cuestionario6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario6.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario6.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario6.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario6_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario6ActionPerformed(evt);
            }
        });
        Pnl_Tema6.add(Btn_Siguiente_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema6.add(Lbl_Header_Aprender15, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_OperadoresdeRelacion.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_OperadoresdeRelacion.setText("Operadores de Relación");
        Pnl_Tema6.add(Lbl_OperadoresdeRelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 440, 40));

        Scp_Tema6.setViewportView(Pnl_Tema6);

        Pnl_Aprender.add(Scp_Tema6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario6.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario6.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario6.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario6.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario6.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario6.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario6.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_OperadoresdeRelacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresdeRelacion_Off.png"))); // NOI18N
        Btn_Anterior_OperadoresdeRelacion.setBorderPainted(false);
        Btn_Anterior_OperadoresdeRelacion.setContentAreaFilled(false);
        Btn_Anterior_OperadoresdeRelacion.setFocusPainted(false);
        Btn_Anterior_OperadoresdeRelacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_OperadoresdeRelacion.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_OperadoresdeRelacion.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_OperadoresdeRelacion.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_OperadoresdeRelacion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresdeRelacion_On.png"))); // NOI18N
        Btn_Anterior_OperadoresdeRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_OperadoresdeRelacionActionPerformed(evt);
            }
        });
        Pnl_Cuestionario6.add(Btn_Anterior_OperadoresdeRelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_OperadoresLogicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresLogicos_Off.png"))); // NOI18N
        Btn_Siguiente_OperadoresLogicos.setBorderPainted(false);
        Btn_Siguiente_OperadoresLogicos.setContentAreaFilled(false);
        Btn_Siguiente_OperadoresLogicos.setFocusPainted(false);
        Btn_Siguiente_OperadoresLogicos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_OperadoresLogicos.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_OperadoresLogicos.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_OperadoresLogicos.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_OperadoresLogicos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresLogicos_On.png"))); // NOI18N
        Btn_Siguiente_OperadoresLogicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_OperadoresLogicosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario6.add(Btn_Siguiente_OperadoresLogicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario6.add(Lbl_Header_Aprender16, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario6.setText("Operadores de Relación | Cuestionario");
        Pnl_Cuestionario6.add(Lbl_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 30));

        Scp_Cuestionario6.setViewportView(Pnl_Cuestionario6);

        Pnl_Aprender.add(Scp_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema7.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema7.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema7.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema7.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema7.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema7.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema7.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario6_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario6.setBorderPainted(false);
        Btn_Anterior_Cuestionario6.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario6.setFocusPainted(false);
        Btn_Anterior_Cuestionario6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario6.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario6.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario6.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario6_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario6ActionPerformed(evt);
            }
        });
        Pnl_Tema7.add(Btn_Anterior_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario7_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario7.setBorderPainted(false);
        Btn_Siguiente_Cuestionario7.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario7.setFocusPainted(false);
        Btn_Siguiente_Cuestionario7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario7.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario7.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario7.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario7_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario7ActionPerformed(evt);
            }
        });
        Pnl_Tema7.add(Btn_Siguiente_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema7.add(Lbl_Header_Aprender17, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_OperadoresLogicos.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_OperadoresLogicos.setText("Operadores Lógicos");
        Pnl_Tema7.add(Lbl_OperadoresLogicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 40));

        Scp_Tema7.setViewportView(Pnl_Tema7);

        Pnl_Aprender.add(Scp_Tema7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario7.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario7.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario7.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario7.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario7.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario7.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario7.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_OperadoresLogicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresLogicos_Off.png"))); // NOI18N
        Btn_Anterior_OperadoresLogicos.setBorderPainted(false);
        Btn_Anterior_OperadoresLogicos.setContentAreaFilled(false);
        Btn_Anterior_OperadoresLogicos.setFocusPainted(false);
        Btn_Anterior_OperadoresLogicos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_OperadoresLogicos.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_OperadoresLogicos.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_OperadoresLogicos.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_OperadoresLogicos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresLogicos_On.png"))); // NOI18N
        Btn_Anterior_OperadoresLogicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_OperadoresLogicosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario7.add(Btn_Anterior_OperadoresLogicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Condicionales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Condicionales_Off.png"))); // NOI18N
        Btn_Siguiente_Condicionales.setBorderPainted(false);
        Btn_Siguiente_Condicionales.setContentAreaFilled(false);
        Btn_Siguiente_Condicionales.setFocusPainted(false);
        Btn_Siguiente_Condicionales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Condicionales.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Condicionales.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Condicionales.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Condicionales.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Condicionales_On.png"))); // NOI18N
        Btn_Siguiente_Condicionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_CondicionalesActionPerformed(evt);
            }
        });
        Pnl_Cuestionario7.add(Btn_Siguiente_Condicionales, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario7.add(Lbl_Header_Aprender18, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario7.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario7.setText("Operadores Lógicos | Cuestionario");
        Pnl_Cuestionario7.add(Lbl_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 40));

        Scp_Cuestionario7.setViewportView(Pnl_Cuestionario7);

        Pnl_Aprender.add(Scp_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema8.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema8.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema8.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema8.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema8.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema8.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema8.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario7_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario7.setBorderPainted(false);
        Btn_Anterior_Cuestionario7.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario7.setFocusPainted(false);
        Btn_Anterior_Cuestionario7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario7.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario7.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario7.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario7_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario7ActionPerformed(evt);
            }
        });
        Pnl_Tema8.add(Btn_Anterior_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario8_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario8.setBorderPainted(false);
        Btn_Siguiente_Cuestionario8.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario8.setFocusPainted(false);
        Btn_Siguiente_Cuestionario8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario8.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario8.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario8.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario8_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario8ActionPerformed(evt);
            }
        });
        Pnl_Tema8.add(Btn_Siguiente_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema8.add(Lbl_Header_Aprender19, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Condicionales.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Condicionales.setText("Condicionales");
        Pnl_Tema8.add(Lbl_Condicionales, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 40));

        Scp_Tema8.setViewportView(Pnl_Tema8);

        Pnl_Aprender.add(Scp_Tema8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario8.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario8.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario8.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario8.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario8.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario8.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario8.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Condicionales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Condicionales_Off.png"))); // NOI18N
        Btn_Anterior_Condicionales.setBorderPainted(false);
        Btn_Anterior_Condicionales.setContentAreaFilled(false);
        Btn_Anterior_Condicionales.setFocusPainted(false);
        Btn_Anterior_Condicionales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Condicionales.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Condicionales.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Condicionales.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Condicionales.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Condicionales_On.png"))); // NOI18N
        Btn_Anterior_Condicionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_CondicionalesActionPerformed(evt);
            }
        });
        Pnl_Cuestionario8.add(Btn_Anterior_Condicionales, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Bucles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Bucles_Off.png"))); // NOI18N
        Btn_Siguiente_Bucles.setBorderPainted(false);
        Btn_Siguiente_Bucles.setContentAreaFilled(false);
        Btn_Siguiente_Bucles.setFocusPainted(false);
        Btn_Siguiente_Bucles.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Bucles.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Bucles.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Bucles.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Bucles.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Bucles_On.png"))); // NOI18N
        Btn_Siguiente_Bucles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_BuclesActionPerformed(evt);
            }
        });
        Pnl_Cuestionario8.add(Btn_Siguiente_Bucles, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario8.add(Lbl_Header_Aprender20, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario8.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario8.setText("Condicionales | Cuestionario");
        Pnl_Cuestionario8.add(Lbl_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 30));

        Scp_Cuestionario8.setViewportView(Pnl_Cuestionario8);

        Pnl_Aprender.add(Scp_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema9.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema9.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema9.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema9.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema9.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema9.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema9.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario8_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario8.setBorderPainted(false);
        Btn_Anterior_Cuestionario8.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario8.setFocusPainted(false);
        Btn_Anterior_Cuestionario8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario8.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario8.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario8.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario8_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario8ActionPerformed(evt);
            }
        });
        Pnl_Tema9.add(Btn_Anterior_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario9_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario9.setBorderPainted(false);
        Btn_Siguiente_Cuestionario9.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario9.setFocusPainted(false);
        Btn_Siguiente_Cuestionario9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario9.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario9.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario9.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario9_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario9ActionPerformed(evt);
            }
        });
        Pnl_Tema9.add(Btn_Siguiente_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema9.add(Lbl_Header_Aprender21, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Bucles.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Bucles.setText("Bucles");
        Pnl_Tema9.add(Lbl_Bucles, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 40));

        Scp_Tema9.setViewportView(Pnl_Tema9);

        Pnl_Aprender.add(Scp_Tema9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario9.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario9.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario9.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario9.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario9.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario9.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario9.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Bucles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Bucles_Off.png"))); // NOI18N
        Btn_Anterior_Bucles.setBorderPainted(false);
        Btn_Anterior_Bucles.setContentAreaFilled(false);
        Btn_Anterior_Bucles.setFocusPainted(false);
        Btn_Anterior_Bucles.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Bucles.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Bucles.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Bucles.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Bucles.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Bucles_On.png"))); // NOI18N
        Btn_Anterior_Bucles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_BuclesActionPerformed(evt);
            }
        });
        Pnl_Cuestionario9.add(Btn_Anterior_Bucles, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Ejercicio2_Intermedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Ejercicio2_Off.png"))); // NOI18N
        Btn_Siguiente_Ejercicio2_Intermedio.setBorder(null);
        Btn_Siguiente_Ejercicio2_Intermedio.setBorderPainted(false);
        Btn_Siguiente_Ejercicio2_Intermedio.setContentAreaFilled(false);
        Btn_Siguiente_Ejercicio2_Intermedio.setFocusPainted(false);
        Btn_Siguiente_Ejercicio2_Intermedio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Ejercicio2_Intermedio.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Ejercicio2_Intermedio.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Ejercicio2_Intermedio.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Ejercicio2_Intermedio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Ejercicio2_On.png"))); // NOI18N
        Btn_Siguiente_Ejercicio2_Intermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Ejercicio2_IntermedioActionPerformed(evt);
            }
        });
        Pnl_Cuestionario9.add(Btn_Siguiente_Ejercicio2_Intermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario9.add(Lbl_Header_Aprender22, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario9.setText("Bucles | Cuestionario");
        Pnl_Cuestionario9.add(Lbl_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 30));

        Scp_Cuestionario9.setViewportView(Pnl_Cuestionario9);

        Pnl_Aprender.add(Scp_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Ejercicio2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Ejercicio2.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Ejercicio2.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Ejercicio2.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Ejercicio2_Aprender.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Ejercicio2_Aprender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Ejercicio2_Aprender.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Ejercicio2_Aprender.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Ejercicio2_Aprender.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Ejercicio2_Aprender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario9_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario9.setBorder(null);
        Btn_Anterior_Cuestionario9.setBorderPainted(false);
        Btn_Anterior_Cuestionario9.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario9.setFocusPainted(false);
        Btn_Anterior_Cuestionario9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario9.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario9.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario9.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario9_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario9ActionPerformed(evt);
            }
        });
        Pnl_Ejercicio2_Aprender.add(Btn_Anterior_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_FuncionesyProc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_FuncyProc_Off.png"))); // NOI18N
        Btn_Siguiente_FuncionesyProc.setBorder(null);
        Btn_Siguiente_FuncionesyProc.setBorderPainted(false);
        Btn_Siguiente_FuncionesyProc.setContentAreaFilled(false);
        Btn_Siguiente_FuncionesyProc.setFocusPainted(false);
        Btn_Siguiente_FuncionesyProc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_FuncionesyProc.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_FuncionesyProc.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_FuncionesyProc.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_FuncionesyProc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_FuncyProc_On.png"))); // NOI18N
        Btn_Siguiente_FuncionesyProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_FuncionesyProcActionPerformed(evt);
            }
        });
        Pnl_Ejercicio2_Aprender.add(Btn_Siguiente_FuncionesyProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Ejercicio2_Aprender.add(Lbl_Header_Aprender34, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Ejercicio2_Intermedio.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Ejercicio2_Intermedio.setText("Ejercicio 2 | Intermedio");
        Pnl_Ejercicio2_Aprender.add(Lbl_Ejercicio2_Intermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 40));

        Scp_Ejercicio2.setViewportView(Pnl_Ejercicio2_Aprender);

        Pnl_Aprender.add(Scp_Ejercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema10.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema10.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema10.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema10.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema10.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema10.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema10.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Ejercicio2_Intermedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Ejercicio2_Off.png"))); // NOI18N
        Btn_Anterior_Ejercicio2_Intermedio.setBorder(null);
        Btn_Anterior_Ejercicio2_Intermedio.setBorderPainted(false);
        Btn_Anterior_Ejercicio2_Intermedio.setContentAreaFilled(false);
        Btn_Anterior_Ejercicio2_Intermedio.setFocusPainted(false);
        Btn_Anterior_Ejercicio2_Intermedio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Ejercicio2_Intermedio.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Ejercicio2_Intermedio.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Ejercicio2_Intermedio.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Ejercicio2_Intermedio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Ejercicio2_On.png"))); // NOI18N
        Btn_Anterior_Ejercicio2_Intermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Ejercicio2_IntermedioActionPerformed(evt);
            }
        });
        Pnl_Tema10.add(Btn_Anterior_Ejercicio2_Intermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario10_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario10.setBorderPainted(false);
        Btn_Siguiente_Cuestionario10.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario10.setFocusPainted(false);
        Btn_Siguiente_Cuestionario10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario10.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario10.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario10.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario10_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario10ActionPerformed(evt);
            }
        });
        Pnl_Tema10.add(Btn_Siguiente_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema10.add(Lbl_Header_Aprender23, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_FuncionesyProcs.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_FuncionesyProcs.setText("Funciones y Procedimientos");
        Pnl_Tema10.add(Lbl_FuncionesyProcs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 460, 40));

        Scp_Tema10.setViewportView(Pnl_Tema10);

        Pnl_Aprender.add(Scp_Tema10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario10.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario10.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario10.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario10.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario10.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario10.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario10.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_FuncyProc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_FuncyProc_Off.png"))); // NOI18N
        Btn_Anterior_FuncyProc.setBorderPainted(false);
        Btn_Anterior_FuncyProc.setContentAreaFilled(false);
        Btn_Anterior_FuncyProc.setFocusPainted(false);
        Btn_Anterior_FuncyProc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_FuncyProc.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_FuncyProc.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_FuncyProc.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_FuncyProc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_FuncyProc_On.png"))); // NOI18N
        Btn_Anterior_FuncyProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_FuncyProcActionPerformed(evt);
            }
        });
        Pnl_Cuestionario10.add(Btn_Anterior_FuncyProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Recursion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Recursion_Off.png"))); // NOI18N
        Btn_Siguiente_Recursion.setBorderPainted(false);
        Btn_Siguiente_Recursion.setContentAreaFilled(false);
        Btn_Siguiente_Recursion.setFocusPainted(false);
        Btn_Siguiente_Recursion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Recursion.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Recursion.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Recursion.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Recursion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Recursion_On.png"))); // NOI18N
        Btn_Siguiente_Recursion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_RecursionActionPerformed(evt);
            }
        });
        Pnl_Cuestionario10.add(Btn_Siguiente_Recursion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario10.add(Lbl_Header_Aprender24, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario10.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario10.setText("Funciones y Procedimientos | Cuestionario");
        Pnl_Cuestionario10.add(Lbl_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 650, 30));

        Scp_Cuestionario10.setViewportView(Pnl_Cuestionario10);

        Pnl_Aprender.add(Scp_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema11.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema11.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema11.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema11.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema11.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema11.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema11.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario10_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario10.setBorderPainted(false);
        Btn_Anterior_Cuestionario10.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario10.setFocusPainted(false);
        Btn_Anterior_Cuestionario10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario10.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario10.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario10.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario10_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario10ActionPerformed(evt);
            }
        });
        Pnl_Tema11.add(Btn_Anterior_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario11_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario11.setBorderPainted(false);
        Btn_Siguiente_Cuestionario11.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario11.setFocusPainted(false);
        Btn_Siguiente_Cuestionario11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario11.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario11.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario11.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario11_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario11ActionPerformed(evt);
            }
        });
        Pnl_Tema11.add(Btn_Siguiente_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema11.add(Lbl_Header_Aprender25, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Recursion.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Recursion.setText("Recursión");
        Pnl_Tema11.add(Lbl_Recursion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 40));

        Scp_Tema11.setViewportView(Pnl_Tema11);

        Pnl_Aprender.add(Scp_Tema11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario11.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario11.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario11.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario11.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario11.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario11.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario11.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Recursion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Recursion_Off.png"))); // NOI18N
        Btn_Anterior_Recursion.setBorderPainted(false);
        Btn_Anterior_Recursion.setContentAreaFilled(false);
        Btn_Anterior_Recursion.setFocusPainted(false);
        Btn_Anterior_Recursion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Recursion.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Recursion.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Recursion.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Recursion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Recursion_On.png"))); // NOI18N
        Btn_Anterior_Recursion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_RecursionActionPerformed(evt);
            }
        });
        Pnl_Cuestionario11.add(Btn_Anterior_Recursion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_EDDBasicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EDDBasicas_Off.png"))); // NOI18N
        Btn_Siguiente_EDDBasicas.setBorderPainted(false);
        Btn_Siguiente_EDDBasicas.setContentAreaFilled(false);
        Btn_Siguiente_EDDBasicas.setFocusPainted(false);
        Btn_Siguiente_EDDBasicas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_EDDBasicas.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_EDDBasicas.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_EDDBasicas.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_EDDBasicas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EDDBasicas_On.png"))); // NOI18N
        Btn_Siguiente_EDDBasicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_EDDBasicasActionPerformed(evt);
            }
        });
        Pnl_Cuestionario11.add(Btn_Siguiente_EDDBasicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario11.add(Lbl_Header_Aprender26, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario11.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario11.setText("Recursión | Cuestionario");
        Pnl_Cuestionario11.add(Lbl_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 30));

        Scp_Cuestionario11.setViewportView(Pnl_Cuestionario11);

        Pnl_Aprender.add(Scp_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema12.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema12.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema12.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema12.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema12.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema12.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema12.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario11_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario11.setBorderPainted(false);
        Btn_Anterior_Cuestionario11.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario11.setFocusPainted(false);
        Btn_Anterior_Cuestionario11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario11.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario11.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario11.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario11_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario11ActionPerformed(evt);
            }
        });
        Pnl_Tema12.add(Btn_Anterior_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario12_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario12.setBorderPainted(false);
        Btn_Siguiente_Cuestionario12.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario12.setFocusPainted(false);
        Btn_Siguiente_Cuestionario12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario12.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario12.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario12.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario12_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario12ActionPerformed(evt);
            }
        });
        Pnl_Tema12.add(Btn_Siguiente_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema12.add(Lbl_Header_Aprender27, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_EDDBasicas.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_EDDBasicas.setText("Estructuras de Datos Básicas");
        Pnl_Tema12.add(Lbl_EDDBasicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 450, 40));

        Scp_Tema12.setViewportView(Pnl_Tema12);

        Pnl_Aprender.add(Scp_Tema12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario12.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario12.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario12.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario12.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario12.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario12.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario12.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_EDDBasicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_EDDBasicas_Off.png"))); // NOI18N
        Btn_Anterior_EDDBasicas.setBorderPainted(false);
        Btn_Anterior_EDDBasicas.setContentAreaFilled(false);
        Btn_Anterior_EDDBasicas.setFocusPainted(false);
        Btn_Anterior_EDDBasicas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_EDDBasicas.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_EDDBasicas.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_EDDBasicas.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_EDDBasicas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_EDDBasicas_On.png"))); // NOI18N
        Btn_Anterior_EDDBasicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_EDDBasicasActionPerformed(evt);
            }
        });
        Pnl_Cuestionario12.add(Btn_Anterior_EDDBasicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_EDDAvanzadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EDDAvanzadas_Off.png"))); // NOI18N
        Btn_Siguiente_EDDAvanzadas.setBorderPainted(false);
        Btn_Siguiente_EDDAvanzadas.setContentAreaFilled(false);
        Btn_Siguiente_EDDAvanzadas.setFocusPainted(false);
        Btn_Siguiente_EDDAvanzadas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_EDDAvanzadas.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_EDDAvanzadas.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_EDDAvanzadas.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_EDDAvanzadas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EDDAvanzadas_On.png"))); // NOI18N
        Btn_Siguiente_EDDAvanzadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_EDDAvanzadasActionPerformed(evt);
            }
        });
        Pnl_Cuestionario12.add(Btn_Siguiente_EDDAvanzadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario12.add(Lbl_Header_Aprender28, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario12.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario12.setText("Estructuras de Datos Básicas | Cuestionario");
        Pnl_Cuestionario12.add(Lbl_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 630, 30));

        Scp_Cuestionario12.setViewportView(Pnl_Cuestionario12);

        Pnl_Aprender.add(Scp_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema13.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema13.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema13.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema13.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema13.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema13.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema13.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario12_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario12.setBorderPainted(false);
        Btn_Anterior_Cuestionario12.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario12.setFocusPainted(false);
        Btn_Anterior_Cuestionario12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario12.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario12.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario12.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario12_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario12ActionPerformed(evt);
            }
        });
        Pnl_Tema13.add(Btn_Anterior_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario13_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario13.setBorderPainted(false);
        Btn_Siguiente_Cuestionario13.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario13.setFocusPainted(false);
        Btn_Siguiente_Cuestionario13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario13.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario13.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario13.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario13_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario13ActionPerformed(evt);
            }
        });
        Pnl_Tema13.add(Btn_Siguiente_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema13.add(Lbl_Header_Aprender29, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_EDDAvanzadas.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_EDDAvanzadas.setText("Estructuras de Datos Avanzadas");
        Pnl_Tema13.add(Lbl_EDDAvanzadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 510, 40));

        Scp_Tema13.setViewportView(Pnl_Tema13);

        Pnl_Aprender.add(Scp_Tema13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario13.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario13.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario13.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario13.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario13.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario13.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario13.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_EDDAvanzadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_EDDAvanzadas_Off.png"))); // NOI18N
        Btn_Anterior_EDDAvanzadas.setBorderPainted(false);
        Btn_Anterior_EDDAvanzadas.setContentAreaFilled(false);
        Btn_Anterior_EDDAvanzadas.setFocusPainted(false);
        Btn_Anterior_EDDAvanzadas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_EDDAvanzadas.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_EDDAvanzadas.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_EDDAvanzadas.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_EDDAvanzadas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_EDDAvanzadas_On.png"))); // NOI18N
        Btn_Anterior_EDDAvanzadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_EDDAvanzadasActionPerformed(evt);
            }
        });
        Pnl_Cuestionario13.add(Btn_Anterior_EDDAvanzadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_PrimerosAlgoritmos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_PrimerosAlgoritmos_Off.png"))); // NOI18N
        Btn_Siguiente_PrimerosAlgoritmos.setBorderPainted(false);
        Btn_Siguiente_PrimerosAlgoritmos.setContentAreaFilled(false);
        Btn_Siguiente_PrimerosAlgoritmos.setFocusPainted(false);
        Btn_Siguiente_PrimerosAlgoritmos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_PrimerosAlgoritmos.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_PrimerosAlgoritmos.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_PrimerosAlgoritmos.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_PrimerosAlgoritmos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_PrimerosAlgoritmos_On.png"))); // NOI18N
        Btn_Siguiente_PrimerosAlgoritmos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_PrimerosAlgoritmosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario13.add(Btn_Siguiente_PrimerosAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario13.add(Lbl_Header_Aprender30, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario13.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario13.setText("Estructuras de Datos Avanzadas | Cuestionario");
        Pnl_Cuestionario13.add(Lbl_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 660, 30));

        Scp_Cuestionario13.setViewportView(Pnl_Cuestionario13);

        Pnl_Aprender.add(Scp_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Tema14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema14.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema14.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Tema14.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Tema14.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Tema14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Tema14.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema14.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema14.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Tema14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario13_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario13.setBorderPainted(false);
        Btn_Anterior_Cuestionario13.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario13.setFocusPainted(false);
        Btn_Anterior_Cuestionario13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario13.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario13.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario13.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario13_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario13ActionPerformed(evt);
            }
        });
        Pnl_Tema14.add(Btn_Anterior_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario14_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario14.setBorderPainted(false);
        Btn_Siguiente_Cuestionario14.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario14.setFocusPainted(false);
        Btn_Siguiente_Cuestionario14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario14.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario14.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario14.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_Cuestionario14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario14_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario14ActionPerformed(evt);
            }
        });
        Pnl_Tema14.add(Btn_Siguiente_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Tema14.add(Lbl_Header_Aprender31, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_PrimerosAlgoritmos.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_PrimerosAlgoritmos.setText("Primeros Algoritmos");
        Pnl_Tema14.add(Lbl_PrimerosAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 40));

        Scp_Tema14.setViewportView(Pnl_Tema14);

        Pnl_Aprender.add(Scp_Tema14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Cuestionario14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario14.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario14.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Cuestionario14.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Cuestionario14.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Cuestionario14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Cuestionario14.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario14.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario14.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Cuestionario14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_PrimerosAlgoritmos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_PrimerosAlgoritmos_Off.png"))); // NOI18N
        Btn_Anterior_PrimerosAlgoritmos.setBorderPainted(false);
        Btn_Anterior_PrimerosAlgoritmos.setContentAreaFilled(false);
        Btn_Anterior_PrimerosAlgoritmos.setFocusPainted(false);
        Btn_Anterior_PrimerosAlgoritmos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_PrimerosAlgoritmos.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_PrimerosAlgoritmos.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_PrimerosAlgoritmos.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_PrimerosAlgoritmos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_PrimerosAlgoritmos_On.png"))); // NOI18N
        Btn_Anterior_PrimerosAlgoritmos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_PrimerosAlgoritmosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario14.add(Btn_Anterior_PrimerosAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_EjercicioFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EjercicioFinal_Off.png"))); // NOI18N
        Btn_Siguiente_EjercicioFinal.setBorder(null);
        Btn_Siguiente_EjercicioFinal.setBorderPainted(false);
        Btn_Siguiente_EjercicioFinal.setContentAreaFilled(false);
        Btn_Siguiente_EjercicioFinal.setFocusPainted(false);
        Btn_Siguiente_EjercicioFinal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_EjercicioFinal.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_EjercicioFinal.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_EjercicioFinal.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Siguiente_EjercicioFinal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EjercicioFinal_On.png"))); // NOI18N
        Btn_Siguiente_EjercicioFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_EjercicioFinalActionPerformed(evt);
            }
        });
        Pnl_Cuestionario14.add(Btn_Siguiente_EjercicioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Header_Aprender32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Cuestionario14.add(Lbl_Header_Aprender32, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_Cuestionario14.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_Cuestionario14.setText("Primeros Algoritmos | Cuestionario");
        Pnl_Cuestionario14.add(Lbl_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 30));

        Scp_Cuestionario14.setViewportView(Pnl_Cuestionario14);

        Pnl_Aprender.add(Scp_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Scp_Ejercicio3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Ejercicio3.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Ejercicio3.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Ejercicio3.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Ejercicio3_Aprender.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Ejercicio3_Aprender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pnl_Ejercicio3_Aprender.setMaximumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Ejercicio3_Aprender.setMinimumSize(new java.awt.Dimension(1155, 1500));
        Pnl_Ejercicio3_Aprender.setPreferredSize(new java.awt.Dimension(1155, 1500));
        Pnl_Ejercicio3_Aprender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario14_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario14.setBorder(null);
        Btn_Anterior_Cuestionario14.setBorderPainted(false);
        Btn_Anterior_Cuestionario14.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario14.setFocusPainted(false);
        Btn_Anterior_Cuestionario14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario14.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario14.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario14.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Anterior_Cuestionario14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario14_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario14ActionPerformed(evt);
            }
        });
        Pnl_Ejercicio3_Aprender.add(Btn_Anterior_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Lbl_Header_Aprender35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Ejercicio3_Aprender.add(Lbl_Header_Aprender35, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_EjercicioFinal.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Lbl_EjercicioFinal.setText("Ejercicio Final");
        Pnl_Ejercicio3_Aprender.add(Lbl_EjercicioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 40));

        Scp_Ejercicio3.setViewportView(Pnl_Ejercicio3_Aprender);

        Pnl_Aprender.add(Scp_Ejercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Pnl_Principal.add(Pnl_Aprender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1176, 705));

        Pnl_CodeStorm.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_CodeStorm.setMaximumSize(new java.awt.Dimension(1176, 706));
        Pnl_CodeStorm.setMinimumSize(new java.awt.Dimension(1176, 706));
        Pnl_CodeStorm.setPreferredSize(new java.awt.Dimension(1176, 706));
        Pnl_CodeStorm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_ListadoEjercicios.setMaximumSize(new java.awt.Dimension(1176, 705));
        Pnl_ListadoEjercicios.setPreferredSize(new java.awt.Dimension(1176, 705));
        Pnl_ListadoEjercicios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_CodeStorm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_CodeStorm.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_Header_CodeStorm, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Btn_Introduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Introduccion_Off.png"))); // NOI18N
        Btn_Introduccion.setBorderPainted(false);
        Btn_Introduccion.setContentAreaFilled(false);
        Btn_Introduccion.setFocusPainted(false);
        Btn_Introduccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Introduccion.setMaximumSize(new java.awt.Dimension(202, 62));
        Btn_Introduccion.setMinimumSize(new java.awt.Dimension(202, 62));
        Btn_Introduccion.setPreferredSize(new java.awt.Dimension(202, 62));
        Btn_Introduccion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Introduccion_On.png"))); // NOI18N
        Btn_Introduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_IntroduccionActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Introduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 202, 62));

        Btn_Nivel1_Ejercicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio1_Off.png"))); // NOI18N
        Btn_Nivel1_Ejercicio1.setBorderPainted(false);
        Btn_Nivel1_Ejercicio1.setContentAreaFilled(false);
        Btn_Nivel1_Ejercicio1.setFocusPainted(false);
        Btn_Nivel1_Ejercicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel1_Ejercicio1.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio1.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio1.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio1_On.png"))); // NOI18N
        Btn_Nivel1_Ejercicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel1_Ejercicio1ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel1_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 142, 52));

        Btn_Nivel1_Ejercicio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio2_Off.png"))); // NOI18N
        Btn_Nivel1_Ejercicio2.setBorderPainted(false);
        Btn_Nivel1_Ejercicio2.setContentAreaFilled(false);
        Btn_Nivel1_Ejercicio2.setFocusPainted(false);
        Btn_Nivel1_Ejercicio2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel1_Ejercicio2.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio2.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio2.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio2_On.png"))); // NOI18N
        Btn_Nivel1_Ejercicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel1_Ejercicio2ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel1_Ejercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 142, 52));

        Btn_Nivel1_Ejercicio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio3_Off.png"))); // NOI18N
        Btn_Nivel1_Ejercicio3.setBorderPainted(false);
        Btn_Nivel1_Ejercicio3.setContentAreaFilled(false);
        Btn_Nivel1_Ejercicio3.setFocusPainted(false);
        Btn_Nivel1_Ejercicio3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel1_Ejercicio3.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio3.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio3.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio3_On.png"))); // NOI18N
        Btn_Nivel1_Ejercicio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel1_Ejercicio3ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel1_Ejercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 142, 52));

        Btn_Nivel1_Ejercicio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio4_Off.png"))); // NOI18N
        Btn_Nivel1_Ejercicio4.setBorderPainted(false);
        Btn_Nivel1_Ejercicio4.setContentAreaFilled(false);
        Btn_Nivel1_Ejercicio4.setFocusPainted(false);
        Btn_Nivel1_Ejercicio4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel1_Ejercicio4.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio4.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio4.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel1_Ejercicio4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio4_On.png"))); // NOI18N
        Btn_Nivel1_Ejercicio4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel1_Ejercicio4ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel1_Ejercicio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 142, 52));

        Btn_Nivel2_Ejercicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio1_Off.png"))); // NOI18N
        Btn_Nivel2_Ejercicio1.setBorderPainted(false);
        Btn_Nivel2_Ejercicio1.setContentAreaFilled(false);
        Btn_Nivel2_Ejercicio1.setFocusPainted(false);
        Btn_Nivel2_Ejercicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel2_Ejercicio1.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio1.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio1.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio1_On.png"))); // NOI18N
        Btn_Nivel2_Ejercicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel2_Ejercicio1ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel2_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 142, 52));

        Btn_Nivel2_Ejercicio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio2_Off.png"))); // NOI18N
        Btn_Nivel2_Ejercicio2.setBorderPainted(false);
        Btn_Nivel2_Ejercicio2.setContentAreaFilled(false);
        Btn_Nivel2_Ejercicio2.setFocusPainted(false);
        Btn_Nivel2_Ejercicio2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel2_Ejercicio2.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio2.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio2.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio2_On.png"))); // NOI18N
        Btn_Nivel2_Ejercicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel2_Ejercicio2ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel2_Ejercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 142, 52));

        Btn_Nivel2_Ejercicio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio3_Off.png"))); // NOI18N
        Btn_Nivel2_Ejercicio3.setBorderPainted(false);
        Btn_Nivel2_Ejercicio3.setContentAreaFilled(false);
        Btn_Nivel2_Ejercicio3.setFocusPainted(false);
        Btn_Nivel2_Ejercicio3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel2_Ejercicio3.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio3.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio3.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio3_On.png"))); // NOI18N
        Btn_Nivel2_Ejercicio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel2_Ejercicio3ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel2_Ejercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 142, 52));

        Btn_Nivel2_Ejercicio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio4_Off.png"))); // NOI18N
        Btn_Nivel2_Ejercicio4.setBorderPainted(false);
        Btn_Nivel2_Ejercicio4.setContentAreaFilled(false);
        Btn_Nivel2_Ejercicio4.setFocusPainted(false);
        Btn_Nivel2_Ejercicio4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel2_Ejercicio4.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio4.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio4.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel2_Ejercicio4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio4_On.png"))); // NOI18N
        Btn_Nivel2_Ejercicio4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel2_Ejercicio4ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel2_Ejercicio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 590, 142, 52));

        Btn_Nivel3_Ejercicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio1_Off.png"))); // NOI18N
        Btn_Nivel3_Ejercicio1.setBorderPainted(false);
        Btn_Nivel3_Ejercicio1.setContentAreaFilled(false);
        Btn_Nivel3_Ejercicio1.setFocusPainted(false);
        Btn_Nivel3_Ejercicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel3_Ejercicio1.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio1.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio1.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio1_On.png"))); // NOI18N
        Btn_Nivel3_Ejercicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel3_Ejercicio1ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel3_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, 142, 52));

        Btn_Nivel3_Ejercicio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio2_Off.png"))); // NOI18N
        Btn_Nivel3_Ejercicio2.setBorderPainted(false);
        Btn_Nivel3_Ejercicio2.setContentAreaFilled(false);
        Btn_Nivel3_Ejercicio2.setFocusPainted(false);
        Btn_Nivel3_Ejercicio2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel3_Ejercicio2.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio2.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio2.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio2_On.png"))); // NOI18N
        Btn_Nivel3_Ejercicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel3_Ejercicio2ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel3_Ejercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 142, 52));

        Btn_Nivel3_Ejercicio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio3_Off.png"))); // NOI18N
        Btn_Nivel3_Ejercicio3.setBorderPainted(false);
        Btn_Nivel3_Ejercicio3.setContentAreaFilled(false);
        Btn_Nivel3_Ejercicio3.setFocusPainted(false);
        Btn_Nivel3_Ejercicio3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel3_Ejercicio3.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio3.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio3.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio3_On.png"))); // NOI18N
        Btn_Nivel3_Ejercicio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel3_Ejercicio3ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel3_Ejercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 142, 52));

        Btn_Nivel3_Ejercicio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio4_Off.png"))); // NOI18N
        Btn_Nivel3_Ejercicio4.setBorderPainted(false);
        Btn_Nivel3_Ejercicio4.setContentAreaFilled(false);
        Btn_Nivel3_Ejercicio4.setFocusPainted(false);
        Btn_Nivel3_Ejercicio4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel3_Ejercicio4.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio4.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio4.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel3_Ejercicio4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio4_On.png"))); // NOI18N
        Btn_Nivel3_Ejercicio4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel3_Ejercicio4ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel3_Ejercicio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 590, 142, 52));

        Btn_Nivel4_Ejercicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio1_Off.png"))); // NOI18N
        Btn_Nivel4_Ejercicio1.setBorderPainted(false);
        Btn_Nivel4_Ejercicio1.setContentAreaFilled(false);
        Btn_Nivel4_Ejercicio1.setFocusPainted(false);
        Btn_Nivel4_Ejercicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel4_Ejercicio1.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio1.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio1.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio1_On.png"))); // NOI18N
        Btn_Nivel4_Ejercicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel4_Ejercicio1ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel4_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, 142, 52));

        Btn_Nivel4_Ejercicio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio2_Off.png"))); // NOI18N
        Btn_Nivel4_Ejercicio2.setBorderPainted(false);
        Btn_Nivel4_Ejercicio2.setContentAreaFilled(false);
        Btn_Nivel4_Ejercicio2.setFocusPainted(false);
        Btn_Nivel4_Ejercicio2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel4_Ejercicio2.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio2.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio2.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio2_On.png"))); // NOI18N
        Btn_Nivel4_Ejercicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel4_Ejercicio2ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel4_Ejercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 142, 52));

        Btn_Nivel4_Ejercicio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio3_Off.png"))); // NOI18N
        Btn_Nivel4_Ejercicio3.setBorderPainted(false);
        Btn_Nivel4_Ejercicio3.setContentAreaFilled(false);
        Btn_Nivel4_Ejercicio3.setFocusPainted(false);
        Btn_Nivel4_Ejercicio3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel4_Ejercicio3.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio3.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio3.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio3_On.png"))); // NOI18N
        Btn_Nivel4_Ejercicio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel4_Ejercicio3ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel4_Ejercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 142, 52));

        Btn_Nivel4_Ejercicio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio4_Off.png"))); // NOI18N
        Btn_Nivel4_Ejercicio4.setBorderPainted(false);
        Btn_Nivel4_Ejercicio4.setContentAreaFilled(false);
        Btn_Nivel4_Ejercicio4.setFocusPainted(false);
        Btn_Nivel4_Ejercicio4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel4_Ejercicio4.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio4.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio4.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel4_Ejercicio4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio4_On.png"))); // NOI18N
        Btn_Nivel4_Ejercicio4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel4_Ejercicio4ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel4_Ejercicio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, 142, 52));

        Btn_Nivel5_Ejercicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio1_Off.png"))); // NOI18N
        Btn_Nivel5_Ejercicio1.setBorderPainted(false);
        Btn_Nivel5_Ejercicio1.setContentAreaFilled(false);
        Btn_Nivel5_Ejercicio1.setFocusPainted(false);
        Btn_Nivel5_Ejercicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel5_Ejercicio1.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio1.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio1.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio1_On.png"))); // NOI18N
        Btn_Nivel5_Ejercicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel5_Ejercicio1ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel5_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 350, 142, 52));

        Btn_Nivel5_Ejercicio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio2_Off.png"))); // NOI18N
        Btn_Nivel5_Ejercicio2.setBorderPainted(false);
        Btn_Nivel5_Ejercicio2.setContentAreaFilled(false);
        Btn_Nivel5_Ejercicio2.setFocusPainted(false);
        Btn_Nivel5_Ejercicio2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel5_Ejercicio2.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio2.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio2.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio2_On.png"))); // NOI18N
        Btn_Nivel5_Ejercicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel5_Ejercicio2ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel5_Ejercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 430, 142, 52));

        Btn_Nivel5_Ejercicio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio3_Off.png"))); // NOI18N
        Btn_Nivel5_Ejercicio3.setBorderPainted(false);
        Btn_Nivel5_Ejercicio3.setContentAreaFilled(false);
        Btn_Nivel5_Ejercicio3.setFocusPainted(false);
        Btn_Nivel5_Ejercicio3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel5_Ejercicio3.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio3.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio3.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio3_On.png"))); // NOI18N
        Btn_Nivel5_Ejercicio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel5_Ejercicio3ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel5_Ejercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 510, 142, 52));

        Btn_Nivel5_Ejercicio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio4_Off.png"))); // NOI18N
        Btn_Nivel5_Ejercicio4.setBorderPainted(false);
        Btn_Nivel5_Ejercicio4.setContentAreaFilled(false);
        Btn_Nivel5_Ejercicio4.setFocusPainted(false);
        Btn_Nivel5_Ejercicio4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Nivel5_Ejercicio4.setMaximumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio4.setMinimumSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio4.setPreferredSize(new java.awt.Dimension(142, 52));
        Btn_Nivel5_Ejercicio4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio4_On.png"))); // NOI18N
        Btn_Nivel5_Ejercicio4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Nivel5_Ejercicio4ActionPerformed(evt);
            }
        });
        Pnl_ListadoEjercicios.add(Btn_Nivel5_Ejercicio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 590, 142, 52));

        Lbl_Nivel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Nivel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Nivel1.png"))); // NOI18N
        Lbl_Nivel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_ListadoEjercicios.add(Lbl_Nivel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 180, 50));

        Lbl_Nivel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Nivel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Nivel2.png"))); // NOI18N
        Lbl_Nivel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_ListadoEjercicios.add(Lbl_Nivel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 180, 50));

        Lbl_Nivel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Nivel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Nivel3.png"))); // NOI18N
        Lbl_Nivel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_ListadoEjercicios.add(Lbl_Nivel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 180, 50));

        Lbl_Nivel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Nivel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Nivel4.png"))); // NOI18N
        Lbl_Nivel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_ListadoEjercicios.add(Lbl_Nivel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 180, 50));

        Lbl_Nivel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Nivel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Nivel5.png"))); // NOI18N
        Lbl_Nivel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_ListadoEjercicios.add(Lbl_Nivel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 270, 180, 50));

        Lbl_BarraProgreso_Nivel1_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_0.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel1_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 17, 290));

        Lbl_BarraProgreso_Nivel1_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_1.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 17, 290));

        Lbl_BarraProgreso_Nivel1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_2.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 17, 290));

        Lbl_BarraProgreso_Nivel1_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_3.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 17, 290));

        Lbl_BarraProgreso_Nivel1_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_4.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 17, 290));

        Lbl_BarraProgreso_Nivel2_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_0.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel2_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 17, 290));

        Lbl_BarraProgreso_Nivel2_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_1.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 17, 290));

        Lbl_BarraProgreso_Nivel2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_2.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 17, 290));

        Lbl_BarraProgreso_Nivel2_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_3.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 17, 290));

        Lbl_BarraProgreso_Nivel2_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_4.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 17, 290));

        Lbl_BarraProgreso_Nivel3_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_0.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel3_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 17, 290));

        Lbl_BarraProgreso_Nivel3_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_1.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 17, 290));

        Lbl_BarraProgreso_Nivel3_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_2.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 17, 290));

        Lbl_BarraProgreso_Nivel3_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_3.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 17, 290));

        Lbl_BarraProgreso_Nivel3_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_4.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 17, 290));

        Lbl_BarraProgreso_Nivel4_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_0.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel4_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 17, 290));

        Lbl_BarraProgreso_Nivel4_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_1.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 17, 290));

        Lbl_BarraProgreso_Nivel4_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_2.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 17, 290));

        Lbl_BarraProgreso_Nivel4_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_3.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 17, 290));

        Lbl_BarraProgreso_Nivel4_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_4.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel4_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 17, 290));

        Lbl_BarraProgreso_Nivel5_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_0.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel5_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 17, 290));

        Lbl_BarraProgreso_Nivel5_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_1.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel5_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 17, 290));

        Lbl_BarraProgreso_Nivel5_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_2.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 17, 290));

        Lbl_BarraProgreso_Nivel5_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_3.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 17, 290));

        Lbl_BarraProgreso_Nivel5_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/BarraProgreso_4.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_BarraProgreso_Nivel5_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 17, 290));

        Lbl_CodeStorm_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Apolo_CodeStorm_Fondo.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_CodeStorm_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_CodeStorm.add(Pnl_ListadoEjercicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, -1));

        Scp_Introduccion.setBackground(new java.awt.Color(237, 234, 243));
        Scp_Introduccion.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Introduccion.setMaximumSize(new java.awt.Dimension(1176, 706));
        Scp_Introduccion.setMinimumSize(new java.awt.Dimension(1176, 706));
        Scp_Introduccion.setName(""); // NOI18N
        Scp_Introduccion.setPreferredSize(new java.awt.Dimension(1176, 706));

        Pnl_Introduccion.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Introduccion.setMaximumSize(new java.awt.Dimension(1176, 4000));
        Pnl_Introduccion.setMinimumSize(new java.awt.Dimension(1176, 4000));
        Pnl_Introduccion.setPreferredSize(new java.awt.Dimension(1176, 4000));
        Pnl_Introduccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_CodeStorm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_CodeStorm.png"))); // NOI18N
        Pnl_Introduccion.add(Lbl_Header_CodeStorm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Btn_Introduccion_Siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Siguiente_Ejercicios_Off.png"))); // NOI18N
        Btn_Introduccion_Siguiente.setBorderPainted(false);
        Btn_Introduccion_Siguiente.setContentAreaFilled(false);
        Btn_Introduccion_Siguiente.setFocusPainted(false);
        Btn_Introduccion_Siguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Introduccion_Siguiente.setMaximumSize(new java.awt.Dimension(254, 64));
        Btn_Introduccion_Siguiente.setMinimumSize(new java.awt.Dimension(254, 64));
        Btn_Introduccion_Siguiente.setPreferredSize(new java.awt.Dimension(254, 64));
        Btn_Introduccion_Siguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Siguiente_Ejercicios_On.png"))); // NOI18N
        Btn_Introduccion_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Introduccion_SiguienteActionPerformed(evt);
            }
        });
        Pnl_Introduccion.add(Btn_Introduccion_Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 3900, 254, 64));

        Scp_Introduccion.setViewportView(Pnl_Introduccion);

        Pnl_CodeStorm.add(Scp_Introduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Pnl_General.setMaximumSize(new java.awt.Dimension(1176, 705));
        Pnl_General.setMinimumSize(new java.awt.Dimension(1176, 705));
        Pnl_General.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Header.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_CodeStorm2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_CodeStorm.png"))); // NOI18N
        Pnl_Header.add(Lbl_Header_CodeStorm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Pnl_General.add(Pnl_Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 90));

        Pnl_BotonesPrincipales.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_BotonesPrincipales.setMaximumSize(new java.awt.Dimension(916, 70));
        Pnl_BotonesPrincipales.setMinimumSize(new java.awt.Dimension(916, 70));
        Pnl_BotonesPrincipales.setPreferredSize(new java.awt.Dimension(916, 70));
        Pnl_BotonesPrincipales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Ejercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio_Off.png"))); // NOI18N
        Btn_Ejercicio.setBorderPainted(false);
        Btn_Ejercicio.setContentAreaFilled(false);
        Btn_Ejercicio.setFocusPainted(false);
        Btn_Ejercicio.setFocusable(false);
        Btn_Ejercicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Ejercicio.setMaximumSize(new java.awt.Dimension(172, 47));
        Btn_Ejercicio.setMinimumSize(new java.awt.Dimension(172, 47));
        Btn_Ejercicio.setPreferredSize(new java.awt.Dimension(172, 47));
        Btn_Ejercicio.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio_On.png"))); // NOI18N
        Btn_Ejercicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio_On.png"))); // NOI18N
        Btn_Ejercicio.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio_Enabled.png"))); // NOI18N
        Btn_Ejercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EjercicioActionPerformed(evt);
            }
        });
        Pnl_BotonesPrincipales.add(Btn_Ejercicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 172, 47));

        Btn_Codigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Codigo_Off.png"))); // NOI18N
        Btn_Codigo.setBorderPainted(false);
        Btn_Codigo.setContentAreaFilled(false);
        Btn_Codigo.setFocusPainted(false);
        Btn_Codigo.setFocusable(false);
        Btn_Codigo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Codigo.setMaximumSize(new java.awt.Dimension(172, 47));
        Btn_Codigo.setMinimumSize(new java.awt.Dimension(172, 47));
        Btn_Codigo.setPreferredSize(new java.awt.Dimension(172, 47));
        Btn_Codigo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Codigo_On.png"))); // NOI18N
        Btn_Codigo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Codigo_On.png"))); // NOI18N
        Btn_Codigo.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Codigo_Enabled.png"))); // NOI18N
        Btn_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CodigoActionPerformed(evt);
            }
        });
        Pnl_BotonesPrincipales.add(Btn_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 172, 47));

        Btn_Enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Enviar_Off.png"))); // NOI18N
        Btn_Enviar.setBorderPainted(false);
        Btn_Enviar.setContentAreaFilled(false);
        Btn_Enviar.setFocusPainted(false);
        Btn_Enviar.setFocusable(false);
        Btn_Enviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Enviar.setMaximumSize(new java.awt.Dimension(172, 47));
        Btn_Enviar.setMinimumSize(new java.awt.Dimension(172, 47));
        Btn_Enviar.setPreferredSize(new java.awt.Dimension(172, 47));
        Btn_Enviar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Enviar_On.png"))); // NOI18N
        Btn_Enviar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Enviar_On.png"))); // NOI18N
        Btn_Enviar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Enviar_Enabled.png"))); // NOI18N
        Btn_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EnviarActionPerformed(evt);
            }
        });
        Pnl_BotonesPrincipales.add(Btn_Enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 172, 47));

        Btn_Solucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Solucion_Off.png"))); // NOI18N
        Btn_Solucion.setBorderPainted(false);
        Btn_Solucion.setContentAreaFilled(false);
        Btn_Solucion.setFocusPainted(false);
        Btn_Solucion.setFocusable(false);
        Btn_Solucion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Solucion.setMaximumSize(new java.awt.Dimension(172, 47));
        Btn_Solucion.setMinimumSize(new java.awt.Dimension(172, 47));
        Btn_Solucion.setPreferredSize(new java.awt.Dimension(172, 47));
        Btn_Solucion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Solucion_On.png"))); // NOI18N
        Btn_Solucion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Solucion_On.png"))); // NOI18N
        Btn_Solucion.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Solucion_Enabled.png"))); // NOI18N
        Btn_Solucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SolucionActionPerformed(evt);
            }
        });
        Pnl_BotonesPrincipales.add(Btn_Solucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 172, 47));

        Btn_Atras_CodeStorm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Atras_Off.png"))); // NOI18N
        Btn_Atras_CodeStorm.setBorder(null);
        Btn_Atras_CodeStorm.setBorderPainted(false);
        Btn_Atras_CodeStorm.setContentAreaFilled(false);
        Btn_Atras_CodeStorm.setFocusPainted(false);
        Btn_Atras_CodeStorm.setFocusable(false);
        Btn_Atras_CodeStorm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Atras_CodeStorm.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Atras_On_CodeStorm.png"))); // NOI18N
        Btn_Atras_CodeStorm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Atras_CodeStormActionPerformed(evt);
            }
        });
        Pnl_BotonesPrincipales.add(Btn_Atras_CodeStorm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 82, 47));

        Pnl_General.add(Pnl_BotonesPrincipales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 916, 70));

        Pnl_Navegacion.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Navegacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Siguiente_Off.png"))); // NOI18N
        Btn_Siguiente.setBorderPainted(false);
        Btn_Siguiente.setContentAreaFilled(false);
        Btn_Siguiente.setFocusPainted(false);
        Btn_Siguiente.setFocusable(false);
        Btn_Siguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Siguiente_On.png"))); // NOI18N
        Btn_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SiguienteActionPerformed(evt);
            }
        });
        Pnl_Navegacion.add(Btn_Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 82, 47));

        Btn_Anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Anterior_Off.png"))); // NOI18N
        Btn_Anterior.setBorderPainted(false);
        Btn_Anterior.setContentAreaFilled(false);
        Btn_Anterior.setFocusPainted(false);
        Btn_Anterior.setFocusable(false);
        Btn_Anterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Anterior_On.png"))); // NOI18N
        Btn_Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AnteriorActionPerformed(evt);
            }
        });
        Pnl_Navegacion.add(Btn_Anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 82, 47));

        Pnl_General.add(Pnl_Navegacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(916, 90, 260, 70));

        Pnl_Main.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_EjercicioFull.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_EjercicioFull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Scp_EjerciciosFull.setBackground(new java.awt.Color(237, 234, 243));
        Scp_EjerciciosFull.setBorder(null);

        Lbl_Ejercicio1.setBackground(new java.awt.Color(237, 234, 243));
        Lbl_Ejercicio1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        Lbl_Ejercicio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Ejercicio1.setText("Aqui van los ejercicios");
        Lbl_Ejercicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lbl_Ejercicio1.setOpaque(true);
        Scp_EjerciciosFull.setViewportView(Lbl_Ejercicio1);

        Pnl_EjercicioFull.add(Scp_EjerciciosFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1090, 440));

        Pnl_Main.add(Pnl_EjercicioFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 1110, 510));

        Pnl_CodigoFull.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_CodigoFull.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true), " Nivel 1 | Ejercicio 1 ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 30), new java.awt.Color(204, 0, 0))); // NOI18N
        Pnl_CodigoFull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_SyntaxCode.setLayout(new java.awt.BorderLayout());
        Pnl_CodigoFull.add(Pnl_SyntaxCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1080, 430));

        Pnl_Main.add(Pnl_CodigoFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 1110, 510));

        Pnl_SolucionFull.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_SolucionFull.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true), " Nivel 1 | Ejercicio 1 ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 30), new java.awt.Color(204, 0, 0))); // NOI18N
        Pnl_SolucionFull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_SyntaxSolution.setLayout(new java.awt.BorderLayout());
        Pnl_SolucionFull.add(Pnl_SyntaxSolution, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1080, 430));

        Pnl_Main.add(Pnl_SolucionFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 1110, 510));

        Pnl_General.add(Pnl_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1176, 545));

        Pnl_CodeStorm.add(Pnl_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Principal.add(Pnl_CodeStorm, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1176, 706));

        Pnl_Historia.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Historia.setMaximumSize(new java.awt.Dimension(1176, 705));
        Pnl_Historia.setMinimumSize(new java.awt.Dimension(1176, 705));
        Pnl_Historia.setPreferredSize(new java.awt.Dimension(1176, 705));
        Pnl_Historia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Pagina1.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Pagina1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Aprender11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Historia.png"))); // NOI18N
        Pnl_Pagina1.add(Lbl_Header_Aprender11, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Lbl_QueEs.setText("¿Qué es la Programación Competitiva?");
        Pnl_Pagina1.add(Lbl_QueEs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 590, 70));

        Scp_QueEs.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_QueEs.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Txa_QueEs.setEditable(false);
        Txa_QueEs.setBackground(new java.awt.Color(237, 234, 243));
        Txa_QueEs.setColumns(20);
        Txa_QueEs.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Txa_QueEs.setLineWrap(true);
        Txa_QueEs.setRows(5);
        Txa_QueEs.setTabSize(4);
        Txa_QueEs.setText("La Programación Competitiva es un deporte mental que generalmente se realiza a través de Internet y en algunas ocasiones de manera presencial. Los competidores deben resolver una gran variedad de problemas de programación en un tiempo estipulado siguiendo reglas ya preestablecidas. La persona o equipo ganador será quien resuelva la mayor cantidad de problemas en el menor tiempo posible. De igual forma, se evalúan conceptos como el uso de memoria y tiempo de ejecución del programa.");
        Txa_QueEs.setWrapStyleWord(true);
        Scp_QueEs.setViewportView(Txa_QueEs);

        Pnl_Pagina1.add(Scp_QueEs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 1100, 150));

        Lbl_Competencias.setText("Competencias de Programación");
        Pnl_Pagina1.add(Lbl_Competencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 590, 70));

        Scp_Competencias.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Competencias.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Txa_Competencias.setEditable(false);
        Txa_Competencias.setBackground(new java.awt.Color(237, 234, 243));
        Txa_Competencias.setColumns(20);
        Txa_Competencias.setLineWrap(true);
        Txa_Competencias.setRows(5);
        Txa_Competencias.setTabSize(4);
        Txa_Competencias.setText("En la actualidad existen un gran número de competencias de programación organizadas por distintas empresas y organizaciones, cada una con formatos distintos, ya sea en tiempo, lugar, accesibilidad, premios, entre otros. A continuación se describirán las competencias más importantes que deberías tener en cuenta:");
        Txa_Competencias.setWrapStyleWord(true);
        Scp_Competencias.setViewportView(Txa_Competencias);

        Pnl_Pagina1.add(Scp_Competencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 1100, 160));

        Pnl_Historia.add(Pnl_Pagina1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Pagina2.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Pagina2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Aprender12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Historia.png"))); // NOI18N
        Pnl_Pagina2.add(Lbl_Header_Aprender12, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Pnl_Historia.add(Pnl_Pagina2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Pagina3.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Pagina3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Aprender13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Historia.png"))); // NOI18N
        Pnl_Pagina3.add(Lbl_Header_Aprender13, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Pnl_Historia.add(Pnl_Pagina3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Pagina4.setBackground(new java.awt.Color(237, 234, 243));
        Pnl_Pagina4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Aprender14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Apolo_Header_Historia.png"))); // NOI18N
        Pnl_Pagina4.add(Lbl_Header_Aprender14, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Pnl_Historia.add(Pnl_Pagina4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Principal.add(Pnl_Historia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1176, 705));

        getContentPane().add(Pnl_Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void Btn_AjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AjustesActionPerformed
        // Habilitar Ventana de Ajustes
        if (evt.getSource() == Btn_Ajustes) {
            Btn_Ajustes.setSelected(false);
            Ajustes.setVisible(true);
        }
    }//GEN-LAST:event_Btn_AjustesActionPerformed

    private void Btn_CodeStormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CodeStormActionPerformed
        if (Btn_CodeStorm.isSelected()) {
            apagarSecciones(3);
            habilitarBotonesCodeStorm();
//            ocultarPanelesEjercicios();

            // Paneles Internos
            Pnl_CodeStorm.setVisible(true);
            Pnl_ListadoEjercicios.setVisible(true);
            Scp_Introduccion.setVisible(false);
            Pnl_General.setVisible(false);

            // Paneles Principales
            Pnl_Aprender.setVisible(false);
//            Pnl_Programar.setVisible(false);
            Pnl_Historia.setVisible(false);
            Pnl_Home.setVisible(false);
        } else {
            Pnl_CodeStorm.setVisible(false);
            Pnl_Home.setVisible(true);
        }
    }//GEN-LAST:event_Btn_CodeStormActionPerformed

    private void Btn_AprenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AprenderActionPerformed
        if (Btn_Aprender.isSelected()) {
            apagarSecciones(1);
            habilitarBotonesAprender();

            Pnl_Aprender.setVisible(true);
            Pnl_Mapa.setVisible(true);

            // Ocultar componentes internos del Panel de Aprender
            for (Component scrollpane : Pnl_Aprender.getComponents()) {
                if (scrollpane instanceof JScrollPane) {
                    ((JScrollPane) scrollpane).setVisible(false);
                }
            }
        } else {
            Pnl_Aprender.setVisible(false);
            Pnl_Home.setVisible(true);
        }
    }//GEN-LAST:event_Btn_AprenderActionPerformed

    private void Btn_ProgramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ProgramarActionPerformed
        if (Btn_Programar.isSelected()) {
            apagarSecciones(2);
            EditorDeCodigo edc = new EditorDeCodigo();
            edc.setVisible(true);
        } else {
//          Pnl_Programar.setVisible(false);
            Pnl_Home.setVisible(true);
        }
    }//GEN-LAST:event_Btn_ProgramarActionPerformed

    private void Btn_HistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_HistoriaActionPerformed
        if (Btn_Historia.isSelected()) {
            apagarSecciones(4);
            habilitarBotonesHistoria();
            Pnl_Historia.setVisible(true);

            // Paneles Principales
            Pnl_Home.setVisible(false);
            Pnl_Aprender.setVisible(false);
//            Pnl_Programar.setVisible(false);
            Pnl_CodeStorm.setVisible(false);
        } else {
            Pnl_Historia.setVisible(false);
            Pnl_Home.setVisible(true);
        }
    }//GEN-LAST:event_Btn_HistoriaActionPerformed


    private void Btn_Aprender_Tema1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema1ActionPerformed
        Scp_Tema1.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema1ActionPerformed

    private void Btn_Aprender_Tema2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema2ActionPerformed
        Scp_Tema2.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema2ActionPerformed

    private void Btn_Aprender_Tema3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema3ActionPerformed
        Scp_Tema3.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema3ActionPerformed

    private void Btn_Aprender_Tema4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema4ActionPerformed
        Scp_Tema4.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema4ActionPerformed

    private void Btn_Aprender_Tema5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema5ActionPerformed
        Scp_Tema5.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema5ActionPerformed

    private void Btn_Aprender_Tema6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema6ActionPerformed
        Scp_Tema6.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema6ActionPerformed

    private void Btn_Aprender_Tema7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema7ActionPerformed
        Scp_Tema7.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema7ActionPerformed

    private void Btn_Aprender_Tema8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema8ActionPerformed
        Scp_Tema8.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema8ActionPerformed

    private void Btn_Aprender_Tema9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema9ActionPerformed
        Scp_Tema9.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema9ActionPerformed

    private void Btn_Aprender_Tema10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema10ActionPerformed
        Scp_Tema10.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema10ActionPerformed

    private void Btn_Aprender_Tema11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema11ActionPerformed
        Scp_Tema11.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema11ActionPerformed

    private void Btn_Aprender_Tema12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema12ActionPerformed
        Scp_Tema12.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema12ActionPerformed

    private void Btn_Aprender_Tema13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema13ActionPerformed
        Scp_Tema13.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema13ActionPerformed

    private void Btn_Aprender_Tema14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema14ActionPerformed
        Scp_Tema14.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Tema14ActionPerformed

    private void Btn_Siguiente_Cuestionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario1ActionPerformed
        Scp_Tema1.setVisible(false);
        Scp_Cuestionario1.setVisible(true);
        tp = new Tips();
        tp.setVisible(true);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario1ActionPerformed

    private void Btn_Anterior_HelloWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_HelloWordActionPerformed
        Scp_Tema1.setVisible(true);
        Scp_Cuestionario1.setVisible(false);
        tp = new Tips();
        tp.setVisible(true);
    }//GEN-LAST:event_Btn_Anterior_HelloWordActionPerformed

    private void Btn_Siguiente_ComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_ComentariosActionPerformed
        Scp_Tema2.setVisible(true);
        Scp_Cuestionario1.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_ComentariosActionPerformed

    private void Btn_Anterior_Cuestionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario1ActionPerformed
        Scp_Cuestionario1.setVisible(true);
        Scp_Tema2.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario1ActionPerformed

    private void Btn_Siguiente_Cuestionario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario2ActionPerformed
        Scp_Cuestionario2.setVisible(true);
        Scp_Tema2.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario2ActionPerformed

    private void Btn_Anterior_ComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_ComentariosActionPerformed
        Scp_Tema2.setVisible(true);
        Scp_Cuestionario2.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_ComentariosActionPerformed

    private void Btn_Siguiente_TiposdeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_TiposdeDatosActionPerformed
        Scp_Tema3.setVisible(true);
        Scp_Cuestionario2.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_TiposdeDatosActionPerformed

    private void Btn_Anterior_Cuestionario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario2ActionPerformed
        Scp_Cuestionario2.setVisible(true);
        Scp_Tema3.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario2ActionPerformed

    private void Btn_Siguiente_Cuestionario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario3ActionPerformed
        Scp_Cuestionario3.setVisible(true);
        Scp_Tema3.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario3ActionPerformed

    private void Btn_Anterior_TiposdeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_TiposdeDatosActionPerformed
        Scp_Tema3.setVisible(true);
        Scp_Cuestionario3.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_TiposdeDatosActionPerformed

    private void Btn_Siguiente_OperadoresAritmeticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_OperadoresAritmeticosActionPerformed
        Scp_Tema4.setVisible(true);
        Scp_Cuestionario3.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_OperadoresAritmeticosActionPerformed

    private void Btn_Anterior_Cuestionario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario3ActionPerformed
        Scp_Cuestionario3.setVisible(true);
        Scp_Tema4.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario3ActionPerformed

    private void Btn_Siguiente_Cuestionario4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario4ActionPerformed
        Scp_Cuestionario4.setVisible(true);
        Scp_Tema4.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario4ActionPerformed

    private void Btn_Anterior_OperadoresAritmeticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_OperadoresAritmeticosActionPerformed
        Scp_Tema4.setVisible(true);
        Scp_Cuestionario4.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_OperadoresAritmeticosActionPerformed

    private void Btn_Siguiente_LecturaeImpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_LecturaeImpresionActionPerformed
        Scp_Tema5.setVisible(true);
        Scp_Cuestionario4.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_LecturaeImpresionActionPerformed

    private void Btn_Anterior_Cuestionario4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario4ActionPerformed
        Scp_Cuestionario4.setVisible(true);
        Scp_Tema5.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario4ActionPerformed

    private void Btn_Siguiente_Cuestionario5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario5ActionPerformed
        Scp_Cuestionario5.setVisible(true);
        Scp_Tema5.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario5ActionPerformed

    private void Btn_Nivel1_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel1_Ejercicio1ActionPerformed
        Pnl_Main.setVisible(true);
        contador = 0;
        aux = 1;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel1_Ejercicio1ActionPerformed

    private void Btn_Nivel1_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel1_Ejercicio2ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 1;
        aux = 2;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel1_Ejercicio2ActionPerformed

    private void Btn_Nivel1_Ejercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel1_Ejercicio3ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 2;
        aux = 3;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel1_Ejercicio3ActionPerformed

    private void Btn_Nivel1_Ejercicio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel1_Ejercicio4ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 3;
        aux = 4;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel1_Ejercicio4ActionPerformed

    private void Btn_IntroduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_IntroduccionActionPerformed
        Scp_Introduccion.setVisible(true);
        Pnl_ListadoEjercicios.setVisible(false);
    }//GEN-LAST:event_Btn_IntroduccionActionPerformed

    private void Btn_Nivel2_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel2_Ejercicio1ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 4;
        aux = 1;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel2_Ejercicio1ActionPerformed

    private void Btn_Nivel2_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel2_Ejercicio2ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 5;
        aux = 2;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel2_Ejercicio2ActionPerformed

    private void Btn_Nivel2_Ejercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel2_Ejercicio3ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 6;
        aux = 3;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel2_Ejercicio3ActionPerformed

    private void Btn_Nivel2_Ejercicio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel2_Ejercicio4ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 7;
        aux = 4;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel2_Ejercicio4ActionPerformed

    private void Btn_Nivel3_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel3_Ejercicio1ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 8;
        aux = 1;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel3_Ejercicio1ActionPerformed

    private void Btn_Nivel3_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel3_Ejercicio2ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 9;
        aux = 2;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel3_Ejercicio2ActionPerformed

    private void Btn_Nivel3_Ejercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel3_Ejercicio3ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 10;
        aux = 3;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel3_Ejercicio3ActionPerformed

    private void Btn_Nivel3_Ejercicio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel3_Ejercicio4ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 11;
        aux = 4;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel3_Ejercicio4ActionPerformed

    private void Btn_Nivel4_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel4_Ejercicio1ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 12;
        aux = 1;
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel4_Ejercicio1ActionPerformed

    private void Btn_Nivel4_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel4_Ejercicio2ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 13;
        aux = 2;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel4_Ejercicio2ActionPerformed

    private void Btn_Nivel4_Ejercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel4_Ejercicio3ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 14;
        aux = 3;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel4_Ejercicio3ActionPerformed

    private void Btn_Nivel4_Ejercicio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel4_Ejercicio4ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 15;
        aux = 4;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel4_Ejercicio4ActionPerformed

    private void Btn_Nivel5_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel5_Ejercicio1ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 16;
        aux = 1;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel5_Ejercicio1ActionPerformed

    private void Btn_Nivel5_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel5_Ejercicio2ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 17;
        aux = 2;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel5_Ejercicio2ActionPerformed

    private void Btn_Nivel5_Ejercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel5_Ejercicio3ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 18;
        aux = 3;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel5_Ejercicio3ActionPerformed

    private void Btn_Nivel5_Ejercicio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel5_Ejercicio4ActionPerformed
        Pnl_EjercicioFull.setVisible(true);
        contador = 19;
        aux = 4;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Nivel5_Ejercicio4ActionPerformed

    private void Btn_EjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EjercicioActionPerformed

        Pnl_CodigoFull.setVisible(false);
        Pnl_EjercicioFull.setVisible(true);
        Pnl_SolucionFull.setVisible(false);
        // Obtener paneles hijos del Panel visible
//        Component[] paneles = obtenerPanelesEjercicios(1);

//        paneles[0].setVisible(true);
//        paneles[1].setVisible(false);
//        paneles[2].setVisible(false);
        DeshabilitarBotonesCodeStorm(0);
    }//GEN-LAST:event_Btn_EjercicioActionPerformed

    private void Btn_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EnviarActionPerformed

        // Obtener Componentes del Panel de Ejercicios
//        Component[] componentes = Pnl_Ejercicios.getComponents();
//        List<JPanel> paneles = new ArrayList<>();
//        for (Component cmp : componentes) {
//            if (cmp instanceof JPanel) {
//                JPanel pnl = (JPanel) cmp;
//                paneles.add(pnl);
//            }
//        }
//        for (int i = 0; i < paneles.size(); i++) {
//            if (paneles.get(i).isVisible()) {
//                Component[] pnl = paneles.get(i).getComponents();
//                List<Component> comp = getAllComponents((JPanel) pnl[1]);
//                for (Component componente : comp) {
//                    if (componente instanceof JTextArea) {
//                        JTextArea txa = (JTextArea) componente;
        String code = syntaxCode.getText();
        String id = "ejercicio" + (contador + 1);
        Main.init.juzgador(id, code);
        Btn_Enviar.setSelected(false);
//                    }
//                }
//            }
//        }
    }//GEN-LAST:event_Btn_EnviarActionPerformed

    private void Btn_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CodigoActionPerformed
        Pnl_CodigoFull.setVisible(true);
        Pnl_EjercicioFull.setVisible(false);
        Pnl_SolucionFull.setVisible(false);
        // Obtener paneles hijos del Panel visible
//        Component[] paneles = obtenerPanelesEjercicios(1);
//
//        paneles[0].setVisible(false);
//        paneles[1].setVisible(true);
//        paneles[2].setVisible(false);

        DeshabilitarBotonesCodeStorm(1);
    }//GEN-LAST:event_Btn_CodigoActionPerformed

    private void Btn_SolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SolucionActionPerformed

        Pnl_CodigoFull.setVisible(false);
        Pnl_EjercicioFull.setVisible(false);
        Pnl_SolucionFull.setVisible(true);
        // Obtener paneles hijos del Panel visible
//        Component[] paneles = obtenerPanelesEjercicios(1);
//
//        paneles[0].setVisible(false);
//        paneles[1].setVisible(false);
//        paneles[2].setVisible(true);

        DeshabilitarBotonesCodeStorm(2);
    }//GEN-LAST:event_Btn_SolucionActionPerformed

    private void Btn_AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AnteriorActionPerformed
//        Component[] paneles = Pnl_Ejercicios.getComponents();

//        paneles[contador - 1].setVisible(true);
//        paneles[contador].setVisible(false);
        inicializarBotonesCodeStorm();
        contador--;
        aux--;
        validarEjercicioActivo();
        System.out.println(contador);
        if (contador == 0) {
            Btn_Anterior.setEnabled(false);
        } else {
            Btn_Siguiente.setEnabled(true);
        }
    }//GEN-LAST:event_Btn_AnteriorActionPerformed

    private void Btn_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SiguienteActionPerformed

//        Component[] paneles = Pnl_Ejercicios.getComponents();
//        paneles[contador].setVisible(false);
//        paneles[contador + 1].setVisible(true);
        inicializarBotonesCodeStorm();
        contador++;
        aux++;
        validarEjercicioActivo();
        System.out.println(contador);
        if (contador == 19) {
            Btn_Siguiente.setEnabled(false);
        } else {
            Btn_Anterior.setEnabled(true);
        }

//        System.out.println(contador);
    }//GEN-LAST:event_Btn_SiguienteActionPerformed

    private void Btn_Introduccion_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Introduccion_SiguienteActionPerformed
        Scp_Introduccion.setVisible(false);
        Pnl_Main.setVisible(true);
        contador = 0;
        aux = 1;
        validarEjercicioActivo();
        paneles_ON_OFF();
    }//GEN-LAST:event_Btn_Introduccion_SiguienteActionPerformed

    private void Btn_Anterior_LecturaeImpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_LecturaeImpresionActionPerformed
        Scp_Tema5.setVisible(true);
        Scp_Cuestionario5.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_LecturaeImpresionActionPerformed

    private void Btn_Siguiente_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Ejercicio1ActionPerformed
        Scp_Ejercicio1.setVisible(true);
        Scp_Cuestionario5.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Ejercicio1ActionPerformed

    private void Btn_Anterior_Ejercicio1_PrincipianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Ejercicio1_PrincipianteActionPerformed
        Scp_Ejercicio1.setVisible(true);
        Scp_Tema6.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Ejercicio1_PrincipianteActionPerformed

    private void Btn_Siguiente_Cuestionario6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario6ActionPerformed
        Scp_Cuestionario6.setVisible(true);
        Scp_Tema6.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario6ActionPerformed

    private void Btn_Anterior_OperadoresdeRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_OperadoresdeRelacionActionPerformed
        Scp_Tema6.setVisible(true);
        Scp_Cuestionario6.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_OperadoresdeRelacionActionPerformed

    private void Btn_Siguiente_OperadoresLogicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_OperadoresLogicosActionPerformed
        Scp_Tema7.setVisible(true);
        Scp_Cuestionario6.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_OperadoresLogicosActionPerformed

    private void Btn_Anterior_Cuestionario6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario6ActionPerformed
        Scp_Cuestionario6.setVisible(true);
        Scp_Tema7.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario6ActionPerformed

    private void Btn_Siguiente_Cuestionario7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario7ActionPerformed
        Scp_Cuestionario7.setVisible(true);
        Scp_Tema7.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario7ActionPerformed

    private void Btn_Anterior_OperadoresLogicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_OperadoresLogicosActionPerformed
        Scp_Tema7.setVisible(true);
        Scp_Cuestionario7.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_OperadoresLogicosActionPerformed

    private void Btn_Siguiente_CondicionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_CondicionalesActionPerformed
        Scp_Tema8.setVisible(true);
        Scp_Cuestionario7.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_CondicionalesActionPerformed

    private void Btn_Anterior_Cuestionario7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario7ActionPerformed
        Scp_Cuestionario7.setVisible(true);
        Scp_Tema8.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario7ActionPerformed

    private void Btn_Siguiente_Cuestionario8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario8ActionPerformed
        Scp_Cuestionario8.setVisible(true);
        Scp_Tema8.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario8ActionPerformed

    private void Btn_Anterior_CondicionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_CondicionalesActionPerformed
        Scp_Tema8.setVisible(true);
        Scp_Cuestionario8.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_CondicionalesActionPerformed

    private void Btn_Siguiente_BuclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_BuclesActionPerformed
        Scp_Tema9.setVisible(true);
        Scp_Cuestionario8.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_BuclesActionPerformed

    private void Btn_Anterior_Cuestionario8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario8ActionPerformed
        Scp_Cuestionario8.setVisible(true);
        Scp_Tema9.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario8ActionPerformed

    private void Btn_Siguiente_Cuestionario9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario9ActionPerformed
        Scp_Cuestionario9.setVisible(true);
        Scp_Tema9.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario9ActionPerformed

    private void Btn_Anterior_BuclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_BuclesActionPerformed
        Scp_Tema9.setVisible(true);
        Scp_Cuestionario9.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_BuclesActionPerformed

    private void Btn_Siguiente_Ejercicio2_IntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Ejercicio2_IntermedioActionPerformed
        Scp_Ejercicio2.setVisible(true);
        Scp_Cuestionario9.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Ejercicio2_IntermedioActionPerformed

    private void Btn_Anterior_Ejercicio2_IntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Ejercicio2_IntermedioActionPerformed
        Scp_Ejercicio2.setVisible(true);
        Scp_Tema10.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Ejercicio2_IntermedioActionPerformed

    private void Btn_Siguiente_Cuestionario10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario10ActionPerformed
        Scp_Cuestionario10.setVisible(true);
        Scp_Tema10.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario10ActionPerformed

    private void Btn_Anterior_FuncyProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_FuncyProcActionPerformed
        Scp_Tema10.setVisible(true);
        Scp_Cuestionario10.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_FuncyProcActionPerformed

    private void Btn_Siguiente_RecursionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_RecursionActionPerformed
        Scp_Tema11.setVisible(true);
        Scp_Cuestionario10.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_RecursionActionPerformed

    private void Btn_Anterior_Cuestionario10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario10ActionPerformed
        Scp_Cuestionario10.setVisible(true);
        Scp_Tema11.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario10ActionPerformed

    private void Btn_Siguiente_Cuestionario11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario11ActionPerformed
        Scp_Cuestionario11.setVisible(true);
        Scp_Tema11.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario11ActionPerformed

    private void Btn_Anterior_RecursionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_RecursionActionPerformed
        Scp_Tema11.setVisible(true);
        Scp_Cuestionario11.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_RecursionActionPerformed

    private void Btn_Siguiente_EDDBasicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_EDDBasicasActionPerformed
        Scp_Tema12.setVisible(true);
        Scp_Cuestionario11.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_EDDBasicasActionPerformed

    private void Btn_Anterior_Cuestionario11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario11ActionPerformed
        Scp_Cuestionario11.setVisible(true);
        Scp_Tema12.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario11ActionPerformed

    private void Btn_Siguiente_Cuestionario12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario12ActionPerformed
        Scp_Cuestionario12.setVisible(true);
        Scp_Tema12.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario12ActionPerformed

    private void Btn_Anterior_EDDBasicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_EDDBasicasActionPerformed
        Scp_Tema12.setVisible(true);
        Scp_Cuestionario12.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_EDDBasicasActionPerformed

    private void Btn_Siguiente_EDDAvanzadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_EDDAvanzadasActionPerformed
        Scp_Tema13.setVisible(true);
        Scp_Cuestionario12.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_EDDAvanzadasActionPerformed

    private void Btn_Anterior_Cuestionario12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario12ActionPerformed
        Scp_Cuestionario12.setVisible(true);
        Scp_Tema13.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario12ActionPerformed

    private void Btn_Siguiente_Cuestionario13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario13ActionPerformed
        Scp_Cuestionario13.setVisible(true);
        Scp_Tema13.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario13ActionPerformed

    private void Btn_Anterior_EDDAvanzadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_EDDAvanzadasActionPerformed
        Scp_Tema13.setVisible(true);
        Scp_Cuestionario13.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_EDDAvanzadasActionPerformed

    private void Btn_Siguiente_PrimerosAlgoritmosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_PrimerosAlgoritmosActionPerformed
        Scp_Tema14.setVisible(true);
        Scp_Cuestionario13.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_PrimerosAlgoritmosActionPerformed

    private void Btn_Anterior_Cuestionario13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario13ActionPerformed
        Scp_Cuestionario13.setVisible(true);
        Scp_Tema14.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario13ActionPerformed

    private void Btn_Siguiente_Cuestionario14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario14ActionPerformed
        Scp_Cuestionario14.setVisible(true);
        Scp_Tema14.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario14ActionPerformed

    private void Btn_Anterior_PrimerosAlgoritmosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_PrimerosAlgoritmosActionPerformed
        Scp_Tema14.setVisible(true);
        Scp_Cuestionario14.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_PrimerosAlgoritmosActionPerformed

    private void Btn_Siguiente_EjercicioFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_EjercicioFinalActionPerformed
        Scp_Cuestionario14.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_EjercicioFinalActionPerformed

    private void Btn_Anterior_Cuestionario5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario5ActionPerformed
        Scp_Cuestionario5.setVisible(true);
        Scp_Ejercicio1.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario5ActionPerformed

    private void Btn_Siguiente_OperadoresdeRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_OperadoresdeRelacionActionPerformed
        Scp_Tema6.setVisible(true);
        Scp_Ejercicio1.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_OperadoresdeRelacionActionPerformed

    private void Btn_Anterior_Cuestionario9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario9ActionPerformed
        Scp_Cuestionario9.setVisible(true);
        Scp_Ejercicio2.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario9ActionPerformed

    private void Btn_Siguiente_FuncionesyProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_FuncionesyProcActionPerformed
        Scp_Tema10.setVisible(true);
        Scp_Ejercicio2.setVisible(false);
    }//GEN-LAST:event_Btn_Siguiente_FuncionesyProcActionPerformed

    private void Btn_Anterior_Cuestionario14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario14ActionPerformed
        Scp_Cuestionario14.setVisible(true);
        Scp_Ejercicio3.setVisible(false);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario14ActionPerformed

    private void Btn_Aprender_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Ejercicio1ActionPerformed
        Scp_Ejercicio1.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Ejercicio1ActionPerformed

    private void Btn_Aprender_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Ejercicio2ActionPerformed
        Scp_Ejercicio2.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_Ejercicio2ActionPerformed

    private void Btn_Aprender_EjercicioFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_EjercicioFinalActionPerformed
        Scp_Ejercicio3.setVisible(true);
        Pnl_Mapa.setVisible(false);
    }//GEN-LAST:event_Btn_Aprender_EjercicioFinalActionPerformed

    private void Btn_AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AtrasActionPerformed
        Pnl_Mapa.setVisible(true);
        Scp_Tema1.setVisible(false);
    }//GEN-LAST:event_Btn_AtrasActionPerformed

    private void Btn_Atras_CodeStormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Atras_CodeStormActionPerformed
        Pnl_ListadoEjercicios.setVisible(true);
        Pnl_General.setVisible(false);
//        ocultarPanelesEjercicios();
    }//GEN-LAST:event_Btn_Atras_CodeStormActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EditorDeCodigo.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new HomeApolo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Btn_Ajustes;
    private javax.swing.JButton Btn_Anterior;
    private javax.swing.JButton Btn_Anterior_Bucles;
    private javax.swing.JButton Btn_Anterior_Comentarios;
    private javax.swing.JButton Btn_Anterior_Condicionales;
    private javax.swing.JButton Btn_Anterior_Cuestionario1;
    private javax.swing.JButton Btn_Anterior_Cuestionario10;
    private javax.swing.JButton Btn_Anterior_Cuestionario11;
    private javax.swing.JButton Btn_Anterior_Cuestionario12;
    private javax.swing.JButton Btn_Anterior_Cuestionario13;
    private javax.swing.JButton Btn_Anterior_Cuestionario14;
    private javax.swing.JButton Btn_Anterior_Cuestionario2;
    private javax.swing.JButton Btn_Anterior_Cuestionario3;
    private javax.swing.JButton Btn_Anterior_Cuestionario4;
    private javax.swing.JButton Btn_Anterior_Cuestionario5;
    private javax.swing.JButton Btn_Anterior_Cuestionario6;
    private javax.swing.JButton Btn_Anterior_Cuestionario7;
    private javax.swing.JButton Btn_Anterior_Cuestionario8;
    private javax.swing.JButton Btn_Anterior_Cuestionario9;
    private javax.swing.JButton Btn_Anterior_EDDAvanzadas;
    private javax.swing.JButton Btn_Anterior_EDDBasicas;
    private javax.swing.JButton Btn_Anterior_Ejercicio1_Principiante;
    private javax.swing.JButton Btn_Anterior_Ejercicio2_Intermedio;
    private javax.swing.JButton Btn_Anterior_FuncyProc;
    private javax.swing.JButton Btn_Anterior_HelloWord;
    private javax.swing.JButton Btn_Anterior_LecturaeImpresion;
    private javax.swing.JButton Btn_Anterior_OperadoresAritmeticos;
    private javax.swing.JButton Btn_Anterior_OperadoresLogicos;
    private javax.swing.JButton Btn_Anterior_OperadoresdeRelacion;
    private javax.swing.JButton Btn_Anterior_PrimerosAlgoritmos;
    private javax.swing.JButton Btn_Anterior_Recursion;
    private javax.swing.JButton Btn_Anterior_TiposdeDatos;
    private javax.swing.JToggleButton Btn_Aprender;
    private javax.swing.JButton Btn_Aprender_Ejercicio1;
    private javax.swing.JButton Btn_Aprender_Ejercicio2;
    private javax.swing.JButton Btn_Aprender_EjercicioFinal;
    private javax.swing.JButton Btn_Aprender_Tema1;
    private javax.swing.JButton Btn_Aprender_Tema10;
    private javax.swing.JButton Btn_Aprender_Tema11;
    private javax.swing.JButton Btn_Aprender_Tema12;
    private javax.swing.JButton Btn_Aprender_Tema13;
    private javax.swing.JButton Btn_Aprender_Tema14;
    private javax.swing.JButton Btn_Aprender_Tema2;
    private javax.swing.JButton Btn_Aprender_Tema3;
    private javax.swing.JButton Btn_Aprender_Tema4;
    private javax.swing.JButton Btn_Aprender_Tema5;
    private javax.swing.JButton Btn_Aprender_Tema6;
    private javax.swing.JButton Btn_Aprender_Tema7;
    private javax.swing.JButton Btn_Aprender_Tema8;
    private javax.swing.JButton Btn_Aprender_Tema9;
    private javax.swing.JButton Btn_Atras;
    private javax.swing.JButton Btn_Atras_CodeStorm;
    private javax.swing.JToggleButton Btn_CodeStorm;
    private javax.swing.JToggleButton Btn_Codigo;
    private javax.swing.JToggleButton Btn_Ejercicio;
    private javax.swing.JToggleButton Btn_Enviar;
    private javax.swing.JToggleButton Btn_Historia;
    private javax.swing.JButton Btn_Introduccion;
    private javax.swing.JButton Btn_Introduccion_Siguiente;
    private javax.swing.JButton Btn_Nivel1_Ejercicio1;
    private javax.swing.JButton Btn_Nivel1_Ejercicio2;
    private javax.swing.JButton Btn_Nivel1_Ejercicio3;
    private javax.swing.JButton Btn_Nivel1_Ejercicio4;
    private javax.swing.JButton Btn_Nivel2_Ejercicio1;
    private javax.swing.JButton Btn_Nivel2_Ejercicio2;
    private javax.swing.JButton Btn_Nivel2_Ejercicio3;
    private javax.swing.JButton Btn_Nivel2_Ejercicio4;
    private javax.swing.JButton Btn_Nivel3_Ejercicio1;
    private javax.swing.JButton Btn_Nivel3_Ejercicio2;
    private javax.swing.JButton Btn_Nivel3_Ejercicio3;
    private javax.swing.JButton Btn_Nivel3_Ejercicio4;
    private javax.swing.JButton Btn_Nivel4_Ejercicio1;
    private javax.swing.JButton Btn_Nivel4_Ejercicio2;
    private javax.swing.JButton Btn_Nivel4_Ejercicio3;
    private javax.swing.JButton Btn_Nivel4_Ejercicio4;
    private javax.swing.JButton Btn_Nivel5_Ejercicio1;
    private javax.swing.JButton Btn_Nivel5_Ejercicio2;
    private javax.swing.JButton Btn_Nivel5_Ejercicio3;
    private javax.swing.JButton Btn_Nivel5_Ejercicio4;
    private javax.swing.JToggleButton Btn_Programar;
    private javax.swing.JButton Btn_Siguiente;
    private javax.swing.JButton Btn_Siguiente_Bucles;
    private javax.swing.JButton Btn_Siguiente_Comentarios;
    private javax.swing.JButton Btn_Siguiente_Condicionales;
    private javax.swing.JButton Btn_Siguiente_Cuestionario1;
    private javax.swing.JButton Btn_Siguiente_Cuestionario10;
    private javax.swing.JButton Btn_Siguiente_Cuestionario11;
    private javax.swing.JButton Btn_Siguiente_Cuestionario12;
    private javax.swing.JButton Btn_Siguiente_Cuestionario13;
    private javax.swing.JButton Btn_Siguiente_Cuestionario14;
    private javax.swing.JButton Btn_Siguiente_Cuestionario2;
    private javax.swing.JButton Btn_Siguiente_Cuestionario3;
    private javax.swing.JButton Btn_Siguiente_Cuestionario4;
    private javax.swing.JButton Btn_Siguiente_Cuestionario5;
    private javax.swing.JButton Btn_Siguiente_Cuestionario6;
    private javax.swing.JButton Btn_Siguiente_Cuestionario7;
    private javax.swing.JButton Btn_Siguiente_Cuestionario8;
    private javax.swing.JButton Btn_Siguiente_Cuestionario9;
    private javax.swing.JButton Btn_Siguiente_EDDAvanzadas;
    private javax.swing.JButton Btn_Siguiente_EDDBasicas;
    private javax.swing.JButton Btn_Siguiente_Ejercicio1;
    private javax.swing.JButton Btn_Siguiente_Ejercicio2_Intermedio;
    private javax.swing.JButton Btn_Siguiente_EjercicioFinal;
    private javax.swing.JButton Btn_Siguiente_FuncionesyProc;
    private javax.swing.JButton Btn_Siguiente_LecturaeImpresion;
    private javax.swing.JButton Btn_Siguiente_OperadoresAritmeticos;
    private javax.swing.JButton Btn_Siguiente_OperadoresLogicos;
    private javax.swing.JButton Btn_Siguiente_OperadoresdeRelacion;
    private javax.swing.JButton Btn_Siguiente_PrimerosAlgoritmos;
    private javax.swing.JButton Btn_Siguiente_Recursion;
    private javax.swing.JButton Btn_Siguiente_TiposdeDatos;
    private javax.swing.JToggleButton Btn_Solucion;
    private javax.swing.JLabel Lbl_Aprender_Mapa;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel1_0;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel1_1;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel1_2;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel1_3;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel1_4;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel2_0;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel2_1;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel2_2;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel2_3;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel2_4;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel3_0;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel3_1;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel3_2;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel3_3;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel3_4;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel4_0;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel4_1;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel4_2;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel4_3;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel4_4;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel5_0;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel5_1;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel5_2;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel5_3;
    private javax.swing.JLabel Lbl_BarraProgreso_Nivel5_4;
    private javax.swing.JLabel Lbl_Bucles;
    private javax.swing.JLabel Lbl_CodeStorm_Fondo;
    private javax.swing.JLabel Lbl_Comentarios;
    private javax.swing.JLabel Lbl_Competencias;
    private javax.swing.JLabel Lbl_Condicionales;
    private javax.swing.JLabel Lbl_Cuestionario1;
    private javax.swing.JLabel Lbl_Cuestionario10;
    private javax.swing.JLabel Lbl_Cuestionario11;
    private javax.swing.JLabel Lbl_Cuestionario12;
    private javax.swing.JLabel Lbl_Cuestionario13;
    private javax.swing.JLabel Lbl_Cuestionario14;
    private javax.swing.JLabel Lbl_Cuestionario2;
    private javax.swing.JLabel Lbl_Cuestionario3;
    private javax.swing.JLabel Lbl_Cuestionario4;
    private javax.swing.JLabel Lbl_Cuestionario5;
    private javax.swing.JLabel Lbl_Cuestionario6;
    private javax.swing.JLabel Lbl_Cuestionario7;
    private javax.swing.JLabel Lbl_Cuestionario8;
    private javax.swing.JLabel Lbl_Cuestionario9;
    private javax.swing.JLabel Lbl_EDDAvanzadas;
    private javax.swing.JLabel Lbl_EDDBasicas;
    private javax.swing.JLabel Lbl_Ejercicio1;
    private javax.swing.JLabel Lbl_Ejercicio1_Principiante;
    private javax.swing.JLabel Lbl_Ejercicio2_Intermedio;
    private javax.swing.JLabel Lbl_EjercicioFinal;
    private javax.swing.JLabel Lbl_FuncionesyProcs;
    private javax.swing.JLabel Lbl_Header_Aprender;
    private javax.swing.JLabel Lbl_Header_Aprender1;
    private javax.swing.JLabel Lbl_Header_Aprender10;
    private javax.swing.JLabel Lbl_Header_Aprender11;
    private javax.swing.JLabel Lbl_Header_Aprender12;
    private javax.swing.JLabel Lbl_Header_Aprender13;
    private javax.swing.JLabel Lbl_Header_Aprender14;
    private javax.swing.JLabel Lbl_Header_Aprender15;
    private javax.swing.JLabel Lbl_Header_Aprender16;
    private javax.swing.JLabel Lbl_Header_Aprender17;
    private javax.swing.JLabel Lbl_Header_Aprender18;
    private javax.swing.JLabel Lbl_Header_Aprender19;
    private javax.swing.JLabel Lbl_Header_Aprender2;
    private javax.swing.JLabel Lbl_Header_Aprender20;
    private javax.swing.JLabel Lbl_Header_Aprender21;
    private javax.swing.JLabel Lbl_Header_Aprender22;
    private javax.swing.JLabel Lbl_Header_Aprender23;
    private javax.swing.JLabel Lbl_Header_Aprender24;
    private javax.swing.JLabel Lbl_Header_Aprender25;
    private javax.swing.JLabel Lbl_Header_Aprender26;
    private javax.swing.JLabel Lbl_Header_Aprender27;
    private javax.swing.JLabel Lbl_Header_Aprender28;
    private javax.swing.JLabel Lbl_Header_Aprender29;
    private javax.swing.JLabel Lbl_Header_Aprender3;
    private javax.swing.JLabel Lbl_Header_Aprender30;
    private javax.swing.JLabel Lbl_Header_Aprender31;
    private javax.swing.JLabel Lbl_Header_Aprender32;
    private javax.swing.JLabel Lbl_Header_Aprender33;
    private javax.swing.JLabel Lbl_Header_Aprender34;
    private javax.swing.JLabel Lbl_Header_Aprender35;
    private javax.swing.JLabel Lbl_Header_Aprender4;
    private javax.swing.JLabel Lbl_Header_Aprender5;
    private javax.swing.JLabel Lbl_Header_Aprender6;
    private javax.swing.JLabel Lbl_Header_Aprender7;
    private javax.swing.JLabel Lbl_Header_Aprender8;
    private javax.swing.JLabel Lbl_Header_CodeStorm;
    private javax.swing.JLabel Lbl_Header_CodeStorm1;
    private javax.swing.JLabel Lbl_Header_CodeStorm2;
    private javax.swing.JLabel Lbl_HelloWorld;
    private javax.swing.JLabel Lbl_HomeButttons;
    private javax.swing.JLabel Lbl_Home_Fondo;
    private javax.swing.JLabel Lbl_LecturaeImpresion;
    private javax.swing.JLabel Lbl_Nivel1;
    private javax.swing.JLabel Lbl_Nivel2;
    private javax.swing.JLabel Lbl_Nivel3;
    private javax.swing.JLabel Lbl_Nivel4;
    private javax.swing.JLabel Lbl_Nivel5;
    private javax.swing.JLabel Lbl_OperadoresAritmeticos;
    private javax.swing.JLabel Lbl_OperadoresLogicos;
    private javax.swing.JLabel Lbl_OperadoresdeRelacion;
    private javax.swing.JLabel Lbl_PrimerosAlgoritmos;
    private javax.swing.JLabel Lbl_QueEs;
    private javax.swing.JLabel Lbl_Recursion;
    private javax.swing.JLabel Lbl_TiposdeDatos;
    private javax.swing.JPanel Pnl_Aprender;
    private javax.swing.JPanel Pnl_Bar_Buttons;
    private javax.swing.JPanel Pnl_BotonesPrincipales;
    private javax.swing.JPanel Pnl_CodeStorm;
    private javax.swing.JPanel Pnl_CodigoFull;
    private javax.swing.JPanel Pnl_Cuestionario1;
    private javax.swing.JPanel Pnl_Cuestionario10;
    private javax.swing.JPanel Pnl_Cuestionario11;
    private javax.swing.JPanel Pnl_Cuestionario12;
    private javax.swing.JPanel Pnl_Cuestionario13;
    private javax.swing.JPanel Pnl_Cuestionario14;
    private javax.swing.JPanel Pnl_Cuestionario2;
    private javax.swing.JPanel Pnl_Cuestionario3;
    private javax.swing.JPanel Pnl_Cuestionario4;
    private javax.swing.JPanel Pnl_Cuestionario5;
    private javax.swing.JPanel Pnl_Cuestionario6;
    private javax.swing.JPanel Pnl_Cuestionario7;
    private javax.swing.JPanel Pnl_Cuestionario8;
    private javax.swing.JPanel Pnl_Cuestionario9;
    private javax.swing.JPanel Pnl_Ejercicio1_Aprender;
    private javax.swing.JPanel Pnl_Ejercicio2_Aprender;
    private javax.swing.JPanel Pnl_Ejercicio3_Aprender;
    private javax.swing.JPanel Pnl_EjercicioFull;
    private javax.swing.JPanel Pnl_General;
    private javax.swing.JPanel Pnl_Header;
    private javax.swing.JPanel Pnl_Historia;
    private javax.swing.JPanel Pnl_Home;
    private javax.swing.JPanel Pnl_Introduccion;
    private javax.swing.JPanel Pnl_ListadoEjercicios;
    private javax.swing.JPanel Pnl_Main;
    private javax.swing.JPanel Pnl_Mapa;
    private javax.swing.JPanel Pnl_Navegacion;
    private javax.swing.JPanel Pnl_Pagina1;
    private javax.swing.JPanel Pnl_Pagina2;
    private javax.swing.JPanel Pnl_Pagina3;
    private javax.swing.JPanel Pnl_Pagina4;
    private javax.swing.JPanel Pnl_Principal;
    private javax.swing.JPanel Pnl_SolucionFull;
    private javax.swing.JPanel Pnl_SyntaxCode;
    private javax.swing.JPanel Pnl_SyntaxSolution;
    private javax.swing.JPanel Pnl_Tema1;
    private javax.swing.JPanel Pnl_Tema10;
    private javax.swing.JPanel Pnl_Tema11;
    private javax.swing.JPanel Pnl_Tema12;
    private javax.swing.JPanel Pnl_Tema13;
    private javax.swing.JPanel Pnl_Tema14;
    private javax.swing.JPanel Pnl_Tema2;
    private javax.swing.JPanel Pnl_Tema3;
    private javax.swing.JPanel Pnl_Tema4;
    private javax.swing.JPanel Pnl_Tema5;
    private javax.swing.JPanel Pnl_Tema6;
    private javax.swing.JPanel Pnl_Tema7;
    private javax.swing.JPanel Pnl_Tema8;
    private javax.swing.JPanel Pnl_Tema9;
    private javax.swing.JScrollPane Scp_Competencias;
    private javax.swing.JScrollPane Scp_Cuestionario1;
    private javax.swing.JScrollPane Scp_Cuestionario10;
    private javax.swing.JScrollPane Scp_Cuestionario11;
    private javax.swing.JScrollPane Scp_Cuestionario12;
    private javax.swing.JScrollPane Scp_Cuestionario13;
    private javax.swing.JScrollPane Scp_Cuestionario14;
    private javax.swing.JScrollPane Scp_Cuestionario2;
    private javax.swing.JScrollPane Scp_Cuestionario3;
    private javax.swing.JScrollPane Scp_Cuestionario4;
    private javax.swing.JScrollPane Scp_Cuestionario5;
    private javax.swing.JScrollPane Scp_Cuestionario6;
    private javax.swing.JScrollPane Scp_Cuestionario7;
    private javax.swing.JScrollPane Scp_Cuestionario8;
    private javax.swing.JScrollPane Scp_Cuestionario9;
    private javax.swing.JScrollPane Scp_Ejercicio1;
    private javax.swing.JScrollPane Scp_Ejercicio2;
    private javax.swing.JScrollPane Scp_Ejercicio3;
    private javax.swing.JScrollPane Scp_EjerciciosFull;
    private javax.swing.JScrollPane Scp_Introduccion;
    private javax.swing.JScrollPane Scp_QueEs;
    private javax.swing.JScrollPane Scp_Tema1;
    private javax.swing.JScrollPane Scp_Tema10;
    private javax.swing.JScrollPane Scp_Tema11;
    private javax.swing.JScrollPane Scp_Tema12;
    private javax.swing.JScrollPane Scp_Tema13;
    private javax.swing.JScrollPane Scp_Tema14;
    private javax.swing.JScrollPane Scp_Tema2;
    private javax.swing.JScrollPane Scp_Tema3;
    private javax.swing.JScrollPane Scp_Tema4;
    private javax.swing.JScrollPane Scp_Tema5;
    private javax.swing.JScrollPane Scp_Tema6;
    private javax.swing.JScrollPane Scp_Tema7;
    private javax.swing.JScrollPane Scp_Tema8;
    private javax.swing.JScrollPane Scp_Tema9;
    private javax.swing.JTextArea Txa_Competencias;
    private javax.swing.JTextArea Txa_QueEs;
    // End of variables declaration//GEN-END:variables
}