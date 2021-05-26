package Main;

import Services.RecursosService;
import javax.swing.JEditorPane;

public class VerifyQuestions extends javax.swing.JDialog {

    private final RecursosService sRecursos;
    private final String template = "<html>"
            + "<p style=\"margin: 0; text-align: center;\"><b>Pregunta 1:</b> %s</p>"
            + "<p style=\"margin: 0; text-align: center;\"><b>Pregunta 2:</b> %s</p>"
            + "<p style=\"margin: 0; text-align: center;\"><b>Pregunta 3:</b> %s</p>"
            + "</html>";
    private String p1, p2, p3;

    public VerifyQuestions(java.awt.Frame parent, boolean modal, String p1, String p2, String p3) {
        super(parent, modal);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        sRecursos = RecursosService.getService();
        initComponents();
        configureText();
        this.setLocationRelativeTo(parent);
    }

    private void configureText() {
        String text = String.format(template, this.p1, this.p2, this.p3);
        Edt_VerifyQuestion.setText(text);
        Edt_VerifyQuestion.setFont(sRecursos.getFGeneral());
        Edt_VerifyQuestion.setForeground(sRecursos.getColorTextGray());
        Edt_VerifyQuestion.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_VerifyQuesiton = new javax.swing.JPanel();
        Btn_Cerrar = new javax.swing.JButton();
        Scp_VerifyQuestion = new javax.swing.JScrollPane();
        Edt_VerifyQuestion = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(230, 120));
        setMinimumSize(new java.awt.Dimension(230, 120));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(230, 120));

        Pnl_VerifyQuesiton.setBackground(sRecursos.getColorDark());
        Pnl_VerifyQuesiton.setMaximumSize(new java.awt.Dimension(230, 120));
        Pnl_VerifyQuesiton.setMinimumSize(new java.awt.Dimension(230, 120));
        Pnl_VerifyQuesiton.setPreferredSize(new java.awt.Dimension(230, 120));
        Pnl_VerifyQuesiton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        Pnl_VerifyQuesiton.add(Btn_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 5, 30, 30));

        Scp_VerifyQuestion.setBorder(null);
        Scp_VerifyQuestion.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_VerifyQuestion.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        Scp_VerifyQuestion.setOpaque(false);

        Edt_VerifyQuestion.setEditable(false);
        Edt_VerifyQuestion.setBackground(sRecursos.getColorDark());
        Edt_VerifyQuestion.setBorder(null);
        Edt_VerifyQuestion.setContentType("text/html"); // NOI18N
        Edt_VerifyQuestion.setSelectionColor(new java.awt.Color(100, 100, 100));
        Scp_VerifyQuestion.setViewportView(Edt_VerifyQuestion);

        Pnl_VerifyQuesiton.add(Scp_VerifyQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 40, 210, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_VerifyQuesiton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_VerifyQuesiton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_CerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cerrar;
    private javax.swing.JEditorPane Edt_VerifyQuestion;
    private javax.swing.JPanel Pnl_VerifyQuesiton;
    private javax.swing.JScrollPane Scp_VerifyQuestion;
    // End of variables declaration//GEN-END:variables
}
