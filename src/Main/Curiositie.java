package Main;

// Librerias Creadas
import Entities.Curiosities;
import Services.RecursosService;
import CustomComponents.CustomScrollBarUI;
import CustomComponents.CustomProgressBarUIHorizontal;
import JPA_Controllers.CuriositiesJpaController;

// Librerias por Default
import javax.swing.Timer;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;

public class Curiositie extends javax.swing.JDialog {

    // Variables
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApoloPU");
    private final CuriositiesJpaController cujpa = new CuriositiesJpaController(emf);
    private final List<Curiosities> cuList = cujpa.findCuriositiesEntities();
    private final RecursosService sRecursos;
    private final Random r = new Random();
    private ActionListener ac;
    private int x = 0;
    private Timer t;
    private final String tmp = "<html>"
            + "<p style=\"text-align: justify; margin: 0; margin-right: 6; background-color: rgb(56, 56, 56);\">%s</p>"
            + "</html>";

    public Curiositie(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        sRecursos = RecursosService.getService();
        initComponents();
        addTimer();
        configureFont();
        configureProgressBar();
        configureScrollBar();
        addCuriositie();
        Btn_PausarSeguir.setIcon(new ImageIcon(getClass().getResource("/Resources/Ventanas/Pausar_Off.png")));
        this.setLocationRelativeTo(parent);
    }

    // Configurar fuente personalizada
    private void configureFont() {
        Edt_Tips.setFont(sRecursos.getFContentTip());
        Lbl_Tip.setFont(sRecursos.getFTitleTips());
    }

    // COnfigurar ScrollBar personalizado
    private void configureScrollBar() {
        Scp_Tips.getVerticalScrollBar().setBackground(sRecursos.getColorDark());
        Scp_Tips.getVerticalScrollBar().setUI(new CustomScrollBarUI(
                new Color(230, 230, 230),
                new Color(250, 250, 250),
                new Color(230, 230, 230)));
    }

    // Configurar ProgressBar personalizado
    private void configureProgressBar() {
        Pb_Tips.setUI(new CustomProgressBarUIHorizontal());
    }

    // Agregar Curiosidad al JTextEditor
    private void addCuriositie() {
        Edt_Tips.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        String text = String.format(tmp, cuList.get(getNumero()).getCuriosityContent());
        Edt_Tips.setText(text);
        Edt_Tips.setCaretPosition(0);
    }

    // Generar numero aleatorio
    private int getNumero() {
        return r.nextInt(18);
    }

    // Agregar el temporizador a la barra de progreso
    private void addTimer() {
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
        Lbl_Bombillo = new javax.swing.JLabel();
        Lbl_Tip = new javax.swing.JLabel();
        Scp_Tips = new javax.swing.JScrollPane();
        Edt_Tips = new javax.swing.JTextPane();
        Btn_PausarSeguir = new javax.swing.JToggleButton();

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
        Pnl_Tips.add(Pb_Tips, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 400, 25));

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
        Pnl_Tips.add(Btn_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 25, 25));

        Lbl_Bombillo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Bombillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Idea.png"))); // NOI18N
        Pnl_Tips.add(Lbl_Bombillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 120));

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

        Pnl_Tips.add(Scp_Tips, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 340, 120));

        Btn_PausarSeguir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Btn_PausarSeguir.setBorderPainted(false);
        Btn_PausarSeguir.setContentAreaFilled(false);
        Btn_PausarSeguir.setFocusPainted(false);
        Btn_PausarSeguir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_PausarSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PausarSeguirActionPerformed(evt);
            }
        });
        Pnl_Tips.add(Btn_PausarSeguir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 25, 25));

        getContentPane().add(Pnl_Tips, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CerrarActionPerformed
        this.dispose();
        t.stop();
    }//GEN-LAST:event_Btn_CerrarActionPerformed

    private void Btn_PausarSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PausarSeguirActionPerformed
        if (Btn_PausarSeguir.isSelected()) {
            Btn_PausarSeguir.setIcon(new ImageIcon(getClass().getResource("/Resources/Ventanas/Seguir_Off.png")));
            t.stop();
        } else {
            Btn_PausarSeguir.setIcon(new ImageIcon(getClass().getResource("/Resources/Ventanas/Pausar_Off.png")));
            t.start();
        }
    }//GEN-LAST:event_Btn_PausarSeguirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Curiositie dialog = new Curiositie(new javax.swing.JFrame(), true);
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
    private javax.swing.JToggleButton Btn_PausarSeguir;
    private javax.swing.JTextPane Edt_Tips;
    private javax.swing.JLabel Lbl_Bombillo;
    private javax.swing.JLabel Lbl_Tip;
    protected javax.swing.JProgressBar Pb_Tips;
    private javax.swing.JPanel Pnl_Tips;
    private javax.swing.JScrollPane Scp_Tips;
    // End of variables declaration//GEN-END:variables
}
