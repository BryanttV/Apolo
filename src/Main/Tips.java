package Main;

// Librerias Creadas
import Entities.Curiosities;
import Services.RecursosService;
import CustomComponents.CustomScrollBarUI;
import CustomComponents.CustomProgressBarUIHorizontal;
import JPA_Controllers.CuriositiesJpaController;
import java.awt.Color;

// Librerias Default
import javax.swing.Timer;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JEditorPane;

public class Tips extends javax.swing.JDialog {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApoloPU");
    private final CuriositiesJpaController cujpa = new CuriositiesJpaController(emf);
    private final List<Curiosities> cuList = cujpa.findCuriositiesEntities();
    private final RecursosService sRecursos;
    private final Random r = new Random();
    private ActionListener ac;
    private int x = 0;
    private Timer t;
    private final String tmp = "<html>"
            + "<p style=\"text-align: justify; margin: 0; background-color: rgb(56, 56, 56);\">%s</p>"
            + "</html>";

    public Tips(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        sRecursos = RecursosService.getService();
        initComponents();
        this.setLocationRelativeTo(parent);
        temporizador();

        // Interfaz
        Pb_Tips.setUI(new CustomProgressBarUIHorizontal());
        Edt_Tips.setFont(sRecursos.getFContentTip());
        Lbl_Tip.setFont(sRecursos.getFTitleTips());
        Edt_Tips.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        String text = String.format(tmp, cuList.get(18).getCuriosityContent());
        Edt_Tips.setText(text);
        Scp_Tips.getVerticalScrollBar().setUI(new CustomScrollBarUI(
                Color.BLACK,
                Color.BLUE,
                sRecursos.getColorGrisBorde()));
        Scp_Tips.getVerticalScrollBar().setBackground(sRecursos.getColorDark());
    }

    private int getNumero() {
        return r.nextInt(18);
    }

    private void temporizador() {
        ac = (ActionEvent e) -> {
            x++;
            Pb_Tips.setValue(x);
            if (Pb_Tips.getValue() == 100) {
                dispose();
                t.stop();
            }
        };
        t = new Timer(50, ac);
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Tips = new javax.swing.JPanel();
        Pb_Tips = new javax.swing.JProgressBar();
        Btn_Cerrar = new javax.swing.JButton();
        Btn_Pausar = new javax.swing.JButton();
        Btn_Seguir = new javax.swing.JButton();
        Lbl_Bombillo = new javax.swing.JLabel();
        Lbl_Tip = new javax.swing.JLabel();
        Scp_Tips = new javax.swing.JScrollPane();
        Edt_Tips = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Tips.setBackground(sRecursos.getColorDark());
        Pnl_Tips.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Pnl_Tips.setMaximumSize(new java.awt.Dimension(350, 200));
        Pnl_Tips.setMinimumSize(new java.awt.Dimension(350, 200));
        Pnl_Tips.setPreferredSize(new java.awt.Dimension(350, 200));
        Pnl_Tips.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pb_Tips.setBackground(new java.awt.Color(51, 51, 51));
        Pb_Tips.setForeground(new java.awt.Color(237, 237, 237));
        Pb_Tips.setBorderPainted(false);
        Pb_Tips.setFocusable(false);
        Pb_Tips.setOpaque(true);
        Pb_Tips.setPreferredSize(new java.awt.Dimension(160, 10));
        Pnl_Tips.add(Pb_Tips, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 205, 430, 25));

        Btn_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Cerrar_Off.png"))); // NOI18N
        Btn_Cerrar.setBorderPainted(false);
        Btn_Cerrar.setContentAreaFilled(false);
        Btn_Cerrar.setFocusPainted(false);
        Btn_Cerrar.setFocusable(false);
        Btn_Cerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Cerrar_On.png"))); // NOI18N
        Btn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CerrarActionPerformed(evt);
            }
        });
        Pnl_Tips.add(Btn_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 25, 25));

        Btn_Pausar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Pausar_Off.png"))); // NOI18N
        Btn_Pausar.setBorderPainted(false);
        Btn_Pausar.setContentAreaFilled(false);
        Btn_Pausar.setFocusPainted(false);
        Btn_Pausar.setFocusable(false);
        Btn_Pausar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Pausar_On.png"))); // NOI18N
        Btn_Pausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PausarActionPerformed(evt);
            }
        });
        Pnl_Tips.add(Btn_Pausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 25, 25));

        Btn_Seguir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Seguir_Off.png"))); // NOI18N
        Btn_Seguir.setBorderPainted(false);
        Btn_Seguir.setContentAreaFilled(false);
        Btn_Seguir.setFocusPainted(false);
        Btn_Seguir.setFocusable(false);
        Btn_Seguir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Seguir_On.png"))); // NOI18N
        Btn_Seguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SeguirActionPerformed(evt);
            }
        });
        Pnl_Tips.add(Btn_Seguir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 25, 25));

        Lbl_Bombillo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Bombillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Idea.png"))); // NOI18N
        Pnl_Tips.add(Lbl_Bombillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 40, 110));

        Lbl_Tip.setForeground(new java.awt.Color(204, 204, 204));
        Lbl_Tip.setText("Tip");
        Pnl_Tips.add(Lbl_Tip, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 20));

        Scp_Tips.setBackground(sRecursos.getColorDark());
        Scp_Tips.setBorder(null);
        Scp_Tips.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tips.setOpaque(false);

        Edt_Tips.setEditable(false);
        Edt_Tips.setBackground(sRecursos.getColorDark());
        Edt_Tips.setBorder(null);
        Edt_Tips.setContentType("text/html"); // NOI18N
        Edt_Tips.setForeground(sRecursos.getColorTextGray());
        Edt_Tips.setSelectionColor(new java.awt.Color(100, 100, 100));
        Scp_Tips.setViewportView(Edt_Tips);

        Pnl_Tips.add(Scp_Tips, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 380, 140));

        getContentPane().add(Pnl_Tips, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CerrarActionPerformed
        this.dispose();
        t.stop();
    }//GEN-LAST:event_Btn_CerrarActionPerformed

    private void Btn_PausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PausarActionPerformed
        t.stop();
    }//GEN-LAST:event_Btn_PausarActionPerformed

    private void Btn_SeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SeguirActionPerformed
        t.start();
    }//GEN-LAST:event_Btn_SeguirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Tips dialog = new Tips(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Btn_Cerrar;
    private javax.swing.JButton Btn_Pausar;
    private javax.swing.JButton Btn_Seguir;
    private javax.swing.JTextPane Edt_Tips;
    private javax.swing.JLabel Lbl_Bombillo;
    private javax.swing.JLabel Lbl_Tip;
    protected javax.swing.JProgressBar Pb_Tips;
    private javax.swing.JPanel Pnl_Tips;
    private javax.swing.JScrollPane Scp_Tips;
    // End of variables declaration//GEN-END:variables
}
