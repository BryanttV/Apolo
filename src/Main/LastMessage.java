package Main;

// Libreria Creada
import Services.RecursosService;

public class LastMessage extends javax.swing.JDialog {

    public ThemesContent tc = null;
    public HTMLTemplates t = null;
    private final RecursosService sRecursos;

    public LastMessage(java.awt.Frame parent, boolean modal, ThemesContent tc, HTMLTemplates t) {
        super(parent, modal);
        this.tc = tc;
        this.t = t;
        sRecursos = RecursosService.getService();
        initComponents();
        LstMssg();
        this.setLocationRelativeTo(parent);
    }

    private void LstMssg() {
        tc.addHTML(t.getLastMessageTemplate(), Edt_LastMessage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_LastMessage = new javax.swing.JPanel();
        Edt_LastMessage = new javax.swing.JEditorPane();
        Btn_Close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        Pnl_LastMessage.setBackground(sRecursos.getColorDark());
        Pnl_LastMessage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Edt_LastMessage.setEditable(false);
        Edt_LastMessage.setContentType("text/html"); // NOI18N
        Edt_LastMessage.setOpaque(false);
        Edt_LastMessage.setSelectionColor(new java.awt.Color(100, 100, 100));
        Pnl_LastMessage.add(Edt_LastMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 920, 440));

        Btn_Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Cerrar_Off.png"))); // NOI18N
        Btn_Close.setBorderPainted(false);
        Btn_Close.setContentAreaFilled(false);
        Btn_Close.setFocusPainted(false);
        Btn_Close.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Cerrar_On.png"))); // NOI18N
        Btn_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CloseActionPerformed(evt);
            }
        });
        Pnl_LastMessage.add(Btn_Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(925, 5, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_LastMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_LastMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_CloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Close;
    private javax.swing.JEditorPane Edt_LastMessage;
    private javax.swing.JPanel Pnl_LastMessage;
    // End of variables declaration//GEN-END:variables
}
