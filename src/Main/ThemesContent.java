package Main;

// Librerias Creadas
import Entities.Codes;
import Entities.Exercises;
import Entities.HistoryTopics;
import Entities.HistorySubtopics;
import Entities.ExercisesContent;
import Entities.LearningSubtopics;
import JPA_Controllers.CodesJpaController;
import JPA_Controllers.ExercisesJpaController;
import JPA_Controllers.HistoryTopicsJpaController;
import JPA_Controllers.ExercisesContentJpaController;
import JPA_Controllers.HistorySubtopicsJpaController;
import JPA_Controllers.LearningSubtopicsJpaController;
import Services.RecursosService;

// Librerias Externas
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

// Librerias por Default
import java.util.List;
import javax.swing.JEditorPane;
import javax.persistence.EntityManagerFactory;

public class ThemesContent {

    private final RecursosService sRecursos = RecursosService.getService();
    private EntityManagerFactory emf = null;

    // Controladores
    private CodesJpaController cojpa = null;
    private ExercisesJpaController ejpa = null;
    private HistoryTopicsJpaController htjpa = null;
    private ExercisesContentJpaController ecjpa = null;
    private HistorySubtopicsJpaController hsjpa = null;
    private LearningSubtopicsJpaController lstjpa = null;

    // Listas para almacenar contenido
    private List<Codes> coList = null;
    private List<Exercises> eList = null;
    private List<HistoryTopics> htList = null;
    private List<ExercisesContent> ecList = null;
    private List<HistorySubtopics> hsList = null;
    private List<LearningSubtopics> lstList = null;

    // Template HTML
    private final HTMLTemplates t = new HTMLTemplates();

    // Constantes de Subtitulos
    private final String stx = "Sintaxis";
    private final String ejm = "Código de Ejemplo";

    public void addHTML(String tmp, JEditorPane edt, String... s) {
        String text = String.format(tmp, (Object[]) s);
        edt.setText(text);
        edt.setFont(sRecursos.getFGeneral());
        edt.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        edt.setEditable(false);
    }

    public void generateListsInfo() {
        coList = cojpa.findCodesEntities();
        eList = ejpa.findExercisesEntities();
        htList = htjpa.findHistoryTopicsEntities();
        hsList = hsjpa.findHistorySubtopicsEntities();
        ecList = ecjpa.findExercisesContentEntities();
        lstList = lstjpa.findLearningSubtopicsEntities();
    }

//    Obtener conexion con la Base de Datos
    public void setConnectionDB(EntityManagerFactory emf) {
        cojpa = new CodesJpaController(emf);
        ejpa = new ExercisesJpaController(emf);
        htjpa = new HistoryTopicsJpaController(emf);
        hsjpa = new HistorySubtopicsJpaController(emf);
        ecjpa = new ExercisesContentJpaController(emf);
        lstjpa = new LearningSubtopicsJpaController(emf);
    }

    public void getHelloWorldContent(JEditorPane e1, JEditorPane e2, RSyntaxTextArea rta) {

        String[] parrafos = lstList.get(0).getLearningSubContent().split("\n");

        // EditorPane0_1
        String anlg0 = lstList.get(0).getTitleAnalogy();
        String sbct0_1 = parrafos[0];

        // Codigo Resaltado
        rta.setText(coList.get(0).getSampleCode());

        // EditorPane0_2
        String out0 = coList.get(0).getOutputScreen();
        String sbct0_2 = parrafos[1];
        String sbct0_3 = parrafos[2];

        String tmp0_1 = t.getGeneralTemplate("h2_p_h3");
        String tmp0_2 = t.getGeneralTemplate("p_p_p");

        addHTML(tmp0_1, e1, anlg0, sbct0_1, ejm);
        addHTML(tmp0_2, e2, out0, sbct0_2, sbct0_3);
    }

    public void getComentariosContent(RSyntaxTextArea rta1, RSyntaxTextArea rta2,
            RSyntaxTextArea rta3, JEditorPane e1, JEditorPane e2, JEditorPane e3, JEditorPane e4) {

        // EditorPane1_1
        String anlg1 = lstList.get(1).getTitleAnalogy();
        String sbct1_1 = lstList.get(1).getLearningSubContent();
        String sbct1_2 = lstList.get(1).getSyntax();

        // Codigo Resaltado
        rta1.setText(coList.get(1).getSampleCode());

        // EditorPane1_2
        String out1_1 = coList.get(1).getOutputScreen();
        String sbct1_3 = coList.get(2).getCodeDescription();

        // Codigo Resaltado
        rta2.setText(coList.get(2).getSampleCode());

        // EditorPane1_3
        String out1_2 = coList.get(2).getOutputScreen();
        String sbct1_4 = coList.get(3).getCodeDescription();

        // Codigo Resaltado
        rta3.setText(coList.get(3).getSampleCode());

        // EditorPane1_4
        String out1_3 = coList.get(3).getOutputScreen();

        String tmp1_1 = t.getGeneralTemplate("h2_p_p_h3BR2");
        String tmp1_2 = t.getGeneralTemplate("p_p_h3BR1");
        String tmp1_3 = t.getGeneralTemplate("p_p_h3BR1");
        String tmp1_4 = t.getGeneralTemplate("p");

        addHTML(tmp1_1, e1, anlg1, sbct1_1, sbct1_2, ejm);
        addHTML(tmp1_2, e2, out1_1, sbct1_3, ejm);
        addHTML(tmp1_3, e3, out1_2, sbct1_4, ejm);
        addHTML(tmp1_4, e4, out1_3);
    }

