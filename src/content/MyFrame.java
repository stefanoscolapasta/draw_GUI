package content;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JPanel jp;

    public MyFrame(final String title, final LayoutManager lm) {
        super(title);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jp = new JPanel(lm);
        this.getContentPane().add(this.jp);
        this.setResizable(true);
        this.setSize(sw / 2, sh / 2);
        this.setVisible(true);
    }

    /**
     * @return this.jp;
     */
    public JPanel getMainPanel() {
        return this.jp;
    }

}
