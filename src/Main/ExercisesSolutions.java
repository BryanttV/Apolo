package Main;

// Librerias Creadas
import Services.RecursosService;

// Librerias Externas
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

// Librerias Default
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import javax.swing.JPanel;

public class ExercisesSolutions extends javax.swing.JDialog {

    private final RecursosService sRecursos = RecursosService.getService();
    private final RSyntaxTextArea syntaxExerciseSolution = new RSyntaxTextArea();

    public ExercisesSolutions(java.awt.Frame parent, boolean modal, String re) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        configureWindow();
        addRSyntax(Pnl_SolucionEjercicio, syntaxExerciseSolution);
        syntaxExerciseSolution.setText(re);
    }

    private void changeStyleViaThemeXml(RSyntaxTextArea rta) {
        try {
            String tema_xml = "/org/fife/ui/rsyntaxtextarea/themes/monokai.xml";
            Theme theme = Theme.load(getClass().getResourceAsStream(tema_xml));
            theme.apply(rta);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    private void copyCode() {
        StringSelection stringSelection = new StringSelection(syntaxExerciseSolution.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    private void configureWindow() {
        Lbl_SolucionEjercicio.setFont(sRecursos.getFTitleTips());
        Lbl_SolucionEjercicio.setForeground(sRecursos.getColorTextGray());
    }

    private void addRSyntax(JPanel p, RSyntaxTextArea rta) {
        rta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        changeStyleViaThemeXml(rta);
        rta.setFont(new Font("Consolas", Font.PLAIN, 14));
        rta.setBackground(sRecursos.getColorDark());
        rta.setAntiAliasingEnabled(true);
        rta.setUseFocusableTips(false);
        rta.setEditable(false);
        rta.revalidate();
        p.add(rta);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_General = new javax.swing.JPanel();
        Btn_Cerrar = new javax.swing.JButton();
        Pnl_SolucionEjercicio = new javax.swing.JPanel();
        Lbl_SolucionEjercicio = new javax.swing.JLabel();
        Btn_Cerrar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(450, 510));
        setMinimumSize(new java.awt.Dimension(450, 510));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(450, 510));

        Pnl_General.setBackground(sRecursos.getColorDark());
        Pnl_General.setMaximumSize(new java.awt.Dimension(450, 510));
        Pnl_General.setMinimumSize(new java.awt.Dimension(450, 510));
        Pnl_General.setPreferredSize(new java.awt.Dimension(450, 510));
        Pnl_General.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Cerrar_Off.png"))); // NOI18N
        Btn_Cerrar.setBorderPainted(false);
        Btn_Cerrar.setContentAreaFilled(false);
        Btn_Cerrar.setFocusPainted(false);
        Btn_Cerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Cerrar_On.png"))); // NOI18N
        Btn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CerrarActionPerformed(evt);
            }
        });
        Pnl_General.add(Btn_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 5, 30, 30));

        Pnl_SolucionEjercicio.setBorder(javax.swing.BorderFactory.createLineBorder(sRecursos.getColorGrisBorde()));
        Pnl_SolucionEjercicio.setMaximumSize(new java.awt.Dimension(440, 510));
        Pnl_SolucionEjercicio.setMinimumSize(new java.awt.Dimension(440, 510));
        Pnl_SolucionEjercicio.setPreferredSize(new java.awt.Dimension(440, 510));
        Pnl_SolucionEjercicio.setLayout(new java.awt.CardLayout());
        Pnl_General.add(Pnl_SolucionEjercicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 430, 460));

        Lbl_SolucionEjercicio.setText("Solución");
        Pnl_General.add(Lbl_SolucionEjercicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 20));

        Btn_Cerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Copiar_Off.png"))); // NOI18N
        Btn_Cerrar1.setBorderPainted(false);
        Btn_Cerrar1.setContentAreaFilled(false);
        Btn_Cerrar1.setFocusPainted(false);
        Btn_Cerrar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Copiar_On.png"))); // NOI18N
        Btn_Cerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Cerrar1ActionPerformed(evt);
            }
        });
        Pnl_General.add(Btn_Cerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 5, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_General, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_General, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_CerrarActionPerformed

    private void Btn_Cerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Cerrar1ActionPerformed
        copyCode();
    }//GEN-LAST:event_Btn_Cerrar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cerrar;
    private javax.swing.JButton Btn_Cerrar1;
    private javax.swing.JLabel Lbl_SolucionEjercicio;
    private javax.swing.JPanel Pnl_General;
    private javax.swing.JPanel Pnl_SolucionEjercicio;
    // End of variables declaration//GEN-END:variables
}
