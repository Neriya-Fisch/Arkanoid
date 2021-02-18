package assfive;

import assthree.Ball;
import assthree.Block;
import assthree.GameLevel;

/**
 * A BlockRemover is in charge of removing blocks from the game, as well as keeping count.
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param game          the object that runs the game.
     * @param removedBlocks counts how many blocks left in the game.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Blocks that are hit should be remove from the game.
     *
     * @param beingHit the block being hit.
     * @param hitter   the ball.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(game);
    }


}