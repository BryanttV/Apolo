package Main;

public class LastMessage extends javax.swing.JDialog {
    public ThemesContent tc = null;
    public HTMLTemplates t = null;

    public LastMessage(java.awt.Frame parent, boolean modal, ThemesContent tc, HTMLTemplates t) {
        super(parent, modal);
        this.tc = tc;
        this.t = t;
        initComponents();
        LstMssg();
    }
    

    private void LstMssg() {
        tc.addHTML(t.getLastMessage(), Edt_LastMessage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LastMessage_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edt_LastMessage = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LastMessage_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Edt_LastMessage.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(Edt_LastMessage);

        LastMessage_Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1140, 1460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LastMessage_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LastMessage_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane Edt_LastMessage;
    private javax.swing.JPanel LastMessage_Panel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
