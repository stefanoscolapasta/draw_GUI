package content;

import java.util.HashSet;
import java.util.Set;

public class LinesSet {
	private final Set<Line> linesSet;
	
	public LinesSet() {
		this.linesSet = new HashSet<>();
	}
	
	public Set<Line> getLines(){
		return this.linesSet;
	}
	
	public void addLine(Line line){
		this.linesSet.add(line);
	}
	
	public void empty() {
		this.linesSet.clear();
	}
}
