//315558692
package asssix;

import assthree.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * * The background of level 1.
 */
public class FinalFourBackground implements Sprite {
    private DrawSurface drawSurface;

    /**
     * Constructor.
     *
     * @param drawSurface which draws.
     */
    public FinalFourBackground(DrawSurface drawSurface) {
        this.drawSurface = drawSurface;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the surface we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.blue);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.white);
        d.drawText(190, 540, "Why does six scared from seven? because seven ate nine:)", 20);

    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
