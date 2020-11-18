package panel;

import java.util.ArrayList;
import java.util.List;

public class LinesSet {
	private final List<Line> linesSet;
	
	public LinesSet(Line l) {
		this.linesSet = new ArrayList<>();
		this.linesSet.add(l);
	}
	
	public List<Line> getLines(){
		return this.linesSet;
	}
	
	public void addLine(Line line){
		this.linesSet.add(line);
	}
	
	public void empty() {
		this.linesSet.clear();
	}
}
