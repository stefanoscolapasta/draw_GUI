package content;

import java.awt.*;

import javax.swing.*;
import java.util.*;

// Specializzazione ad-hoc per un JPanel
public class DrawPanel extends JPanel {

	private static final long serialVersionUID = 7114066347061701832L;
	private Set<Map<Point, Pair<Color, Integer>>> lines; 
	private Map<Point, Pair<Color, Integer>> circles;
	
	public DrawPanel() {
		this.circles = new HashMap<>();
		this.lines = new HashSet<>(); 
		this.lines.add(this.circles);
	}

	// override del metodo di disegno  
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Map<Point, Pair<Color, Integer>> e : this.lines) {
			for(Map.Entry<Point, Pair<Color, Integer>> c : e.entrySet()) {
				g.setColor(c.getValue().first);
				g.fillOval(c.getKey().x, c.getKey().y, c.getValue().second, c.getValue().second);
			}
		}
	}
	
	public void deleteEverything() {
		this.lines = new HashSet<>();
	}
	
	public void setPenSize(int size) {	
		for(Pair<Color, Integer> lastLine : this.circles.values()) {
			lastLine.second = size;
		}
	}
	
	public void setColor(Color c) {
		for(Pair<Color, Integer> pair : this.circles.values()) {
			pair.first = c;
		}
	}
	
	public void createLineObj() {
		this.lines.add(this.circles);
		this.circles = new HashMap<>();
		this.lines.add(this.circles);
	}
	
	public void addPoint(int x, int y){
		int lastSize = 1;
		Color c1 = Color.BLACK;
		for(Pair<Color, Integer> c : this.circles.values()) {
			lastSize = c.second;
			c1 = c.first;
		}
		
		if(lastSize < 1) {
			lastSize = 1;
		}
		
		this.circles.put(new Point(x-(lastSize/2), y-(lastSize)/2), new Pair<Color, Integer>(c1, lastSize));
	}
	
}
