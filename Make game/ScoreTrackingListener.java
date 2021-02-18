package assfive;

import assthree.Ball;
import assthree.Block;

/**
 * this object is in charge to update this counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     *
     * @param scoreCounter is the counter of the points.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}
