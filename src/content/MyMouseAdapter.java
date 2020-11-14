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
	    private final DrawPanel pCenter;
	    private final JSlider penSize;
	    private JLabel penSizeText;
	    private final MyFrame frame;
	    private final JPanel pEast;
	    
	    public MyMouseAdapter() {
	    	this.frame = new MyFrame("Canvas Example",new BorderLayout());
	    	this.penSize = new JSlider(JSlider.HORIZONTAL, 1, 20, 10); 
	    	this.pCenter = new DrawPanel();
	    	this.pEast = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
	    	this.setPenSizeJSlider();	
	    	this.setPanel();	
			pEast.add(penSize);
			pEast.add(penSizeText);	
			
			this.setFrameView();	
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
	    		pCenter.repaint();
				pCenter.addPoint(e.getX(), e.getY());
				pCenter.setPenSize(penSize.getValue());
	    }
	    
	    public void show(){
			this.frame.setVisible(true);
		}
	
}
