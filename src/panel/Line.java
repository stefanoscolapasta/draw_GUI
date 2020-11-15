package panel;

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
	
	public Set<ColoredSizedPoint> getPoints(){
		return this.points;
	}
}
