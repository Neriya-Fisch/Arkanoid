package assfive;

import assthree.Ball;
import assthree.Block;
import assthree.GameLevel;

/**
 * A BlockRemover is in charge of removing blocks from the game, as well as keeping count.
 * of the number of blocks that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor.
     * @param game the object that runs the game.
     * @param remainingBalls count how many balls left in the game.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(this.game);
    }
}