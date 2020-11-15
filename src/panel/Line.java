package panel;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class Line {
	final private Set<ColoredSizedPoint> points;
	
	public Line() {
		this.points = new HashSet<>();
	}
	
	public void addPoint(ColoredSizedPoint p) {
		this.points.add(p);
	}
	
	public Set<ColoredSizedPoint> getColoredSizedPoint(){
		return this.points;
	}
	
	public Set<Point> getPoints(){
		Set<Point> pointsCoordinates = new HashSet<>();
		for(ColoredSizedPoint p : this.points) {
			pointsCoordinates.add(p.getPointCoordinates());
		}
		return pointsCoordinates;
	}
}
