//ID 315558692
package assthree;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * define the paddle object- a block controlled by the user's keyboard.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private Color color;
    private int speed;

    /**
     * constructor.
     *
     * @param rectangle      the shape of the paddle.
     * @param color          the color of the paddle.
     * @param keyboardSensor the keyboard of the user.
     * @param speed          the speed of the paddle.
     */
    public Paddle(Rectangle rectangle, Color color, KeyboardSensor keyboardSensor, int speed) {
        this.rectangle = rectangle;
        this.color = color;
        this.keyboard = keyboardSensor;
        this.speed = speed;
    }

    /**
     * move the paddle to left.
     */
    public void moveLeft() {
        if (rectangle.getBottomLeft().getX() >= 34) {
            rectangle = new Rectangle(new Point(rectangle.getUpperLeft().getX() - speed
                    , rectangle.getUpperLeft().getY()), rectangle.getWidth(), rectangle.getHeight());
        }

    }

    /**
     * move the paddle to right.
     */
    public void moveRight() {
        if (rectangle.getBottomRight().getX() <= 770) {
            rectangle = new Rectangle(new Point(rectangle.getUpperLeft().getX() + speed
                    , rectangle.getUpperLeft().getY()), rectangle.getWidth(), rectangle.getHeight());
        }
    }


    /**
     * check what tapped by the user and execute it.
     */
    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * implement sprite- draw the paddle to the screen.
     *
     * @param surface helps to draw the paddle.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        int x1 = (int) Math.round(this.rectangle.getUpperLeft().getX());
        int x2 = (int) Math.round(this.rectangle.getUpperLeft().getY());
        int x3 = (int) Math.round(this.rectangle.getWidth());
        int x4 = (int) Math.round(this.rectangle.getHeight());
        surface.fillRectangle(x1, x2, x3, x4);
        surface.setColor(Color.BLACK);
        surface.drawRectangle(x1, x2, x3, x4);
    }

    /**
     * implement collision- the Block is a rectangle Collision.
     *
     * @return the block (a rectangle).
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * implement collision- notify the object that we collided with it at collisionPoint with a given velocity.
     * The paddle as having 5 equally-spaced regions.
     * The behavior of the ball's bounce depends on where it hits the paddle.
     *
     * @param collisionPoint  is the collision point.
     * @param currentVelocity is the velocity of the object that we collided with.
     * @param hitter          the ball.
     * @return the appropriate velocity after the collision.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        int funPaddle = (int) rectangle.getWidth() / 5;
        Line region1 = new Line(rectangle.getUpperLeft(), new Point(rectangle.getUpperLeft().getX() + funPaddle - 1
                , rectangle.getUpperLeft().getY()));
        Line region2 = new Line(region1.end().getX() + 1, region1.end().getY(), region1.end().getX() + funPaddle
                , region1.end().getY());
        Line region3 = new Line(region2.end().getX() + 1, region2.end().getY(), region2.end().getX() + funPaddle
                , region2.end().getY());
        Line region4 = new Line(region3.end().getX() + 1, region3.end().getY(), region3.end().getX() + funPaddle
                , region3.end().getY());
        Line region5 = new Line(region4.end().getX() + 1, region4.end().getY(), region4.end().getX() + funPaddle
                , region4.end().getY());
        // if collide horizontally and vertically (at the edges)
        if (collisionPoint.equal(rectangle.getBottomLeft()) || collisionPoint.equal(rectangle.getBottomRight())
                || collisionPoint.equal(rectangle.getUpperLeft()) || collisionPoint.equal(rectangle.getUpperRight())) {
            Velocity newVelocity = new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy() * -1);
            return newVelocity;
        }
        // if collide in region 1
        if (collisionPoint.getX() >= region1.start().getX()
                && collisionPoint.getX() <= region1.end().getX()) {
            Velocity newVelocity = Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
            return newVelocity;
        }
        // if collide in region 2
        if (collisionPoint.getX() >= region2.start().getX()
                && collisionPoint.getX() <= region2.end().getX()) {
            Velocity newVelocity = Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
            return newVelocity;
        }
        // if collide in region 3
        if (collisionPoint.getX() >= region3.start().getX()
                && collisionPoint.getX() <= region3.end().getX()) {
            Velocity newVelocity = Velocity.fromAngleAndSpeed(0, currentVelocity.getSpeed());
            return newVelocity;
        }
        // if collide in region 4
        if (collisionPoint.getX() >= region4.start().getX()
                && collisionPoint.getX() <= region4.end().getX()) {
            Velocity newVelocity = Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
            return newVelocity;
        }
        // if collide in region 5
        if (collisionPoint.getX() >= region5.start().getX()
                && collisionPoint.getX() <= region5.end().getX()) {
            Velocity newVelocity = Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
            return newVelocity;
        }

        // if collide horizontally
        if (collisionPoint.getY() > rectangle.getUpperLeft().getY()
                && collisionPoint.getY() < rectangle.getBottomRight().getY()) {
            Velocity newVelocity = new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
            return newVelocity;
        } else {
            return currentVelocity;
        }
    }

    /**
     * Add the paddle to the game.
     *
     * @param g is the game object
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}