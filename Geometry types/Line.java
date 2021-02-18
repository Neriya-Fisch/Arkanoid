//ID 315558692
package assthree;

import java.util.List;

/**
 * The class define Line by connection of 2 points, and some methods of using it.
 */
public class Line {
    private Point start;
    private Point end;
    static final double EPSILON = Math.pow(10, -10);


    /**
     * Build the line by 2 points.
     *
     * @param start represent the first point.
     * @param end   represent the second point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Build the line by (x1,y1) represent the first point and (x2,y2) the second.
     *
     * @param x1 represents the distance of the start point from Y axis.
     * @param y1 represents the distance of the start point from X axis.
     * @param x2 represents the distance of the end point from Y axis.
     * @param y2 represents the distance of the end point from X axis.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * measure the length of the line- the distance between start to end points.
     *
     * @return the length of the line.
     */
    public double length() {
        double length = Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
        return length;
    }

    /**
     * check what is the middle of the line- ths average (x,y) point of start and end.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        double x = 2;
        Point middle = new Point((start.getX() + end.getX()) / x, (start.getY() + end.getY()) / x);
        return middle;

    }

    /**
     * Give the start point of the line.
     *
     * @return the start point of the line
     */
    public Point start() {
        return this.start;

    }

    /**
     * Give the end point of the line.
     *
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }

    /**
     * Give an equation as an array of 2 doubles. y=ax+b- arr[0] = a (incline), arr[1] = b.
     *
     * @param a the first point.
     * @param b the second point.
     * @return array of 2 doubles, represent an equation of straight line.
     */
    public double[] equation(Point a, Point b) {
        double[] equ = new double[2];
        double incline;
        //if the line is from form x=? then the incline is infinity or if the line is just a point
        if ((a.getX() - b.getX() == 0 && a.getY() > b.getY()) || (a.equal(b))) {
            incline = Double.POSITIVE_INFINITY;
            equ[0] = incline;
            equ[1] = a.getX();
            return equ;
        } else if (a.getX() - b.getX() == 0 && a.getY() < b.getY()) {
            incline = Double.NEGATIVE_INFINITY;
            equ[0] = incline;
            equ[1] = a.getX();
            return equ;
        }
        incline = (a.getY() - b.getY()) / (a.getX() - b.getX());
        equ[0] = incline;
        equ[1] = b.getY() - (incline * b.getX());
        return equ;
    }

    /**
     * check if 2 lines intersect (only in one point!).
     *
     * @param other the line we check if intersect with our line.
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        double[] equationUs = equation(this.start, this.end);
        double[] equationOther = equation(other.start, other.end);
        Line line = new Line(this.start, this.end);
        //if the lines are parallels
        if (equationOther[0] == equationUs[0]) {
            //check if there is only one intersect
            if (equationOther[1] != equationUs[1]) {
                return false;
            } else {
                return ((this.start == other.end && this.start == other.end
                        && this.end.getX() != other.start.getX() && this.end.getY() != other.start.getY())
                        || (this.start.getX() != other.end.getX() && this.start.getY() != other.end.getY()
                        && this.end.getX() == other.start.getX() && this.end.getY() == other.start.getY())
                        || (this.start.getX() == other.start.getX() && start.getY() == other.start.getY()
                        && end.getY() != other.end.getY() && end.getX() != other.end.getX())
                        || (this.start.getX() != other.start.getX() && start.getY() != other.start.getY()
                        && end.getY() == other.end.getY() && end.getX() == other.end.getX()));
            }
        }
        //if one of the equations is from form x=a
        if (equationUs[0] == Double.POSITIVE_INFINITY || equationUs[0] == Double.NEGATIVE_INFINITY) {
            double sharedX = equationUs[1];
            double sharedY = equationOther[0] * sharedX + equationOther[1];
            Point sharedPoint = new Point(sharedX, sharedY);
            return (line.pointOnLine(sharedPoint) && other.pointOnLine(sharedPoint));
        } else if (equationOther[0] == Double.POSITIVE_INFINITY || equationOther[0] == Double.NEGATIVE_INFINITY) {
            double sharedX = equationOther[1];
            double sharedY = equationUs[0] * sharedX + equationUs[1];
            Point sharedPoint = new Point(sharedX, sharedY);
            return (line.pointOnLine(sharedPoint) && other.pointOnLine(sharedPoint));
        }
        //else
        double sharedX = (equationUs[1] - equationOther[1]) / (equationOther[0] - equationUs[0]);
        double sharedY = equationUs[0] * sharedX + equationUs[1];        //check if the shared point is on the 2 lines
        Point sharedPoint = new Point(sharedX, sharedY);
        return (line.pointOnLine(sharedPoint) && other.pointOnLine(sharedPoint));
    }

    /**
     * check if there is an only intersection point between lines- the method give it.
     *
     * @param other is the other line we check with our line.
     * @return the intersection point if the lines intersect, and null otherwise
     */
    public Point intersectionWith(Line other) {
        Line line = new Line(this.start, this.end);
        if (!line.isIntersecting(other)) {
            return null;
        }
        double[] equationUs = equation(this.start, this.end);
        double[] equationOther = equation(other.start, other.end);
        //if one of the equations is from form x=a
        if (equationUs[0] == Double.POSITIVE_INFINITY || equationUs[0] == Double.NEGATIVE_INFINITY) {
            double sharedX = equationUs[1];
            double sharedY = equationOther[0] * sharedX + equationOther[1];
            Point intersect = new Point(sharedX, sharedY);
            return intersect;
        }
        if (equationOther[0] == Double.POSITIVE_INFINITY || equationOther[0] == Double.NEGATIVE_INFINITY) {
            double sharedX = equationOther[1];
            double sharedY = equationUs[0] * sharedX + equationUs[1];
            Point intersect = new Point(sharedX, sharedY);
            return intersect;
        }
        //else
        double sharedX = (equationUs[1] - equationOther[1]) / (equationOther[0] - equationUs[0]);
        double sharedY = equationUs[0] * sharedX + equationUs[1];
        Point intersect = new Point(sharedX, sharedY);
        return intersect;
    }

