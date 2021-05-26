package Main;

// Librerias Propias
import Services.RecursosService;

// Librerias por Default
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class About extends javax.swing.JDialog {

    private final RecursosService sRecursos;
    private final String template = "<html>"
            + "<h2 style=\"text-align: center; margin-top: 5;\">Programado por</h2>"
            + "<p style=\"text-align: center; margin: 0;\">Bryann Valderrama<br>"
            + "Luciano Chavarría<br>"
            + "Cristian Maldonado</p>"
            + "<h2 style=\"text-align: center; margin-top: 5;\">Diseño de Interfaz</h2>"
            + "<p style=\"text-align: center; margin: 0;\">Bryann Valderrama</p>"
            + "<h2 style=\"text-align: center; margin-top: 5;\">Diseño de Base de Datos</h2>"
            + "<p style=\"text-align: center; margin: 0;\">Cristian Maldonado</p>"
            + "<h2 style=\"text-align: center; margin-top: 5;\">Resaltador de Sintaxis</h2>"
            + "<p style=\"text-align: center; margin: 0;\">Copyright(c) 2019, Robert Futrell<br>"
            + "Todos los derechos reservados</p>"
            + "<h2 style=\"text-align: center; margin-top: 5;\">Agradecimientos</h2>"
            + "<p style=\"text-align: center; margin: 0;\">Ing. Diego Rodríguez <b>(Guía de Programación)</b><br>"
            + "Ing. Carlos Rodríguez <b>(Asesor de Proyecto)</b<br>"
            + "Ing. Mónica Barrios <b>(Directora de Proyecto)</b><br>"
            + "Manuel Romero <b>(Uso de GitFlow)</b></p>"
            + "</html>";

    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        sRecursos = RecursosService.getService();
        initComponents();
        setLocationRelativeTo(parent);
        addMessage();
    }

    private void addMessage() {
        Edt_AcercaDe.setText(template);
        Edt_AcercaDe.setBackground(sRecursos.getColorDark());
        Edt_AcercaDe.setForeground(sRecursos.getColorTextGray());
        Edt_AcercaDe.setFont(sRecursos.getFGeneral());
        Edt_AcercaDe.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Ajustes = new javax.swing.JPanel();
        Lbl_Header_Settings = new javax.swing.JLabel();
        Btn_Regresar = new javax.swing.JButton();
        Scp_AcercaDe = new javax.swing.JScrollPane();
        Edt_AcercaDe = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 580));
        setMinimumSize(new java.awt.Dimension(400, 580));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 580));

        Pnl_Ajustes.setBackground(sRecursos.getColorDark());
        Pnl_Ajustes.setMaximumSize(new java.awt.Dimension(400, 580));
        Pnl_Ajustes.setMinimumSize(new java.awt.Dimension(400, 580));
        Pnl_Ajustes.setPreferredSize(new java.awt.Dimension(400, 580));
        Pnl_Ajustes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Settings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Header_Settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Header_AcercaDe.png"))); // NOI18N
        Lbl_Header_Settings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Pnl_Ajustes.add(Lbl_Header_Settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        Btn_Regresar.setBackground(sRecursos.getColorDark());
        Btn_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Regresar_Off.png"))); // NOI18N
        Btn_Regresar.setBorderPainted(false);
        Btn_Regresar.setContentAreaFilled(false);
        Btn_Regresar.setCursor(sRecursos.getCMano());
        Btn_Regresar.setFocusPainted(false);
        Btn_Regresar.setFocusable(false);
        Btn_Regresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Regresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Regresar_On.png"))); // NOI18N
        Btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RegresarActionPerformed(evt);
            }
        });
        Pnl_Ajustes.add(Btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 380, 50));

        Scp_AcercaDe.setBorder(null);
        Scp_AcercaDe.setOpaque(false);

        Edt_AcercaDe.setEditable(false);
        Edt_AcercaDe.setContentType("text/html"); // NOI18N
        Edt_AcercaDe.setSelectionColor(new java.awt.Color(100, 100, 100));
        Scp_AcercaDe.setViewportView(Edt_AcercaDe);

        Pnl_Ajustes.add(Scp_AcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 380, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_Ajustes, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_Ajustes, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            About dialog = new About(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Btn_Regresar;
    private javax.swing.JEditorPane Edt_AcercaDe;
    private javax.swing.JLabel Lbl_Header_Settings;
    private javax.swing.JPanel Pnl_Ajustes;
    private javax.swing.JScrollPane Scp_AcercaDe;
    // End of variables declaration//GEN-END:variables
}
