package Salida;

// Librerias Creadas
import Main.EditorDeCodigo;
import Services.RecursosService;

// Librerias Default
import javax.swing.UIManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

public class ExitEditor extends javax.swing.JFrame {

    private final RecursosService sRecursos;

    public ExitEditor() {
        sRecursos = RecursosService.getService();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Salida = new javax.swing.JPanel();
        Lbl_Salida = new javax.swing.JLabel();
        Lbl_Mensaje = new javax.swing.JLabel();
        Btn_No = new javax.swing.JButton();
        Btn_Si = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 100));
        setUndecorated(true);

        Pnl_Salida.setBackground(new java.awt.Color(250, 250, 250));
        Pnl_Salida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Pnl_Salida.setMaximumSize(new java.awt.Dimension(300, 100));
        Pnl_Salida.setMinimumSize(new java.awt.Dimension(300, 100));
        Pnl_Salida.setPreferredSize(new java.awt.Dimension(300, 100));
        Pnl_Salida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Salida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Advertencia.png"))); // NOI18N
        Pnl_Salida.add(Lbl_Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, 42));

        Lbl_Mensaje.setFont(sRecursos.getFContentTip());
        Lbl_Mensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Mensaje.setText("¿Desea guardar el código?");
        Pnl_Salida.add(Lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 190, -1));

        Btn_No.setBackground(new java.awt.Color(255, 255, 255));
        Btn_No.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Btn_No.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/No_Off.png"))); // NOI18N
        Btn_No.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Btn_No.setBorderPainted(false);
        Btn_No.setContentAreaFilled(false);
        Btn_No.setFocusPainted(false);
        Btn_No.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_No.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/No_On.png"))); // NOI18N
        Btn_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NoActionPerformed(evt);
            }
        });
        Pnl_Salida.add(Btn_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 52, 32));

        Btn_Si.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Si.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Btn_Si.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Si_Off.png"))); // NOI18N
        Btn_Si.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Btn_Si.setBorderPainted(false);
        Btn_Si.setContentAreaFilled(false);
        Btn_Si.setFocusPainted(false);
        Btn_Si.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Si.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Si_On.png"))); // NOI18N
        Btn_Si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SiActionPerformed(evt);
            }
        });
        Pnl_Salida.add(Btn_Si, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 52, 32));

        getContentPane().add(Pnl_Salida, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(280, 100));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SiActionPerformed

    }//GEN-LAST:event_Btn_SiActionPerformed

    private void Btn_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NoActionPerformed

    }//GEN-LAST:event_Btn_NoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(EditorDeCodigo.class.getName()).log(Level.SEVERE, null, ex);
            }
            new ExitEditor().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn_No;
    public javax.swing.JButton Btn_Si;
    private javax.swing.JLabel Lbl_Mensaje;
    private javax.swing.JLabel Lbl_Salida;
    private javax.swing.JPanel Pnl_Salida;
    // End of variables declaration//GEN-END:variables
}
