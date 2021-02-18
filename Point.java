//ID 315558692
package assthree;

/**
 * The class define Point by coordinates of x,y and some methods of using it.
 */
public class Point {
    private double x;
    private double y;

    /**
     * build the Point.
     *
     * @param x represents the distance from Y axis.
     * @param y represents the distance from X axis.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * return the distance of this point to the other point to the point of the class.
     *
     * @param other is the Point we want to measure the distance from our point.
     * @return the distance between them (a number).
     */
    public double distance(Point other) {
        double distance = Math.sqrt(((this.x - other.x) * (this.x - other.x))
                + ((this.y - other.y) * (this.y - other.y)));
        return distance;
    }

    /**
     * check if 2 points are equals or not.
     *
     * @param other is the Point we want to check if it same to our point.
     * @return true is the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return (this.x == other.x && this.y == other.y);
    }

    /**
     * check what is the coordinate in X axis.
     *
     * @return the x value of this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * check what is the coordinate in Y axis.
     *
     * @return the y value of this point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * check if 2 points are equals.
     * @param point the point we check on.
     * @return true or false.
     */
    public boolean equal(Point point) {
        return (this.getX() == point.getX() && this.getY() == point.getY());
    }
}