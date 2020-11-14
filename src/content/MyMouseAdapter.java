package content;

import java.awt.*;
import java.awt.event.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.MouseInputAdapter;

public class MyMouseAdapter extends MouseAdapter{
	    private static final int MIN_PEN_SIZE = 1;
	    private static final int MAX_PEN_SIZE = 30;
	    private static final int STARTING_PEN_SIZE = 30;
		private final DrawPanel pCenter;
	    private final JSlider penSize;
	    private JLabel penSizeText;
	    private final MyFrame frame;
	    private final JPanel pEast;
	    private final ColorButton bColor;
	    
	    public MyMouseAdapter() {
	    	this.frame = new MyFrame("Canvas Example",new BorderLayout());
	    	this.penSize = new JSlider(JSlider.HORIZONTAL, MIN_PEN_SIZE, MAX_PEN_SIZE, STARTING_PEN_SIZE); 
	    	this.pCenter = new DrawPanel();
	    	this.bColor = new ColorButton("RED", Color.RED);
	    	bColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pCenter.changeColor(MyMouseAdapter.this.bColor.getColor());
				}
			});
	    	this.pEast = new JPanel();
	    	this.pEast.setLayout(new BoxLayout(this.pEast, BoxLayout.Y_AXIS));
	    	this.pEast.setBackground(Color.WHITE);
	    	this.pEast.setBorder(new TitledBorder("Change settings here"));
	    	this.setPenSizeJSlider();	
	    	this.setPanel();	
			pEast.add(penSize);
			this.addVerticalSpacing(this.pEast, 10);
			pEast.add(penSizeText);
			this.addVerticalSpacing(this.pEast, 10);
			pEast.add(bColor);		
			this.setFrameView();	
		}
	    
	    private void addVerticalSpacing(JPanel target, int Yspacing) {
	    	target.add(Box.createVerticalStrut(Yspacing));
	    }
	    
	    private void setFrameView() {
	    	this.frame.getMainPanel().add(pCenter,BorderLayout.CENTER);
	    	this.frame.getMainPanel().add(pEast,BorderLayout.EAST);
	    		
		}

		private void setPanel() {
	    	this.pCenter.setBorder(new TitledBorder("Draw something here.."));
	    	this.pCenter.addMouseMotionListener(this);
	    	this.pCenter.addMouseListener(this);
	    }
	    
	    private void setPenSizeJSlider() {
	    	this.penSize.setPaintTicks(true);
	    	this.penSizeText = new JLabel("Select pen size");
	    	this.penSize.setMajorTickSpacing(2);
	    }

	    public void mouseReleased(MouseEvent e) {
	    	pCenter.createLineObj();
	    	pCenter.repaint(); 
	    }
 
	    public void mouseDragged(MouseEvent e) { 	
				pCenter.addPoint(e.getX(), e.getY());
				pCenter.setPenSize(penSize.getValue());
				pCenter.repaint();
	    }
	    
	    public void show(){
			this.frame.setVisible(true);
		}
	
}