    public void getTiposDeDatosContent(RSyntaxTextArea rta, JEditorPane edt1, JEditorPane edt2) {

        //EditorPane2_1
        String anlg2 = lstList.get(2).getTitleAnalogy();
        String sbct2_1 = lstList.get(2).getLearningSubContent();

        // Resaltado de Codido
        rta.setText(coList.get(4).getSampleCode());

        // EditorPane2_2
        String tips2_1 = lstList.get(2).getTips();

        String tmp2_1 = t.getGeneralTemplate("h2_p_h3BR");
        String tmp2_2 = t.getGeneralTemplate("pBR");

        addHTML(tmp2_1, edt1, anlg2, sbct2_1, ejm);
        addHTML(tmp2_2, edt2, tips2_1);
    }

    public void getOperadoresAritmeticosContent(RSyntaxTextArea rta1, RSyntaxTextArea rta2, RSyntaxTextArea rta3,
            RSyntaxTextArea rta4, RSyntaxTextArea rta5, JEditorPane edt1, JEditorPane edt2, JEditorPane edt3,
            JEditorPane edt4, JEditorPane edt5, JEditorPane edt6, JEditorPane edt7, JEditorPane edt8) {

        String parrafo[] = lstList.get(3).getLearningSubContent().split(":");

        // EditorPane3_1
        String anlg3_1 = lstList.get(3).getTitleAnalogy();
        String sbct3_1 = parrafo[0] + ":";
        String sbct3_2 = parrafo[1];

        // Resaltado de Codigo
        rta1.setText(coList.get(6).getSampleCode());

        // EditorPane3_2
        String out3_1 = coList.get(6).getOutputScreen();

        // Resaltado de Codigo
        rta2.setText(coList.get(5).getSampleCode());

        // EditorPane3_3
        String out3_2 = coList.get(5).getOutputScreen();
        String tips3_1 = lstList.get(3).getTips();

        String tmp3_1 = t.getGeneralTemplate("h2_p_p_h3BR1");
        String tmp3_2 = t.getGeneralTemplate("p_h3BR");
        String tmp3_3 = t.getGeneralTemplate("p_p");

        addHTML(tmp3_1, edt1, anlg3_1, sbct3_1, sbct3_2, ejm);
        addHTML(tmp3_2, edt2, out3_1, ejm);
        addHTML(tmp3_3, edt3, out3_2, tips3_1);

        // Acumuladores ---------------------------------------------------------------------
        // EditorPane3_4
        String anlg3_2 = lstList.get(4).getTitleAnalogy();
        String sbct3_3 = lstList.get(4).getLearningSubContent();
        String stx3_1 = lstList.get(4).getSyntax();

        // Resaltado de Sintaxis
        rta3.setText(coList.get(7).getSampleCode());

        // EditorPane3_5
        String out3_3 = coList.get(7).getOutputScreen();

        // Resaltado de Sintaxis
        rta4.setText(coList.get(8).getSampleCode());

        // EditorPane3_6
        String out3_4 = coList.get(8).getOutputScreen();
        String tips3_2 = lstList.get(4).getTips();

        String tmp3_4 = t.getGeneralTemplate("h2_p_p_h3BR1");
        String tmp3_5 = t.getGeneralTemplate("p_h3BR");
        String tmp3_6 = t.getGeneralTemplate("p_pBR");

        addHTML(tmp3_4, edt4, anlg3_2, sbct3_3, stx3_1, ejm);
        addHTML(tmp3_5, edt5, out3_3, ejm);
        addHTML(tmp3_6, edt6, out3_4, tips3_2);

        // ---------------------------------------------------------------------
        //Operadores de Incremento y decremento
        // EditorPane3_7
        String anlg3_3 = lstList.get(5).getTitleAnalogy();
        String sbct3_4 = lstList.get(5).getLearningSubContent();
        String stx3_2 = lstList.get(5).getSyntax();

        // Resaltado de Sintaxis
        rta5.setText(coList.get(9).getSampleCode());

        // EditorPane3_8
        String out3_5 = coList.get(9).getOutputScreen();

        String tmp3_7 = t.getGeneralTemplate("h2_p_p_h3BR1");
        String tmp3_8 = t.getGeneralTemplate("p");

        addHTML(tmp3_7, edt7, anlg3_3, sbct3_4, stx3_2, ejm);
        addHTML(tmp3_8, edt8, out3_5);
    }

