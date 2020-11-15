package content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class ButtonSelectColor extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final GuiHandler gui;
	
	public ButtonSelectColor(String name, GuiHandler gui) {
		super(name);
		this.gui = gui;
		this.setBackground(GuiHandler.DEFAULT_BUTTON_COLOR);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JColorChooser colorChooser = new JColorChooser();
				AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
		        for(AbstractColorChooserPanel p : panels){
		            String displayName = p.getDisplayName();
		            switch (displayName) {
		                case "HSV":
		                    colorChooser.removeChooserPanel(p);
		                    break;
		                case "HSL":
		                    colorChooser.removeChooserPanel(p);
		                    break;
		                case "CMYK":
		                    colorChooser.removeChooserPanel(p);
		                    break;
		                case "RGB":
		                    colorChooser.removeChooserPanel(p);
		                    break;
		            }
		        }
				@SuppressWarnings("static-access")
				JDialog d = colorChooser.createDialog(null, "Please select a color",true, colorChooser, null, null);
				d.setVisible(true);
				ButtonSelectColor.this.gui.changeCurrentColor(colorChooser.getColor());
			}
		});
	}
	
}
