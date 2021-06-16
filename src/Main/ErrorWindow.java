package Main;

// Librerias Creadas
import Services.RecursosService;

// Librerias por Default
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;

public class ErrorWindow extends javax.swing.JDialog {

    // Varibles
    private final RecursosService sRecursos;
    private final String msg;
    private final String path_img;
    private final String template = "<html>"
            + "<p style=\"margin : 0; text-align: center;\"><b>%s</b></p>"
            + "</html>";

    public ErrorWindow(java.awt.Frame parent, boolean modal, String msg, String path_img) {
        super(parent, modal);
        sRecursos = RecursosService.getService();
        this.msg = msg;
        this.path_img = path_img;
        initComponents();
        addMessage();
        addImage();
        this.setLocationRelativeTo(parent);
    }

    // Agregar mensaje a la ventana
    private void addMessage() {
        String text = String.format(template, this.msg);
        Edt_ErrorWindow.setText(text);
        Edt_ErrorWindow.setFont(sRecursos.getFGeneral());
        Edt_ErrorWindow.setForeground(sRecursos.getColorTextGray());
        Edt_ErrorWindow.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
    }

    // Agregar icono dinamico a la ventana de error
    private void addImage() {
        Lbl_Icon.setIcon(new ImageIcon(getClass().getResource(this.path_img)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_ErrorWindow = new javax.swing.JPanel();
        Edt_ErrorWindow = new javax.swing.JEditorPane();
        Btn_Cerrar = new javax.swing.JButton();
        Lbl_Icon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(210, 120));
        setMinimumSize(new java.awt.Dimension(210, 120));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_ErrorWindow.setBackground(sRecursos.getColorDark());
        Pnl_ErrorWindow.setBorder(new javax.swing.border.LineBorder(sRecursos.getColorGrisBorde(), 1, true));
        Pnl_ErrorWindow.setMaximumSize(new java.awt.Dimension(210, 120));
        Pnl_ErrorWindow.setMinimumSize(new java.awt.Dimension(210, 120));
        Pnl_ErrorWindow.setPreferredSize(new java.awt.Dimension(210, 120));
        Pnl_ErrorWindow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Edt_ErrorWindow.setEditable(false);
        Edt_ErrorWindow.setContentType("text/html"); // NOI18N
        Edt_ErrorWindow.setOpaque(false);
        Edt_ErrorWindow.setSelectionColor(new java.awt.Color(100, 100, 100));
        Pnl_ErrorWindow.add(Edt_ErrorWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 190, 50));

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
        Pnl_ErrorWindow.add(Btn_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 5, 25, 25));
        Pnl_ErrorWindow.add(Lbl_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 15, 40, 40));

        getContentPane().add(Pnl_ErrorWindow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_CerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Cerrar;
    private javax.swing.JEditorPane Edt_ErrorWindow;
    private javax.swing.JLabel Lbl_Icon;
    private javax.swing.JPanel Pnl_ErrorWindow;
    // End of variables declaration//GEN-END:variables
}
