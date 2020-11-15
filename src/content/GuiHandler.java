package content;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import panel.DrawPanel;

public class GuiHandler extends MouseAdapter{
	    private static final int MIN_PEN_SIZE = 1;
	    private static final int MAX_PEN_SIZE = 30;
	    private static final int STARTING_PEN_SIZE = 15;
	    static final Color DEFAULT_BUTTON_COLOR = Color.LIGHT_GRAY;
		private final DrawPanel pcenterPanel;
	    private final JSlider penSize;
	    private JLabel penSizeText;
	    private final MyFrame frame;
	    private final JPanel pEast;
	    private final JButton bDelete;
	    private final JButton bSelectColor;
	    private Color currentColor = Color.BLACK;
	    private final MyMouseListener myListener;
	    
	    public GuiHandler() {
	    	this.frame = new MyFrame("Canvas Example",new BorderLayout());
	    	this.penSize = new JSlider(JSlider.HORIZONTAL, MIN_PEN_SIZE, MAX_PEN_SIZE, STARTING_PEN_SIZE); 
	    	this.pcenterPanel = new DrawPanel();
	    	this.pEast = new JPanel(new GridBagLayout());
	    	this.myListener = new MyMouseListener(this);
	    	this.bSelectColor = new ButtonSelectColor("Select Color", this);   	
	    	this.bDelete = new ButtonDeleteEverything("Erase everything", this);	
	    	this.pEast.setLayout(new BoxLayout(this.pEast, BoxLayout.Y_AXIS) );
	    	this.pEast.setBackground(Color.WHITE);
	    	this.pEast.setBorder(new TitledBorder("Change settings here"));
	    	this.setPenSizeJSlider();
	    	this.getpCenterPanel().setBorder(new TitledBorder("Draw something here.."));
	    	this.setCenterPanelListeners();
	    	this.buildSettingsPanel();
			this.setFrameView();	
		}
	    
	    private void buildSettingsPanel() {
	    	this.addVerticalSpacing(this.pEast, 25);
	    	this.pEast.add(this.penSizeText);
			this.addVerticalSpacing(this.pEast, 10);
			this.pEast.add(this.penSize);
			this.addVerticalSpacing(this.pEast, 5);
			this.pEast.add(this.bSelectColor, BorderLayout.EAST);
			this.addVerticalSpacing(this.pEast, 10);
			this.pEast.add(this.bDelete);
	    }
	    
	    private void addVerticalSpacing(JPanel target, int Yspacing) {
	    	target.add(Box.createVerticalStrut(Yspacing));
	    }
	    
	    private void setFrameView() {
	    	this.frame.getMainPanel().add(this.getpCenterPanel(),BorderLayout.CENTER);
	    	this.frame.getMainPanel().add(this.pEast, BorderLayout.EAST);
	    		
		}

		private void setCenterPanelListeners() { 	
	    	this.getpCenterPanel().addMouseListener(this.myListener);
	    	this.getpCenterPanel().addMouseMotionListener(this.myListener);
	    }
	    
	    private void setPenSizeJSlider() {
	    	this.penSize.setPaintTicks(true);
	    	this.penSizeText = new JLabel("Select pen size");
	    	this.penSize.setMajorTickSpacing(2);
	    }
	    
	    public DrawPanel getpCenterPanel() {
	    	return this.pcenterPanel;
	    }
	    
	    public void changeCurrentColor(Color c) {
	    	this.currentColor = c;
	    }
	    
	    public Color getCurrentColor() {
	    	return this.currentColor;
	    }

	    public int getPenSize() {
	    	return this.penSize.getValue();
	    }
	    
	    public void show(){
			this.frame.setVisible(true);
		}
	
}
