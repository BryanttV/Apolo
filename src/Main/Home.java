package Main;

// Librerias creadas
import Salida.ExitMain;
import Services.RecursosService;
import static Judge.init.juzgador;

import Entities.Progress;
import Entities.Questions;
import Entities.Exercises;
import Entities.TestCases;
import Entities.Curiosities;
import Entities.HistoryImages;
import Entities.LearningImages;
import Entities.LearningTopics;
import Entities.Questionnaires;
import Entities.ExercisesContent;
import Entities.AlternativeSolutions;

import JPA_Controllers.ProgressJpaController;
import JPA_Controllers.ExercisesJpaController;
import JPA_Controllers.QuestionsJpaController;
import JPA_Controllers.TestCasesJpaController;
import JPA_Controllers.CuriositiesJpaController;
import JPA_Controllers.HistoryImagesJpaController;
import JPA_Controllers.LearningImagesJpaController;
import JPA_Controllers.LearningTopicsJpaController;
import JPA_Controllers.QuestionnairesJpaController;
import JPA_Controllers.ExercisesContentJpaController;
import JPA_Controllers.AlternativeSolutionsJpaController;

import CustomComponents.CustomScrollBarUI;
import CustomComponents.CustomProgressBarUIVertical;
import CustomComponents.CustomProgressBarUIHorizontal;