    public void getLecturaContent(RSyntaxTextArea rta, JEditorPane edt1, JEditorPane edt2) {

        // EditorPane4_1
        String anlg4_1 = lstList.get(6).getTitleAnalogy();
        String sbct4_1 = lstList.get(6).getLearningSubContent();

        // Resaltado de Código
        rta.setText(coList.get(10).getSampleCode());

        // EditorPane4_2
        String out4_1 = coList.get(10).getOutputScreen();
        String tips4_1 = lstList.get(6).getTips();

        String tmp4_1 = t.getGeneralTemplate("h2_p_h3BR");
        String tmp4_2 = t.getGeneralTemplate("p_p");

        addHTML(tmp4_1, edt1, anlg4_1, sbct4_1, ejm);
        addHTML(tmp4_2, edt2, out4_1, tips4_1);
    }

    public void getOperadoresDeRelacion(RSyntaxTextArea rta, JEditorPane edt1, JEditorPane edt2, JEditorPane edt3) {

        String[] parrafos = lstList.get(7).getLearningSubContent().split("\n");

        // EditorPane5_1
        String anlg5_1 = lstList.get(7).getTitleAnalogy();
        String sbct5_1 = parrafos[0];

        // EditorPane5_2
        String sbct5_2 = parrafos[1];

        // Resaltado de Codigo
        rta.setText(coList.get(11).getSampleCode());

        // EditorPane5_3
        String out5_1 = coList.get(11).getOutputScreen();
        String tip5_1 = lstList.get(7).getTips();

        String tmp5_1 = t.getGeneralTemplate("h2_p_h3BR");
        String tmp5_2 = t.getGeneralTemplate("p_h3BR");
        String tmp5_3 = t.getGeneralTemplate("p_p");

        addHTML(tmp5_1, edt1, anlg5_1, sbct5_1, "Tabla de Sintaxis General");
        addHTML(tmp5_2, edt2, sbct5_2, ejm);
        addHTML(tmp5_3, edt3, out5_1, tip5_1);
    }

    public void getOperadoresLogicos(RSyntaxTextArea rta, JEditorPane edt1, JEditorPane edt2, JEditorPane edt3) {

        String[] parrafos = lstList.get(8).getLearningSubContent().split("\n");

        // EditorPane6_1
        String anlg6_1 = lstList.get(8).getTitleAnalogy();
        String sbct6_1 = parrafos[0];

        // EditorPane6_2
        String sbct6_2 = parrafos[1];
        String sbct6_3 = parrafos[2];
        String sbct6_4 = parrafos[3];

        // Resaltado de Codigo
        rta.setText(coList.get(11).getSampleCode());

        // EditorPane6_3
        String out6_1 = coList.get(12).getOutputScreen();
        String tips6_1 = lstList.get(8).getTips();

        String tmp6_1 = t.getGeneralTemplate("h2_p_h3BR");
        String tmp6_2 = t.getGeneralTemplate("p_p_p_h3BR");
        String tmp6_3 = t.getGeneralTemplate("p_p");

        addHTML(tmp6_1, edt1, anlg6_1, sbct6_1, "Tabla de Sintaxis General");
        addHTML(tmp6_2, edt2, sbct6_2, sbct6_3, sbct6_4, ejm);
        addHTML(tmp6_3, edt3, out6_1, tips6_1);
    }

