//ID 315558692
package assthree;

import java.util.ArrayList;
import java.util.List;

/**
 * Define the object rectangle ant its methods.
 */
public class Rectangle {
    private Point upperLeft;
    private Line up;
    private Line down;
    private Line right;
    private Line left;
    private Double width;
    private Double height;

    // Create a new rectangle with location and width/height.

    /**
     * constructor.
     *
     * @param upperLeft the upper left point or the rectangle.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        //up and down sides- from left to right, left and right sides- from top to bottom.
        this.up = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY());
        this.left = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX(), upperLeft.getY() + height);
        this.down = new Line(upperLeft.getX(), upperLeft.getY() + height, upperLeft.getX() + width,
                upperLeft.getY() + height);
        this.right = new Line(upperLeft.getX() + width, upperLeft.getY(),
                upperLeft.getX() + width, upperLeft.getY() + height);
    }

    /**
     * Return a (possibly empty) List of intersection points with the specified line.
     *
     * @param line the specified line.
     * @return the list.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> pointsList = new ArrayList<Point>();
        if (this.up.isIntersecting(line)) {
            pointsList.add(this.up.intersectionWith(line));
        }
        if (this.down.isIntersecting(line)) {
            pointsList.add(this.down.intersectionWith(line));
        }
        if (this.left.isIntersecting(line)) {
            pointsList.add(this.left.intersectionWith(line));
        }
        if (this.right.isIntersecting(line)) {
            pointsList.add(this.right.intersectionWith(line));
        }
        return pointsList;
    }

    /**
     * Return the width of the rectangle.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Return the height of the rectangle.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Returns the upper-right point of the rectangle.
     *
     * @return the upper-right point of the rectangle.
     */
    public Point getUpperRight() {
        return this.up.end();
    }

    /**
     * Returns the bottom-left point of the rectangle.
     *
     * @return the bottom-left point of the rectangle.
     */
    public Point getBottomLeft() {
        return this.down.start();
    }


    /**
     * Returns the bottom-right point of the rectangle.
     *
     * @return the bottom-right point of the rectangle.
     */
    public Point getBottomRight() {
        return this.down.end();
    }

    /**
     * Returns the up side of the rectangle.
     *
     * @return the up side point of the rectangle.
     */
    public Line getUpSide() {
        return this.up;
    }

    /**
     * Returns the bottom side of the rectangle.
     *
     * @return the bottom side point of the rectangle.
     */
    public Line getBottomSide() {
        return this.down;
    }

    /**
     * Returns the left side of the rectangle.
     *
     * @return the left side point of the rectangle.
     */
    public Line getLeftSide() {
        return this.left;
    }

    /**
     * Returns the right side of the rectangle.
     *
     * @return the right side point of the rectangle.
     */
    public Line getRightSide() {
        return this.right;
    }
}