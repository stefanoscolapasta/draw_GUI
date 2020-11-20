package content;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonEraser extends JButton{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private GuiHandler gui;

    public ButtonEraser(final String name, final GuiHandler gui) {
        super(name);
        this.gui = gui;
        this.setBackground(Color.LIGHT_GRAY);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                
                if (!ButtonEraser.this.gui.getpCenterPanel().isErasingEnabled()) {
                    ButtonEraser.this.setBackground(Color.RED);
                    ButtonEraser.this.gui.getpCenterPanel().setErasing(true);
                } else {
                    ButtonEraser.this.setBackground(Color.LIGHT_GRAY);
                    ButtonEraser.this.gui.getpCenterPanel().setErasing(false);
                }
            }
        });
    }
}
