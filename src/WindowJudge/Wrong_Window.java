package WindowJudge;

import Services.RecursosService;

public class Wrong_Window extends javax.swing.JFrame {

    RecursosService sRecursos;

    public Wrong_Window() {
        sRecursos = RecursosService.getService();
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_WrongAnswer = new javax.swing.JPanel();
        Lbl_WrongAnswer = new javax.swing.JLabel();
        Lbl_Mensaje = new javax.swing.JLabel();
        Btn_Ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        Pnl_WrongAnswer.setBackground(sRecursos.getColorDark());
        Pnl_WrongAnswer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 51, 42), 2, true));
        Pnl_WrongAnswer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_WrongAnswer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/WrongAnswer.png"))); // NOI18N
        Pnl_WrongAnswer.add(Lbl_WrongAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Lbl_Mensaje.setFont(sRecursos.getFWindow());
        Lbl_Mensaje.setForeground(sRecursos.getColorTextGray());
        Lbl_Mensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Mensaje.setText("¡Tú código es incorrecto!");
        Lbl_Mensaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_WrongAnswer.add(Lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, -1));

        Btn_Ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Ok_Off_Dark.png"))); // NOI18N
        Btn_Ok.setBorderPainted(false);
        Btn_Ok.setContentAreaFilled(false);
        Btn_Ok.setFocusPainted(false);
        Btn_Ok.setFocusable(false);
        Btn_Ok.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Ok_On_Dark.png"))); // NOI18N
        Btn_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_OkActionPerformed(evt);
            }
        });
        Pnl_WrongAnswer.add(Btn_Ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 54, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_WrongAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_WrongAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_OkActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_OkActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Wrong_Window().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Ok;
    private javax.swing.JLabel Lbl_Mensaje;
    private javax.swing.JLabel Lbl_WrongAnswer;
    private javax.swing.JPanel Pnl_WrongAnswer;
    // End of variables declaration//GEN-END:variables
}