    /**
     * check if 2 lines are equals- begin and end in the same points.
     *
     * @param other is the line we check if it equals to our line.
     * @return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        return (this.start.getX() == other.start.getX() && this.start.getY() == other.start.getY()
                && this.end.getX() == other.end.getX() && this.end.getY() == other.end.getY());
    }

    /**
     * measure the length of the line- the distance between start to end points.
     *
     * @param p1 first point.
     * @param p2 second point.
     * @return the length.
     */
    public double length(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2)
                + Math.pow(p2.getY() - p1.getY(), 2));
    }

    /**
     * check if this line is intersect with the rectangle, and return its closest point.
     *
     * @param rect the rectangle.
     * @return if this line does not intersect with the rectangle, return null. Otherwise, return the closest.
     * intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line line = new Line(this.start, this.end);
        List<Point> pointsList = rect.intersectionPoints(line);
        if (pointsList.size() == 0) {
            return null;
        }
        //The maximum intersection points between a line and a rectangle are 2
        double length = length(line.start, pointsList.get(0));
        if (pointsList.size() == 2) {
            double length2 = length(line.start, pointsList.get(1));
            if (length2 < length) {
                return pointsList.get(1);
            }
        }
        return pointsList.get(0);
    }

    /**
     * check if point is on line.
     *
     * @param point the point.
     * @return true uf does, false if doesn't.
     */
    public boolean pointOnLine(Point point) {
        Line line = new Line(this.start, this.end);
        double[] equation = line.equation(this.start, this.end);
        //if one of the equations is from form x=a, check all the possible direction of a line- to left up, left down,
        //right up, right down.
        if (equation[0] == Double.POSITIVE_INFINITY || equation[0] == Double.NEGATIVE_INFINITY) {
            return ((equation[1] == point.getX() && point.getX() >= this.start.getX()
                    && point.getX() <= this.end.getX() && point.getY() >= this.start.getY()
                    && point.getY() <= this.end.getY())
                    || (equation[1] == point.getX() && point.getX() >= this.start.getX()
                    && point.getX() <= this.end.getX() && point.getY() <= this.start.getY()
                    && point.getY() >= this.end.getY())
                    || (equation[1] == point.getX() && point.getX() <= this.start.getX()
                    && point.getX() >= this.end.getX() && point.getY() >= this.start.getY()
                    && point.getY() <= this.end.getY())
                    || (equation[1] == point.getX() && point.getX() <= this.start.getX()
                    && point.getX() >= this.end.getX() && point.getY() <= this.start.getY()
                    && point.getY() >= this.end.getY()));
        }
        //check all the possible direction of a line- to left up, left down, right up, right down.
        //epsilon checks the in -accuracy of the double.
        return ((Math.abs(point.getY() - (equation[0] * point.getX() + equation[1]))
                < EPSILON && point.getX() >= this.start.getX()
                && point.getX() <= this.end.getX() && point.getY() >= this.start.getY()
                && point.getY() <= this.end.getY())
                || (Math.abs(point.getY() - (equation[0] * point.getX() + equation[1]))
                < EPSILON && point.getX() >= this.start.getX()
                && point.getX() <= this.end.getX() && point.getY() <= this.start.getY()
                && point.getY() >= this.end.getY())
                || (Math.abs(point.getY() - (equation[0] * point.getX() + equation[1]))
                < EPSILON && (point.getX() <= this.start.getX()
                && point.getX() >= this.end.getX() && point.getY() >= this.start.getY()
                && point.getY() <= this.end.getY()))
                || (Math.abs(point.getY() - (equation[0] * point.getX() + equation[1]))
                < EPSILON) && (point.getX() <= this.start.getX()
                && point.getX() >= this.end.getX() && point.getY() <= this.start.getY()
                && point.getY() >= this.end.getY()));
    }
}