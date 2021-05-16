package Main;

// Librerias creadas
import Salida.ExitMain;
import Services.RecursosService;
import CustomComponents.CustomScrollBarUI;
import CustomComponents.CustomProgressBarUIVertical;
import CustomComponents.CustomProgressBarUIHorizontal;
import Entities.LearningSubtopics;
import Entities.Codes;
import Entities.AlternativeSolutions;
import Entities.Curiosities;
import Entities.Exercises;
import Entities.ExercisesContent;
import Entities.HistoryImages;
import Entities.HistorySubtopics;
import Entities.HistoryTopics;
import Entities.LearningImages;
import Entities.LearningTopics;
import Entities.Progress;
import Entities.Questionnaires;
import Entities.Questions;
import Entities.TestCases;

import JPA_Controllers.AlternativeSolutionsJpaController;
import JPA_Controllers.CodesJpaController;
import JPA_Controllers.CuriositiesJpaController;
import JPA_Controllers.ExercisesContentJpaController;
import JPA_Controllers.ExercisesJpaController;
import JPA_Controllers.HistoryImagesJpaController;
import JPA_Controllers.HistorySubtopicsJpaController;
import JPA_Controllers.HistoryTopicsJpaController;
import JPA_Controllers.LearningImagesJpaController;
import JPA_Controllers.LearningSubtopicsJpaController;
import JPA_Controllers.LearningTopicsJpaController;
import JPA_Controllers.ProgressJpaController;
import JPA_Controllers.QuestionnairesJpaController;
import JPA_Controllers.QuestionsJpaController;
import JPA_Controllers.TestCasesJpaController;
import static Judge.init.juzgador;

// Librerias externas
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

