//ID 315558692
package assthree;

/**
 * The Collidable interface will be used by things that can be collided with.
 */
public interface Collidable {

    /**
     * Return the "collision shape" of the object.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint  the collision point.
     * @param currentVelocity the collision velocity.
     * @param hitter a ball.
     * @return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
