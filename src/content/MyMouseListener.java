package content;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.NoSuchElementException;

import panel.Line;

public class MyMouseListener implements MouseListener, MouseMotionListener{

	private final GuiHandler gui;
	private int clickCount = 0;
	private Line lineToTraslate;
	public MyMouseListener(GuiHandler gui) {
		this.gui = gui;
	}
	
	public void mouseDragged(MouseEvent e) { 	
		this.resetClickCount();
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
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3 && this.clickCount < 1) {
			try {
				this.lineToTraslate = this.gui.getpCenterPanel().getLineAtCoordinates(new Point((int)e.getX(), (int)e.getY()));
				System.out.print(lineToTraslate.toString() + this.clickCount);	
				this.increaseClickCount();
			}catch(NoSuchElementException exc){
				System.out.println("Didn't find a line here");
			}
		}else if(e.getButton() == MouseEvent.BUTTON3 && this.clickCount >= 1) {
			this.gui.getpCenterPanel().traslateLine(this.lineToTraslate, new Point(e.getX(), e.getY()));
			this.gui.getpCenterPanel().repaint();
			this.resetClickCount();
		}
	}
	
	private void resetClickCount() {
		this.clickCount = 0;
	}
	
	private void increaseClickCount() {
		this.clickCount++;
	}
	

}
