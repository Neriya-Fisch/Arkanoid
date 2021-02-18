//315558692
package asssix;

import assfive.Counter;
import biuoop.DrawSurface;

/**
 * announce you win and print a screen with the score.
 */
public class WinGame implements Animation {
    private boolean stop;
    private int width;
    private int height;
    private Counter score;

    /**
     * Constructor.
     *
     * @param width  of the gui screen.
     * @param height of the gui screen.
     * @param score  of the game.
     */
    public WinGame(int width, int height, Counter score) {
        this.stop = false;
        this.height = height;
        this.width = width;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(width / 10, height / 2, "You Win! your score is: " + score.getValue(), 50);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
