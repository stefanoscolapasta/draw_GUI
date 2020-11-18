package content;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MyFrame(final String title) {
        super(title);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(sw / 2, sh / 2);
        this.setVisible(true);
    }

    /**
     * @return this.jp;
     */

}
