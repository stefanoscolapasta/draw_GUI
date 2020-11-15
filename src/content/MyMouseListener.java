package content;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.NoSuchElementException;

import panel.Line;

public class MyMouseListener implements MouseListener, MouseMotionListener{

	private final GuiHandler gui;
	
	public MyMouseListener(GuiHandler gui) {
		this.gui = gui;
	}
	
	public void mouseDragged(MouseEvent e) { 	
    	this.gui.getpCenterPanel().addPoint(e.getX(), e.getY());
    	this.gui.getpCenterPanel().setPenSize(this.gui.getPenSize());
    	this.gui.getpCenterPanel().setColor(this.gui.getCurrentColor());
    	this.gui.getpCenterPanel().repaint();
    }
	
	public void mouseReleased(MouseEvent e) {
    	this.gui.getpCenterPanel().createLineObj();
    	this.gui.getpCenterPanel().repaint(); 
    }
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		try {
			Line lineToTraslate = this.gui.getpCenterPanel().getLineAtCoordinates(new Point((int)arg0.getX(), (int)arg0.getY()));
			System.out.print(lineToTraslate.toString());
			this.gui.getpCenterPanel().traslateLine(lineToTraslate, new Point(250, 250));
			this.gui.getpCenterPanel().repaint();
			
		}catch(NoSuchElementException exc){
			System.out.println("Didn't find a line here");
		}
		
	}

	

}
