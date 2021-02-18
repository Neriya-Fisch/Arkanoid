//315558692
package asssix;

import assthree.SpriteCollection;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen.
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private boolean stop = false;
    private boolean flag;
    private long start;
    private int countFrom;
    private double numOfSeconds;
    private SpriteCollection spriteCollection;

    /**
     * Constructor.
     *
     * @param numOfSeconds the countdown holds.
     * @param countFrom    which number.
     * @param gameScreen   all the sprites of the game.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.flag = true;
        this.countFrom = countFrom;
        this.numOfSeconds = numOfSeconds;
        this.spriteCollection = gameScreen;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.spriteCollection.drawAllOn(d);
        d.setColor(Color.red);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, countFrom + "...", 100);
        if (flag) {
            start = System.currentTimeMillis();
        }
        long timeHasPassed = System.currentTimeMillis();
        if ((timeHasPassed - start) / 500 >= 1) {
            start = System.currentTimeMillis();
            countFrom--;
        }
        if (countFrom == 0) {
            this.stop = true;
        }
        flag = false;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}