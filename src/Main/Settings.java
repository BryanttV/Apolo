package Main;

import Services.RecursosService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Settings extends javax.swing.JDialog {

    private final RecursosService sRecursos;

    public Settings(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        sRecursos = RecursosService.getService();
        initComponents();
        setLocationRelativeTo(parent);
        Lbl_ColorVentanas.setFont(sRecursos.getFLabelSettings());
        Rbtn_Dark.setFont(sRecursos.getFWindow());
        Rbtn_Light.setFont(sRecursos.getFWindow());
        BtnG_Tema.add(Rbtn_Dark);
        BtnG_Tema.add(Rbtn_Light);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnG_Tema = new javax.swing.ButtonGroup();
        Pnl_Ajustes = new javax.swing.JPanel();
        Lbl_Header_Settings = new javax.swing.JLabel();
        Btn_Regresar = new javax.swing.JButton();
        Lbl_ColorVentanas = new javax.swing.JLabel();
        Rbtn_Dark = new javax.swing.JRadioButton();
        Rbtn_Light = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        Pnl_Ajustes.setBackground(sRecursos.getColorDark());
        Pnl_Ajustes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Header_Ajustes.png"))); // NOI18N
        Pnl_Ajustes.add(Lbl_Header_Settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 10, -1, -1));

        Btn_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Regresar_Off.png"))); // NOI18N
        Btn_Regresar.setBorderPainted(false);
        Btn_Regresar.setContentAreaFilled(false);
        Btn_Regresar.setCursor(sRecursos.getCMano());
        Btn_Regresar.setFocusPainted(false);
        Btn_Regresar.setFocusable(false);
        Btn_Regresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Regresar_On.png"))); // NOI18N
        Btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RegresarActionPerformed(evt);
            }
        });
        Pnl_Ajustes.add(Btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 130, 50));

        Lbl_ColorVentanas.setForeground(sRecursos.getColorTextGray());
        Lbl_ColorVentanas.setText("Fondo Ventanas Emergentes");
        Pnl_Ajustes.add(Lbl_ColorVentanas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        Rbtn_Dark.setForeground(sRecursos.getColorTextGray());
        Rbtn_Dark.setText("Dark");
        Rbtn_Dark.setFocusPainted(false);
        Rbtn_Dark.setFocusable(false);
        Rbtn_Dark.setOpaque(false);
        Pnl_Ajustes.add(Rbtn_Dark, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        Rbtn_Light.setForeground(sRecursos.getColorTextGray());
        Rbtn_Light.setText("Light");
        Rbtn_Light.setFocusPainted(false);
        Rbtn_Light.setFocusable(false);
        Rbtn_Light.setOpaque(false);
        Pnl_Ajustes.add(Rbtn_Light, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_Ajustes, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_Ajustes, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_RegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_RegresarActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HomeApolo.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            Settings dialog = new Settings(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnG_Tema;
    private javax.swing.JButton Btn_Regresar;
    private javax.swing.JLabel Lbl_ColorVentanas;
    private javax.swing.JLabel Lbl_Header_Settings;
    private javax.swing.JPanel Pnl_Ajustes;
    private javax.swing.JRadioButton Rbtn_Dark;
    private javax.swing.JRadioButton Rbtn_Light;
    // End of variables declaration//GEN-END:variables
}
