package Main;

// Librerias Creadas
import Services.RecursosService;

// Librerias Default
import javax.swing.Timer;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CustomComponents.CustomProgressBarUIHorizontal;

public class Tips extends javax.swing.JDialog {

    private final RecursosService sRecursos;
    private final Random r = new Random();
    private ActionListener ac;
    private int x = 0;
    private Timer t;
    private final ArrayList<String> arr = new ArrayList<>(Arrays.asList(
            "Cuando definas una variable de tipo long con un valor dado, deberás colocar una L mayúscula o minúscula al final. Eso le permitirá saber al programa que no es un numero entero.",
            "Cuando definas una variable de tipo float con un valor dado, deberás colocar una F mayúscula o minúscula al final. Eso le permitirá saber al programa que no es un numero decimal de tipo Double.",
            "De acuerdo a las tasks de cada problema de programación, defines las variables que necesitas y los tipos que debes usar. Este es un consejito muy bueno, ya que nos ha pasado en algunas competencias XD.",
            "Para la lectura de números decimales, es necesario hacer uso de la coma. Aunque esto puede variar de acuerdo a la regionalidad.",
            "Los booleanos solo pueden ser leídos como true o false, ya que no admite un dato numérico como 1 para verdadero y 0 para falso."));

    public Tips(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        sRecursos = RecursosService.getService();
        initComponents();
        this.setLocationRelativeTo(parent);
        temporizador();

        Pb_Tips.setUI(new CustomProgressBarUIHorizontal());

        // Interfaz
        Txa_Tips.setFont(sRecursos.getFContentTip());
        Lbl_Tip.setFont(sRecursos.getFTitleTips());
        Txa_Tips.setText(arr.get(getNumero()));
    }

    private int getNumero() {
        return r.nextInt(5);
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
        Scp_Tips = new javax.swing.JScrollPane();
        Txa_Tips = new javax.swing.JTextArea();
        Pb_Tips = new javax.swing.JProgressBar();
        Btn_Cerrar = new javax.swing.JButton();
        Btn_Pausar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Btn_Seguir = new javax.swing.JButton();
        Lbl_Tip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_Tips.setBackground(new java.awt.Color(51, 51, 51));
        Pnl_Tips.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Pnl_Tips.setMaximumSize(new java.awt.Dimension(350, 200));
        Pnl_Tips.setMinimumSize(new java.awt.Dimension(350, 200));
        Pnl_Tips.setPreferredSize(new java.awt.Dimension(350, 200));
        Pnl_Tips.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Scp_Tips.setBorder(null);
        Scp_Tips.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Scp_Tips.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Txa_Tips.setEditable(false);
        Txa_Tips.setBackground(new java.awt.Color(51, 51, 51));
        Txa_Tips.setColumns(20);
        Txa_Tips.setForeground(new java.awt.Color(204, 204, 204));
        Txa_Tips.setLineWrap(true);
        Txa_Tips.setRows(5);
        Txa_Tips.setWrapStyleWord(true);
        Txa_Tips.setSelectionColor(new java.awt.Color(204, 204, 204));
        Scp_Tips.setViewportView(Txa_Tips);

        Pnl_Tips.add(Scp_Tips, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 45, 280, 110));

        Pb_Tips.setBackground(new java.awt.Color(51, 51, 51));
        Pb_Tips.setForeground(new java.awt.Color(237, 237, 237));
        Pb_Tips.setBorderPainted(false);
        Pb_Tips.setFocusable(false);
        Pb_Tips.setOpaque(true);
        Pb_Tips.setPreferredSize(new java.awt.Dimension(160, 10));
        Pnl_Tips.add(Pb_Tips, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 165, 350, 25));

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
        Pnl_Tips.add(Btn_Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 25, 25));

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
        Pnl_Tips.add(Btn_Pausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 25, 25));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Idea.png"))); // NOI18N
        Pnl_Tips.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 40, 60));

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
        Pnl_Tips.add(Btn_Seguir, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 25, 25));

        Lbl_Tip.setForeground(new java.awt.Color(204, 204, 204));
        Lbl_Tip.setText("Tip del Día");
        Pnl_Tips.add(Lbl_Tip, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 20));

        getContentPane().add(Pnl_Tips, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, -1));

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
    private javax.swing.JLabel Lbl_Tip;
    protected javax.swing.JProgressBar Pb_Tips;
    private javax.swing.JPanel Pnl_Tips;
    private javax.swing.JScrollPane Scp_Tips;
    private javax.swing.JTextArea Txa_Tips;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
