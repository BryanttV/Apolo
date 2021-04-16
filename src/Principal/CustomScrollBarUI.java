package Principal;

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

    Color drag;
    Color thumb_off;
    Color thumb_on;

    public CustomScrollBarUI(Color drag, Color thumb_off, Color thumb_on) {
        this.drag = drag;
        this.thumb_off = thumb_off;
        this.thumb_on = thumb_on;
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
        Color color = null;
        JScrollBar sb = (JScrollBar) c;
        if (!sb.isEnabled() || r.width > r.height) {
            return;
        } else if (isDragging) {
            color = drag; // Color del Drag
        } else if (isThumbRollover()) {
            color = thumb_on; // Color del Thumb On
        } else {
            color = thumb_off; // Color del Thumb Off
        }

        g2.setPaint(color);
        g2.fillRoundRect(r.x, r.y, r.width, r.height, 15, 15);
//      g2.setPaint(Color.WHITE); // Poner borde
        g2.drawRoundRect(r.x, r.y, r.width, r.height, 15, 15);
        g2.dispose();
    }

    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
    }
}