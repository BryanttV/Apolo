package Main;

import Tipografias.Fuentes;
import java.awt.Font;

public class Presentation_window extends javax.swing.JFrame {

    private final Fuentes f = new Fuentes();
    private final Font euclid = f.fuente(f.EUCR, 0, 16);

    public Presentation_window() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_PresentationError = new javax.swing.JPanel();
        Lbl_CompileError = new javax.swing.JLabel();
        Btn_Ok = new javax.swing.JButton();
        Lbl_Mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        Pnl_PresentationError.setBackground(new java.awt.Color(255, 255, 255));
        Pnl_PresentationError.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(7, 89, 157), 2, true));
        Pnl_PresentationError.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_CompileError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/PresentationError.png"))); // NOI18N
        Pnl_PresentationError.add(Lbl_CompileError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Btn_Ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Ok_Off.png"))); // NOI18N
        Btn_Ok.setBorderPainted(false);
        Btn_Ok.setContentAreaFilled(false);
        Btn_Ok.setFocusPainted(false);
        Btn_Ok.setFocusable(false);
        Btn_Ok.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Ok_On.png"))); // NOI18N
        Btn_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_OkActionPerformed(evt);
            }
        });
        Pnl_PresentationError.add(Btn_Ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 54, -1));

        Lbl_Mensaje.setFont(euclid);
        Lbl_Mensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Mensaje.setText("<html><body style='text-align: center'>¡Revisa los espacios<br>en blanco!"); // NOI18N
        Lbl_Mensaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_PresentationError.add(Lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, -1));

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
        dispose();
    }//GEN-LAST:event_Btn_OkActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Presentation_window().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Ok;
    private javax.swing.JLabel Lbl_CompileError;
    private javax.swing.JLabel Lbl_Mensaje;
    private javax.swing.JPanel Pnl_PresentationError;
    // End of variables declaration//GEN-END:variables
}
