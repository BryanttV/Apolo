package Principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.Timer;

public class Tips extends javax.swing.JFrame {

    private Timer t;
    private final ActionListener ac;
    private int x = 0;

    Random r = new Random();

//    private ArrayList<String> arr = new ArrayList<>();
    public Tips() {
        initComponents();
        ArrayList<String> arr = new ArrayList<String>(Arrays.asList(
                "Cuando definas una variable de tipo long con un valor dado, deberás colocar una L mayúscula o minúscula al final. Eso le permitirá saber al programa que no es un numero entero.",
                "Cuando definas una variable de tipo float con un valor dado, deberás colocar una F mayúscula o minúscula al final. Eso le permitirá saber al programa que no es un numero decimal de tipo Double.",
                "De acuerdo a las tasks de cada problema de programación, defines las variables que necesitas y los tipos que debes usar. Este es un consejito muy bueno, ya que nos ha pasado en algunas competencias XD.",
                "Para la lectura de números decimales, es necesario hacer uso de la coma. Aunque esto puede variar de acuerdo a la regionalidad.",
                "Los booleanos solo pueden ser leídos como true o false, ya que no admite un dato numérico como 1 para verdadero y 0 para falso."));
        this.setLocationRelativeTo(null);
        ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x++;
                jProgressBar1.setValue(x);
                if (jProgressBar1.getValue() == 100) {
                    dispose();
                    t.stop();
                }
            }
        };
        t = new Timer(50, ac);
        t.start();

        int rand = r.nextInt(5);

        jTextArea1.setText(arr.get(rand));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jProgressBar1.setForeground(new java.awt.Color(51, 255, 51));

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tips().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
