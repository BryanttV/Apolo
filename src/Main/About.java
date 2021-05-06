package Main;

// Librerias Propias
import Services.RecursosService;

// Librerias por Default
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class About extends javax.swing.JDialog {

    private final RecursosService sRecursos;

    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        sRecursos = RecursosService.getService();
        initComponents();
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Ajustes = new javax.swing.JPanel();
        Lbl_Header_Settings = new javax.swing.JLabel();
        Btn_Regresar = new javax.swing.JButton();
        Scp_AcercaDe = new javax.swing.JScrollPane();
        Txa_AcercaDe = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Scp_AcercaDe1 = new javax.swing.JScrollPane();
        Txa_AcercaDe1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        Scp_AcercaDe2 = new javax.swing.JScrollPane();
        Txa_AcercaDe2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        Scp_AcercaDe3 = new javax.swing.JScrollPane();
        Txa_AcercaDe3 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        Scp_AcercaDe4 = new javax.swing.JScrollPane();
        Txa_AcercaDe4 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        Pnl_Ajustes.setBackground(sRecursos.getColorDark());
        Pnl_Ajustes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Header_Settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Header_AcercaDe.png"))); // NOI18N
        Pnl_Ajustes.add(Lbl_Header_Settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Btn_Regresar.setBackground(sRecursos.getColorDark());
        Btn_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Regresar_Off.png"))); // NOI18N
        Btn_Regresar.setBorderPainted(false);
        Btn_Regresar.setContentAreaFilled(false);
        Btn_Regresar.setCursor(sRecursos.getCMano());
        Btn_Regresar.setFocusPainted(false);
        Btn_Regresar.setFocusable(false);
        Btn_Regresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Regresar.setRolloverEnabled(false);
        Btn_Regresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/General/Regresar_On.png"))); // NOI18N
        Btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_RegresarActionPerformed(evt);
            }
        });
        Pnl_Ajustes.add(Btn_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 130, 50));

        Scp_AcercaDe.setBackground(sRecursos.getColorDark());
        Scp_AcercaDe.setBorder(null);
        Scp_AcercaDe.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_AcercaDe.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        Scp_AcercaDe.setFocusable(false);
        Scp_AcercaDe.setOpaque(false);

        Txa_AcercaDe.setEditable(false);
        Txa_AcercaDe.setBackground(sRecursos.getColorDark());
        Txa_AcercaDe.setColumns(20);
        Txa_AcercaDe.setFont(sRecursos.getFContentTip());
        Txa_AcercaDe.setForeground(sRecursos.getColorTextGray());
        Txa_AcercaDe.setRows(5);
        Txa_AcercaDe.setText("• Copyright (c) 2019, Robert Futrell\nTodos los derechos reservados.");
        Txa_AcercaDe.setBorder(null);
        Txa_AcercaDe.setFocusable(false);
        Scp_AcercaDe.setViewportView(Txa_AcercaDe);

        Pnl_Ajustes.add(Scp_AcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 300, 40));

        jLabel1.setFont(sRecursos.getFTitleTips());
        jLabel1.setForeground(sRecursos.getColorTextGray());
        jLabel1.setText("Diseño de Base de Datos");
        Pnl_Ajustes.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 220, 30));

        jLabel2.setFont(sRecursos.getFTitleTips());
        jLabel2.setForeground(sRecursos.getColorTextGray());
        jLabel2.setText("Programado Por");
        Pnl_Ajustes.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, 30));

        Scp_AcercaDe1.setBackground(sRecursos.getColorDark());
        Scp_AcercaDe1.setBorder(null);
        Scp_AcercaDe1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_AcercaDe1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        Scp_AcercaDe1.setFocusable(false);
        Scp_AcercaDe1.setOpaque(false);

        Txa_AcercaDe1.setEditable(false);
        Txa_AcercaDe1.setBackground(sRecursos.getColorDark());
        Txa_AcercaDe1.setColumns(20);
        Txa_AcercaDe1.setFont(sRecursos.getFContentTip());
        Txa_AcercaDe1.setForeground(sRecursos.getColorTextGray());
        Txa_AcercaDe1.setRows(5);
        Txa_AcercaDe1.setText("• Bryann Valderrama\n• Luciano Chavarría");
        Txa_AcercaDe1.setBorder(null);
        Txa_AcercaDe1.setFocusable(false);
        Scp_AcercaDe1.setViewportView(Txa_AcercaDe1);

        Pnl_Ajustes.add(Scp_AcercaDe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 300, 50));

        jLabel3.setFont(sRecursos.getFTitleTips());
        jLabel3.setForeground(sRecursos.getColorTextGray());
        jLabel3.setText("Diseño de Interfaz");
        Pnl_Ajustes.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 30));

        Scp_AcercaDe2.setBackground(sRecursos.getColorDark());
        Scp_AcercaDe2.setBorder(null);
        Scp_AcercaDe2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_AcercaDe2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        Scp_AcercaDe2.setFocusable(false);
        Scp_AcercaDe2.setOpaque(false);

        Txa_AcercaDe2.setEditable(false);
        Txa_AcercaDe2.setBackground(sRecursos.getColorDark());
        Txa_AcercaDe2.setColumns(20);
        Txa_AcercaDe2.setFont(sRecursos.getFContentTip());
        Txa_AcercaDe2.setForeground(sRecursos.getColorTextGray());
        Txa_AcercaDe2.setRows(5);
        Txa_AcercaDe2.setText("• Bryann Valderrama\n");
        Txa_AcercaDe2.setBorder(null);
        Txa_AcercaDe2.setFocusable(false);
        Scp_AcercaDe2.setViewportView(Txa_AcercaDe2);

        Pnl_Ajustes.add(Scp_AcercaDe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 300, 40));

        jLabel4.setFont(sRecursos.getFTitleTips());
        jLabel4.setForeground(sRecursos.getColorTextGray());
        jLabel4.setText("Agradecimientos");
        Pnl_Ajustes.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 220, 30));

        Scp_AcercaDe3.setBackground(sRecursos.getColorDark());
        Scp_AcercaDe3.setBorder(null);
        Scp_AcercaDe3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_AcercaDe3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        Scp_AcercaDe3.setFocusable(false);
        Scp_AcercaDe3.setOpaque(false);

        Txa_AcercaDe3.setEditable(false);
        Txa_AcercaDe3.setBackground(sRecursos.getColorDark());
        Txa_AcercaDe3.setColumns(20);
        Txa_AcercaDe3.setFont(sRecursos.getFContentTip());
        Txa_AcercaDe3.setForeground(sRecursos.getColorTextGray());
        Txa_AcercaDe3.setRows(5);
        Txa_AcercaDe3.setText("• Ing. Diego Rodríguez (Guía Programación)\n• Ing. Carlos Rodíguez (Asesor de Proyecto)\n• Ing. Mónica Barrios (Directora de Proyecto)\n• Manuel Romero (Uso Git Flow)");
        Txa_AcercaDe3.setBorder(null);
        Txa_AcercaDe3.setFocusable(false);
        Scp_AcercaDe3.setViewportView(Txa_AcercaDe3);

        Pnl_Ajustes.add(Scp_AcercaDe3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 300, 90));

        jLabel5.setFont(sRecursos.getFTitleTips());
        jLabel5.setForeground(sRecursos.getColorTextGray());
        jLabel5.setText("Resaltador de Sintaxis");
        Pnl_Ajustes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 220, 30));

        Scp_AcercaDe4.setBackground(sRecursos.getColorDark());
        Scp_AcercaDe4.setBorder(null);
        Scp_AcercaDe4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_AcercaDe4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        Scp_AcercaDe4.setFocusable(false);
        Scp_AcercaDe4.setOpaque(false);

        Txa_AcercaDe4.setEditable(false);
        Txa_AcercaDe4.setBackground(sRecursos.getColorDark());
        Txa_AcercaDe4.setColumns(20);
        Txa_AcercaDe4.setFont(sRecursos.getFContentTip());
        Txa_AcercaDe4.setForeground(sRecursos.getColorTextGray());
        Txa_AcercaDe4.setRows(5);
        Txa_AcercaDe4.setText("• Cristian Maldonado\n");
        Txa_AcercaDe4.setBorder(null);
        Txa_AcercaDe4.setFocusable(false);
        Scp_AcercaDe4.setViewportView(Txa_AcercaDe4);

        Pnl_Ajustes.add(Scp_AcercaDe4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 300, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_Ajustes, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_Ajustes, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JLabel Lbl_Header_Settings;
    private javax.swing.JPanel Pnl_Ajustes;
    private javax.swing.JScrollPane Scp_AcercaDe;
    private javax.swing.JScrollPane Scp_AcercaDe1;
    private javax.swing.JScrollPane Scp_AcercaDe2;
    private javax.swing.JScrollPane Scp_AcercaDe3;
    private javax.swing.JScrollPane Scp_AcercaDe4;
    private javax.swing.JTextArea Txa_AcercaDe;
    private javax.swing.JTextArea Txa_AcercaDe1;
    private javax.swing.JTextArea Txa_AcercaDe2;
    private javax.swing.JTextArea Txa_AcercaDe3;
    private javax.swing.JTextArea Txa_AcercaDe4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