    public void getCondicionalesContent(RSyntaxTextArea rta1, RSyntaxTextArea rta2, RSyntaxTextArea rta3,
            RSyntaxTextArea rta4, RSyntaxTextArea rta5, RSyntaxTextArea rta6, RSyntaxTextArea rta7,
            RSyntaxTextArea rta8, RSyntaxTextArea rta9, RSyntaxTextArea rta10, JEditorPane edt1,
            JEditorPane edt2, JEditorPane edt3, JEditorPane edt4, JEditorPane edt5, JEditorPane edt6,
            JEditorPane edt7, JEditorPane edt8, JEditorPane edt9, JEditorPane edt10) {

        // EditorPane7_1
        String anlg7_1 = lstList.get(9).getTitleAnalogy();
        String sbct7_1 = lstList.get(9).getLearningSubContent();
        String stx7_1 = lstList.get(9).getSyntax();
        String cs7_1 = lstList.get(9).getTips();

        // Resaltado de Codigo
        rta1.setText(coList.get(13).getSampleCode());

        // EditorPane7_2
        String out7_1 = coList.get(13).getOutputScreen();
        String cds7_1 = coList.get(14).getCodeDescription();

        // Resaltado de Codigo
        rta2.setText(coList.get(14).getSampleCode());

        // EditorPane7_3
        String out7_2 = coList.get(14).getOutputScreen();

        String tmp7_1 = t.getGeneralTemplate("h2_p_p_p_h3BR3");
        String tmp7_2 = t.getGeneralTemplate("p_p_h3BR1");
        String tmp7_3 = t.getGeneralTemplate("p");

        addHTML(tmp7_1, edt1, anlg7_1, sbct7_1, stx7_1, cs7_1, ejm);
        addHTML(tmp7_2, edt2, out7_1, cds7_1, ejm);
        addHTML(tmp7_3, edt3, out7_2);

        // Condicionales Anidados ----------------------------------------------
        // Resaltado de Sintaxis
        rta3.setText(lstList.get(10).getSyntax());
        rta4.setText(coList.get(15).getSampleCode());

        // EditorPane7_4
        String out7_3 = coList.get(15).getOutputScreen();

        String tmp7_4 = t.getGeneralTemplate("p");

        addHTML(tmp7_4, edt4, out7_3);

        // Try-Catch -----------------------------------------------------------
        // EditorPane7_5
        String anlg7_2 = lstList.get(11).getTitleAnalogy();
        String sbct7_2 = lstList.get(11).getLearningSubContent();

        // Resaltado de Codigo
        rta5.setText(lstList.get(11).getSyntax());
        rta6.setText(coList.get(16).getSampleCode());

        // EditorPane7_6
        String out7_4 = coList.get(16).getOutputScreen();

        // Resaltado de Codigo
        rta7.setText(coList.get(17).getSampleCode());

        // EditorPane7_7
        String out7_5 = coList.get(17).getOutputScreen();
        String cds7_2 = coList.get(18).getCodeDescription();

        // Resaltado de Codigo
        rta8.setText(coList.get(18).getSampleCode());

        // EditorPane7_8
        String out7_6 = coList.get(18).getOutputScreen();

        String tmp7_5 = t.getGeneralTemplate("h2_p_h3BR");
        String tmp7_6 = t.getGeneralTemplate("p_h3BR");
        String tmp7_7 = t.getGeneralTemplate("p_p_h3BR1");
        String tmp7_8 = t.getGeneralTemplate("p");

        addHTML(tmp7_5, edt5, anlg7_2, sbct7_2, stx);
        addHTML(tmp7_6, edt6, out7_4, ejm);
        addHTML(tmp7_7, edt7, out7_5, cds7_2, ejm);
        addHTML(tmp7_8, edt8, out7_6);

        // Switch-Case ---------------------------------------------------------
        // EditorPane7_9
        String anlg7_3 = lstList.get(12).getTitleAnalogy();
        String sbct7_3 = lstList.get(12).getLearningSubContent();

        // Resaltado de Sintaxis
        rta9.setText(lstList.get(12).getSyntax());
        rta10.setText(coList.get(19).getSampleCode());

        // EditorPane7_10
        String out7_7 = coList.get(19).getOutputScreen();

        String tmp7_9 = t.getGeneralTemplate("h2_p_h3BR");
        String tmp7_10 = t.getGeneralTemplate("p");

        addHTML(tmp7_9, edt9, anlg7_3, sbct7_3, stx);
        addHTML(tmp7_10, edt10, out7_7);
    }

    public void getBuclesContent(RSyntaxTextArea rta1, RSyntaxTextArea rta2, RSyntaxTextArea rta3,
            RSyntaxTextArea rta4, RSyntaxTextArea rta5, RSyntaxTextArea rta6, JEditorPane edt1,
            JEditorPane edt2, JEditorPane edt3, JEditorPane edt4, JEditorPane edt5, JEditorPane edt6,
            JEditorPane edt7) {

        // EditorPane8_1
        String anlg8_1 = lstList.get(13).getTitleAnalogy();
        String sbct8_1 = lstList.get(13).getLearningSubContent();

        String tmp8_1 = t.getGeneralTemplate("h2_p");

        addHTML(tmp8_1, edt1, anlg8_1, sbct8_1);

        // Bucle While ---------------------------------------------------------
        // EditorPane8_2
        String sbct8_2 = lstList.get(14).getLearningSubContent();

        // Resaltado de Codigo
        rta4.setText(lstList.get(14).getSyntax());
        rta1.setText(coList.get(20).getSampleCode());

        // EditorPane8_3
        String out8_1 = coList.get(20).getOutputScreen();
        String tips8_1 = lstList.get(14).getTips();

        String tmp8_2 = t.getGeneralTemplate("p_h3BR");
        String tmp8_3 = t.getGeneralTemplate("p_pBR");

        addHTML(tmp8_2, edt2, sbct8_2, stx);
        addHTML(tmp8_3, edt3, out8_1, tips8_1);

        // Bucle For -----------------------------------------------------------
        // EditorPane8_4
        String sbct8_3 = lstList.get(15).getLearningSubContent();

        // Resaltado de Codigo
        rta5.setText(lstList.get(15).getSyntax());
        rta2.setText(coList.get(21).getSampleCode());

        // EditorPane8_5
        String out8_2 = coList.get(21).getOutputScreen();

        String tmp8_4 = t.getGeneralTemplate("p_h3BR");
        String tmp8_5 = t.getGeneralTemplate("pBR");

        addHTML(tmp8_4, edt4, sbct8_3, stx);
        addHTML(tmp8_5, edt5, out8_2, stx);

        // Bucle Do-While ------------------------------------------------------
        // EditorPane8_6
        String sbct8_4 = lstList.get(16).getLearningSubContent();

        // Resaltado de Codigo
        rta6.setText(lstList.get(16).getSyntax());
        rta3.setText(coList.get(22).getSampleCode());

        // EditorPane8_7
        String out8_3 = coList.get(23).getOutputScreen();
        String tips8_2 = lstList.get(16).getTips();

        String tmp8_6 = t.getGeneralTemplate("p_h3BR");
        String tmp8_7 = t.getGeneralTemplate("p_pBR");

        addHTML(tmp8_6, edt6, sbct8_4, stx);
        addHTML(tmp8_7, edt7, out8_3, tips8_2);
    }

