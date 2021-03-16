package Principal;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.AbstractBorder;

public class TestRoundedBorder {

    public static void main(String[] args) {
        new TestRoundedBorder();
    }

    public TestRoundedBorder() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setBackground(Color.RED);
            setLayout(new GridBagLayout());
            JLabel label = new JLabel("Test");
            label.setBorder(new RoundedBorder(Color.WHITE, 10));
            label.setPreferredSize(new Dimension(200, 200));
            add(label);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(250, 250);
        }

    }

    public class RoundedBorder extends AbstractBorder {

        private final Color color;
        private final int gap;

        public RoundedBorder(Color c, int g) {
            color = c;
            gap = g;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(color);
            g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, gap, gap));
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return (getBorderInsets(c, new Insets(gap, gap, gap, gap)));
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = gap / 2;
            return insets;
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    }

}
