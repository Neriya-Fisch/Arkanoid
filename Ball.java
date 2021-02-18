//ID 315558692
package assthree;

import biuoop.DrawSurface;

/**
 * The class define the object Ball.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * Build a ball like a circle- point,radius and a color.
     *
     * @param center          the Center point.
     * @param r               the radius of the ball(/circle).
     * @param color           the color of the ball.
     * @param gameEnvironment the collidable list.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Build a ball like a circle- point,radius and a color.
     *
     * @param x     value of the Center point.
     * @param y     value of the Center point.
     * @param r     the radius of the ball(/circle).
     * @param color the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }


    /**
     * check what is the coordinate in X axis of the center point.
     *
     * @return the x value of this point.
     */
    public int getX() {
        int x = (int) Math.round(this.center.getX());
        return x;
    }

    /**
     * check what is the coordinate in Y axis of the center point.
     *
     * @return the x value of this point.
     */
    public int getY() {
        int y = (int) Math.round(this.center.getY());
        return y;
    }

    /**
     * check what is the radius of the center point.
     *
     * @return radius of this point.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * check what color the ball is.
     *
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * implement sprite- draw the ball on the given DrawSurface.
     *
     * @param surface to draw the ball on.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        int x = this.getX();
        int y = this.getY();
        surface.fillCircle(x, y, this.r);
    }

    /**
     * implement sprite- make one move.
     */
    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * check the velocity (speed) of the ball.
     *
     * @param v is the velocity of our ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * define the velocity of our ball.
     *
     * @param dx the number of steps on the X axis.
     * @param dy the number of steps on the Y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * check what is the velocity of our ball.
     *
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * move the ball in the screen (less useful from the second moveOneStep method).
     */
    public void moveOneStep() {
        Line line = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        if (gameEnvironment.getClosestCollision(line) == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(line);
            this.velocity = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), this.velocity);
        }
    }

    /**
     * initialize the GameEnvironment.
     *
     * @param gameEnvironment1 initialize the GameEnvironment.
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment1) {
        this.gameEnvironment = gameEnvironment1;
    }

    /**
     * return the GameEnviroment object.
     *
     * @return GameEnviroment.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * Add the ball to the game.
     *
     * @param g is the game object.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * remove the ball from the game.
     *
     * @param game is the game object.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}


