package content;

import java.awt.Color;

import javax.swing.JButton;

public class ColorButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final Color c;
	public ColorButton(String name, Color c) {
		super(name);
		this.c = c;
	}
	
	public Color getColor() {
		return this.c;
	}
}