    public void getFuncyProcedContent(RSyntaxTextArea rta1, RSyntaxTextArea rta2,
            JEditorPane edt1, JEditorPane edt2, JEditorPane edt3) {
        // EditorPane9_1
        String anlg9_1 = lstList.get(17).getTitleAnalogy();
        String sbct9_1 = lstList.get(17).getLearningSubContent();

        // Resaltado de Codigo
        rta1.setText(lstList.get(17).getSyntax());

        // EditorPane9_2
        String tips9_1 = lstList.get(17).getTips();

        // Resaltado de Codigo
        rta2.setText(coList.get(23).getSampleCode());

        // EditorPane9_3
        String out9_1 = coList.get(23).getOutputScreen();
        String cds9_1 = coList.get(23).getCodeDescription();

        String tmp9_1 = t.getGeneralTemplate("h2_p_h3BR");
        String tmp9_2 = t.getGeneralTemplate("p_h3BR");
        String tmp9_3 = t.getGeneralTemplate("p_pBR");

        addHTML(tmp9_1, edt1, anlg9_1, sbct9_1, stx);
        addHTML(tmp9_2, edt2, tips9_1, ejm);
        addHTML(tmp9_3, edt3, out9_1, cds9_1);
    }

    public void getRecursionContent(RSyntaxTextArea rta1, RSyntaxTextArea rta2,
            JEditorPane edt1, JEditorPane edt2, JEditorPane edt3) {

        // EditorPane10_1
        String anlg10_1 = lstList.get(18).getTitleAnalogy();
        String sbct10_1 = lstList.get(18).getLearningSubContent();

        // Resaltado de Codigo
        rta1.setText(lstList.get(18).getSyntax());

        // EditorPane10_2
        String cds10_1 = coList.get(24).getCodeDescription();

        // Resaltado de Codigo
        rta2.setText(coList.get(24).getSampleCode());

        // EditorPane10_3
        String out10_1 = coList.get(24).getOutputScreen();

        String tmp10_1 = t.getGeneralTemplate("h2_p_h3BR");
        String tmp10_2 = t.getGeneralTemplate("p_h3BR");
        String tmp10_3 = t.getGeneralTemplate("pBR");

        addHTML(tmp10_1, edt1, anlg10_1, sbct10_1, stx);
        addHTML(tmp10_2, edt2, cds10_1, ejm);
        addHTML(tmp10_3, edt3, out10_1);
    }

