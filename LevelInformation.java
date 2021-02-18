//315558692
package asssix;

import assthree.Velocity;
import assthree.Sprite;
import assthree.Block;
import biuoop.DrawSurface;

import java.util.List;

/**
 * The LevelInformation interface specifies the information required to fully describe a level.
 */
public interface LevelInformation {
    /**
     * how much balls there are in the game.
     *
     * @return the number of them.
     */
    int numberOfBalls();


    /**
     * The initial velocity of each ball.
     * initialBallVelocities().size() == numberOfBalls()
     *
     * @return a list of the velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * the speed of the paddle.
     *
     * @return the speed.
     */
    int paddleSpeed();

    /**
     * the width of the paddle.
     *
     * @return the width.
     */
    int paddleWidth();


    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the name as a string.
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @param d draws on the screen.
     * @return the background we created.
     */
    Sprite getBackground(DrawSurface d);


    /**
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return the list.
     */
    List<Block> blocks();


    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     * This number = blocks.size();
     *
     * @return the number.
     */
    int numberOfBlocksToRemove();

}
