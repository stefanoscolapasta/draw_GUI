package panel;

import java.util.List;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Line {
    final private List<ColoredSizedPoint> points;
    private Color actualLineColor;
    private Color LineLastColor;
    private int actualLineSize;

    public Line() {
        this.points = new ArrayList<>();
    }

    public Color getLineColor() {
        this.points.forEach(point -> actualLineColor = point.getPointColor());
        return this.actualLineColor;
    }

    public Color getLineLastColor() {
        this.points.forEach(point -> LineLastColor = point.getPointLastColor());
        return this.LineLastColor;
    }

    public int getLineSize() {
        this.points.forEach(point -> actualLineSize = point.getPointSize());
        return this.actualLineSize;
    }

    public void addPoint(ColoredSizedPoint p) {
        this.points.add(p);
    }

    public List<ColoredSizedPoint> getColoredSizedPoint() {
        return this.points;
    }

    public Set<Point> getPoints() {
        Set<Point> pointsCoordinates = new HashSet<>();
        this.points.forEach(point -> pointsCoordinates.add(point.getPointCoordinates()));
        return pointsCoordinates;
    }

}