    public void getEstructBasicasContent(RSyntaxTextArea[] rta, JEditorPane[] edt) {

        //Envoltorios de Clase
        // EditorPane11_1
        String anlg11_1 = lstList.get(19).getTitleAnalogy();
        String sbct11_1 = lstList.get(19).getLearningSubContent();
        String tips11_1 = lstList.get(19).getTips();
        String stx11_1 = lstList.get(19).getSyntax();

        // Resaltado de Codigo
        rta[0].setText(coList.get(25).getSampleCode());

        String tmp11_1 = t.getGeneralTemplate("h2_p_p_p_h3BR3");

        addHTML(tmp11_1, edt[0], anlg11_1, sbct11_1, tips11_1, stx11_1, ejm);

        // Vectores Fijos ------------------------------------------------------
        // EditorPane11_2
        String anlg11_2 = lstList.get(20).getTitleAnalogy();
        String sbct11_2 = lstList.get(20).getLearningSubContent();
        String stx11_2 = lstList.get(20).getSyntax();

        // Resaltado de Sintaxis
        rta[1].setText(coList.get(26).getSampleCode());

        // EditorPane11_3
        String out11_1 = coList.get(26).getOutputScreen();

        // Resaltado de Sintaxis
        rta[2].setText(coList.get(27).getSampleCode());

        // EditorPane11_4
        String out11_2 = coList.get(27).getOutputScreen();
        String cds11_1 = coList.get(27).getCodeDescription();
        String tips11_2 = lstList.get(20).getTips();

        String tmp11_2 = t.getGeneralTemplate("h2_p_p_h3BR2");
        String tmp11_3 = t.getGeneralTemplate("p_h3BR");
        String tmp11_4 = t.getGeneralTemplate("p_p_pBR2");

        addHTML(tmp11_2, edt[1], anlg11_2, sbct11_2, stx11_2, ejm);
        addHTML(tmp11_3, edt[2], out11_1, ejm);
        addHTML(tmp11_4, edt[3], out11_2, cds11_1, tips11_2);

        // Vectores dinamicos --------------------------------------------------
        // EditorPane11_5
        String anlg11_3 = lstList.get(21).getTitleAnalogy();
        String sbct11_3 = lstList.get(21).getLearningSubContent();
        String stx11_3 = lstList.get(21).getSyntax();

        // Resaltado de Codigo
        rta[3].setText(coList.get(28).getSampleCode());

        // EditorPane11_6
        String out11_3 = coList.get(28).getOutputScreen();
        String tips11_3 = coList.get(28).getCodeDescription();

        String tmp11_5 = t.getGeneralTemplate("h2_p_p_h3BR2");
        String tmp11_6 = t.getGeneralTemplate("p_pBR");

        addHTML(tmp11_5, edt[4], anlg11_3, sbct11_3, stx11_3, ejm);
        addHTML(tmp11_6, edt[5], out11_3, tips11_3);

        // Matrices Fijas ------------------------------------------------------
        // EditorPane11_7
        String anlg11_4 = lstList.get(22).getTitleAnalogy();
        String sbct11_4 = lstList.get(22).getLearningSubContent();
        String stx11_4 = lstList.get(22).getSyntax();

        // Resaltado de Codido
        rta[4].setText(coList.get(29).getSampleCode());

        // EditorPane11_8
        String out11_4 = coList.get(29).getOutputScreen();
        String tips11_4 = coList.get(29).getCodeDescription();

        String tmp11_7 = t.getGeneralTemplate("h2_p_p_h3BR2");
        String tmp11_8 = t.getGeneralTemplate("p_pBR");

        addHTML(tmp11_7, edt[6], anlg11_4, sbct11_4, stx11_4, ejm);
        addHTML(tmp11_8, edt[7], out11_4, tips11_4);

        // Matrices Dinamicas --------------------------------------------------
        // EditorPane11_9
        String anlg11_5 = lstList.get(23).getTitleAnalogy();
        String sbct11_5 = lstList.get(23).getLearningSubContent();
        String stx11_5 = lstList.get(23).getSyntax();

        // Resaltado de Codigo
        rta[5].setText(coList.get(30).getSampleCode());

        // EditorPane11_10
        String out11_5 = coList.get(30).getOutputScreen();
        String tips11_5 = lstList.get(23).getTips();

        String tmp11_9 = t.getGeneralTemplate("h2_p_p_h3BR2");
        String tmp11_10 = t.getGeneralTemplate("p_p");

        addHTML(tmp11_9, edt[8], anlg11_5, sbct11_5, stx11_5, ejm);
        addHTML(tmp11_10, edt[9], out11_5, tips11_5);

        // Pilas ---------------------------------------------------------------
        // EditorPane11_11
        String anlg11_6 = lstList.get(24).getTitleAnalogy();
        String sbct11_6 = lstList.get(24).getLearningSubContent();
        String stx11_6 = lstList.get(24).getSyntax();

        // Resaltado de Codigo
        rta[6].setText(coList.get(31).getSampleCode());

        // EditorPane11_12
        String out11_6 = coList.get(31).getOutputScreen();
        String tips11_6 = lstList.get(24).getTips();

        String tmp11_11 = t.getGeneralTemplate("h2_p_p_h3BR2");
        String tmp11_12 = t.getGeneralTemplate("p_p");

        addHTML(tmp11_11, edt[10], anlg11_6, sbct11_6, stx11_6, ejm);
        addHTML(tmp11_12, edt[11], out11_6, tips11_6);

        //Colas ----------------------------------------------------------------
        // EditorPane11_13
        String anlg11_7 = lstList.get(25).getTitleAnalogy();
        String sbct11_7 = lstList.get(25).getLearningSubContent();
        String stx11_7 = lstList.get(25).getSyntax();

        // Resaltado de Sintaxis
        rta[7].setText(coList.get(32).getSampleCode());

        // EditorPane11_14
        String out11_7 = coList.get(32).getOutputScreen();
        String tips11_7 = coList.get(32).getCodeDescription();

        String tmp11_13 = t.getGeneralTemplate("h2_p_p_h3BR2");
        String tmp11_14 = t.getGeneralTemplate("p_p");

        addHTML(tmp11_13, edt[12], anlg11_7, sbct11_7, stx11_7, ejm);
        addHTML(tmp11_14, edt[13], out11_7, tips11_7);
    }

