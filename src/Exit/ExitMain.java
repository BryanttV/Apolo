package Exit;

import Services.RecursosService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class ExitMain extends javax.swing.JDialog {

    private final RecursosService sRecursos;
    private EntityManagerFactory _emf;

    //Progress bar percentage
    private String lastTheme;
    private int b1;
    private int b2;
    private int b3;
    private int b4;
    private int b5;
    private int map;

    public ExitMain(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        sRecursos = RecursosService.getService();
        initComponents();
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_Salida = new javax.swing.JPanel();
        Lbl_Salida = new javax.swing.JLabel();
        Lbl_Mensaje = new javax.swing.JLabel();
        Btn_No = new javax.swing.JButton();
        Btn_Si = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        Pnl_Salida.setBackground(new java.awt.Color(250, 250, 250));
        Pnl_Salida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Pnl_Salida.setMaximumSize(new java.awt.Dimension(400, 100));
        Pnl_Salida.setMinimumSize(new java.awt.Dimension(400, 100));
        Pnl_Salida.setPreferredSize(new java.awt.Dimension(400, 100));
        Pnl_Salida.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_Salida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Advertencia.png"))); // NOI18N
        Pnl_Salida.add(Lbl_Salida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, 42));

        Lbl_Mensaje.setFont(sRecursos.getFContentTip());
        Lbl_Mensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Mensaje.setText("¿Seguro de que desea salir de la aplicación?");
        Pnl_Salida.add(Lbl_Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 300, -1));

        Btn_No.setBackground(new java.awt.Color(255, 255, 255));
        Btn_No.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Btn_No.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/No_Off.png"))); // NOI18N
        Btn_No.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Btn_No.setBorderPainted(false);
        Btn_No.setContentAreaFilled(false);
        Btn_No.setFocusPainted(false);
        Btn_No.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_No.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/No_On.png"))); // NOI18N
        Btn_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NoActionPerformed(evt);
            }
        });
        Pnl_Salida.add(Btn_No, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 52, 32));

        Btn_Si.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Si.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Btn_Si.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Si_Off.png"))); // NOI18N
        Btn_Si.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Btn_Si.setBorderPainted(false);
        Btn_Si.setContentAreaFilled(false);
        Btn_Si.setFocusPainted(false);
        Btn_Si.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_Si.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Ventanas/Si_On.png"))); // NOI18N
        Btn_Si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SiActionPerformed(evt);
            }
        });
        Pnl_Salida.add(Btn_Si, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 52, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_Salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Pnl_Salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NoActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_NoActionPerformed

    private void Btn_SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SiActionPerformed
        finalTransaction();
        System.exit(0);
    }//GEN-LAST:event_Btn_SiActionPerformed

    private void finalTransaction() {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();

        /*CREATE QUERIES FOR TRANSACTION*/
        //Map ProgressBar
        Query tran_map = em.createQuery("UPDATE Progress p SET p.learningPercentage = :map , p.lastTopicLearning = :lastTheme " + "WHERE p.recordId = 1");
        //First Progressbar
        Query tran_pb1 = em.createQuery("UPDATE Progress p SET p.learningPercentage = :b1 " + "WHERE p.recordId = 2");
        //Second Progressbar
        Query tran_pb2 = em.createQuery("UPDATE Progress p SET p.learningPercentage = :b2 " + "WHERE p.recordId = 3");
        //Third Progressbar
        Query tran_pb3 = em.createQuery("UPDATE Progress p SET p.learningPercentage = :b3 " + "WHERE p.recordId = 4");
        //Fourth Progressbar
        Query tran_pb4 = em.createQuery("UPDATE Progress p SET p.learningPercentage = :b4 " + "WHERE p.recordId = 5");
        //Fifth Progressbar
        Query tran_pb5 = em.createQuery("UPDATE Progress p SET p.learningPercentage = :b5 " + "WHERE p.recordId = 6");

        /*PASS ARGUMENTS TO QUERIES*/
        tran_map.setParameter("lastTheme", lastTheme);
        tran_map.setParameter("map", map);
        tran_pb1.setParameter("b1", b1);
        tran_pb2.setParameter("b2", b2);
        tran_pb3.setParameter("b3", b3);
        tran_pb4.setParameter("b4", b4);
        tran_pb5.setParameter("b5", b5);

        //Execute a verify update
        int rowmap = tran_map.executeUpdate();
        int row1 = tran_pb1.executeUpdate();
        int row2 = tran_pb2.executeUpdate();
        int row3 = tran_pb3.executeUpdate();
        int row4 = tran_pb4.executeUpdate();
        int row5 = tran_pb5.executeUpdate();

        System.out.println("FILAS ACTUALIZADAS map:" + rowmap);
        System.out.println("FILAS ACTUALIZADAS pb1: " + row1);
        System.out.println("FILAS ACTUALIZADAS pb2: " + row2);
        System.out.println("FILAS ACTUALIZADAS pb3: " + row3);
        System.out.println("FILAS ACTUALIZADAS pb4: " + row4);
        System.out.println("FILAS ACTUALIZADAS pb5: " + row5);

        em.getTransaction().commit();
        em.close();
        _emf.close();
    }

    public void getInfoOfProgressBar(EntityManagerFactory emf, int map, int b1, int b2, int b3, int b4, int b5) {
        _emf = emf;
        this.map = map;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
        int temp = map / 6;
        if(temp == 0){
            lastTheme = "1";
        }else{
            lastTheme = Integer.toString(temp + 1);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            ExitMain dialog = new ExitMain(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Btn_No;
    private javax.swing.JButton Btn_Si;
    private javax.swing.JLabel Lbl_Mensaje;
    private javax.swing.JLabel Lbl_Salida;
    private javax.swing.JPanel Pnl_Salida;
    // End of variables declaration//GEN-END:variables
}
