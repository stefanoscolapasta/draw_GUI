package content;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ColorButton extends JButton {
    private static final long serialVersionUID = 1L;
    private final Color c;
    private boolean isColored;
    private int clickCount;

    public ColorButton(final String name, final Color c, final GuiHandler m) {
        super(name);
        this.c = c;
        this.isColored = false;
        this.clickCount = 0;
        this.setBackground(Color.LIGHT_GRAY);
        this.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                if (getClickCount() < 1) {
                    m.changeCurrentColor(getButtonColor());
                    m.getpCenterPanel().setColor(m.getCurrentColor());
                    ColorButton.this.increaseClickCount();
                    ColorButton.this.setBackground(ColorButton.this.getButtonColor());
                    ColorButton.this.colored(true);
                } else {
                    ColorButton.this.resetClickCount();
                    ColorButton.this.colored(false);
                    m.changeCurrentColor(Color.BLACK);
                    m.getpCenterPanel().setColor(m.getCurrentColor());
                }
            }
        });

        this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(final MouseEvent e) {
                ColorButton.this.setBackground(ColorButton.this.getButtonColor());
            }

            public void mouseExited(final MouseEvent e) {
                if (!ColorButton.this.amIcolored()) {
                    ColorButton.this.setBackground(Color.LIGHT_GRAY);
                }
            }
        });
    }

    /**
     * this method increases the clickCount var.
     */
    public void increaseClickCount() {
        this.clickCount++;
    }

    /**
     * @return this.clickCount;
     */
    public int getClickCount() {
        return this.clickCount;
    }

    /**
     * this method resets the clickCount var.
     */
    public void resetClickCount() {
        this.clickCount = 0;
    }

    /**
     * @param isColored is used to set this.isColored bool
     */
    public void colored(final boolean isColored) {
        this.isColored = isColored;
    }

    /**
     * @return this.isColored;
     */
    public boolean amIcolored() {
        return this.isColored;
    }

    /**
     * @return this.c;
     */
    public Color getButtonColor() {
        return this.c;
    }

}