// Librerias por Default
import java.io.IOException;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UnsupportedLookAndFeelException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Home extends javax.swing.JFrame {

    // Clase Recursos
    private final RecursosService sRecursos;

    // Ventanas JDialog
    private final About st = new About(this, true);
    private final ExitMain Confirmar = new ExitMain(this, true);

    // Resaltador de Sintaxis
    private final RSyntaxTextArea syntaxCode = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxSolution = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxEjercicio1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxEjercicio2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxEjercicio3 = new RSyntaxTextArea();

    private final RSyntaxTextArea syntaxTemas0 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas1_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas1_2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas1_3 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas4 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas5 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas6 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_3 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_4 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_5 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_6 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_7 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas8_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas8_2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas8_3 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas12_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas12_2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas12_3 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas12_4 = new RSyntaxTextArea();

    // Colores ScrollBar
    private final Color thumb_off = new Color(50, 50, 50);
    private final Color thumb_on = new Color(32, 30, 33);
    private final Color drag = new Color(32, 30, 33);

    // Variables Auxiliares
    private int aux = 1;
    private int contador = 0;
    private boolean active = true;
    private final Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();

    // Llamada informacion DDBB -------------------------------------------------
    // Creación de Fabrica de Entidades
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApoloPU");

    // Creacion de Controladores
    AlternativeSolutionsJpaController asjpa = new AlternativeSolutionsJpaController(emf);
    CodesJpaController cojpa = new CodesJpaController(emf);
    CuriositiesJpaController cujpa = new CuriositiesJpaController(emf);
    ExercisesContentJpaController ecjpa = new ExercisesContentJpaController(emf);
    ExercisesJpaController ejpa = new ExercisesJpaController(emf);
    HistoryImagesJpaController hijpa = new HistoryImagesJpaController(emf);
    HistorySubtopicsJpaController hsjpa = new HistorySubtopicsJpaController(emf);
    HistoryTopicsJpaController htjpa = new HistoryTopicsJpaController(emf);
    LearningImagesJpaController lijpa = new LearningImagesJpaController(emf);
    LearningSubtopicsJpaController lstjpa = new LearningSubtopicsJpaController(emf);
    LearningTopicsJpaController ltjpa = new LearningTopicsJpaController(emf);
    ProgressJpaController projpa = new ProgressJpaController(emf);
    QuestionnairesJpaController qresjpa = new QuestionnairesJpaController(emf);
    QuestionsJpaController qjpa = new QuestionsJpaController(emf);
    TestCasesJpaController tcjpa = new TestCasesJpaController(emf);

    // Creacion de Listas 
    List<AlternativeSolutions> asList = asjpa.findAlternativeSolutionsEntities();
    List<Codes> coList = cojpa.findCodesEntities();
    List<Curiosities> cuList = cujpa.findCuriositiesEntities();
    List<ExercisesContent> ecList = ecjpa.findExercisesContentEntities();
    List<Exercises> eList = ejpa.findExercisesEntities();
    List<HistoryImages> hiList = hijpa.findHistoryImagesEntities();
    List<HistorySubtopics> hsList = hsjpa.findHistorySubtopicsEntities();
    List<HistoryTopics> htList = htjpa.findHistoryTopicsEntities();
    List<LearningImages> liList = lijpa.findLearningImagesEntities();
    List<LearningSubtopics> lstList = lstjpa.findLearningSubtopicsEntities();
    List<LearningTopics> ltList = ltjpa.findLearningTopicsEntities();
    List<Progress> proList = projpa.findProgressEntities();
    List<Questionnaires> qresList = qresjpa.findQuestionnairesEntities();
    List<Questions> qList = qjpa.findQuestionsEntities();
    List<TestCases> tcList = tcjpa.findTestCasesEntities();

    // Constructor
    public Home() {
        sRecursos = RecursosService.getService();
        initComponents();
        configurarVentana();
        ocultarComponentes();
        cargarFuenteyCursor();
        resaltarCodigo();
        configurarBarraDesplazamiento();
        configurarBarraProgreso();
        confirmarCierre();
    }

    // Configurar las Caracteristicas de la Ventana Principal
    private void configurarVentana() {
        this.setLocationRelativeTo(null);
        this.setExtendedState(((int) DimMax.getHeight() == 768) ? 6 : 0);
        this.setResizable((int) DimMax.getHeight() == 768);
        this.getContentPane().setBackground(Color.red); // Color de Fondo del JFrame
        // Agregar icono de Apolo
        setIconImage(new ImageIcon(getClass().getResource(
                "/Resources/General/Apolo_Icono_Blanco_40px.png")).getImage()); // Agregar icono de Apolo
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

    // Personalizar las Barras de Progreso de la aplicacion
    private void configurarBarraProgreso() {
        Pb_Mapa.setUI(new CustomProgressBarUIHorizontal());
        Pb_Nivel1.setUI(new CustomProgressBarUIVertical());
        Pb_Nivel2.setUI(new CustomProgressBarUIVertical());
        Pb_Nivel3.setUI(new CustomProgressBarUIVertical());
        Pb_Nivel4.setUI(new CustomProgressBarUIVertical());
        Pb_Nivel5.setUI(new CustomProgressBarUIVertical());
    }

    // Personalizar la Barra de Desplazamiento de todos los ScrollPane
    private void configurarBarraDesplazamiento() {
        List<Component> compList = getAllComponents(this);
        for (Component componente : compList) {
            if (componente instanceof JScrollPane) {
                JScrollPane scp = (JScrollPane) componente;
                // Agregar Barra de Desplazamiento Personalizada cada ScrollPane
                scp.getVerticalScrollBar().setUI(
                        new CustomScrollBarUI(drag, thumb_on, thumb_off));
                scp.getVerticalScrollBar().setUnitIncrement(16);
                // Quitar borde por defecto
                scp.setBorder(null);
            }
            if (componente instanceof JButton) {
                JButton btn = (JButton) componente;
                btn.setCursor(sRecursos.getCMano());
            }
        }
    }

    // Personalizar cursor en los Botones de todas las secciones
    // Cargar fuente personalizada del paquete Tipografias en todas las Secciones
    private void cargarFuenteyCursor() {

        // Lista de Componentes de la Seccion de Aprender
        List<Component> aprenderList = getAllComponents(Pnl_Aprender);
        for (Component componente : aprenderList) {
            if (componente instanceof JLabel) {
                JLabel lbl = (JLabel) componente;
                if (lbl.getBounds().y == 5) {
                    lbl.setFont(sRecursos.getFLabelsAprender());
                    lbl.setForeground(sRecursos.getColorVerde());
                }
            }
        }

        // Lista de Componentes de la Seccion de Historia 
        List<Component> historiaList = getAllComponents(Pnl_Historia);
        for (Component componente : historiaList) {
            if (componente instanceof JLabel) {
                componente.setFont(sRecursos.getFHistoriaB());
                componente.setForeground(sRecursos.getColorAzul());
            }
            if (componente instanceof JTextArea) {
                componente.setFont(sRecursos.getFHistoriaR());
                componente.setForeground(Color.BLACK);
            }
        }
    }
    // Personalizar RSyntaxTextArea en paneles de CodeStorm

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
        rta.setFont(new Font("Consolas", Font.PLAIN, 14));
        rta.setBackground(sRecursos.getCPrincipal());
        rta.setAntiAliasingEnabled(true);
        rta.revalidate();

        // Agregar Area de Texto al Panel
        p.add(tsp);
    }

    private void agregarRSyntax(JPanel p, RSyntaxTextArea rta) {
        rta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        changeStyleViaThemeXml(rta);
        rta.setFont(new Font("Consolas", Font.PLAIN, 14));
        rta.setBackground(sRecursos.getCPrincipal());
        rta.setAntiAliasingEnabled(true);
        rta.revalidate();
        rta.setEditable(false);
        p.add(rta);
    }

    // Agregar RSyntaxText a panel de Codigo y Solucion en CodeStorm
    private void resaltarCodigo() {
        // Creacion de Resaltado de Sintaxis para Codigo y Solucion en CodeStorm
        RTextScrollPane tspCode = new RTextScrollPane();
        RTextScrollPane tspSolution = new RTextScrollPane();
        RTextScrollPane tspEjercicio1 = new RTextScrollPane();
        RTextScrollPane tspEjercicio2 = new RTextScrollPane();
        RTextScrollPane tspEjercicio3 = new RTextScrollPane();
        agregarRSyntax(Pnl_SyntaxCode, syntaxCode, tspCode);
        agregarRSyntax(Pnl_SyntaxSolution, syntaxSolution, tspSolution);
        agregarRSyntax(Pnl_SyntaxEjercicio1, syntaxEjercicio1, tspEjercicio1);
        agregarRSyntax(Pnl_SyntaxEjercicio2, syntaxEjercicio2, tspEjercicio2);
        agregarRSyntax(Pnl_SyntaxEjercicio3, syntaxEjercicio3, tspEjercicio3);

        agregarRSyntax(Pnl_CodesThemes0, syntaxTemas0);
        agregarRSyntax(Pnl_CodesThemes1_1, syntaxTemas1_1);
        agregarRSyntax(Pnl_CodesThemes1_2, syntaxTemas1_2);
        agregarRSyntax(Pnl_CodesThemes1_3, syntaxTemas1_3);
        agregarRSyntax(Pnl_CodesThemes2, syntaxTemas2);
        agregarRSyntax(Pnl_CodesThemes4, syntaxTemas4);
        agregarRSyntax(Pnl_CodesThemes5, syntaxTemas5);
        agregarRSyntax(Pnl_CodesThemes6, syntaxTemas6);
        agregarRSyntax(Pnl_CodesThemes7, syntaxTemas7);
        agregarRSyntax(Pnl_CodesThemes7_1, syntaxTemas7_1);
        agregarRSyntax(Pnl_CodesThemes7_2, syntaxTemas7_2);
        agregarRSyntax(Pnl_CodesThemes7_3, syntaxTemas7_3);
        agregarRSyntax(Pnl_CodesThemes7_4, syntaxTemas7_4);
        agregarRSyntax(Pnl_CodesThemes7_5, syntaxTemas7_5);
        agregarRSyntax(Pnl_CodesThemes7_6, syntaxTemas7_6);
        agregarRSyntax(Pnl_CodesThemes7_7, syntaxTemas7_7);
        agregarRSyntax(Pnl_CodesThemes8_1, syntaxTemas8_1);
        agregarRSyntax(Pnl_CodesThemes8_2, syntaxTemas8_2);
        agregarRSyntax(Pnl_CodesThemes8_3, syntaxTemas8_3);
        agregarRSyntax(Pnl_CodesThemes12_1, syntaxTemas12_1);
        agregarRSyntax(Pnl_CodesThemes12_2, syntaxTemas12_2);
        agregarRSyntax(Pnl_CodesThemes12_3, syntaxTemas12_3);
        agregarRSyntax(Pnl_CodesThemes12_4, syntaxTemas12_4);

        syntaxSolution.setEditable(false);
    }

    // Cargar tema preestablecido en RSyntaxTextArea
    private void changeStyleViaThemeXml(RSyntaxTextArea rta) {
        try {
            String tema_xml = "/org/fife/ui/rsyntaxtextarea/themes/eclipse.xml";
            Theme theme = Theme.load(getClass().getResourceAsStream(tema_xml));
            theme.apply(rta);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
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

    // Habilitar botones de la Seccion Aprender
    private void habilitarBotonesAprender() {
        for (Component component : Pnl_Aprender.getComponents()) {
            component.setVisible(true);
        }
    }

    // Mostrar panel de Encabezado en Seccion Aprender
    private void mostrarPanelesAprender() {
        Pnl_Mapa.setVisible(false);
        Pnl_Encabezado.setVisible(true);
    }

    // Habilitar botones de la Seccion CodeStorm
    private void habilitarBotonesCodeStorm() {
        for (Component component : Pnl_CodeStorm.getComponents()) {
            if (component instanceof JButton || component instanceof JToggleButton) {
                component.setVisible(true);
            }
        }
    }

    // Inicializar botones según navegacion en seccion CodeStorm
    private void inicializarBotonesCodeStorm() {
        Btn_Ejercicio.doClick();
        Btn_Ejercicio.setSelected(true);
        Btn_Codigo.setSelected(false);
        Btn_Solucion.setSelected(false);
    }

    // Habilitar o Deshabilitar botones de Siguiente y Anterior en seccion CodeStorm
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

    // Deshabilitar botones de los Ejercicios según Eleccion en CodeStorm
    private void validarSeleccionBotones(int opcion) {
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

    // Deshabilitar paneles comunes de la seccion CodeStorm
    private void paneles_ON_OFF() {
        Pnl_General.setVisible(true);
        Pnl_Main.setVisible(true);
        Pnl_ListadoEjercicios.setVisible(false);
        inicializarBotonesCodeStorm();
        contador();
    }

    // Asignar titulo a los paneles en seccion CodeStorm
    private void asignarTitulo(JPanel p) {
        p.setBorder(new TitledBorder(
                new LineBorder(sRecursos.getColorRojo(), 2, true),
                " Nivel " + (int) Math.ceil(((double) contador + 1) / 4) + " | Ejercicio " + (aux) + " ",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Tahoma", 1, 30),
                sRecursos.getColorRojo()));
    }

    // Validar ejercicio que se encuentra activo en Seccion CodeStorm
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

    // Habilitar botones de la Seccion Historia
    private void habilitarBotonesHistoria() {
        for (Component component : Pnl_Historia.getComponents()) {
            component.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Bar_Buttons = new javax.swing.JPanel();
        Btn_Aprender = new javax.swing.JToggleButton();
        Btn_CodeStorm = new javax.swing.JToggleButton();
        Btn_Programar = new javax.swing.JToggleButton();
        Btn_AcercaDe = new javax.swing.JToggleButton();
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
        Pb_Mapa = new javax.swing.JProgressBar();
        Pnl_Temas = new javax.swing.JPanel();
        Pnl_Encabezado = new javax.swing.JPanel();
        Lbl_Header_Aprender = new javax.swing.JLabel();
        Btn_Atras_Aprender = new javax.swing.JButton();
        Scp_Tema1 = new javax.swing.JScrollPane();
        Pnl_Tema1 = new javax.swing.JPanel();
        Btn_Siguiente_Cuestionario1 = new javax.swing.JButton();
        Lbl_HelloWorld = new javax.swing.JLabel();
        Txa_Analogy0 = new javax.swing.JTextArea();
        Txa_OutputScreen0 = new javax.swing.JTextArea();
        Txa_SubContent0 = new javax.swing.JTextArea();
        Pnl_CodesThemes0 = new javax.swing.JPanel();
        Scp_Cuestionario1 = new javax.swing.JScrollPane();
        Pnl_Cuestionario1 = new javax.swing.JPanel();
        Btn_Anterior_HelloWord = new javax.swing.JButton();
        Btn_Siguiente_Comentarios = new javax.swing.JButton();
        Lbl_Cuestionario1 = new javax.swing.JLabel();
        Scp_Tema2 = new javax.swing.JScrollPane();
        Pnl_Tema2 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario1 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario2 = new javax.swing.JButton();
        Lbl_Comentarios = new javax.swing.JLabel();
        Txa_Analogy1 = new javax.swing.JTextArea();
        Txa_OutputScreen1 = new javax.swing.JTextArea();
        Txa_CodeDescription2 = new javax.swing.JTextArea();
        Txa_SubContent1 = new javax.swing.JTextArea();
        Pnl_CodesThemes1_1 = new javax.swing.JPanel();
        Txa_CodeDescription1 = new javax.swing.JTextArea();
        Lbl_Sintaxis1 = new javax.swing.JLabel();
        Lbl_Input1_1 = new javax.swing.JLabel();
        Lbl_Output1_1 = new javax.swing.JLabel();
        Lbl_Input1_2 = new javax.swing.JLabel();
        Lbl_Output1_2 = new javax.swing.JLabel();
        Lbl_Input1_3 = new javax.swing.JLabel();
        Lbl_Output1_3 = new javax.swing.JLabel();
        Txa_OutputScreen1_2 = new javax.swing.JTextArea();
        Txa_OutputScreen1_3 = new javax.swing.JTextArea();
        Pnl_CodesThemes1_2 = new javax.swing.JPanel();
        Pnl_CodesThemes1_3 = new javax.swing.JPanel();
        Txa_CodeDescription1_1 = new javax.swing.JTextArea();
        Scp_Cuestionario2 = new javax.swing.JScrollPane();
        Pnl_Cuestionario2 = new javax.swing.JPanel();
        Btn_Anterior_Comentarios = new javax.swing.JButton();
        Btn_Siguiente_TiposdeDatos = new javax.swing.JButton();
        Lbl_Cuestionario2 = new javax.swing.JLabel();
        Scp_Tema3 = new javax.swing.JScrollPane();
        Pnl_Tema3 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario2 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario3 = new javax.swing.JButton();
        Lbl_TiposdeDatos = new javax.swing.JLabel();
        Txa_Analogy2 = new javax.swing.JTextArea();
        Txa_SubContent2 = new javax.swing.JTextArea();
        Pnl_CodesThemes2 = new javax.swing.JPanel();
        Txa_Tips2 = new javax.swing.JTextArea();
        Lbl_SampleCode2 = new javax.swing.JLabel();
        Lbl_Tips2 = new javax.swing.JLabel();
        Scp_Cuestionario3 = new javax.swing.JScrollPane();
        Pnl_Cuestionario3 = new javax.swing.JPanel();
        Btn_Anterior_TiposdeDatos = new javax.swing.JButton();
        Btn_Siguiente_OperadoresAritmeticos = new javax.swing.JButton();
        Lbl_Cuestionario3 = new javax.swing.JLabel();
        Scp_Tema4 = new javax.swing.JScrollPane();
        Pnl_Tema4 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario3 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario4 = new javax.swing.JButton();
        Lbl_OperadoresAritmeticos = new javax.swing.JLabel();
        Scp_Cuestionario4 = new javax.swing.JScrollPane();
        Pnl_Cuestionario4 = new javax.swing.JPanel();
        Btn_Anterior_OperadoresAritmeticos = new javax.swing.JButton();
        Btn_Siguiente_LecturaeImpresion = new javax.swing.JButton();
        Lbl_Cuestionario4 = new javax.swing.JLabel();
        Scp_Tema5 = new javax.swing.JScrollPane();
        Pnl_Tema5 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario4 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario5 = new javax.swing.JButton();
        Lbl_LecturaeImpresion = new javax.swing.JLabel();
        Pnl_CodesThemes4 = new javax.swing.JPanel();
        Txa_SubContent4 = new javax.swing.JTextArea();
        Txa_Analogy4 = new javax.swing.JTextArea();
        Txa_Tip4_1 = new javax.swing.JTextArea();
        Scp_Cuestionario5 = new javax.swing.JScrollPane();
        Pnl_Cuestionario5 = new javax.swing.JPanel();
        Btn_Anterior_LecturaeImpresion = new javax.swing.JButton();
        Btn_Siguiente_Ejercicio1 = new javax.swing.JButton();
        Lbl_Cuestionario5 = new javax.swing.JLabel();
        Scp_Ejercicio1 = new javax.swing.JScrollPane();
        Pnl_Ejercicio1_Aprender = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario5 = new javax.swing.JButton();
        Btn_Siguiente_OperadoresdeRelacion = new javax.swing.JButton();
        Lbl_Ejercicio1_Principiante = new javax.swing.JLabel();
        Btn_EnviarEjercicio1 = new javax.swing.JButton();
        Pnl_SyntaxEjercicio1 = new javax.swing.JPanel();
        Scp_Tema6 = new javax.swing.JScrollPane();
        Pnl_Tema6 = new javax.swing.JPanel();
        Btn_Anterior_Ejercicio1_Principiante = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario6 = new javax.swing.JButton();
        Lbl_OperadoresdeRelacion = new javax.swing.JLabel();
        Txa_Analogy5 = new javax.swing.JTextArea();
        Txa_SubContent5_1 = new javax.swing.JTextArea();
        Txa_SubContent5_2 = new javax.swing.JTextArea();
        Lbl_Tabla5 = new javax.swing.JLabel();
        Pnl_CodesThemes5 = new javax.swing.JPanel();
        Txa_OutputScreen5 = new javax.swing.JTextArea();
        Lbl_CodeEjemplo5 = new javax.swing.JLabel();
        Lbl_TablaOperadoresRelacion = new javax.swing.JLabel();
        Scp_Cuestionario6 = new javax.swing.JScrollPane();
        Pnl_Cuestionario6 = new javax.swing.JPanel();
        Btn_Anterior_OperadoresdeRelacion = new javax.swing.JButton();
        Btn_Siguiente_OperadoresLogicos = new javax.swing.JButton();
        Lbl_Cuestionario6 = new javax.swing.JLabel();
        Scp_Tema7 = new javax.swing.JScrollPane();
        Pnl_Tema7 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario6 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario7 = new javax.swing.JButton();
        Lbl_OperadoresLogicos = new javax.swing.JLabel();
        Txa_Analogy6 = new javax.swing.JTextArea();
        Txa_SubContent6_1 = new javax.swing.JTextArea();
        Lbl_Tabla6 = new javax.swing.JLabel();
        Lbl_TablaOperadoresLogicos = new javax.swing.JLabel();
        Txa_SubContent6_2 = new javax.swing.JTextArea();
        Pnl_CodesThemes6 = new javax.swing.JPanel();
        Txa_OutputScreen6 = new javax.swing.JTextArea();
        Txa_Tip6 = new javax.swing.JTextArea();
        Scp_Cuestionario7 = new javax.swing.JScrollPane();
        Pnl_Cuestionario7 = new javax.swing.JPanel();
        Btn_Anterior_OperadoresLogicos = new javax.swing.JButton();
        Btn_Siguiente_Condicionales = new javax.swing.JButton();
        Lbl_Cuestionario7 = new javax.swing.JLabel();
        Scp_Tema8 = new javax.swing.JScrollPane();
        Pnl_Tema8 = new javax.swing.JPanel();
        Lbl_Condicionales = new javax.swing.JLabel();
        Txa_Analogy7 = new javax.swing.JTextArea();
        Txa_SubContent7 = new javax.swing.JTextArea();
        Lbl_Sintaxis8_1_1 = new javax.swing.JLabel();
        Txa_CodeDescription7 = new javax.swing.JTextArea();
        Txa_OutputScreen7 = new javax.swing.JTextArea();
        Pnl_CodesThemes7 = new javax.swing.JPanel();
        Txa_CodeDescription7_1 = new javax.swing.JTextArea();
        Txa_OutputScreen7_1 = new javax.swing.JTextArea();
        Pnl_CodesThemes7_1 = new javax.swing.JPanel();
        Lbl_CondicionalesAnidados = new javax.swing.JLabel();
        Pnl_CodesThemes7_2 = new javax.swing.JPanel();
        Pnl_CodesThemes7_3 = new javax.swing.JPanel();
        Txa_OutputScreen7_3 = new javax.swing.JTextArea();
        Txa_Analogy7_4 = new javax.swing.JTextArea();
        Txa_SubContent7_4 = new javax.swing.JTextArea();
        Txa_CodeDescription7_4 = new javax.swing.JTextArea();
        Txa_OutputScreen7_4 = new javax.swing.JTextArea();
        Pnl_CodesThemes7_4 = new javax.swing.JPanel();
        Txa_OutputScreen7_5 = new javax.swing.JTextArea();
        Pnl_CodesThemes7_5 = new javax.swing.JPanel();
        Txa_OutputScreen7_6 = new javax.swing.JTextArea();
        Pnl_CodesThemes7_6 = new javax.swing.JPanel();
        Txa_CodeDescription7_3 = new javax.swing.JTextArea();
        Lbl_SwitchCase = new javax.swing.JLabel();
        Txa_Analogy7_5 = new javax.swing.JTextArea();
        Txa_CodeDescription7_5 = new javax.swing.JTextArea();
        Txa_Syntax7_2 = new javax.swing.JTextArea();
        Txa_OutputScreen7_7 = new javax.swing.JTextArea();
        Pnl_CodesThemes7_7 = new javax.swing.JPanel();
        Lbl_SampleCode8_4 = new javax.swing.JLabel();
        Lbl_Output8_4 = new javax.swing.JLabel();
        Lbl_SampleCode8_5 = new javax.swing.JLabel();
        Lbl_Sintaxis8_5 = new javax.swing.JLabel();
        Lbl_Output8_5 = new javax.swing.JLabel();
        Lbl_SampleCode8_6 = new javax.swing.JLabel();
        Lbl_Output8_6 = new javax.swing.JLabel();
        Lbl_SampleCode8_7 = new javax.swing.JLabel();
        Lbl_Output8_7 = new javax.swing.JLabel();
        Lbl_SampleCode8_8 = new javax.swing.JLabel();
        Lbl_Sintaxis8_6 = new javax.swing.JLabel();
        Lbl_Output8_8 = new javax.swing.JLabel();
        Lbl_SampleCode8_9 = new javax.swing.JLabel();
        Lbl_SampleCode8_10 = new javax.swing.JLabel();
        Lbl_Sintaxis8_7 = new javax.swing.JLabel();
        Lbl_Output8_9 = new javax.swing.JLabel();
        Lbl_Output8_10 = new javax.swing.JLabel();
        Lbl_TryCatch = new javax.swing.JLabel();
        Lbl_SampleCode8_11 = new javax.swing.JLabel();
        Txa_Casos7 = new javax.swing.JTextArea();
        Spr_CondicionalesAnidados = new javax.swing.JSeparator();
        Spr_TryCatch = new javax.swing.JSeparator();
        Spr_SwitchCase = new javax.swing.JSeparator();
        Btn_Anterior_Cuestionario7 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario8 = new javax.swing.JButton();
        Scp_Cuestionario8 = new javax.swing.JScrollPane();
        Pnl_Cuestionario8 = new javax.swing.JPanel();
        Btn_Anterior_Condicionales = new javax.swing.JButton();
        Btn_Siguiente_Bucles = new javax.swing.JButton();
        Lbl_Cuestionario8 = new javax.swing.JLabel();
        Scp_Tema9 = new javax.swing.JScrollPane();
        Pnl_Tema9 = new javax.swing.JPanel();
        Lbl_Bucles = new javax.swing.JLabel();
        Txa_Analogy8 = new javax.swing.JTextArea();
        Txa_SubContent8_1 = new javax.swing.JTextArea();
        Lbl_BucleWhile = new javax.swing.JLabel();
        Txa_SubContent8_2 = new javax.swing.JTextArea();
        Lbl_Sintaxis8_1 = new javax.swing.JLabel();
        Txa_Sintaxis8_1 = new javax.swing.JTextArea();
        Lbl_SampleCode8_1 = new javax.swing.JLabel();
        Pnl_CodesThemes8_1 = new javax.swing.JPanel();
        Lbl_Output8_1 = new javax.swing.JLabel();
        Txa_OutputScreen8_1 = new javax.swing.JTextArea();
        Lbl_Tip8_1 = new javax.swing.JLabel();
        Txa_Tips8_1 = new javax.swing.JTextArea();
        Lbl_BucleFor = new javax.swing.JLabel();
        Txa_SubContent8_3 = new javax.swing.JTextArea();
        Lbl_Sintaxis8_2 = new javax.swing.JLabel();
        Txa_Sintaxis8_2 = new javax.swing.JTextArea();
        Lbl_SampleCode8_2 = new javax.swing.JLabel();
        Pnl_CodesThemes8_2 = new javax.swing.JPanel();
        Lbl_Output8_2 = new javax.swing.JLabel();
        Txa_OutputScreen8_2 = new javax.swing.JTextArea();
        Lbl_BucleDoWhile = new javax.swing.JLabel();
        Txa_SubContent8_4 = new javax.swing.JTextArea();
        Lbl_Sintaxis8_3 = new javax.swing.JLabel();
        Txa_Sintaxis8_3 = new javax.swing.JTextArea();
        Lbl_SampleCode8_3 = new javax.swing.JLabel();
        Pnl_CodesThemes8_3 = new javax.swing.JPanel();
        Lbl_Output8_3 = new javax.swing.JLabel();
        Txa_OutputScreen8_3 = new javax.swing.JTextArea();
        Lbl_Tip8_2 = new javax.swing.JLabel();
        Txa_Tips8_2 = new javax.swing.JTextArea();
        Btn_Anterior_Cuestionario8 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario9 = new javax.swing.JButton();
        Spr_DoWhile = new javax.swing.JSeparator();
        Spr_While = new javax.swing.JSeparator();
        Spr_For = new javax.swing.JSeparator();
        Scp_Cuestionario9 = new javax.swing.JScrollPane();
        Pnl_Cuestionario9 = new javax.swing.JPanel();
        Btn_Anterior_Bucles = new javax.swing.JButton();
        Btn_Siguiente_Ejercicio2_Intermedio = new javax.swing.JButton();
        Lbl_Cuestionario9 = new javax.swing.JLabel();
        Scp_Ejercicio2 = new javax.swing.JScrollPane();
        Pnl_Ejercicio2_Aprender = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario9 = new javax.swing.JButton();
        Btn_Siguiente_FuncionesyProc = new javax.swing.JButton();
        Lbl_Ejercicio2_Intermedio = new javax.swing.JLabel();
        Btn_EnviarEjercicio2 = new javax.swing.JButton();
        Pnl_SyntaxEjercicio2 = new javax.swing.JPanel();
        Scp_Tema10 = new javax.swing.JScrollPane();
        Pnl_Tema10 = new javax.swing.JPanel();
        Btn_Anterior_Ejercicio2_Intermedio = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario10 = new javax.swing.JButton();
        Lbl_FuncionesyProcs = new javax.swing.JLabel();
        Scp_Cuestionario10 = new javax.swing.JScrollPane();
        Pnl_Cuestionario10 = new javax.swing.JPanel();
        Btn_Anterior_FuncyProc = new javax.swing.JButton();
        Btn_Siguiente_Recursion = new javax.swing.JButton();
        Lbl_Cuestionario10 = new javax.swing.JLabel();
        Scp_Tema11 = new javax.swing.JScrollPane();
        Pnl_Tema11 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario10 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario11 = new javax.swing.JButton();
        Lbl_Recursion = new javax.swing.JLabel();
        Scp_Cuestionario11 = new javax.swing.JScrollPane();
        Pnl_Cuestionario11 = new javax.swing.JPanel();
        Btn_Anterior_Recursion = new javax.swing.JButton();
        Btn_Siguiente_EDDBasicas = new javax.swing.JButton();
        Lbl_Cuestionario11 = new javax.swing.JLabel();
        Scp_Tema12 = new javax.swing.JScrollPane();
        Pnl_Tema12 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario11 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario12 = new javax.swing.JButton();
        Lbl_EDDBasicas = new javax.swing.JLabel();
        Scp_Cuestionario12 = new javax.swing.JScrollPane();
        Pnl_Cuestionario12 = new javax.swing.JPanel();
        Btn_Anterior_EDDBasicas = new javax.swing.JButton();
        Btn_Siguiente_EDDAvanzadas = new javax.swing.JButton();
        Lbl_Cuestionario12 = new javax.swing.JLabel();
        Scp_Tema13 = new javax.swing.JScrollPane();
        Pnl_Tema13 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario12 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario13 = new javax.swing.JButton();
        Lbl_EDDIntermedias = new javax.swing.JLabel();
        Txa_Analogy12 = new javax.swing.JTextArea();
        Txa_SubContent12_1 = new javax.swing.JTextArea();
        Spr_Sets = new javax.swing.JSeparator();
        Lbl_Sets = new javax.swing.JLabel();
        Txa_SubContent12_2 = new javax.swing.JTextArea();
        Lbl_MetodosBasicos12_1 = new javax.swing.JLabel();
        Txa_SubContent12_3 = new javax.swing.JTextArea();
        Spr_HashSet = new javax.swing.JSeparator();
        Lbl_SampleCode9_4 = new javax.swing.JLabel();
        Txa_SubContent12_4 = new javax.swing.JTextArea();
        Lbl_Sintaxis12_1 = new javax.swing.JLabel();
        Txa_Sintaxis12_1 = new javax.swing.JTextArea();
        Lbl_SampleCode12_1 = new javax.swing.JLabel();
        Pnl_CodesThemes12_1 = new javax.swing.JPanel();
        Lbl_Output12_1 = new javax.swing.JLabel();
        Txa_OutputScreen12_1 = new javax.swing.JTextArea();
        Spr_TreeSet = new javax.swing.JSeparator();
        Lbl_TreeSet = new javax.swing.JLabel();
        Txa_SubContent12_5 = new javax.swing.JTextArea();
        Lbl_Sintaxis12_2 = new javax.swing.JLabel();
        Txa_Sintaxis12_2 = new javax.swing.JTextArea();
        Lbl_SampleCode12_2 = new javax.swing.JLabel();
        Pnl_CodesThemes12_2 = new javax.swing.JPanel();
        Lbl_Output12_2 = new javax.swing.JLabel();
        Txa_OutputScreen12_2 = new javax.swing.JTextArea();
        Lbl_Tip12_1 = new javax.swing.JLabel();
        Txa_Tips12_1 = new javax.swing.JTextArea();
        Spr_Maps = new javax.swing.JSeparator();
        Lbl_Maps = new javax.swing.JLabel();
        Txa_SubContent12_6 = new javax.swing.JTextArea();
        Lbl_MetodosBasicos12_2 = new javax.swing.JLabel();
        Txa_SubContent12_7 = new javax.swing.JTextArea();
        Spr_HashMap = new javax.swing.JSeparator();
        Lbl_HashMap = new javax.swing.JLabel();
        Txa_SubContent12_8 = new javax.swing.JTextArea();
        Lbl_Sintaxis12_3 = new javax.swing.JLabel();
        Txa_Sintaxis12_3 = new javax.swing.JTextArea();
        Lbl_SampleCode12_3 = new javax.swing.JLabel();
        Pnl_CodesThemes12_3 = new javax.swing.JPanel();
        Lbl_Output12_3 = new javax.swing.JLabel();
        Txa_OutputScreen12_3 = new javax.swing.JTextArea();
        Spr_TreeMap = new javax.swing.JSeparator();
        Lbl_TreeMap = new javax.swing.JLabel();
        Txa_SubContent12_9 = new javax.swing.JTextArea();
        Lbl_Sintaxis12_4 = new javax.swing.JLabel();
        Txa_Sintaxis12_4 = new javax.swing.JTextArea();
        Lbl_SampleCode12_4 = new javax.swing.JLabel();
        Pnl_CodesThemes12_4 = new javax.swing.JPanel();
        Lbl_Output12_4 = new javax.swing.JLabel();
        Txa_OutputScreen12_4 = new javax.swing.JTextArea();
        Scp_Cuestionario13 = new javax.swing.JScrollPane();
        Pnl_Cuestionario13 = new javax.swing.JPanel();
        Btn_Anterior_EDDAvanzadas = new javax.swing.JButton();
        Btn_Siguiente_PrimerosAlgoritmos = new javax.swing.JButton();
        Lbl_Cuestionario13 = new javax.swing.JLabel();
        Scp_Tema14 = new javax.swing.JScrollPane();
        Pnl_Tema14 = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario13 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario14 = new javax.swing.JButton();
        Lbl_PrimerosAlgoritmos = new javax.swing.JLabel();
        Scp_Cuestionario14 = new javax.swing.JScrollPane();
        Pnl_Cuestionario14 = new javax.swing.JPanel();
        Btn_Anterior_PrimerosAlgoritmos = new javax.swing.JButton();
        Btn_Siguiente_EjercicioFinal = new javax.swing.JButton();
        Lbl_Cuestionario14 = new javax.swing.JLabel();
        Scp_Ejercicio3 = new javax.swing.JScrollPane();
        Pnl_Ejercicio3_Aprender = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario14 = new javax.swing.JButton();
        Lbl_EjercicioFinal = new javax.swing.JLabel();
        Btn_EnviarEjercicio3 = new javax.swing.JButton();
        Pnl_SyntaxEjercicio3 = new javax.swing.JPanel();
        Pnl_CodeStorm = new javax.swing.JPanel();
        Pnl_ListadoEjercicios = new javax.swing.JPanel();
        Pb_Nivel1 = new javax.swing.JProgressBar();
        Pb_Nivel2 = new javax.swing.JProgressBar();
        Pb_Nivel3 = new javax.swing.JProgressBar();
        Pb_Nivel4 = new javax.swing.JProgressBar();
        Pb_Nivel5 = new javax.swing.JProgressBar();
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
        Lbl_Header_Historia = new javax.swing.JLabel();
        Lbl_QueEs = new javax.swing.JLabel();
        Scp_QueEs = new javax.swing.JScrollPane();
        Txa_QueEs = new javax.swing.JTextArea();
        Lbl_Competencias = new javax.swing.JLabel();
        Scp_Competencias = new javax.swing.JScrollPane();
        Txa_Competencias = new javax.swing.JTextArea();
        Pnl_Pagina2 = new javax.swing.JPanel();
        Lbl_Header_Historia2 = new javax.swing.JLabel();
        Pnl_Pagina3 = new javax.swing.JPanel();
        Lbl_Header_Historia3 = new javax.swing.JLabel();
        Pnl_Pagina4 = new javax.swing.JPanel();
        Lbl_Header_Historia4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1366, 705));
        setSize(new java.awt.Dimension(1366, 705));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Bar_Buttons.setBackground(sRecursos.getCPrincipal());
        Pnl_Bar_Buttons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Aprender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Apolo_Aprender_Button_Off.png"))); // NOI18N
        Btn_Aprender.setToolTipText("");
        Btn_Aprender.setBorderPainted(false);
        Btn_Aprender.setContentAreaFilled(false);
        Btn_Aprender.setCursor(sRecursos.getCMano());
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
        Btn_CodeStorm.setBorderPainted(false);
        Btn_CodeStorm.setContentAreaFilled(false);
        Btn_CodeStorm.setCursor(sRecursos.getCMano());
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

        Btn_Programar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_ProgramaButton_Off.png"))); // NOI18N
        Btn_Programar.setBorderPainted(false);
        Btn_Programar.setContentAreaFilled(false);
        Btn_Programar.setCursor(sRecursos.getCMano());
        Btn_Programar.setFocusPainted(false);
        Btn_Programar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_ProgramaButton_On.png"))); // NOI18N
        Btn_Programar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_ProgramaButton_On.png"))); // NOI18N
        Btn_Programar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_ProgramaButton_Enabled.png"))); // NOI18N
        Btn_Programar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ProgramarActionPerformed(evt);
            }
        });
        Pnl_Bar_Buttons.add(Btn_Programar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 170, 55));

        Btn_AcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/AcercaDe_Off.png"))); // NOI18N
        Btn_AcercaDe.setBorderPainted(false);
        Btn_AcercaDe.setContentAreaFilled(false);
        Btn_AcercaDe.setCursor(sRecursos.getCMano());
        Btn_AcercaDe.setFocusPainted(false);
        Btn_AcercaDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_AcercaDe.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/AcercaDe_On.png"))); // NOI18N
        Btn_AcercaDe.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/AcercaDe_On.png"))); // NOI18N
        Btn_AcercaDe.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/AcercaDe_Enable.png"))); // NOI18N
        Btn_AcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AcercaDeActionPerformed(evt);
            }
        });
        Pnl_Bar_Buttons.add(Btn_AcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 170, 55));

        Btn_Historia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_HistoriaButton_Off.png"))); // NOI18N
        Btn_Historia.setBorderPainted(false);
        Btn_Historia.setContentAreaFilled(false);
        Btn_Historia.setCursor(sRecursos.getCMano());
        Btn_Historia.setFocusPainted(false);
        Btn_Historia.setFocusable(false);
        Btn_Historia.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_HistoriaButton_On.png"))); // NOI18N
        Btn_Historia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_HistoriaButton_On.png"))); // NOI18N
        Btn_Historia.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_HistoriaButton_Enabled.png"))); // NOI18N
        Btn_Historia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_HistoriaActionPerformed(evt);
            }
        });
        Pnl_Bar_Buttons.add(Btn_Historia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 170, 55));

        Lbl_HomeButttons.setBackground(sRecursos.getCPrincipal());
        Lbl_HomeButttons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_FondoButtons.png"))); // NOI18N
        Lbl_HomeButttons.setOpaque(true);
        Pnl_Bar_Buttons.add(Lbl_HomeButttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 705));

        getContentPane().add(Pnl_Bar_Buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Pnl_Principal.setBackground(sRecursos.getCPrincipal());
        Pnl_Principal.setMinimumSize(new java.awt.Dimension(1366, 705));
        Pnl_Principal.setPreferredSize(new java.awt.Dimension(1366, 705));
        Pnl_Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Home.setBackground(sRecursos.getCPrincipal());
        Pnl_Home.setMaximumSize(sRecursos.getDTamanio());
        Pnl_Home.setMinimumSize(sRecursos.getDTamanio());
        Pnl_Home.setPreferredSize(sRecursos.getDTamanio());
        Pnl_Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Home_Fondo.setBackground(sRecursos.getCPrincipal());
        Lbl_Home_Fondo.setForeground(sRecursos.getCPrincipal());
        Lbl_Home_Fondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Home_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_Home_Fondo.png"))); // NOI18N
        Lbl_Home_Fondo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lbl_Home_Fondo.setMaximumSize(sRecursos.getDTamanio());
        Lbl_Home_Fondo.setMinimumSize(sRecursos.getDTamanio());
        Lbl_Home_Fondo.setOpaque(true);
        Lbl_Home_Fondo.setPreferredSize(sRecursos.getDTamanio());
        Pnl_Home.add(Lbl_Home_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Principal.add(Pnl_Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1176, 705));

        Pnl_Aprender.setBackground(sRecursos.getCPrincipal());
        Pnl_Aprender.setMaximumSize(sRecursos.getDTamanio());
        Pnl_Aprender.setMinimumSize(sRecursos.getDTamanio());
        Pnl_Aprender.setPreferredSize(sRecursos.getDTamanio());
        Pnl_Aprender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Mapa.setBackground(new java.awt.Color(7, 89, 157));
        Pnl_Mapa.setMaximumSize(sRecursos.getDTamanio());
        Pnl_Mapa.setMinimumSize(sRecursos.getDTamanio());
        Pnl_Mapa.setPreferredSize(sRecursos.getDTamanio());
        Pnl_Mapa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Aprender_Tema1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema1_Off.png"))); // NOI18N
        Btn_Aprender_Tema1.setBorderPainted(false);
        Btn_Aprender_Tema1.setContentAreaFilled(false);
        Btn_Aprender_Tema1.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema1.setFocusPainted(false);
        Btn_Aprender_Tema1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema1_On.png"))); // NOI18N
        Btn_Aprender_Tema1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema1ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 88, 81));
        Btn_Aprender_Tema1.getAccessibleContext().setAccessibleDescription("");

        Btn_Aprender_Tema2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema2_Off.png"))); // NOI18N
        Btn_Aprender_Tema2.setBorderPainted(false);
        Btn_Aprender_Tema2.setContentAreaFilled(false);
        Btn_Aprender_Tema2.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema2.setFocusPainted(false);
        Btn_Aprender_Tema2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema2_On.png"))); // NOI18N
        Btn_Aprender_Tema2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema2ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 88, 81));

        Btn_Aprender_Tema3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema3_Off.png"))); // NOI18N
        Btn_Aprender_Tema3.setBorderPainted(false);
        Btn_Aprender_Tema3.setContentAreaFilled(false);
        Btn_Aprender_Tema3.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema3.setFocusPainted(false);
        Btn_Aprender_Tema3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema3_On.png"))); // NOI18N
        Btn_Aprender_Tema3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema3ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 88, 81));

        Btn_Aprender_Tema4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema4_Off.png"))); // NOI18N
        Btn_Aprender_Tema4.setBorderPainted(false);
        Btn_Aprender_Tema4.setContentAreaFilled(false);
        Btn_Aprender_Tema4.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema4.setFocusPainted(false);
        Btn_Aprender_Tema4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema4_On.png"))); // NOI18N
        Btn_Aprender_Tema4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema4ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, 88, 81));

        Btn_Aprender_Tema5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema5_Off.png"))); // NOI18N
        Btn_Aprender_Tema5.setBorderPainted(false);
        Btn_Aprender_Tema5.setContentAreaFilled(false);
        Btn_Aprender_Tema5.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema5.setFocusPainted(false);
        Btn_Aprender_Tema5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema5_On.png"))); // NOI18N
        Btn_Aprender_Tema5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema5ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 210, 88, 81));

        Btn_Aprender_Tema6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema6_Off.png"))); // NOI18N
        Btn_Aprender_Tema6.setBorderPainted(false);
        Btn_Aprender_Tema6.setContentAreaFilled(false);
        Btn_Aprender_Tema6.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema6.setFocusPainted(false);
        Btn_Aprender_Tema6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema6_On.png"))); // NOI18N
        Btn_Aprender_Tema6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema6ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 265, 88, 80));

        Btn_Aprender_Tema7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema7_Off.png"))); // NOI18N
        Btn_Aprender_Tema7.setBorderPainted(false);
        Btn_Aprender_Tema7.setContentAreaFilled(false);
        Btn_Aprender_Tema7.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema7.setFocusPainted(false);
        Btn_Aprender_Tema7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema7_On.png"))); // NOI18N
        Btn_Aprender_Tema7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema7ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 265, 88, 80));

        Btn_Aprender_Tema8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema8_Off.png"))); // NOI18N
        Btn_Aprender_Tema8.setBorderPainted(false);
        Btn_Aprender_Tema8.setContentAreaFilled(false);
        Btn_Aprender_Tema8.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema8.setFocusPainted(false);
        Btn_Aprender_Tema8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema8_On.png"))); // NOI18N
        Btn_Aprender_Tema8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema8ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 88, 78));

        Btn_Aprender_Tema9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema9_Off.png"))); // NOI18N
        Btn_Aprender_Tema9.setBorderPainted(false);
        Btn_Aprender_Tema9.setContentAreaFilled(false);
        Btn_Aprender_Tema9.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema9.setFocusPainted(false);
        Btn_Aprender_Tema9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema9_On.png"))); // NOI18N
        Btn_Aprender_Tema9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema9ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 88, 78));

        Btn_Aprender_Tema10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema10_Off.png"))); // NOI18N
        Btn_Aprender_Tema10.setBorderPainted(false);
        Btn_Aprender_Tema10.setContentAreaFilled(false);
        Btn_Aprender_Tema10.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema10.setFocusPainted(false);
        Btn_Aprender_Tema10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema10_On.png"))); // NOI18N
        Btn_Aprender_Tema10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema10ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema10, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, 88, 81));

        Btn_Aprender_Tema11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema11_Off.png"))); // NOI18N
        Btn_Aprender_Tema11.setBorderPainted(false);
        Btn_Aprender_Tema11.setContentAreaFilled(false);
        Btn_Aprender_Tema11.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema11.setFocusPainted(false);
        Btn_Aprender_Tema11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema11_On.png"))); // NOI18N
        Btn_Aprender_Tema11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema11ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 400, 88, 81));

        Btn_Aprender_Tema12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema12_Off.png"))); // NOI18N
        Btn_Aprender_Tema12.setBorderPainted(false);
        Btn_Aprender_Tema12.setContentAreaFilled(false);
        Btn_Aprender_Tema12.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema12.setFocusPainted(false);
        Btn_Aprender_Tema12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema12_On.png"))); // NOI18N
        Btn_Aprender_Tema12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema12ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 560, 88, 81));

        Btn_Aprender_Tema13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema13_Off.png"))); // NOI18N
        Btn_Aprender_Tema13.setBorderPainted(false);
        Btn_Aprender_Tema13.setContentAreaFilled(false);
        Btn_Aprender_Tema13.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema13.setFocusPainted(false);
        Btn_Aprender_Tema13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema13_On.png"))); // NOI18N
        Btn_Aprender_Tema13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema13ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 560, 88, 81));

        Btn_Aprender_Tema14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema14_Off.png"))); // NOI18N
        Btn_Aprender_Tema14.setBorderPainted(false);
        Btn_Aprender_Tema14.setContentAreaFilled(false);
        Btn_Aprender_Tema14.setCursor(sRecursos.getCMano());
        Btn_Aprender_Tema14.setFocusPainted(false);
        Btn_Aprender_Tema14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Aprender_Tema14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Tema14_On.png"))); // NOI18N
        Btn_Aprender_Tema14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Tema14ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Tema14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 88, 81));

        Btn_Aprender_Ejercicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Ejercicio1_Off.png"))); // NOI18N
        Btn_Aprender_Ejercicio1.setBorderPainted(false);
        Btn_Aprender_Ejercicio1.setContentAreaFilled(false);
        Btn_Aprender_Ejercicio1.setCursor(sRecursos.getCMano());
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
        Pnl_Mapa.add(Btn_Aprender_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 80, 140));

        Btn_Aprender_Ejercicio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Ejercicio2_Off.png"))); // NOI18N
        Btn_Aprender_Ejercicio2.setBorderPainted(false);
        Btn_Aprender_Ejercicio2.setContentAreaFilled(false);
        Btn_Aprender_Ejercicio2.setCursor(sRecursos.getCMano());
        Btn_Aprender_Ejercicio2.setMaximumSize(new java.awt.Dimension(90, 140));
        Btn_Aprender_Ejercicio2.setMinimumSize(new java.awt.Dimension(90, 140));
        Btn_Aprender_Ejercicio2.setPreferredSize(new java.awt.Dimension(90, 140));
        Btn_Aprender_Ejercicio2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Ejercicio2_On.png"))); // NOI18N
        Btn_Aprender_Ejercicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_Ejercicio2ActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_Ejercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 100, 150));

        Btn_Aprender_EjercicioFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/EjercicioFinal_Off.png"))); // NOI18N
        Btn_Aprender_EjercicioFinal.setBorderPainted(false);
        Btn_Aprender_EjercicioFinal.setContentAreaFilled(false);
        Btn_Aprender_EjercicioFinal.setCursor(sRecursos.getCMano());
        Btn_Aprender_EjercicioFinal.setMaximumSize(new java.awt.Dimension(121, 184));
        Btn_Aprender_EjercicioFinal.setMinimumSize(new java.awt.Dimension(121, 184));
        Btn_Aprender_EjercicioFinal.setPreferredSize(new java.awt.Dimension(121, 184));
        Btn_Aprender_EjercicioFinal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/EjercicioFinal_On.png"))); // NOI18N
        Btn_Aprender_EjercicioFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Aprender_EjercicioFinalActionPerformed(evt);
            }
        });
        Pnl_Mapa.add(Btn_Aprender_EjercicioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 121, 210));

        Lbl_Aprender_Mapa.setBackground(sRecursos.getCPrincipal());
        Lbl_Aprender_Mapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Aprender_Mapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Mapa.png"))); // NOI18N
        Lbl_Aprender_Mapa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lbl_Aprender_Mapa.setMaximumSize(sRecursos.getDTamanio());
        Lbl_Aprender_Mapa.setMinimumSize(sRecursos.getDTamanio());
        Lbl_Aprender_Mapa.setOpaque(true);
        Lbl_Aprender_Mapa.setPreferredSize(sRecursos.getDTamanio());
        Pnl_Mapa.add(Lbl_Aprender_Mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 1176, 670));

        Pb_Mapa.setBackground(new java.awt.Color(7, 95, 168));
        Pb_Mapa.setForeground(new java.awt.Color(0, 24, 96));
        Pb_Mapa.setValue(50);
        Pb_Mapa.setBorderPainted(false);
        Pnl_Mapa.add(Pb_Mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1150, 25));

        Pnl_Aprender.add(Pnl_Mapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Temas.setMaximumSize(sRecursos.getDTamanio());
        Pnl_Temas.setMinimumSize(sRecursos.getDTamanio());
        Pnl_Temas.setPreferredSize(sRecursos.getDTamanio());
        Pnl_Temas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Encabezado.setBackground(sRecursos.getCPrincipal());
        Pnl_Encabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Aprender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_Header_Aprender.png"))); // NOI18N
        Pnl_Encabezado.add(Lbl_Header_Aprender, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 980, 55));

        Btn_Atras_Aprender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Atras_Aprender_Off.png"))); // NOI18N
        Btn_Atras_Aprender.setMnemonic('b');
        Btn_Atras_Aprender.setToolTipText("Atrás");
        Btn_Atras_Aprender.setBorderPainted(false);
        Btn_Atras_Aprender.setContentAreaFilled(false);
        Btn_Atras_Aprender.setFocusPainted(false);
        Btn_Atras_Aprender.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Atras_Aprender_On.png"))); // NOI18N
        Btn_Atras_Aprender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Atras_AprenderActionPerformed(evt);
            }
        });
        Pnl_Encabezado.add(Btn_Atras_Aprender, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 102, 60));

        Pnl_Temas.add(Pnl_Encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 100));

        Scp_Tema1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema1.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema1.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema1.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema1.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema1.setCursor(sRecursos.getCDefault());
        Pnl_Tema1.setMaximumSize(new java.awt.Dimension(1176, 710));
        Pnl_Tema1.setMinimumSize(new java.awt.Dimension(1176, 710));
        Pnl_Tema1.setPreferredSize(new java.awt.Dimension(1176, 710));
        Pnl_Tema1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Siguiente_Cuestionario1.setBackground(null);
        Btn_Siguiente_Cuestionario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario1_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario1.setMnemonic(KeyEvent.VK_RIGHT);
        Btn_Siguiente_Cuestionario1.setBorderPainted(false);
        Btn_Siguiente_Cuestionario1.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario1.setFocusPainted(false);
        Btn_Siguiente_Cuestionario1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario1.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario1.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario1.setOpaque(true);
        Btn_Siguiente_Cuestionario1.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario1_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario1ActionPerformed(evt);
            }
        });
        Pnl_Tema1.add(Btn_Siguiente_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 610, 254, 64));

        Lbl_HelloWorld.setFont(sRecursos.getFLabels());
        Lbl_HelloWorld.setText("Hello World");
        Lbl_HelloWorld.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema1.add(Lbl_HelloWorld, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 190, 45));

        Txa_Analogy0.setEditable(false);
        Txa_Analogy0.setColumns(20);
        Txa_Analogy0.setFont(sRecursos.getFTitleTips());
        Txa_Analogy0.setRows(5);
        Txa_Analogy0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Analogy0.setFocusable(false);
        Txa_Analogy0.setOpaque(false);
        Pnl_Tema1.add(Txa_Analogy0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1120, 120));

        Txa_OutputScreen0.setEditable(false);
        Txa_OutputScreen0.setColumns(20);
        Txa_OutputScreen0.setFont(sRecursos.getFWindow());
        Txa_OutputScreen0.setLineWrap(true);
        Txa_OutputScreen0.setRows(5);
        Txa_OutputScreen0.setWrapStyleWord(true);
        Txa_OutputScreen0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen0.setFocusable(false);
        Txa_OutputScreen0.setOpaque(false);
        Txa_OutputScreen0.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema1.add(Txa_OutputScreen0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 1120, 200));

        Txa_SubContent0.setEditable(false);
        Txa_SubContent0.setColumns(20);
        Txa_SubContent0.setFont(sRecursos.getFWindow());
        Txa_SubContent0.setLineWrap(true);
        Txa_SubContent0.setRows(5);
        Txa_SubContent0.setWrapStyleWord(true);
        Txa_SubContent0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent0.setFocusable(false);
        Txa_SubContent0.setOpaque(false);
        Pnl_Tema1.add(Txa_SubContent0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 1120, 80));

        Pnl_CodesThemes0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes0.setLayout(new java.awt.CardLayout());
        Pnl_Tema1.add(Pnl_CodesThemes0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 1120, 90));

        Scp_Tema1.setViewportView(Pnl_Tema1);

        Pnl_Temas.add(Scp_Tema1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));
        Scp_Tema1.getAccessibleContext().setAccessibleDescription("");

        Scp_Cuestionario1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario1.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario1.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario1.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario1.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario1.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario1.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario1.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario1.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_HelloWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_HelloWorld_Off.png"))); // NOI18N
        Btn_Anterior_HelloWord.setMnemonic(KeyEvent.VK_LEFT);
        Btn_Anterior_HelloWord.setBorderPainted(false);
        Btn_Anterior_HelloWord.setContentAreaFilled(false);
        Btn_Anterior_HelloWord.setFocusPainted(false);
        Btn_Anterior_HelloWord.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_HelloWord.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_HelloWord.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_HelloWord.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_HelloWord.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_HelloWorld_On.png"))); // NOI18N
        Btn_Anterior_HelloWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_HelloWordActionPerformed(evt);
            }
        });
        Pnl_Cuestionario1.add(Btn_Anterior_HelloWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Comentarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Comentarios_Off.png"))); // NOI18N
        Btn_Siguiente_Comentarios.setMnemonic(KeyEvent.VK_RIGHT);
        Btn_Siguiente_Comentarios.setBorderPainted(false);
        Btn_Siguiente_Comentarios.setContentAreaFilled(false);
        Btn_Siguiente_Comentarios.setFocusPainted(false);
        Btn_Siguiente_Comentarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Comentarios.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Comentarios.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Comentarios.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Comentarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Comentarios_On.png"))); // NOI18N
        Btn_Siguiente_Comentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_ComentariosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario1.add(Btn_Siguiente_Comentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario1.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario1.setText("Hello World | Cuestionario");
        Lbl_Cuestionario1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario1.add(Lbl_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 420, 45));

        Scp_Cuestionario1.setViewportView(Pnl_Cuestionario1);

        Pnl_Temas.add(Scp_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema2.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema2.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema2.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema2.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema2.setCursor(sRecursos.getCDefault());
        Pnl_Tema2.setMaximumSize(new java.awt.Dimension(1176, 1560));
        Pnl_Tema2.setMinimumSize(new java.awt.Dimension(1176, 1560));
        Pnl_Tema2.setPreferredSize(new java.awt.Dimension(1176, 1560));
        Pnl_Tema2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario1_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario1.setMnemonic(KeyEvent.VK_LEFT);
        Btn_Anterior_Cuestionario1.setBorderPainted(false);
        Btn_Anterior_Cuestionario1.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario1.setFocusPainted(false);
        Btn_Anterior_Cuestionario1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario1.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario1.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario1.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario1_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario1ActionPerformed(evt);
            }
        });
        Pnl_Tema2.add(Btn_Anterior_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1460, 254, 64));

        Btn_Siguiente_Cuestionario2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario2_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario2.setMnemonic(KeyEvent.VK_RIGHT);
        Btn_Siguiente_Cuestionario2.setBorderPainted(false);
        Btn_Siguiente_Cuestionario2.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario2.setFocusPainted(false);
        Btn_Siguiente_Cuestionario2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario2.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario2.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario2.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario2_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario2ActionPerformed(evt);
            }
        });
        Pnl_Tema2.add(Btn_Siguiente_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1460, 254, 64));

        Lbl_Comentarios.setFont(sRecursos.getFLabels());
        Lbl_Comentarios.setText("Comentarios");
        Lbl_Comentarios.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema2.add(Lbl_Comentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 190, 45));

        Txa_Analogy1.setEditable(false);
        Txa_Analogy1.setColumns(20);
        Txa_Analogy1.setFont(sRecursos.getFTitleTips());
        Txa_Analogy1.setRows(5);
        Txa_Analogy1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Analogy1.setFocusable(false);
        Txa_Analogy1.setOpaque(false);
        Pnl_Tema2.add(Txa_Analogy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1120, 30));

        Txa_OutputScreen1.setEditable(false);
        Txa_OutputScreen1.setColumns(20);
        Txa_OutputScreen1.setFont(sRecursos.getFWindow());
        Txa_OutputScreen1.setLineWrap(true);
        Txa_OutputScreen1.setRows(5);
        Txa_OutputScreen1.setWrapStyleWord(true);
        Txa_OutputScreen1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen1.setFocusable(false);
        Txa_OutputScreen1.setOpaque(false);
        Txa_OutputScreen1.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema2.add(Txa_OutputScreen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 1120, 50));

        Txa_CodeDescription2.setEditable(false);
        Txa_CodeDescription2.setColumns(20);
        Txa_CodeDescription2.setFont(sRecursos.getFWindow());
        Txa_CodeDescription2.setLineWrap(true);
        Txa_CodeDescription2.setRows(5);
        Txa_CodeDescription2.setWrapStyleWord(true);
        Txa_CodeDescription2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_CodeDescription2.setFocusable(false);
        Txa_CodeDescription2.setOpaque(false);
        Pnl_Tema2.add(Txa_CodeDescription2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 1120, 30));

        Txa_SubContent1.setEditable(false);
        Txa_SubContent1.setColumns(20);
        Txa_SubContent1.setFont(sRecursos.getFWindow());
        Txa_SubContent1.setLineWrap(true);
        Txa_SubContent1.setRows(5);
        Txa_SubContent1.setWrapStyleWord(true);
        Txa_SubContent1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent1.setFocusable(false);
        Txa_SubContent1.setOpaque(false);
        Pnl_Tema2.add(Txa_SubContent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1120, 130));

        Pnl_CodesThemes1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes1_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema2.add(Pnl_CodesThemes1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 1120, 180));

        Txa_CodeDescription1.setEditable(false);
        Txa_CodeDescription1.setColumns(20);
        Txa_CodeDescription1.setFont(sRecursos.getFWindow());
        Txa_CodeDescription1.setLineWrap(true);
        Txa_CodeDescription1.setRows(5);
        Txa_CodeDescription1.setWrapStyleWord(true);
        Txa_CodeDescription1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_CodeDescription1.setFocusable(false);
        Txa_CodeDescription1.setOpaque(false);
        Pnl_Tema2.add(Txa_CodeDescription1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 1120, 70));

        Lbl_Sintaxis1.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis1.setText("Sintaxis");
        Pnl_Tema2.add(Lbl_Sintaxis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        Lbl_Input1_1.setFont(sRecursos.getFTitles());
        Lbl_Input1_1.setText("Input");
        Pnl_Tema2.add(Lbl_Input1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 20));

        Lbl_Output1_1.setFont(sRecursos.getFTitles());
        Lbl_Output1_1.setText("Output");
        Pnl_Tema2.add(Lbl_Output1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        Lbl_Input1_2.setFont(sRecursos.getFTitles());
        Lbl_Input1_2.setText("Input");
        Pnl_Tema2.add(Lbl_Input1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, -1, 20));

        Lbl_Output1_2.setFont(sRecursos.getFTitles());
        Lbl_Output1_2.setText("Output");
        Pnl_Tema2.add(Lbl_Output1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 930, -1, -1));

        Lbl_Input1_3.setFont(sRecursos.getFTitles());
        Lbl_Input1_3.setText("Input");
        Pnl_Tema2.add(Lbl_Input1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1060, -1, 20));

        Lbl_Output1_3.setFont(sRecursos.getFTitles());
        Lbl_Output1_3.setText("Output");
        Pnl_Tema2.add(Lbl_Output1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1350, -1, -1));

        Txa_OutputScreen1_2.setEditable(false);
        Txa_OutputScreen1_2.setColumns(20);
        Txa_OutputScreen1_2.setFont(sRecursos.getFWindow());
        Txa_OutputScreen1_2.setLineWrap(true);
        Txa_OutputScreen1_2.setRows(5);
        Txa_OutputScreen1_2.setWrapStyleWord(true);
        Txa_OutputScreen1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen1_2.setFocusable(false);
        Txa_OutputScreen1_2.setOpaque(false);
        Txa_OutputScreen1_2.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema2.add(Txa_OutputScreen1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 960, 1120, 30));

        Txa_OutputScreen1_3.setEditable(false);
        Txa_OutputScreen1_3.setColumns(20);
        Txa_OutputScreen1_3.setFont(sRecursos.getFWindow());
        Txa_OutputScreen1_3.setLineWrap(true);
        Txa_OutputScreen1_3.setRows(5);
        Txa_OutputScreen1_3.setWrapStyleWord(true);
        Txa_OutputScreen1_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen1_3.setFocusable(false);
        Txa_OutputScreen1_3.setOpaque(false);
        Txa_OutputScreen1_3.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema2.add(Txa_OutputScreen1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1380, 1120, 30));

        Pnl_CodesThemes1_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes1_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema2.add(Pnl_CodesThemes1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 730, 1118, 190));

        Pnl_CodesThemes1_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes1_3.setLayout(new java.awt.CardLayout());
        Pnl_Tema2.add(Pnl_CodesThemes1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1090, 1116, 250));

        Txa_CodeDescription1_1.setEditable(false);
        Txa_CodeDescription1_1.setColumns(20);
        Txa_CodeDescription1_1.setFont(sRecursos.getFWindow());
        Txa_CodeDescription1_1.setLineWrap(true);
        Txa_CodeDescription1_1.setRows(5);
        Txa_CodeDescription1_1.setWrapStyleWord(true);
        Txa_CodeDescription1_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_CodeDescription1_1.setFocusable(false);
        Txa_CodeDescription1_1.setOpaque(false);
        Txa_CodeDescription1_1.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema2.add(Txa_CodeDescription1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1000, 1120, 50));

        Scp_Tema2.setViewportView(Pnl_Tema2);

        Pnl_Temas.add(Scp_Tema2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario2.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario2.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario2.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario2.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario2.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario2.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario2.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario2.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Comentarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Comentarios_Off.png"))); // NOI18N
        Btn_Anterior_Comentarios.setMnemonic(KeyEvent.VK_LEFT);
        Btn_Anterior_Comentarios.setBorderPainted(false);
        Btn_Anterior_Comentarios.setContentAreaFilled(false);
        Btn_Anterior_Comentarios.setFocusPainted(false);
        Btn_Anterior_Comentarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Comentarios.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Comentarios.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Comentarios.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Comentarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Comentarios_On.png"))); // NOI18N
        Btn_Anterior_Comentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_ComentariosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario2.add(Btn_Anterior_Comentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_TiposdeDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_TiposdeDatos_Off.png"))); // NOI18N
        Btn_Siguiente_TiposdeDatos.setMnemonic(KeyEvent.VK_RIGHT);
        Btn_Siguiente_TiposdeDatos.setBorderPainted(false);
        Btn_Siguiente_TiposdeDatos.setContentAreaFilled(false);
        Btn_Siguiente_TiposdeDatos.setFocusPainted(false);
        Btn_Siguiente_TiposdeDatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_TiposdeDatos.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_TiposdeDatos.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_TiposdeDatos.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_TiposdeDatos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_TiposdeDatos_On.png"))); // NOI18N
        Btn_Siguiente_TiposdeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_TiposdeDatosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario2.add(Btn_Siguiente_TiposdeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario2.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario2.setText("Comentarios | Cuestionario");
        Lbl_Cuestionario2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario2.add(Lbl_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 440, 45));

        Scp_Cuestionario2.setViewportView(Pnl_Cuestionario2);

        Pnl_Temas.add(Scp_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema3.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema3.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema3.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema3.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema3.setCursor(sRecursos.getCDefault());
        Pnl_Tema3.setMaximumSize(new java.awt.Dimension(1176, 1090));
        Pnl_Tema3.setMinimumSize(new java.awt.Dimension(1176, 1090));
        Pnl_Tema3.setPreferredSize(new java.awt.Dimension(1176, 1090));
        Pnl_Tema3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario2_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario2.setMnemonic(KeyEvent.VK_LEFT);
        Btn_Anterior_Cuestionario2.setBorderPainted(false);
        Btn_Anterior_Cuestionario2.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario2.setFocusPainted(false);
        Btn_Anterior_Cuestionario2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario2.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario2.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario2.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario2_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario2ActionPerformed(evt);
            }
        });
        Pnl_Tema3.add(Btn_Anterior_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 990, 254, 64));

        Btn_Siguiente_Cuestionario3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario3_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario3.setMnemonic(KeyEvent.VK_RIGHT);
        Btn_Siguiente_Cuestionario3.setBorderPainted(false);
        Btn_Siguiente_Cuestionario3.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario3.setFocusPainted(false);
        Btn_Siguiente_Cuestionario3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario3.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario3.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario3.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario3_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario3ActionPerformed(evt);
            }
        });
        Pnl_Tema3.add(Btn_Siguiente_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 990, 254, 64));

        Lbl_TiposdeDatos.setFont(sRecursos.getFLabels());
        Lbl_TiposdeDatos.setText("Tipos de Datos");
        Lbl_TiposdeDatos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema3.add(Lbl_TiposdeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 230, 45));

        Txa_Analogy2.setEditable(false);
        Txa_Analogy2.setColumns(20);
        Txa_Analogy2.setFont(sRecursos.getFTitleTips());
        Txa_Analogy2.setRows(5);
        Txa_Analogy2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Analogy2.setFocusable(false);
        Txa_Analogy2.setOpaque(false);
        Pnl_Tema3.add(Txa_Analogy2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1120, 70));

        Txa_SubContent2.setEditable(false);
        Txa_SubContent2.setColumns(20);
        Txa_SubContent2.setFont(sRecursos.getFWindow());
        Txa_SubContent2.setLineWrap(true);
        Txa_SubContent2.setRows(5);
        Txa_SubContent2.setWrapStyleWord(true);
        Txa_SubContent2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent2.setFocusable(false);
        Txa_SubContent2.setOpaque(false);
        Pnl_Tema3.add(Txa_SubContent2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1120, 350));

        Pnl_CodesThemes2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes2.setLayout(new java.awt.CardLayout());
        Pnl_Tema3.add(Pnl_CodesThemes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 1120, 210));

        Txa_Tips2.setEditable(false);
        Txa_Tips2.setColumns(20);
        Txa_Tips2.setFont(sRecursos.getFWindow());
        Txa_Tips2.setLineWrap(true);
        Txa_Tips2.setRows(5);
        Txa_Tips2.setWrapStyleWord(true);
        Txa_Tips2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Tips2.setFocusable(false);
        Txa_Tips2.setOpaque(false);
        Txa_Tips2.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema3.add(Txa_Tips2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 800, 1120, 140));

        Lbl_SampleCode2.setFont(sRecursos.getFTitles());
        Lbl_SampleCode2.setText("Código de Ejemplo");
        Pnl_Tema3.add(Lbl_SampleCode2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        Lbl_Tips2.setFont(sRecursos.getFTitles());
        Lbl_Tips2.setText("Tips");
        Pnl_Tema3.add(Lbl_Tips2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 770, -1, -1));

        Scp_Tema3.setViewportView(Pnl_Tema3);

        Pnl_Temas.add(Scp_Tema3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario3.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario3.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario3.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario3.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario3.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario3.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario3.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario3.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_TiposdeDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_TiposdeDatos_Off.png"))); // NOI18N
        Btn_Anterior_TiposdeDatos.setMnemonic(37);
        Btn_Anterior_TiposdeDatos.setBorderPainted(false);
        Btn_Anterior_TiposdeDatos.setContentAreaFilled(false);
        Btn_Anterior_TiposdeDatos.setFocusPainted(false);
        Btn_Anterior_TiposdeDatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_TiposdeDatos.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_TiposdeDatos.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_TiposdeDatos.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_TiposdeDatos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_TiposdeDatos_On.png"))); // NOI18N
        Btn_Anterior_TiposdeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_TiposdeDatosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario3.add(Btn_Anterior_TiposdeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_OperadoresAritmeticos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresAritmeticos_Off.png"))); // NOI18N
        Btn_Siguiente_OperadoresAritmeticos.setMnemonic(39);
        Btn_Siguiente_OperadoresAritmeticos.setBorderPainted(false);
        Btn_Siguiente_OperadoresAritmeticos.setContentAreaFilled(false);
        Btn_Siguiente_OperadoresAritmeticos.setFocusPainted(false);
        Btn_Siguiente_OperadoresAritmeticos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_OperadoresAritmeticos.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_OperadoresAritmeticos.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_OperadoresAritmeticos.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_OperadoresAritmeticos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresAritmeticos_On.png"))); // NOI18N
        Btn_Siguiente_OperadoresAritmeticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_OperadoresAritmeticosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario3.add(Btn_Siguiente_OperadoresAritmeticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario3.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario3.setText("Tipos de Datos | Cuestionario");
        Lbl_Cuestionario3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario3.add(Lbl_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 430, 45));

        Scp_Cuestionario3.setViewportView(Pnl_Cuestionario3);

        Pnl_Temas.add(Scp_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema4.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema4.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema4.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema4.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema4.setCursor(sRecursos.getCDefault());
        Pnl_Tema4.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema4.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema4.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Tema4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario3_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario3.setMnemonic(37);
        Btn_Anterior_Cuestionario3.setBorderPainted(false);
        Btn_Anterior_Cuestionario3.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario3.setFocusPainted(false);
        Btn_Anterior_Cuestionario3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario3.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario3.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario3.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario3_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario3ActionPerformed(evt);
            }
        });
        Pnl_Tema4.add(Btn_Anterior_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario4_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario4.setMnemonic(39);
        Btn_Siguiente_Cuestionario4.setBorderPainted(false);
        Btn_Siguiente_Cuestionario4.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario4.setFocusPainted(false);
        Btn_Siguiente_Cuestionario4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario4.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario4.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario4.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario4_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario4ActionPerformed(evt);
            }
        });
        Pnl_Tema4.add(Btn_Siguiente_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_OperadoresAritmeticos.setFont(sRecursos.getFLabels());
        Lbl_OperadoresAritmeticos.setText("Operadores Aritméticos");
        Lbl_OperadoresAritmeticos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema4.add(Lbl_OperadoresAritmeticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 350, 45));

        Scp_Tema4.setViewportView(Pnl_Tema4);

        Pnl_Temas.add(Scp_Tema4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario4.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario4.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario4.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario4.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario4.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario4.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario4.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario4.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_OperadoresAritmeticos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresAritmeticos_Off.png"))); // NOI18N
        Btn_Anterior_OperadoresAritmeticos.setMnemonic(37);
        Btn_Anterior_OperadoresAritmeticos.setBorderPainted(false);
        Btn_Anterior_OperadoresAritmeticos.setContentAreaFilled(false);
        Btn_Anterior_OperadoresAritmeticos.setFocusPainted(false);
        Btn_Anterior_OperadoresAritmeticos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_OperadoresAritmeticos.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_OperadoresAritmeticos.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_OperadoresAritmeticos.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_OperadoresAritmeticos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresAritmeticos_On.png"))); // NOI18N
        Btn_Anterior_OperadoresAritmeticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_OperadoresAritmeticosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario4.add(Btn_Anterior_OperadoresAritmeticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_LecturaeImpresion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_LecturaeImpresion_Off.png"))); // NOI18N
        Btn_Siguiente_LecturaeImpresion.setMnemonic(39);
        Btn_Siguiente_LecturaeImpresion.setBorderPainted(false);
        Btn_Siguiente_LecturaeImpresion.setContentAreaFilled(false);
        Btn_Siguiente_LecturaeImpresion.setFocusPainted(false);
        Btn_Siguiente_LecturaeImpresion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_LecturaeImpresion.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_LecturaeImpresion.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_LecturaeImpresion.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_LecturaeImpresion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_LecturaeImpresion_On.png"))); // NOI18N
        Btn_Siguiente_LecturaeImpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_LecturaeImpresionActionPerformed(evt);
            }
        });
        Pnl_Cuestionario4.add(Btn_Siguiente_LecturaeImpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario4.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario4.setText("Operadores Aritméticos | Cuestionario");
        Lbl_Cuestionario4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario4.add(Lbl_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 610, 45));

        Scp_Cuestionario4.setViewportView(Pnl_Cuestionario4);

        Pnl_Temas.add(Scp_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema5.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema5.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema5.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema5.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema5.setCursor(sRecursos.getCDefault());
        Pnl_Tema5.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema5.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema5.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Tema5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario4_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario4.setMnemonic(37);
        Btn_Anterior_Cuestionario4.setBorderPainted(false);
        Btn_Anterior_Cuestionario4.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario4.setFocusPainted(false);
        Btn_Anterior_Cuestionario4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario4.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario4.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario4.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario4_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario4ActionPerformed(evt);
            }
        });
        Pnl_Tema5.add(Btn_Anterior_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario5_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario5.setMnemonic(39);
        Btn_Siguiente_Cuestionario5.setBorderPainted(false);
        Btn_Siguiente_Cuestionario5.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario5.setFocusPainted(false);
        Btn_Siguiente_Cuestionario5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario5.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario5.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario5.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario5_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario5ActionPerformed(evt);
            }
        });
        Pnl_Tema5.add(Btn_Siguiente_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_LecturaeImpresion.setFont(sRecursos.getFLabels());
        Lbl_LecturaeImpresion.setText("Lectura e Impresión");
        Lbl_LecturaeImpresion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema5.add(Lbl_LecturaeImpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 340, 45));

        Pnl_CodesThemes4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes4.setLayout(new java.awt.CardLayout());
        Pnl_Tema5.add(Pnl_CodesThemes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 1120, 450));

        Txa_SubContent4.setEditable(false);
        Txa_SubContent4.setColumns(20);
        Txa_SubContent4.setFont(sRecursos.getFWindow());
        Txa_SubContent4.setLineWrap(true);
        Txa_SubContent4.setRows(5);
        Txa_SubContent4.setWrapStyleWord(true);
        Txa_SubContent4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent4.setFocusable(false);
        Txa_SubContent4.setOpaque(false);
        Pnl_Tema5.add(Txa_SubContent4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1120, 70));

        Txa_Analogy4.setEditable(false);
        Txa_Analogy4.setColumns(20);
        Txa_Analogy4.setFont(sRecursos.getFTitleTips());
        Txa_Analogy4.setRows(5);
        Txa_Analogy4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Analogy4.setFocusable(false);
        Txa_Analogy4.setOpaque(false);
        Pnl_Tema5.add(Txa_Analogy4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1120, 30));

        Txa_Tip4_1.setEditable(false);
        Txa_Tip4_1.setColumns(20);
        Txa_Tip4_1.setFont(sRecursos.getFWindow());
        Txa_Tip4_1.setLineWrap(true);
        Txa_Tip4_1.setRows(5);
        Txa_Tip4_1.setWrapStyleWord(true);
        Txa_Tip4_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Tip4_1.setFocusable(false);
        Txa_Tip4_1.setOpaque(false);
        Pnl_Tema5.add(Txa_Tip4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 1120, 90));

        Scp_Tema5.setViewportView(Pnl_Tema5);

        Pnl_Temas.add(Scp_Tema5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario5.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario5.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario5.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario5.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario5.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario5.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario5.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario5.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_LecturaeImpresion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_LecturaeImpresion_Off.png"))); // NOI18N
        Btn_Anterior_LecturaeImpresion.setMnemonic(37);
        Btn_Anterior_LecturaeImpresion.setBorderPainted(false);
        Btn_Anterior_LecturaeImpresion.setContentAreaFilled(false);
        Btn_Anterior_LecturaeImpresion.setFocusPainted(false);
        Btn_Anterior_LecturaeImpresion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_LecturaeImpresion.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_LecturaeImpresion.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_LecturaeImpresion.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_LecturaeImpresion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_LecturaeImpresion_On.png"))); // NOI18N
        Btn_Anterior_LecturaeImpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_LecturaeImpresionActionPerformed(evt);
            }
        });
        Pnl_Cuestionario5.add(Btn_Anterior_LecturaeImpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Ejercicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Ejercicio1_Off.png"))); // NOI18N
        Btn_Siguiente_Ejercicio1.setMnemonic(39);
        Btn_Siguiente_Ejercicio1.setBorderPainted(false);
        Btn_Siguiente_Ejercicio1.setContentAreaFilled(false);
        Btn_Siguiente_Ejercicio1.setFocusPainted(false);
        Btn_Siguiente_Ejercicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Ejercicio1.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Ejercicio1.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Ejercicio1.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Ejercicio1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Ejercicio1_On.png"))); // NOI18N
        Btn_Siguiente_Ejercicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Ejercicio1ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario5.add(Btn_Siguiente_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario5.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario5.setText("Lectura e Impresión | Cuestionario");
        Lbl_Cuestionario5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario5.add(Lbl_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 610, 45));

        Scp_Cuestionario5.setViewportView(Pnl_Cuestionario5);

        Pnl_Temas.add(Scp_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Ejercicio1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Ejercicio1.setMaximumSize(sRecursos.getDTamanio());
        Scp_Ejercicio1.setMinimumSize(sRecursos.getDTamanio());
        Scp_Ejercicio1.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Ejercicio1_Aprender.setBackground(sRecursos.getCPrincipal());
        Pnl_Ejercicio1_Aprender.setCursor(sRecursos.getCDefault());
        Pnl_Ejercicio1_Aprender.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Ejercicio1_Aprender.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Ejercicio1_Aprender.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Ejercicio1_Aprender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario5_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario5.setMnemonic(37);
        Btn_Anterior_Cuestionario5.setBorderPainted(false);
        Btn_Anterior_Cuestionario5.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario5.setFocusPainted(false);
        Btn_Anterior_Cuestionario5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario5.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario5.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario5.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario5_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario5ActionPerformed(evt);
            }
        });
        Pnl_Ejercicio1_Aprender.add(Btn_Anterior_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_OperadoresdeRelacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresdeRelacion_Off.png"))); // NOI18N
        Btn_Siguiente_OperadoresdeRelacion.setMnemonic(39);
        Btn_Siguiente_OperadoresdeRelacion.setBorderPainted(false);
        Btn_Siguiente_OperadoresdeRelacion.setContentAreaFilled(false);
        Btn_Siguiente_OperadoresdeRelacion.setFocusPainted(false);
        Btn_Siguiente_OperadoresdeRelacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_OperadoresdeRelacion.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_OperadoresdeRelacion.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_OperadoresdeRelacion.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_OperadoresdeRelacion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresdeRelacion_On.png"))); // NOI18N
        Btn_Siguiente_OperadoresdeRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_OperadoresdeRelacionActionPerformed(evt);
            }
        });
        Pnl_Ejercicio1_Aprender.add(Btn_Siguiente_OperadoresdeRelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Ejercicio1_Principiante.setFont(sRecursos.getFLabels());
        Lbl_Ejercicio1_Principiante.setText("Ejercicio 1 | Principiante");
        Lbl_Ejercicio1_Principiante.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Ejercicio1_Aprender.add(Lbl_Ejercicio1_Principiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 610, 45));

        Btn_EnviarEjercicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/EnviarAprender_Off.png"))); // NOI18N
        Btn_EnviarEjercicio1.setBorderPainted(false);
        Btn_EnviarEjercicio1.setContentAreaFilled(false);
        Btn_EnviarEjercicio1.setFocusPainted(false);
        Btn_EnviarEjercicio1.setFocusable(false);
        Btn_EnviarEjercicio1.setMaximumSize(sRecursos.getDTamanioBotones());
        Btn_EnviarEjercicio1.setMinimumSize(sRecursos.getDTamanioBotones());
        Btn_EnviarEjercicio1.setPreferredSize(sRecursos.getDTamanioBotones());
        Btn_EnviarEjercicio1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/EnviarAprender_On.png"))); // NOI18N
        Btn_EnviarEjercicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EnviarEjercicio1ActionPerformed(evt);
            }
        });
        Pnl_Ejercicio1_Aprender.add(Btn_EnviarEjercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 990, 170, 50));

        Pnl_SyntaxEjercicio1.setBackground(new java.awt.Color(204, 204, 204));
        Pnl_SyntaxEjercicio1.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_SyntaxEjercicio1.setLayout(new java.awt.CardLayout());
        Pnl_Ejercicio1_Aprender.add(Pnl_SyntaxEjercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1050, 1080, 330));

        Scp_Ejercicio1.setViewportView(Pnl_Ejercicio1_Aprender);

        Pnl_Temas.add(Scp_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema6.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema6.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema6.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema6.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema6.setCursor(sRecursos.getCDefault());
        Pnl_Tema6.setMaximumSize(new java.awt.Dimension(1176, 1400));
        Pnl_Tema6.setMinimumSize(new java.awt.Dimension(1176, 1400));
        Pnl_Tema6.setPreferredSize(new java.awt.Dimension(1176, 1400));
        Pnl_Tema6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Ejercicio1_Principiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Ejercicio1_Off.png"))); // NOI18N
        Btn_Anterior_Ejercicio1_Principiante.setMnemonic(37);
        Btn_Anterior_Ejercicio1_Principiante.setBorderPainted(false);
        Btn_Anterior_Ejercicio1_Principiante.setContentAreaFilled(false);
        Btn_Anterior_Ejercicio1_Principiante.setFocusPainted(false);
        Btn_Anterior_Ejercicio1_Principiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Ejercicio1_Principiante.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Ejercicio1_Principiante.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Ejercicio1_Principiante.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Ejercicio1_Principiante.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Ejercicio1_On.png"))); // NOI18N
        Btn_Anterior_Ejercicio1_Principiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Ejercicio1_PrincipianteActionPerformed(evt);
            }
        });
        Pnl_Tema6.add(Btn_Anterior_Ejercicio1_Principiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1290, 254, 64));

        Btn_Siguiente_Cuestionario6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario6_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario6.setMnemonic(39);
        Btn_Siguiente_Cuestionario6.setBorderPainted(false);
        Btn_Siguiente_Cuestionario6.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario6.setFocusPainted(false);
        Btn_Siguiente_Cuestionario6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario6.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario6.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario6.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario6_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario6ActionPerformed(evt);
            }
        });
        Pnl_Tema6.add(Btn_Siguiente_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1290, 254, 64));

        Lbl_OperadoresdeRelacion.setFont(sRecursos.getFLabels());
        Lbl_OperadoresdeRelacion.setText("Operadores de Relación");
        Lbl_OperadoresdeRelacion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema6.add(Lbl_OperadoresdeRelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 440, 45));

        Txa_Analogy5.setEditable(false);
        Txa_Analogy5.setColumns(20);
        Txa_Analogy5.setFont(sRecursos.getFTitleTips());
        Txa_Analogy5.setRows(5);
        Txa_Analogy5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Analogy5.setFocusable(false);
        Txa_Analogy5.setOpaque(false);
        Pnl_Tema6.add(Txa_Analogy5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1120, 100));

        Txa_SubContent5_1.setEditable(false);
        Txa_SubContent5_1.setColumns(20);
        Txa_SubContent5_1.setFont(sRecursos.getFWindow());
        Txa_SubContent5_1.setLineWrap(true);
        Txa_SubContent5_1.setRows(5);
        Txa_SubContent5_1.setWrapStyleWord(true);
        Txa_SubContent5_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent5_1.setFocusable(false);
        Txa_SubContent5_1.setOpaque(false);
        Pnl_Tema6.add(Txa_SubContent5_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 1120, 50));

        Txa_SubContent5_2.setEditable(false);
        Txa_SubContent5_2.setColumns(20);
        Txa_SubContent5_2.setFont(sRecursos.getFWindow());
        Txa_SubContent5_2.setLineWrap(true);
        Txa_SubContent5_2.setRows(5);
        Txa_SubContent5_2.setWrapStyleWord(true);
        Txa_SubContent5_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent5_2.setFocusable(false);
        Txa_SubContent5_2.setOpaque(false);
        Pnl_Tema6.add(Txa_SubContent5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 1120, 50));

        Lbl_Tabla5.setFont(sRecursos.getFTitles());
        Lbl_Tabla5.setText("Tabla de Sintaxis General");
        Pnl_Tema6.add(Lbl_Tabla5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        Pnl_CodesThemes5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes5.setLayout(new java.awt.CardLayout());
        Pnl_Tema6.add(Pnl_CodesThemes5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, 1120, 270));

        Txa_OutputScreen5.setEditable(false);
        Txa_OutputScreen5.setColumns(20);
        Txa_OutputScreen5.setFont(sRecursos.getFWindow());
        Txa_OutputScreen5.setLineWrap(true);
        Txa_OutputScreen5.setRows(5);
        Txa_OutputScreen5.setWrapStyleWord(true);
        Txa_OutputScreen5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen5.setFocusable(false);
        Txa_OutputScreen5.setOpaque(false);
        Txa_OutputScreen5.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema6.add(Txa_OutputScreen5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 990, 1120, 260));

        Lbl_CodeEjemplo5.setFont(sRecursos.getFTitles());
        Lbl_CodeEjemplo5.setText("Código de Ejemplo");
        Pnl_Tema6.add(Lbl_CodeEjemplo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, -1, -1));

        Lbl_TablaOperadoresRelacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl_TablaOperadoresRelacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Learning_Images/Operadores_Relacion.png"))); // NOI18N
        Pnl_Tema6.add(Lbl_TablaOperadoresRelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 1130, 320));

        Scp_Tema6.setViewportView(Pnl_Tema6);

        Pnl_Temas.add(Scp_Tema6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario6.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario6.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario6.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario6.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario6.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario6.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario6.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario6.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_OperadoresdeRelacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresdeRelacion_Off.png"))); // NOI18N
        Btn_Anterior_OperadoresdeRelacion.setMnemonic(37);
        Btn_Anterior_OperadoresdeRelacion.setBorderPainted(false);
        Btn_Anterior_OperadoresdeRelacion.setContentAreaFilled(false);
        Btn_Anterior_OperadoresdeRelacion.setFocusPainted(false);
        Btn_Anterior_OperadoresdeRelacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_OperadoresdeRelacion.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_OperadoresdeRelacion.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_OperadoresdeRelacion.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_OperadoresdeRelacion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresdeRelacion_On.png"))); // NOI18N
        Btn_Anterior_OperadoresdeRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_OperadoresdeRelacionActionPerformed(evt);
            }
        });
        Pnl_Cuestionario6.add(Btn_Anterior_OperadoresdeRelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_OperadoresLogicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresLogicos_Off.png"))); // NOI18N
        Btn_Siguiente_OperadoresLogicos.setMnemonic(39);
        Btn_Siguiente_OperadoresLogicos.setBorderPainted(false);
        Btn_Siguiente_OperadoresLogicos.setContentAreaFilled(false);
        Btn_Siguiente_OperadoresLogicos.setFocusPainted(false);
        Btn_Siguiente_OperadoresLogicos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_OperadoresLogicos.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_OperadoresLogicos.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_OperadoresLogicos.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_OperadoresLogicos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_OperadoresLogicos_On.png"))); // NOI18N
        Btn_Siguiente_OperadoresLogicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_OperadoresLogicosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario6.add(Btn_Siguiente_OperadoresLogicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario6.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario6.setText("Operadores de Relación | Cuestionario");
        Lbl_Cuestionario6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario6.add(Lbl_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 610, 45));

        Scp_Cuestionario6.setViewportView(Pnl_Cuestionario6);

        Pnl_Temas.add(Scp_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema7.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema7.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema7.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema7.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema7.setCursor(sRecursos.getCDefault());
        Pnl_Tema7.setMaximumSize(new java.awt.Dimension(1176, 1270));
        Pnl_Tema7.setMinimumSize(new java.awt.Dimension(1176, 1270));
        Pnl_Tema7.setPreferredSize(new java.awt.Dimension(1176, 1270));
        Pnl_Tema7.setRequestFocusEnabled(false);
        Pnl_Tema7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario6_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario6.setMnemonic(37);
        Btn_Anterior_Cuestionario6.setBorderPainted(false);
        Btn_Anterior_Cuestionario6.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario6.setFocusPainted(false);
        Btn_Anterior_Cuestionario6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario6.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario6.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario6.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario6_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario6ActionPerformed(evt);
            }
        });
        Pnl_Tema7.add(Btn_Anterior_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1160, 254, 64));

        Btn_Siguiente_Cuestionario7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario7_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario7.setMnemonic(39);
        Btn_Siguiente_Cuestionario7.setBorderPainted(false);
        Btn_Siguiente_Cuestionario7.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario7.setFocusPainted(false);
        Btn_Siguiente_Cuestionario7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario7.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario7.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario7.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario7_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario7ActionPerformed(evt);
            }
        });
        Pnl_Tema7.add(Btn_Siguiente_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1160, 254, 64));

        Lbl_OperadoresLogicos.setFont(sRecursos.getFLabels());
        Lbl_OperadoresLogicos.setText("Operadores Lógicos");
        Lbl_OperadoresLogicos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema7.add(Lbl_OperadoresLogicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 340, 45));

        Txa_Analogy6.setEditable(false);
        Txa_Analogy6.setColumns(20);
        Txa_Analogy6.setFont(sRecursos.getFTitleTips());
        Txa_Analogy6.setRows(5);
        Txa_Analogy6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Analogy6.setFocusable(false);
        Txa_Analogy6.setOpaque(false);
        Pnl_Tema7.add(Txa_Analogy6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1120, 30));

        Txa_SubContent6_1.setEditable(false);
        Txa_SubContent6_1.setColumns(20);
        Txa_SubContent6_1.setFont(sRecursos.getFWindow());
        Txa_SubContent6_1.setLineWrap(true);
        Txa_SubContent6_1.setRows(5);
        Txa_SubContent6_1.setWrapStyleWord(true);
        Txa_SubContent6_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent6_1.setFocusable(false);
        Txa_SubContent6_1.setOpaque(false);
        Pnl_Tema7.add(Txa_SubContent6_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1120, 50));

        Lbl_Tabla6.setFont(sRecursos.getFTitles());
        Lbl_Tabla6.setText("Tabla de Sintaxis General");
        Pnl_Tema7.add(Lbl_Tabla6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        Lbl_TablaOperadoresLogicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Learning_Images/Operadores_Logicos.png"))); // NOI18N
        Pnl_Tema7.add(Lbl_TablaOperadoresLogicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 1130, 290));

        Txa_SubContent6_2.setEditable(false);
        Txa_SubContent6_2.setColumns(20);
        Txa_SubContent6_2.setFont(sRecursos.getFWindow());
        Txa_SubContent6_2.setLineWrap(true);
        Txa_SubContent6_2.setRows(5);
        Txa_SubContent6_2.setWrapStyleWord(true);
        Txa_SubContent6_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent6_2.setFocusable(false);
        Txa_SubContent6_2.setOpaque(false);
        Pnl_Tema7.add(Txa_SubContent6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 1120, 70));

        Pnl_CodesThemes6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes6.setLayout(new java.awt.CardLayout());
        Pnl_Tema7.add(Pnl_CodesThemes6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 1120, 270));

        Txa_OutputScreen6.setEditable(false);
        Txa_OutputScreen6.setColumns(20);
        Txa_OutputScreen6.setFont(sRecursos.getFWindow());
        Txa_OutputScreen6.setLineWrap(true);
        Txa_OutputScreen6.setRows(5);
        Txa_OutputScreen6.setWrapStyleWord(true);
        Txa_OutputScreen6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen6.setFocusable(false);
        Txa_OutputScreen6.setOpaque(false);
        Txa_OutputScreen6.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema7.add(Txa_OutputScreen6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 1120, 180));

        Txa_Tip6.setEditable(false);
        Txa_Tip6.setColumns(20);
        Txa_Tip6.setFont(sRecursos.getFWindow());
        Txa_Tip6.setLineWrap(true);
        Txa_Tip6.setRows(5);
        Txa_Tip6.setWrapStyleWord(true);
        Txa_Tip6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Tip6.setFocusable(false);
        Txa_Tip6.setOpaque(false);
        Pnl_Tema7.add(Txa_Tip6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1070, 1120, 50));

        Scp_Tema7.setViewportView(Pnl_Tema7);

        Pnl_Temas.add(Scp_Tema7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario7.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario7.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario7.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario7.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario7.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario7.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario7.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario7.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_OperadoresLogicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresLogicos_Off.png"))); // NOI18N
        Btn_Anterior_OperadoresLogicos.setMnemonic(37);
        Btn_Anterior_OperadoresLogicos.setBorderPainted(false);
        Btn_Anterior_OperadoresLogicos.setContentAreaFilled(false);
        Btn_Anterior_OperadoresLogicos.setFocusPainted(false);
        Btn_Anterior_OperadoresLogicos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_OperadoresLogicos.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_OperadoresLogicos.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_OperadoresLogicos.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_OperadoresLogicos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_OperadoresLogicos_On.png"))); // NOI18N
        Btn_Anterior_OperadoresLogicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_OperadoresLogicosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario7.add(Btn_Anterior_OperadoresLogicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Condicionales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Condicionales_Off.png"))); // NOI18N
        Btn_Siguiente_Condicionales.setMnemonic(39);
        Btn_Siguiente_Condicionales.setBorderPainted(false);
        Btn_Siguiente_Condicionales.setContentAreaFilled(false);
        Btn_Siguiente_Condicionales.setFocusPainted(false);
        Btn_Siguiente_Condicionales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Condicionales.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Condicionales.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Condicionales.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Condicionales.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Condicionales_On.png"))); // NOI18N
        Btn_Siguiente_Condicionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_CondicionalesActionPerformed(evt);
            }
        });
        Pnl_Cuestionario7.add(Btn_Siguiente_Condicionales, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario7.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario7.setText("Operadores Lógicos | Cuestionario");
        Lbl_Cuestionario7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario7.add(Lbl_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 610, 45));

        Scp_Cuestionario7.setViewportView(Pnl_Cuestionario7);

        Pnl_Temas.add(Scp_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema8.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema8.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema8.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema8.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema8.setCursor(sRecursos.getCDefault());
        Pnl_Tema8.setMaximumSize(new java.awt.Dimension(1176, 5400));
        Pnl_Tema8.setMinimumSize(new java.awt.Dimension(1176, 5400));
        Pnl_Tema8.setPreferredSize(new java.awt.Dimension(1176, 5400));
        Pnl_Tema8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Condicionales.setFont(sRecursos.getFLabels());
        Lbl_Condicionales.setText("Condicionales");
        Lbl_Condicionales.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema8.add(Lbl_Condicionales, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 340, 45));

        Txa_Analogy7.setEditable(false);
        Txa_Analogy7.setColumns(20);
        Txa_Analogy7.setFont(sRecursos.getFTitles());
        Txa_Analogy7.setRows(5);
        Txa_Analogy7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Analogy7.setFocusable(false);
        Txa_Analogy7.setOpaque(false);
        Pnl_Tema8.add(Txa_Analogy7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1120, 30));

        Txa_SubContent7.setEditable(false);
        Txa_SubContent7.setColumns(20);
        Txa_SubContent7.setFont(sRecursos.getFWindow());
        Txa_SubContent7.setLineWrap(true);
        Txa_SubContent7.setRows(5);
        Txa_SubContent7.setWrapStyleWord(true);
        Txa_SubContent7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent7.setFocusable(false);
        Txa_SubContent7.setOpaque(false);
        Pnl_Tema8.add(Txa_SubContent7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1120, 90));

        Lbl_Sintaxis8_1_1.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis8_1_1.setText("Sintaxis");
        Pnl_Tema8.add(Lbl_Sintaxis8_1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        Txa_CodeDescription7.setEditable(false);
        Txa_CodeDescription7.setColumns(20);
        Txa_CodeDescription7.setFont(sRecursos.getFWindow());
        Txa_CodeDescription7.setLineWrap(true);
        Txa_CodeDescription7.setRows(5);
        Txa_CodeDescription7.setWrapStyleWord(true);
        Txa_CodeDescription7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_CodeDescription7.setFocusable(false);
        Txa_CodeDescription7.setOpaque(false);
        Pnl_Tema8.add(Txa_CodeDescription7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 1120, 70));

        Txa_OutputScreen7.setEditable(false);
        Txa_OutputScreen7.setColumns(20);
        Txa_OutputScreen7.setFont(sRecursos.getFWindow());
        Txa_OutputScreen7.setLineWrap(true);
        Txa_OutputScreen7.setRows(5);
        Txa_OutputScreen7.setWrapStyleWord(true);
        Txa_OutputScreen7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen7.setFocusable(false);
        Txa_OutputScreen7.setOpaque(false);
        Txa_OutputScreen7.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_OutputScreen7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 800, 1120, 90));

        Pnl_CodesThemes7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes7.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 1120, 260));

        Txa_CodeDescription7_1.setEditable(false);
        Txa_CodeDescription7_1.setColumns(20);
        Txa_CodeDescription7_1.setFont(sRecursos.getFWindow());
        Txa_CodeDescription7_1.setLineWrap(true);
        Txa_CodeDescription7_1.setRows(5);
        Txa_CodeDescription7_1.setWrapStyleWord(true);
        Txa_CodeDescription7_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_CodeDescription7_1.setFocusable(false);
        Txa_CodeDescription7_1.setOpaque(false);
        Txa_CodeDescription7_1.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_CodeDescription7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 900, 1120, 30));

        Txa_OutputScreen7_1.setEditable(false);
        Txa_OutputScreen7_1.setColumns(20);
        Txa_OutputScreen7_1.setFont(sRecursos.getFWindow());
        Txa_OutputScreen7_1.setLineWrap(true);
        Txa_OutputScreen7_1.setRows(5);
        Txa_OutputScreen7_1.setWrapStyleWord(true);
        Txa_OutputScreen7_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen7_1.setFocusable(false);
        Txa_OutputScreen7_1.setOpaque(false);
        Txa_OutputScreen7_1.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_OutputScreen7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1360, 1120, 150));

        Pnl_CodesThemes7_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes7_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 970, 1120, 350));

        Lbl_CondicionalesAnidados.setFont(sRecursos.getFB20());
        Lbl_CondicionalesAnidados.setForeground(sRecursos.getColorVerde());
        Lbl_CondicionalesAnidados.setText("Condicionales Anidados");
        Pnl_Tema8.add(Lbl_CondicionalesAnidados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1560, 300, 20));

        Pnl_CodesThemes7_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes7_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1630, 1120, 180));

        Pnl_CodesThemes7_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes7_3.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1850, 1118, 300));

        Txa_OutputScreen7_3.setEditable(false);
        Txa_OutputScreen7_3.setColumns(20);
        Txa_OutputScreen7_3.setFont(sRecursos.getFWindow());
        Txa_OutputScreen7_3.setLineWrap(true);
        Txa_OutputScreen7_3.setRows(5);
        Txa_OutputScreen7_3.setWrapStyleWord(true);
        Txa_OutputScreen7_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen7_3.setFocusable(false);
        Txa_OutputScreen7_3.setOpaque(false);
        Txa_OutputScreen7_3.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_OutputScreen7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2190, 1120, 50));

        Txa_Analogy7_4.setEditable(false);
        Txa_Analogy7_4.setColumns(20);
        Txa_Analogy7_4.setFont(sRecursos.getFTitles());
        Txa_Analogy7_4.setLineWrap(true);
        Txa_Analogy7_4.setRows(5);
        Txa_Analogy7_4.setWrapStyleWord(true);
        Txa_Analogy7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Analogy7_4.setFocusable(false);
        Txa_Analogy7_4.setOpaque(false);
        Txa_Analogy7_4.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_Analogy7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2330, 1120, 40));

        Txa_SubContent7_4.setEditable(false);
        Txa_SubContent7_4.setColumns(20);
        Txa_SubContent7_4.setFont(sRecursos.getFWindow());
        Txa_SubContent7_4.setLineWrap(true);
        Txa_SubContent7_4.setRows(5);
        Txa_SubContent7_4.setWrapStyleWord(true);
        Txa_SubContent7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent7_4.setFocusable(false);
        Txa_SubContent7_4.setOpaque(false);
        Txa_SubContent7_4.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_SubContent7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2380, 1120, 110));

        Txa_CodeDescription7_4.setEditable(false);
        Txa_CodeDescription7_4.setColumns(20);
        Txa_CodeDescription7_4.setFont(sRecursos.getFWindow());
        Txa_CodeDescription7_4.setLineWrap(true);
        Txa_CodeDescription7_4.setRows(5);
        Txa_CodeDescription7_4.setWrapStyleWord(true);
        Txa_CodeDescription7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_CodeDescription7_4.setFocusable(false);
        Txa_CodeDescription7_4.setOpaque(false);
        Txa_CodeDescription7_4.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_CodeDescription7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2530, 1120, 280));

        Txa_OutputScreen7_4.setEditable(false);
        Txa_OutputScreen7_4.setColumns(20);
        Txa_OutputScreen7_4.setFont(sRecursos.getFWindow());
        Txa_OutputScreen7_4.setLineWrap(true);
        Txa_OutputScreen7_4.setRows(5);
        Txa_OutputScreen7_4.setWrapStyleWord(true);
        Txa_OutputScreen7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen7_4.setFocusable(false);
        Txa_OutputScreen7_4.setOpaque(false);
        Txa_OutputScreen7_4.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_OutputScreen7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3170, 1120, 150));

        Pnl_CodesThemes7_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes7_4.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2850, 1118, 280));

        Txa_OutputScreen7_5.setEditable(false);
        Txa_OutputScreen7_5.setColumns(20);
        Txa_OutputScreen7_5.setFont(sRecursos.getFWindow());
        Txa_OutputScreen7_5.setLineWrap(true);
        Txa_OutputScreen7_5.setRows(5);
        Txa_OutputScreen7_5.setWrapStyleWord(true);
        Txa_OutputScreen7_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen7_5.setFocusable(false);
        Txa_OutputScreen7_5.setOpaque(false);
        Txa_OutputScreen7_5.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_OutputScreen7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3600, 1120, 30));

        Pnl_CodesThemes7_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes7_5.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3360, 1118, 190));

        Txa_OutputScreen7_6.setEditable(false);
        Txa_OutputScreen7_6.setColumns(20);
        Txa_OutputScreen7_6.setFont(sRecursos.getFWindow());
        Txa_OutputScreen7_6.setLineWrap(true);
        Txa_OutputScreen7_6.setRows(5);
        Txa_OutputScreen7_6.setWrapStyleWord(true);
        Txa_OutputScreen7_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen7_6.setFocusable(false);
        Txa_OutputScreen7_6.setOpaque(false);
        Txa_OutputScreen7_6.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_OutputScreen7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4000, 1120, 50));

        Pnl_CodesThemes7_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes7_6.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3730, 1118, 230));

        Txa_CodeDescription7_3.setEditable(false);
        Txa_CodeDescription7_3.setColumns(20);
        Txa_CodeDescription7_3.setFont(sRecursos.getFWindow());
        Txa_CodeDescription7_3.setLineWrap(true);
        Txa_CodeDescription7_3.setRows(5);
        Txa_CodeDescription7_3.setWrapStyleWord(true);
        Txa_CodeDescription7_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_CodeDescription7_3.setFocusable(false);
        Txa_CodeDescription7_3.setOpaque(false);
        Txa_CodeDescription7_3.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_CodeDescription7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3640, 1120, 50));

        Lbl_SwitchCase.setFont(sRecursos.getFB20());
        Lbl_SwitchCase.setForeground(sRecursos.getColorVerde());
        Lbl_SwitchCase.setText("Switch Case");
        Pnl_Tema8.add(Lbl_SwitchCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4110, 160, 20));

        Txa_Analogy7_5.setEditable(false);
        Txa_Analogy7_5.setColumns(20);
        Txa_Analogy7_5.setFont(sRecursos.getFTitles());
        Txa_Analogy7_5.setLineWrap(true);
        Txa_Analogy7_5.setRows(5);
        Txa_Analogy7_5.setWrapStyleWord(true);
        Txa_Analogy7_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Analogy7_5.setFocusable(false);
        Txa_Analogy7_5.setOpaque(false);
        Txa_Analogy7_5.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_Analogy7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4140, 1120, 70));

        Txa_CodeDescription7_5.setEditable(false);
        Txa_CodeDescription7_5.setColumns(20);
        Txa_CodeDescription7_5.setFont(sRecursos.getFWindow());
        Txa_CodeDescription7_5.setLineWrap(true);
        Txa_CodeDescription7_5.setRows(5);
        Txa_CodeDescription7_5.setWrapStyleWord(true);
        Txa_CodeDescription7_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_CodeDescription7_5.setFocusable(false);
        Txa_CodeDescription7_5.setOpaque(false);
        Txa_CodeDescription7_5.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_CodeDescription7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4220, 1120, 50));

        Txa_Syntax7_2.setEditable(false);
        Txa_Syntax7_2.setColumns(20);
        Txa_Syntax7_2.setFont(sRecursos.getFWindow());
        Txa_Syntax7_2.setLineWrap(true);
        Txa_Syntax7_2.setRows(5);
        Txa_Syntax7_2.setWrapStyleWord(true);
        Txa_Syntax7_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Syntax7_2.setFocusable(false);
        Txa_Syntax7_2.setOpaque(false);
        Txa_Syntax7_2.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_Syntax7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4310, 1120, 380));

        Txa_OutputScreen7_7.setEditable(false);
        Txa_OutputScreen7_7.setColumns(20);
        Txa_OutputScreen7_7.setFont(sRecursos.getFWindow());
        Txa_OutputScreen7_7.setLineWrap(true);
        Txa_OutputScreen7_7.setRows(5);
        Txa_OutputScreen7_7.setWrapStyleWord(true);
        Txa_OutputScreen7_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen7_7.setFocusable(false);
        Txa_OutputScreen7_7.setOpaque(false);
        Txa_OutputScreen7_7.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema8.add(Txa_OutputScreen7_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5150, 1120, 50));

        Pnl_CodesThemes7_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes7_7.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4730, 1118, 380));

        Lbl_SampleCode8_4.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_4.setText("Ejemplo de Código");
        Pnl_Tema8.add(Lbl_SampleCode8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 20));

        Lbl_Output8_4.setFont(sRecursos.getFTitles());
        Lbl_Output8_4.setText("Output");
        Pnl_Tema8.add(Lbl_Output8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5120, -1, -1));

        Lbl_SampleCode8_5.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_5.setText("Ejemplo de Código");
        Pnl_Tema8.add(Lbl_SampleCode8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4700, -1, 20));

        Lbl_Sintaxis8_5.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis8_5.setText("Sintaxis");
        Pnl_Tema8.add(Lbl_Sintaxis8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4280, -1, 20));

        Lbl_Output8_5.setFont(sRecursos.getFTitles());
        Lbl_Output8_5.setText("Output");
        Pnl_Tema8.add(Lbl_Output8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3970, -1, -1));

        Lbl_SampleCode8_6.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_6.setText("Ejemplo de Código");
        Pnl_Tema8.add(Lbl_SampleCode8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3700, -1, 20));

        Lbl_Output8_6.setFont(sRecursos.getFTitles());
        Lbl_Output8_6.setText("Output");
        Pnl_Tema8.add(Lbl_Output8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3570, -1, -1));

        Lbl_SampleCode8_7.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_7.setText("Ejemplo de Código");
        Pnl_Tema8.add(Lbl_SampleCode8_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3330, -1, 20));

        Lbl_Output8_7.setFont(sRecursos.getFTitles());
        Lbl_Output8_7.setText("Output");
        Pnl_Tema8.add(Lbl_Output8_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3140, -1, -1));

        Lbl_SampleCode8_8.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_8.setText("Ejemplo de Código");
        Pnl_Tema8.add(Lbl_SampleCode8_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2820, -1, 20));

        Lbl_Sintaxis8_6.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis8_6.setText("Sintaxis");
        Pnl_Tema8.add(Lbl_Sintaxis8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2500, -1, 20));

        Lbl_Output8_8.setFont(sRecursos.getFTitles());
        Lbl_Output8_8.setText("Output");
        Pnl_Tema8.add(Lbl_Output8_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2160, -1, -1));

        Lbl_SampleCode8_9.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_9.setText("Ejemplo de Código");
        Pnl_Tema8.add(Lbl_SampleCode8_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 940, -1, 20));

        Lbl_SampleCode8_10.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_10.setText("Ejemplo de Código");
        Pnl_Tema8.add(Lbl_SampleCode8_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1820, -1, 20));

        Lbl_Sintaxis8_7.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis8_7.setText("Sintaxis");
        Pnl_Tema8.add(Lbl_Sintaxis8_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1600, -1, 20));

        Lbl_Output8_9.setFont(sRecursos.getFTitles());
        Lbl_Output8_9.setText("Output");
        Pnl_Tema8.add(Lbl_Output8_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1330, -1, -1));

        Lbl_Output8_10.setFont(sRecursos.getFTitles());
        Lbl_Output8_10.setText("Output");
        Pnl_Tema8.add(Lbl_Output8_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 770, -1, -1));

        Lbl_TryCatch.setFont(sRecursos.getFB20());
        Lbl_TryCatch.setForeground(sRecursos.getColorVerde());
        Lbl_TryCatch.setText("Try-Catch");
        Pnl_Tema8.add(Lbl_TryCatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2300, 120, 20));

        Lbl_SampleCode8_11.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_11.setText("Casos");
        Pnl_Tema8.add(Lbl_SampleCode8_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 20));

        Txa_Casos7.setEditable(false);
        Txa_Casos7.setColumns(20);
        Txa_Casos7.setFont(sRecursos.getFWindow());
        Txa_Casos7.setLineWrap(true);
        Txa_Casos7.setRows(5);
        Txa_Casos7.setWrapStyleWord(true);
        Txa_Casos7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Casos7.setFocusable(false);
        Txa_Casos7.setOpaque(false);
        Pnl_Tema8.add(Txa_Casos7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 1120, 90));

        Spr_CondicionalesAnidados.setForeground(sRecursos.getColorVerde());
        Spr_CondicionalesAnidados.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema8.add(Spr_CondicionalesAnidados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1540, 1120, -1));

        Spr_TryCatch.setForeground(sRecursos.getColorVerde());
        Spr_TryCatch.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema8.add(Spr_TryCatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2270, 1120, -1));

        Spr_SwitchCase.setForeground(sRecursos.getColorVerde());
        Spr_SwitchCase.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema8.add(Spr_SwitchCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4080, 1120, -1));

        Btn_Anterior_Cuestionario7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario7_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario7.setMnemonic(37);
        Btn_Anterior_Cuestionario7.setBorderPainted(false);
        Btn_Anterior_Cuestionario7.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario7.setFocusPainted(false);
        Btn_Anterior_Cuestionario7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario7.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario7.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario7.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario7_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario7ActionPerformed(evt);
            }
        });
        Pnl_Tema8.add(Btn_Anterior_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5300, 254, 64));

        Btn_Siguiente_Cuestionario8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario8_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario8.setMnemonic(39);
        Btn_Siguiente_Cuestionario8.setBorderPainted(false);
        Btn_Siguiente_Cuestionario8.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario8.setFocusPainted(false);
        Btn_Siguiente_Cuestionario8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario8.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario8.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario8.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario8_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario8ActionPerformed(evt);
            }
        });
        Pnl_Tema8.add(Btn_Siguiente_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 5300, 254, 64));

        Scp_Tema8.setViewportView(Pnl_Tema8);

        Pnl_Temas.add(Scp_Tema8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario8.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario8.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario8.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario8.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario8.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario8.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario8.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario8.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Condicionales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Condicionales_Off.png"))); // NOI18N
        Btn_Anterior_Condicionales.setMnemonic(37);
        Btn_Anterior_Condicionales.setBorderPainted(false);
        Btn_Anterior_Condicionales.setContentAreaFilled(false);
        Btn_Anterior_Condicionales.setFocusPainted(false);
        Btn_Anterior_Condicionales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Condicionales.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Condicionales.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Condicionales.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Condicionales.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Condicionales_On.png"))); // NOI18N
        Btn_Anterior_Condicionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_CondicionalesActionPerformed(evt);
            }
        });
        Pnl_Cuestionario8.add(Btn_Anterior_Condicionales, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Bucles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Bucles_Off.png"))); // NOI18N
        Btn_Siguiente_Bucles.setMnemonic(39);
        Btn_Siguiente_Bucles.setBorderPainted(false);
        Btn_Siguiente_Bucles.setContentAreaFilled(false);
        Btn_Siguiente_Bucles.setFocusPainted(false);
        Btn_Siguiente_Bucles.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Bucles.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Bucles.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Bucles.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Bucles.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Bucles_On.png"))); // NOI18N
        Btn_Siguiente_Bucles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_BuclesActionPerformed(evt);
            }
        });
        Pnl_Cuestionario8.add(Btn_Siguiente_Bucles, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario8.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario8.setText("Condicionales | Cuestionario");
        Lbl_Cuestionario8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario8.add(Lbl_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 610, 45));

        Scp_Cuestionario8.setViewportView(Pnl_Cuestionario8);

        Pnl_Temas.add(Scp_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema9.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema9.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema9.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema9.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema9.setCursor(sRecursos.getCDefault());
        Pnl_Tema9.setMaximumSize(new java.awt.Dimension(1176, 2380));
        Pnl_Tema9.setMinimumSize(new java.awt.Dimension(1176, 2380));
        Pnl_Tema9.setPreferredSize(new java.awt.Dimension(1176, 2380));
        Pnl_Tema9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Bucles.setFont(sRecursos.getFLabels());
        Lbl_Bucles.setText("Bucles");
        Lbl_Bucles.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema9.add(Lbl_Bucles, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 340, 45));

        Txa_Analogy8.setEditable(false);
        Txa_Analogy8.setColumns(20);
        Txa_Analogy8.setFont(sRecursos.getFTitleTips());
        Txa_Analogy8.setRows(5);
        Txa_Analogy8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Analogy8.setFocusable(false);
        Txa_Analogy8.setOpaque(false);
        Pnl_Tema9.add(Txa_Analogy8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1120, 80));

        Txa_SubContent8_1.setEditable(false);
        Txa_SubContent8_1.setColumns(20);
        Txa_SubContent8_1.setFont(sRecursos.getFWindow());
        Txa_SubContent8_1.setLineWrap(true);
        Txa_SubContent8_1.setRows(5);
        Txa_SubContent8_1.setWrapStyleWord(true);
        Txa_SubContent8_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent8_1.setFocusable(false);
        Txa_SubContent8_1.setOpaque(false);
        Pnl_Tema9.add(Txa_SubContent8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 1120, 50));

        Lbl_BucleWhile.setFont(sRecursos.getFTitleEditor());
        Lbl_BucleWhile.setForeground(sRecursos.getColorVerde());
        Lbl_BucleWhile.setText("Bucle While");
        Pnl_Tema9.add(Lbl_BucleWhile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 20));

        Txa_SubContent8_2.setEditable(false);
        Txa_SubContent8_2.setColumns(20);
        Txa_SubContent8_2.setFont(sRecursos.getFWindow());
        Txa_SubContent8_2.setLineWrap(true);
        Txa_SubContent8_2.setRows(5);
        Txa_SubContent8_2.setWrapStyleWord(true);
        Txa_SubContent8_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent8_2.setFocusable(false);
        Txa_SubContent8_2.setOpaque(false);
        Pnl_Tema9.add(Txa_SubContent8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 1120, 30));

        Lbl_Sintaxis8_1.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis8_1.setText("Sintaxis");
        Pnl_Tema9.add(Lbl_Sintaxis8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 20));

        Txa_Sintaxis8_1.setEditable(false);
        Txa_Sintaxis8_1.setColumns(20);
        Txa_Sintaxis8_1.setFont(sRecursos.getFWindow());
        Txa_Sintaxis8_1.setLineWrap(true);
        Txa_Sintaxis8_1.setRows(5);
        Txa_Sintaxis8_1.setWrapStyleWord(true);
        Txa_Sintaxis8_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Sintaxis8_1.setFocusable(false);
        Txa_Sintaxis8_1.setOpaque(false);
        Pnl_Tema9.add(Txa_Sintaxis8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 1120, 70));

        Lbl_SampleCode8_1.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_1.setText("Ejemplo de Código");
        Pnl_Tema9.add(Lbl_SampleCode8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 20));

        Pnl_CodesThemes8_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes8_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema9.add(Pnl_CodesThemes8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 1120, 200));

        Lbl_Output8_1.setFont(sRecursos.getFTitles());
        Lbl_Output8_1.setText("Output");
        Pnl_Tema9.add(Lbl_Output8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, -1, -1));

        Txa_OutputScreen8_1.setEditable(false);
        Txa_OutputScreen8_1.setColumns(20);
        Txa_OutputScreen8_1.setFont(sRecursos.getFWindow());
        Txa_OutputScreen8_1.setLineWrap(true);
        Txa_OutputScreen8_1.setRows(5);
        Txa_OutputScreen8_1.setWrapStyleWord(true);
        Txa_OutputScreen8_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen8_1.setFocusable(false);
        Txa_OutputScreen8_1.setOpaque(false);
        Txa_OutputScreen8_1.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema9.add(Txa_OutputScreen8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 740, 1120, 30));

        Lbl_Tip8_1.setFont(sRecursos.getFTitles());
        Lbl_Tip8_1.setText("Tip");
        Pnl_Tema9.add(Lbl_Tip8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 780, -1, -1));

        Txa_Tips8_1.setEditable(false);
        Txa_Tips8_1.setColumns(20);
        Txa_Tips8_1.setFont(sRecursos.getFWindow());
        Txa_Tips8_1.setLineWrap(true);
        Txa_Tips8_1.setRows(5);
        Txa_Tips8_1.setWrapStyleWord(true);
        Txa_Tips8_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Tips8_1.setFocusable(false);
        Txa_Tips8_1.setOpaque(false);
        Pnl_Tema9.add(Txa_Tips8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 810, 1120, 30));

        Lbl_BucleFor.setFont(sRecursos.getFTitleEditor());
        Lbl_BucleFor.setForeground(sRecursos.getColorVerde());
        Lbl_BucleFor.setText("Bucle For");
        Pnl_Tema9.add(Lbl_BucleFor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 920, -1, 20));

        Txa_SubContent8_3.setEditable(false);
        Txa_SubContent8_3.setColumns(20);
        Txa_SubContent8_3.setFont(sRecursos.getFWindow());
        Txa_SubContent8_3.setLineWrap(true);
        Txa_SubContent8_3.setRows(5);
        Txa_SubContent8_3.setWrapStyleWord(true);
        Txa_SubContent8_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent8_3.setFocusable(false);
        Txa_SubContent8_3.setOpaque(false);
        Pnl_Tema9.add(Txa_SubContent8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 950, 1120, 30));

        Lbl_Sintaxis8_2.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis8_2.setText("Sintaxis");
        Pnl_Tema9.add(Lbl_Sintaxis8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 990, -1, 20));

        Txa_Sintaxis8_2.setEditable(false);
        Txa_Sintaxis8_2.setColumns(20);
        Txa_Sintaxis8_2.setFont(sRecursos.getFWindow());
        Txa_Sintaxis8_2.setLineWrap(true);
        Txa_Sintaxis8_2.setRows(5);
        Txa_Sintaxis8_2.setWrapStyleWord(true);
        Txa_Sintaxis8_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Sintaxis8_2.setFocusable(false);
        Txa_Sintaxis8_2.setOpaque(false);
        Pnl_Tema9.add(Txa_Sintaxis8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1020, 1120, 70));

        Lbl_SampleCode8_2.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_2.setText("Ejemplo de Código");
        Pnl_Tema9.add(Lbl_SampleCode8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1100, -1, 20));

        Pnl_CodesThemes8_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes8_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema9.add(Pnl_CodesThemes8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1130, 1118, 200));

        Lbl_Output8_2.setFont(sRecursos.getFTitles());
        Lbl_Output8_2.setText("Output");
        Pnl_Tema9.add(Lbl_Output8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1340, -1, -1));

        Txa_OutputScreen8_2.setEditable(false);
        Txa_OutputScreen8_2.setColumns(20);
        Txa_OutputScreen8_2.setFont(sRecursos.getFWindow());
        Txa_OutputScreen8_2.setLineWrap(true);
        Txa_OutputScreen8_2.setRows(5);
        Txa_OutputScreen8_2.setWrapStyleWord(true);
        Txa_OutputScreen8_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen8_2.setFocusable(false);
        Txa_OutputScreen8_2.setOpaque(false);
        Txa_OutputScreen8_2.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema9.add(Txa_OutputScreen8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1370, 1120, 30));

        Lbl_BucleDoWhile.setFont(sRecursos.getFTitleEditor());
        Lbl_BucleDoWhile.setForeground(sRecursos.getColorVerde());
        Lbl_BucleDoWhile.setText("Bucle Do-While");
        Pnl_Tema9.add(Lbl_BucleDoWhile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1470, -1, 20));

        Txa_SubContent8_4.setEditable(false);
        Txa_SubContent8_4.setColumns(20);
        Txa_SubContent8_4.setFont(sRecursos.getFWindow());
        Txa_SubContent8_4.setLineWrap(true);
        Txa_SubContent8_4.setRows(5);
        Txa_SubContent8_4.setWrapStyleWord(true);
        Txa_SubContent8_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent8_4.setFocusable(false);
        Txa_SubContent8_4.setOpaque(false);
        Pnl_Tema9.add(Txa_SubContent8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1500, 1120, 30));

        Lbl_Sintaxis8_3.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis8_3.setText("Sintaxis");
        Pnl_Tema9.add(Lbl_Sintaxis8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1550, -1, 20));

        Txa_Sintaxis8_3.setEditable(false);
        Txa_Sintaxis8_3.setColumns(20);
        Txa_Sintaxis8_3.setFont(sRecursos.getFWindow());
        Txa_Sintaxis8_3.setLineWrap(true);
        Txa_Sintaxis8_3.setRows(5);
        Txa_Sintaxis8_3.setWrapStyleWord(true);
        Txa_Sintaxis8_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Sintaxis8_3.setFocusable(false);
        Txa_Sintaxis8_3.setOpaque(false);
        Pnl_Tema9.add(Txa_Sintaxis8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1580, 1120, 90));

        Lbl_SampleCode8_3.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_3.setText("Ejemplo de Código");
        Pnl_Tema9.add(Lbl_SampleCode8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1690, -1, 20));

        Pnl_CodesThemes8_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes8_3.setLayout(new java.awt.CardLayout());
        Pnl_Tema9.add(Pnl_CodesThemes8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1720, 1116, 200));

        Lbl_Output8_3.setFont(sRecursos.getFTitles());
        Lbl_Output8_3.setText("Output");
        Pnl_Tema9.add(Lbl_Output8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1930, -1, -1));

        Txa_OutputScreen8_3.setEditable(false);
        Txa_OutputScreen8_3.setColumns(20);
        Txa_OutputScreen8_3.setFont(sRecursos.getFWindow());
        Txa_OutputScreen8_3.setLineWrap(true);
        Txa_OutputScreen8_3.setRows(5);
        Txa_OutputScreen8_3.setWrapStyleWord(true);
        Txa_OutputScreen8_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen8_3.setFocusable(false);
        Txa_OutputScreen8_3.setOpaque(false);
        Txa_OutputScreen8_3.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema9.add(Txa_OutputScreen8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1960, 1120, 130));

        Lbl_Tip8_2.setFont(sRecursos.getFTitles());
        Lbl_Tip8_2.setText("Tip");
        Pnl_Tema9.add(Lbl_Tip8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2110, -1, -1));

        Txa_Tips8_2.setEditable(false);
        Txa_Tips8_2.setColumns(20);
        Txa_Tips8_2.setFont(sRecursos.getFWindow());
        Txa_Tips8_2.setLineWrap(true);
        Txa_Tips8_2.setRows(5);
        Txa_Tips8_2.setWrapStyleWord(true);
        Txa_Tips8_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Tips8_2.setFocusable(false);
        Txa_Tips8_2.setOpaque(false);
        Pnl_Tema9.add(Txa_Tips8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2140, 1120, 70));

        Btn_Anterior_Cuestionario8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario8_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario8.setMnemonic(37);
        Btn_Anterior_Cuestionario8.setBorderPainted(false);
        Btn_Anterior_Cuestionario8.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario8.setFocusPainted(false);
        Btn_Anterior_Cuestionario8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario8.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario8.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario8.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario8_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario8ActionPerformed(evt);
            }
        });
        Pnl_Tema9.add(Btn_Anterior_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 2270, 254, 64));

        Btn_Siguiente_Cuestionario9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario9_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario9.setMnemonic(39);
        Btn_Siguiente_Cuestionario9.setBorderPainted(false);
        Btn_Siguiente_Cuestionario9.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario9.setFocusPainted(false);
        Btn_Siguiente_Cuestionario9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario9.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario9.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario9.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario9_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario9ActionPerformed(evt);
            }
        });
        Pnl_Tema9.add(Btn_Siguiente_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 2270, 254, 64));

        Spr_DoWhile.setForeground(sRecursos.getColorVerde());
        Spr_DoWhile.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema9.add(Spr_DoWhile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1440, 1120, -1));

        Spr_While.setForeground(sRecursos.getColorVerde());
        Spr_While.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema9.add(Spr_While, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 245, 1120, -1));

        Spr_For.setForeground(sRecursos.getColorVerde());
        Spr_For.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema9.add(Spr_For, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 1120, -1));

        Scp_Tema9.setViewportView(Pnl_Tema9);

        Pnl_Temas.add(Scp_Tema9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario9.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario9.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario9.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario9.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario9.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario9.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario9.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario9.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Bucles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Bucles_Off.png"))); // NOI18N
        Btn_Anterior_Bucles.setMnemonic(37);
        Btn_Anterior_Bucles.setBorderPainted(false);
        Btn_Anterior_Bucles.setContentAreaFilled(false);
        Btn_Anterior_Bucles.setFocusPainted(false);
        Btn_Anterior_Bucles.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Bucles.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Bucles.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Bucles.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Bucles.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Bucles_On.png"))); // NOI18N
        Btn_Anterior_Bucles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_BuclesActionPerformed(evt);
            }
        });
        Pnl_Cuestionario9.add(Btn_Anterior_Bucles, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Ejercicio2_Intermedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Ejercicio2_Off.png"))); // NOI18N
        Btn_Siguiente_Ejercicio2_Intermedio.setMnemonic(39);
        Btn_Siguiente_Ejercicio2_Intermedio.setBorderPainted(false);
        Btn_Siguiente_Ejercicio2_Intermedio.setContentAreaFilled(false);
        Btn_Siguiente_Ejercicio2_Intermedio.setFocusPainted(false);
        Btn_Siguiente_Ejercicio2_Intermedio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Ejercicio2_Intermedio.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Ejercicio2_Intermedio.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Ejercicio2_Intermedio.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Ejercicio2_Intermedio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Ejercicio2_On.png"))); // NOI18N
        Btn_Siguiente_Ejercicio2_Intermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Ejercicio2_IntermedioActionPerformed(evt);
            }
        });
        Pnl_Cuestionario9.add(Btn_Siguiente_Ejercicio2_Intermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario9.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario9.setText("Bucles | Cuestionario");
        Lbl_Cuestionario9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario9.add(Lbl_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 610, 45));

        Scp_Cuestionario9.setViewportView(Pnl_Cuestionario9);

        Pnl_Temas.add(Scp_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Ejercicio2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Ejercicio2.setMaximumSize(sRecursos.getDTamanio());
        Scp_Ejercicio2.setMinimumSize(sRecursos.getDTamanio());
        Scp_Ejercicio2.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Ejercicio2_Aprender.setBackground(sRecursos.getCPrincipal());
        Pnl_Ejercicio2_Aprender.setCursor(sRecursos.getCDefault());
        Pnl_Ejercicio2_Aprender.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Ejercicio2_Aprender.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Ejercicio2_Aprender.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Ejercicio2_Aprender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario9_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario9.setMnemonic(37);
        Btn_Anterior_Cuestionario9.setBorderPainted(false);
        Btn_Anterior_Cuestionario9.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario9.setFocusPainted(false);
        Btn_Anterior_Cuestionario9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario9.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario9.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario9.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario9_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario9ActionPerformed(evt);
            }
        });
        Pnl_Ejercicio2_Aprender.add(Btn_Anterior_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_FuncionesyProc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_FuncyProc_Off.png"))); // NOI18N
        Btn_Siguiente_FuncionesyProc.setMnemonic(39);
        Btn_Siguiente_FuncionesyProc.setBorderPainted(false);
        Btn_Siguiente_FuncionesyProc.setContentAreaFilled(false);
        Btn_Siguiente_FuncionesyProc.setFocusPainted(false);
        Btn_Siguiente_FuncionesyProc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_FuncionesyProc.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_FuncionesyProc.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_FuncionesyProc.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_FuncionesyProc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_FuncyProc_On.png"))); // NOI18N
        Btn_Siguiente_FuncionesyProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_FuncionesyProcActionPerformed(evt);
            }
        });
        Pnl_Ejercicio2_Aprender.add(Btn_Siguiente_FuncionesyProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Ejercicio2_Intermedio.setFont(sRecursos.getFLabels());
        Lbl_Ejercicio2_Intermedio.setText("Ejercicio 2 | Intermedio");
        Lbl_Ejercicio2_Intermedio.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Ejercicio2_Aprender.add(Lbl_Ejercicio2_Intermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 610, 45));

        Btn_EnviarEjercicio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/EnviarAprender_Off.png"))); // NOI18N
        Btn_EnviarEjercicio2.setBorderPainted(false);
        Btn_EnviarEjercicio2.setContentAreaFilled(false);
        Btn_EnviarEjercicio2.setFocusPainted(false);
        Btn_EnviarEjercicio2.setFocusable(false);
        Btn_EnviarEjercicio2.setMaximumSize(sRecursos.getDTamanioBotones());
        Btn_EnviarEjercicio2.setMinimumSize(sRecursos.getDTamanioBotones());
        Btn_EnviarEjercicio2.setPreferredSize(sRecursos.getDTamanioBotones());
        Btn_EnviarEjercicio2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/EnviarAprender_On.png"))); // NOI18N
        Btn_EnviarEjercicio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EnviarEjercicio2ActionPerformed(evt);
            }
        });
        Pnl_Ejercicio2_Aprender.add(Btn_EnviarEjercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 990, 170, 50));

        Pnl_SyntaxEjercicio2.setBackground(new java.awt.Color(204, 204, 204));
        Pnl_SyntaxEjercicio2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_SyntaxEjercicio2.setLayout(new java.awt.CardLayout());
        Pnl_Ejercicio2_Aprender.add(Pnl_SyntaxEjercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1050, 1080, 330));

        Scp_Ejercicio2.setViewportView(Pnl_Ejercicio2_Aprender);

        Pnl_Temas.add(Scp_Ejercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema10.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema10.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema10.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema10.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema10.setCursor(sRecursos.getCDefault());
        Pnl_Tema10.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema10.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema10.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Tema10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Ejercicio2_Intermedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Ejercicio2_Off.png"))); // NOI18N
        Btn_Anterior_Ejercicio2_Intermedio.setMnemonic(37);
        Btn_Anterior_Ejercicio2_Intermedio.setBorderPainted(false);
        Btn_Anterior_Ejercicio2_Intermedio.setContentAreaFilled(false);
        Btn_Anterior_Ejercicio2_Intermedio.setFocusPainted(false);
        Btn_Anterior_Ejercicio2_Intermedio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Ejercicio2_Intermedio.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Ejercicio2_Intermedio.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Ejercicio2_Intermedio.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Ejercicio2_Intermedio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Ejercicio2_On.png"))); // NOI18N
        Btn_Anterior_Ejercicio2_Intermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Ejercicio2_IntermedioActionPerformed(evt);
            }
        });
        Pnl_Tema10.add(Btn_Anterior_Ejercicio2_Intermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario10_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario10.setMnemonic(39);
        Btn_Siguiente_Cuestionario10.setBorderPainted(false);
        Btn_Siguiente_Cuestionario10.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario10.setFocusPainted(false);
        Btn_Siguiente_Cuestionario10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario10.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario10.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario10.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario10_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario10ActionPerformed(evt);
            }
        });
        Pnl_Tema10.add(Btn_Siguiente_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_FuncionesyProcs.setFont(sRecursos.getFLabels());
        Lbl_FuncionesyProcs.setText("Funciones y Procedimientos");
        Lbl_FuncionesyProcs.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema10.add(Lbl_FuncionesyProcs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 460, 45));

        Scp_Tema10.setViewportView(Pnl_Tema10);

        Pnl_Temas.add(Scp_Tema10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario10.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario10.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario10.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario10.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario10.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario10.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario10.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario10.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_FuncyProc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_FuncyProc_Off.png"))); // NOI18N
        Btn_Anterior_FuncyProc.setMnemonic(37);
        Btn_Anterior_FuncyProc.setBorderPainted(false);
        Btn_Anterior_FuncyProc.setContentAreaFilled(false);
        Btn_Anterior_FuncyProc.setFocusPainted(false);
        Btn_Anterior_FuncyProc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_FuncyProc.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_FuncyProc.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_FuncyProc.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_FuncyProc.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_FuncyProc_On.png"))); // NOI18N
        Btn_Anterior_FuncyProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_FuncyProcActionPerformed(evt);
            }
        });
        Pnl_Cuestionario10.add(Btn_Anterior_FuncyProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Recursion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Recursion_Off.png"))); // NOI18N
        Btn_Siguiente_Recursion.setMnemonic(39);
        Btn_Siguiente_Recursion.setBorderPainted(false);
        Btn_Siguiente_Recursion.setContentAreaFilled(false);
        Btn_Siguiente_Recursion.setFocusPainted(false);
        Btn_Siguiente_Recursion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Recursion.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Recursion.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Recursion.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Recursion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Recursion_On.png"))); // NOI18N
        Btn_Siguiente_Recursion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_RecursionActionPerformed(evt);
            }
        });
        Pnl_Cuestionario10.add(Btn_Siguiente_Recursion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario10.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario10.setText("Funciones y Procedimientos | Cuestionario");
        Lbl_Cuestionario10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario10.add(Lbl_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 650, 45));

        Scp_Cuestionario10.setViewportView(Pnl_Cuestionario10);

        Pnl_Temas.add(Scp_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema11.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema11.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema11.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema11.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema11.setCursor(sRecursos.getCDefault());
        Pnl_Tema11.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema11.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema11.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Tema11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario10_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario10.setMnemonic(37);
        Btn_Anterior_Cuestionario10.setBorderPainted(false);
        Btn_Anterior_Cuestionario10.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario10.setFocusPainted(false);
        Btn_Anterior_Cuestionario10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario10.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario10.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario10.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario10_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario10ActionPerformed(evt);
            }
        });
        Pnl_Tema11.add(Btn_Anterior_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario11_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario11.setMnemonic(39);
        Btn_Siguiente_Cuestionario11.setBorderPainted(false);
        Btn_Siguiente_Cuestionario11.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario11.setFocusPainted(false);
        Btn_Siguiente_Cuestionario11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario11.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario11.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario11.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario11_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario11ActionPerformed(evt);
            }
        });
        Pnl_Tema11.add(Btn_Siguiente_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Recursion.setFont(sRecursos.getFLabels());
        Lbl_Recursion.setText("Recursión");
        Lbl_Recursion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema11.add(Lbl_Recursion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 340, 45));

        Scp_Tema11.setViewportView(Pnl_Tema11);

        Pnl_Temas.add(Scp_Tema11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario11.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario11.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario11.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario11.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario11.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario11.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario11.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario11.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Recursion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Recursion_Off.png"))); // NOI18N
        Btn_Anterior_Recursion.setMnemonic(37);
        Btn_Anterior_Recursion.setBorderPainted(false);
        Btn_Anterior_Recursion.setContentAreaFilled(false);
        Btn_Anterior_Recursion.setFocusPainted(false);
        Btn_Anterior_Recursion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Recursion.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Recursion.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Recursion.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Recursion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Recursion_On.png"))); // NOI18N
        Btn_Anterior_Recursion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_RecursionActionPerformed(evt);
            }
        });
        Pnl_Cuestionario11.add(Btn_Anterior_Recursion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_EDDBasicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EDDBasicas_Off.png"))); // NOI18N
        Btn_Siguiente_EDDBasicas.setMnemonic(39);
        Btn_Siguiente_EDDBasicas.setBorderPainted(false);
        Btn_Siguiente_EDDBasicas.setContentAreaFilled(false);
        Btn_Siguiente_EDDBasicas.setFocusPainted(false);
        Btn_Siguiente_EDDBasicas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_EDDBasicas.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EDDBasicas.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EDDBasicas.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EDDBasicas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EDDBasicas_On.png"))); // NOI18N
        Btn_Siguiente_EDDBasicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_EDDBasicasActionPerformed(evt);
            }
        });
        Pnl_Cuestionario11.add(Btn_Siguiente_EDDBasicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario11.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario11.setText("Recursión | Cuestionario");
        Lbl_Cuestionario11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario11.add(Lbl_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 610, 45));

        Scp_Cuestionario11.setViewportView(Pnl_Cuestionario11);

        Pnl_Temas.add(Scp_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema12.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema12.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema12.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema12.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema12.setCursor(sRecursos.getCDefault());
        Pnl_Tema12.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema12.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema12.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Tema12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario11_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario11.setMnemonic(37);
        Btn_Anterior_Cuestionario11.setBorderPainted(false);
        Btn_Anterior_Cuestionario11.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario11.setFocusPainted(false);
        Btn_Anterior_Cuestionario11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario11.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario11.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario11.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario11_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario11ActionPerformed(evt);
            }
        });
        Pnl_Tema12.add(Btn_Anterior_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario12_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario12.setMnemonic(39);
        Btn_Siguiente_Cuestionario12.setBorderPainted(false);
        Btn_Siguiente_Cuestionario12.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario12.setFocusPainted(false);
        Btn_Siguiente_Cuestionario12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario12.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario12.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario12.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario12_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario12ActionPerformed(evt);
            }
        });
        Pnl_Tema12.add(Btn_Siguiente_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_EDDBasicas.setFont(sRecursos.getFLabels());
        Lbl_EDDBasicas.setText("Estructuras de Datos Básicas");
        Lbl_EDDBasicas.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema12.add(Lbl_EDDBasicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 450, 45));

        Scp_Tema12.setViewportView(Pnl_Tema12);

        Pnl_Temas.add(Scp_Tema12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario12.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario12.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario12.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario12.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario12.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario12.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario12.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario12.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_EDDBasicas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_EDDBasicas_Off.png"))); // NOI18N
        Btn_Anterior_EDDBasicas.setMnemonic(37);
        Btn_Anterior_EDDBasicas.setBorderPainted(false);
        Btn_Anterior_EDDBasicas.setContentAreaFilled(false);
        Btn_Anterior_EDDBasicas.setFocusPainted(false);
        Btn_Anterior_EDDBasicas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_EDDBasicas.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_EDDBasicas.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_EDDBasicas.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_EDDBasicas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_EDDBasicas_On.png"))); // NOI18N
        Btn_Anterior_EDDBasicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_EDDBasicasActionPerformed(evt);
            }
        });
        Pnl_Cuestionario12.add(Btn_Anterior_EDDBasicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_EDDAvanzadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EDDAvanzadas_Off.png"))); // NOI18N
        Btn_Siguiente_EDDAvanzadas.setMnemonic(39);
        Btn_Siguiente_EDDAvanzadas.setBorderPainted(false);
        Btn_Siguiente_EDDAvanzadas.setContentAreaFilled(false);
        Btn_Siguiente_EDDAvanzadas.setFocusPainted(false);
        Btn_Siguiente_EDDAvanzadas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_EDDAvanzadas.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EDDAvanzadas.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EDDAvanzadas.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EDDAvanzadas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EDDAvanzadas_On.png"))); // NOI18N
        Btn_Siguiente_EDDAvanzadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_EDDAvanzadasActionPerformed(evt);
            }
        });
        Pnl_Cuestionario12.add(Btn_Siguiente_EDDAvanzadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario12.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario12.setText("Estructuras de Datos Básicas | Cuestionario");
        Lbl_Cuestionario12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario12.add(Lbl_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 630, 45));

        Scp_Cuestionario12.setViewportView(Pnl_Cuestionario12);

        Pnl_Temas.add(Scp_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema13.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema13.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema13.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema13.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema13.setCursor(sRecursos.getCDefault());
        Pnl_Tema13.setMaximumSize(new java.awt.Dimension(1176, 4120));
        Pnl_Tema13.setMinimumSize(new java.awt.Dimension(1176, 4120));
        Pnl_Tema13.setPreferredSize(new java.awt.Dimension(1176, 4120));
        Pnl_Tema13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario12_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario12.setMnemonic(37);
        Btn_Anterior_Cuestionario12.setBorderPainted(false);
        Btn_Anterior_Cuestionario12.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario12.setFocusPainted(false);
        Btn_Anterior_Cuestionario12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario12.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario12.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario12.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario12_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario12ActionPerformed(evt);
            }
        });
        Pnl_Tema13.add(Btn_Anterior_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 4020, 254, 64));

        Btn_Siguiente_Cuestionario13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario13_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario13.setMnemonic(39);
        Btn_Siguiente_Cuestionario13.setBorderPainted(false);
        Btn_Siguiente_Cuestionario13.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario13.setFocusPainted(false);
        Btn_Siguiente_Cuestionario13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario13.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario13.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario13.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario13_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario13ActionPerformed(evt);
            }
        });
        Pnl_Tema13.add(Btn_Siguiente_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 4020, 254, 64));

        Lbl_EDDIntermedias.setFont(sRecursos.getFLabels());
        Lbl_EDDIntermedias.setText("Estructuras de Datos Intermedias");
        Lbl_EDDIntermedias.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema13.add(Lbl_EDDIntermedias, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 510, 45));

        Txa_Analogy12.setEditable(false);
        Txa_Analogy12.setColumns(20);
        Txa_Analogy12.setFont(sRecursos.getFTitleTips());
        Txa_Analogy12.setRows(5);
        Txa_Analogy12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Analogy12.setFocusable(false);
        Txa_Analogy12.setOpaque(false);
        Pnl_Tema13.add(Txa_Analogy12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1120, 50));

        Txa_SubContent12_1.setEditable(false);
        Txa_SubContent12_1.setColumns(20);
        Txa_SubContent12_1.setFont(sRecursos.getFWindow());
        Txa_SubContent12_1.setLineWrap(true);
        Txa_SubContent12_1.setRows(5);
        Txa_SubContent12_1.setWrapStyleWord(true);
        Txa_SubContent12_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent12_1.setFocusable(false);
        Txa_SubContent12_1.setOpaque(false);
        Pnl_Tema13.add(Txa_SubContent12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1120, 50));

        Spr_Sets.setForeground(sRecursos.getColorVerde());
        Spr_Sets.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_Sets, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 1120, -1));

        Lbl_Sets.setFont(sRecursos.getFTitleEditor());
        Lbl_Sets.setForeground(sRecursos.getColorVerde());
        Lbl_Sets.setText("Sets");
        Pnl_Tema13.add(Lbl_Sets, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        Txa_SubContent12_2.setEditable(false);
        Txa_SubContent12_2.setColumns(20);
        Txa_SubContent12_2.setFont(sRecursos.getFWindow());
        Txa_SubContent12_2.setLineWrap(true);
        Txa_SubContent12_2.setRows(5);
        Txa_SubContent12_2.setWrapStyleWord(true);
        Txa_SubContent12_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent12_2.setFocusable(false);
        Txa_SubContent12_2.setOpaque(false);
        Pnl_Tema13.add(Txa_SubContent12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 1120, 50));

        Lbl_MetodosBasicos12_1.setFont(sRecursos.getFTitles());
        Lbl_MetodosBasicos12_1.setText("Métodos Básicos");
        Pnl_Tema13.add(Lbl_MetodosBasicos12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 20));

        Txa_SubContent12_3.setEditable(false);
        Txa_SubContent12_3.setColumns(20);
        Txa_SubContent12_3.setFont(sRecursos.getFWindow());
        Txa_SubContent12_3.setLineWrap(true);
        Txa_SubContent12_3.setRows(5);
        Txa_SubContent12_3.setWrapStyleWord(true);
        Txa_SubContent12_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent12_3.setFocusable(false);
        Txa_SubContent12_3.setOpaque(false);
        Pnl_Tema13.add(Txa_SubContent12_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 1120, 260));

        Spr_HashSet.setForeground(sRecursos.getColorVerde());
        Spr_HashSet.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_HashSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 1120, -1));

        Lbl_SampleCode9_4.setFont(sRecursos.getFTitles());
        Lbl_SampleCode9_4.setText("HashSet");
        Pnl_Tema13.add(Lbl_SampleCode9_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, -1, 20));

        Txa_SubContent12_4.setEditable(false);
        Txa_SubContent12_4.setColumns(20);
        Txa_SubContent12_4.setFont(sRecursos.getFWindow());
        Txa_SubContent12_4.setLineWrap(true);
        Txa_SubContent12_4.setRows(5);
        Txa_SubContent12_4.setWrapStyleWord(true);
        Txa_SubContent12_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent12_4.setFocusable(false);
        Txa_SubContent12_4.setOpaque(false);
        Pnl_Tema13.add(Txa_SubContent12_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, 1120, 50));

        Lbl_Sintaxis12_1.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis12_1.setText("Sintaxis");
        Pnl_Tema13.add(Lbl_Sintaxis12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 780, -1, 20));

        Txa_Sintaxis12_1.setEditable(false);
        Txa_Sintaxis12_1.setColumns(20);
        Txa_Sintaxis12_1.setFont(sRecursos.getFWindow());
        Txa_Sintaxis12_1.setLineWrap(true);
        Txa_Sintaxis12_1.setRows(5);
        Txa_Sintaxis12_1.setWrapStyleWord(true);
        Txa_Sintaxis12_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Sintaxis12_1.setFocusable(false);
        Txa_Sintaxis12_1.setOpaque(false);
        Pnl_Tema13.add(Txa_Sintaxis12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 810, 1120, 30));

        Lbl_SampleCode12_1.setFont(sRecursos.getFTitles());
        Lbl_SampleCode12_1.setText("Ejemplo de Código");
        Pnl_Tema13.add(Lbl_SampleCode12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 860, -1, 20));

        Pnl_CodesThemes12_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes12_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema13.add(Pnl_CodesThemes12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 890, 1120, 280));

        Lbl_Output12_1.setFont(sRecursos.getFTitles());
        Lbl_Output12_1.setText("Output");
        Pnl_Tema13.add(Lbl_Output12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1180, -1, -1));

        Txa_OutputScreen12_1.setEditable(false);
        Txa_OutputScreen12_1.setColumns(20);
        Txa_OutputScreen12_1.setFont(sRecursos.getFWindow());
        Txa_OutputScreen12_1.setLineWrap(true);
        Txa_OutputScreen12_1.setRows(5);
        Txa_OutputScreen12_1.setWrapStyleWord(true);
        Txa_OutputScreen12_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen12_1.setFocusable(false);
        Txa_OutputScreen12_1.setOpaque(false);
        Txa_OutputScreen12_1.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema13.add(Txa_OutputScreen12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1210, 1120, 30));

        Spr_TreeSet.setForeground(sRecursos.getColorVerde());
        Spr_TreeSet.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_TreeSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1270, 1120, -1));

        Lbl_TreeSet.setFont(sRecursos.getFTitles());
        Lbl_TreeSet.setForeground(sRecursos.getColorVerde());
        Lbl_TreeSet.setText("TreeSet");
        Pnl_Tema13.add(Lbl_TreeSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1300, -1, 20));

        Txa_SubContent12_5.setEditable(false);
        Txa_SubContent12_5.setColumns(20);
        Txa_SubContent12_5.setFont(sRecursos.getFWindow());
        Txa_SubContent12_5.setLineWrap(true);
        Txa_SubContent12_5.setRows(5);
        Txa_SubContent12_5.setWrapStyleWord(true);
        Txa_SubContent12_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent12_5.setFocusable(false);
        Txa_SubContent12_5.setOpaque(false);
        Pnl_Tema13.add(Txa_SubContent12_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1330, 1120, 70));

        Lbl_Sintaxis12_2.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis12_2.setText("Sintaxis");
        Pnl_Tema13.add(Lbl_Sintaxis12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1410, -1, 20));

        Txa_Sintaxis12_2.setEditable(false);
        Txa_Sintaxis12_2.setColumns(20);
        Txa_Sintaxis12_2.setFont(sRecursos.getFWindow());
        Txa_Sintaxis12_2.setLineWrap(true);
        Txa_Sintaxis12_2.setRows(5);
        Txa_Sintaxis12_2.setWrapStyleWord(true);
        Txa_Sintaxis12_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Sintaxis12_2.setFocusable(false);
        Txa_Sintaxis12_2.setOpaque(false);
        Pnl_Tema13.add(Txa_Sintaxis12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1440, 1120, 30));

        Lbl_SampleCode12_2.setFont(sRecursos.getFTitles());
        Lbl_SampleCode12_2.setText("Ejemplo de Código");
        Pnl_Tema13.add(Lbl_SampleCode12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1490, -1, 20));

        Pnl_CodesThemes12_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes12_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema13.add(Pnl_CodesThemes12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1520, 1118, 280));

        Lbl_Output12_2.setFont(sRecursos.getFTitles());
        Lbl_Output12_2.setText("Output");
        Pnl_Tema13.add(Lbl_Output12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1810, -1, -1));

        Txa_OutputScreen12_2.setEditable(false);
        Txa_OutputScreen12_2.setColumns(20);
        Txa_OutputScreen12_2.setFont(sRecursos.getFWindow());
        Txa_OutputScreen12_2.setLineWrap(true);
        Txa_OutputScreen12_2.setRows(5);
        Txa_OutputScreen12_2.setWrapStyleWord(true);
        Txa_OutputScreen12_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen12_2.setFocusable(false);
        Txa_OutputScreen12_2.setOpaque(false);
        Txa_OutputScreen12_2.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema13.add(Txa_OutputScreen12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1840, 1120, 150));

        Lbl_Tip12_1.setFont(sRecursos.getFTitles());
        Lbl_Tip12_1.setText("Tip");
        Pnl_Tema13.add(Lbl_Tip12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2000, -1, -1));

        Txa_Tips12_1.setEditable(false);
        Txa_Tips12_1.setColumns(20);
        Txa_Tips12_1.setFont(sRecursos.getFWindow());
        Txa_Tips12_1.setLineWrap(true);
        Txa_Tips12_1.setRows(5);
        Txa_Tips12_1.setWrapStyleWord(true);
        Txa_Tips12_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Tips12_1.setFocusable(false);
        Txa_Tips12_1.setOpaque(false);
        Pnl_Tema13.add(Txa_Tips12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2030, 1120, 30));

        Spr_Maps.setForeground(sRecursos.getColorVerde());
        Spr_Maps.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_Maps, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2090, 1120, -1));

        Lbl_Maps.setFont(sRecursos.getFTitleEditor());
        Lbl_Maps.setForeground(sRecursos.getColorVerde());
        Lbl_Maps.setText("Maps");
        Pnl_Tema13.add(Lbl_Maps, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2110, -1, 30));

        Txa_SubContent12_6.setEditable(false);
        Txa_SubContent12_6.setColumns(20);
        Txa_SubContent12_6.setFont(sRecursos.getFWindow());
        Txa_SubContent12_6.setLineWrap(true);
        Txa_SubContent12_6.setRows(5);
        Txa_SubContent12_6.setWrapStyleWord(true);
        Txa_SubContent12_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent12_6.setFocusable(false);
        Txa_SubContent12_6.setOpaque(false);
        Pnl_Tema13.add(Txa_SubContent12_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2150, 1120, 50));

        Lbl_MetodosBasicos12_2.setFont(sRecursos.getFTitles());
        Lbl_MetodosBasicos12_2.setText("Métodos Básicos");
        Pnl_Tema13.add(Lbl_MetodosBasicos12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2220, -1, 20));

        Txa_SubContent12_7.setEditable(false);
        Txa_SubContent12_7.setColumns(20);
        Txa_SubContent12_7.setFont(sRecursos.getFWindow());
        Txa_SubContent12_7.setLineWrap(true);
        Txa_SubContent12_7.setRows(5);
        Txa_SubContent12_7.setWrapStyleWord(true);
        Txa_SubContent12_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent12_7.setFocusable(false);
        Txa_SubContent12_7.setOpaque(false);
        Pnl_Tema13.add(Txa_SubContent12_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2250, 1120, 280));

        Spr_HashMap.setForeground(sRecursos.getColorVerde());
        Spr_HashMap.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_HashMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2560, 1120, -1));

        Lbl_HashMap.setFont(sRecursos.getFTitles());
        Lbl_HashMap.setForeground(sRecursos.getColorVerde());
        Lbl_HashMap.setText("HashMap");
        Pnl_Tema13.add(Lbl_HashMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2590, -1, 20));

        Txa_SubContent12_8.setEditable(false);
        Txa_SubContent12_8.setColumns(20);
        Txa_SubContent12_8.setFont(sRecursos.getFWindow());
        Txa_SubContent12_8.setLineWrap(true);
        Txa_SubContent12_8.setRows(5);
        Txa_SubContent12_8.setWrapStyleWord(true);
        Txa_SubContent12_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent12_8.setFocusable(false);
        Txa_SubContent12_8.setOpaque(false);
        Pnl_Tema13.add(Txa_SubContent12_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2620, 1120, 50));

        Lbl_Sintaxis12_3.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis12_3.setText("Sintaxis");
        Pnl_Tema13.add(Lbl_Sintaxis12_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2680, -1, 20));

        Txa_Sintaxis12_3.setEditable(false);
        Txa_Sintaxis12_3.setColumns(20);
        Txa_Sintaxis12_3.setFont(sRecursos.getFWindow());
        Txa_Sintaxis12_3.setLineWrap(true);
        Txa_Sintaxis12_3.setRows(5);
        Txa_Sintaxis12_3.setWrapStyleWord(true);
        Txa_Sintaxis12_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Sintaxis12_3.setFocusable(false);
        Txa_Sintaxis12_3.setOpaque(false);
        Pnl_Tema13.add(Txa_Sintaxis12_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2710, 1120, 30));

        Lbl_SampleCode12_3.setFont(sRecursos.getFTitles());
        Lbl_SampleCode12_3.setText("Ejemplo de Código");
        Pnl_Tema13.add(Lbl_SampleCode12_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2750, -1, 20));

        Pnl_CodesThemes12_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes12_3.setLayout(new java.awt.CardLayout());
        Pnl_Tema13.add(Pnl_CodesThemes12_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2780, 1120, 300));

        Lbl_Output12_3.setFont(sRecursos.getFTitles());
        Lbl_Output12_3.setText("Output");
        Pnl_Tema13.add(Lbl_Output12_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3100, -1, -1));

        Txa_OutputScreen12_3.setEditable(false);
        Txa_OutputScreen12_3.setColumns(20);
        Txa_OutputScreen12_3.setFont(sRecursos.getFWindow());
        Txa_OutputScreen12_3.setLineWrap(true);
        Txa_OutputScreen12_3.setRows(5);
        Txa_OutputScreen12_3.setWrapStyleWord(true);
        Txa_OutputScreen12_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen12_3.setFocusable(false);
        Txa_OutputScreen12_3.setOpaque(false);
        Txa_OutputScreen12_3.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema13.add(Txa_OutputScreen12_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3130, 1120, 110));

        Spr_TreeMap.setForeground(sRecursos.getColorVerde());
        Spr_TreeMap.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_TreeMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3270, 1120, -1));

        Lbl_TreeMap.setFont(sRecursos.getFTitles());
        Lbl_TreeMap.setForeground(sRecursos.getColorVerde());
        Lbl_TreeMap.setText("TreeMap");
        Pnl_Tema13.add(Lbl_TreeMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3300, -1, 20));

        Txa_SubContent12_9.setEditable(false);
        Txa_SubContent12_9.setColumns(20);
        Txa_SubContent12_9.setFont(sRecursos.getFWindow());
        Txa_SubContent12_9.setLineWrap(true);
        Txa_SubContent12_9.setRows(5);
        Txa_SubContent12_9.setWrapStyleWord(true);
        Txa_SubContent12_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_SubContent12_9.setFocusable(false);
        Txa_SubContent12_9.setOpaque(false);
        Pnl_Tema13.add(Txa_SubContent12_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3330, 1120, 50));

        Lbl_Sintaxis12_4.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis12_4.setText("Sintaxis");
        Pnl_Tema13.add(Lbl_Sintaxis12_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3400, -1, 20));

        Txa_Sintaxis12_4.setEditable(false);
        Txa_Sintaxis12_4.setColumns(20);
        Txa_Sintaxis12_4.setFont(sRecursos.getFWindow());
        Txa_Sintaxis12_4.setLineWrap(true);
        Txa_Sintaxis12_4.setRows(5);
        Txa_Sintaxis12_4.setWrapStyleWord(true);
        Txa_Sintaxis12_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_Sintaxis12_4.setFocusable(false);
        Txa_Sintaxis12_4.setOpaque(false);
        Pnl_Tema13.add(Txa_Sintaxis12_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3430, 1120, 30));

        Lbl_SampleCode12_4.setFont(sRecursos.getFTitles());
        Lbl_SampleCode12_4.setText("Ejemplo de Código");
        Pnl_Tema13.add(Lbl_SampleCode12_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3480, -1, 20));

        Pnl_CodesThemes12_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Pnl_CodesThemes12_4.setLayout(new java.awt.CardLayout());
        Pnl_Tema13.add(Pnl_CodesThemes12_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3510, 1120, 300));

        Lbl_Output12_4.setFont(sRecursos.getFTitles());
        Lbl_Output12_4.setText("Output");
        Pnl_Tema13.add(Lbl_Output12_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3830, -1, -1));

        Txa_OutputScreen12_4.setEditable(false);
        Txa_OutputScreen12_4.setColumns(20);
        Txa_OutputScreen12_4.setFont(sRecursos.getFWindow());
        Txa_OutputScreen12_4.setLineWrap(true);
        Txa_OutputScreen12_4.setRows(5);
        Txa_OutputScreen12_4.setWrapStyleWord(true);
        Txa_OutputScreen12_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Txa_OutputScreen12_4.setFocusable(false);
        Txa_OutputScreen12_4.setOpaque(false);
        Txa_OutputScreen12_4.setPreferredSize(new java.awt.Dimension(500, 94));
        Pnl_Tema13.add(Txa_OutputScreen12_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3860, 1120, 110));

        Scp_Tema13.setViewportView(Pnl_Tema13);

        Pnl_Temas.add(Scp_Tema13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario13.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario13.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario13.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario13.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario13.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario13.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario13.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario13.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_EDDAvanzadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_EDDAvanzadas_Off.png"))); // NOI18N
        Btn_Anterior_EDDAvanzadas.setMnemonic(37);
        Btn_Anterior_EDDAvanzadas.setBorderPainted(false);
        Btn_Anterior_EDDAvanzadas.setContentAreaFilled(false);
        Btn_Anterior_EDDAvanzadas.setFocusPainted(false);
        Btn_Anterior_EDDAvanzadas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_EDDAvanzadas.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_EDDAvanzadas.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_EDDAvanzadas.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_EDDAvanzadas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_EDDAvanzadas_On.png"))); // NOI18N
        Btn_Anterior_EDDAvanzadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_EDDAvanzadasActionPerformed(evt);
            }
        });
        Pnl_Cuestionario13.add(Btn_Anterior_EDDAvanzadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_PrimerosAlgoritmos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_PrimerosAlgoritmos_Off.png"))); // NOI18N
        Btn_Siguiente_PrimerosAlgoritmos.setMnemonic(39);
        Btn_Siguiente_PrimerosAlgoritmos.setBorderPainted(false);
        Btn_Siguiente_PrimerosAlgoritmos.setContentAreaFilled(false);
        Btn_Siguiente_PrimerosAlgoritmos.setFocusPainted(false);
        Btn_Siguiente_PrimerosAlgoritmos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_PrimerosAlgoritmos.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_PrimerosAlgoritmos.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_PrimerosAlgoritmos.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_PrimerosAlgoritmos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_PrimerosAlgoritmos_On.png"))); // NOI18N
        Btn_Siguiente_PrimerosAlgoritmos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_PrimerosAlgoritmosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario13.add(Btn_Siguiente_PrimerosAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario13.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario13.setText("Estructuras de Datos Avanzadas | Cuestionario");
        Lbl_Cuestionario13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario13.add(Lbl_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 700, 45));

        Scp_Cuestionario13.setViewportView(Pnl_Cuestionario13);

        Pnl_Temas.add(Scp_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema14.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema14.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema14.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema14.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema14.setCursor(sRecursos.getCDefault());
        Pnl_Tema14.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema14.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Tema14.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Tema14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario13_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario13.setMnemonic(37);
        Btn_Anterior_Cuestionario13.setBorderPainted(false);
        Btn_Anterior_Cuestionario13.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario13.setFocusPainted(false);
        Btn_Anterior_Cuestionario13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario13.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario13.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario13.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario13_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario13ActionPerformed(evt);
            }
        });
        Pnl_Tema14.add(Btn_Anterior_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_Cuestionario14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario14_Off.png"))); // NOI18N
        Btn_Siguiente_Cuestionario14.setMnemonic(39);
        Btn_Siguiente_Cuestionario14.setBorderPainted(false);
        Btn_Siguiente_Cuestionario14.setContentAreaFilled(false);
        Btn_Siguiente_Cuestionario14.setFocusPainted(false);
        Btn_Siguiente_Cuestionario14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_Cuestionario14.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario14.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario14.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_Cuestionario14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_Cuestionario14_On.png"))); // NOI18N
        Btn_Siguiente_Cuestionario14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_Cuestionario14ActionPerformed(evt);
            }
        });
        Pnl_Tema14.add(Btn_Siguiente_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_PrimerosAlgoritmos.setFont(sRecursos.getFLabels());
        Lbl_PrimerosAlgoritmos.setText("Primeros Algoritmos");
        Lbl_PrimerosAlgoritmos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Tema14.add(Lbl_PrimerosAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 340, 45));

        Scp_Tema14.setViewportView(Pnl_Tema14);

        Pnl_Temas.add(Scp_Tema14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario14.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario14.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario14.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario14.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario14.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario14.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario14.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario14.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Cuestionario14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_PrimerosAlgoritmos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_PrimerosAlgoritmos_Off.png"))); // NOI18N
        Btn_Anterior_PrimerosAlgoritmos.setMnemonic(37);
        Btn_Anterior_PrimerosAlgoritmos.setBorderPainted(false);
        Btn_Anterior_PrimerosAlgoritmos.setContentAreaFilled(false);
        Btn_Anterior_PrimerosAlgoritmos.setFocusPainted(false);
        Btn_Anterior_PrimerosAlgoritmos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_PrimerosAlgoritmos.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_PrimerosAlgoritmos.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_PrimerosAlgoritmos.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_PrimerosAlgoritmos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_PrimerosAlgoritmos_On.png"))); // NOI18N
        Btn_Anterior_PrimerosAlgoritmos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_PrimerosAlgoritmosActionPerformed(evt);
            }
        });
        Pnl_Cuestionario14.add(Btn_Anterior_PrimerosAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Btn_Siguiente_EjercicioFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EjercicioFinal_Off.png"))); // NOI18N
        Btn_Siguiente_EjercicioFinal.setMnemonic(39);
        Btn_Siguiente_EjercicioFinal.setBorderPainted(false);
        Btn_Siguiente_EjercicioFinal.setContentAreaFilled(false);
        Btn_Siguiente_EjercicioFinal.setFocusPainted(false);
        Btn_Siguiente_EjercicioFinal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_EjercicioFinal.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EjercicioFinal.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EjercicioFinal.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EjercicioFinal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EjercicioFinal_On.png"))); // NOI18N
        Btn_Siguiente_EjercicioFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_EjercicioFinalActionPerformed(evt);
            }
        });
        Pnl_Cuestionario14.add(Btn_Siguiente_EjercicioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1410, 254, 64));

        Lbl_Cuestionario14.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario14.setText("Primeros Algoritmos | Cuestionario");
        Lbl_Cuestionario14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Cuestionario14.add(Lbl_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 610, 45));

        Scp_Cuestionario14.setViewportView(Pnl_Cuestionario14);

        Pnl_Temas.add(Scp_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Ejercicio3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Ejercicio3.setMaximumSize(sRecursos.getDTamanio());
        Scp_Ejercicio3.setMinimumSize(sRecursos.getDTamanio());
        Scp_Ejercicio3.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Ejercicio3_Aprender.setBackground(sRecursos.getCPrincipal());
        Pnl_Ejercicio3_Aprender.setCursor(sRecursos.getCDefault());
        Pnl_Ejercicio3_Aprender.setMaximumSize(sRecursos.getDPnls_Temas());
        Pnl_Ejercicio3_Aprender.setMinimumSize(sRecursos.getDPnls_Temas());
        Pnl_Ejercicio3_Aprender.setPreferredSize(sRecursos.getDPnls_Temas());
        Pnl_Ejercicio3_Aprender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_Cuestionario14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario14_Off.png"))); // NOI18N
        Btn_Anterior_Cuestionario14.setMnemonic(37);
        Btn_Anterior_Cuestionario14.setBorderPainted(false);
        Btn_Anterior_Cuestionario14.setContentAreaFilled(false);
        Btn_Anterior_Cuestionario14.setFocusPainted(false);
        Btn_Anterior_Cuestionario14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_Cuestionario14.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario14.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario14.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_Cuestionario14.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_Cuestionario14_On.png"))); // NOI18N
        Btn_Anterior_Cuestionario14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_Cuestionario14ActionPerformed(evt);
            }
        });
        Pnl_Ejercicio3_Aprender.add(Btn_Anterior_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1410, 254, 64));

        Lbl_EjercicioFinal.setFont(sRecursos.getFLabels());
        Lbl_EjercicioFinal.setText("Ejercicio Final");
        Lbl_EjercicioFinal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Pnl_Ejercicio3_Aprender.add(Lbl_EjercicioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 350, 45));

        Btn_EnviarEjercicio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/EnviarAprender_Off.png"))); // NOI18N
        Btn_EnviarEjercicio3.setBorderPainted(false);
        Btn_EnviarEjercicio3.setContentAreaFilled(false);
        Btn_EnviarEjercicio3.setFocusPainted(false);
        Btn_EnviarEjercicio3.setFocusable(false);
        Btn_EnviarEjercicio3.setMaximumSize(sRecursos.getDTamanioBotones());
        Btn_EnviarEjercicio3.setMinimumSize(sRecursos.getDTamanioBotones());
        Btn_EnviarEjercicio3.setPreferredSize(sRecursos.getDTamanioBotones());
        Btn_EnviarEjercicio3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/EnviarAprender_On.png"))); // NOI18N
        Btn_EnviarEjercicio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EnviarEjercicio3ActionPerformed(evt);
            }
        });
        Pnl_Ejercicio3_Aprender.add(Btn_EnviarEjercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 990, 170, 50));

        Pnl_SyntaxEjercicio3.setBackground(new java.awt.Color(204, 204, 204));
        Pnl_SyntaxEjercicio3.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_SyntaxEjercicio3.setLayout(new java.awt.CardLayout());
        Pnl_Ejercicio3_Aprender.add(Pnl_SyntaxEjercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1050, 1080, 330));

        Scp_Ejercicio3.setViewportView(Pnl_Ejercicio3_Aprender);

        Pnl_Temas.add(Scp_Ejercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Pnl_Aprender.add(Pnl_Temas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Principal.add(Pnl_Aprender, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1176, 705));

        Pnl_CodeStorm.setBackground(sRecursos.getCPrincipal());
        Pnl_CodeStorm.setMaximumSize(sRecursos.getDTamanio());
        Pnl_CodeStorm.setMinimumSize(sRecursos.getDTamanio());
        Pnl_CodeStorm.setPreferredSize(sRecursos.getDTamanio());
        Pnl_CodeStorm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_ListadoEjercicios.setMaximumSize(sRecursos.getDTamanio());
        Pnl_ListadoEjercicios.setMinimumSize(sRecursos.getDTamanio());
        Pnl_ListadoEjercicios.setPreferredSize(sRecursos.getDTamanio());
        Pnl_ListadoEjercicios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pb_Nivel1.setBackground(sRecursos.getCPrincipal());
        Pb_Nivel1.setForeground(sRecursos.getColorRojo());
        Pb_Nivel1.setOrientation(1);
        Pb_Nivel1.setValue(75);
        Pb_Nivel1.setBorderPainted(false);
        Pnl_ListadoEjercicios.add(Pb_Nivel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 20, 290));

        Pb_Nivel2.setBackground(sRecursos.getCPrincipal());
        Pb_Nivel2.setForeground(sRecursos.getColorRojo());
        Pb_Nivel2.setOrientation(1);
        Pb_Nivel2.setValue(50);
        Pb_Nivel2.setBorderPainted(false);
        Pb_Nivel2.setOpaque(true);
        Pb_Nivel2.setString("");
        Pnl_ListadoEjercicios.add(Pb_Nivel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 20, 290));

        Pb_Nivel3.setBackground(sRecursos.getCPrincipal());
        Pb_Nivel3.setForeground(sRecursos.getColorRojo());
        Pb_Nivel3.setOrientation(1);
        Pb_Nivel3.setToolTipText("");
        Pb_Nivel3.setValue(100);
        Pb_Nivel3.setBorderPainted(false);
        Pb_Nivel3.setOpaque(true);
        Pnl_ListadoEjercicios.add(Pb_Nivel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 20, 290));

        Pb_Nivel4.setBackground(sRecursos.getCPrincipal());
        Pb_Nivel4.setForeground(sRecursos.getColorRojo());
        Pb_Nivel4.setOrientation(1);
        Pb_Nivel4.setValue(50);
        Pb_Nivel4.setBorderPainted(false);
        Pnl_ListadoEjercicios.add(Pb_Nivel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 20, 290));

        Pb_Nivel5.setBackground(sRecursos.getCPrincipal());
        Pb_Nivel5.setForeground(sRecursos.getColorRojo());
        Pb_Nivel5.setBorderPainted(false);
        Pnl_ListadoEjercicios.add(Pb_Nivel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, 20, 290));

        Lbl_Header_CodeStorm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_Header_CodeStorm.png"))); // NOI18N
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
        Btn_Nivel1_Ejercicio1.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel1_Ejercicio1.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel1_Ejercicio1.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel1_Ejercicio2.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel1_Ejercicio2.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel1_Ejercicio2.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel1_Ejercicio3.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel1_Ejercicio3.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel1_Ejercicio3.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel1_Ejercicio4.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel1_Ejercicio4.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel1_Ejercicio4.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel2_Ejercicio1.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel2_Ejercicio1.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel2_Ejercicio1.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel2_Ejercicio2.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel2_Ejercicio2.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel2_Ejercicio2.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel2_Ejercicio3.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel2_Ejercicio3.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel2_Ejercicio3.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel2_Ejercicio4.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel2_Ejercicio4.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel2_Ejercicio4.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel3_Ejercicio1.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel3_Ejercicio1.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel3_Ejercicio1.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel3_Ejercicio2.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel3_Ejercicio2.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel3_Ejercicio2.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel3_Ejercicio3.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel3_Ejercicio3.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel3_Ejercicio3.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel3_Ejercicio4.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel3_Ejercicio4.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel3_Ejercicio4.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel4_Ejercicio1.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel4_Ejercicio1.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel4_Ejercicio1.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel4_Ejercicio2.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel4_Ejercicio2.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel4_Ejercicio2.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel4_Ejercicio3.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel4_Ejercicio3.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel4_Ejercicio3.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel4_Ejercicio4.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel4_Ejercicio4.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel4_Ejercicio4.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel5_Ejercicio1.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel5_Ejercicio1.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel5_Ejercicio1.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel5_Ejercicio2.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel5_Ejercicio2.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel5_Ejercicio2.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel5_Ejercicio3.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel5_Ejercicio3.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel5_Ejercicio3.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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
        Btn_Nivel5_Ejercicio4.setMaximumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel5_Ejercicio4.setMinimumSize(sRecursos.getDBtns_CodeStorm());
        Btn_Nivel5_Ejercicio4.setPreferredSize(sRecursos.getDBtns_CodeStorm());
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

        Lbl_CodeStorm_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Apolo_CodeStorm_Fondo.png"))); // NOI18N
        Pnl_ListadoEjercicios.add(Lbl_CodeStorm_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_CodeStorm.add(Pnl_ListadoEjercicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, -1));

        Scp_Introduccion.setBackground(sRecursos.getCPrincipal());
        Scp_Introduccion.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Introduccion.setMaximumSize(sRecursos.getDTamanio());
        Scp_Introduccion.setMinimumSize(sRecursos.getDTamanio());
        Scp_Introduccion.setName(""); // NOI18N
        Scp_Introduccion.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Introduccion.setBackground(sRecursos.getCPrincipal());
        Pnl_Introduccion.setMaximumSize(new java.awt.Dimension(1176, 4000));
        Pnl_Introduccion.setMinimumSize(new java.awt.Dimension(1176, 4000));
        Pnl_Introduccion.setPreferredSize(new java.awt.Dimension(1176, 4000));
        Pnl_Introduccion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_CodeStorm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_Header_CodeStorm.png"))); // NOI18N
        Pnl_Introduccion.add(Lbl_Header_CodeStorm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Btn_Introduccion_Siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Siguiente_Ejercicios_Off.png"))); // NOI18N
        Btn_Introduccion_Siguiente.setBorderPainted(false);
        Btn_Introduccion_Siguiente.setContentAreaFilled(false);
        Btn_Introduccion_Siguiente.setFocusPainted(false);
        Btn_Introduccion_Siguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Introduccion_Siguiente.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Introduccion_Siguiente.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Introduccion_Siguiente.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Introduccion_Siguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Siguiente_Ejercicios_On.png"))); // NOI18N
        Btn_Introduccion_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Introduccion_SiguienteActionPerformed(evt);
            }
        });
        Pnl_Introduccion.add(Btn_Introduccion_Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 3900, 254, 64));

        Scp_Introduccion.setViewportView(Pnl_Introduccion);

        Pnl_CodeStorm.add(Scp_Introduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 706));

        Pnl_General.setMaximumSize(sRecursos.getDTamanio());
        Pnl_General.setMinimumSize(sRecursos.getDTamanio());
        Pnl_General.setPreferredSize(sRecursos.getDTamanio());
        Pnl_General.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Header.setBackground(sRecursos.getCPrincipal());
        Pnl_Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_CodeStorm2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_Header_CodeStorm.png"))); // NOI18N
        Pnl_Header.add(Lbl_Header_CodeStorm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Pnl_General.add(Pnl_Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 90));

        Pnl_BotonesPrincipales.setBackground(sRecursos.getCPrincipal());
        Pnl_BotonesPrincipales.setMaximumSize(new java.awt.Dimension(916, 70));
        Pnl_BotonesPrincipales.setMinimumSize(new java.awt.Dimension(916, 70));
        Pnl_BotonesPrincipales.setPreferredSize(new java.awt.Dimension(916, 70));
        Pnl_BotonesPrincipales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Ejercicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Ejercicio_Off.png"))); // NOI18N
        Btn_Ejercicio.setBorderPainted(false);
        Btn_Ejercicio.setContentAreaFilled(false);
        Btn_Ejercicio.setCursor(sRecursos.getCMano());
        Btn_Ejercicio.setFocusPainted(false);
        Btn_Ejercicio.setFocusable(false);
        Btn_Ejercicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Ejercicio.setMaximumSize(sRecursos.getDTamanioBotones());
        Btn_Ejercicio.setMinimumSize(sRecursos.getDTamanioBotones());
        Btn_Ejercicio.setPreferredSize(sRecursos.getDTamanioBotones());
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
        Btn_Codigo.setCursor(sRecursos.getCMano());
        Btn_Codigo.setFocusPainted(false);
        Btn_Codigo.setFocusable(false);
        Btn_Codigo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Codigo.setMaximumSize(sRecursos.getDTamanioBotones());
        Btn_Codigo.setMinimumSize(sRecursos.getDTamanioBotones());
        Btn_Codigo.setPreferredSize(sRecursos.getDTamanioBotones());
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
        Btn_Enviar.setCursor(sRecursos.getCMano());
        Btn_Enviar.setFocusPainted(false);
        Btn_Enviar.setFocusable(false);
        Btn_Enviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Enviar.setMaximumSize(sRecursos.getDTamanioBotones());
        Btn_Enviar.setMinimumSize(sRecursos.getDTamanioBotones());
        Btn_Enviar.setPreferredSize(sRecursos.getDTamanioBotones());
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
        Btn_Solucion.setCursor(sRecursos.getCMano());
        Btn_Solucion.setFocusPainted(false);
        Btn_Solucion.setFocusable(false);
        Btn_Solucion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Solucion.setMaximumSize(sRecursos.getDTamanioBotones());
        Btn_Solucion.setMinimumSize(sRecursos.getDTamanioBotones());
        Btn_Solucion.setPreferredSize(sRecursos.getDTamanioBotones());
        Btn_Solucion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Solucion_On.png"))); // NOI18N
        Btn_Solucion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Solucion_On.png"))); // NOI18N
        Btn_Solucion.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Solucion_Enabled.png"))); // NOI18N
        Btn_Solucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SolucionActionPerformed(evt);
            }
        });
        Pnl_BotonesPrincipales.add(Btn_Solucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 172, 47));

        Btn_Atras_CodeStorm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Atras_CodeStorm_Off.png"))); // NOI18N
        Btn_Atras_CodeStorm.setMnemonic('b');
        Btn_Atras_CodeStorm.setToolTipText("Atrás");
        Btn_Atras_CodeStorm.setBorderPainted(false);
        Btn_Atras_CodeStorm.setContentAreaFilled(false);
        Btn_Atras_CodeStorm.setFocusPainted(false);
        Btn_Atras_CodeStorm.setFocusable(false);
        Btn_Atras_CodeStorm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Atras_CodeStorm.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Atras_CodeStorm_On.png"))); // NOI18N
        Btn_Atras_CodeStorm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Atras_CodeStormActionPerformed(evt);
            }
        });
        Pnl_BotonesPrincipales.add(Btn_Atras_CodeStorm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 82, 47));

        Pnl_General.add(Pnl_BotonesPrincipales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 916, 70));

        Pnl_Navegacion.setBackground(sRecursos.getCPrincipal());
        Pnl_Navegacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/CodeStorm/Siguiente_Off.png"))); // NOI18N
        Btn_Siguiente.setMnemonic(KeyEvent.VK_RIGHT);
        Btn_Siguiente.setToolTipText("Siguiente");
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
        Btn_Anterior.setMnemonic(KeyEvent.VK_LEFT);
        Btn_Anterior.setToolTipText("Anterior");
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

        Pnl_Main.setBackground(sRecursos.getCPrincipal());
        Pnl_Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_EjercicioFull.setBackground(sRecursos.getCPrincipal());
        Pnl_EjercicioFull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Scp_EjerciciosFull.setBackground(sRecursos.getCPrincipal());

        Lbl_Ejercicio1.setBackground(new java.awt.Color(237, 234, 243));
        Lbl_Ejercicio1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        Lbl_Ejercicio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Ejercicio1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lbl_Ejercicio1.setOpaque(true);
        Scp_EjerciciosFull.setViewportView(Lbl_Ejercicio1);

        Pnl_EjercicioFull.add(Scp_EjerciciosFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1090, 440));

        Pnl_Main.add(Pnl_EjercicioFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 1110, 510));

        Pnl_CodigoFull.setBackground(sRecursos.getCPrincipal());
        Pnl_CodigoFull.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true), " Nivel 1 | Ejercicio 1 ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 30), new java.awt.Color(204, 0, 0))); // NOI18N
        Pnl_CodigoFull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_SyntaxCode.setLayout(new java.awt.BorderLayout());
        Pnl_CodigoFull.add(Pnl_SyntaxCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1080, 430));

        Pnl_Main.add(Pnl_CodigoFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 1110, 510));

        Pnl_SolucionFull.setBackground(sRecursos.getCPrincipal());
        Pnl_SolucionFull.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true), " Nivel 1 | Ejercicio 1 ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 30), new java.awt.Color(204, 0, 0))); // NOI18N
        Pnl_SolucionFull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_SyntaxSolution.setLayout(new java.awt.BorderLayout());
        Pnl_SolucionFull.add(Pnl_SyntaxSolution, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1080, 430));

        Pnl_Main.add(Pnl_SolucionFull, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 1110, 510));

        Pnl_General.add(Pnl_Main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1176, 545));

        Pnl_CodeStorm.add(Pnl_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Principal.add(Pnl_CodeStorm, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1176, 706));

        Pnl_Historia.setBackground(sRecursos.getCPrincipal());
        Pnl_Historia.setMaximumSize(sRecursos.getDTamanio());
        Pnl_Historia.setMinimumSize(sRecursos.getDTamanio());
        Pnl_Historia.setPreferredSize(sRecursos.getDTamanio());
        Pnl_Historia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Pagina1.setBackground(sRecursos.getCPrincipal());
        Pnl_Pagina1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Historia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_Header_Historia.png"))); // NOI18N
        Pnl_Pagina1.add(Lbl_Header_Historia, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

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

        Pnl_Pagina2.setBackground(sRecursos.getCPrincipal());
        Pnl_Pagina2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Historia2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_Header_Historia.png"))); // NOI18N
        Pnl_Pagina2.add(Lbl_Header_Historia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Pnl_Historia.add(Pnl_Pagina2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Pagina3.setBackground(sRecursos.getCPrincipal());
        Pnl_Pagina3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Historia3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_Header_Historia.png"))); // NOI18N
        Pnl_Pagina3.add(Lbl_Header_Historia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Pnl_Historia.add(Pnl_Pagina3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Pagina4.setBackground(sRecursos.getCPrincipal());
        Pnl_Pagina4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Historia4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Apolo_Header_Historia.png"))); // NOI18N
        Pnl_Pagina4.add(Lbl_Header_Historia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1115, 55));

        Pnl_Historia.add(Pnl_Pagina4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

        Pnl_Principal.add(Pnl_Historia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1176, 705));

        getContentPane().add(Pnl_Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void Btn_AcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AcercaDeActionPerformed
        // Habilitar Ventana de Acerca de
        if (evt.getSource() == Btn_AcercaDe) {
            Btn_AcercaDe.setSelected(false);
            st.setVisible(true);
        }
    }//GEN-LAST:event_Btn_AcercaDeActionPerformed

    private void Btn_CodeStormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CodeStormActionPerformed
        if (Btn_CodeStorm.isSelected()) {
            apagarSecciones(3);
            habilitarBotonesCodeStorm();

            // Paneles Internos
            Pnl_CodeStorm.setVisible(true);
            Pnl_ListadoEjercicios.setVisible(true);
            Scp_Introduccion.setVisible(false);
            Pnl_General.setVisible(false);

            //Paneles Principales
            Pnl_Aprender.setVisible(false);
            Pnl_Historia.setVisible(false);
            Pnl_Home.setVisible(false);
        } else {
            Pnl_CodeStorm.setVisible(false);
            Pnl_Home.setVisible(true);
        }
    }//GEN-LAST:event_Btn_CodeStormActionPerformed

    private void Btn_AprenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AprenderActionPerformed
        if (Btn_Aprender.isSelected()) {
//            if (active) {
//                new Tips(this, true).setVisible(true);
//                active = false;
//            }

            apagarSecciones(1);
            habilitarBotonesAprender();
            Pnl_Aprender.setVisible(true);
            Pnl_Mapa.setVisible(true);
            Pnl_Encabezado.setVisible(false);

            // Ocultar componentes internos del Panel de Aprender
            for (Component scrollpane : Pnl_Temas.getComponents()) {
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
        if (evt.getSource() == Btn_Programar) {
            Btn_Programar.setSelected(false);
            CodeEditor edc = new CodeEditor();
            edc.setVisible(true);
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
            Pnl_CodeStorm.setVisible(false);
        } else {
            Pnl_Historia.setVisible(false);
            Pnl_Home.setVisible(true);
        }
    }//GEN-LAST:event_Btn_HistoriaActionPerformed

    private void helloWorldContent() {
        String[] parrafos = lstList.get(0).getLearningSubContent().split("\n");
        Txa_Analogy0.setText(lstList.get(0).getTitleAnalogy());
        Txa_SubContent0.setText(parrafos[0]);
        syntaxTemas0.setText(coList.get(0).getSampleCode());
        Txa_OutputScreen0.setText(coList.get(0).getOutputScreen() + "\n\n");
        Txa_OutputScreen0.append(parrafos[1] + "\n\n" + parrafos[2]);
    }

    private void ComentariosContent() {
        Txa_Analogy1.setText(lstList.get(1).getTitleAnalogy());
        Txa_SubContent1.setText(lstList.get(1).getLearningSubContent());
        Txa_CodeDescription1.setText(lstList.get(1).getSyntax());
        syntaxTemas1_1.setText(coList.get(1).getSampleCode());
        Txa_OutputScreen1.setText(coList.get(1).getOutputScreen() + "\n\n");
        Txa_CodeDescription2.setText(coList.get(2).getCodeDescription() + "\n\n");

        syntaxTemas1_2.setText(coList.get(2).getSampleCode());
        Txa_OutputScreen1_2.setText(coList.get(2).getOutputScreen() + "\n\n");
        Txa_CodeDescription1_1.setText(coList.get(3).getCodeDescription());

        syntaxTemas1_3.setText(coList.get(3).getSampleCode());
        Txa_OutputScreen1_3.setText(coList.get(3).getOutputScreen() + "\n\n");
    }

    private void LecturaContent() {
        Txa_Analogy4.setText(lstList.get(6).getTitleAnalogy());
        Txa_SubContent4.setText(lstList.get(6).getLearningSubContent());
        syntaxTemas4.setText(coList.get(10).getSampleCode());
        Txa_Tip4_1.setText(lstList.get(6).getTips());
    }

    private void Btn_Aprender_Tema1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema1ActionPerformed
        helloWorldContent();
        Scp_Tema1.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema1ActionPerformed

    private void Btn_Aprender_Tema2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema2ActionPerformed
        ComentariosContent();
        Scp_Tema2.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema2ActionPerformed

    private void tiposDeDatos() {
        Txa_Analogy2.setText(lstList.get(2).getTitleAnalogy());
        Txa_SubContent2.setText(lstList.get(2).getLearningSubContent());
        syntaxTemas2.setText(coList.get(4).getSampleCode());
        Txa_Tips2.setText(lstList.get(2).getTips());
    }

    private void Btn_Aprender_Tema3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema3ActionPerformed
        tiposDeDatos();
        Scp_Tema3.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema3ActionPerformed

    private void Btn_Aprender_Tema4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema4ActionPerformed
        Scp_Tema4.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema4ActionPerformed

    private void Btn_Aprender_Tema5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema5ActionPerformed
        LecturaContent();
        Scp_Tema5.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema5ActionPerformed

    private void operadoresDeRelacion() {
        String[] parrafos = lstList.get(7).getLearningSubContent().split("\n");
        Txa_Analogy5.setText(lstList.get(7).getTitleAnalogy());
        Txa_SubContent5_1.setText(parrafos[0]);
        syntaxTemas5.setText(coList.get(11).getSampleCode());
        Txa_SubContent5_2.setText(parrafos[1]);
        Txa_OutputScreen5.setText(coList.get(11).getOutputScreen() + "\n\n");
        Txa_OutputScreen5.append(coList.get(11).getCodeDescription());
    }

    private void Btn_Aprender_Tema6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema6ActionPerformed
        operadoresDeRelacion();
        Scp_Tema6.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema6ActionPerformed

    private void OperadoresLogicos() {
        String[] parrafos = lstList.get(8).getLearningSubContent().split("\n");
        Txa_Analogy6.setText(lstList.get(8).getTitleAnalogy());
        Txa_SubContent6_1.setText(parrafos[0]);
        Txa_SubContent6_2.setText(parrafos[1] + "\n" + parrafos[2] + "\n" + parrafos[3]);
        syntaxTemas6.setText(coList.get(11).getSampleCode());
        Txa_OutputScreen6.setText(coList.get(12).getOutputScreen() + "\n\n");
        Txa_Tip6.setText(lstList.get(8).getTips());
    }

    private void Btn_Aprender_Tema7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema7ActionPerformed
        OperadoresLogicos();
        Scp_Tema7.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema7ActionPerformed

    private void CondicionalesContent() {
        Txa_Analogy7.setText(lstList.get(9).getTitleAnalogy());
        Txa_SubContent7.setText(lstList.get(9).getLearningSubContent());
        Txa_CodeDescription7.setText(lstList.get(9).getSyntax());
        Txa_Casos7.setText(lstList.get(9).getTips());
        syntaxTemas7.setText(coList.get(13).getSampleCode());
        Txa_OutputScreen7.setText(coList.get(13).getOutputScreen() + "\n\n");
        Txa_CodeDescription7_1.setText(coList.get(14).getCodeDescription());
        syntaxTemas7_1.setText(coList.get(14).getSampleCode());
        Txa_OutputScreen7_1.setText(coList.get(14).getOutputScreen() + "\n\n");
        syntaxTemas7_2.setText(lstList.get(10).getSyntax());
        syntaxTemas7_3.setText(coList.get(15).getSampleCode());
        Txa_OutputScreen7_3.setText(coList.get(15).getOutputScreen() + "\n\n");
        Txa_Analogy7_4.setText(lstList.get(11).getTitleAnalogy());
        Txa_SubContent7_4.setText(lstList.get(11).getLearningSubContent());
        Txa_CodeDescription7_4.setText(lstList.get(11).getSyntax());
        syntaxTemas7_4.setText(coList.get(16).getSampleCode());
        Txa_OutputScreen7_4.setText(coList.get(16).getOutputScreen() + "\n\n");
        syntaxTemas7_5.setText(coList.get(17).getSampleCode());
        Txa_OutputScreen7_5.setText(coList.get(17).getOutputScreen() + "\n\n");
        syntaxTemas7_6.setText(coList.get(18).getSampleCode());
        Txa_OutputScreen7_6.setText(coList.get(18).getOutputScreen() + "\n\n");
        Txa_CodeDescription7_3.setText(coList.get(18).getCodeDescription());
        Txa_Analogy7_5.setText(lstList.get(12).getTitleAnalogy());
        Txa_CodeDescription7_5.setText(lstList.get(12).getLearningSubContent());
        Txa_Syntax7_2.setText(lstList.get(12).getSyntax());
        syntaxTemas7_7.setText(coList.get(19).getSampleCode());
        Txa_OutputScreen7_7.setText(coList.get(19).getOutputScreen() + "\n\n");
    }

    private void Btn_Aprender_Tema8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema8ActionPerformed
        CondicionalesContent();
        Scp_Tema8.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema8ActionPerformed

    private void Bucles() {
        Txa_Analogy8.setText(lstList.get(13).getTitleAnalogy());
        Txa_SubContent8_1.setText(lstList.get(13).getLearningSubContent());
        Txa_SubContent8_2.setText(lstList.get(14).getLearningSubContent());
        Txa_Sintaxis8_1.setText(lstList.get(14).getSyntax());
        syntaxTemas8_1.setText(coList.get(20).getSampleCode());
        Txa_OutputScreen8_1.setText(coList.get(20).getOutputScreen());
        Txa_Tips8_1.setText(lstList.get(14).getTips());
        Txa_SubContent8_3.setText(lstList.get(15).getLearningSubContent());
        Txa_Sintaxis8_2.setText(lstList.get(15).getSyntax());
        syntaxTemas8_2.setText(coList.get(21).getSampleCode());
        Txa_OutputScreen8_2.setText(coList.get(21).getOutputScreen());
        Txa_SubContent8_4.setText(lstList.get(16).getLearningSubContent());
        Txa_Sintaxis8_3.setText(lstList.get(16).getSyntax());
        syntaxTemas8_3.setText(coList.get(22).getSampleCode());
        Txa_OutputScreen8_3.setText(coList.get(23).getOutputScreen());
        Txa_Tips8_2.setText(lstList.get(16).getTips());
    }

    private void Btn_Aprender_Tema9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema9ActionPerformed
        Bucles();
        Scp_Tema9.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema9ActionPerformed

    private void Btn_Aprender_Tema10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema10ActionPerformed
        Scp_Tema10.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema10ActionPerformed

    private void Btn_Aprender_Tema11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema11ActionPerformed
        Scp_Tema11.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema11ActionPerformed

    private void Btn_Aprender_Tema12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema12ActionPerformed
        Scp_Tema12.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema12ActionPerformed

    private void estructurasIntermedias() {
        String[] parrafos = lstList.get(26).getLearningSubContent().split("\n");
        String[] parrafos2 = lstList.get(29).getLearningSubContent().split("su valor.");
        Txa_Analogy12.setText(lstList.get(26).getTitleAnalogy());
        Txa_SubContent12_1.setText(parrafos[0]);
        Txa_SubContent12_2.setText(parrafos[1]);
        Txa_SubContent12_3.setText(parrafos[2] + "\n" + parrafos[3] + "\n"
                + parrafos[4] + "\n" + parrafos[5] + "\n" + parrafos[6]
                + "\n" + parrafos[7] + "\n" + parrafos[8] + "\n\n" + parrafos[9]);
        Txa_SubContent12_4.setText(lstList.get(27).getLearningSubContent());
        Txa_Sintaxis12_1.setText(lstList.get(27).getSyntax());
        syntaxTemas12_1.setText(coList.get(33).getSampleCode());
        Txa_OutputScreen12_1.setText(coList.get(33).getOutputScreen());
        Txa_SubContent12_5.setText(lstList.get(28).getLearningSubContent());
        Txa_Sintaxis12_2.setText(lstList.get(28).getSyntax());
        syntaxTemas12_2.setText(coList.get(34).getSampleCode());
        Txa_OutputScreen12_2.setText(coList.get(34).getOutputScreen());
        Txa_Tips12_1.setText(lstList.get(28).getTips());
        Txa_SubContent12_6.setText(parrafos2[0] + " su valor.");
        Txa_SubContent12_7.setText("  " + parrafos2[1].trim() + parrafos2[2]);
        Txa_SubContent12_8.setText(lstList.get(30).getLearningSubContent());
        Txa_Sintaxis12_3.setText(lstList.get(30).getSyntax());
        syntaxTemas12_3.setText(coList.get(35).getSampleCode());
        Txa_OutputScreen12_3.setText(coList.get(35).getOutputScreen());
        Txa_SubContent12_9.setText(lstList.get(31).getLearningSubContent());
        Txa_Sintaxis12_4.setText(lstList.get(31).getSyntax());
        syntaxTemas12_4.setText(coList.get(36).getSampleCode());
        Txa_OutputScreen12_4.setText(coList.get(36).getOutputScreen());

    }

    private void Btn_Aprender_Tema13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema13ActionPerformed
        estructurasIntermedias();
        Scp_Tema13.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema13ActionPerformed

    private void Btn_Aprender_Tema14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema14ActionPerformed
        Scp_Tema14.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Tema14ActionPerformed

    private void Btn_Siguiente_Cuestionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario1ActionPerformed
        ComentariosContent();
        Scp_Tema1.setVisible(false);
        Scp_Cuestionario1.setVisible(true);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario1ActionPerformed

    private void Btn_Anterior_HelloWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_HelloWordActionPerformed
        helloWorldContent();
        Scp_Tema1.setVisible(true);
        Scp_Cuestionario1.setVisible(false);
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
        ComentariosContent();
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
        validarSeleccionBotones(0);
    }//GEN-LAST:event_Btn_EjercicioActionPerformed

    private void Btn_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EnviarActionPerformed
        String code = syntaxCode.getText();
        String id = "input" + (contador + 1);
        juzgador(id, code, "judge", "iofiles", Integer.toString(contador + 1));
        Btn_Enviar.setSelected(false);
    }//GEN-LAST:event_Btn_EnviarActionPerformed

    private void Btn_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CodigoActionPerformed
        Pnl_CodigoFull.setVisible(true);
        Pnl_EjercicioFull.setVisible(false);
        Pnl_SolucionFull.setVisible(false);
        validarSeleccionBotones(1);
    }//GEN-LAST:event_Btn_CodigoActionPerformed

    private void Btn_SolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SolucionActionPerformed
        Pnl_CodigoFull.setVisible(false);
        Pnl_EjercicioFull.setVisible(false);
        Pnl_SolucionFull.setVisible(true);
        validarSeleccionBotones(2);
    }//GEN-LAST:event_Btn_SolucionActionPerformed

    private void Btn_AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AnteriorActionPerformed
        inicializarBotonesCodeStorm();
        contador--;
        aux--;
        validarEjercicioActivo();
        if (contador == 0) {
            Btn_Anterior.setEnabled(false);
        } else {
            Btn_Siguiente.setEnabled(true);
        }
    }//GEN-LAST:event_Btn_AnteriorActionPerformed

    private void Btn_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SiguienteActionPerformed
        inicializarBotonesCodeStorm();
        contador++;
        aux++;
        validarEjercicioActivo();
        if (contador == 19) {
            Btn_Siguiente.setEnabled(false);
        } else {
            Btn_Anterior.setEnabled(true);
        }
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
        Scp_Ejercicio3.setVisible(true);
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
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Ejercicio1ActionPerformed

    private void Btn_Aprender_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Ejercicio2ActionPerformed
        Scp_Ejercicio2.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_Ejercicio2ActionPerformed

    private void Btn_Aprender_EjercicioFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_EjercicioFinalActionPerformed
        Scp_Ejercicio3.setVisible(true);
        mostrarPanelesAprender();
    }//GEN-LAST:event_Btn_Aprender_EjercicioFinalActionPerformed

    private void Btn_Atras_CodeStormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Atras_CodeStormActionPerformed
        Pnl_ListadoEjercicios.setVisible(true);
        Pnl_General.setVisible(false);
    }//GEN-LAST:event_Btn_Atras_CodeStormActionPerformed

    private void Btn_Atras_AprenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Atras_AprenderActionPerformed
        Pnl_Encabezado.setVisible(false);
        Pnl_Mapa.setVisible(true);
        for (Component scrollpane : Pnl_Temas.getComponents()) {
            if (scrollpane instanceof JScrollPane) {
                ((JScrollPane) scrollpane).setVisible(false);
            }
        }
    }//GEN-LAST:event_Btn_Atras_AprenderActionPerformed

    private void Btn_EnviarEjercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EnviarEjercicio1ActionPerformed
        String code = syntaxEjercicio1.getText();
        juzgador("input1", code, "ioaprender", "ioaprender", "3");
    }//GEN-LAST:event_Btn_EnviarEjercicio1ActionPerformed

    private void Btn_EnviarEjercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EnviarEjercicio2ActionPerformed
        String code = syntaxEjercicio2.getText();
        juzgador("input2", code, "ioaprender", "ioaprender", "3");
    }//GEN-LAST:event_Btn_EnviarEjercicio2ActionPerformed

    private void Btn_EnviarEjercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EnviarEjercicio3ActionPerformed
        String code = syntaxEjercicio3.getText();
        juzgador("input3", code, "ioaprender", "ioaprender", "3");
    }//GEN-LAST:event_Btn_EnviarEjercicio3ActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Btn_AcercaDe;
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
    private javax.swing.JButton Btn_Atras_Aprender;
    private javax.swing.JButton Btn_Atras_CodeStorm;
    private javax.swing.JToggleButton Btn_CodeStorm;
    private javax.swing.JToggleButton Btn_Codigo;
    private javax.swing.JToggleButton Btn_Ejercicio;
    private javax.swing.JToggleButton Btn_Enviar;
    private javax.swing.JButton Btn_EnviarEjercicio1;
    private javax.swing.JButton Btn_EnviarEjercicio2;
    private javax.swing.JButton Btn_EnviarEjercicio3;
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
    protected javax.swing.JToggleButton Btn_Programar;
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
    private javax.swing.JLabel Lbl_BucleDoWhile;
    private javax.swing.JLabel Lbl_BucleFor;
    private javax.swing.JLabel Lbl_BucleWhile;
    private javax.swing.JLabel Lbl_Bucles;
    private javax.swing.JLabel Lbl_CodeEjemplo5;
    private javax.swing.JLabel Lbl_CodeStorm_Fondo;
    private javax.swing.JLabel Lbl_Comentarios;
    private javax.swing.JLabel Lbl_Competencias;
    private javax.swing.JLabel Lbl_Condicionales;
    private javax.swing.JLabel Lbl_CondicionalesAnidados;
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
    private javax.swing.JLabel Lbl_EDDBasicas;
    private javax.swing.JLabel Lbl_EDDIntermedias;
    private javax.swing.JLabel Lbl_Ejercicio1;
    private javax.swing.JLabel Lbl_Ejercicio1_Principiante;
    private javax.swing.JLabel Lbl_Ejercicio2_Intermedio;
    private javax.swing.JLabel Lbl_EjercicioFinal;
    private javax.swing.JLabel Lbl_FuncionesyProcs;
    private javax.swing.JLabel Lbl_HashMap;
    private javax.swing.JLabel Lbl_Header_Aprender;
    private javax.swing.JLabel Lbl_Header_CodeStorm;
    private javax.swing.JLabel Lbl_Header_CodeStorm1;
    private javax.swing.JLabel Lbl_Header_CodeStorm2;
    private javax.swing.JLabel Lbl_Header_Historia;
    private javax.swing.JLabel Lbl_Header_Historia2;
    private javax.swing.JLabel Lbl_Header_Historia3;
    private javax.swing.JLabel Lbl_Header_Historia4;
    private javax.swing.JLabel Lbl_HelloWorld;
    private javax.swing.JLabel Lbl_HomeButttons;
    private javax.swing.JLabel Lbl_Home_Fondo;
    private javax.swing.JLabel Lbl_Input1_1;
    private javax.swing.JLabel Lbl_Input1_2;
    private javax.swing.JLabel Lbl_Input1_3;
    private javax.swing.JLabel Lbl_LecturaeImpresion;
    private javax.swing.JLabel Lbl_Maps;
    private javax.swing.JLabel Lbl_MetodosBasicos12_1;
    private javax.swing.JLabel Lbl_MetodosBasicos12_2;
    private javax.swing.JLabel Lbl_Nivel1;
    private javax.swing.JLabel Lbl_Nivel2;
    private javax.swing.JLabel Lbl_Nivel3;
    private javax.swing.JLabel Lbl_Nivel4;
    private javax.swing.JLabel Lbl_Nivel5;
    private javax.swing.JLabel Lbl_OperadoresAritmeticos;
    private javax.swing.JLabel Lbl_OperadoresLogicos;
    private javax.swing.JLabel Lbl_OperadoresdeRelacion;
    private javax.swing.JLabel Lbl_Output12_1;
    private javax.swing.JLabel Lbl_Output12_2;
    private javax.swing.JLabel Lbl_Output12_3;
    private javax.swing.JLabel Lbl_Output12_4;
    private javax.swing.JLabel Lbl_Output1_1;
    private javax.swing.JLabel Lbl_Output1_2;
    private javax.swing.JLabel Lbl_Output1_3;
    private javax.swing.JLabel Lbl_Output8_1;
    private javax.swing.JLabel Lbl_Output8_10;
    private javax.swing.JLabel Lbl_Output8_2;
    private javax.swing.JLabel Lbl_Output8_3;
    private javax.swing.JLabel Lbl_Output8_4;
    private javax.swing.JLabel Lbl_Output8_5;
    private javax.swing.JLabel Lbl_Output8_6;
    private javax.swing.JLabel Lbl_Output8_7;
    private javax.swing.JLabel Lbl_Output8_8;
    private javax.swing.JLabel Lbl_Output8_9;
    private javax.swing.JLabel Lbl_PrimerosAlgoritmos;
    private javax.swing.JLabel Lbl_QueEs;
    private javax.swing.JLabel Lbl_Recursion;
    private javax.swing.JLabel Lbl_SampleCode12_1;
    private javax.swing.JLabel Lbl_SampleCode12_2;
    private javax.swing.JLabel Lbl_SampleCode12_3;
    private javax.swing.JLabel Lbl_SampleCode12_4;
    private javax.swing.JLabel Lbl_SampleCode2;
    private javax.swing.JLabel Lbl_SampleCode8_1;
    private javax.swing.JLabel Lbl_SampleCode8_10;
    private javax.swing.JLabel Lbl_SampleCode8_11;
    private javax.swing.JLabel Lbl_SampleCode8_2;
    private javax.swing.JLabel Lbl_SampleCode8_3;
    private javax.swing.JLabel Lbl_SampleCode8_4;
    private javax.swing.JLabel Lbl_SampleCode8_5;
    private javax.swing.JLabel Lbl_SampleCode8_6;
    private javax.swing.JLabel Lbl_SampleCode8_7;
    private javax.swing.JLabel Lbl_SampleCode8_8;
    private javax.swing.JLabel Lbl_SampleCode8_9;
    private javax.swing.JLabel Lbl_SampleCode9_4;
    private javax.swing.JLabel Lbl_Sets;
    private javax.swing.JLabel Lbl_Sintaxis1;
    private javax.swing.JLabel Lbl_Sintaxis12_1;
    private javax.swing.JLabel Lbl_Sintaxis12_2;
    private javax.swing.JLabel Lbl_Sintaxis12_3;
    private javax.swing.JLabel Lbl_Sintaxis12_4;
    private javax.swing.JLabel Lbl_Sintaxis8_1;
    private javax.swing.JLabel Lbl_Sintaxis8_1_1;
    private javax.swing.JLabel Lbl_Sintaxis8_2;
    private javax.swing.JLabel Lbl_Sintaxis8_3;
    private javax.swing.JLabel Lbl_Sintaxis8_5;
    private javax.swing.JLabel Lbl_Sintaxis8_6;
    private javax.swing.JLabel Lbl_Sintaxis8_7;
    private javax.swing.JLabel Lbl_SwitchCase;
    private javax.swing.JLabel Lbl_Tabla5;
    private javax.swing.JLabel Lbl_Tabla6;
    private javax.swing.JLabel Lbl_TablaOperadoresLogicos;
    private javax.swing.JLabel Lbl_TablaOperadoresRelacion;
    private javax.swing.JLabel Lbl_Tip12_1;
    private javax.swing.JLabel Lbl_Tip8_1;
    private javax.swing.JLabel Lbl_Tip8_2;
    private javax.swing.JLabel Lbl_TiposdeDatos;
    private javax.swing.JLabel Lbl_Tips2;
    private javax.swing.JLabel Lbl_TreeMap;
    private javax.swing.JLabel Lbl_TreeSet;
    private javax.swing.JLabel Lbl_TryCatch;
    private javax.swing.JProgressBar Pb_Mapa;
    private javax.swing.JProgressBar Pb_Nivel1;
    private javax.swing.JProgressBar Pb_Nivel2;
    private javax.swing.JProgressBar Pb_Nivel3;
    private javax.swing.JProgressBar Pb_Nivel4;
    private javax.swing.JProgressBar Pb_Nivel5;
    private javax.swing.JPanel Pnl_Aprender;
    private javax.swing.JPanel Pnl_Bar_Buttons;
    private javax.swing.JPanel Pnl_BotonesPrincipales;
    private javax.swing.JPanel Pnl_CodeStorm;
    private javax.swing.JPanel Pnl_CodesThemes0;
    private javax.swing.JPanel Pnl_CodesThemes12_1;
    private javax.swing.JPanel Pnl_CodesThemes12_2;
    private javax.swing.JPanel Pnl_CodesThemes12_3;
    private javax.swing.JPanel Pnl_CodesThemes12_4;
    private javax.swing.JPanel Pnl_CodesThemes1_1;
    private javax.swing.JPanel Pnl_CodesThemes1_2;
    private javax.swing.JPanel Pnl_CodesThemes1_3;
    private javax.swing.JPanel Pnl_CodesThemes2;
    private javax.swing.JPanel Pnl_CodesThemes4;
    private javax.swing.JPanel Pnl_CodesThemes5;
    private javax.swing.JPanel Pnl_CodesThemes6;
    private javax.swing.JPanel Pnl_CodesThemes7;
    private javax.swing.JPanel Pnl_CodesThemes7_1;
    private javax.swing.JPanel Pnl_CodesThemes7_2;
    private javax.swing.JPanel Pnl_CodesThemes7_3;
    private javax.swing.JPanel Pnl_CodesThemes7_4;
    private javax.swing.JPanel Pnl_CodesThemes7_5;
    private javax.swing.JPanel Pnl_CodesThemes7_6;
    private javax.swing.JPanel Pnl_CodesThemes7_7;
    private javax.swing.JPanel Pnl_CodesThemes8_1;
    private javax.swing.JPanel Pnl_CodesThemes8_2;
    private javax.swing.JPanel Pnl_CodesThemes8_3;
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
    private javax.swing.JPanel Pnl_Encabezado;
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
    private javax.swing.JPanel Pnl_SyntaxEjercicio1;
    private javax.swing.JPanel Pnl_SyntaxEjercicio2;
    private javax.swing.JPanel Pnl_SyntaxEjercicio3;
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
    private javax.swing.JPanel Pnl_Temas;
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
    private javax.swing.JSeparator Spr_CondicionalesAnidados;
    private javax.swing.JSeparator Spr_DoWhile;
    private javax.swing.JSeparator Spr_For;
    private javax.swing.JSeparator Spr_HashMap;
    private javax.swing.JSeparator Spr_HashSet;
    private javax.swing.JSeparator Spr_Maps;
    private javax.swing.JSeparator Spr_Sets;
    private javax.swing.JSeparator Spr_SwitchCase;
    private javax.swing.JSeparator Spr_TreeMap;
    private javax.swing.JSeparator Spr_TreeSet;
    private javax.swing.JSeparator Spr_TryCatch;
    private javax.swing.JSeparator Spr_While;
    private javax.swing.JTextArea Txa_Analogy0;
    private javax.swing.JTextArea Txa_Analogy1;
    private javax.swing.JTextArea Txa_Analogy12;
    private javax.swing.JTextArea Txa_Analogy2;
    private javax.swing.JTextArea Txa_Analogy4;
    private javax.swing.JTextArea Txa_Analogy5;
    private javax.swing.JTextArea Txa_Analogy6;
    private javax.swing.JTextArea Txa_Analogy7;
    private javax.swing.JTextArea Txa_Analogy7_4;
    private javax.swing.JTextArea Txa_Analogy7_5;
    private javax.swing.JTextArea Txa_Analogy8;
    private javax.swing.JTextArea Txa_Casos7;
    private javax.swing.JTextArea Txa_CodeDescription1;
    private javax.swing.JTextArea Txa_CodeDescription1_1;
    private javax.swing.JTextArea Txa_CodeDescription2;
    private javax.swing.JTextArea Txa_CodeDescription7;
    private javax.swing.JTextArea Txa_CodeDescription7_1;
    private javax.swing.JTextArea Txa_CodeDescription7_3;
    private javax.swing.JTextArea Txa_CodeDescription7_4;
    private javax.swing.JTextArea Txa_CodeDescription7_5;
    private javax.swing.JTextArea Txa_Competencias;
    private javax.swing.JTextArea Txa_OutputScreen0;
    private javax.swing.JTextArea Txa_OutputScreen1;
    private javax.swing.JTextArea Txa_OutputScreen12_1;
    private javax.swing.JTextArea Txa_OutputScreen12_2;
    private javax.swing.JTextArea Txa_OutputScreen12_3;
    private javax.swing.JTextArea Txa_OutputScreen12_4;
    private javax.swing.JTextArea Txa_OutputScreen1_2;
    private javax.swing.JTextArea Txa_OutputScreen1_3;
    private javax.swing.JTextArea Txa_OutputScreen5;
    private javax.swing.JTextArea Txa_OutputScreen6;
    private javax.swing.JTextArea Txa_OutputScreen7;
    private javax.swing.JTextArea Txa_OutputScreen7_1;
    private javax.swing.JTextArea Txa_OutputScreen7_3;
    private javax.swing.JTextArea Txa_OutputScreen7_4;
    private javax.swing.JTextArea Txa_OutputScreen7_5;
    private javax.swing.JTextArea Txa_OutputScreen7_6;
    private javax.swing.JTextArea Txa_OutputScreen7_7;
    private javax.swing.JTextArea Txa_OutputScreen8_1;
    private javax.swing.JTextArea Txa_OutputScreen8_2;
    private javax.swing.JTextArea Txa_OutputScreen8_3;
    private javax.swing.JTextArea Txa_QueEs;
    private javax.swing.JTextArea Txa_Sintaxis12_1;
    private javax.swing.JTextArea Txa_Sintaxis12_2;
    private javax.swing.JTextArea Txa_Sintaxis12_3;
    private javax.swing.JTextArea Txa_Sintaxis12_4;
    private javax.swing.JTextArea Txa_Sintaxis8_1;
    private javax.swing.JTextArea Txa_Sintaxis8_2;
    private javax.swing.JTextArea Txa_Sintaxis8_3;
    private javax.swing.JTextArea Txa_SubContent0;
    private javax.swing.JTextArea Txa_SubContent1;
    private javax.swing.JTextArea Txa_SubContent12_1;
    private javax.swing.JTextArea Txa_SubContent12_2;
    private javax.swing.JTextArea Txa_SubContent12_3;
    private javax.swing.JTextArea Txa_SubContent12_4;
    private javax.swing.JTextArea Txa_SubContent12_5;
    private javax.swing.JTextArea Txa_SubContent12_6;
    private javax.swing.JTextArea Txa_SubContent12_7;
    private javax.swing.JTextArea Txa_SubContent12_8;
    private javax.swing.JTextArea Txa_SubContent12_9;
    private javax.swing.JTextArea Txa_SubContent2;
    private javax.swing.JTextArea Txa_SubContent4;
    private javax.swing.JTextArea Txa_SubContent5_1;
    private javax.swing.JTextArea Txa_SubContent5_2;
    private javax.swing.JTextArea Txa_SubContent6_1;
    private javax.swing.JTextArea Txa_SubContent6_2;
    private javax.swing.JTextArea Txa_SubContent7;
    private javax.swing.JTextArea Txa_SubContent7_4;
    private javax.swing.JTextArea Txa_SubContent8_1;
    private javax.swing.JTextArea Txa_SubContent8_2;
    private javax.swing.JTextArea Txa_SubContent8_3;
    private javax.swing.JTextArea Txa_SubContent8_4;
    private javax.swing.JTextArea Txa_Syntax7_2;
    private javax.swing.JTextArea Txa_Tip4_1;
    private javax.swing.JTextArea Txa_Tip6;
    private javax.swing.JTextArea Txa_Tips12_1;
    private javax.swing.JTextArea Txa_Tips2;
    private javax.swing.JTextArea Txa_Tips8_1;
    private javax.swing.JTextArea Txa_Tips8_2;
    // End of variables declaration//GEN-END:variables
}
