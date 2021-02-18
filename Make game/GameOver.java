//315558692
package asssix;

import assfive.Counter;
import biuoop.DrawSurface;

/**
 * ends the game and print a screen with the score.
 */
public class GameOver implements Animation {
    private boolean stop;
    private int width;
    private int height;
    private Counter score;

    /**
     * Constructor.
     *
     * @param width  of the screen.
     * @param height of the screen.
     * @param score  of the game.
     */
    public GameOver(int width, int height, Counter score) {
        this.stop = false;
        this.height = height;
        this.width = width;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(width / 10, height / 2, "Game Over! your score is: " + score.getValue(), 50);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
