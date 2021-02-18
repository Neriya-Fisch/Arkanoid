package assfive;

import assthree.Ball;
import assthree.Block;

/**
 * Objects that want to be notified of hit events, should implement the HitListener interface.
 * and register themselves with a HitNotifier object using its addHitListener method.
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     *
     * @param beingHit the objact being hit.
     * @param hitter   the ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