    public void getEstructIntermediasContent(RSyntaxTextArea rta1, RSyntaxTextArea rta2,
            RSyntaxTextArea rta3, RSyntaxTextArea rta4, JEditorPane... edtList) {

        JEditorPane[] edt = (JEditorPane[]) edtList;

        // EditorPane12_1
        String anlg12_1 = lstList.get(26).getTitleAnalogy();
        String sbct12_1 = lstList.get(26).getSyntax();

        String tmp12_1 = t.getGeneralTemplate("h2_p");

        addHTML(tmp12_1, edt[0], anlg12_1, sbct12_1);

        // ---------------------------------------------------------------------
        // EditorPane12_2
        String sbct12_2 = lstList.get(26).getLearningSubContent();

        String tmp12_2 = t.getGeneralTemplate("p");

        addHTML(tmp12_2, edt[1], sbct12_2);

        // HashSet -------------------------------------------------------------
        // EditorPane12_3
        String sbct12_3 = lstList.get(27).getLearningSubContent();
        String stx12_1 = lstList.get(27).getSyntax();

        // Resaltado de Codigo
        rta1.setText(coList.get(33).getSampleCode());

        // EditorPane12_4
        String out12_1 = coList.get(33).getOutputScreen();

        String tmp12_3 = t.getGeneralTemplate("p_p_h3BR1");
        String tmp12_4 = t.getGeneralTemplate("p");

        addHTML(tmp12_3, edt[2], sbct12_3, stx12_1, ejm);
        addHTML(tmp12_4, edt[3], out12_1);

        // TreeSet -------------------------------------------------------------
        // EditorPane12_5
        String sbct12_4 = lstList.get(28).getLearningSubContent();
        String stx12_2 = lstList.get(28).getSyntax();

        // Resaltado de Codigo
        rta2.setText(coList.get(34).getSampleCode());

        // EditorPane12_6
        String out12_2 = coList.get(34).getOutputScreen();
        String tips12_1 = lstList.get(28).getTips();

        String tmp12_5 = t.getGeneralTemplate("p_p_h3BR1");
        String tmp12_6 = t.getGeneralTemplate("p_pBR");

        addHTML(tmp12_5, edt[4], sbct12_4, stx12_2, ejm);
        addHTML(tmp12_6, edt[5], out12_2, tips12_1);

        // Maps ----------------------------------------------------------------
        // EditorPane12_7
        String sbct12_5 = lstList.get(29).getLearningSubContent();

        String tmp12_7 = t.getGeneralTemplate("p");

        addHTML(tmp12_7, edt[6], sbct12_5);

        // HashMap -------------------------------------------------------------
        // EditorPane12_8
        String sbct12_6 = lstList.get(30).getLearningSubContent();
        String stx12_3 = lstList.get(30).getSyntax();

        // Resaltado de Codigo
        rta3.setText(coList.get(35).getSampleCode());

        // EditorPane12_9
        String out12_3 = coList.get(35).getOutputScreen();

        String tmp12_8 = t.getGeneralTemplate("p_p_h3BR2");
        String tmp12_9 = t.getGeneralTemplate("p");

        addHTML(tmp12_8, edt[7], sbct12_6, stx12_3, ejm);
        addHTML(tmp12_9, edt[8], out12_3);

        // TreeMap -------------------------------------------------------------
        // EditorPane12_10
        String sbct12_7 = lstList.get(31).getLearningSubContent();
        String stx12_4 = lstList.get(31).getSyntax();

        // Resaltado de Codigo
        rta4.setText(coList.get(36).getSampleCode());

        // EditorPane12_11
        String out12_4 = coList.get(36).getOutputScreen();

        String tmp12_10 = t.getGeneralTemplate("p_p_h3BR2");
        String tmp12_11 = t.getGeneralTemplate("p");

        addHTML(tmp12_10, edt[9], sbct12_7, stx12_4, ejm);
        addHTML(tmp12_11, edt[10], out12_4);
    }

    public void getAlgoritmosContent(RSyntaxTextArea rta1, RSyntaxTextArea rta2,
            JEditorPane edt1, JEditorPane edt2, JEditorPane edt3, JEditorPane edt4,
            JEditorPane edt5, JEditorPane edt6) {
        String[] parrafos = lstList.get(32).getLearningSubContent().split("\n");

        // EditorPane13_1
        String anlg13_1 = lstList.get(32).getTitleAnalogy();
        String sbct13_1 = parrafos[0];

        // Resaltado de Codigo
        rta1.setText(coList.get(37).getSampleCode());

        // EditorPane13_2
        String out13_1 = coList.get(37).getOutputScreen();
        String sbct13_2 = parrafos[1];

        // EditorPane13_3
        String sbct13_3 = parrafos[2];
        String tip13_1 = lstList.get(32).getTips();

        String tmp13_1 = t.getGeneralTemplate("h2_p_h3BR");
        String tmp13_2 = t.getGeneralTemplate("p_pBR");
        String tmp13_3 = t.getGeneralTemplate("p_pBR");

        addHTML(tmp13_1, edt1, anlg13_1, sbct13_1, ejm);
        addHTML(tmp13_2, edt2, out13_1, sbct13_2);
        addHTML(tmp13_3, edt3, sbct13_3, tip13_1);

        // BinarySearch --------------------------------------------------------
        String[] parrafos_1 = lstList.get(33).getLearningSubContent().split("\n");

        // EditorPane13_4
        String anlg13_2 = lstList.get(32).getTitleAnalogy();
        String sbct13_4 = parrafos_1[0];

        // Resaltado de Codigo
        rta2.setText(coList.get(38).getSampleCode());

        // EditorPane13_5
        String out13_2 = coList.get(38).getOutputScreen();
        String sbct13_5 = parrafos_1[1];

        // EditorPane13_6
        String sbct13_6 = parrafos_1[2];
        String tips13_2 = lstList.get(33).getTips();

        String tmp13_4 = t.getGeneralTemplate("h2_p_h3BR");
        String tmp13_5 = t.getGeneralTemplate("p_pBR");
        String tmp13_6 = t.getGeneralTemplate("p_pBR");

        addHTML(tmp13_4, edt4, anlg13_2, sbct13_4, ejm);
        addHTML(tmp13_5, edt5, out13_2, sbct13_5);
        addHTML(tmp13_6, edt6, sbct13_6, tips13_2);
    }