// Librerias Externas
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UnsupportedLookAndFeelException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Home extends javax.swing.JFrame {

    // Clase Recursos
    private final RecursosService sRecursos;

    // Instancias de Clases
    private final HTMLTemplates t = new HTMLTemplates();
    private final ThemesContent tc = new ThemesContent();
    private final Exercise ex = new Exercise();

    // Ventanas JDialog
    private final About st = new About(this, true);
    private final ExitMain Confirmar = new ExitMain(this, true);

    // Declaracion de Resaltador de Sintaxis
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
    private final RSyntaxTextArea syntaxTemas3_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas3_2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas3_3 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas3_4 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas3_5 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas4 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas5 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas6 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_3 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_4 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_5 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_6 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_7 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_8 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_9 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas7_10 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas8_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas8_2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas8_3 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas8_4 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas8_5 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas8_6 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas9_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas9_2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas10_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas10_2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas11_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas11_2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas11_3 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas11_4 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas11_5 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas11_6 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas11_7 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas11_8 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas12_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas12_2 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas12_3 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas12_4 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas13_1 = new RSyntaxTextArea();
    private final RSyntaxTextArea syntaxTemas13_2 = new RSyntaxTextArea();

    // Variables Auxiliares
    private int aux = 1;
    private int cont = 0;
    private boolean active = true;
    private final Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();

    // Tamanio de EditorPane en los ejercicios de CodeStorm
    int[] sizes = new int[]{820, 1000, 530, 530, 800, 760, 710, 680, 780, 950,
        750, 750, 730, 800, 800, 665, 900, 980, 630, 960};

    // Llamada informacion DDBB -------------------------------------------------
    // Creación de Fabrica de Entidades
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApoloPU");

    // Creacion de Controladores
    ExercisesJpaController ejpa = null;
    QuestionsJpaController qjpa = null;
    TestCasesJpaController tcjpa = null;
    ProgressJpaController projpa = null;
    CuriositiesJpaController cujpa = null;
    HistoryImagesJpaController hijpa = null;
    LearningImagesJpaController lijpa = null;
    LearningTopicsJpaController ltjpa = null;
    ExercisesContentJpaController ecjpa = null;
    QuestionnairesJpaController qresjpa = null;
    AlternativeSolutionsJpaController asjpa = null;

    // Creacion de Listas 
    List<Exercises> eList = null;
    List<Questions> qList = null;
    List<TestCases> tcList = null;
    List<Progress> proList = null;
    List<Curiosities> cuList = null;
    List<HistoryImages> hiList = null;
    List<LearningImages> liList = null;
    List<LearningTopics> ltList = null;
    List<ExercisesContent> ecList = null;
    List<Questionnaires> qresList = null;
    List<AlternativeSolutions> asList = null;

    private void generateAllControllers() {
        ejpa = new ExercisesJpaController(emf);
        qjpa = new QuestionsJpaController(emf);
        tcjpa = new TestCasesJpaController(emf);
        projpa = new ProgressJpaController(emf);
        cujpa = new CuriositiesJpaController(emf);
        hijpa = new HistoryImagesJpaController(emf);
        lijpa = new LearningImagesJpaController(emf);
        ltjpa = new LearningTopicsJpaController(emf);
        ecjpa = new ExercisesContentJpaController(emf);
        qresjpa = new QuestionnairesJpaController(emf);
        asjpa = new AlternativeSolutionsJpaController(emf);
    }

    private void generateAllLists() {
        eList = ejpa.findExercisesEntities();
        qList = qjpa.findQuestionsEntities();
        tcList = tcjpa.findTestCasesEntities();
        proList = projpa.findProgressEntities();
        cuList = cujpa.findCuriositiesEntities();
        hiList = hijpa.findHistoryImagesEntities();
        liList = lijpa.findLearningImagesEntities();
        ltList = ltjpa.findLearningTopicsEntities();
        ecList = ecjpa.findExercisesContentEntities();
        qresList = qresjpa.findQuestionnairesEntities();
        asList = asjpa.findAlternativeSolutionsEntities();
    }

    // Constructor
    public Home() {
        sRecursos = RecursosService.getService();
        generateAllControllers();
        generateAllLists();
        initComponents();
        callInfoThemes();
        configureWindow();
        hideComponents();
        initClassExercise();
        loadFontAndCursor();
        configureScrollBar();
        configureProgressBar();
        highlightCode();
        confirmaClosing();
        HistoryContent();
        IntroductionContent();
    }

    private void callInfoThemes() {
        tc.setConnectionDB(emf);
        tc.generateListsInfo();
    }

    // Configurar las Caracteristicas de la Ventana Principal
    private void configureWindow() {
        this.setLocationRelativeTo(null);
        this.setExtendedState(((int) DimMax.getHeight() == 768) ? 6 : 0);
        this.setResizable((int) DimMax.getHeight() == 768);
        this.getContentPane().setBackground(Color.RED); // Color de Fondo del JFrame
        // Agregar icono de Apolo
        setIconImage(new ImageIcon(getClass().getResource(
                "/Resources/General/Apolo_Icono_Blanco_40px.png")).getImage());
    }

    // Ocultar Componentes de todas las Secciones
    private void hideComponents() {
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
    private void configureProgressBar() {
        Pb_Mapa.setUI(new CustomProgressBarUIHorizontal());
        Pb_Nivel1.setUI(new CustomProgressBarUIVertical());
        Pb_Nivel2.setUI(new CustomProgressBarUIVertical());
        Pb_Nivel3.setUI(new CustomProgressBarUIVertical());
        Pb_Nivel4.setUI(new CustomProgressBarUIVertical());
        Pb_Nivel5.setUI(new CustomProgressBarUIVertical());
    }

    // Personalizar la Barra de Desplazamiento de todos los ScrollPane
    private void configureScrollBar() {
        List<Component> compList = getAllComponents(this);
        compList.stream().map((componente) -> {
            if (componente instanceof JScrollPane) {
                JScrollPane scp = (JScrollPane) componente;
                // Agregar Barra de Desplazamiento Personalizada a cada ScrollPane
                JScrollBar v = scp.getVerticalScrollBar();
                v.setUI(new CustomScrollBarUI(sRecursos.getColorDrag(),
                        sRecursos.getColorThumbOn(),
                        sRecursos.getColorThumbOff()));
                v.setUnitIncrement(16);
                scp.setBorder(null);
            }
            return componente;
        }).filter((componente)
                -> (componente instanceof JButton)).map((componente)
                -> (JButton) componente).forEachOrdered((btn)
                -> {
            btn.setCursor(sRecursos.getCMano());
        });
    }

    // Personalizar cursor en los Botones de todas las secciones
    // Cargar fuente personalizada del paquete Tipografias en todas las Secciones
    private void loadFontAndCursor() {

        // Lista de Componentes de la Seccion de Aprender
        List<Component> aprenderList = getAllComponents(Pnl_Aprender);
        aprenderList.stream().filter((componente)
                -> (componente instanceof JLabel)).map((componente)
                -> (JLabel) componente).filter((lbl)
                -> (lbl.getBounds().y == 5)).map((lbl)
                -> {
            lbl.setFont(sRecursos.getFLabelsAprender());
            return lbl;
        }).forEachOrdered((lbl) -> {
            lbl.setForeground(sRecursos.getColorVerde());
        });

        // Lista de Componentes de la Seccion de Historia 
        List<Component> historiaList = getAllComponents(Pnl_Historia);
        historiaList.stream().map((componente) -> {
            if (componente instanceof JLabel) {
                componente.setFont(sRecursos.getFHistoriaB());
                componente.setForeground(sRecursos.getColorAzul());
            }
            return componente;
        }).filter((componente)
                -> (componente instanceof JTextArea)).map((componente)
                -> {
            componente.setFont(sRecursos.getFHistoriaR());
            return componente;
        }).forEachOrdered((componente) -> {
            componente.setForeground(Color.BLACK);
        });
    }

    // Personalizar RSyntaxTextArea en Editor de Codigo
    private void addRSyntax(JPanel p, RSyntaxTextArea rta, RTextScrollPane tsp) {
        rta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        tsp = new RTextScrollPane(rta);

        // Agregar tema personalizado
        changeStyleViaThemeXml(rta);

        // Personalizar ScrollBar Horizontal y Vertical
        int horizontalPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        int verticalPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
        tsp.setHorizontalScrollBarPolicy(horizontalPolicy);
        tsp.setVerticalScrollBarPolicy(verticalPolicy);
        tsp.getHorizontalScrollBar().setUI(new CustomScrollBarUI(
                sRecursos.getColorDrag(),
                sRecursos.getColorThumbOn(),
                sRecursos.getColorThumbOff()));
        tsp.getVerticalScrollBar().setUI(new CustomScrollBarUI(
                sRecursos.getColorDrag(),
                sRecursos.getColorThumbOn(),
                sRecursos.getColorThumbOff()));
        tsp.setBorder(null);

        // Personalizar Area de Texto
        rta.setText("// Pega aquí tu código...");
        rta.setFont(new Font("Consolas", Font.PLAIN, 14));
        rta.setBackground(sRecursos.getCPrincipal());
        rta.setAntiAliasingEnabled(true);
        rta.setCloseMarkupTags(true);
        rta.setPaintTabLines(true);
        rta.revalidate();

        // Agregar Area de Texto al Panel
        p.add(tsp);
    }

    // Personalizar RSyntaxTextArea en Codigo de Ejemplo
    private void addRSyntax(JPanel p, RSyntaxTextArea rta) {
        rta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        changeStyleViaThemeXml(rta);
        rta.setFont(new Font("Consolas", Font.PLAIN, 14));
        rta.setBackground(sRecursos.getCPrincipal());
        rta.setAntiAliasingEnabled(true);
        rta.setUseFocusableTips(false);
        rta.setEditable(false);
        rta.revalidate();
        p.add(rta);
    }

    // Agregar RSyntaxText a panel de Codigo y Solucion en Seccion CodeStorm
    private void highlightCode() {

        // Creacion de Resaltado de Sintaxis para Codigo y Solucion en Seccion CodeStorm
        RTextScrollPane tspCode = new RTextScrollPane();
        RTextScrollPane tspSolution = new RTextScrollPane();
        RTextScrollPane tspEjercicio1 = new RTextScrollPane();
        RTextScrollPane tspEjercicio2 = new RTextScrollPane();
        RTextScrollPane tspEjercicio3 = new RTextScrollPane();

        addRSyntax(Pnl_SyntaxCode, syntaxCode, tspCode);
        addRSyntax(Pnl_SyntaxSolution, syntaxSolution, tspSolution);
        addRSyntax(Pnl_SyntaxEjercicio1, syntaxEjercicio1, tspEjercicio1);
        addRSyntax(Pnl_SyntaxEjercicio2, syntaxEjercicio2, tspEjercicio2);
        addRSyntax(Pnl_SyntaxEjercicio3, syntaxEjercicio3, tspEjercicio3);
        syntaxSolution.setEditable(false);

        addRSyntax(Pnl_CodesThemes0, syntaxTemas0);
        addRSyntax(Pnl_CodesThemes1_1, syntaxTemas1_1);
        addRSyntax(Pnl_CodesThemes1_2, syntaxTemas1_2);
        addRSyntax(Pnl_CodesThemes1_3, syntaxTemas1_3);
        addRSyntax(Pnl_CodesThemes2, syntaxTemas2);
        addRSyntax(Pnl_CodesThemes3_1, syntaxTemas3_1);
        addRSyntax(Pnl_CodesThemes3_2, syntaxTemas3_2);
        addRSyntax(Pnl_CodesThemes3_3, syntaxTemas3_3);
        addRSyntax(Pnl_CodesThemes3_4, syntaxTemas3_4);
        addRSyntax(Pnl_CodesThemes3_5, syntaxTemas3_5);
        addRSyntax(Pnl_CodesThemes4, syntaxTemas4);
        addRSyntax(Pnl_CodesThemes5, syntaxTemas5);
        addRSyntax(Pnl_CodesThemes6, syntaxTemas6);
        addRSyntax(Pnl_CodesThemes7_1, syntaxTemas7_1);
        addRSyntax(Pnl_CodesThemes7_2, syntaxTemas7_2);
        addRSyntax(Pnl_CodesThemes7_3, syntaxTemas7_3);
        addRSyntax(Pnl_CodesThemes7_4, syntaxTemas7_4);
        addRSyntax(Pnl_CodesThemes7_5, syntaxTemas7_5);
        addRSyntax(Pnl_CodesThemes7_6, syntaxTemas7_6);
        addRSyntax(Pnl_CodesThemes7_7, syntaxTemas7_7);
        addRSyntax(Pnl_CodesThemes7_8, syntaxTemas7_8);
        addRSyntax(Pnl_CodesThemes7_9, syntaxTemas7_9);
        addRSyntax(Pnl_CodesThemes7_10, syntaxTemas7_10);
        addRSyntax(Pnl_CodesThemes8_1, syntaxTemas8_1);
        addRSyntax(Pnl_CodesThemes8_2, syntaxTemas8_2);
        addRSyntax(Pnl_CodesThemes8_3, syntaxTemas8_3);
        addRSyntax(Pnl_CodesThemes8_4, syntaxTemas8_4);
        addRSyntax(Pnl_CodesThemes8_5, syntaxTemas8_5);
        addRSyntax(Pnl_CodesThemes8_6, syntaxTemas8_6);
        addRSyntax(Pnl_CodesThemes9_1, syntaxTemas9_1);
        addRSyntax(Pnl_CodesThemes9_2, syntaxTemas9_2);
        addRSyntax(Pnl_CodesThemes10_1, syntaxTemas10_1);
        addRSyntax(Pnl_CodesThemes10_2, syntaxTemas10_2);
        addRSyntax(Pnl_CodesThemes11_1, syntaxTemas11_1);
        addRSyntax(Pnl_CodesThemes11_2, syntaxTemas11_2);
        addRSyntax(Pnl_CodesThemes11_3, syntaxTemas11_3);
        addRSyntax(Pnl_CodesThemes11_4, syntaxTemas11_4);
        addRSyntax(Pnl_CodesThemes11_5, syntaxTemas11_5);
        addRSyntax(Pnl_CodesThemes11_6, syntaxTemas11_6);
        addRSyntax(Pnl_CodesThemes11_7, syntaxTemas11_7);
        addRSyntax(Pnl_CodesThemes11_8, syntaxTemas11_8);
        addRSyntax(Pnl_CodesThemes12_1, syntaxTemas12_1);
        addRSyntax(Pnl_CodesThemes12_2, syntaxTemas12_2);
        addRSyntax(Pnl_CodesThemes12_3, syntaxTemas12_3);
        addRSyntax(Pnl_CodesThemes12_4, syntaxTemas12_4);
        addRSyntax(Pnl_CodesThemes13_1, syntaxTemas13_1);
        addRSyntax(Pnl_CodesThemes13_2, syntaxTemas13_2);
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
    private void confirmaClosing() {
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
    private void shutDownSection(int btn) {
        switch (btn) {
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
    private void enableLearnButtons() {
        for (Component component : Pnl_Aprender.getComponents()) {
            component.setVisible(true);
        }
    }

    // Habilitar botones de la Seccion CodeStorm
    private void enableCodeStormButtons() {
        for (Component component : Pnl_CodeStorm.getComponents()) {
            if (component instanceof JButton || component instanceof JToggleButton) {
                component.setVisible(true);
            }
        }
    }

    // Habilitar botones de la Seccion Historia
    private void enableHistoryButtons() {
        for (Component component : Pnl_Historia.getComponents()) {
            component.setVisible(true);
        }
    }

    // Mostrar panel de Encabezado en Seccion Aprender
    private void showLearnPanels() {
        Pnl_Mapa.setVisible(false);
        Pnl_Encabezado.setVisible(true);
    }

    // Inicializar botones según navegacion en Seccion CodeStorm
    private void initializeCodeStormButtons() {
        Btn_Ejercicio.doClick();
        Btn_Ejercicio.setSelected(true);
        Btn_Codigo.setSelected(false);
        Btn_Solucion.setSelected(false);
    }

    // Habilitar o Deshabilitar botones de Siguiente y Anterior en Seccion CodeStorm
    private void counter() {
        Btn_Anterior.setEnabled((cont != 0));
        Btn_Siguiente.setEnabled((cont != 19));
    }

    // Deshabilitar botones de los Ejercicios según Eleccion en Seccion CodeStorm
    private void validateCodeStormButtons(int option) {
        switch (option) {
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

    // Deshabilitar paneles comunes de la Seccion CodeStorm
    private void ON_OFF_CodeStormPanels() {
        Pnl_General.setVisible(true);
        Pnl_Main.setVisible(true);
        Pnl_ListadoEjercicios.setVisible(false);
        initializeCodeStormButtons();
        counter();
    }

    // Asignar titulo a los paneles en Seccion CodeStorm
    private void addCodeStormTitle(JPanel p) {
        p.setBorder(new TitledBorder(
                new LineBorder(sRecursos.getColorRojo(), 2, true),
                " Nivel " + (int) Math.ceil(((double) cont + 1) / 4)
                + " | Ejercicio " + (aux) + " ",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Tahoma", 1, 30),
                sRecursos.getColorRojo()));
    }

    // Validar ejercicio que se encuentra activo en Seccion CodeStorm
    private void validateActiveExcercise() {
        if (aux > 4) {
            aux = 1;
        } else if (aux == 0) {
            aux = 4;
        }
        addCodeStormTitle(Pnl_EjercicioFull);
        addCodeStormTitle(Pnl_CodigoFull);
        addCodeStormTitle(Pnl_SolucionFull);
    }

    // Cristian ----------------------------------------------------------------
    private String title;
    private String content;
    private String input;
    private String output;
    private String sampleInput;
    private String sampleOutput;

    //Definicion de funciones iniciales
    private void initClassExercise() {
        ex.setConnectionDB(emf);
        ex.generateListsInfo();
    }

    private void getAndPublicInfo() {
        //Obtener info de las listas
        title = ex.getTitle();
        content = ex.getContent();
        input = ex.getInput();
        output = ex.getOutput();
        sampleInput = ex.getSampleInput();
        sampleOutput = ex.getSampleOutput();

        //Calcular la nueva medida vertical del panel
//        resize_Txe_Editor();
        ex.setVerticalSize(sizes[ex.getCounter()]);
        Dimension size = new Dimension(1060, ex.getVerticalSize());
        //Resize panel
        Pnl_ExerciseInfo.setSize(size);
        Pnl_ExerciseInfo.setMaximumSize(size);
        Pnl_ExerciseInfo.setMinimumSize(size);
        Pnl_ExerciseInfo.setPreferredSize(size);

        //Generar formato
        tc.addHTML(t.getExerciseTemplateCodeStorm(), Edt_General_info, title, content, input, output, sampleInput, sampleOutput);

    }

    private void verifySolutionStatus() {
//        int tmp = ex.getCounter();
//        ex.setCounter(tmp);
        if (!ex.getStatus().equals("ACCEPTED")) {
            Btn_Solucion.setEnabled(false);
        } else {
            Btn_Solucion.setEnabled(true);
            syntaxSolution.setText(ex.getSolution());
        }
    }

    // Cristian ----------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bgr_Question1 = new javax.swing.ButtonGroup();
        Bgr_Question2 = new javax.swing.ButtonGroup();
        Bgr_Question3 = new javax.swing.ButtonGroup();
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
        Lbl_HelloWorld = new javax.swing.JLabel();
        Edt0_1 = new javax.swing.JEditorPane();
        Pnl_CodesThemes0 = new javax.swing.JPanel();
        Edt0_2 = new javax.swing.JEditorPane();
        Btn_Siguiente_Cuestionario1 = new javax.swing.JButton();
        Scp_Cuestionario1 = new javax.swing.JScrollPane();
        Pnl_Cuestionario1 = new javax.swing.JPanel();
        Btn_Anterior_HelloWord = new javax.swing.JButton();
        Btn_Siguiente_Comentarios = new javax.swing.JButton();
        Lbl_Cuestionario1 = new javax.swing.JLabel();
        Rad_Question0_1 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        Btn_Answer0 = new javax.swing.JButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        Rad_Question0 = new javax.swing.JRadioButton();
        Rad_Question0_2 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        Rad_Question01 = new javax.swing.JRadioButton();
        Rad_Question0_3 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        EdtCuestionario1 = new javax.swing.JEditorPane();
        Scp_Tema2 = new javax.swing.JScrollPane();
        Pnl_Tema2 = new javax.swing.JPanel();
        Lbl_Comentarios = new javax.swing.JLabel();
        Edt1_1 = new javax.swing.JEditorPane();
        Pnl_CodesThemes1_1 = new javax.swing.JPanel();
        Edt1_2 = new javax.swing.JEditorPane();
        Pnl_CodesThemes1_2 = new javax.swing.JPanel();
        Edt1_3 = new javax.swing.JEditorPane();
        Pnl_CodesThemes1_3 = new javax.swing.JPanel();
        Edt1_4 = new javax.swing.JEditorPane();
        Btn_Anterior_Cuestionario1 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario2 = new javax.swing.JButton();
        Scp_Cuestionario2 = new javax.swing.JScrollPane();
        Pnl_Cuestionario2 = new javax.swing.JPanel();
        Btn_Anterior_Comentarios = new javax.swing.JButton();
        Btn_Siguiente_TiposdeDatos = new javax.swing.JButton();
        Lbl_Cuestionario2 = new javax.swing.JLabel();
        Rad_Question0_4 = new javax.swing.JRadioButton();
        Rad_Question1_1 = new javax.swing.JRadioButton();
        Btn_Answer1 = new javax.swing.JButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        Rad_Question1_2 = new javax.swing.JRadioButton();
        Rad_Question0_5 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        Rad_Question1_3 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        EdtCuestionario2 = new javax.swing.JEditorPane();
        Scp_Tema3 = new javax.swing.JScrollPane();
        Pnl_Tema3 = new javax.swing.JPanel();
        Lbl_TiposdeDatos = new javax.swing.JLabel();
        Edt2_1 = new javax.swing.JEditorPane();
        Pnl_CodesThemes2 = new javax.swing.JPanel();
        Edt2_2 = new javax.swing.JEditorPane();
        Btn_Anterior_Cuestionario2 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario3 = new javax.swing.JButton();
        Scp_Cuestionario3 = new javax.swing.JScrollPane();
        Pnl_Cuestionario3 = new javax.swing.JPanel();
        Btn_Anterior_TiposdeDatos = new javax.swing.JButton();
        Btn_Siguiente_OperadoresAritmeticos = new javax.swing.JButton();
        Lbl_Cuestionario3 = new javax.swing.JLabel();
        Rad_Question0_6 = new javax.swing.JRadioButton();
        Rad_Question1_4 = new javax.swing.JRadioButton();
        Btn_Answer2 = new javax.swing.JButton();
        Rad_Question2_1 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        Rad_Question1_5 = new javax.swing.JRadioButton();
        Rad_Question2_2 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jRadioButton21 = new javax.swing.JRadioButton();
        Rad_Question3 = new javax.swing.JRadioButton();
        Rad_Question1_6 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        Rad_Question2_3 = new javax.swing.JRadioButton();
        EdtCuestionario3 = new javax.swing.JEditorPane();
        Scp_Tema4 = new javax.swing.JScrollPane();
        Pnl_Tema4 = new javax.swing.JPanel();
        Lbl_OperadoresAritmeticos = new javax.swing.JLabel();
        Edt3_1 = new javax.swing.JEditorPane();
        Pnl_CodesThemes3_1 = new javax.swing.JPanel();
        Edt3_2 = new javax.swing.JEditorPane();
        Pnl_CodesThemes3_2 = new javax.swing.JPanel();
        Edt3_3 = new javax.swing.JEditorPane();
        Spr_Acumuladores = new javax.swing.JSeparator();
        Lbl_Acumuladores = new javax.swing.JLabel();
        Edt3_4 = new javax.swing.JEditorPane();
        Pnl_CodesThemes3_3 = new javax.swing.JPanel();
        Edt3_5 = new javax.swing.JEditorPane();
        Pnl_CodesThemes3_4 = new javax.swing.JPanel();
        Edt3_6 = new javax.swing.JEditorPane();
        Spr_OperadoresIncDec = new javax.swing.JSeparator();
        Lbl_OperadorIncDec = new javax.swing.JLabel();
        Edt3_7 = new javax.swing.JEditorPane();
        Pnl_CodesThemes3_5 = new javax.swing.JPanel();
        Edt3_8 = new javax.swing.JEditorPane();
        Btn_Anterior_Cuestionario3 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario4 = new javax.swing.JButton();
        Scp_Cuestionario4 = new javax.swing.JScrollPane();
        Pnl_Cuestionario4 = new javax.swing.JPanel();
        Btn_Anterior_OperadoresAritmeticos = new javax.swing.JButton();
        Btn_Siguiente_LecturaeImpresion = new javax.swing.JButton();
        Lbl_Cuestionario4 = new javax.swing.JLabel();
        Rad_Question3_1 = new javax.swing.JRadioButton();
        Rad_Question1_7 = new javax.swing.JRadioButton();
        Btn_Answer3 = new javax.swing.JButton();
        Rad_Question2_4 = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        Rad_Question1_8 = new javax.swing.JRadioButton();
        Rad_Question2_5 = new javax.swing.JRadioButton();
        Rad_Question3_2 = new javax.swing.JRadioButton();
        jRadioButton25 = new javax.swing.JRadioButton();
        Rad_Question4 = new javax.swing.JRadioButton();
        Rad_Question1_9 = new javax.swing.JRadioButton();
        jRadioButton26 = new javax.swing.JRadioButton();
        Rad_Question3_3 = new javax.swing.JRadioButton();
        EdtCuestionario4 = new javax.swing.JEditorPane();
        Scp_Tema5 = new javax.swing.JScrollPane();
        Pnl_Tema5 = new javax.swing.JPanel();
        Lbl_LecturaeImpresion = new javax.swing.JLabel();
        Edt4_1 = new javax.swing.JEditorPane();
        Pnl_CodesThemes4 = new javax.swing.JPanel();
        Edt4_2 = new javax.swing.JEditorPane();
        Btn_Anterior_Cuestionario4 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario5 = new javax.swing.JButton();
        Scp_Cuestionario5 = new javax.swing.JScrollPane();
        Pnl_Cuestionario5 = new javax.swing.JPanel();
        Btn_Anterior_LecturaeImpresion = new javax.swing.JButton();
        Btn_Siguiente_Ejercicio1 = new javax.swing.JButton();
        Lbl_Cuestionario5 = new javax.swing.JLabel();
        Rad_Question4_1_1 = new javax.swing.JRadioButton();
        Rad_Question1_10 = new javax.swing.JRadioButton();
        Btn_Answer4 = new javax.swing.JButton();
        Rad_Question2_6 = new javax.swing.JRadioButton();
        Rad_Question4_1 = new javax.swing.JRadioButton();
        Rad_Question4_2 = new javax.swing.JRadioButton();
        Rad_Question4_3 = new javax.swing.JRadioButton();
        Rad_Question1_20 = new javax.swing.JRadioButton();
        Rad_Question3_7 = new javax.swing.JRadioButton();
        Rad_Question4_00 = new javax.swing.JRadioButton();
        Rad_Question4_7 = new javax.swing.JRadioButton();
        jRadioButton35 = new javax.swing.JRadioButton();
        Rad_Question3_13 = new javax.swing.JRadioButton();
        EdtCuestionario5 = new javax.swing.JEditorPane();
        Scp_Ejercicio1 = new javax.swing.JScrollPane();
        Pnl_Ejercicio1_Aprender = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario5 = new javax.swing.JButton();
        Btn_Siguiente_OperadoresdeRelacion = new javax.swing.JButton();
        Lbl_Ejercicio1_Principiante = new javax.swing.JLabel();
        Btn_EnviarEjercicio1 = new javax.swing.JButton();
        Pnl_SyntaxEjercicio1 = new javax.swing.JPanel();
        Edt_Ejercicio1 = new javax.swing.JEditorPane();
        Scp_Tema6 = new javax.swing.JScrollPane();
        Pnl_Tema6 = new javax.swing.JPanel();
        Lbl_OperadoresdeRelacion = new javax.swing.JLabel();
        Edt5_1 = new javax.swing.JEditorPane();
        Lbl_TablaOperadoresRelacion = new javax.swing.JLabel();
        Edt5_2 = new javax.swing.JEditorPane();
        Pnl_CodesThemes5 = new javax.swing.JPanel();
        Edt5_3 = new javax.swing.JEditorPane();
        Btn_Anterior_Ejercicio1_Principiante = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario6 = new javax.swing.JButton();
        Scp_Cuestionario6 = new javax.swing.JScrollPane();
        Pnl_Cuestionario6 = new javax.swing.JPanel();
        Btn_Anterior_OperadoresdeRelacion = new javax.swing.JButton();
        Btn_Siguiente_OperadoresLogicos = new javax.swing.JButton();
        Lbl_Cuestionario6 = new javax.swing.JLabel();
        Rad_Question5_1_0 = new javax.swing.JRadioButton();
        Rad_Question1_12 = new javax.swing.JRadioButton();
        Btn_Answer5 = new javax.swing.JButton();
        Rad_Question2_8 = new javax.swing.JRadioButton();
        Rad_Question5_1 = new javax.swing.JRadioButton();
        Rad_Question2_9 = new javax.swing.JRadioButton();
        Rad_Question5_2 = new javax.swing.JRadioButton();
        Rad_Question5_3 = new javax.swing.JRadioButton();
        Rad_Question4_6 = new javax.swing.JRadioButton();
        jRadioButton29 = new javax.swing.JRadioButton();
        Rad_Question3_8 = new javax.swing.JRadioButton();
        EdtCuestionario6 = new javax.swing.JEditorPane();
        Scp_Tema7 = new javax.swing.JScrollPane();
        Pnl_Tema7 = new javax.swing.JPanel();
        Lbl_OperadoresLogicos = new javax.swing.JLabel();
        Edt6_1 = new javax.swing.JEditorPane();
        Lbl_TablaOperadoresLogicos = new javax.swing.JLabel();
        Edt6_2 = new javax.swing.JEditorPane();
        Pnl_CodesThemes6 = new javax.swing.JPanel();
        Edt6_3 = new javax.swing.JEditorPane();
        Btn_Anterior_Cuestionario6 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario7 = new javax.swing.JButton();
        Scp_Cuestionario7 = new javax.swing.JScrollPane();
        Pnl_Cuestionario7 = new javax.swing.JPanel();
        Btn_Anterior_OperadoresLogicos = new javax.swing.JButton();
        Btn_Siguiente_Condicionales = new javax.swing.JButton();
        Lbl_Cuestionario7 = new javax.swing.JLabel();
        Rad_Question5_4 = new javax.swing.JRadioButton();
        Rad_Question6_1 = new javax.swing.JRadioButton();
        Btn_Answer6 = new javax.swing.JButton();
        Rad_Question2_10 = new javax.swing.JRadioButton();
        Rad_Question6_1_0 = new javax.swing.JRadioButton();
        Rad_Question1_15 = new javax.swing.JRadioButton();
        Rad_Question2_11 = new javax.swing.JRadioButton();
        Rad_Question5_5 = new javax.swing.JRadioButton();
        Rad_Question6_2 = new javax.swing.JRadioButton();
        Rad_Question6_3 = new javax.swing.JRadioButton();
        Rad_Question4_8 = new javax.swing.JRadioButton();
        jRadioButton31 = new javax.swing.JRadioButton();
        Rad_Question3_9 = new javax.swing.JRadioButton();
        EdtCuestionario7 = new javax.swing.JEditorPane();
        Scp_Tema8 = new javax.swing.JScrollPane();
        Pnl_Tema8 = new javax.swing.JPanel();
        Lbl_Condicionales = new javax.swing.JLabel();
        Edt7_1 = new javax.swing.JEditorPane();
        Pnl_CodesThemes7_1 = new javax.swing.JPanel();
        Edt7_2 = new javax.swing.JEditorPane();
        Pnl_CodesThemes7_2 = new javax.swing.JPanel();
        Edt7_3 = new javax.swing.JEditorPane();
        Spr_CondicionalesAnidados = new javax.swing.JSeparator();
        Lbl_CondicionalesAnidados = new javax.swing.JLabel();
        Lbl_Sintaxis8_7 = new javax.swing.JLabel();
        Pnl_CodesThemes7_3 = new javax.swing.JPanel();
        Lbl_SampleCode8_10 = new javax.swing.JLabel();
        Pnl_CodesThemes7_4 = new javax.swing.JPanel();
        Edt7_4 = new javax.swing.JEditorPane();
        Spr_TryCatch = new javax.swing.JSeparator();
        Lbl_TryCatch = new javax.swing.JLabel();
        Edt7_5 = new javax.swing.JEditorPane();
        Pnl_CodesThemes7_9 = new javax.swing.JPanel();
        Lbl_SampleCode8_8 = new javax.swing.JLabel();
        Pnl_CodesThemes7_5 = new javax.swing.JPanel();
        Edt7_6 = new javax.swing.JEditorPane();
        Pnl_CodesThemes7_6 = new javax.swing.JPanel();
        Edt7_7 = new javax.swing.JEditorPane();
        Pnl_CodesThemes7_7 = new javax.swing.JPanel();
        Edt7_8 = new javax.swing.JEditorPane();
        Spr_SwitchCase = new javax.swing.JSeparator();
        Lbl_SwitchCase = new javax.swing.JLabel();
        Edt7_9 = new javax.swing.JEditorPane();
        Pnl_CodesThemes7_10 = new javax.swing.JPanel();
        Lbl_SampleCode8_5 = new javax.swing.JLabel();
        Pnl_CodesThemes7_8 = new javax.swing.JPanel();
        Edt7_10 = new javax.swing.JEditorPane();
        Btn_Anterior_Cuestionario7 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario8 = new javax.swing.JButton();
        Scp_Cuestionario8 = new javax.swing.JScrollPane();
        Pnl_Cuestionario8 = new javax.swing.JPanel();
        Btn_Anterior_Condicionales = new javax.swing.JButton();
        Btn_Siguiente_Bucles = new javax.swing.JButton();
        Lbl_Cuestionario8 = new javax.swing.JLabel();
        Rad_Question5_6 = new javax.swing.JRadioButton();
        Rad_Question7_1_0 = new javax.swing.JRadioButton();
        Btn_Answer7 = new javax.swing.JButton();
        Rad_Question2_12 = new javax.swing.JRadioButton();
        Rad_Question7_1 = new javax.swing.JRadioButton();
        Rad_Question1_17 = new javax.swing.JRadioButton();
        Rad_Question7_2 = new javax.swing.JRadioButton();
        Rad_Question5_7 = new javax.swing.JRadioButton();
        Rad_Question7_2_0 = new javax.swing.JRadioButton();
        Rad_Question7_3 = new javax.swing.JRadioButton();
        Rad_Question4_9 = new javax.swing.JRadioButton();
        jRadioButton32 = new javax.swing.JRadioButton();
        Rad_Question3_10 = new javax.swing.JRadioButton();
        EdtCuestionario8 = new javax.swing.JEditorPane();
        Scp_Tema9 = new javax.swing.JScrollPane();
        Pnl_Tema9 = new javax.swing.JPanel();
        Lbl_Bucles = new javax.swing.JLabel();
        Edt8_1 = new javax.swing.JEditorPane();
        Spr_While = new javax.swing.JSeparator();
        Lbl_BucleWhile = new javax.swing.JLabel();
        Edt8_2 = new javax.swing.JEditorPane();
        Pnl_CodesThemes8_4 = new javax.swing.JPanel();
        Lbl_SampleCode8_1 = new javax.swing.JLabel();
        Pnl_CodesThemes8_1 = new javax.swing.JPanel();
        Edt8_3 = new javax.swing.JEditorPane();
        Spr_For = new javax.swing.JSeparator();
        Lbl_BucleFor = new javax.swing.JLabel();
        Edt8_4 = new javax.swing.JEditorPane();
        Pnl_CodesThemes8_5 = new javax.swing.JPanel();
        Lbl_SampleCode8_2 = new javax.swing.JLabel();
        Pnl_CodesThemes8_2 = new javax.swing.JPanel();
        Edt8_5 = new javax.swing.JEditorPane();
        Spr_DoWhile = new javax.swing.JSeparator();
        Lbl_BucleDoWhile = new javax.swing.JLabel();
        Edt8_6 = new javax.swing.JEditorPane();
        Pnl_CodesThemes8_6 = new javax.swing.JPanel();
        Lbl_SampleCode8_3 = new javax.swing.JLabel();
        Pnl_CodesThemes8_3 = new javax.swing.JPanel();
        Edt8_7 = new javax.swing.JEditorPane();
        Btn_Anterior_Cuestionario8 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario9 = new javax.swing.JButton();
        Scp_Cuestionario9 = new javax.swing.JScrollPane();
        Pnl_Cuestionario9 = new javax.swing.JPanel();
        Btn_Anterior_Bucles = new javax.swing.JButton();
        Btn_Siguiente_Ejercicio2_Intermedio = new javax.swing.JButton();
        Lbl_Cuestionario9 = new javax.swing.JLabel();
        Rad_Question5_8 = new javax.swing.JRadioButton();
        Rad_Question8_1 = new javax.swing.JRadioButton();
        Btn_Answer8 = new javax.swing.JButton();
        Rad_Question2_14 = new javax.swing.JRadioButton();
        Rad_Question8_1_0 = new javax.swing.JRadioButton();
        Rad_Question8_2 = new javax.swing.JRadioButton();
        Rad_Question8_2_0 = new javax.swing.JRadioButton();
        Rad_Question5_9 = new javax.swing.JRadioButton();
        Rad_Question7_5 = new javax.swing.JRadioButton();
        Rad_Question8_3_0 = new javax.swing.JRadioButton();
        Rad_Question4_10 = new javax.swing.JRadioButton();
        jRadioButton33 = new javax.swing.JRadioButton();
        Rad_Question8_3 = new javax.swing.JRadioButton();
        EdtCuestionario9 = new javax.swing.JEditorPane();
        Scp_Ejercicio2 = new javax.swing.JScrollPane();
        Pnl_Ejercicio2_Aprender = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario9 = new javax.swing.JButton();
        Btn_Siguiente_FuncionesyProc = new javax.swing.JButton();
        Lbl_Ejercicio2_Intermedio = new javax.swing.JLabel();
        Btn_EnviarEjercicio2 = new javax.swing.JButton();
        Pnl_SyntaxEjercicio2 = new javax.swing.JPanel();
        Edt_Ejercicio2 = new javax.swing.JEditorPane();
        Scp_Tema10 = new javax.swing.JScrollPane();
        Pnl_Tema10 = new javax.swing.JPanel();
        Lbl_FuncionesyProcs = new javax.swing.JLabel();
        Edt9_1 = new javax.swing.JEditorPane();
        Pnl_CodesThemes9_1 = new javax.swing.JPanel();
        Edt9_2 = new javax.swing.JEditorPane();
        Pnl_CodesThemes9_2 = new javax.swing.JPanel();
        Edt9_3 = new javax.swing.JEditorPane();
        Btn_Anterior_Ejercicio2_Intermedio = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario10 = new javax.swing.JButton();
        Scp_Cuestionario10 = new javax.swing.JScrollPane();
        Pnl_Cuestionario10 = new javax.swing.JPanel();
        Btn_Anterior_FuncyProc = new javax.swing.JButton();
        Btn_Siguiente_Recursion = new javax.swing.JButton();
        Lbl_Cuestionario10 = new javax.swing.JLabel();
        Rad_Question5_10 = new javax.swing.JRadioButton();
        Rad_Question9_1 = new javax.swing.JRadioButton();
        Btn_Answer9 = new javax.swing.JButton();
        Rad_Question2_15 = new javax.swing.JRadioButton();
        Rad_Question8_4 = new javax.swing.JRadioButton();
        Rad_Question1_19 = new javax.swing.JRadioButton();
        Rad_Question8_5 = new javax.swing.JRadioButton();
        Rad_Question5_11 = new javax.swing.JRadioButton();
        Rad_Question9_2 = new javax.swing.JRadioButton();
        Rad_Question8_6 = new javax.swing.JRadioButton();
        Rad_Question4_11 = new javax.swing.JRadioButton();
        Rad_Question9_3 = new javax.swing.JRadioButton();
        Rad_Question3_12 = new javax.swing.JRadioButton();
        EdtCuestionario10 = new javax.swing.JEditorPane();
        Scp_Tema11 = new javax.swing.JScrollPane();
        Pnl_Tema11 = new javax.swing.JPanel();
        Lbl_Recursion = new javax.swing.JLabel();
        Edt10_1 = new javax.swing.JEditorPane();
        Pnl_CodesThemes10_1 = new javax.swing.JPanel();
        Edt10_2 = new javax.swing.JEditorPane();
        Pnl_CodesThemes10_2 = new javax.swing.JPanel();
        Edt10_3 = new javax.swing.JEditorPane();
        Btn_Anterior_Cuestionario10 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario11 = new javax.swing.JButton();
        Scp_Cuestionario11 = new javax.swing.JScrollPane();
        Pnl_Cuestionario11 = new javax.swing.JPanel();
        Btn_Anterior_Recursion = new javax.swing.JButton();
        Btn_Siguiente_EDDBasicas = new javax.swing.JButton();
        Lbl_Cuestionario11 = new javax.swing.JLabel();
        Rad_Question5_13 = new javax.swing.JRadioButton();
        Rad_Question10_1 = new javax.swing.JRadioButton();
        Btn_Answer10 = new javax.swing.JButton();
        Rad_Question8_9 = new javax.swing.JRadioButton();
        Rad_Question10_2 = new javax.swing.JRadioButton();
        Rad_Question8_10 = new javax.swing.JRadioButton();
        Rad_Question5_14 = new javax.swing.JRadioButton();
        Rad_Question10_2_1 = new javax.swing.JRadioButton();
        Rad_Question8_11 = new javax.swing.JRadioButton();
        Rad_Question10_3 = new javax.swing.JRadioButton();
        Rad_Question3_14 = new javax.swing.JRadioButton();
        EdtCuestionario11 = new javax.swing.JEditorPane();
        Scp_Tema12 = new javax.swing.JScrollPane();
        Pnl_Tema12 = new javax.swing.JPanel();
        Lbl_EDDBasicas = new javax.swing.JLabel();
        Edt11_1 = new javax.swing.JEditorPane();
        Pnl_CodesThemes11_1 = new javax.swing.JPanel();
        Spr_VectorFijo = new javax.swing.JSeparator();
        Lbl_VectorFijo = new javax.swing.JLabel();
        Edt11_2 = new javax.swing.JEditorPane();
        Pnl_CodesThemes11_2 = new javax.swing.JPanel();
        Edt11_3 = new javax.swing.JEditorPane();
        Pnl_CodesThemes11_3 = new javax.swing.JPanel();
        Edt11_4 = new javax.swing.JEditorPane();
        Spr_VectorDinamico = new javax.swing.JSeparator();
        Lbl_VectorDinamico = new javax.swing.JLabel();
        Edt11_5 = new javax.swing.JEditorPane();
        Pnl_CodesThemes11_4 = new javax.swing.JPanel();
        Edt11_6 = new javax.swing.JEditorPane();
        Spr_MatrizFija = new javax.swing.JSeparator();
        Lbl_MatrizFija = new javax.swing.JLabel();
        Edt11_7 = new javax.swing.JEditorPane();
        Pnl_CodesThemes11_5 = new javax.swing.JPanel();
        Edt11_8 = new javax.swing.JEditorPane();
        Spr_MatrizDinamica = new javax.swing.JSeparator();
        Lbl_MatrizDinamica = new javax.swing.JLabel();
        Edt11_9 = new javax.swing.JEditorPane();
        Pnl_CodesThemes11_6 = new javax.swing.JPanel();
        Edt11_10 = new javax.swing.JEditorPane();
        Spr_Pilas = new javax.swing.JSeparator();
        Lbl_Pilas = new javax.swing.JLabel();
        Edt11_11 = new javax.swing.JEditorPane();
        Pnl_CodesThemes11_7 = new javax.swing.JPanel();
        Edt11_12 = new javax.swing.JEditorPane();
        Spr_Colas = new javax.swing.JSeparator();
        Lbl_Colas = new javax.swing.JLabel();
        Edt11_13 = new javax.swing.JEditorPane();
        Pnl_CodesThemes11_8 = new javax.swing.JPanel();
        Edt11_14 = new javax.swing.JEditorPane();
        Btn_Anterior_Cuestionario11 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario12 = new javax.swing.JButton();
        Scp_Cuestionario12 = new javax.swing.JScrollPane();
        Pnl_Cuestionario12 = new javax.swing.JPanel();
        Btn_Anterior_EDDBasicas = new javax.swing.JButton();
        Btn_Siguiente_EDDIntermedias = new javax.swing.JButton();
        Lbl_Cuestionario12 = new javax.swing.JLabel();
        Rad_Question5_15 = new javax.swing.JRadioButton();
        Rad_Question10_4 = new javax.swing.JRadioButton();
        Rad_Question11_1 = new javax.swing.JRadioButton();
        Rad_Question10_5 = new javax.swing.JRadioButton();
        Rad_Question11_2 = new javax.swing.JRadioButton();
        Rad_Question10_2_2 = new javax.swing.JRadioButton();
        Rad_Question11_3 = new javax.swing.JRadioButton();
        Rad_Question10_6 = new javax.swing.JRadioButton();
        Rad_Question3_18 = new javax.swing.JRadioButton();
        Btn_Answer11 = new javax.swing.JButton();
        EdtCuestionario12 = new javax.swing.JEditorPane();
        Scp_Tema13 = new javax.swing.JScrollPane();
        Pnl_Tema13 = new javax.swing.JPanel();
        Lbl_EDDIntermedias = new javax.swing.JLabel();
        Edt12_1 = new javax.swing.JEditorPane();
        Spr_Sets = new javax.swing.JSeparator();
        Lbl_Sets = new javax.swing.JLabel();
        Edt12_2 = new javax.swing.JEditorPane();
        Spr_HashSet = new javax.swing.JSeparator();
        Lbl_HashSet = new javax.swing.JLabel();
        Edt12_3 = new javax.swing.JEditorPane();
        Pnl_CodesThemes12_1 = new javax.swing.JPanel();
        Edt12_4 = new javax.swing.JEditorPane();
        Spr_TreeSet = new javax.swing.JSeparator();
        Lbl_TreeSet = new javax.swing.JLabel();
        Edt12_5 = new javax.swing.JEditorPane();
        Pnl_CodesThemes12_2 = new javax.swing.JPanel();
        Edt12_6 = new javax.swing.JEditorPane();
        Spr_Maps = new javax.swing.JSeparator();
        Lbl_Maps = new javax.swing.JLabel();
        Edt12_7 = new javax.swing.JEditorPane();
        Spr_HashMap = new javax.swing.JSeparator();
        Lbl_HashMap = new javax.swing.JLabel();
        Edt12_8 = new javax.swing.JEditorPane();
        Pnl_CodesThemes12_3 = new javax.swing.JPanel();
        Edt12_9 = new javax.swing.JEditorPane();
        Spr_TreeMap = new javax.swing.JSeparator();
        Lbl_TreeMap = new javax.swing.JLabel();
        Edt12_10 = new javax.swing.JEditorPane();
        Pnl_CodesThemes12_4 = new javax.swing.JPanel();
        Edt12_11 = new javax.swing.JEditorPane();
        Btn_Anterior_Cuestionario12 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario13 = new javax.swing.JButton();
        Scp_Cuestionario13 = new javax.swing.JScrollPane();
        Pnl_Cuestionario13 = new javax.swing.JPanel();
        Btn_Anterior_EDDIntermedias = new javax.swing.JButton();
        Btn_Siguiente_PrimerosAlgoritmos = new javax.swing.JButton();
        Lbl_Cuestionario13 = new javax.swing.JLabel();
        Rad_Question5_17 = new javax.swing.JRadioButton();
        Rad_Question8_12 = new javax.swing.JRadioButton();
        Rad_Question12_1 = new javax.swing.JRadioButton();
        Rad_Question8_1_1 = new javax.swing.JRadioButton();
        Rad_Question8_13 = new javax.swing.JRadioButton();
        Rad_Question12_2 = new javax.swing.JRadioButton();
        Rad_Question5_18 = new javax.swing.JRadioButton();
        Rad_Question7_6 = new javax.swing.JRadioButton();
        Rad_Question12_3 = new javax.swing.JRadioButton();
        Rad_Question4_16 = new javax.swing.JRadioButton();
        jRadioButton34 = new javax.swing.JRadioButton();
        Rad_Question8_14 = new javax.swing.JRadioButton();
        Btn_Answer12 = new javax.swing.JButton();
        EdtCuestionario13 = new javax.swing.JEditorPane();
        Scp_Tema14 = new javax.swing.JScrollPane();
        Pnl_Tema14 = new javax.swing.JPanel();
        Lbl_PrimerosAlgoritmos = new javax.swing.JLabel();
        Lbl_BubbleSort = new javax.swing.JLabel();
        Edt13_1 = new javax.swing.JEditorPane();
        Pnl_CodesThemes13_1 = new javax.swing.JPanel();
        Edt13_2 = new javax.swing.JEditorPane();
        Lbl_ImagenBubbleSort = new javax.swing.JLabel();
        Edt13_3 = new javax.swing.JEditorPane();
        Spr_BinarySearch = new javax.swing.JSeparator();
        Lbl_BinarySearch = new javax.swing.JLabel();
        Edt13_4 = new javax.swing.JEditorPane();
        Pnl_CodesThemes13_2 = new javax.swing.JPanel();
        Edt13_5 = new javax.swing.JEditorPane();
        Lbl_ImagenBinarySearch = new javax.swing.JLabel();
        Edt13_6 = new javax.swing.JEditorPane();
        Btn_Anterior_Cuestionario13 = new javax.swing.JButton();
        Btn_Siguiente_Cuestionario14 = new javax.swing.JButton();
        Scp_Cuestionario14 = new javax.swing.JScrollPane();
        Pnl_Cuestionario14 = new javax.swing.JPanel();
        Btn_Anterior_PrimerosAlgoritmos = new javax.swing.JButton();
        Btn_Siguiente_EjercicioFinal = new javax.swing.JButton();
        Lbl_Cuestionario14 = new javax.swing.JLabel();
        Rad_Question13_1 = new javax.swing.JRadioButton();
        Rad_Question10_7 = new javax.swing.JRadioButton();
        Rad_Question2_21 = new javax.swing.JRadioButton();
        Rad_Question11_4 = new javax.swing.JRadioButton();
        Rad_Question10_8 = new javax.swing.JRadioButton();
        Rad_Question11_5 = new javax.swing.JRadioButton();
        Rad_Question13_2 = new javax.swing.JRadioButton();
        Rad_Question10_2_3 = new javax.swing.JRadioButton();
        Rad_Question11_6 = new javax.swing.JRadioButton();
        Rad_Question13_3 = new javax.swing.JRadioButton();
        Rad_Question10_3_3 = new javax.swing.JRadioButton();
        Rad_Question3_19 = new javax.swing.JRadioButton();
        Btn_Answer13 = new javax.swing.JButton();
        EdtCuestionario14 = new javax.swing.JEditorPane();
        Scp_Ejercicio3 = new javax.swing.JScrollPane();
        Pnl_Ejercicio3_Aprender = new javax.swing.JPanel();
        Btn_Anterior_Cuestionario14 = new javax.swing.JButton();
        Lbl_EjercicioFinal = new javax.swing.JLabel();
        Btn_EnviarEjercicio3 = new javax.swing.JButton();
        Pnl_SyntaxEjercicio3 = new javax.swing.JPanel();
        Edt_Ejercicio3 = new javax.swing.JEditorPane();
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
        Edt_Introduccion = new javax.swing.JEditorPane();
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
        Scp_General = new javax.swing.JScrollPane();
        Pnl_ExerciseInfo = new javax.swing.JPanel();
        Edt_General_info = new javax.swing.JEditorPane();
        Pnl_CodigoFull = new javax.swing.JPanel();
        Pnl_SyntaxCode = new javax.swing.JPanel();
        Pnl_SolucionFull = new javax.swing.JPanel();
        Pnl_SyntaxSolution = new javax.swing.JPanel();
        Pnl_Historia = new javax.swing.JPanel();
        Pnl_Pagina1 = new javax.swing.JPanel();
        Lbl_Header_Historia = new javax.swing.JLabel();
        Scp_ContenidoHistoria = new javax.swing.JScrollPane();
        Pnl_ContenidoHistoria = new javax.swing.JPanel();
        Edt_ContenidoHistoria = new javax.swing.JEditorPane();

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
        Btn_Aprender_Tema1.setToolTipText("Hello World");
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
        Btn_Aprender_Tema2.setToolTipText("Comentarios");
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
        Btn_Aprender_Tema3.setToolTipText("Tipos de Datos");
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
        Btn_Aprender_Tema4.setToolTipText("Operadores Aritméticos");
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
        Btn_Aprender_Tema5.setToolTipText("Lectura e Impresión");
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
        Btn_Aprender_Tema6.setToolTipText("Operadores de Relación");
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
        Btn_Aprender_Tema7.setToolTipText("Operadores Lógicos");
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
        Btn_Aprender_Tema8.setToolTipText("Condicionales");
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
        Btn_Aprender_Tema9.setToolTipText("Bucles");
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
        Btn_Aprender_Tema10.setToolTipText("Funciones y Procedimientos");
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
        Btn_Aprender_Tema11.setToolTipText("Recursión");
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
        Btn_Aprender_Tema12.setToolTipText("Estructuras de Datos Básicas");
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
        Btn_Aprender_Tema13.setToolTipText("Estructuras de Datos Intermedias");
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
        Btn_Aprender_Tema14.setToolTipText("Primeros Algoritmos");
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
        Btn_Aprender_Ejercicio1.setToolTipText("Ejercicio 1");
        Btn_Aprender_Ejercicio1.setBorderPainted(false);
        Btn_Aprender_Ejercicio1.setContentAreaFilled(false);
        Btn_Aprender_Ejercicio1.setCursor(sRecursos.getCMano());
        Btn_Aprender_Ejercicio1.setFocusPainted(false);
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
        Btn_Aprender_Ejercicio2.setToolTipText("Ejercicio 2");
        Btn_Aprender_Ejercicio2.setBorderPainted(false);
        Btn_Aprender_Ejercicio2.setContentAreaFilled(false);
        Btn_Aprender_Ejercicio2.setCursor(sRecursos.getCMano());
        Btn_Aprender_Ejercicio2.setFocusPainted(false);
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
        Btn_Aprender_EjercicioFinal.setToolTipText("Ejercicio Final");
        Btn_Aprender_EjercicioFinal.setBorderPainted(false);
        Btn_Aprender_EjercicioFinal.setContentAreaFilled(false);
        Btn_Aprender_EjercicioFinal.setCursor(sRecursos.getCMano());
        Btn_Aprender_EjercicioFinal.setFocusPainted(false);
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
        Pnl_Tema1.setMaximumSize(new java.awt.Dimension(1176, 800));
        Pnl_Tema1.setMinimumSize(new java.awt.Dimension(1176, 800));
        Pnl_Tema1.setPreferredSize(new java.awt.Dimension(1176, 800));
        Pnl_Tema1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_HelloWorld.setFont(sRecursos.getFLabels());
        Lbl_HelloWorld.setText("1. Hello World");
        Lbl_HelloWorld.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_HelloWorld.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_HelloWorld.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_HelloWorld.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema1.add(Lbl_HelloWorld, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt0_1.setContentType("text/html"); // NOI18N
        Edt0_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt0_1.setText("");
        Edt0_1.setOpaque(false);
        Pnl_Tema1.add(Edt0_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 265));

        Pnl_CodesThemes0.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes0.setLayout(new java.awt.CardLayout());
        Pnl_Tema1.add(Pnl_CodesThemes0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 1120, 90));

        Edt0_2.setContentType("text/html"); // NOI18N
        Edt0_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt0_2.setText("");
        Edt0_2.setOpaque(false);
        Pnl_Tema1.add(Edt0_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 1120, 200));

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
        Pnl_Tema1.add(Btn_Siguiente_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 700, 254, 64));

        Scp_Tema1.setViewportView(Pnl_Tema1);

        Pnl_Temas.add(Scp_Tema1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));
        Scp_Tema1.getAccessibleContext().setAccessibleDescription("");

        Scp_Cuestionario1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario1.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario1.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario1.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario1.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario1.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario1.setMaximumSize(new java.awt.Dimension(1176, 860));
        Pnl_Cuestionario1.setMinimumSize(new java.awt.Dimension(1176, 860));
        Pnl_Cuestionario1.setPreferredSize(new java.awt.Dimension(1176, 860));
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
        Pnl_Cuestionario1.add(Btn_Anterior_HelloWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 760, 254, 64));

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
        Pnl_Cuestionario1.add(Btn_Siguiente_Comentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 760, 254, 64));

        Lbl_Cuestionario1.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario1.setText("1. Hello World | Cuestionario");
        Lbl_Cuestionario1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario1.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario1.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario1.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario1.add(Lbl_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question0_1);
        Rad_Question0_1.setOpaque(false);
        Pnl_Cuestionario1.add(Rad_Question0_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 185, -1, -1));

        Bgr_Question1.add(jRadioButton4);
        jRadioButton4.setOpaque(false);
        Pnl_Cuestionario1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, -1, -1));

        Btn_Answer0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer0.setContentAreaFilled(false);
        Btn_Answer0.setFocusPainted(false);
        Btn_Answer0.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer0ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario1.add(Btn_Answer0, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 260, 50));

        Bgr_Question1.add(jRadioButton5);
        jRadioButton5.setOpaque(false);
        Pnl_Cuestionario1.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, -1, -1));

        Bgr_Question1.add(jRadioButton6);
        jRadioButton6.setOpaque(false);
        Pnl_Cuestionario1.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, -1, -1));

        Bgr_Question2.add(Rad_Question0);
        Rad_Question0.setOpaque(false);
        Pnl_Cuestionario1.add(Rad_Question0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        Bgr_Question2.add(Rad_Question0_2);
        Rad_Question0_2.setOpaque(false);
        Pnl_Cuestionario1.add(Rad_Question0_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        Bgr_Question2.add(jRadioButton8);
        jRadioButton8.setOpaque(false);
        Pnl_Cuestionario1.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        Bgr_Question2.add(jRadioButton9);
        jRadioButton9.setOpaque(false);
        Pnl_Cuestionario1.add(jRadioButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        Bgr_Question3.add(Rad_Question01);
        Rad_Question01.setOpaque(false);
        Pnl_Cuestionario1.add(Rad_Question01, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 495, -1, -1));

        Bgr_Question3.add(Rad_Question0_3);
        Rad_Question0_3.setOpaque(false);
        Pnl_Cuestionario1.add(Rad_Question0_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 475, -1, -1));

        Bgr_Question3.add(jRadioButton11);
        jRadioButton11.setOpaque(false);
        Pnl_Cuestionario1.add(jRadioButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 515, -1, -1));

        Bgr_Question3.add(jRadioButton12);
        jRadioButton12.setOpaque(false);
        Pnl_Cuestionario1.add(jRadioButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 455, -1, -1));

        EdtCuestionario1.setContentType("text/html"); // NOI18N
        EdtCuestionario1.setOpaque(false);
        Pnl_Cuestionario1.add(EdtCuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 660, 450));

        Scp_Cuestionario1.setViewportView(Pnl_Cuestionario1);

        Pnl_Temas.add(Scp_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema2.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema2.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema2.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema2.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema2.setCursor(sRecursos.getCDefault());
        Pnl_Tema2.setMaximumSize(new java.awt.Dimension(1176, 1650));
        Pnl_Tema2.setMinimumSize(new java.awt.Dimension(1176, 1650));
        Pnl_Tema2.setPreferredSize(new java.awt.Dimension(1176, 1650));
        Pnl_Tema2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Comentarios.setFont(sRecursos.getFLabels());
        Lbl_Comentarios.setText("2. Comentarios");
        Lbl_Comentarios.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Comentarios.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Comentarios.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Comentarios.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema2.add(Lbl_Comentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt1_1.setContentType("text/html"); // NOI18N
        Edt1_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt1_1.setText("");
        Edt1_1.setOpaque(false);
        Pnl_Tema2.add(Edt1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 370));

        Pnl_CodesThemes1_1.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes1_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema2.add(Pnl_CodesThemes1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 1120, 180));

        Edt1_2.setContentType("text/html"); // NOI18N
        Edt1_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt1_2.setText("");
        Edt1_2.setOpaque(false);
        Pnl_Tema2.add(Edt1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 1120, 170));

        Pnl_CodesThemes1_2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes1_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema2.add(Pnl_CodesThemes1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 790, 1118, 190));

        Edt1_3.setContentType("text/html"); // NOI18N
        Edt1_3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt1_3.setText("");
        Edt1_3.setOpaque(false);
        Pnl_Tema2.add(Edt1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 980, 1120, 170));

        Pnl_CodesThemes1_3.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes1_3.setLayout(new java.awt.CardLayout());
        Pnl_Tema2.add(Pnl_CodesThemes1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1160, 1116, 250));

        Edt1_4.setContentType("text/html"); // NOI18N
        Edt1_4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt1_4.setText("");
        Edt1_4.setOpaque(false);
        Pnl_Tema2.add(Edt1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1410, 1120, 60));

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
        Pnl_Tema2.add(Btn_Anterior_Cuestionario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1550, 254, 64));

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
        Pnl_Tema2.add(Btn_Siguiente_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1550, 254, 64));

        Scp_Tema2.setViewportView(Pnl_Tema2);

        Pnl_Temas.add(Scp_Tema2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario2.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario2.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario2.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario2.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario2.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario2.setMaximumSize(new java.awt.Dimension(1176, 850));
        Pnl_Cuestionario2.setMinimumSize(new java.awt.Dimension(1176, 850));
        Pnl_Cuestionario2.setPreferredSize(new java.awt.Dimension(1176, 850));
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
        Pnl_Cuestionario2.add(Btn_Anterior_Comentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 750, 254, 64));

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
        Pnl_Cuestionario2.add(Btn_Siguiente_TiposdeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 750, 254, 64));

        Lbl_Cuestionario2.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario2.setText("2. Comentarios | Cuestionario");
        Lbl_Cuestionario2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario2.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario2.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario2.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario2.add(Lbl_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question0_4);
        Rad_Question0_4.setOpaque(false);
        Pnl_Cuestionario2.add(Rad_Question0_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 185, -1, -1));

        Bgr_Question1.add(Rad_Question1_1);
        Rad_Question1_1.setOpaque(false);
        Pnl_Cuestionario2.add(Rad_Question1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, -1, -1));

        Btn_Answer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer1.setBorderPainted(false);
        Btn_Answer1.setContentAreaFilled(false);
        Btn_Answer1.setFocusPainted(false);
        Btn_Answer1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer1ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario2.add(Btn_Answer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 260, 50));

        Bgr_Question1.add(jRadioButton10);
        jRadioButton10.setOpaque(false);
        Pnl_Cuestionario2.add(jRadioButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, -1, -1));

        Bgr_Question1.add(jRadioButton13);
        jRadioButton13.setOpaque(false);
        Pnl_Cuestionario2.add(jRadioButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, -1, -1));

        Bgr_Question2.add(Rad_Question1_2);
        Rad_Question1_2.setOpaque(false);
        Pnl_Cuestionario2.add(Rad_Question1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        Bgr_Question2.add(Rad_Question0_5);
        Rad_Question0_5.setOpaque(false);
        Pnl_Cuestionario2.add(Rad_Question0_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        Bgr_Question2.add(jRadioButton15);
        jRadioButton15.setOpaque(false);
        Pnl_Cuestionario2.add(jRadioButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        Bgr_Question3.add(Rad_Question1_3);
        Rad_Question1_3.setOpaque(false);
        Pnl_Cuestionario2.add(Rad_Question1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 475, -1, -1));

        Bgr_Question3.add(jRadioButton17);
        jRadioButton17.setOpaque(false);
        Pnl_Cuestionario2.add(jRadioButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 455, -1, -1));

        Bgr_Question2.add(jRadioButton16);
        jRadioButton16.setOpaque(false);
        Pnl_Cuestionario2.add(jRadioButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        EdtCuestionario2.setContentType("text/html"); // NOI18N
        EdtCuestionario2.setOpaque(false);
        Pnl_Cuestionario2.add(EdtCuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 730, 450));

        Scp_Cuestionario2.setViewportView(Pnl_Cuestionario2);

        Pnl_Temas.add(Scp_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema3.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema3.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema3.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema3.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema3.setCursor(sRecursos.getCDefault());
        Pnl_Tema3.setMaximumSize(new java.awt.Dimension(1176, 1150));
        Pnl_Tema3.setMinimumSize(new java.awt.Dimension(1176, 1150));
        Pnl_Tema3.setPreferredSize(new java.awt.Dimension(1176, 1150));
        Pnl_Tema3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_TiposdeDatos.setFont(sRecursos.getFLabels());
        Lbl_TiposdeDatos.setText("3. Tipos de Datos");
        Lbl_TiposdeDatos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_TiposdeDatos.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_TiposdeDatos.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_TiposdeDatos.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema3.add(Lbl_TiposdeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt2_1.setContentType("text/html"); // NOI18N
        Edt2_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt2_1.setText("");
        Edt2_1.setOpaque(false);
        Pnl_Tema3.add(Edt2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 510));

        Pnl_CodesThemes2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes2.setLayout(new java.awt.CardLayout());
        Pnl_Tema3.add(Pnl_CodesThemes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 1120, 210));

        Edt2_2.setContentType("text/html"); // NOI18N
        Edt2_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt2_2.setText("");
        Edt2_2.setOpaque(false);
        Pnl_Tema3.add(Edt2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 790, 1120, 170));

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
        Pnl_Tema3.add(Btn_Anterior_Cuestionario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1050, 254, 64));

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
        Pnl_Tema3.add(Btn_Siguiente_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1050, 254, 64));

        Scp_Tema3.setViewportView(Pnl_Tema3);

        Pnl_Temas.add(Scp_Tema3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario3.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario3.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario3.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario3.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario3.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario3.setMaximumSize(new java.awt.Dimension(1176, 1000));
        Pnl_Cuestionario3.setMinimumSize(new java.awt.Dimension(1176, 1000));
        Pnl_Cuestionario3.setPreferredSize(new java.awt.Dimension(1176, 1000));
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
        Pnl_Cuestionario3.add(Btn_Anterior_TiposdeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 900, 254, 64));

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
        Pnl_Cuestionario3.add(Btn_Siguiente_OperadoresAritmeticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 900, 254, 64));

        Lbl_Cuestionario3.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario3.setText("3. Tipos de Datos | Cuestionario");
        Lbl_Cuestionario3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario3.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario3.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario3.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario3.add(Lbl_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question0_6);
        Rad_Question0_6.setOpaque(false);
        Pnl_Cuestionario3.add(Rad_Question0_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 185, -1, -1));

        Bgr_Question1.add(Rad_Question1_4);
        Rad_Question1_4.setOpaque(false);
        Pnl_Cuestionario3.add(Rad_Question1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, -1, -1));

        Btn_Answer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer2.setBorderPainted(false);
        Btn_Answer2.setContentAreaFilled(false);
        Btn_Answer2.setFocusPainted(false);
        Btn_Answer2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer2ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario3.add(Btn_Answer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 730, 260, 50));

        Bgr_Question1.add(Rad_Question2_1);
        Rad_Question2_1.setOpaque(false);
        Pnl_Cuestionario3.add(Rad_Question2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, -1, -1));

        Bgr_Question1.add(jRadioButton19);
        jRadioButton19.setOpaque(false);
        Pnl_Cuestionario3.add(jRadioButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, -1, -1));

        Bgr_Question2.add(Rad_Question1_5);
        Rad_Question1_5.setOpaque(false);
        Pnl_Cuestionario3.add(Rad_Question1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 465, -1, -1));

        Bgr_Question2.add(Rad_Question2_2);
        Rad_Question2_2.setOpaque(false);
        Pnl_Cuestionario3.add(Rad_Question2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 445, -1, -1));

        Bgr_Question2.add(jRadioButton20);
        jRadioButton20.setOpaque(false);
        Pnl_Cuestionario3.add(jRadioButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 485, -1, -1));

        Bgr_Question2.add(jRadioButton21);
        jRadioButton21.setOpaque(false);
        Pnl_Cuestionario3.add(jRadioButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 425, -1, -1));

        Bgr_Question3.add(Rad_Question3);
        Rad_Question3.setOpaque(false);
        Pnl_Cuestionario3.add(Rad_Question3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));

        Bgr_Question3.add(Rad_Question1_6);
        Rad_Question1_6.setOpaque(false);
        Pnl_Cuestionario3.add(Rad_Question1_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, -1, -1));

        Bgr_Question3.add(jRadioButton22);
        jRadioButton22.setOpaque(false);
        Pnl_Cuestionario3.add(jRadioButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, -1, -1));

        Bgr_Question3.add(Rad_Question2_3);
        Rad_Question2_3.setOpaque(false);
        Pnl_Cuestionario3.add(Rad_Question2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        EdtCuestionario3.setContentType("text/html"); // NOI18N
        EdtCuestionario3.setOpaque(false);
        Pnl_Cuestionario3.add(EdtCuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 800, 580));

        Scp_Cuestionario3.setViewportView(Pnl_Cuestionario3);

        Pnl_Temas.add(Scp_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema4.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema4.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema4.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema4.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema4.setCursor(sRecursos.getCDefault());
        Pnl_Tema4.setMaximumSize(new java.awt.Dimension(1176, 4250));
        Pnl_Tema4.setMinimumSize(new java.awt.Dimension(1176, 4250));
        Pnl_Tema4.setPreferredSize(new java.awt.Dimension(1176, 4250));
        Pnl_Tema4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_OperadoresAritmeticos.setFont(sRecursos.getFLabels());
        Lbl_OperadoresAritmeticos.setText("4. Operadores Aritméticos");
        Lbl_OperadoresAritmeticos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_OperadoresAritmeticos.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_OperadoresAritmeticos.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_OperadoresAritmeticos.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema4.add(Lbl_OperadoresAritmeticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt3_1.setContentType("text/html"); // NOI18N
        Edt3_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt3_1.setText("");
        Edt3_1.setOpaque(false);
        Pnl_Tema4.add(Edt3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 280));

        Pnl_CodesThemes3_1.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes3_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema4.add(Pnl_CodesThemes3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 1110, 330));

        Edt3_2.setContentType("text/html"); // NOI18N
        Edt3_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt3_2.setText("");
        Edt3_2.setOpaque(false);
        Pnl_Tema4.add(Edt3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 1120, 280));

        Pnl_CodesThemes3_2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes3_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema4.add(Pnl_CodesThemes3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 970, 1110, 220));

        Edt3_3.setContentType("text/html"); // NOI18N
        Edt3_3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt3_3.setText("");
        Edt3_3.setOpaque(false);
        Pnl_Tema4.add(Edt3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1200, 1120, 160));

        Spr_Acumuladores.setForeground(sRecursos.getColorVerde());
        Spr_Acumuladores.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema4.add(Spr_Acumuladores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1390, 1120, -1));

        Lbl_Acumuladores.setFont(sRecursos.getFTitleEditor());
        Lbl_Acumuladores.setText("Acumuladores");
        Lbl_Acumuladores.setFocusable(false);
        Pnl_Tema4.add(Lbl_Acumuladores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1420, 220, -1));

        Edt3_4.setContentType("text/html"); // NOI18N
        Edt3_4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt3_4.setText("");
        Edt3_4.setOpaque(false);
        Pnl_Tema4.add(Edt3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1450, 1120, 530));

        Pnl_CodesThemes3_3.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes3_3.setLayout(new java.awt.CardLayout());
        Pnl_Tema4.add(Pnl_CodesThemes3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1990, 1110, 320));

        Edt3_5.setContentType("text/html"); // NOI18N
        Edt3_5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt3_5.setText("");
        Edt3_5.setOpaque(false);
        Pnl_Tema4.add(Edt3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2320, 1120, 180));

        Pnl_CodesThemes3_4.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes3_4.setLayout(new java.awt.CardLayout());
        Pnl_Tema4.add(Pnl_CodesThemes3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2510, 1110, 310));

        Edt3_6.setContentType("text/html"); // NOI18N
        Edt3_6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt3_6.setText("");
        Edt3_6.setOpaque(false);
        Pnl_Tema4.add(Edt3_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2830, 1120, 200));

        Spr_OperadoresIncDec.setForeground(sRecursos.getColorVerde());
        Spr_OperadoresIncDec.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema4.add(Spr_OperadoresIncDec, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3070, 1120, -1));

        Lbl_OperadorIncDec.setFont(sRecursos.getFTitleEditor());
        Lbl_OperadorIncDec.setText("Operadores de Incremento y Decremento");
        Pnl_Tema4.add(Lbl_OperadorIncDec, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3110, -1, -1));

        Edt3_7.setContentType("text/html"); // NOI18N
        Edt3_7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt3_7.setText("");
        Edt3_7.setOpaque(false);
        Pnl_Tema4.add(Edt3_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3150, 1120, 700));

        Pnl_CodesThemes3_5.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes3_5.setLayout(new java.awt.CardLayout());
        Pnl_Tema4.add(Pnl_CodesThemes3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3860, 1110, 160));

        Edt3_8.setContentType("text/html"); // NOI18N
        Edt3_8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt3_8.setText("");
        Edt3_8.setOpaque(false);
        Pnl_Tema4.add(Edt3_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4030, 1120, 60));

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
        Pnl_Tema4.add(Btn_Anterior_Cuestionario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 4150, 254, 64));

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
        Pnl_Tema4.add(Btn_Siguiente_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 4150, 254, 64));

        Scp_Tema4.setViewportView(Pnl_Tema4);

        Pnl_Temas.add(Scp_Tema4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario4.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario4.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario4.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario4.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario4.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario4.setMaximumSize(new java.awt.Dimension(1176, 860));
        Pnl_Cuestionario4.setMinimumSize(new java.awt.Dimension(1176, 860));
        Pnl_Cuestionario4.setPreferredSize(new java.awt.Dimension(1176, 860));
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
        Pnl_Cuestionario4.add(Btn_Anterior_OperadoresAritmeticos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 760, 254, 64));

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
        Pnl_Cuestionario4.add(Btn_Siguiente_LecturaeImpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 760, 254, 64));

        Lbl_Cuestionario4.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario4.setText("4. Operadores Aritméticos | Cuestionario");
        Lbl_Cuestionario4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario4.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario4.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario4.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario4.add(Lbl_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question3_1);
        Rad_Question3_1.setOpaque(false);
        Pnl_Cuestionario4.add(Rad_Question3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 185, -1, -1));

        Bgr_Question1.add(Rad_Question1_7);
        Rad_Question1_7.setOpaque(false);
        Pnl_Cuestionario4.add(Rad_Question1_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, -1, -1));

        Btn_Answer3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer3.setBorderPainted(false);
        Btn_Answer3.setContentAreaFilled(false);
        Btn_Answer3.setFocusPainted(false);
        Btn_Answer3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer3ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario4.add(Btn_Answer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 260, 50));

        Bgr_Question1.add(Rad_Question2_4);
        Rad_Question2_4.setOpaque(false);
        Pnl_Cuestionario4.add(Rad_Question2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 205, -1, -1));

        Bgr_Question1.add(jRadioButton23);
        jRadioButton23.setOpaque(false);
        Pnl_Cuestionario4.add(jRadioButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, -1, -1));

        Bgr_Question2.add(Rad_Question1_8);
        Rad_Question1_8.setOpaque(false);
        Pnl_Cuestionario4.add(Rad_Question1_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        Bgr_Question2.add(Rad_Question2_5);
        Rad_Question2_5.setOpaque(false);
        Pnl_Cuestionario4.add(Rad_Question2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        Bgr_Question2.add(Rad_Question3_2);
        Rad_Question3_2.setOpaque(false);
        Pnl_Cuestionario4.add(Rad_Question3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        Bgr_Question2.add(jRadioButton25);
        jRadioButton25.setOpaque(false);
        Pnl_Cuestionario4.add(jRadioButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        Bgr_Question3.add(Rad_Question4);
        Rad_Question4.setOpaque(false);
        Pnl_Cuestionario4.add(Rad_Question4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 495, -1, -1));

        Bgr_Question3.add(Rad_Question1_9);
        Rad_Question1_9.setOpaque(false);
        Pnl_Cuestionario4.add(Rad_Question1_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 475, -1, -1));

        Bgr_Question3.add(jRadioButton26);
        jRadioButton26.setOpaque(false);
        Pnl_Cuestionario4.add(jRadioButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 515, -1, -1));

        Bgr_Question3.add(Rad_Question3_3);
        Rad_Question3_3.setOpaque(false);
        Pnl_Cuestionario4.add(Rad_Question3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 455, -1, -1));

        EdtCuestionario4.setContentType("text/html"); // NOI18N
        EdtCuestionario4.setOpaque(false);
        Pnl_Cuestionario4.add(EdtCuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 800, 460));

        Scp_Cuestionario4.setViewportView(Pnl_Cuestionario4);

        Pnl_Temas.add(Scp_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema5.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema5.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema5.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema5.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema5.setCursor(sRecursos.getCDefault());
        Pnl_Tema5.setMaximumSize(new java.awt.Dimension(1176, 1250));
        Pnl_Tema5.setMinimumSize(new java.awt.Dimension(1176, 1250));
        Pnl_Tema5.setPreferredSize(new java.awt.Dimension(1176, 1250));
        Pnl_Tema5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_LecturaeImpresion.setFont(sRecursos.getFLabels());
        Lbl_LecturaeImpresion.setText("5. Lectura e Impresión");
        Lbl_LecturaeImpresion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_LecturaeImpresion.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_LecturaeImpresion.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_LecturaeImpresion.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema5.add(Lbl_LecturaeImpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt4_1.setContentType("text/html"); // NOI18N
        Edt4_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt4_1.setText("");
        Edt4_1.setOpaque(false);
        Pnl_Tema5.add(Edt4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 180));

        Pnl_CodesThemes4.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes4.setLayout(new java.awt.CardLayout());
        Pnl_Tema5.add(Pnl_CodesThemes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 1120, 450));

        Edt4_2.setContentType("text/html"); // NOI18N
        Edt4_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt4_2.setText("");
        Edt4_2.setOpaque(false);
        Pnl_Tema5.add(Edt4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 1120, 350));

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
        Pnl_Tema5.add(Btn_Anterior_Cuestionario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1150, 254, 64));

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
        Pnl_Tema5.add(Btn_Siguiente_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1150, 254, 64));

        Scp_Tema5.setViewportView(Pnl_Tema5);

        Pnl_Temas.add(Scp_Tema5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario5.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario5.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario5.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario5.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario5.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario5.setMaximumSize(new java.awt.Dimension(1176, 930));
        Pnl_Cuestionario5.setMinimumSize(new java.awt.Dimension(1176, 930));
        Pnl_Cuestionario5.setPreferredSize(new java.awt.Dimension(1176, 930));
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
        Pnl_Cuestionario5.add(Btn_Anterior_LecturaeImpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 830, 254, 64));

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
        Pnl_Cuestionario5.add(Btn_Siguiente_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 830, 254, 64));

        Lbl_Cuestionario5.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario5.setText("5. Lectura e Impresión | Cuestionario");
        Lbl_Cuestionario5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario5.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario5.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario5.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario5.add(Lbl_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question4_1_1);
        Rad_Question4_1_1.setOpaque(false);
        Pnl_Cuestionario5.add(Rad_Question4_1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        Bgr_Question1.add(Rad_Question1_10);
        Rad_Question1_10.setOpaque(false);
        Pnl_Cuestionario5.add(Rad_Question1_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        Btn_Answer4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer4.setBorderPainted(false);
        Btn_Answer4.setContentAreaFilled(false);
        Btn_Answer4.setFocusPainted(false);
        Btn_Answer4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer4ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario5.add(Btn_Answer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 260, 50));

        Bgr_Question1.add(Rad_Question2_6);
        Rad_Question2_6.setOpaque(false);
        Pnl_Cuestionario5.add(Rad_Question2_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        Bgr_Question1.add(Rad_Question4_1);
        Rad_Question4_1.setOpaque(false);
        Pnl_Cuestionario5.add(Rad_Question4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        Bgr_Question2.add(Rad_Question4_2);
        Rad_Question4_2.setOpaque(false);
        Pnl_Cuestionario5.add(Rad_Question4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 363, -1, -1));

        Bgr_Question3.add(Rad_Question4_3);
        Rad_Question4_3.setOpaque(false);
        Pnl_Cuestionario5.add(Rad_Question4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        Bgr_Question2.add(Rad_Question1_20);
        Rad_Question1_20.setOpaque(false);
        Pnl_Cuestionario5.add(Rad_Question1_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 383, -1, -1));

        Bgr_Question2.add(Rad_Question3_7);
        Rad_Question3_7.setOpaque(false);
        Pnl_Cuestionario5.add(Rad_Question3_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 403, -1, -1));

        Bgr_Question2.add(Rad_Question4_00);
        Rad_Question4_00.setOpaque(false);
        Pnl_Cuestionario5.add(Rad_Question4_00, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 343, -1, -1));

        Bgr_Question3.add(Rad_Question4_7);
        Rad_Question4_7.setOpaque(false);
        Pnl_Cuestionario5.add(Rad_Question4_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        Bgr_Question3.add(jRadioButton35);
        jRadioButton35.setOpaque(false);
        Pnl_Cuestionario5.add(jRadioButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        Bgr_Question3.add(Rad_Question3_13);
        Rad_Question3_13.setOpaque(false);
        Pnl_Cuestionario5.add(Rad_Question3_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        EdtCuestionario5.setContentType("text/html"); // NOI18N
        EdtCuestionario5.setOpaque(false);
        Pnl_Cuestionario5.add(EdtCuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 850, 500));

        Scp_Cuestionario5.setViewportView(Pnl_Cuestionario5);

        Pnl_Temas.add(Scp_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Ejercicio1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Ejercicio1.setMaximumSize(sRecursos.getDTamanio());
        Scp_Ejercicio1.setMinimumSize(sRecursos.getDTamanio());
        Scp_Ejercicio1.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Ejercicio1_Aprender.setBackground(sRecursos.getCPrincipal());
        Pnl_Ejercicio1_Aprender.setCursor(sRecursos.getCDefault());
        Pnl_Ejercicio1_Aprender.setMaximumSize(new java.awt.Dimension(1176, 1300));
        Pnl_Ejercicio1_Aprender.setMinimumSize(new java.awt.Dimension(1176, 1300));
        Pnl_Ejercicio1_Aprender.setPreferredSize(new java.awt.Dimension(1176, 1300));
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
        Pnl_Ejercicio1_Aprender.add(Btn_Anterior_Cuestionario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1200, 254, 64));

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
        Pnl_Ejercicio1_Aprender.add(Btn_Siguiente_OperadoresdeRelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1200, 254, 64));

        Lbl_Ejercicio1_Principiante.setFont(sRecursos.getFLabels());
        Lbl_Ejercicio1_Principiante.setText("Ejercicio 1 | Principiante");
        Lbl_Ejercicio1_Principiante.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Ejercicio1_Principiante.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Ejercicio1_Principiante.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Ejercicio1_Principiante.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Ejercicio1_Aprender.add(Lbl_Ejercicio1_Principiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

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
        Pnl_Ejercicio1_Aprender.add(Btn_EnviarEjercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 750, 170, 50));

        Pnl_SyntaxEjercicio1.setBackground(new java.awt.Color(204, 204, 204));
        Pnl_SyntaxEjercicio1.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_SyntaxEjercicio1.setLayout(new java.awt.CardLayout());
        Pnl_Ejercicio1_Aprender.add(Pnl_SyntaxEjercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 810, 1080, 330));

        Edt_Ejercicio1.setBackground(sRecursos.getCPrincipal());
        Edt_Ejercicio1.setContentType("text/html"); // NOI18N
        Edt_Ejercicio1.setOpaque(false);
        Pnl_Ejercicio1_Aprender.add(Edt_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1120, 610));

        Scp_Ejercicio1.setViewportView(Pnl_Ejercicio1_Aprender);

        Pnl_Temas.add(Scp_Ejercicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema6.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema6.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema6.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema6.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema6.setCursor(sRecursos.getCDefault());
        Pnl_Tema6.setMaximumSize(new java.awt.Dimension(1176, 1500));
        Pnl_Tema6.setMinimumSize(new java.awt.Dimension(1176, 1500));
        Pnl_Tema6.setPreferredSize(new java.awt.Dimension(1176, 1500));
        Pnl_Tema6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_OperadoresdeRelacion.setFont(sRecursos.getFLabels());
        Lbl_OperadoresdeRelacion.setText("6. Operadores de Relación");
        Lbl_OperadoresdeRelacion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_OperadoresdeRelacion.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_OperadoresdeRelacion.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_OperadoresdeRelacion.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema6.add(Lbl_OperadoresdeRelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt5_1.setContentType("text/html"); // NOI18N
        Edt5_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt5_1.setText("");
        Edt5_1.setOpaque(false);
        Pnl_Tema6.add(Edt5_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 240));

        Lbl_TablaOperadoresRelacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Lbl_TablaOperadoresRelacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Learning_Images/Operadores_Relacion.png"))); // NOI18N
        Pnl_Tema6.add(Lbl_TablaOperadoresRelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 1130, 320));

        Edt5_2.setContentType("text/html"); // NOI18N
        Edt5_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt5_2.setText("");
        Edt5_2.setOpaque(false);
        Pnl_Tema6.add(Edt5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 1120, 140));

        Pnl_CodesThemes5.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes5.setLayout(new java.awt.CardLayout());
        Pnl_Tema6.add(Pnl_CodesThemes5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 780, 1120, 260));

        Edt5_3.setContentType("text/html"); // NOI18N
        Edt5_3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt5_3.setText("");
        Edt5_3.setOpaque(false);
        Pnl_Tema6.add(Edt5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1050, 1120, 270));

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
        Pnl_Tema6.add(Btn_Anterior_Ejercicio1_Principiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1400, 254, 64));

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
        Pnl_Tema6.add(Btn_Siguiente_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1400, 254, 64));

        Scp_Tema6.setViewportView(Pnl_Tema6);

        Pnl_Temas.add(Scp_Tema6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario6.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario6.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario6.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario6.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario6.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario6.setMaximumSize(new java.awt.Dimension(1176, 1100));
        Pnl_Cuestionario6.setMinimumSize(new java.awt.Dimension(1176, 1100));
        Pnl_Cuestionario6.setPreferredSize(new java.awt.Dimension(1176, 1100));
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
        Pnl_Cuestionario6.add(Btn_Anterior_OperadoresdeRelacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1000, 254, 64));

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
        Pnl_Cuestionario6.add(Btn_Siguiente_OperadoresLogicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1000, 254, 64));

        Lbl_Cuestionario6.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario6.setText("6. Operadores de Relación | Cuestionario");
        Lbl_Cuestionario6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario6.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario6.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario6.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario6.add(Lbl_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question5_1_0);
        Rad_Question5_1_0.setOpaque(false);
        Pnl_Cuestionario6.add(Rad_Question5_1_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 435, -1, -1));

        Bgr_Question1.add(Rad_Question1_12);
        Rad_Question1_12.setOpaque(false);
        Pnl_Cuestionario6.add(Rad_Question1_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 415, -1, -1));

        Btn_Answer5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer5.setBorderPainted(false);
        Btn_Answer5.setContentAreaFilled(false);
        Btn_Answer5.setFocusPainted(false);
        Btn_Answer5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer5ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario6.add(Btn_Answer5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 830, 260, 50));

        Bgr_Question1.add(Rad_Question2_8);
        Rad_Question2_8.setOpaque(false);
        Pnl_Cuestionario6.add(Rad_Question2_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 455, -1, -1));

        Bgr_Question1.add(Rad_Question5_1);
        Rad_Question5_1.setOpaque(false);
        Pnl_Cuestionario6.add(Rad_Question5_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 395, -1, -1));

        Bgr_Question2.add(Rad_Question2_9);
        Rad_Question2_9.setOpaque(false);
        Pnl_Cuestionario6.add(Rad_Question2_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 572, -1, -1));

        Bgr_Question2.add(Rad_Question5_2);
        Rad_Question5_2.setOpaque(false);
        Pnl_Cuestionario6.add(Rad_Question5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 552, -1, -1));

        Bgr_Question3.add(Rad_Question5_3);
        Rad_Question5_3.setOpaque(false);
        Pnl_Cuestionario6.add(Rad_Question5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 708, -1, -1));

        Bgr_Question3.add(Rad_Question4_6);
        Rad_Question4_6.setOpaque(false);
        Pnl_Cuestionario6.add(Rad_Question4_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 688, -1, -1));

        Bgr_Question3.add(jRadioButton29);
        jRadioButton29.setOpaque(false);
        Pnl_Cuestionario6.add(jRadioButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 728, -1, -1));

        Bgr_Question3.add(Rad_Question3_8);
        Rad_Question3_8.setOpaque(false);
        Pnl_Cuestionario6.add(Rad_Question3_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 668, -1, -1));

        EdtCuestionario6.setContentType("text/html"); // NOI18N
        EdtCuestionario6.setOpaque(false);
        Pnl_Cuestionario6.add(EdtCuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 800, 660));

        Scp_Cuestionario6.setViewportView(Pnl_Cuestionario6);

        Pnl_Temas.add(Scp_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema7.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema7.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema7.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema7.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema7.setCursor(sRecursos.getCDefault());
        Pnl_Tema7.setMaximumSize(new java.awt.Dimension(1176, 1400));
        Pnl_Tema7.setMinimumSize(new java.awt.Dimension(1176, 1400));
        Pnl_Tema7.setPreferredSize(new java.awt.Dimension(1176, 1400));
        Pnl_Tema7.setRequestFocusEnabled(false);
        Pnl_Tema7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_OperadoresLogicos.setFont(sRecursos.getFLabels());
        Lbl_OperadoresLogicos.setText("7. Operadores Lógicos");
        Lbl_OperadoresLogicos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_OperadoresLogicos.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_OperadoresLogicos.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_OperadoresLogicos.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema7.add(Lbl_OperadoresLogicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt6_1.setContentType("text/html"); // NOI18N
        Edt6_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt6_1.setText("");
        Edt6_1.setOpaque(false);
        Pnl_Tema7.add(Edt6_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 160));

        Lbl_TablaOperadoresLogicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Learning_Images/Operadores_Logicos.png"))); // NOI18N
        Pnl_Tema7.add(Lbl_TablaOperadoresLogicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 1130, 290));

        Edt6_2.setContentType("text/html"); // NOI18N
        Edt6_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt6_2.setText("");
        Edt6_2.setOpaque(false);
        Pnl_Tema7.add(Edt6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 1120, 170));

        Pnl_CodesThemes6.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes6.setLayout(new java.awt.CardLayout());
        Pnl_Tema7.add(Pnl_CodesThemes6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 1120, 260));

        Edt6_3.setContentType("text/html"); // NOI18N
        Edt6_3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt6_3.setText("");
        Edt6_3.setOpaque(false);
        Pnl_Tema7.add(Edt6_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 970, 1120, 220));

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
        Pnl_Tema7.add(Btn_Anterior_Cuestionario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1300, 254, 64));

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
        Pnl_Tema7.add(Btn_Siguiente_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1300, 254, 64));

        Scp_Tema7.setViewportView(Pnl_Tema7);

        Pnl_Temas.add(Scp_Tema7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario7.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario7.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario7.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario7.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario7.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario7.setMaximumSize(new java.awt.Dimension(1176, 1050));
        Pnl_Cuestionario7.setMinimumSize(new java.awt.Dimension(1176, 1050));
        Pnl_Cuestionario7.setPreferredSize(new java.awt.Dimension(1176, 1050));
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
        Pnl_Cuestionario7.add(Btn_Anterior_OperadoresLogicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 950, 254, 64));

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
        Pnl_Cuestionario7.add(Btn_Siguiente_Condicionales, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 950, 254, 64));

        Lbl_Cuestionario7.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario7.setText("7. Operadores Lógicos | Cuestionario");
        Lbl_Cuestionario7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario7.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario7.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario7.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario7.add(Lbl_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question5_4);
        Rad_Question5_4.setOpaque(false);
        Pnl_Cuestionario7.add(Rad_Question5_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        Bgr_Question1.add(Rad_Question6_1);
        Rad_Question6_1.setOpaque(false);
        Pnl_Cuestionario7.add(Rad_Question6_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        Btn_Answer6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer6.setBorderPainted(false);
        Btn_Answer6.setContentAreaFilled(false);
        Btn_Answer6.setFocusPainted(false);
        Btn_Answer6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer6ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario7.add(Btn_Answer6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 790, 260, 50));

        Bgr_Question1.add(Rad_Question2_10);
        Rad_Question2_10.setOpaque(false);
        Pnl_Cuestionario7.add(Rad_Question2_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        Bgr_Question1.add(Rad_Question6_1_0);
        Rad_Question6_1_0.setOpaque(false);
        Pnl_Cuestionario7.add(Rad_Question6_1_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        Bgr_Question2.add(Rad_Question1_15);
        Rad_Question1_15.setOpaque(false);
        Pnl_Cuestionario7.add(Rad_Question1_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 508, -1, -1));

        Bgr_Question2.add(Rad_Question2_11);
        Rad_Question2_11.setOpaque(false);
        Pnl_Cuestionario7.add(Rad_Question2_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 488, -1, -1));

        Bgr_Question2.add(Rad_Question5_5);
        Rad_Question5_5.setOpaque(false);
        Pnl_Cuestionario7.add(Rad_Question5_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 528, -1, -1));

        Bgr_Question2.add(Rad_Question6_2);
        Rad_Question6_2.setOpaque(false);
        Pnl_Cuestionario7.add(Rad_Question6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 468, -1, -1));

        Bgr_Question3.add(Rad_Question6_3);
        Rad_Question6_3.setOpaque(false);
        Pnl_Cuestionario7.add(Rad_Question6_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 662, -1, -1));

        Bgr_Question3.add(Rad_Question4_8);
        Rad_Question4_8.setOpaque(false);
        Pnl_Cuestionario7.add(Rad_Question4_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 642, -1, -1));

        Bgr_Question3.add(jRadioButton31);
        jRadioButton31.setOpaque(false);
        Pnl_Cuestionario7.add(jRadioButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 682, -1, -1));

        Bgr_Question3.add(Rad_Question3_9);
        Rad_Question3_9.setOpaque(false);
        Pnl_Cuestionario7.add(Rad_Question3_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 622, -1, -1));

        EdtCuestionario7.setContentType("text/html"); // NOI18N
        EdtCuestionario7.setOpaque(false);
        Pnl_Cuestionario7.add(EdtCuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 800, 620));

        Scp_Cuestionario7.setViewportView(Pnl_Cuestionario7);

        Pnl_Temas.add(Scp_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema8.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema8.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema8.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema8.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema8.setCursor(sRecursos.getCDefault());
        Pnl_Tema8.setMaximumSize(new java.awt.Dimension(1176, 5650));
        Pnl_Tema8.setMinimumSize(new java.awt.Dimension(1176, 5650));
        Pnl_Tema8.setPreferredSize(new java.awt.Dimension(1176, 5650));
        Pnl_Tema8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Condicionales.setFont(sRecursos.getFLabels());
        Lbl_Condicionales.setText("8. Condicionales");
        Lbl_Condicionales.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Condicionales.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Condicionales.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Condicionales.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema8.add(Lbl_Condicionales, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt7_1.setContentType("text/html"); // NOI18N
        Edt7_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt7_1.setText("");
        Edt7_1.setOpaque(false);
        Pnl_Tema8.add(Edt7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 470));

        Pnl_CodesThemes7_1.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes7_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 1120, 260));

        Edt7_2.setContentType("text/html"); // NOI18N
        Edt7_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt7_2.setText("");
        Edt7_2.setOpaque(false);
        Pnl_Tema8.add(Edt7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 800, 1120, 220));

        Pnl_CodesThemes7_2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes7_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1030, 1120, 350));

        Edt7_3.setContentType("text/html"); // NOI18N
        Edt7_3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt7_3.setText("");
        Edt7_3.setOpaque(false);
        Pnl_Tema8.add(Edt7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1390, 1120, 280));

        Spr_CondicionalesAnidados.setForeground(sRecursos.getColorVerde());
        Spr_CondicionalesAnidados.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema8.add(Spr_CondicionalesAnidados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1700, 1120, -1));

        Lbl_CondicionalesAnidados.setFont(sRecursos.getFTitleEditor());
        Lbl_CondicionalesAnidados.setForeground(sRecursos.getColorVerde());
        Lbl_CondicionalesAnidados.setText("Condicionales Anidados");
        Pnl_Tema8.add(Lbl_CondicionalesAnidados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1730, 300, 20));

        Lbl_Sintaxis8_7.setFont(sRecursos.getFTitles());
        Lbl_Sintaxis8_7.setText("Sintaxis");
        Pnl_Tema8.add(Lbl_Sintaxis8_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1770, -1, 20));

        Pnl_CodesThemes7_3.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes7_3.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1800, 1120, 180));

        Lbl_SampleCode8_10.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_10.setText("Código de Ejemplo");
        Pnl_Tema8.add(Lbl_SampleCode8_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1990, -1, 20));

        Pnl_CodesThemes7_4.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes7_4.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2020, 1118, 300));

        Edt7_4.setContentType("text/html"); // NOI18N
        Edt7_4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt7_4.setText("");
        Edt7_4.setOpaque(false);
        Pnl_Tema8.add(Edt7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2330, 1120, 90));

        Spr_TryCatch.setForeground(sRecursos.getColorVerde());
        Spr_TryCatch.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema8.add(Spr_TryCatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2450, 1120, -1));

        Lbl_TryCatch.setFont(sRecursos.getFTitleEditor());
        Lbl_TryCatch.setForeground(sRecursos.getColorVerde());
        Lbl_TryCatch.setText("Try-Catch");
        Pnl_Tema8.add(Lbl_TryCatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2480, 120, 20));

        Edt7_5.setContentType("text/html"); // NOI18N
        Edt7_5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt7_5.setText("");
        Edt7_5.setOpaque(false);
        Pnl_Tema8.add(Edt7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2520, 1120, 240));

        Pnl_CodesThemes7_9.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes7_9.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2770, 1118, 240));

        Lbl_SampleCode8_8.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_8.setText("Código de Ejemplo");
        Pnl_Tema8.add(Lbl_SampleCode8_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3020, -1, 20));

        Pnl_CodesThemes7_5.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes7_5.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3050, 1118, 280));

        Edt7_6.setContentType("text/html"); // NOI18N
        Edt7_6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt7_6.setText("");
        Edt7_6.setOpaque(false);
        Pnl_Tema8.add(Edt7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3340, 1120, 240));

        Pnl_CodesThemes7_6.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes7_6.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3590, 1118, 190));

        Edt7_7.setContentType("text/html"); // NOI18N
        Edt7_7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt7_7.setText("");
        Edt7_7.setOpaque(false);
        Pnl_Tema8.add(Edt7_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3790, 1120, 170));

        Pnl_CodesThemes7_7.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes7_7.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3970, 1118, 230));

        Edt7_8.setContentType("text/html"); // NOI18N
        Edt7_8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt7_8.setText("");
        Edt7_8.setOpaque(false);
        Pnl_Tema8.add(Edt7_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4210, 1120, 80));

        Spr_SwitchCase.setForeground(sRecursos.getColorVerde());
        Spr_SwitchCase.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema8.add(Spr_SwitchCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4320, 1120, -1));

        Lbl_SwitchCase.setFont(sRecursos.getFTitleEditor());
        Lbl_SwitchCase.setForeground(sRecursos.getColorVerde());
        Lbl_SwitchCase.setText("Switch Case");
        Pnl_Tema8.add(Lbl_SwitchCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4350, 160, 20));

        Edt7_9.setContentType("text/html"); // NOI18N
        Edt7_9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt7_9.setText("");
        Edt7_9.setOpaque(false);
        Pnl_Tema8.add(Edt7_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4390, 1120, 210));

        Pnl_CodesThemes7_10.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes7_10.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4610, 1118, 320));

        Lbl_SampleCode8_5.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_5.setText("Código de Ejemplo");
        Pnl_Tema8.add(Lbl_SampleCode8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4940, -1, 20));

        Pnl_CodesThemes7_8.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes7_8.setLayout(new java.awt.CardLayout());
        Pnl_Tema8.add(Pnl_CodesThemes7_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4970, 1118, 380));

        Edt7_10.setContentType("text/html"); // NOI18N
        Edt7_10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt7_10.setText("");
        Edt7_10.setOpaque(false);
        Pnl_Tema8.add(Edt7_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5360, 1120, 80));

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
        Pnl_Tema8.add(Btn_Anterior_Cuestionario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5550, 254, 64));

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
        Pnl_Tema8.add(Btn_Siguiente_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 5550, 254, 64));

        Scp_Tema8.setViewportView(Pnl_Tema8);

        Pnl_Temas.add(Scp_Tema8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario8.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario8.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario8.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario8.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario8.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario8.setMaximumSize(new java.awt.Dimension(1176, 930));
        Pnl_Cuestionario8.setMinimumSize(new java.awt.Dimension(1176, 930));
        Pnl_Cuestionario8.setPreferredSize(new java.awt.Dimension(1176, 930));
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
        Pnl_Cuestionario8.add(Btn_Anterior_Condicionales, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 830, 254, 64));

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
        Pnl_Cuestionario8.add(Btn_Siguiente_Bucles, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 830, 254, 64));

        Lbl_Cuestionario8.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario8.setText("8. Condicionales | Cuestionario");
        Lbl_Cuestionario8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario8.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario8.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario8.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario8.add(Lbl_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question5_6);
        Rad_Question5_6.setOpaque(false);
        Pnl_Cuestionario8.add(Rad_Question5_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 183, -1, -1));

        Bgr_Question1.add(Rad_Question7_1_0);
        Rad_Question7_1_0.setOpaque(false);
        Pnl_Cuestionario8.add(Rad_Question7_1_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 163, -1, -1));

        Btn_Answer7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer7.setBorderPainted(false);
        Btn_Answer7.setContentAreaFilled(false);
        Btn_Answer7.setFocusPainted(false);
        Btn_Answer7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer7ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario8.add(Btn_Answer7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 680, 260, 50));

        Bgr_Question1.add(Rad_Question2_12);
        Rad_Question2_12.setOpaque(false);
        Pnl_Cuestionario8.add(Rad_Question2_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 203, -1, -1));

        Bgr_Question1.add(Rad_Question7_1);
        Rad_Question7_1.setOpaque(false);
        Pnl_Cuestionario8.add(Rad_Question7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 143, -1, -1));

        Bgr_Question2.add(Rad_Question1_17);
        Rad_Question1_17.setOpaque(false);
        Pnl_Cuestionario8.add(Rad_Question1_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        Bgr_Question2.add(Rad_Question7_2);
        Rad_Question7_2.setOpaque(false);
        Pnl_Cuestionario8.add(Rad_Question7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        Bgr_Question2.add(Rad_Question5_7);
        Rad_Question5_7.setOpaque(false);
        Pnl_Cuestionario8.add(Rad_Question5_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        Bgr_Question2.add(Rad_Question7_2_0);
        Rad_Question7_2_0.setOpaque(false);
        Pnl_Cuestionario8.add(Rad_Question7_2_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        Bgr_Question3.add(Rad_Question7_3);
        Rad_Question7_3.setOpaque(false);
        Pnl_Cuestionario8.add(Rad_Question7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        Bgr_Question3.add(Rad_Question4_9);
        Rad_Question4_9.setOpaque(false);
        Pnl_Cuestionario8.add(Rad_Question4_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, -1, -1));

        Bgr_Question3.add(jRadioButton32);
        jRadioButton32.setOpaque(false);
        Pnl_Cuestionario8.add(jRadioButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        Bgr_Question3.add(Rad_Question3_10);
        Rad_Question3_10.setOpaque(false);
        Pnl_Cuestionario8.add(Rad_Question3_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        EdtCuestionario8.setContentType("text/html"); // NOI18N
        EdtCuestionario8.setOpaque(false);
        Pnl_Cuestionario8.add(EdtCuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 800, 520));

        Scp_Cuestionario8.setViewportView(Pnl_Cuestionario8);

        Pnl_Temas.add(Scp_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema9.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema9.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema9.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema9.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema9.setCursor(sRecursos.getCDefault());
        Pnl_Tema9.setMaximumSize(new java.awt.Dimension(1176, 2450));
        Pnl_Tema9.setMinimumSize(new java.awt.Dimension(1176, 2450));
        Pnl_Tema9.setPreferredSize(new java.awt.Dimension(1176, 2450));
        Pnl_Tema9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Bucles.setFont(sRecursos.getFLabels());
        Lbl_Bucles.setText("9. Bucles");
        Lbl_Bucles.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Bucles.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Bucles.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Bucles.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema9.add(Lbl_Bucles, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt8_1.setContentType("text/html"); // NOI18N
        Edt8_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt8_1.setText("");
        Edt8_1.setOpaque(false);
        Pnl_Tema9.add(Edt8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 160));

        Spr_While.setForeground(sRecursos.getColorVerde());
        Spr_While.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema9.add(Spr_While, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 1120, -1));

        Lbl_BucleWhile.setFont(sRecursos.getFTitleEditor());
        Lbl_BucleWhile.setForeground(sRecursos.getColorVerde());
        Lbl_BucleWhile.setText("Bucle While");
        Pnl_Tema9.add(Lbl_BucleWhile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        Edt8_2.setContentType("text/html"); // NOI18N
        Edt8_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt8_2.setText("");
        Edt8_2.setOpaque(false);
        Pnl_Tema9.add(Edt8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 1120, 90));

        Pnl_CodesThemes8_4.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes8_4.setLayout(new java.awt.CardLayout());
        Pnl_Tema9.add(Pnl_CodesThemes8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 1120, 60));

        Lbl_SampleCode8_1.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_1.setText("Código de Ejemplo");
        Pnl_Tema9.add(Lbl_SampleCode8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 20));

        Pnl_CodesThemes8_1.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes8_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema9.add(Pnl_CodesThemes8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 1120, 200));

        Edt8_3.setContentType("text/html"); // NOI18N
        Edt8_3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt8_3.setText("");
        Edt8_3.setOpaque(false);
        Pnl_Tema9.add(Edt8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, 1120, 140));

        Spr_For.setForeground(sRecursos.getColorVerde());
        Spr_For.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema9.add(Spr_For, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 1120, -1));

        Lbl_BucleFor.setFont(sRecursos.getFTitleEditor());
        Lbl_BucleFor.setForeground(sRecursos.getColorVerde());
        Lbl_BucleFor.setText("Bucle For");
        Pnl_Tema9.add(Lbl_BucleFor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 910, -1, 20));

        Edt8_4.setContentType("text/html"); // NOI18N
        Edt8_4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt8_4.setText("");
        Edt8_4.setOpaque(false);
        Pnl_Tema9.add(Edt8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 940, 1120, 90));

        Pnl_CodesThemes8_5.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes8_5.setLayout(new java.awt.CardLayout());
        Pnl_Tema9.add(Pnl_CodesThemes8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1040, 1120, 60));

        Lbl_SampleCode8_2.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_2.setText("Código de Ejemplo");
        Pnl_Tema9.add(Lbl_SampleCode8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1110, -1, 20));

        Pnl_CodesThemes8_2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes8_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema9.add(Pnl_CodesThemes8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1140, 1118, 200));

        Edt8_5.setContentType("text/html"); // NOI18N
        Edt8_5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt8_5.setText("");
        Edt8_5.setOpaque(false);
        Pnl_Tema9.add(Edt8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1350, 1120, 70));

        Spr_DoWhile.setForeground(sRecursos.getColorVerde());
        Spr_DoWhile.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema9.add(Spr_DoWhile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1450, 1120, -1));

        Lbl_BucleDoWhile.setFont(sRecursos.getFTitleEditor());
        Lbl_BucleDoWhile.setForeground(sRecursos.getColorVerde());
        Lbl_BucleDoWhile.setText("Bucle Do-While");
        Pnl_Tema9.add(Lbl_BucleDoWhile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1480, -1, 20));

        Edt8_6.setContentType("text/html"); // NOI18N
        Edt8_6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt8_6.setText("");
        Edt8_6.setOpaque(false);
        Pnl_Tema9.add(Edt8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1510, 1120, 90));

        Pnl_CodesThemes8_6.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes8_6.setLayout(new java.awt.CardLayout());
        Pnl_Tema9.add(Pnl_CodesThemes8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1610, 1120, 80));

        Lbl_SampleCode8_3.setFont(sRecursos.getFTitles());
        Lbl_SampleCode8_3.setText("Código de Ejemplo");
        Pnl_Tema9.add(Lbl_SampleCode8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1700, -1, 20));

        Pnl_CodesThemes8_3.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes8_3.setLayout(new java.awt.CardLayout());
        Pnl_Tema9.add(Pnl_CodesThemes8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1730, 1116, 200));

        Edt8_7.setContentType("text/html"); // NOI18N
        Edt8_7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt8_7.setText("");
        Edt8_7.setOpaque(false);
        Pnl_Tema9.add(Edt8_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1940, 1120, 290));

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
        Pnl_Tema9.add(Btn_Anterior_Cuestionario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 2350, 254, 64));

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
        Pnl_Tema9.add(Btn_Siguiente_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 2350, 254, 64));

        Scp_Tema9.setViewportView(Pnl_Tema9);

        Pnl_Temas.add(Scp_Tema9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario9.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario9.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario9.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario9.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario9.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario9.setMaximumSize(new java.awt.Dimension(1176, 1300));
        Pnl_Cuestionario9.setMinimumSize(new java.awt.Dimension(1176, 1300));
        Pnl_Cuestionario9.setPreferredSize(new java.awt.Dimension(1176, 1300));
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
        Pnl_Cuestionario9.add(Btn_Anterior_Bucles, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1200, 254, 64));

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
        Pnl_Cuestionario9.add(Btn_Siguiente_Ejercicio2_Intermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1200, 254, 64));

        Lbl_Cuestionario9.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario9.setText("9. Bucles | Cuestionario");
        Lbl_Cuestionario9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario9.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario9.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario9.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario9.add(Lbl_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question5_8);
        Rad_Question5_8.setOpaque(false);
        Pnl_Cuestionario9.add(Rad_Question5_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 20));

        Bgr_Question1.add(Rad_Question8_1);
        Rad_Question8_1.setOpaque(false);
        Pnl_Cuestionario9.add(Rad_Question8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, 20));

        Btn_Answer8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer8.setBorderPainted(false);
        Btn_Answer8.setContentAreaFilled(false);
        Btn_Answer8.setFocusPainted(false);
        Btn_Answer8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer8ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario9.add(Btn_Answer8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1030, 260, 50));

        Bgr_Question1.add(Rad_Question2_14);
        Rad_Question2_14.setOpaque(false);
        Pnl_Cuestionario9.add(Rad_Question2_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 20));

        Bgr_Question1.add(Rad_Question8_1_0);
        Rad_Question8_1_0.setOpaque(false);
        Pnl_Cuestionario9.add(Rad_Question8_1_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 20));

        Bgr_Question2.add(Rad_Question8_2);
        Rad_Question8_2.setOpaque(false);
        Pnl_Cuestionario9.add(Rad_Question8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 466, -1, 20));

        Bgr_Question2.add(Rad_Question8_2_0);
        Rad_Question8_2_0.setOpaque(false);
        Pnl_Cuestionario9.add(Rad_Question8_2_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 446, -1, 20));

        Bgr_Question2.add(Rad_Question5_9);
        Rad_Question5_9.setOpaque(false);
        Pnl_Cuestionario9.add(Rad_Question5_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 486, -1, 20));

        Bgr_Question2.add(Rad_Question7_5);
        Rad_Question7_5.setOpaque(false);
        Pnl_Cuestionario9.add(Rad_Question7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 426, -1, 20));

        Bgr_Question3.add(Rad_Question8_3_0);
        Rad_Question8_3_0.setOpaque(false);
        Pnl_Cuestionario9.add(Rad_Question8_3_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 920, -1, 20));

        Bgr_Question3.add(Rad_Question4_10);
        Rad_Question4_10.setOpaque(false);
        Pnl_Cuestionario9.add(Rad_Question4_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 900, -1, 20));

        Bgr_Question3.add(jRadioButton33);
        jRadioButton33.setOpaque(false);
        Pnl_Cuestionario9.add(jRadioButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 940, -1, 20));

        Bgr_Question3.add(Rad_Question8_3);
        Rad_Question8_3.setOpaque(false);
        Pnl_Cuestionario9.add(Rad_Question8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 880, -1, 20));

        EdtCuestionario9.setContentType("text/html"); // NOI18N
        EdtCuestionario9.setOpaque(false);
        Pnl_Cuestionario9.add(EdtCuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 1070, 870));

        Scp_Cuestionario9.setViewportView(Pnl_Cuestionario9);

        Pnl_Temas.add(Scp_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Ejercicio2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Ejercicio2.setMaximumSize(sRecursos.getDTamanio());
        Scp_Ejercicio2.setMinimumSize(sRecursos.getDTamanio());
        Scp_Ejercicio2.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Ejercicio2_Aprender.setBackground(sRecursos.getCPrincipal());
        Pnl_Ejercicio2_Aprender.setCursor(sRecursos.getCDefault());
        Pnl_Ejercicio2_Aprender.setMaximumSize(new java.awt.Dimension(1176, 1290));
        Pnl_Ejercicio2_Aprender.setMinimumSize(new java.awt.Dimension(1176, 1290));
        Pnl_Ejercicio2_Aprender.setPreferredSize(new java.awt.Dimension(1176, 1290));
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
        Pnl_Ejercicio2_Aprender.add(Btn_Anterior_Cuestionario9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1190, 254, 64));

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
        Pnl_Ejercicio2_Aprender.add(Btn_Siguiente_FuncionesyProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1190, 254, 64));

        Lbl_Ejercicio2_Intermedio.setFont(sRecursos.getFLabels());
        Lbl_Ejercicio2_Intermedio.setText("Ejercicio 2 | Intermedio");
        Lbl_Ejercicio2_Intermedio.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Ejercicio2_Intermedio.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Ejercicio2_Intermedio.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Ejercicio2_Intermedio.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Ejercicio2_Aprender.add(Lbl_Ejercicio2_Intermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

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
        Pnl_Ejercicio2_Aprender.add(Btn_EnviarEjercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 730, 170, 50));

        Pnl_SyntaxEjercicio2.setBackground(new java.awt.Color(204, 204, 204));
        Pnl_SyntaxEjercicio2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_SyntaxEjercicio2.setLayout(new java.awt.CardLayout());
        Pnl_Ejercicio2_Aprender.add(Pnl_SyntaxEjercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 790, 1080, 330));

        Edt_Ejercicio2.setBackground(sRecursos.getCPrincipal());
        Edt_Ejercicio2.setContentType("text/html"); // NOI18N
        Edt_Ejercicio2.setOpaque(false);
        Pnl_Ejercicio2_Aprender.add(Edt_Ejercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1120, 590));

        Scp_Ejercicio2.setViewportView(Pnl_Ejercicio2_Aprender);

        Pnl_Temas.add(Scp_Ejercicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema10.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema10.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema10.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema10.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema10.setCursor(sRecursos.getCDefault());
        Pnl_Tema10.setMaximumSize(new java.awt.Dimension(1176, 2180));
        Pnl_Tema10.setMinimumSize(new java.awt.Dimension(1176, 2180));
        Pnl_Tema10.setPreferredSize(new java.awt.Dimension(1176, 2180));
        Pnl_Tema10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_FuncionesyProcs.setFont(sRecursos.getFLabels());
        Lbl_FuncionesyProcs.setText("10. Funciones y Procedimientos");
        Lbl_FuncionesyProcs.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_FuncionesyProcs.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_FuncionesyProcs.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_FuncionesyProcs.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema10.add(Lbl_FuncionesyProcs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt9_1.setContentType("text/html"); // NOI18N
        Edt9_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt9_1.setText("");
        Edt9_1.setOpaque(false);
        Pnl_Tema10.add(Edt9_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 270));

        Pnl_CodesThemes9_1.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes9_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema10.add(Pnl_CodesThemes9_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 1110, 120));

        Edt9_2.setContentType("text/html"); // NOI18N
        Edt9_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt9_2.setText("");
        Edt9_2.setOpaque(false);
        Pnl_Tema10.add(Edt9_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 1120, 470));

        Pnl_CodesThemes9_2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes9_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema10.add(Pnl_CodesThemes9_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 940, 1110, 670));

        Edt9_3.setContentType("text/html"); // NOI18N
        Edt9_3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt9_3.setText("");
        Edt9_3.setOpaque(false);
        Pnl_Tema10.add(Edt9_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1620, 1120, 350));

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
        Pnl_Tema10.add(Btn_Anterior_Ejercicio2_Intermedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 2080, 254, 64));

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
        Pnl_Tema10.add(Btn_Siguiente_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 2080, 254, 64));

        Scp_Tema10.setViewportView(Pnl_Tema10);

        Pnl_Temas.add(Scp_Tema10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario10.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario10.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario10.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario10.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario10.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario10.setMaximumSize(new java.awt.Dimension(1176, 880));
        Pnl_Cuestionario10.setMinimumSize(new java.awt.Dimension(1176, 880));
        Pnl_Cuestionario10.setPreferredSize(new java.awt.Dimension(1176, 880));
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
        Pnl_Cuestionario10.add(Btn_Anterior_FuncyProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 780, 254, 64));

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
        Pnl_Cuestionario10.add(Btn_Siguiente_Recursion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 780, 254, 64));

        Lbl_Cuestionario10.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario10.setText("10. Funciones y Procedimientos | Cuestionario");
        Lbl_Cuestionario10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario10.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario10.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario10.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario10.add(Lbl_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question5_10);
        Rad_Question5_10.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question5_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 182, -1, -1));

        Bgr_Question1.add(Rad_Question9_1);
        Rad_Question9_1.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question9_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 162, -1, -1));

        Btn_Answer9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer9.setBorderPainted(false);
        Btn_Answer9.setContentAreaFilled(false);
        Btn_Answer9.setFocusPainted(false);
        Btn_Answer9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer9ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario10.add(Btn_Answer9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 260, 50));

        Bgr_Question1.add(Rad_Question2_15);
        Rad_Question2_15.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question2_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 202, -1, -1));

        Bgr_Question1.add(Rad_Question8_4);
        Rad_Question8_4.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 142, -1, -1));

        Bgr_Question2.add(Rad_Question1_19);
        Rad_Question1_19.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question1_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        Bgr_Question2.add(Rad_Question8_5);
        Rad_Question8_5.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        Bgr_Question2.add(Rad_Question5_11);
        Rad_Question5_11.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question5_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        Bgr_Question2.add(Rad_Question9_2);
        Rad_Question9_2.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question9_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        Bgr_Question3.add(Rad_Question8_6);
        Rad_Question8_6.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 495, -1, -1));

        Bgr_Question3.add(Rad_Question4_11);
        Rad_Question4_11.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question4_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 475, -1, -1));

        Bgr_Question3.add(Rad_Question9_3);
        Rad_Question9_3.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question9_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 515, -1, -1));

        Bgr_Question3.add(Rad_Question3_12);
        Rad_Question3_12.setOpaque(false);
        Pnl_Cuestionario10.add(Rad_Question3_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 455, -1, -1));

        EdtCuestionario10.setContentType("text/html"); // NOI18N
        EdtCuestionario10.setOpaque(false);
        Pnl_Cuestionario10.add(EdtCuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 800, 450));

        Scp_Cuestionario10.setViewportView(Pnl_Cuestionario10);

        Pnl_Temas.add(Scp_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema11.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema11.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema11.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema11.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema11.setCursor(sRecursos.getCDefault());
        Pnl_Tema11.setMaximumSize(new java.awt.Dimension(1176, 1400));
        Pnl_Tema11.setMinimumSize(new java.awt.Dimension(1176, 1400));
        Pnl_Tema11.setPreferredSize(new java.awt.Dimension(1176, 1400));
        Pnl_Tema11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Recursion.setFont(sRecursos.getFLabels());
        Lbl_Recursion.setText("11. Recursión");
        Lbl_Recursion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Recursion.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Recursion.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Recursion.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema11.add(Lbl_Recursion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt10_1.setContentType("text/html"); // NOI18N
        Edt10_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt10_1.setText("");
        Edt10_1.setOpaque(false);
        Pnl_Tema11.add(Edt10_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 430));

        Pnl_CodesThemes10_1.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes10_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema11.add(Pnl_CodesThemes10_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 1120, 110));

        Edt10_2.setContentType("text/html"); // NOI18N
        Edt10_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt10_2.setText("");
        Edt10_2.setOpaque(false);
        Pnl_Tema11.add(Edt10_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 1120, 120));

        Pnl_CodesThemes10_2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes10_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema11.add(Pnl_CodesThemes10_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 740, 1120, 350));

        Edt10_3.setContentType("text/html"); // NOI18N
        Edt10_3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt10_3.setText("");
        Edt10_3.setOpaque(false);
        Pnl_Tema11.add(Edt10_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1100, 1120, 110));

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
        Pnl_Tema11.add(Btn_Anterior_Cuestionario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1300, 254, 64));

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
        Pnl_Tema11.add(Btn_Siguiente_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1300, 254, 64));

        Scp_Tema11.setViewportView(Pnl_Tema11);

        Pnl_Temas.add(Scp_Tema11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario11.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario11.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario11.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario11.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario11.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario11.setMaximumSize(new java.awt.Dimension(1176, 850));
        Pnl_Cuestionario11.setMinimumSize(new java.awt.Dimension(1176, 850));
        Pnl_Cuestionario11.setPreferredSize(new java.awt.Dimension(1176, 850));
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
        Pnl_Cuestionario11.add(Btn_Anterior_Recursion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 750, 254, 64));

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
        Pnl_Cuestionario11.add(Btn_Siguiente_EDDBasicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 750, 254, 64));

        Lbl_Cuestionario11.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario11.setText("11. Recursión | Cuestionario");
        Lbl_Cuestionario11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario11.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario11.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario11.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario11.add(Lbl_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question5_13);
        Rad_Question5_13.setOpaque(false);
        Pnl_Cuestionario11.add(Rad_Question5_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 182, -1, -1));

        Bgr_Question1.add(Rad_Question10_1);
        Rad_Question10_1.setOpaque(false);
        Pnl_Cuestionario11.add(Rad_Question10_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 162, -1, -1));

        Btn_Answer10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer10.setBorderPainted(false);
        Btn_Answer10.setContentAreaFilled(false);
        Btn_Answer10.setFocusPainted(false);
        Btn_Answer10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer10ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario11.add(Btn_Answer10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 260, 50));

        Bgr_Question1.add(Rad_Question8_9);
        Rad_Question8_9.setOpaque(false);
        Pnl_Cuestionario11.add(Rad_Question8_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 142, -1, -1));

        Bgr_Question2.add(Rad_Question10_2);
        Rad_Question10_2.setOpaque(false);
        Pnl_Cuestionario11.add(Rad_Question10_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 318, -1, -1));

        Bgr_Question2.add(Rad_Question8_10);
        Rad_Question8_10.setOpaque(false);
        Pnl_Cuestionario11.add(Rad_Question8_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 298, -1, -1));

        Bgr_Question2.add(Rad_Question5_14);
        Rad_Question5_14.setOpaque(false);
        Pnl_Cuestionario11.add(Rad_Question5_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 338, -1, -1));

        Bgr_Question2.add(Rad_Question10_2_1);
        Rad_Question10_2_1.setOpaque(false);
        Pnl_Cuestionario11.add(Rad_Question10_2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 278, -1, -1));

        Bgr_Question3.add(Rad_Question8_11);
        Rad_Question8_11.setOpaque(false);
        Pnl_Cuestionario11.add(Rad_Question8_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 475, -1, -1));

        Bgr_Question3.add(Rad_Question10_3);
        Rad_Question10_3.setOpaque(false);
        Pnl_Cuestionario11.add(Rad_Question10_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 455, -1, -1));

        Bgr_Question3.add(Rad_Question3_14);
        Rad_Question3_14.setOpaque(false);
        Pnl_Cuestionario11.add(Rad_Question3_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 435, -1, -1));

        EdtCuestionario11.setContentType("text/html"); // NOI18N
        EdtCuestionario11.setOpaque(false);
        Pnl_Cuestionario11.add(EdtCuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 800, 410));

        Scp_Cuestionario11.setViewportView(Pnl_Cuestionario11);

        Pnl_Temas.add(Scp_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema12.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema12.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema12.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema12.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema12.setCursor(sRecursos.getCDefault());
        Pnl_Tema12.setMaximumSize(new java.awt.Dimension(1176, 7050));
        Pnl_Tema12.setMinimumSize(new java.awt.Dimension(1176, 7050));
        Pnl_Tema12.setPreferredSize(new java.awt.Dimension(1176, 7050));
        Pnl_Tema12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_EDDBasicas.setFont(sRecursos.getFLabels());
        Lbl_EDDBasicas.setText("12. Estructuras de Datos Básicas");
        Lbl_EDDBasicas.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_EDDBasicas.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_EDDBasicas.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_EDDBasicas.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema12.add(Lbl_EDDBasicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt11_1.setContentType("text/html"); // NOI18N
        Edt11_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_1.setText("");
        Edt11_1.setOpaque(false);
        Pnl_Tema12.add(Edt11_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 640));

        Pnl_CodesThemes11_1.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes11_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema12.add(Pnl_CodesThemes11_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 1120, 40));

        Spr_VectorFijo.setForeground(sRecursos.getColorVerde());
        Spr_VectorFijo.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema12.add(Spr_VectorFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 770, 1120, -1));

        Lbl_VectorFijo.setFont(sRecursos.getFB20());
        Lbl_VectorFijo.setForeground(sRecursos.getColorVerde());
        Lbl_VectorFijo.setText("Vector Fijo");
        Pnl_Tema12.add(Lbl_VectorFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 790, -1, -1));

        Edt11_2.setContentType("text/html"); // NOI18N
        Edt11_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_2.setText("");
        Edt11_2.setOpaque(false);
        Pnl_Tema12.add(Edt11_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 830, 1120, 240));

        Pnl_CodesThemes11_2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes11_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema12.add(Pnl_CodesThemes11_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1080, 1120, 370));

        Edt11_3.setContentType("text/html"); // NOI18N
        Edt11_3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_3.setText("");
        Edt11_3.setOpaque(false);
        Pnl_Tema12.add(Edt11_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1460, 1120, 300));

        Pnl_CodesThemes11_3.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes11_3.setLayout(new java.awt.CardLayout());
        Pnl_Tema12.add(Pnl_CodesThemes11_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1770, 1120, 340));

        Edt11_4.setContentType("text/html"); // NOI18N
        Edt11_4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_4.setText("");
        Edt11_4.setOpaque(false);
        Pnl_Tema12.add(Edt11_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2120, 1120, 220));

        Spr_VectorDinamico.setForeground(sRecursos.getColorVerde());
        Spr_VectorDinamico.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema12.add(Spr_VectorDinamico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2370, 1120, -1));

        Lbl_VectorDinamico.setFont(sRecursos.getFB20());
        Lbl_VectorDinamico.setForeground(sRecursos.getColorVerde());
        Lbl_VectorDinamico.setText("Vector Dinámico");
        Pnl_Tema12.add(Lbl_VectorDinamico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2400, -1, -1));

        Edt11_5.setContentType("text/html"); // NOI18N
        Edt11_5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_5.setText("");
        Edt11_5.setOpaque(false);
        Pnl_Tema12.add(Edt11_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2430, 1120, 240));

        Pnl_CodesThemes11_4.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes11_4.setLayout(new java.awt.CardLayout());
        Pnl_Tema12.add(Pnl_CodesThemes11_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2680, 1120, 250));

        Edt11_6.setContentType("text/html"); // NOI18N
        Edt11_6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_6.setText("");
        Edt11_6.setOpaque(false);
        Pnl_Tema12.add(Edt11_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2940, 1120, 200));

        Spr_MatrizFija.setForeground(sRecursos.getColorVerde());
        Spr_MatrizFija.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema12.add(Spr_MatrizFija, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3170, 1120, -1));

        Lbl_MatrizFija.setFont(sRecursos.getFB20());
        Lbl_MatrizFija.setForeground(sRecursos.getColorVerde());
        Lbl_MatrizFija.setText("Matriz Fija");
        Pnl_Tema12.add(Lbl_MatrizFija, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3200, -1, -1));

        Edt11_7.setContentType("text/html"); // NOI18N
        Edt11_7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_7.setText("");
        Edt11_7.setOpaque(false);
        Pnl_Tema12.add(Edt11_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3230, 1120, 240));

        Pnl_CodesThemes11_5.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes11_5.setLayout(new java.awt.CardLayout());
        Pnl_Tema12.add(Pnl_CodesThemes11_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3480, 1120, 350));

        Edt11_8.setContentType("text/html"); // NOI18N
        Edt11_8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_8.setText("");
        Edt11_8.setOpaque(false);
        Pnl_Tema12.add(Edt11_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3840, 1120, 180));

        Spr_MatrizDinamica.setForeground(sRecursos.getColorVerde());
        Spr_MatrizDinamica.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema12.add(Spr_MatrizDinamica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4050, 1120, -1));

        Lbl_MatrizDinamica.setFont(sRecursos.getFB20());
        Lbl_MatrizDinamica.setForeground(sRecursos.getColorVerde());
        Lbl_MatrizDinamica.setText("Matriz Dinámica");
        Pnl_Tema12.add(Lbl_MatrizDinamica, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4080, -1, -1));

        Edt11_9.setContentType("text/html"); // NOI18N
        Edt11_9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_9.setText("");
        Edt11_9.setOpaque(false);
        Pnl_Tema12.add(Edt11_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4120, 1120, 240));

        Pnl_CodesThemes11_6.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes11_6.setLayout(new java.awt.CardLayout());
        Pnl_Tema12.add(Pnl_CodesThemes11_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4370, 1120, 330));

        Edt11_10.setContentType("text/html"); // NOI18N
        Edt11_10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_10.setText("");
        Edt11_10.setOpaque(false);
        Pnl_Tema12.add(Edt11_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4710, 1120, 160));

        Spr_Pilas.setForeground(sRecursos.getColorVerde());
        Spr_Pilas.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema12.add(Spr_Pilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4900, 1120, -1));

        Lbl_Pilas.setFont(sRecursos.getFB20());
        Lbl_Pilas.setForeground(sRecursos.getColorVerde());
        Lbl_Pilas.setText("Pilas");
        Pnl_Tema12.add(Lbl_Pilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4930, -1, -1));

        Edt11_11.setContentType("text/html"); // NOI18N
        Edt11_11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_11.setText("");
        Edt11_11.setOpaque(false);
        Pnl_Tema12.add(Edt11_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4970, 1120, 390));

        Pnl_CodesThemes11_7.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes11_7.setLayout(new java.awt.CardLayout());
        Pnl_Tema12.add(Pnl_CodesThemes11_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5370, 1120, 260));

        Edt11_12.setContentType("text/html"); // NOI18N
        Edt11_12.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_12.setText("");
        Edt11_12.setOpaque(false);
        Pnl_Tema12.add(Edt11_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5640, 1120, 370));

        Spr_Colas.setForeground(sRecursos.getColorVerde());
        Spr_Colas.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema12.add(Spr_Colas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6040, 1120, -1));

        Lbl_Colas.setFont(sRecursos.getFB20());
        Lbl_Colas.setForeground(sRecursos.getColorVerde());
        Lbl_Colas.setText("Colas");
        Pnl_Tema12.add(Lbl_Colas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6070, -1, -1));

        Edt11_13.setContentType("text/html"); // NOI18N
        Edt11_13.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_13.setText("");
        Edt11_13.setOpaque(false);
        Pnl_Tema12.add(Edt11_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6110, 1120, 260));

        Pnl_CodesThemes11_8.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes11_8.setLayout(new java.awt.CardLayout());
        Pnl_Tema12.add(Pnl_CodesThemes11_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6380, 1120, 260));

        Edt11_14.setContentType("text/html"); // NOI18N
        Edt11_14.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt11_14.setText("");
        Edt11_14.setOpaque(false);
        Pnl_Tema12.add(Edt11_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6650, 1120, 200));

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
        Pnl_Tema12.add(Btn_Anterior_Cuestionario11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 6950, 254, 64));

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
        Pnl_Tema12.add(Btn_Siguiente_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 6950, 254, 64));

        Scp_Tema12.setViewportView(Pnl_Tema12);

        Pnl_Temas.add(Scp_Tema12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario12.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario12.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario12.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario12.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario12.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario12.setMaximumSize(new java.awt.Dimension(1176, 820));
        Pnl_Cuestionario12.setMinimumSize(new java.awt.Dimension(1176, 820));
        Pnl_Cuestionario12.setPreferredSize(new java.awt.Dimension(1176, 820));
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
        Pnl_Cuestionario12.add(Btn_Anterior_EDDBasicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 720, 254, 64));

        Btn_Siguiente_EDDIntermedias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EDDIntermedias_Off.png"))); // NOI18N
        Btn_Siguiente_EDDIntermedias.setMnemonic(39);
        Btn_Siguiente_EDDIntermedias.setBorderPainted(false);
        Btn_Siguiente_EDDIntermedias.setContentAreaFilled(false);
        Btn_Siguiente_EDDIntermedias.setFocusPainted(false);
        Btn_Siguiente_EDDIntermedias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Siguiente_EDDIntermedias.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EDDIntermedias.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EDDIntermedias.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Siguiente_EDDIntermedias.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Siguiente_EDDIntermedias_On.png"))); // NOI18N
        Btn_Siguiente_EDDIntermedias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Siguiente_EDDIntermediasActionPerformed(evt);
            }
        });
        Pnl_Cuestionario12.add(Btn_Siguiente_EDDIntermedias, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 720, 254, 64));

        Lbl_Cuestionario12.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario12.setText("12. Estructuras de Datos Básicas | Cuestionario");
        Lbl_Cuestionario12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario12.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario12.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario12.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario12.add(Lbl_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question5_15);
        Rad_Question5_15.setOpaque(false);
        Pnl_Cuestionario12.add(Rad_Question5_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 185, -1, -1));

        Bgr_Question1.add(Rad_Question10_4);
        Rad_Question10_4.setOpaque(false);
        Pnl_Cuestionario12.add(Rad_Question10_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 165, -1, -1));

        Bgr_Question1.add(Rad_Question11_1);
        Rad_Question11_1.setOpaque(false);
        Pnl_Cuestionario12.add(Rad_Question11_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, -1, -1));

        Bgr_Question2.add(Rad_Question10_5);
        Rad_Question10_5.setOpaque(false);
        Pnl_Cuestionario12.add(Rad_Question10_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        Bgr_Question2.add(Rad_Question11_2);
        Rad_Question11_2.setOpaque(false);
        Pnl_Cuestionario12.add(Rad_Question11_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        Bgr_Question2.add(Rad_Question10_2_2);
        Rad_Question10_2_2.setOpaque(false);
        Pnl_Cuestionario12.add(Rad_Question10_2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        Bgr_Question3.add(Rad_Question11_3);
        Rad_Question11_3.setOpaque(false);
        Pnl_Cuestionario12.add(Rad_Question11_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 452, -1, -1));

        Bgr_Question3.add(Rad_Question10_6);
        Rad_Question10_6.setOpaque(false);
        Pnl_Cuestionario12.add(Rad_Question10_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 432, -1, -1));

        Bgr_Question3.add(Rad_Question3_18);
        Rad_Question3_18.setOpaque(false);
        Pnl_Cuestionario12.add(Rad_Question3_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 412, -1, -1));

        Btn_Answer11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer11.setBorderPainted(false);
        Btn_Answer11.setContentAreaFilled(false);
        Btn_Answer11.setFocusPainted(false);
        Btn_Answer11.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer11ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario12.add(Btn_Answer11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 260, 50));

        EdtCuestionario12.setContentType("text/html"); // NOI18N
        EdtCuestionario12.setOpaque(false);
        Pnl_Cuestionario12.add(EdtCuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 800, 390));

        Scp_Cuestionario12.setViewportView(Pnl_Cuestionario12);

        Pnl_Temas.add(Scp_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema13.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema13.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema13.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema13.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema13.setCursor(sRecursos.getCDefault());
        Pnl_Tema13.setMaximumSize(new java.awt.Dimension(1176, 4350));
        Pnl_Tema13.setMinimumSize(new java.awt.Dimension(1176, 4350));
        Pnl_Tema13.setPreferredSize(new java.awt.Dimension(1176, 4350));
        Pnl_Tema13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_EDDIntermedias.setFont(sRecursos.getFLabels());
        Lbl_EDDIntermedias.setText("13. Estructuras de Datos Intermedias");
        Lbl_EDDIntermedias.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_EDDIntermedias.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_EDDIntermedias.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_EDDIntermedias.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema13.add(Lbl_EDDIntermedias, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Edt12_1.setContentType("text/html"); // NOI18N
        Edt12_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt12_1.setText("");
        Edt12_1.setOpaque(false);
        Pnl_Tema13.add(Edt12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 130));

        Spr_Sets.setForeground(sRecursos.getColorVerde());
        Spr_Sets.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_Sets, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 1120, -1));

        Lbl_Sets.setFont(sRecursos.getFTitleEditor());
        Lbl_Sets.setForeground(sRecursos.getColorVerde());
        Lbl_Sets.setText("Sets");
        Pnl_Tema13.add(Lbl_Sets, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 20));

        Edt12_2.setContentType("text/html"); // NOI18N
        Edt12_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt12_2.setText("");
        Edt12_2.setOpaque(false);
        Pnl_Tema13.add(Edt12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 1120, 360));

        Spr_HashSet.setForeground(sRecursos.getColorVerde());
        Spr_HashSet.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_HashSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 1120, -1));

        Lbl_HashSet.setFont(sRecursos.getFTitleEditor());
        Lbl_HashSet.setForeground(sRecursos.getColorVerde());
        Lbl_HashSet.setText("HashSet");
        Pnl_Tema13.add(Lbl_HashSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, -1, 20));

        Edt12_3.setContentType("text/html"); // NOI18N
        Edt12_3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt12_3.setText("");
        Edt12_3.setOpaque(false);
        Pnl_Tema13.add(Edt12_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 1120, 170));

        Pnl_CodesThemes12_1.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes12_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema13.add(Pnl_CodesThemes12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 900, 1120, 280));

        Edt12_4.setContentType("text/html"); // NOI18N
        Edt12_4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt12_4.setText("");
        Edt12_4.setOpaque(false);
        Pnl_Tema13.add(Edt12_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1190, 1120, 60));

        Spr_TreeSet.setForeground(sRecursos.getColorVerde());
        Spr_TreeSet.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_TreeSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1280, 1120, -1));

        Lbl_TreeSet.setFont(sRecursos.getFTitleEditor());
        Lbl_TreeSet.setForeground(sRecursos.getColorVerde());
        Lbl_TreeSet.setText("TreeSet");
        Pnl_Tema13.add(Lbl_TreeSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1310, -1, 20));

        Edt12_5.setContentType("text/html"); // NOI18N
        Edt12_5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt12_5.setText("");
        Edt12_5.setOpaque(false);
        Pnl_Tema13.add(Edt12_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1350, 1120, 200));

        Pnl_CodesThemes12_2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes12_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema13.add(Pnl_CodesThemes12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1560, 1118, 280));

        Edt12_6.setContentType("text/html"); // NOI18N
        Edt12_6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt12_6.setText("");
        Edt12_6.setOpaque(false);
        Pnl_Tema13.add(Edt12_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1850, 1120, 270));

        Spr_Maps.setForeground(sRecursos.getColorVerde());
        Spr_Maps.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_Maps, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2150, 1120, -1));

        Lbl_Maps.setFont(sRecursos.getFTitleEditor());
        Lbl_Maps.setForeground(sRecursos.getColorVerde());
        Lbl_Maps.setText("Maps");
        Pnl_Tema13.add(Lbl_Maps, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2170, -1, 30));

        Edt12_7.setContentType("text/html"); // NOI18N
        Edt12_7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt12_7.setText("");
        Edt12_7.setOpaque(false);
        Pnl_Tema13.add(Edt12_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2220, 1120, 400));

        Spr_HashMap.setForeground(sRecursos.getColorVerde());
        Spr_HashMap.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_HashMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2650, 1120, -1));

        Lbl_HashMap.setFont(sRecursos.getFTitleEditor());
        Lbl_HashMap.setForeground(sRecursos.getColorVerde());
        Lbl_HashMap.setText("HashMap");
        Pnl_Tema13.add(Lbl_HashMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2680, -1, 20));

        Edt12_8.setContentType("text/html"); // NOI18N
        Edt12_8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt12_8.setText("");
        Edt12_8.setOpaque(false);
        Pnl_Tema13.add(Edt12_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2720, 1120, 190));

        Pnl_CodesThemes12_3.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes12_3.setLayout(new java.awt.CardLayout());
        Pnl_Tema13.add(Pnl_CodesThemes12_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2920, 1120, 300));

        Edt12_9.setContentType("text/html"); // NOI18N
        Edt12_9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt12_9.setText("");
        Edt12_9.setOpaque(false);
        Pnl_Tema13.add(Edt12_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3230, 1120, 150));

        Spr_TreeMap.setForeground(sRecursos.getColorVerde());
        Spr_TreeMap.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema13.add(Spr_TreeMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3410, 1120, -1));

        Lbl_TreeMap.setFont(sRecursos.getFTitleEditor());
        Lbl_TreeMap.setForeground(sRecursos.getColorVerde());
        Lbl_TreeMap.setText("TreeMap");
        Pnl_Tema13.add(Lbl_TreeMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3440, -1, 20));

        Edt12_10.setContentType("text/html"); // NOI18N
        Edt12_10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt12_10.setText("");
        Edt12_10.setOpaque(false);
        Pnl_Tema13.add(Edt12_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3480, 1120, 200));

        Pnl_CodesThemes12_4.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes12_4.setLayout(new java.awt.CardLayout());
        Pnl_Tema13.add(Pnl_CodesThemes12_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3690, 1120, 300));

        Edt12_11.setContentType("text/html"); // NOI18N
        Edt12_11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt12_11.setText("");
        Edt12_11.setOpaque(false);
        Pnl_Tema13.add(Edt12_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 4000, 1120, 170));

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
        Pnl_Tema13.add(Btn_Anterior_Cuestionario12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 4250, 254, 64));

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
        Pnl_Tema13.add(Btn_Siguiente_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 4250, 254, 64));

        Scp_Tema13.setViewportView(Pnl_Tema13);

        Pnl_Temas.add(Scp_Tema13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario13.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario13.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario13.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario13.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario13.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario13.setMaximumSize(new java.awt.Dimension(1176, 1160));
        Pnl_Cuestionario13.setMinimumSize(new java.awt.Dimension(1176, 1160));
        Pnl_Cuestionario13.setPreferredSize(new java.awt.Dimension(1176, 1160));
        Pnl_Cuestionario13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Anterior_EDDIntermedias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_EDDIntermedias_Off.png"))); // NOI18N
        Btn_Anterior_EDDIntermedias.setMnemonic(37);
        Btn_Anterior_EDDIntermedias.setBorderPainted(false);
        Btn_Anterior_EDDIntermedias.setContentAreaFilled(false);
        Btn_Anterior_EDDIntermedias.setFocusPainted(false);
        Btn_Anterior_EDDIntermedias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Anterior_EDDIntermedias.setMaximumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_EDDIntermedias.setMinimumSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_EDDIntermedias.setPreferredSize(sRecursos.getDBtns_Aprender());
        Btn_Anterior_EDDIntermedias.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/Anterior_EDDIntermedias_On.png"))); // NOI18N
        Btn_Anterior_EDDIntermedias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Anterior_EDDIntermediasActionPerformed(evt);
            }
        });
        Pnl_Cuestionario13.add(Btn_Anterior_EDDIntermedias, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1060, 254, 64));

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
        Pnl_Cuestionario13.add(Btn_Siguiente_PrimerosAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 1060, 254, 64));

        Lbl_Cuestionario13.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario13.setText("13. Estructuras de Datos Intermedias | Cuestionario");
        Lbl_Cuestionario13.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario13.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario13.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario13.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario13.add(Lbl_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Bgr_Question1.add(Rad_Question5_17);
        Rad_Question5_17.setOpaque(false);
        Pnl_Cuestionario13.add(Rad_Question5_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 355, -1, -1));

        Bgr_Question1.add(Rad_Question8_12);
        Rad_Question8_12.setOpaque(false);
        Pnl_Cuestionario13.add(Rad_Question8_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 335, -1, -1));

        Bgr_Question1.add(Rad_Question12_1);
        Rad_Question12_1.setOpaque(false);
        Pnl_Cuestionario13.add(Rad_Question12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 375, -1, -1));

        Bgr_Question1.add(Rad_Question8_1_1);
        Rad_Question8_1_1.setOpaque(false);
        Pnl_Cuestionario13.add(Rad_Question8_1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 315, -1, -1));

        Bgr_Question2.add(Rad_Question8_13);
        Rad_Question8_13.setOpaque(false);
        Pnl_Cuestionario13.add(Rad_Question8_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 632, -1, -1));

        Bgr_Question2.add(Rad_Question12_2);
        Rad_Question12_2.setOpaque(false);
        Pnl_Cuestionario13.add(Rad_Question12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 612, -1, -1));

        Bgr_Question2.add(Rad_Question5_18);
        Rad_Question5_18.setOpaque(false);
        Pnl_Cuestionario13.add(Rad_Question5_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 652, -1, -1));

        Bgr_Question2.add(Rad_Question7_6);
        Rad_Question7_6.setOpaque(false);
        Pnl_Cuestionario13.add(Rad_Question7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 592, -1, -1));

        Bgr_Question3.add(Rad_Question12_3);
        Rad_Question12_3.setOpaque(false);
        Pnl_Cuestionario13.add(Rad_Question12_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 790, -1, -1));

        Bgr_Question3.add(Rad_Question4_16);
        Rad_Question4_16.setOpaque(false);
        Pnl_Cuestionario13.add(Rad_Question4_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 770, -1, -1));

        Bgr_Question3.add(jRadioButton34);
        jRadioButton34.setOpaque(false);
        Pnl_Cuestionario13.add(jRadioButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 810, -1, -1));

        Bgr_Question3.add(Rad_Question8_14);
        Rad_Question8_14.setOpaque(false);
        Pnl_Cuestionario13.add(Rad_Question8_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 750, -1, -1));

        Btn_Answer12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer12.setBorderPainted(false);
        Btn_Answer12.setContentAreaFilled(false);
        Btn_Answer12.setFocusPainted(false);
        Btn_Answer12.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer12ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario13.add(Btn_Answer12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 920, 260, 50));

        EdtCuestionario13.setContentType("text/html"); // NOI18N
        EdtCuestionario13.setOpaque(false);
        Pnl_Cuestionario13.add(EdtCuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 1060, 740));

        Scp_Cuestionario13.setViewportView(Pnl_Cuestionario13);

        Pnl_Temas.add(Scp_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Tema14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tema14.setMaximumSize(sRecursos.getDTamanio());
        Scp_Tema14.setMinimumSize(sRecursos.getDTamanio());
        Scp_Tema14.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Tema14.setBackground(sRecursos.getCPrincipal());
        Pnl_Tema14.setCursor(sRecursos.getCDefault());
        Pnl_Tema14.setMaximumSize(new java.awt.Dimension(1176, 3970));
        Pnl_Tema14.setMinimumSize(new java.awt.Dimension(1176, 3970));
        Pnl_Tema14.setPreferredSize(new java.awt.Dimension(1176, 3970));
        Pnl_Tema14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_PrimerosAlgoritmos.setFont(sRecursos.getFLabels());
        Lbl_PrimerosAlgoritmos.setText("14. Primeros Algoritmos");
        Lbl_PrimerosAlgoritmos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_PrimerosAlgoritmos.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_PrimerosAlgoritmos.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_PrimerosAlgoritmos.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Tema14.add(Lbl_PrimerosAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

        Lbl_BubbleSort.setFont(sRecursos.getFTitleEditor());
        Lbl_BubbleSort.setForeground(sRecursos.getColorVerde());
        Lbl_BubbleSort.setText("Ordenamientos «Bubble Sort»");
        Pnl_Tema14.add(Lbl_BubbleSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 400, 20));

        Edt13_1.setContentType("text/html"); // NOI18N
        Edt13_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt13_1.setText("");
        Edt13_1.setOpaque(false);
        Pnl_Tema14.add(Edt13_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1120, 290));

        Pnl_CodesThemes13_1.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes13_1.setLayout(new java.awt.CardLayout());
        Pnl_Tema14.add(Pnl_CodesThemes13_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 1120, 380));

        Edt13_2.setContentType("text/html"); // NOI18N
        Edt13_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt13_2.setText("");
        Edt13_2.setOpaque(false);
        Pnl_Tema14.add(Edt13_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 820, 1120, 170));

        Lbl_ImagenBubbleSort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_ImagenBubbleSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Learning_Images/BubbleSort.png"))); // NOI18N
        Lbl_ImagenBubbleSort.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_Tema14.add(Lbl_ImagenBubbleSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1000, 1120, 640));

        Edt13_3.setContentType("text/html"); // NOI18N
        Edt13_3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt13_3.setText("");
        Edt13_3.setOpaque(false);
        Pnl_Tema14.add(Edt13_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1650, 1120, 160));

        Spr_BinarySearch.setForeground(sRecursos.getColorVerde());
        Spr_BinarySearch.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_Tema14.add(Spr_BinarySearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1840, 1120, -1));

        Lbl_BinarySearch.setFont(sRecursos.getFTitleEditor());
        Lbl_BinarySearch.setForeground(sRecursos.getColorVerde());
        Lbl_BinarySearch.setText("Búsquedas «Binary Search»");
        Pnl_Tema14.add(Lbl_BinarySearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1870, 400, 30));

        Edt13_4.setContentType("text/html"); // NOI18N
        Edt13_4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt13_4.setText("");
        Edt13_4.setOpaque(false);
        Pnl_Tema14.add(Edt13_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1920, 1120, 290));

        Pnl_CodesThemes13_2.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes13_2.setLayout(new java.awt.CardLayout());
        Pnl_Tema14.add(Pnl_CodesThemes13_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2220, 1120, 480));

        Edt13_5.setContentType("text/html"); // NOI18N
        Edt13_5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt13_5.setText("");
        Edt13_5.setOpaque(false);
        Pnl_Tema14.add(Edt13_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2710, 1120, 160));

        Lbl_ImagenBinarySearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_ImagenBinarySearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Learning_Images/BinarySearch.png"))); // NOI18N
        Lbl_ImagenBinarySearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_Tema14.add(Lbl_ImagenBinarySearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 2880, 1120, 510));

        Edt13_6.setContentType("text/html"); // NOI18N
        Edt13_6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Edt13_6.setText("");
        Edt13_6.setOpaque(false);
        Pnl_Tema14.add(Edt13_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3400, 1120, 370));

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
        Pnl_Tema14.add(Btn_Anterior_Cuestionario13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 3870, 254, 64));

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
        Pnl_Tema14.add(Btn_Siguiente_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 3870, 254, 64));

        Scp_Tema14.setViewportView(Pnl_Tema14);

        Pnl_Temas.add(Scp_Tema14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Cuestionario14.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Cuestionario14.setMaximumSize(sRecursos.getDTamanio());
        Scp_Cuestionario14.setMinimumSize(sRecursos.getDTamanio());
        Scp_Cuestionario14.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Cuestionario14.setBackground(sRecursos.getCPrincipal());
        Pnl_Cuestionario14.setCursor(sRecursos.getCDefault());
        Pnl_Cuestionario14.setMaximumSize(new java.awt.Dimension(1176, 860));
        Pnl_Cuestionario14.setMinimumSize(new java.awt.Dimension(1176, 860));
        Pnl_Cuestionario14.setPreferredSize(new java.awt.Dimension(1176, 860));
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
        Pnl_Cuestionario14.add(Btn_Anterior_PrimerosAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 760, 254, 64));

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
        Pnl_Cuestionario14.add(Btn_Siguiente_EjercicioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 760, 254, 64));

        Lbl_Cuestionario14.setFont(sRecursos.getFLabels());
        Lbl_Cuestionario14.setText("14. Primeros Algoritmos | Cuestionario");
        Lbl_Cuestionario14.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_Cuestionario14.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario14.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_Cuestionario14.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Cuestionario14.add(Lbl_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 610, 45));

        Bgr_Question1.add(Rad_Question13_1);
        Rad_Question13_1.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question13_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 183, -1, -1));

        Bgr_Question1.add(Rad_Question10_7);
        Rad_Question10_7.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question10_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 163, -1, -1));

        Bgr_Question1.add(Rad_Question2_21);
        Rad_Question2_21.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question2_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 203, -1, -1));

        Bgr_Question1.add(Rad_Question11_4);
        Rad_Question11_4.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question11_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 143, -1, -1));

        Bgr_Question2.add(Rad_Question10_8);
        Rad_Question10_8.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question10_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        Bgr_Question2.add(Rad_Question11_5);
        Rad_Question11_5.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question11_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        Bgr_Question2.add(Rad_Question13_2);
        Rad_Question13_2.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question13_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        Bgr_Question2.add(Rad_Question10_2_3);
        Rad_Question10_2_3.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question10_2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        Bgr_Question3.add(Rad_Question11_6);
        Rad_Question11_6.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question11_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 495, -1, -1));

        Bgr_Question3.add(Rad_Question13_3);
        Rad_Question13_3.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question13_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 475, -1, -1));

        Bgr_Question3.add(Rad_Question10_3_3);
        Rad_Question10_3_3.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question10_3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 515, -1, -1));

        Bgr_Question3.add(Rad_Question3_19);
        Rad_Question3_19.setOpaque(false);
        Pnl_Cuestionario14.add(Rad_Question3_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 455, -1, -1));

        Btn_Answer13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOff.png"))); // NOI18N
        Btn_Answer13.setBorderPainted(false);
        Btn_Answer13.setContentAreaFilled(false);
        Btn_Answer13.setFocusPainted(false);
        Btn_Answer13.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Aprender/VerificarRespuestaOn.png"))); // NOI18N
        Btn_Answer13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Answer13ActionPerformed(evt);
            }
        });
        Pnl_Cuestionario14.add(Btn_Answer13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 260, 50));

        EdtCuestionario14.setContentType("text/html"); // NOI18N
        EdtCuestionario14.setOpaque(false);
        Pnl_Cuestionario14.add(EdtCuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 800, 450));

        Scp_Cuestionario14.setViewportView(Pnl_Cuestionario14);

        Pnl_Temas.add(Scp_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Scp_Ejercicio3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Ejercicio3.setMaximumSize(sRecursos.getDTamanio());
        Scp_Ejercicio3.setMinimumSize(sRecursos.getDTamanio());
        Scp_Ejercicio3.setPreferredSize(sRecursos.getDTamanio());

        Pnl_Ejercicio3_Aprender.setBackground(sRecursos.getCPrincipal());
        Pnl_Ejercicio3_Aprender.setCursor(sRecursos.getCDefault());
        Pnl_Ejercicio3_Aprender.setMaximumSize(new java.awt.Dimension(1176, 1290));
        Pnl_Ejercicio3_Aprender.setMinimumSize(new java.awt.Dimension(1176, 1290));
        Pnl_Ejercicio3_Aprender.setPreferredSize(new java.awt.Dimension(1176, 1290));
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
        Pnl_Ejercicio3_Aprender.add(Btn_Anterior_Cuestionario14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1190, 254, 64));

        Lbl_EjercicioFinal.setFont(sRecursos.getFLabels());
        Lbl_EjercicioFinal.setText("Ejercicio Final");
        Lbl_EjercicioFinal.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Lbl_EjercicioFinal.setMaximumSize(sRecursos.getDLbls_Temas());
        Lbl_EjercicioFinal.setMinimumSize(sRecursos.getDLbls_Temas());
        Lbl_EjercicioFinal.setPreferredSize(sRecursos.getDLbls_Temas());
        Pnl_Ejercicio3_Aprender.add(Lbl_EjercicioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, -1, -1));

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
        Pnl_Ejercicio3_Aprender.add(Btn_EnviarEjercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 730, 170, 50));

        Pnl_SyntaxEjercicio3.setBackground(new java.awt.Color(204, 204, 204));
        Pnl_SyntaxEjercicio3.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorVerde(), 2, true));
        Pnl_SyntaxEjercicio3.setLayout(new java.awt.CardLayout());
        Pnl_Ejercicio3_Aprender.add(Pnl_SyntaxEjercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 790, 1080, 330));

        Edt_Ejercicio3.setBackground(sRecursos.getCPrincipal());
        Edt_Ejercicio3.setContentType("text/html"); // NOI18N
        Edt_Ejercicio3.setOpaque(false);
        Pnl_Ejercicio3_Aprender.add(Edt_Ejercicio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1120, 580));

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
        Pnl_Introduccion.setPreferredSize(new java.awt.Dimension(1176, 1750));
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
        Pnl_Introduccion.add(Btn_Introduccion_Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 1650, 254, 64));

        Edt_Introduccion.setBackground(sRecursos.getCPrincipal());
        Edt_Introduccion.setBorder(null);
        Edt_Introduccion.setContentType("text/html"); // NOI18N
        Pnl_Introduccion.add(Edt_Introduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1120, 1500));

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

        Scp_General.setOpaque(false);

        Pnl_ExerciseInfo.setInheritsPopupMenu(true);
        Pnl_ExerciseInfo.setMaximumSize(new java.awt.Dimension(1060, 3000));

        Edt_General_info.setBackground(sRecursos.getCPrincipal());
        Edt_General_info.setBorder(null);
        Edt_General_info.setContentType("text/html"); // NOI18N
        Edt_General_info.setMaximumSize(new java.awt.Dimension(1060, 3000));
        Edt_General_info.setMinimumSize(new java.awt.Dimension(1060, 820));
        Edt_General_info.setPreferredSize(new java.awt.Dimension(1060, 820));

        javax.swing.GroupLayout Pnl_ExerciseInfoLayout = new javax.swing.GroupLayout(Pnl_ExerciseInfo);
        Pnl_ExerciseInfo.setLayout(Pnl_ExerciseInfoLayout);
        Pnl_ExerciseInfoLayout.setHorizontalGroup(
            Pnl_ExerciseInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Edt_General_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Pnl_ExerciseInfoLayout.setVerticalGroup(
            Pnl_ExerciseInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Edt_General_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Scp_General.setViewportView(Pnl_ExerciseInfo);

        Pnl_EjercicioFull.add(Scp_General, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1080, 440));

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

        Scp_ContenidoHistoria.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_ContenidoHistoria.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Scp_ContenidoHistoria.setOpaque(false);

        Pnl_ContenidoHistoria.setBackground(sRecursos.getCPrincipal());
        Pnl_ContenidoHistoria.setMaximumSize(new java.awt.Dimension(1176, 4600));
        Pnl_ContenidoHistoria.setMinimumSize(new java.awt.Dimension(1176, 4600));
        Pnl_ContenidoHistoria.setPreferredSize(new java.awt.Dimension(1176, 4600));
        Pnl_ContenidoHistoria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Edt_ContenidoHistoria.setBackground(sRecursos.getCPrincipal());
        Edt_ContenidoHistoria.setContentType("text/html"); // NOI18N
        Pnl_ContenidoHistoria.add(Edt_ContenidoHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1120, 4530));

        Scp_ContenidoHistoria.setViewportView(Pnl_ContenidoHistoria);

        Pnl_Pagina1.add(Scp_ContenidoHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1176, 605));

        Pnl_Historia.add(Pnl_Pagina1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 705));

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
            shutDownSection(3);
            enableCodeStormButtons();

            // Paneles Internos
            Pnl_CodeStorm.setVisible(true);
            Pnl_ListadoEjercicios.setVisible(true);
            Scp_Introduccion.setVisible(false);
            Pnl_General.setVisible(false);

            // Desactivar Paneles Principales
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

            shutDownSection(1);
            enableLearnButtons();
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
            new CodeEditor().setVisible(true);
        }
    }//GEN-LAST:event_Btn_ProgramarActionPerformed

    private void Btn_HistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_HistoriaActionPerformed
        if (Btn_Historia.isSelected()) {
            shutDownSection(4);
            enableHistoryButtons();
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

    private void Btn_Aprender_Tema1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema1ActionPerformed
        tc.getHelloWorldContent(Edt0_1, Edt0_2, syntaxTemas0);
        Scp_Tema1.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema1ActionPerformed

    private void Btn_Aprender_Tema2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema2ActionPerformed
        tc.getComentariosContent(syntaxTemas1_1, syntaxTemas1_2, syntaxTemas1_3, Edt1_1,
                Edt1_2, Edt1_3, Edt1_4);
        Scp_Tema2.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema2ActionPerformed

    private void Btn_Aprender_Tema3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema3ActionPerformed
        tc.getTiposDeDatosContent(syntaxTemas2, Edt2_1, Edt2_2);
        Scp_Tema3.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema3ActionPerformed

    private void Btn_Aprender_Tema4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema4ActionPerformed
        tc.getOperadoresAritmeticosContent(syntaxTemas3_1, syntaxTemas3_2, syntaxTemas3_3,
                syntaxTemas3_4, syntaxTemas3_5, Edt3_1, Edt3_2, Edt3_3, Edt3_4, Edt3_5, Edt3_6,
                Edt3_7, Edt3_8);
        Scp_Tema4.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema4ActionPerformed

    private void Btn_Aprender_Tema5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema5ActionPerformed
        tc.getLecturaContent(syntaxTemas4, Edt4_1, Edt4_2);
        Scp_Tema5.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema5ActionPerformed


    private void Btn_Aprender_Tema6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema6ActionPerformed
        tc.getOperadoresDeRelacion(syntaxTemas5, Edt5_1, Edt5_2, Edt5_3);
        Scp_Tema6.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema6ActionPerformed

    private void Btn_Aprender_Tema7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema7ActionPerformed
        tc.getOperadoresLogicos(syntaxTemas6, Edt6_1, Edt6_2, Edt6_3);
        Scp_Tema7.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema7ActionPerformed

    private void Btn_Aprender_Tema8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema8ActionPerformed
        tc.getCondicionalesContent(syntaxTemas7_1, syntaxTemas7_2, syntaxTemas7_3,
                syntaxTemas7_4, syntaxTemas7_5, syntaxTemas7_6, syntaxTemas7_7,
                syntaxTemas7_8, syntaxTemas7_9, syntaxTemas7_10, Edt7_1, Edt7_2,
                Edt7_3, Edt7_4, Edt7_5, Edt7_6, Edt7_7, Edt7_8, Edt7_9, Edt7_10);
        Scp_Tema8.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema8ActionPerformed

    private void Btn_Aprender_Tema9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema9ActionPerformed
        tc.getBuclesContent(syntaxTemas8_1, syntaxTemas8_2, syntaxTemas8_3,
                syntaxTemas8_4, syntaxTemas8_5, syntaxTemas8_6, Edt8_1, Edt8_2,
                Edt8_3, Edt8_4, Edt8_5, Edt8_6, Edt8_7);
        Scp_Tema9.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema9ActionPerformed

    private void Btn_Aprender_Tema10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema10ActionPerformed
        tc.getFuncyProcedContent(syntaxTemas9_1, syntaxTemas9_2, Edt9_1, Edt9_2, Edt9_3);
        Scp_Tema10.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema10ActionPerformed

    private void Btn_Aprender_Tema11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema11ActionPerformed
        tc.getRecursionContent(syntaxTemas10_1, syntaxTemas10_2, Edt10_1, Edt10_2, Edt10_3);
        Scp_Tema11.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema11ActionPerformed

    private void Btn_Aprender_Tema12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema12ActionPerformed
        tc.getEstructBasicasContent(new RSyntaxTextArea[]{syntaxTemas11_1, syntaxTemas11_2,
            syntaxTemas11_3, syntaxTemas11_4, syntaxTemas11_5, syntaxTemas11_6, syntaxTemas11_7,
            syntaxTemas11_8}, new JEditorPane[]{Edt11_1, Edt11_2, Edt11_3, Edt11_4, Edt11_5, Edt11_6,
            Edt11_7, Edt11_8, Edt11_9, Edt11_10, Edt11_11, Edt11_12, Edt11_13, Edt11_14});
        Scp_Tema12.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema12ActionPerformed

    private void Btn_Aprender_Tema13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema13ActionPerformed
        tc.getEstructIntermediasContent(syntaxTemas12_1, syntaxTemas12_2, syntaxTemas12_3,
                syntaxTemas12_4, Edt12_1, Edt12_2, Edt12_3, Edt12_4, Edt12_5, Edt12_6,
                Edt12_7, Edt12_8, Edt12_9, Edt12_10, Edt12_11);
        Scp_Tema13.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema13ActionPerformed

    private void Btn_Aprender_Tema14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Tema14ActionPerformed
        tc.getAlgoritmosContent(syntaxTemas13_1, syntaxTemas13_2, Edt13_1, Edt13_2,
                Edt13_3, Edt13_4, Edt13_5, Edt13_6);
        Scp_Tema14.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Tema14ActionPerformed

    private void Btn_Siguiente_Cuestionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario1ActionPerformed
        addInfoQuestionnaires(EdtCuestionario1, 0, 1, 2);
        visibleAndInvisibleScp(Scp_Cuestionario1, Scp_Tema1);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario1ActionPerformed

    private void addInfoQuestionnaires(JEditorPane edt, int q1, int q2, int q3) {
        tc.addHTML(t.getQuestionnairesTemplate(), edt,
                qList.get(q1).getQuestionContent(),
                qList.get(q1).getQuestionOptions(),
                qList.get(q2).getQuestionContent(),
                qList.get(q2).getQuestionOptions(),
                qList.get(q3).getQuestionContent(),
                qList.get(q3).getQuestionOptions());
    }

    private void HistoryContent() {
        tc.getHistoryContent(Edt_ContenidoHistoria);
    }

    private void IntroductionContent() {
        tc.addHTML(t.getIntroductionTemplate(), Edt_Introduccion);
    }

    private void visibleAndInvisibleScp(JScrollPane scp1, JScrollPane scp2) {
        scp1.setVisible(true);
        scp2.setVisible(false);
    }

    private void Btn_Anterior_HelloWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_HelloWordActionPerformed
        tc.getHelloWorldContent(Edt0_1, Edt0_2, syntaxCode);
        visibleAndInvisibleScp(Scp_Tema1, Scp_Cuestionario1);
    }//GEN-LAST:event_Btn_Anterior_HelloWordActionPerformed

    private void Btn_Siguiente_ComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_ComentariosActionPerformed
        tc.getComentariosContent(syntaxTemas1_1, syntaxTemas1_2, syntaxTemas1_3, Edt1_1, Edt1_2, Edt1_3, Edt1_4);
        visibleAndInvisibleScp(Scp_Tema2, Scp_Cuestionario1);
    }//GEN-LAST:event_Btn_Siguiente_ComentariosActionPerformed

    private void Btn_Anterior_Cuestionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario1ActionPerformed
        addInfoQuestionnaires(EdtCuestionario1, 0, 1, 2);
        visibleAndInvisibleScp(Scp_Cuestionario1, Scp_Tema2);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario1ActionPerformed

    private void Btn_Siguiente_Cuestionario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario2ActionPerformed
        addInfoQuestionnaires(EdtCuestionario2, 3, 4, 5);
        visibleAndInvisibleScp(Scp_Cuestionario2, Scp_Tema2);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario2ActionPerformed

    private void Btn_Anterior_ComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_ComentariosActionPerformed
        tc.getComentariosContent(syntaxTemas1_1, syntaxTemas1_2, syntaxTemas1_3, Edt1_1,
                Edt1_2, Edt1_3, Edt1_4);
        visibleAndInvisibleScp(Scp_Tema2, Scp_Cuestionario2);
    }//GEN-LAST:event_Btn_Anterior_ComentariosActionPerformed

    private void Btn_Siguiente_TiposdeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_TiposdeDatosActionPerformed
        tc.getTiposDeDatosContent(syntaxTemas2, Edt2_1, Edt2_2);
        visibleAndInvisibleScp(Scp_Tema3, Scp_Cuestionario2);
    }//GEN-LAST:event_Btn_Siguiente_TiposdeDatosActionPerformed

    private void Btn_Anterior_Cuestionario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario2ActionPerformed
        addInfoQuestionnaires(EdtCuestionario2, 3, 4, 5);
        visibleAndInvisibleScp(Scp_Cuestionario2, Scp_Tema3);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario2ActionPerformed

    private void Btn_Siguiente_Cuestionario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario3ActionPerformed
        addInfoQuestionnaires(EdtCuestionario3, 6, 7, 8);
        visibleAndInvisibleScp(Scp_Cuestionario3, Scp_Tema3);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario3ActionPerformed

    private void Btn_Anterior_TiposdeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_TiposdeDatosActionPerformed
        tc.getTiposDeDatosContent(syntaxTemas2, Edt2_1, Edt2_2);
        visibleAndInvisibleScp(Scp_Tema3, Scp_Cuestionario3);
    }//GEN-LAST:event_Btn_Anterior_TiposdeDatosActionPerformed

    private void Btn_Siguiente_OperadoresAritmeticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_OperadoresAritmeticosActionPerformed
        tc.getOperadoresAritmeticosContent(syntaxTemas3_1, syntaxTemas3_2, syntaxTemas3_3, syntaxTemas3_4,
                syntaxTemas3_5, Edt3_1, Edt3_2, Edt3_3, Edt3_4, Edt3_5, Edt3_6, Edt3_7, Edt3_8);
        visibleAndInvisibleScp(Scp_Tema4, Scp_Cuestionario3);
    }//GEN-LAST:event_Btn_Siguiente_OperadoresAritmeticosActionPerformed

    private void Btn_Anterior_Cuestionario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario3ActionPerformed
        addInfoQuestionnaires(EdtCuestionario3, 6, 7, 8);
        visibleAndInvisibleScp(Scp_Cuestionario3, Scp_Tema4);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario3ActionPerformed

    private void Btn_Siguiente_Cuestionario4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario4ActionPerformed
        addInfoQuestionnaires(EdtCuestionario4, 9, 10, 11);
        visibleAndInvisibleScp(Scp_Cuestionario4, Scp_Tema4);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario4ActionPerformed

    private void Btn_Anterior_OperadoresAritmeticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_OperadoresAritmeticosActionPerformed
        tc.getOperadoresAritmeticosContent(syntaxTemas3_1, syntaxTemas3_2, syntaxTemas3_3, syntaxTemas3_4,
                syntaxTemas3_5, Edt3_1, Edt3_2, Edt3_3, Edt3_4, Edt3_5, Edt3_6, Edt3_7, Edt3_8);
        visibleAndInvisibleScp(Scp_Tema4, Scp_Cuestionario4);
    }//GEN-LAST:event_Btn_Anterior_OperadoresAritmeticosActionPerformed

    private void Btn_Siguiente_LecturaeImpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_LecturaeImpresionActionPerformed
        tc.getLecturaContent(syntaxTemas4, Edt4_1, Edt4_2);
        visibleAndInvisibleScp(Scp_Tema5, Scp_Cuestionario4);
    }//GEN-LAST:event_Btn_Siguiente_LecturaeImpresionActionPerformed

    private void Btn_Anterior_Cuestionario4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario4ActionPerformed
        addInfoQuestionnaires(EdtCuestionario4, 9, 10, 11);
        visibleAndInvisibleScp(Scp_Cuestionario4, Scp_Tema5);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario4ActionPerformed

    private void Btn_Siguiente_Cuestionario5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario5ActionPerformed
        addInfoQuestionnaires(EdtCuestionario5, 13, 14, 15);
        visibleAndInvisibleScp(Scp_Cuestionario5, Scp_Tema5);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario5ActionPerformed

    // Cargar las variables y configuracion del listado de botones en CodeStorm
    private void configureExerciseButton(JPanel main, int cont, int aux) {
        main.setVisible(true);
        this.cont = cont;
        ex.setCounter(cont);
        this.aux = aux;
        validateActiveExcercise();
        ON_OFF_CodeStormPanels();
        getAndPublicInfo();
        verifySolutionStatus();
    }

    private void Btn_Nivel1_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel1_Ejercicio1ActionPerformed
        configureExerciseButton(Pnl_Main, 0, 1);
    }//GEN-LAST:event_Btn_Nivel1_Ejercicio1ActionPerformed

    private void Btn_Nivel1_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel1_Ejercicio2ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 1, 2);
    }//GEN-LAST:event_Btn_Nivel1_Ejercicio2ActionPerformed

    private void Btn_Nivel1_Ejercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel1_Ejercicio3ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 2, 3);
    }//GEN-LAST:event_Btn_Nivel1_Ejercicio3ActionPerformed

    private void Btn_Nivel1_Ejercicio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel1_Ejercicio4ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 3, 4);
    }//GEN-LAST:event_Btn_Nivel1_Ejercicio4ActionPerformed

    private void Btn_IntroduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_IntroduccionActionPerformed
        Scp_Introduccion.setVisible(true);
        Pnl_ListadoEjercicios.setVisible(false);
    }//GEN-LAST:event_Btn_IntroduccionActionPerformed

    private void Btn_Nivel2_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel2_Ejercicio1ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 4, 1);
    }//GEN-LAST:event_Btn_Nivel2_Ejercicio1ActionPerformed

    private void Btn_Nivel2_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel2_Ejercicio2ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 5, 2);
    }//GEN-LAST:event_Btn_Nivel2_Ejercicio2ActionPerformed

    private void Btn_Nivel2_Ejercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel2_Ejercicio3ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 6, 3);
    }//GEN-LAST:event_Btn_Nivel2_Ejercicio3ActionPerformed

    private void Btn_Nivel2_Ejercicio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel2_Ejercicio4ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 7, 4);
    }//GEN-LAST:event_Btn_Nivel2_Ejercicio4ActionPerformed

    private void Btn_Nivel3_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel3_Ejercicio1ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 8, 1);
    }//GEN-LAST:event_Btn_Nivel3_Ejercicio1ActionPerformed

    private void Btn_Nivel3_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel3_Ejercicio2ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 9, 2);
    }//GEN-LAST:event_Btn_Nivel3_Ejercicio2ActionPerformed

    private void Btn_Nivel3_Ejercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel3_Ejercicio3ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 10, 3);
    }//GEN-LAST:event_Btn_Nivel3_Ejercicio3ActionPerformed

    private void Btn_Nivel3_Ejercicio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel3_Ejercicio4ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 11, 4);
    }//GEN-LAST:event_Btn_Nivel3_Ejercicio4ActionPerformed

    private void Btn_Nivel4_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel4_Ejercicio1ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 12, 1);
    }//GEN-LAST:event_Btn_Nivel4_Ejercicio1ActionPerformed

    private void Btn_Nivel4_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel4_Ejercicio2ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 13, 2);
    }//GEN-LAST:event_Btn_Nivel4_Ejercicio2ActionPerformed

    private void Btn_Nivel4_Ejercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel4_Ejercicio3ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 14, 3);
    }//GEN-LAST:event_Btn_Nivel4_Ejercicio3ActionPerformed

    private void Btn_Nivel4_Ejercicio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel4_Ejercicio4ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 15, 4);
    }//GEN-LAST:event_Btn_Nivel4_Ejercicio4ActionPerformed

    private void Btn_Nivel5_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel5_Ejercicio1ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 16, 1);
    }//GEN-LAST:event_Btn_Nivel5_Ejercicio1ActionPerformed

    private void Btn_Nivel5_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel5_Ejercicio2ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 17, 2);
    }//GEN-LAST:event_Btn_Nivel5_Ejercicio2ActionPerformed

    private void Btn_Nivel5_Ejercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel5_Ejercicio3ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 18, 3);
    }//GEN-LAST:event_Btn_Nivel5_Ejercicio3ActionPerformed

    private void Btn_Nivel5_Ejercicio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Nivel5_Ejercicio4ActionPerformed
        configureExerciseButton(Pnl_EjercicioFull, 19, 4);
    }//GEN-LAST:event_Btn_Nivel5_Ejercicio4ActionPerformed

    private void Btn_EjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EjercicioActionPerformed
        Pnl_CodigoFull.setVisible(false);
        Pnl_EjercicioFull.setVisible(true);
        Pnl_SolucionFull.setVisible(false);
        validateCodeStormButtons(0);
    }//GEN-LAST:event_Btn_EjercicioActionPerformed

    private void Btn_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EnviarActionPerformed
        String code = syntaxCode.getText();
        String id = "input" + (cont + 1);
        try {
            juzgador(id, code, "judge", "iofiles", Integer.toString(cont + 1), ex.getCounter(), emf);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        Btn_Enviar.setSelected(false);
        emf = ex.regenerateConnectionUpdatep();
        System.out.println(ex.getCounter());
        System.out.println(ex.getStatus());
        verifySolutionStatus();
    }//GEN-LAST:event_Btn_EnviarActionPerformed

    private void Btn_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CodigoActionPerformed
        Pnl_CodigoFull.setVisible(true);
        Pnl_EjercicioFull.setVisible(false);
        Pnl_SolucionFull.setVisible(false);
        validateCodeStormButtons(1);
    }//GEN-LAST:event_Btn_CodigoActionPerformed

    private void Btn_SolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SolucionActionPerformed
        Pnl_CodigoFull.setVisible(false);
        Pnl_EjercicioFull.setVisible(false);
        Pnl_SolucionFull.setVisible(true);
        validateCodeStormButtons(2);
    }//GEN-LAST:event_Btn_SolucionActionPerformed

    private void Btn_AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AnteriorActionPerformed
        int tmp = ex.getCounter();
        ex.setCounter(--tmp);
        initializeCodeStormButtons();
        cont--;
        aux--;
        validateActiveExcercise();
        getAndPublicInfo();
        if (cont == 0) {
            Btn_Anterior.setEnabled(false);
        } else {
            Btn_Siguiente.setEnabled(true);
        }
        verifySolutionStatus();
        syntaxCode.setText("//Pega aquí tú código...");
    }//GEN-LAST:event_Btn_AnteriorActionPerformed

    private void Btn_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SiguienteActionPerformed
        int tmp = ex.getCounter();
        ex.setCounter(++tmp);
        initializeCodeStormButtons();
        cont++;
        aux++;
        validateActiveExcercise();
        getAndPublicInfo();
        if (cont == 19) {
            Btn_Siguiente.setEnabled(false);
        } else {
            Btn_Anterior.setEnabled(true);
        }
        verifySolutionStatus();
        syntaxCode.setText("//Pega aqui tú código...");
    }//GEN-LAST:event_Btn_SiguienteActionPerformed

    private void Btn_Introduccion_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Introduccion_SiguienteActionPerformed
        Scp_Introduccion.setVisible(false);
        configureExerciseButton(Pnl_Main, 0, 1);
    }//GEN-LAST:event_Btn_Introduccion_SiguienteActionPerformed

    private void Btn_Anterior_LecturaeImpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_LecturaeImpresionActionPerformed
        tc.getLecturaContent(syntaxTemas4, Edt4_1, Edt4_2);
        visibleAndInvisibleScp(Scp_Tema5, Scp_Cuestionario5);
    }//GEN-LAST:event_Btn_Anterior_LecturaeImpresionActionPerformed

    private void Btn_Siguiente_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Ejercicio1ActionPerformed
        tc.getExer1LearnContent(Edt_Ejercicio1);
        visibleAndInvisibleScp(Scp_Ejercicio1, Scp_Cuestionario5);
    }//GEN-LAST:event_Btn_Siguiente_Ejercicio1ActionPerformed

    private void Btn_Anterior_Ejercicio1_PrincipianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Ejercicio1_PrincipianteActionPerformed
        tc.getExer1LearnContent(Edt_Ejercicio1);
        visibleAndInvisibleScp(Scp_Ejercicio1, Scp_Tema6);
    }//GEN-LAST:event_Btn_Anterior_Ejercicio1_PrincipianteActionPerformed

    private void Btn_Siguiente_Cuestionario6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario6ActionPerformed
        addInfoQuestionnaires(EdtCuestionario6, 18, 19, 20);
        visibleAndInvisibleScp(Scp_Cuestionario6, Scp_Tema6);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario6ActionPerformed

    private void Btn_Anterior_OperadoresdeRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_OperadoresdeRelacionActionPerformed
        tc.getOperadoresDeRelacion(syntaxTemas5, Edt5_1, Edt5_2, Edt5_3);
        visibleAndInvisibleScp(Scp_Tema6, Scp_Cuestionario6);
    }//GEN-LAST:event_Btn_Anterior_OperadoresdeRelacionActionPerformed

    private void Btn_Siguiente_OperadoresLogicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_OperadoresLogicosActionPerformed
        tc.getOperadoresLogicos(syntaxTemas6, Edt6_1, Edt6_2, Edt6_3);
        visibleAndInvisibleScp(Scp_Tema7, Scp_Cuestionario6);
    }//GEN-LAST:event_Btn_Siguiente_OperadoresLogicosActionPerformed

    private void Btn_Anterior_Cuestionario6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario6ActionPerformed
        addInfoQuestionnaires(EdtCuestionario6, 18, 19, 20);
        visibleAndInvisibleScp(Scp_Cuestionario6, Scp_Tema7);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario6ActionPerformed

    private void Btn_Siguiente_Cuestionario7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario7ActionPerformed
        addInfoQuestionnaires(EdtCuestionario7, 21, 22, 23);
        visibleAndInvisibleScp(Scp_Cuestionario7, Scp_Tema7);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario7ActionPerformed

    private void Btn_Anterior_OperadoresLogicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_OperadoresLogicosActionPerformed
        tc.getOperadoresLogicos(syntaxTemas6, Edt6_1, Edt6_2, Edt6_3);
        visibleAndInvisibleScp(Scp_Tema7, Scp_Cuestionario7);
    }//GEN-LAST:event_Btn_Anterior_OperadoresLogicosActionPerformed

    private void Btn_Siguiente_CondicionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_CondicionalesActionPerformed
        tc.getCondicionalesContent(syntaxTemas7_1, syntaxTemas7_2, syntaxTemas7_3,
                syntaxTemas7_4, syntaxTemas7_5, syntaxTemas7_6, syntaxTemas7_7,
                syntaxTemas7_8, syntaxTemas7_9, syntaxTemas7_10, Edt7_1, Edt7_2,
                Edt7_3, Edt7_4, Edt7_5, Edt7_6, Edt7_7, Edt7_8, Edt7_9, Edt7_10);
        visibleAndInvisibleScp(Scp_Tema8, Scp_Cuestionario7);
    }//GEN-LAST:event_Btn_Siguiente_CondicionalesActionPerformed

    private void Btn_Anterior_Cuestionario7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario7ActionPerformed
        addInfoQuestionnaires(EdtCuestionario7, 21, 22, 23);
        visibleAndInvisibleScp(Scp_Cuestionario7, Scp_Tema8);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario7ActionPerformed

    private void Btn_Siguiente_Cuestionario8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario8ActionPerformed
        addInfoQuestionnaires(EdtCuestionario8, 24, 25, 26);
        visibleAndInvisibleScp(Scp_Cuestionario8, Scp_Tema8);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario8ActionPerformed

    private void Btn_Anterior_CondicionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_CondicionalesActionPerformed
        tc.getCondicionalesContent(syntaxTemas7_1, syntaxTemas7_2, syntaxTemas7_3,
                syntaxTemas7_4, syntaxTemas7_5, syntaxTemas7_6, syntaxTemas7_7,
                syntaxTemas7_8, syntaxTemas7_9, syntaxTemas7_10, Edt7_1, Edt7_2,
                Edt7_3, Edt7_4, Edt7_5, Edt7_6, Edt7_7, Edt7_8, Edt7_9, Edt7_10);
        visibleAndInvisibleScp(Scp_Tema8, Scp_Cuestionario8);
    }//GEN-LAST:event_Btn_Anterior_CondicionalesActionPerformed

    private void Btn_Siguiente_BuclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_BuclesActionPerformed
        tc.getBuclesContent(syntaxTemas8_1, syntaxTemas8_2, syntaxTemas8_3,
                syntaxTemas8_4, syntaxTemas8_5, syntaxTemas8_6, Edt8_1, Edt8_2,
                Edt8_3, Edt8_4, Edt8_5, Edt8_6, Edt8_7);
        visibleAndInvisibleScp(Scp_Tema9, Scp_Cuestionario8);
    }//GEN-LAST:event_Btn_Siguiente_BuclesActionPerformed

    private void Btn_Anterior_Cuestionario8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario8ActionPerformed
        addInfoQuestionnaires(EdtCuestionario8, 24, 25, 26);
        visibleAndInvisibleScp(Scp_Cuestionario8, Scp_Tema9);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario8ActionPerformed

    private void Btn_Siguiente_Cuestionario9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario9ActionPerformed
        addInfoQuestionnaires(EdtCuestionario9, 27, 28, 29);
        visibleAndInvisibleScp(Scp_Cuestionario9, Scp_Tema9);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario9ActionPerformed

    private void Btn_Anterior_BuclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_BuclesActionPerformed
        tc.getBuclesContent(syntaxTemas8_1, syntaxTemas8_2, syntaxTemas8_3,
                syntaxTemas8_4, syntaxTemas8_5, syntaxTemas8_6, Edt8_1, Edt8_2,
                Edt8_3, Edt8_4, Edt8_5, Edt8_6, Edt8_7);
        visibleAndInvisibleScp(Scp_Tema9, Scp_Cuestionario9);
    }//GEN-LAST:event_Btn_Anterior_BuclesActionPerformed

    private void Btn_Siguiente_Ejercicio2_IntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Ejercicio2_IntermedioActionPerformed
        tc.getExer2LearnContent(Edt_Ejercicio2);
        visibleAndInvisibleScp(Scp_Ejercicio2, Scp_Cuestionario9);
    }//GEN-LAST:event_Btn_Siguiente_Ejercicio2_IntermedioActionPerformed

    private void Btn_Anterior_Ejercicio2_IntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Ejercicio2_IntermedioActionPerformed
        tc.getExer2LearnContent(Edt_Ejercicio2);
        visibleAndInvisibleScp(Scp_Ejercicio2, Scp_Tema10);
    }//GEN-LAST:event_Btn_Anterior_Ejercicio2_IntermedioActionPerformed

    private void Btn_Siguiente_Cuestionario10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario10ActionPerformed
        addInfoQuestionnaires(EdtCuestionario10, 32, 33, 34);
        visibleAndInvisibleScp(Scp_Cuestionario10, Scp_Tema10);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario10ActionPerformed

    private void Btn_Anterior_FuncyProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_FuncyProcActionPerformed
        tc.getFuncyProcedContent(syntaxTemas9_1, syntaxTemas9_2, Edt9_1, Edt9_2, Edt9_3);
        visibleAndInvisibleScp(Scp_Tema10, Scp_Cuestionario10);
    }//GEN-LAST:event_Btn_Anterior_FuncyProcActionPerformed

    private void Btn_Siguiente_RecursionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_RecursionActionPerformed
        tc.getRecursionContent(syntaxTemas10_1, syntaxTemas10_2, Edt10_1, Edt10_2, Edt10_3);
        visibleAndInvisibleScp(Scp_Tema11, Scp_Cuestionario10);
    }//GEN-LAST:event_Btn_Siguiente_RecursionActionPerformed

    private void Btn_Anterior_Cuestionario10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario10ActionPerformed
        addInfoQuestionnaires(EdtCuestionario10, 32, 33, 34);
        visibleAndInvisibleScp(Scp_Cuestionario10, Scp_Tema11);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario10ActionPerformed

    private void Btn_Siguiente_Cuestionario11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario11ActionPerformed
        addInfoQuestionnaires(EdtCuestionario11, 35, 36, 37);
        visibleAndInvisibleScp(Scp_Cuestionario11, Scp_Tema11);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario11ActionPerformed

    private void Btn_Anterior_RecursionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_RecursionActionPerformed
        tc.getRecursionContent(syntaxTemas10_1, syntaxTemas10_2, Edt10_1, Edt10_2, Edt10_3);
        visibleAndInvisibleScp(Scp_Tema11, Scp_Cuestionario11);
    }//GEN-LAST:event_Btn_Anterior_RecursionActionPerformed

    private void Btn_Siguiente_EDDBasicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_EDDBasicasActionPerformed
        tc.getEstructBasicasContent(new RSyntaxTextArea[]{syntaxTemas11_1, syntaxTemas11_2,
            syntaxTemas11_3, syntaxTemas11_4, syntaxTemas11_5, syntaxTemas11_6, syntaxTemas11_7,
            syntaxTemas11_8}, new JEditorPane[]{Edt11_1, Edt11_2, Edt11_3, Edt11_4, Edt11_5, Edt11_6,
            Edt11_7, Edt11_8, Edt11_9, Edt11_10, Edt11_11, Edt11_12, Edt11_13, Edt11_14});
        visibleAndInvisibleScp(Scp_Tema12, Scp_Cuestionario11);
    }//GEN-LAST:event_Btn_Siguiente_EDDBasicasActionPerformed

    private void Btn_Anterior_Cuestionario11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario11ActionPerformed
        addInfoQuestionnaires(EdtCuestionario11, 35, 36, 37);
        visibleAndInvisibleScp(Scp_Cuestionario11, Scp_Tema12);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario11ActionPerformed

    private void Btn_Siguiente_Cuestionario12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario12ActionPerformed
        addInfoQuestionnaires(EdtCuestionario12, 38, 39, 40);
        visibleAndInvisibleScp(Scp_Cuestionario12, Scp_Tema12);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario12ActionPerformed

    private void Btn_Anterior_EDDBasicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_EDDBasicasActionPerformed
        tc.getEstructBasicasContent(new RSyntaxTextArea[]{syntaxTemas11_1, syntaxTemas11_2,
            syntaxTemas11_3, syntaxTemas11_4, syntaxTemas11_5, syntaxTemas11_6, syntaxTemas11_7,
            syntaxTemas11_8}, new JEditorPane[]{Edt11_1, Edt11_2, Edt11_3, Edt11_4, Edt11_5, Edt11_6,
            Edt11_7, Edt11_8, Edt11_9, Edt11_10, Edt11_11, Edt11_12, Edt11_13, Edt11_14});
        visibleAndInvisibleScp(Scp_Tema12, Scp_Cuestionario12);
    }//GEN-LAST:event_Btn_Anterior_EDDBasicasActionPerformed

    private void Btn_Siguiente_EDDIntermediasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_EDDIntermediasActionPerformed
        tc.getEstructIntermediasContent(syntaxTemas12_1, syntaxTemas12_2,
                syntaxTemas12_3, syntaxTemas12_4, Edt12_1, Edt12_2, Edt12_3,
                Edt12_4, Edt12_5, Edt12_6, Edt12_7, Edt12_8, Edt12_9, Edt12_10, Edt12_11);
        visibleAndInvisibleScp(Scp_Tema13, Scp_Cuestionario12);
    }//GEN-LAST:event_Btn_Siguiente_EDDIntermediasActionPerformed

    private void Btn_Anterior_Cuestionario12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario12ActionPerformed
        addInfoQuestionnaires(EdtCuestionario12, 38, 39, 40);
        visibleAndInvisibleScp(Scp_Cuestionario12, Scp_Tema13);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario12ActionPerformed

    private void Btn_Siguiente_Cuestionario13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario13ActionPerformed
        addInfoQuestionnaires(EdtCuestionario13, 41, 42, 43);
        visibleAndInvisibleScp(Scp_Cuestionario13, Scp_Tema13);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario13ActionPerformed

    private void Btn_Anterior_EDDIntermediasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_EDDIntermediasActionPerformed
        tc.getEstructIntermediasContent(syntaxTemas12_1, syntaxTemas12_2,
                syntaxTemas12_3, syntaxTemas12_4, Edt12_1, Edt12_2, Edt12_3,
                Edt12_4, Edt12_5, Edt12_6, Edt12_7, Edt12_8, Edt12_9, Edt12_10, Edt12_11);
        visibleAndInvisibleScp(Scp_Tema13, Scp_Cuestionario13);
    }//GEN-LAST:event_Btn_Anterior_EDDIntermediasActionPerformed

    private void Btn_Siguiente_PrimerosAlgoritmosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_PrimerosAlgoritmosActionPerformed
        tc.getAlgoritmosContent(syntaxTemas13_1, syntaxTemas13_2, Edt13_1, Edt13_2,
                Edt13_3, Edt13_4, Edt13_5, Edt13_6);
        visibleAndInvisibleScp(Scp_Tema14, Scp_Cuestionario13);
    }//GEN-LAST:event_Btn_Siguiente_PrimerosAlgoritmosActionPerformed

    private void Btn_Anterior_Cuestionario13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario13ActionPerformed
        addInfoQuestionnaires(EdtCuestionario13, 41, 42, 43);
        visibleAndInvisibleScp(Scp_Cuestionario13, Scp_Tema14);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario13ActionPerformed

    private void Btn_Siguiente_Cuestionario14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_Cuestionario14ActionPerformed
        addInfoQuestionnaires(EdtCuestionario14, 46, 47, 48);
        visibleAndInvisibleScp(Scp_Cuestionario14, Scp_Tema14);
    }//GEN-LAST:event_Btn_Siguiente_Cuestionario14ActionPerformed

    private void Btn_Anterior_PrimerosAlgoritmosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_PrimerosAlgoritmosActionPerformed
        tc.getAlgoritmosContent(syntaxTemas13_1, syntaxTemas13_2, Edt13_1, Edt13_2,
                Edt13_3, Edt13_4, Edt13_5, Edt13_6);
        visibleAndInvisibleScp(Scp_Tema14, Scp_Cuestionario14);
    }//GEN-LAST:event_Btn_Anterior_PrimerosAlgoritmosActionPerformed

    private void Btn_Siguiente_EjercicioFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_EjercicioFinalActionPerformed
        tc.getExer3LearnContent(Edt_Ejercicio3);
        visibleAndInvisibleScp(Scp_Ejercicio3, Scp_Cuestionario14);
    }//GEN-LAST:event_Btn_Siguiente_EjercicioFinalActionPerformed

    private void Btn_Anterior_Cuestionario5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario5ActionPerformed
        addInfoQuestionnaires(EdtCuestionario5, 13, 14, 15);
        visibleAndInvisibleScp(Scp_Cuestionario5, Scp_Ejercicio1);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario5ActionPerformed

    private void Btn_Siguiente_OperadoresdeRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_OperadoresdeRelacionActionPerformed
        tc.getOperadoresDeRelacion(syntaxTemas5, Edt5_1, Edt5_2, Edt5_3);
        visibleAndInvisibleScp(Scp_Tema6, Scp_Ejercicio1);
    }//GEN-LAST:event_Btn_Siguiente_OperadoresdeRelacionActionPerformed

    private void Btn_Anterior_Cuestionario9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario9ActionPerformed
        addInfoQuestionnaires(EdtCuestionario9, 27, 28, 29);
        visibleAndInvisibleScp(Scp_Cuestionario9, Scp_Ejercicio2);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario9ActionPerformed

    private void Btn_Siguiente_FuncionesyProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Siguiente_FuncionesyProcActionPerformed
        tc.getFuncyProcedContent(syntaxTemas9_1, syntaxTemas9_2, Edt9_1, Edt9_2, Edt9_3);
        visibleAndInvisibleScp(Scp_Tema10, Scp_Ejercicio2);
    }//GEN-LAST:event_Btn_Siguiente_FuncionesyProcActionPerformed

    private void Btn_Anterior_Cuestionario14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Anterior_Cuestionario14ActionPerformed
        addInfoQuestionnaires(EdtCuestionario14, 46, 47, 48);
        visibleAndInvisibleScp(Scp_Cuestionario14, Scp_Ejercicio3);
    }//GEN-LAST:event_Btn_Anterior_Cuestionario14ActionPerformed

    private void Btn_Aprender_Ejercicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Ejercicio1ActionPerformed
        tc.getExer1LearnContent(Edt_Ejercicio1);
        Scp_Ejercicio1.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Ejercicio1ActionPerformed

    private void Btn_Aprender_Ejercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_Ejercicio2ActionPerformed
        tc.getExer2LearnContent(Edt_Ejercicio2);
        Scp_Ejercicio2.setVisible(true);
        showLearnPanels();
    }//GEN-LAST:event_Btn_Aprender_Ejercicio2ActionPerformed

    private void Btn_Aprender_EjercicioFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Aprender_EjercicioFinalActionPerformed
        tc.getExer3LearnContent(Edt_Ejercicio3);
        Scp_Ejercicio3.setVisible(true);
        showLearnPanels();
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
        try {
            juzgador("input1", code, "ioaprender", "ioaprender", "1", 20, emf);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        emf = ex.regenerateConnectionUpdatep();
        verifySolutionStatus();
    }//GEN-LAST:event_Btn_EnviarEjercicio1ActionPerformed

    private void Btn_EnviarEjercicio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EnviarEjercicio2ActionPerformed
        String code = syntaxEjercicio2.getText();
        try {
            juzgador("input2", code, "ioaprender", "ioaprender", "2", 21, emf);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        emf = ex.regenerateConnectionUpdatep();
        verifySolutionStatus();
    }//GEN-LAST:event_Btn_EnviarEjercicio2ActionPerformed

    private void Btn_EnviarEjercicio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EnviarEjercicio3ActionPerformed
        String code = syntaxEjercicio3.getText();
        try {
            juzgador("input3", code, "ioaprender", "ioaprender", "3", 22, emf);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        emf = ex.regenerateConnectionUpdatep();
        verifySolutionStatus();
    }//GEN-LAST:event_Btn_EnviarEjercicio3ActionPerformed

    private void showAnswerWindow(JRadioButton r1, JRadioButton r2, JRadioButton r3) {
        JOptionPane.showMessageDialog(null, ((r1.isSelected()) ? "Pregunta 1: Correcto" : " Pregunta 1: Incorrecto"));
        JOptionPane.showMessageDialog(null, ((r2.isSelected()) ? "Pregunta 2: Correcto" : " Pregunta 2: Incorrecto"));
        JOptionPane.showMessageDialog(null, ((r3.isSelected()) ? "Pregunta 3: Correcto" : " Pregunta 3: Incorrecto"));
    }

    private void Btn_Answer0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer0ActionPerformed
        showAnswerWindow(Rad_Question0_1, Rad_Question0_2, Rad_Question0_3);
    }//GEN-LAST:event_Btn_Answer0ActionPerformed

    private void Btn_Answer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer1ActionPerformed
        showAnswerWindow(Rad_Question1_1, Rad_Question1_2, Rad_Question1_3);
    }//GEN-LAST:event_Btn_Answer1ActionPerformed

    private void Btn_Answer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer2ActionPerformed
        showAnswerWindow(Rad_Question2_1, Rad_Question2_2, Rad_Question2_3);
    }//GEN-LAST:event_Btn_Answer2ActionPerformed

    private void Btn_Answer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer3ActionPerformed
        showAnswerWindow(Rad_Question3_1, Rad_Question3_2, Rad_Question3_3);
    }//GEN-LAST:event_Btn_Answer3ActionPerformed

    private void Btn_Answer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer4ActionPerformed
        showAnswerWindow(Rad_Question4_1, Rad_Question4_2, Rad_Question4_3);
    }//GEN-LAST:event_Btn_Answer4ActionPerformed

    private void Btn_Answer5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer5ActionPerformed
        showAnswerWindow(Rad_Question5_1, Rad_Question5_2, Rad_Question5_3);
    }//GEN-LAST:event_Btn_Answer5ActionPerformed

    private void Btn_Answer6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer6ActionPerformed
        showAnswerWindow(Rad_Question6_1, Rad_Question6_2, Rad_Question6_3);
    }//GEN-LAST:event_Btn_Answer6ActionPerformed

    private void Btn_Answer7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer7ActionPerformed
        showAnswerWindow(Rad_Question7_1, Rad_Question7_2, Rad_Question7_3);
    }//GEN-LAST:event_Btn_Answer7ActionPerformed

    private void Btn_Answer8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer8ActionPerformed
        showAnswerWindow(Rad_Question8_1, Rad_Question8_2, Rad_Question8_3);
    }//GEN-LAST:event_Btn_Answer8ActionPerformed

    private void Btn_Answer9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer9ActionPerformed
        showAnswerWindow(Rad_Question9_1, Rad_Question9_2, Rad_Question9_3);
    }//GEN-LAST:event_Btn_Answer9ActionPerformed

    private void Btn_Answer10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer10ActionPerformed
        showAnswerWindow(Rad_Question10_1, Rad_Question10_2, Rad_Question10_3);
    }//GEN-LAST:event_Btn_Answer10ActionPerformed

    private void Btn_Answer11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer11ActionPerformed
        showAnswerWindow(Rad_Question11_1, Rad_Question11_2, Rad_Question11_3);
    }//GEN-LAST:event_Btn_Answer11ActionPerformed

    private void Btn_Answer12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer12ActionPerformed
        showAnswerWindow(Rad_Question12_1, Rad_Question12_2, Rad_Question12_3);
    }//GEN-LAST:event_Btn_Answer12ActionPerformed

    private void Btn_Answer13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Answer13ActionPerformed
        showAnswerWindow(Rad_Question13_1, Rad_Question13_2, Rad_Question13_3);
    }//GEN-LAST:event_Btn_Answer13ActionPerformed

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
    private javax.swing.ButtonGroup Bgr_Question1;
    private javax.swing.ButtonGroup Bgr_Question2;
    private javax.swing.ButtonGroup Bgr_Question3;
    private javax.swing.JToggleButton Btn_AcercaDe;
    private javax.swing.JButton Btn_Answer0;
    private javax.swing.JButton Btn_Answer1;
    private javax.swing.JButton Btn_Answer10;
    private javax.swing.JButton Btn_Answer11;
    private javax.swing.JButton Btn_Answer12;
    private javax.swing.JButton Btn_Answer13;
    private javax.swing.JButton Btn_Answer2;
    private javax.swing.JButton Btn_Answer3;
    private javax.swing.JButton Btn_Answer4;
    private javax.swing.JButton Btn_Answer5;
    private javax.swing.JButton Btn_Answer6;
    private javax.swing.JButton Btn_Answer7;
    private javax.swing.JButton Btn_Answer8;
    private javax.swing.JButton Btn_Answer9;
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
    private javax.swing.JButton Btn_Anterior_EDDBasicas;
    private javax.swing.JButton Btn_Anterior_EDDIntermedias;
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
    private javax.swing.JButton Btn_Siguiente_EDDBasicas;
    private javax.swing.JButton Btn_Siguiente_EDDIntermedias;
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
    private javax.swing.JEditorPane Edt0_1;
    private javax.swing.JEditorPane Edt0_2;
    private javax.swing.JEditorPane Edt10_1;
    private javax.swing.JEditorPane Edt10_2;
    private javax.swing.JEditorPane Edt10_3;
    private javax.swing.JEditorPane Edt11_1;
    private javax.swing.JEditorPane Edt11_10;
    private javax.swing.JEditorPane Edt11_11;
    private javax.swing.JEditorPane Edt11_12;
    private javax.swing.JEditorPane Edt11_13;
    private javax.swing.JEditorPane Edt11_14;
    private javax.swing.JEditorPane Edt11_2;
    private javax.swing.JEditorPane Edt11_3;
    private javax.swing.JEditorPane Edt11_4;
    private javax.swing.JEditorPane Edt11_5;
    private javax.swing.JEditorPane Edt11_6;
    private javax.swing.JEditorPane Edt11_7;
    private javax.swing.JEditorPane Edt11_8;
    private javax.swing.JEditorPane Edt11_9;
    private javax.swing.JEditorPane Edt12_1;
    private javax.swing.JEditorPane Edt12_10;
    private javax.swing.JEditorPane Edt12_11;
    private javax.swing.JEditorPane Edt12_2;
    private javax.swing.JEditorPane Edt12_3;
    private javax.swing.JEditorPane Edt12_4;
    private javax.swing.JEditorPane Edt12_5;
    private javax.swing.JEditorPane Edt12_6;
    private javax.swing.JEditorPane Edt12_7;
    private javax.swing.JEditorPane Edt12_8;
    private javax.swing.JEditorPane Edt12_9;
    private javax.swing.JEditorPane Edt13_1;
    private javax.swing.JEditorPane Edt13_2;
    private javax.swing.JEditorPane Edt13_3;
    private javax.swing.JEditorPane Edt13_4;
    private javax.swing.JEditorPane Edt13_5;
    private javax.swing.JEditorPane Edt13_6;
    private javax.swing.JEditorPane Edt1_1;
    private javax.swing.JEditorPane Edt1_2;
    private javax.swing.JEditorPane Edt1_3;
    private javax.swing.JEditorPane Edt1_4;
    private javax.swing.JEditorPane Edt2_1;
    private javax.swing.JEditorPane Edt2_2;
    private javax.swing.JEditorPane Edt3_1;
    private javax.swing.JEditorPane Edt3_2;
    private javax.swing.JEditorPane Edt3_3;
    private javax.swing.JEditorPane Edt3_4;
    private javax.swing.JEditorPane Edt3_5;
    private javax.swing.JEditorPane Edt3_6;
    private javax.swing.JEditorPane Edt3_7;
    private javax.swing.JEditorPane Edt3_8;
    private javax.swing.JEditorPane Edt4_1;
    private javax.swing.JEditorPane Edt4_2;
    private javax.swing.JEditorPane Edt5_1;
    private javax.swing.JEditorPane Edt5_2;
    private javax.swing.JEditorPane Edt5_3;
    private javax.swing.JEditorPane Edt6_1;
    private javax.swing.JEditorPane Edt6_2;
    private javax.swing.JEditorPane Edt6_3;
    private javax.swing.JEditorPane Edt7_1;
    private javax.swing.JEditorPane Edt7_10;
    private javax.swing.JEditorPane Edt7_2;
    private javax.swing.JEditorPane Edt7_3;
    private javax.swing.JEditorPane Edt7_4;
    private javax.swing.JEditorPane Edt7_5;
    private javax.swing.JEditorPane Edt7_6;
    private javax.swing.JEditorPane Edt7_7;
    private javax.swing.JEditorPane Edt7_8;
    private javax.swing.JEditorPane Edt7_9;
    private javax.swing.JEditorPane Edt8_1;
    private javax.swing.JEditorPane Edt8_2;
    private javax.swing.JEditorPane Edt8_3;
    private javax.swing.JEditorPane Edt8_4;
    private javax.swing.JEditorPane Edt8_5;
    private javax.swing.JEditorPane Edt8_6;
    private javax.swing.JEditorPane Edt8_7;
    private javax.swing.JEditorPane Edt9_1;
    private javax.swing.JEditorPane Edt9_2;
    private javax.swing.JEditorPane Edt9_3;
    private javax.swing.JEditorPane EdtCuestionario1;
    private javax.swing.JEditorPane EdtCuestionario10;
    private javax.swing.JEditorPane EdtCuestionario11;
    private javax.swing.JEditorPane EdtCuestionario12;
    private javax.swing.JEditorPane EdtCuestionario13;
    private javax.swing.JEditorPane EdtCuestionario14;
    private javax.swing.JEditorPane EdtCuestionario2;
    private javax.swing.JEditorPane EdtCuestionario3;
    private javax.swing.JEditorPane EdtCuestionario4;
    private javax.swing.JEditorPane EdtCuestionario5;
    private javax.swing.JEditorPane EdtCuestionario6;
    private javax.swing.JEditorPane EdtCuestionario7;
    private javax.swing.JEditorPane EdtCuestionario8;
    private javax.swing.JEditorPane EdtCuestionario9;
    private javax.swing.JEditorPane Edt_ContenidoHistoria;
    private javax.swing.JEditorPane Edt_Ejercicio1;
    private javax.swing.JEditorPane Edt_Ejercicio2;
    private javax.swing.JEditorPane Edt_Ejercicio3;
    private javax.swing.JEditorPane Edt_General_info;
    private javax.swing.JEditorPane Edt_Introduccion;
    private javax.swing.JLabel Lbl_Acumuladores;
    private javax.swing.JLabel Lbl_Aprender_Mapa;
    private javax.swing.JLabel Lbl_BinarySearch;
    private javax.swing.JLabel Lbl_BubbleSort;
    private javax.swing.JLabel Lbl_BucleDoWhile;
    private javax.swing.JLabel Lbl_BucleFor;
    private javax.swing.JLabel Lbl_BucleWhile;
    private javax.swing.JLabel Lbl_Bucles;
    private javax.swing.JLabel Lbl_CodeStorm_Fondo;
    private javax.swing.JLabel Lbl_Colas;
    private javax.swing.JLabel Lbl_Comentarios;
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
    private javax.swing.JLabel Lbl_Ejercicio1_Principiante;
    private javax.swing.JLabel Lbl_Ejercicio2_Intermedio;
    private javax.swing.JLabel Lbl_EjercicioFinal;
    private javax.swing.JLabel Lbl_FuncionesyProcs;
    private javax.swing.JLabel Lbl_HashMap;
    private javax.swing.JLabel Lbl_HashSet;
    private javax.swing.JLabel Lbl_Header_Aprender;
    private javax.swing.JLabel Lbl_Header_CodeStorm;
    private javax.swing.JLabel Lbl_Header_CodeStorm1;
    private javax.swing.JLabel Lbl_Header_CodeStorm2;
    private javax.swing.JLabel Lbl_Header_Historia;
    private javax.swing.JLabel Lbl_HelloWorld;
    private javax.swing.JLabel Lbl_HomeButttons;
    private javax.swing.JLabel Lbl_Home_Fondo;
    private javax.swing.JLabel Lbl_ImagenBinarySearch;
    private javax.swing.JLabel Lbl_ImagenBubbleSort;
    private javax.swing.JLabel Lbl_LecturaeImpresion;
    private javax.swing.JLabel Lbl_Maps;
    private javax.swing.JLabel Lbl_MatrizDinamica;
    private javax.swing.JLabel Lbl_MatrizFija;
    private javax.swing.JLabel Lbl_Nivel1;
    private javax.swing.JLabel Lbl_Nivel2;
    private javax.swing.JLabel Lbl_Nivel3;
    private javax.swing.JLabel Lbl_Nivel4;
    private javax.swing.JLabel Lbl_Nivel5;
    private javax.swing.JLabel Lbl_OperadorIncDec;
    private javax.swing.JLabel Lbl_OperadoresAritmeticos;
    private javax.swing.JLabel Lbl_OperadoresLogicos;
    private javax.swing.JLabel Lbl_OperadoresdeRelacion;
    private javax.swing.JLabel Lbl_Pilas;
    private javax.swing.JLabel Lbl_PrimerosAlgoritmos;
    private javax.swing.JLabel Lbl_Recursion;
    private javax.swing.JLabel Lbl_SampleCode8_1;
    private javax.swing.JLabel Lbl_SampleCode8_10;
    private javax.swing.JLabel Lbl_SampleCode8_2;
    private javax.swing.JLabel Lbl_SampleCode8_3;
    private javax.swing.JLabel Lbl_SampleCode8_5;
    private javax.swing.JLabel Lbl_SampleCode8_8;
    private javax.swing.JLabel Lbl_Sets;
    private javax.swing.JLabel Lbl_Sintaxis8_7;
    private javax.swing.JLabel Lbl_SwitchCase;
    private javax.swing.JLabel Lbl_TablaOperadoresLogicos;
    private javax.swing.JLabel Lbl_TablaOperadoresRelacion;
    private javax.swing.JLabel Lbl_TiposdeDatos;
    private javax.swing.JLabel Lbl_TreeMap;
    private javax.swing.JLabel Lbl_TreeSet;
    private javax.swing.JLabel Lbl_TryCatch;
    private javax.swing.JLabel Lbl_VectorDinamico;
    private javax.swing.JLabel Lbl_VectorFijo;
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
    private javax.swing.JPanel Pnl_CodesThemes10_1;
    private javax.swing.JPanel Pnl_CodesThemes10_2;
    private javax.swing.JPanel Pnl_CodesThemes11_1;
    private javax.swing.JPanel Pnl_CodesThemes11_2;
    private javax.swing.JPanel Pnl_CodesThemes11_3;
    private javax.swing.JPanel Pnl_CodesThemes11_4;
    private javax.swing.JPanel Pnl_CodesThemes11_5;
    private javax.swing.JPanel Pnl_CodesThemes11_6;
    private javax.swing.JPanel Pnl_CodesThemes11_7;
    private javax.swing.JPanel Pnl_CodesThemes11_8;
    private javax.swing.JPanel Pnl_CodesThemes12_1;
    private javax.swing.JPanel Pnl_CodesThemes12_2;
    private javax.swing.JPanel Pnl_CodesThemes12_3;
    private javax.swing.JPanel Pnl_CodesThemes12_4;
    private javax.swing.JPanel Pnl_CodesThemes13_1;
    private javax.swing.JPanel Pnl_CodesThemes13_2;
    private javax.swing.JPanel Pnl_CodesThemes1_1;
    private javax.swing.JPanel Pnl_CodesThemes1_2;
    private javax.swing.JPanel Pnl_CodesThemes1_3;
    private javax.swing.JPanel Pnl_CodesThemes2;
    private javax.swing.JPanel Pnl_CodesThemes3_1;
    private javax.swing.JPanel Pnl_CodesThemes3_2;
    private javax.swing.JPanel Pnl_CodesThemes3_3;
    private javax.swing.JPanel Pnl_CodesThemes3_4;
    private javax.swing.JPanel Pnl_CodesThemes3_5;
    private javax.swing.JPanel Pnl_CodesThemes4;
    private javax.swing.JPanel Pnl_CodesThemes5;
    private javax.swing.JPanel Pnl_CodesThemes6;
    private javax.swing.JPanel Pnl_CodesThemes7_1;
    private javax.swing.JPanel Pnl_CodesThemes7_10;
    private javax.swing.JPanel Pnl_CodesThemes7_2;
    private javax.swing.JPanel Pnl_CodesThemes7_3;
    private javax.swing.JPanel Pnl_CodesThemes7_4;
    private javax.swing.JPanel Pnl_CodesThemes7_5;
    private javax.swing.JPanel Pnl_CodesThemes7_6;
    private javax.swing.JPanel Pnl_CodesThemes7_7;
    private javax.swing.JPanel Pnl_CodesThemes7_8;
    private javax.swing.JPanel Pnl_CodesThemes7_9;
    private javax.swing.JPanel Pnl_CodesThemes8_1;
    private javax.swing.JPanel Pnl_CodesThemes8_2;
    private javax.swing.JPanel Pnl_CodesThemes8_3;
    private javax.swing.JPanel Pnl_CodesThemes8_4;
    private javax.swing.JPanel Pnl_CodesThemes8_5;
    private javax.swing.JPanel Pnl_CodesThemes8_6;
    private javax.swing.JPanel Pnl_CodesThemes9_1;
    private javax.swing.JPanel Pnl_CodesThemes9_2;
    private javax.swing.JPanel Pnl_CodigoFull;
    private javax.swing.JPanel Pnl_ContenidoHistoria;
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
    private javax.swing.JPanel Pnl_ExerciseInfo;
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
    private javax.swing.JRadioButton Rad_Question0;
    private javax.swing.JRadioButton Rad_Question01;
    private javax.swing.JRadioButton Rad_Question0_1;
    private javax.swing.JRadioButton Rad_Question0_2;
    private javax.swing.JRadioButton Rad_Question0_3;
    private javax.swing.JRadioButton Rad_Question0_4;
    private javax.swing.JRadioButton Rad_Question0_5;
    private javax.swing.JRadioButton Rad_Question0_6;
    private javax.swing.JRadioButton Rad_Question10_1;
    private javax.swing.JRadioButton Rad_Question10_2;
    private javax.swing.JRadioButton Rad_Question10_2_1;
    private javax.swing.JRadioButton Rad_Question10_2_2;
    private javax.swing.JRadioButton Rad_Question10_2_3;
    private javax.swing.JRadioButton Rad_Question10_3;
    private javax.swing.JRadioButton Rad_Question10_3_3;
    private javax.swing.JRadioButton Rad_Question10_4;
    private javax.swing.JRadioButton Rad_Question10_5;
    private javax.swing.JRadioButton Rad_Question10_6;
    private javax.swing.JRadioButton Rad_Question10_7;
    private javax.swing.JRadioButton Rad_Question10_8;
    private javax.swing.JRadioButton Rad_Question11_1;
    private javax.swing.JRadioButton Rad_Question11_2;
    private javax.swing.JRadioButton Rad_Question11_3;
    private javax.swing.JRadioButton Rad_Question11_4;
    private javax.swing.JRadioButton Rad_Question11_5;
    private javax.swing.JRadioButton Rad_Question11_6;
    private javax.swing.JRadioButton Rad_Question12_1;
    private javax.swing.JRadioButton Rad_Question12_2;
    private javax.swing.JRadioButton Rad_Question12_3;
    private javax.swing.JRadioButton Rad_Question13_1;
    private javax.swing.JRadioButton Rad_Question13_2;
    private javax.swing.JRadioButton Rad_Question13_3;
    private javax.swing.JRadioButton Rad_Question1_1;
    private javax.swing.JRadioButton Rad_Question1_10;
    private javax.swing.JRadioButton Rad_Question1_12;
    private javax.swing.JRadioButton Rad_Question1_15;
    private javax.swing.JRadioButton Rad_Question1_17;
    private javax.swing.JRadioButton Rad_Question1_19;
    private javax.swing.JRadioButton Rad_Question1_2;
    private javax.swing.JRadioButton Rad_Question1_20;
    private javax.swing.JRadioButton Rad_Question1_3;
    private javax.swing.JRadioButton Rad_Question1_4;
    private javax.swing.JRadioButton Rad_Question1_5;
    private javax.swing.JRadioButton Rad_Question1_6;
    private javax.swing.JRadioButton Rad_Question1_7;
    private javax.swing.JRadioButton Rad_Question1_8;
    private javax.swing.JRadioButton Rad_Question1_9;
    private javax.swing.JRadioButton Rad_Question2_1;
    private javax.swing.JRadioButton Rad_Question2_10;
    private javax.swing.JRadioButton Rad_Question2_11;
    private javax.swing.JRadioButton Rad_Question2_12;
    private javax.swing.JRadioButton Rad_Question2_14;
    private javax.swing.JRadioButton Rad_Question2_15;
    private javax.swing.JRadioButton Rad_Question2_2;
    private javax.swing.JRadioButton Rad_Question2_21;
    private javax.swing.JRadioButton Rad_Question2_3;
    private javax.swing.JRadioButton Rad_Question2_4;
    private javax.swing.JRadioButton Rad_Question2_5;
    private javax.swing.JRadioButton Rad_Question2_6;
    private javax.swing.JRadioButton Rad_Question2_8;
    private javax.swing.JRadioButton Rad_Question2_9;
    private javax.swing.JRadioButton Rad_Question3;
    private javax.swing.JRadioButton Rad_Question3_1;
    private javax.swing.JRadioButton Rad_Question3_10;
    private javax.swing.JRadioButton Rad_Question3_12;
    private javax.swing.JRadioButton Rad_Question3_13;
    private javax.swing.JRadioButton Rad_Question3_14;
    private javax.swing.JRadioButton Rad_Question3_18;
    private javax.swing.JRadioButton Rad_Question3_19;
    private javax.swing.JRadioButton Rad_Question3_2;
    private javax.swing.JRadioButton Rad_Question3_3;
    private javax.swing.JRadioButton Rad_Question3_7;
    private javax.swing.JRadioButton Rad_Question3_8;
    private javax.swing.JRadioButton Rad_Question3_9;
    private javax.swing.JRadioButton Rad_Question4;
    private javax.swing.JRadioButton Rad_Question4_00;
    private javax.swing.JRadioButton Rad_Question4_1;
    private javax.swing.JRadioButton Rad_Question4_10;
    private javax.swing.JRadioButton Rad_Question4_11;
    private javax.swing.JRadioButton Rad_Question4_16;
    private javax.swing.JRadioButton Rad_Question4_1_1;
    private javax.swing.JRadioButton Rad_Question4_2;
    private javax.swing.JRadioButton Rad_Question4_3;
    private javax.swing.JRadioButton Rad_Question4_6;
    private javax.swing.JRadioButton Rad_Question4_7;
    private javax.swing.JRadioButton Rad_Question4_8;
    private javax.swing.JRadioButton Rad_Question4_9;
    private javax.swing.JRadioButton Rad_Question5_1;
    private javax.swing.JRadioButton Rad_Question5_10;
    private javax.swing.JRadioButton Rad_Question5_11;
    private javax.swing.JRadioButton Rad_Question5_13;
    private javax.swing.JRadioButton Rad_Question5_14;
    private javax.swing.JRadioButton Rad_Question5_15;
    private javax.swing.JRadioButton Rad_Question5_17;
    private javax.swing.JRadioButton Rad_Question5_18;
    private javax.swing.JRadioButton Rad_Question5_1_0;
    private javax.swing.JRadioButton Rad_Question5_2;
    private javax.swing.JRadioButton Rad_Question5_3;
    private javax.swing.JRadioButton Rad_Question5_4;
    private javax.swing.JRadioButton Rad_Question5_5;
    private javax.swing.JRadioButton Rad_Question5_6;
    private javax.swing.JRadioButton Rad_Question5_7;
    private javax.swing.JRadioButton Rad_Question5_8;
    private javax.swing.JRadioButton Rad_Question5_9;
    private javax.swing.JRadioButton Rad_Question6_1;
    private javax.swing.JRadioButton Rad_Question6_1_0;
    private javax.swing.JRadioButton Rad_Question6_2;
    private javax.swing.JRadioButton Rad_Question6_3;
    private javax.swing.JRadioButton Rad_Question7_1;
    private javax.swing.JRadioButton Rad_Question7_1_0;
    private javax.swing.JRadioButton Rad_Question7_2;
    private javax.swing.JRadioButton Rad_Question7_2_0;
    private javax.swing.JRadioButton Rad_Question7_3;
    private javax.swing.JRadioButton Rad_Question7_5;
    private javax.swing.JRadioButton Rad_Question7_6;
    private javax.swing.JRadioButton Rad_Question8_1;
    private javax.swing.JRadioButton Rad_Question8_10;
    private javax.swing.JRadioButton Rad_Question8_11;
    private javax.swing.JRadioButton Rad_Question8_12;
    private javax.swing.JRadioButton Rad_Question8_13;
    private javax.swing.JRadioButton Rad_Question8_14;
    private javax.swing.JRadioButton Rad_Question8_1_0;
    private javax.swing.JRadioButton Rad_Question8_1_1;
    private javax.swing.JRadioButton Rad_Question8_2;
    private javax.swing.JRadioButton Rad_Question8_2_0;
    private javax.swing.JRadioButton Rad_Question8_3;
    private javax.swing.JRadioButton Rad_Question8_3_0;
    private javax.swing.JRadioButton Rad_Question8_4;
    private javax.swing.JRadioButton Rad_Question8_5;
    private javax.swing.JRadioButton Rad_Question8_6;
    private javax.swing.JRadioButton Rad_Question8_9;
    private javax.swing.JRadioButton Rad_Question9_1;
    private javax.swing.JRadioButton Rad_Question9_2;
    private javax.swing.JRadioButton Rad_Question9_3;
    private javax.swing.JScrollPane Scp_ContenidoHistoria;
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
    private javax.swing.JScrollPane Scp_General;
    private javax.swing.JScrollPane Scp_Introduccion;
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
    private javax.swing.JSeparator Spr_Acumuladores;
    private javax.swing.JSeparator Spr_BinarySearch;
    private javax.swing.JSeparator Spr_Colas;
    private javax.swing.JSeparator Spr_CondicionalesAnidados;
    private javax.swing.JSeparator Spr_DoWhile;
    private javax.swing.JSeparator Spr_For;
    private javax.swing.JSeparator Spr_HashMap;
    private javax.swing.JSeparator Spr_HashSet;
    private javax.swing.JSeparator Spr_Maps;
    private javax.swing.JSeparator Spr_MatrizDinamica;
    private javax.swing.JSeparator Spr_MatrizFija;
    private javax.swing.JSeparator Spr_OperadoresIncDec;
    private javax.swing.JSeparator Spr_Pilas;
    private javax.swing.JSeparator Spr_Sets;
    private javax.swing.JSeparator Spr_SwitchCase;
    private javax.swing.JSeparator Spr_TreeMap;
    private javax.swing.JSeparator Spr_TreeSet;
    private javax.swing.JSeparator Spr_TryCatch;
    private javax.swing.JSeparator Spr_VectorDinamico;
    private javax.swing.JSeparator Spr_VectorFijo;
    private javax.swing.JSeparator Spr_While;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JRadioButton jRadioButton25;
    private javax.swing.JRadioButton jRadioButton26;
    private javax.swing.JRadioButton jRadioButton29;
    private javax.swing.JRadioButton jRadioButton31;
    private javax.swing.JRadioButton jRadioButton32;
    private javax.swing.JRadioButton jRadioButton33;
    private javax.swing.JRadioButton jRadioButton34;
    private javax.swing.JRadioButton jRadioButton35;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    // End of variables declaration//GEN-END:variables
}
