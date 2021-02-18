//ID 315558692
package assthree;

import assfive.HitListener;
import assfive.HitNotifier;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The class define the Block object and its methods.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners = new ArrayList<>();
    private Rectangle rectangle;
    private Color color;

    /**
     * Constructor.
     *
     * @param rectangle initialize the given rectangle.
     * @param color     initialize the given color.
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
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
     * is called whenever a hit() occurs.
     * and notifiers all of the registered HitListener objects by calling their hitEvent method.
     *
     * @param hitter the ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * implement collision- notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param hitter          is the ball
     * @param collisionPoint  is the collision point.
     * @param currentVelocity is the velocity of the object that we collided with.
     * @return the appropriate velocity after the collision.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // if collide horizontally and vertically (at the edges)
        if (collisionPoint.equal(rectangle.getBottomLeft()) || collisionPoint.equal(rectangle.getBottomRight())
                || collisionPoint.equal(rectangle.getUpperLeft()) || collisionPoint.equal(rectangle.getUpperRight())) {
            Velocity newVelocity = new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy() * -1);
            this.notifyHit(hitter);
            return newVelocity;
        }
        // if collide vertically
        if (collisionPoint.getX() > rectangle.getUpperLeft().getX()
                && collisionPoint.getX() < rectangle.getBottomRight().getX()) {
            Velocity newVelocity = new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
            this.notifyHit(hitter);
            return newVelocity;
        }
        // if collide horizontally
        if (collisionPoint.getY() > rectangle.getUpperLeft().getY()
                && collisionPoint.getY() < rectangle.getBottomRight().getY()) {
            Velocity newVelocity = new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
            this.notifyHit(hitter);
            return newVelocity;
        } else {
            return currentVelocity;
        }
    }

    /**
     * implement sprite- draw the block to the screen.
     *
     * @param surface helps to draw the block.
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
     * implement sprite- for now, do nothing.
     */
    @Override
    public void timePassed() {

    }

    /**
     * Add the block to the game.
     *
     * @param g is the game object
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * remove the block from the game.
     *
     * @param game is the game object.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