    public void getHistoryContent(JEditorPane edtHistory) {

        String Title1 = htList.get(0).getHistoryTopicTitle();
        String Title2 = htList.get(1).getHistoryTopicTitle();
        String Title3 = htList.get(2).getHistoryTopicTitle();
        String Title4 = htList.get(3).getHistoryTopicTitle();
        String Title5 = htList.get(4).getHistoryTopicTitle();
        String Title6 = htList.get(5).getHistoryTopicTitle();

        String SubTitle1 = hsList.get(1).getHistorySubTitle();
        String SubTitle2 = hsList.get(2).getHistorySubTitle();
        String SubTitle3 = hsList.get(3).getHistorySubTitle();
        String SubTitle4 = hsList.get(4).getHistorySubTitle();
        String SubTitle5 = hsList.get(5).getHistorySubTitle();
        String SubTitle6 = hsList.get(6).getHistorySubTitle();
        String SubTitle7 = hsList.get(7).getHistorySubTitle();
        String SubTitle8 = hsList.get(8).getHistorySubTitle();
        String SubTitle9 = hsList.get(9).getHistorySubTitle();
        String SubTitle10 = hsList.get(10).getHistorySubTitle();
        String SubTitle11 = hsList.get(11).getHistorySubTitle();
        String SubTitle12 = hsList.get(13).getHistorySubTitle();
        String SubTitle13 = hsList.get(14).getHistorySubTitle();
        String SubTitle14 = hsList.get(15).getHistorySubTitle();

        String Content1 = hsList.get(0).getHistorySubContent();
        String Content2 = hsList.get(1).getHistorySubContent();
        String Content3 = hsList.get(2).getHistorySubContent();
        String Content4 = hsList.get(3).getHistorySubContent();
        String Content5 = hsList.get(4).getHistorySubContent();
        String Content6 = hsList.get(5).getHistorySubContent();
        String Content7 = hsList.get(6).getHistorySubContent();
        String Content8 = hsList.get(7).getHistorySubContent();
        String Content9 = hsList.get(8).getHistorySubContent();
        String Content10 = hsList.get(9).getHistorySubContent();
        String Content11 = hsList.get(10).getHistorySubContent();
        String Content12 = hsList.get(11).getHistorySubContent();
        String Content13 = hsList.get(12).getHistorySubContent();
        String Content14 = hsList.get(13).getHistorySubContent();
        String Content15 = hsList.get(14).getHistorySubContent();
        String Content16 = hsList.get(15).getHistorySubContent();
        String Content17 = hsList.get(16).getHistorySubContent();

        addHTML(t.getHistoryTemplate(), edtHistory, Title1, Content1, Title2,
                SubTitle1, Content2, SubTitle2, Content3, Title3,
                SubTitle3, Content4, SubTitle4, Content5, SubTitle5,
                Content6, SubTitle6, Content7, SubTitle7, Content8,
                SubTitle8, Content9, SubTitle9, Content10, Title4,
                SubTitle10, Content11, SubTitle11,
                Content12, Title5, Content13, SubTitle12, Content14,
                SubTitle13, Content15, SubTitle14, Content16, Title6,
                Content17);
    }

    public void getExer1LearnContent(JEditorPane edt_Ejercicio1) {

        String title1 = eList.get(20).getExerciseName();
        String content1 = ecList.get(20).getExerciseDescription();
        String input1 = ecList.get(20).getInput();
        String output1 = ecList.get(20).getOutput();
        String sample_Input1 = ecList.get(20).getSampleInput();
        String sample_Output1 = ecList.get(20).getSampleOutput();

        addHTML(t.getExerciseTemplateLearn(), edt_Ejercicio1, title1, content1, input1,
                output1, sample_Input1, sample_Output1);
    }

    public void getExer2LearnContent(JEditorPane edt_Ejercicio2) {

        String title2 = eList.get(21).getExerciseName();
        String content2 = ecList.get(21).getExerciseDescription();
        String input2 = ecList.get(21).getInput();
        String output2 = ecList.get(21).getOutput();
        String sample_Input2 = ecList.get(21).getSampleInput();
        String sample_Output2 = ecList.get(21).getSampleOutput();

        addHTML(t.getExerciseTemplateLearn(), edt_Ejercicio2, title2, content2, input2,
                output2, sample_Input2, sample_Output2);
    }

    public void getExer3LearnContent(JEditorPane edt_Ejercicio3) {

        String title3 = eList.get(22).getExerciseName();
        String content3 = ecList.get(22).getExerciseDescription();
        String input3 = ecList.get(22).getInput();
        String output3 = ecList.get(22).getOutput();
        String sample_Input3 = ecList.get(22).getSampleInput();
        String sample_Output3 = ecList.get(22).getSampleOutput();

        addHTML(t.getExerciseTemplateLearn(), edt_Ejercicio3, title3, content3, input3,
                output3, sample_Input3, sample_Output3);
    }

    public void clearListExercises() {
        eList.clear();
    }

//    public EntityManagerFactory regenerateConnectionUpdate() {
//        this.emf = Persistence.createEntityManagerFactory("ApoloPU");
//        setConnectionDB(this.emf);
//        EntityManager em = this.emf.createEntityManager();
//        em.getTransaction().begin();
//        clearListExercises();
//        Query q = em.createQuery("Select ex from Exercises ex");
//        eList = (List<Exercises>) q.getResultList();
//        em.close();
//        return this.emf;
//    }
}
