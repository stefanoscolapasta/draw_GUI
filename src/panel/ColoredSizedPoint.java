package panel;

import java.awt.Color;
import java.awt.Point;

public class ColoredSizedPoint {
	private Point coordinates;
	private Color color;
	private int size;
	private Color lastColor;
	
	public ColoredSizedPoint(Point p, Color c, int size) {
		this.coordinates = p;
		this.color = c;
		this.size = size;
	}
	
	public Point getPointCoordinates() {
		return this.coordinates;
	}
	
	public void setPointColor(final Color c) {
		this.lastColor = this.color;
		this.color = c;
	}
	
	public void traslate(Point p) {
		this.coordinates.x += p.getX();
		this.coordinates.y += p.getY();
	}
	
	public void setPointSize(final int newSize) {
		this.size = newSize;
	}
	
	public int getPointSize() {
		return this.size;
	}
	
	public Color getPointLastColor() {
		return this.lastColor;
	}
	
	public Color getPointColor() {
		return this.color;
	}
}
