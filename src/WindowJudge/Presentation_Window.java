package WindowJudge;

import Services.RecursosService;

public class Presentation_Window extends javax.swing.JFrame {

    RecursosService sRecursos;

    public Presentation_Window() {
        sRecursos = RecursosService.getService();
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_PresentationError = new javax.swing.JPanel();
        Btn_Ok = new javax.swing.JButton();
        Lbl_Mensaje = new javax.swing.JLabel();
        Lbl_PresentationError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        Pnl_PresentationError.setBackground(sRecursos.getColorDark());
        Pnl_PresentationError.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 159, 227), 2, true));
        Pnl_PresentationError.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        Pnl_PresentationError.add(Btn_Ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 54, -1));

        Lbl_Mensaje.setFont(sRecursos.getFWindow());
        Lbl_Mensaje.setForeground(sRecursos.getColorTextGray());
        Lbl_Mensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Mensaje.setText("<html><body style='text-align: center'>??Revisa los espacios<br>en blanco!"); // NOI18N
        Lbl_Mensaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_PresentationError.add(Lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, -1));

        Lbl_PresentationError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/PresentationError.png"))); // NOI18N
        Pnl_PresentationError.add(Lbl_PresentationError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_PresentationError, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_PresentationError, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_OkActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_OkActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Presentation_Window().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Ok;
    private javax.swing.JLabel Lbl_Mensaje;
    private javax.swing.JLabel Lbl_PresentationError;
    private javax.swing.JPanel Pnl_PresentationError;
    // End of variables declaration//GEN-END:variables
}
