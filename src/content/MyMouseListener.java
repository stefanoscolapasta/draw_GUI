package content;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseListener implements MouseListener, MouseMotionListener{

	private final guiHandler gui;
	
	public MyMouseListener(guiHandler gui) {
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
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	

}
