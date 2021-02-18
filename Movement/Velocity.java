//  ID 315558692
package assthree;

/**
 * The class define a velocity of a ball (velocity specifies the change in position on the `x` and the `y` axis).
 */
public class Velocity {
    private double dx;
    private double dy;


    /**
     * Build velocity by dx and dy.
     *
     * @param dx the movement on X axis.
     * @param dy the movement on Y axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * get the dx velocity.
     *
     * @return dx.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * get the dy velocity.
     *
     * @return dy.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * calculate the speed of the velocity by pythagoras phrase.
     *
     * @return the speed as a double.
     */
    public Double getSpeed() {
        Double speed = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return speed;
    }

    /**
     * define velocity by angel and speed and calculate them with trigonometric math.
     *
     * @param angle the angle the ball move (0 degree is up)
     * @param speed the units on X axis the ball progress.
     * @return the velocity of the ball.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radians = Math.toRadians(angle - 90);
        double dx = speed * Math.cos(radians);
        double dy = speed * Math.sin(radians);
        return new Velocity(dx, dy);
    }

    /**
     * Take a point with position (x,y).
     *
     * @param p a point.
     * @return a new point with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        Point p2 = new Point(p.getX() + dx, p.getY() + dy);
        return p2;
    }
}