package panel;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class DrawPanel extends JPanel {
    static final Color DEFALUT_COLOR = Color.BLACK;
    static final int DEFALUT_SIZE = 1;
    private static final int MAX_DISTANCE = 999999;
    private static final long serialVersionUID = 7114066347061701832L;
    private LinesSet linesSet;
    private Line line;
    private Point vectorForTraslation;

    public DrawPanel() {
        this.line = new Line();
        this.linesSet = new LinesSet();
        this.linesSet.addLine(this.line);
    }
    /**
     * @param g is used to set graphical shapes and settings
     * 
     */
    public void paint(final Graphics g) {
        super.paintComponent(g);

        for (Line e : this.linesSet.getLines()) {
            ColoredSizedPoint last = null;
            for (ColoredSizedPoint c : e.getColoredSizedPoint()) {
                if (last != null) {
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(last.getPointColor());
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setStroke(new BasicStroke(c.getPointSize(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.drawLine((int) last.getPointCoordinates().getX() + (c.getPointSize() / 2),
                            (int) last.getPointCoordinates().getY() + (c.getPointSize() / 2),
                            (int) c.getPointCoordinates().getX() + (c.getPointSize() / 2),
                            (int) c.getPointCoordinates().getY() + (c.getPointSize() / 2));
                }
                last = new ColoredSizedPoint(c.getPointCoordinates(), c.getPointColor(), c.getPointSize());
            }
        }
    }
    /**
     * this method deletes all lines on call.
     * 
     */
    public void deleteEverything() {
        this.linesSet.empty();
        this.line = new Line();
        this.linesSet = new LinesSet();
        this.linesSet.addLine(this.line);
    }
    /**
     * @param size is used to set the actual line's size
     * 
     */
    public void setPenSize(final int size) {
        for (ColoredSizedPoint c : this.line.getColoredSizedPoint()) {
            c.setPointSize(size);
        }
    }
    /**
     * @param color is used to set the line's actual color
     * 
     */
    public void setColor(final Color color) {
        for (ColoredSizedPoint c : this.line.getColoredSizedPoint()) {
            c.setPointColor(color);
        }
    }
    /**
     * 
     * @param p is used to get the line at those coordinates
     * @return getLineAtCoordinates is the line the coordinates where clicked, so at coordinates @param p
     */
    public Line getLineAtCoordinates(final Point p) throws NoSuchElementException {
        for (Line l : this.linesSet.getLines()) { // I control if there is a line that has one of it's point in it's
                                                  // surroundings
            for (int i = (-l.getLineSize()); i <= l.getLineSize(); i++) {
                for (int j = (-l.getLineSize()); j <= l.getLineSize(); j++) {
                    if (l.getPoints().contains(new Point((int) (p.getX() + i), (int) (p.getY() + j)))) {
                        return l;
                    }
                }
            }
        }
        throw new NoSuchElementException();
    }
    /**
     * @param l is used to change the color of the passed line 
     * @param c is the color to which change the line passed as argument
     */
    public void changeLinesColor(final Line l, final Color c) throws NoSuchElementException {
        if (l != null) {
            for (ColoredSizedPoint p : l.getColoredSizedPoint()) {
                p.setPointColor(c);
            }
        } else {
            throw new NoSuchElementException();
        }
    }
    /**
     * this method resets the Vector used to traslate lines/points with the RMB.
     * 
     */
    public void resetVector() {
        this.vectorForTraslation = new Point();
    }
    /**
     * @param l is the line to traslate
     * @param vectorOfWhichTraslateLine is the vector of which traslate the line passed as first argument
     * @param isTraslating is a boolean used to know if the line is already been traslated and so there's no need to 
     * recalculate the new closest point to use as anchor for traslation
     */
    public void traslateLine(final Line l, final Point vectorOfWhichTraslateLine, final boolean isTraslating) {
        if (!isTraslating) { // This way it's not recalculated every time but only the first time the object
                             // is selected for traslation
            this.vectorForTraslation = this.findClosestPoint(l, vectorOfWhichTraslateLine);
        }
        int xTrasl = (int) (vectorOfWhichTraslateLine.getX() - this.vectorForTraslation.getX());
        int yTrasl = (int) (vectorOfWhichTraslateLine.getY() - this.vectorForTraslation.getY());
        Point vector = new Point(xTrasl, yTrasl);

        for (ColoredSizedPoint p : l.getColoredSizedPoint()) {
            p.traslate(vector);
        }
    }

    private Point findClosestPoint(final Line l, final Point a) {
        Point closest = new Point();
        int minDis = MAX_DISTANCE;
        for (Point p : l.getPoints()) {
            int actualDis = (int) (Math.pow((p.getX() - a.getX()), 2) + Math.pow((p.getY() - a.getY()), 2));
            if (actualDis < minDis) {
                minDis = actualDis;
                closest = p;
            }
        }
        return closest;
    }
    /**
     * this method is used to create a new Line Object, it's invoked as soon as the mouse is released after dragging a line.
     * 
     */
    public void createLineObj() {
        this.linesSet.addLine(this.line);
        this.line = new Line();
        this.linesSet.addLine(this.line);
    }
    /**
     * @param x is the x coordinate of the new point to add to the line object
     * @param y is the y coordinate of the new point to add to the line object
     * 
     */
    public void addPoint(final int x, final int y) {
        int lastSize = DEFALUT_SIZE;
        Color c1 = DEFALUT_COLOR;
        for (ColoredSizedPoint c : this.line.getColoredSizedPoint()) {
            lastSize = c.getPointSize();
            c1 = c.getPointColor();
        }

        if (lastSize < DEFALUT_SIZE) {
            lastSize = DEFALUT_SIZE;
        }

        this.line.addPoint(new ColoredSizedPoint(new Point(x - (lastSize / 2), y - (lastSize / 2)), c1, lastSize));
    }

}
