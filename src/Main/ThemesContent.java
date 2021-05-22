package Main;

import Entities.Codes;
import Entities.LearningSubtopics;
import JPA_Controllers.CodesJpaController;
import JPA_Controllers.LearningSubtopicsJpaController;
import Services.RecursosService;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JEditorPane;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class ThemesContent {

    private final RecursosService sRecursos = RecursosService.getService();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApoloPU");

    LearningSubtopicsJpaController lstjpa = new LearningSubtopicsJpaController(emf);
    CodesJpaController cojpa = new CodesJpaController(emf);

    List<LearningSubtopics> lstList = lstjpa.findLearningSubtopicsEntities();
    List<Codes> coList = cojpa.findCodesEntities();

    HTMLTemplates t = new HTMLTemplates();

    private final String stx = "Sintaxis";
    private final String ejm = "Código de Ejemplo";

    private void addHTML(String tmp, JEditorPane edt, String... s) {
        String text = String.format(tmp, (Object[]) s);
        edt.setText(text);
        edt.setFont(sRecursos.getFGeneral());
        edt.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        edt.setEditable(false);
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

        String tmp0_1 = t.getTemplate("h2_p_h3");
        String tmp0_2 = t.getTemplate("p_p_p");

        addHTML(tmp0_1, e1, anlg0, sbct0_1, ejm);
        addHTML(tmp0_2, e2, out0, sbct0_2, sbct0_3);
    }

    public void getComentariosContent(RSyntaxTextArea rta1, RSyntaxTextArea rta2, RSyntaxTextArea rta3,
            JEditorPane e1, JEditorPane e2, JEditorPane e3, JEditorPane e4) {

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

        String tmp1_1 = t.getTemplate("h2_p_p_h3BR2");
        String tmp1_2 = t.getTemplate("p_p_h3BR1");
        String tmp1_3 = t.getTemplate("p_p_h3BR1");
        String tmp1_4 = t.getTemplate("p");

        addHTML(tmp1_1, e1, anlg1, sbct1_1, sbct1_2, ejm);
        addHTML(tmp1_2, e2, out1_1, sbct1_3, ejm);
        addHTML(tmp1_3, e3, out1_2, sbct1_4, ejm);
        addHTML(tmp1_4, e4, out1_3);
    }

}
