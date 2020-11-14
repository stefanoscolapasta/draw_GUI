package content;

import java.awt.*;
import java.awt.event.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.MouseInputAdapter;

public class MyMouseAdapter extends MouseAdapter{
	    private static final int MIN_PEN_SIZE = 1;
	    private static final int MAX_PEN_SIZE = 30;
	    private static final int STARTING_PEN_SIZE = 30;
		private final DrawPanel pcenterPanel;
	    private final JSlider penSize;
	    private JLabel penSizeText;
	    private final JLabel selectColorText;
	    private final MyFrame frame;
	    private final JPanel pEast;
	    private final Set<ColorButton> bColors;
	    private final JButton bDelete;
	    private Color currentColor = Color.BLACK;
	    
	    public MyMouseAdapter() {
	    	this.frame = new MyFrame("Canvas Example",new BorderLayout());
	    	this.penSize = new JSlider(JSlider.HORIZONTAL, MIN_PEN_SIZE, MAX_PEN_SIZE, STARTING_PEN_SIZE); 
	    	this.pcenterPanel = new DrawPanel();
	    	this.bColors = new HashSet<>();
	    	this.bDelete = new JButton("Erase everything");
	    	this.bDelete.addActionListener(new ActionListener() {		
				public void actionPerformed(ActionEvent arg0) {
					MyMouseAdapter.this.pcenterPanel.deleteEverything();	
					MyMouseAdapter.this.pcenterPanel.repaint();
				}
			});
	    	this.selectColorText = new JLabel("Select color");
	    	bColors.add(new ColorButton("RED", Color.RED, this));
	    	bColors.add(new ColorButton("GREEN", Color.GREEN, this));
	    	bColors.add(new ColorButton("DARK_GRAY", Color.DARK_GRAY, this));
	    	bColors.add(new ColorButton("YELLOW", Color.YELLOW, this));
	    	bColors.add(new ColorButton("BLACK", Color.BLACK, this));
	    	this.pEast = new JPanel();
	    	this.pEast.setLayout(new BoxLayout(this.pEast, BoxLayout.Y_AXIS));
	    	this.pEast.setBackground(Color.WHITE);
	    	this.pEast.setBorder(new TitledBorder("Change settings here"));
	    	this.setPenSizeJSlider();	
	    	this.setPanel();
	    	this.addVerticalSpacing(this.pEast, 25);
	    	pEast.add(penSizeText);
			this.addVerticalSpacing(this.pEast, 10);
			pEast.add(penSize);
			this.addVerticalSpacing(this.pEast, 10);
			pEast.add(selectColorText);
			this.addVerticalSpacing(this.pEast, 10);
			//Adding all buttons to pEast
			for(ColorButton b : bColors) {
				pEast.add(b);
				this.addVerticalSpacing(this.pEast, 5);
			}		
			this.addVerticalSpacing(this.pEast, 10);
			pEast.add(this.bDelete);
			
			this.setFrameView();	
		}
	    
	    private void addVerticalSpacing(JPanel target, int Yspacing) {
	    	target.add(Box.createVerticalStrut(Yspacing));
	    }
	    
	    private void setFrameView() {
	    	this.frame.getMainPanel().add(pcenterPanel,BorderLayout.CENTER);
	    	this.frame.getMainPanel().add(pEast,BorderLayout.EAST);
	    		
		}

		private void setPanel() {
	    	this.pcenterPanel.setBorder(new TitledBorder("Draw something here.."));
	    	this.pcenterPanel.addMouseMotionListener(this);
	    	this.pcenterPanel.addMouseListener(this);
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
	    
	    public void mouseReleased(MouseEvent e) {
	    	pcenterPanel.createLineObj();
	    	pcenterPanel.repaint(); 
	    }
 
	    public void mouseDragged(MouseEvent e) { 	
				pcenterPanel.addPoint(e.getX(), e.getY());
				pcenterPanel.setPenSize(penSize.getValue());
				pcenterPanel.setColor(MyMouseAdapter.this.currentColor);
				pcenterPanel.repaint();
	    }
	    
	    public void show(){
			this.frame.setVisible(true);
		}
	
}
