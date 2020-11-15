package content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonDeleteEverything extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final GuiHandler gui;
	
	public ButtonDeleteEverything(String name, GuiHandler gui) {
		super(name);
		this.gui = gui;
		this.setBackground(GuiHandler.DEFAULT_BUTTON_COLOR);
		this.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent arg0) {
				ButtonDeleteEverything.this.gui.getpCenterPanel().deleteEverything();	
				ButtonDeleteEverything.this.gui.getpCenterPanel().repaint();
				
			}
		});	
	}
}
