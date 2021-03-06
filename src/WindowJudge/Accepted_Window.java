package WindowJudge;

import Services.RecursosService;

public class Accepted_Window extends javax.swing.JFrame {

    private final RecursosService sRecursos;

    public Accepted_Window() {
        sRecursos = RecursosService.getService();
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Accepted = new javax.swing.JPanel();
        Lbl_Mensaje = new javax.swing.JLabel();
        Btn_Ok = new javax.swing.JButton();
        Lbl_Accepted = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Accepted.setBackground(sRecursos.getColorDark());
        Pnl_Accepted.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 170, 53), 2, true));
        Pnl_Accepted.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Mensaje.setBackground(sRecursos.getColorDark());
        Lbl_Mensaje.setFont(sRecursos.getFWindow());
        Lbl_Mensaje.setForeground(sRecursos.getColorTextGray());
        Lbl_Mensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Mensaje.setText("¡Tú código es correcto!");
        Lbl_Mensaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_Accepted.add(Lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, -1));

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
        Pnl_Accepted.add(Btn_Ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 54, 40));

        Lbl_Accepted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Accepted.png"))); // NOI18N
        Pnl_Accepted.add(Lbl_Accepted, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(Pnl_Accepted, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_OkActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_OkActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Accepted_Window().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Ok;
    private javax.swing.JLabel Lbl_Accepted;
    private javax.swing.JLabel Lbl_Mensaje;
    private javax.swing.JPanel Pnl_Accepted;
    // End of variables declaration//GEN-END:variables
}
