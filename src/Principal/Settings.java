package Principal;

import Services.RecursosService;

public class Settings extends javax.swing.JDialog {

    private final RecursosService sRecursos;

    public Settings(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        sRecursos = RecursosService.getService();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Ajustes = new javax.swing.JPanel();
        Label_Ajustes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Panel_Ajustes.setBackground(sRecursos.getColorDark());

        Label_Ajustes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Label_Ajustes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Ajustes.setText("Ventana de Ajustes");
        Label_Ajustes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout Panel_AjustesLayout = new javax.swing.GroupLayout(Panel_Ajustes);
        Panel_Ajustes.setLayout(Panel_AjustesLayout);
        Panel_AjustesLayout.setHorizontalGroup(
            Panel_AjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AjustesLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(Label_Ajustes, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        Panel_AjustesLayout.setVerticalGroup(
            Panel_AjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AjustesLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(Label_Ajustes, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Ajustes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Ajustes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

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
    private javax.swing.JLabel Label_Ajustes;
    private javax.swing.JPanel Panel_Ajustes;
    // End of variables declaration//GEN-END:variables
}
