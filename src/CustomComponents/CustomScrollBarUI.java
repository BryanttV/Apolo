package CustomComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class CustomScrollBarUI extends BasicScrollBarUI {

    private final Color cDrag;
    private final Color cThumb_Off;
    private final Color cThumb_On;

    public CustomScrollBarUI(Color cDrag, Color cThumb_On, Color cThumb_Off) {
        this.cDrag = cDrag;
        this.cThumb_Off = cThumb_Off;
        this.cThumb_On = cThumb_On;
    }

    private final Dimension d = new Dimension();

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new JButton() {

            private static final long serialVersionUID = -3592643796245558676L;

            @Override
            public Dimension getPreferredSize() {
                return d;
            }
        };
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new JButton() {

            private static final long serialVersionUID = 1L;

            @Override
            public Dimension getPreferredSize() {
                return d;
            }
        };
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color color;
        JScrollBar sb = (JScrollBar) c;
        if (!sb.isEnabled() || r.width > r.height) {
            return;
        } else if (isDragging) {
            color = cDrag; // Color del Drag
        } else if (isThumbRollover()) {
            color = cThumb_On; // Color del Thumb On
        } else {
            color = cThumb_Off; // Color del Thumb Off
        }

        g2.setPaint(color);
        g2.fillRoundRect(r.x, r.y, r.width, r.height, 15, 15);
        g2.drawRoundRect(r.x, r.y, r.width, r.height, 15, 15);
        g2.dispose();
    }

    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
    }
}
