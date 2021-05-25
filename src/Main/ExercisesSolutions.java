package Main;

import Entities.Exercises;
import Services.RecursosService;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JPanel;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;

public class ExercisesSolutions extends javax.swing.JDialog {
    private final RecursosService sRecursos = RecursosService.getService();
    private final RSyntaxTextArea syntaxExerciseSolution1 = new RSyntaxTextArea();
    
    public ExercisesSolutions(java.awt.Frame parent, boolean modal, String re) {
        super(parent, modal);
        this.setLocationRelativeTo(null);
        initComponents();
        addRSyntax(Pnl_CodesThemes0, syntaxExerciseSolution1);
        syntaxExerciseSolution1.setText(re);
    }
    
    
    private void changeStyleViaThemeXml(RSyntaxTextArea rta) {
        try {
            String tema_xml = "/org/fife/ui/rsyntaxtextarea/themes/eclipse.xml";
            Theme theme = Theme.load(getClass().getResourceAsStream(tema_xml));
            theme.apply(rta);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
    
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
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_CodesThemes0 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 530));
        setMinimumSize(new java.awt.Dimension(600, 530));
        setPreferredSize(new java.awt.Dimension(600, 530));

        Pnl_CodesThemes0.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 2, true));
        Pnl_CodesThemes0.setMaximumSize(new java.awt.Dimension(600, 530));
        Pnl_CodesThemes0.setMinimumSize(new java.awt.Dimension(600, 530));
        Pnl_CodesThemes0.setPreferredSize(new java.awt.Dimension(600, 530));
        Pnl_CodesThemes0.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_CodesThemes0, javax.swing.GroupLayout.PREFERRED_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_CodesThemes0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pnl_CodesThemes0;
    // End of variables declaration//GEN-END:variables
}
