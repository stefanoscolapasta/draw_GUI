package content;

import java.awt.*;

import javax.swing.*;
import java.util.*;

// Specializzazione ad-hoc per un JPanel
public class DrawPanel extends JPanel {
	private static final Color DEFALUT_COLOR = Color.BLACK;
	private static final int DEFALUT_SIZE = 1;
	private static final long serialVersionUID = 7114066347061701832L;
	private LinesSet linesSet; 
	private Line line;
	
	public DrawPanel() {
		this.line = new Line();
		this.linesSet = new LinesSet(); 
		this.linesSet.addLine(this.line);
	}

	// override del metodo di disegno  
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Line e : this.linesSet.getLines()) {
			for(ColoredSizedPoint c : e.getPoints()) {
				g.setColor(c.getPointColor());
				g.fillOval(c.getPointCoordinates().x, c.getPointCoordinates().y, c.getPointSize(), c.getPointSize());
			}
		}
	}
	
	public void deleteEverything() {
		this.linesSet.empty();
	}
	
	public void setPenSize(final int size) {	
		for(ColoredSizedPoint c : this.line.getPoints()) {
			c.setPointSize(size);
		}
	}
	
	public void setColor(final Color color) {
		for(ColoredSizedPoint c : this.line.getPoints()) {
			c.setPointColor(color);
		}
	}
	
	public void createLineObj() {
		this.linesSet.addLine(this.line);
		this.line = new Line();
		this.linesSet.addLine(this.line);
	}
	
	public void addPoint(final int x, final int y){
		int lastSize = DEFALUT_SIZE;
		Color c1 = DEFALUT_COLOR;	
		for(ColoredSizedPoint c : this.line.getPoints()) {
			lastSize = c.getPointSize();
			c1 = c.getPointColor();
		}
		
		if(lastSize < DEFALUT_SIZE) {
			lastSize = DEFALUT_SIZE;
		}
		
		this.line.addPoint(new ColoredSizedPoint(new Point(x-(lastSize/2), y-(lastSize/2)), c1, lastSize));
	}
	
}
