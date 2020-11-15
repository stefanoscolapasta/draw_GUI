package panel;

import java.util.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Line {
	final private List<ColoredSizedPoint> points;
	
	public Line() {
		this.points = new ArrayList<>();
	}
	
	public void addPoint(ColoredSizedPoint p) {
		this.points.add(p);
	}
	
	public List<ColoredSizedPoint> getColoredSizedPoint(){
		return this.points;
	}
	
	public int getLineSize() {
		int size = DrawPanel.DEFALUT_SIZE;
		for(ColoredSizedPoint p : this.points) {
			size = p.getPointSize();
		}
		return size;
	}
	
	public Set<Point> getPoints(){
		Set<Point> pointsCoordinates = new HashSet<>();
		for(ColoredSizedPoint p : this.points) {
			pointsCoordinates.add(p.getPointCoordinates());
		}
		return pointsCoordinates;
	}
}
