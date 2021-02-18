package assfive;


import assthree.GameLevel;
import assthree.Point;
import assthree.Rectangle;
import assthree.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * the Score indicator is in charge of displaying the current score.
 */
public class ScoreIndicator implements Sprite {
    private Counter counter;
    private String levelName;

    /**
     * constructor.
     *
     * @param counter   the game counter of points.
     * @param levelName of the level.
     */
    public ScoreIndicator(Counter counter, String levelName) {
        this.counter = counter;
        this.levelName = levelName;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the surface we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        Rectangle score = new Rectangle(new Point(0, 0), 800, 20);
        int x1 = (int) Math.round(score.getUpperLeft().getX());
        int x2 = (int) Math.round(score.getUpperLeft().getY());
        int x3 = (int) Math.round(score.getWidth());
        int x4 = (int) Math.round(score.getHeight());
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle(x1, x2, x3, x4);
        d.setColor(Color.black);
        d.drawRectangle(x1, x2, x3, x4);
        d.drawText(360, 19, "Score:" + counter.getValue(), 20);
        d.drawText(500, 19, "Level Name: " + levelName, 20);

    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * Add the score indicator to the game.
     *
     * @param g is the game object.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
