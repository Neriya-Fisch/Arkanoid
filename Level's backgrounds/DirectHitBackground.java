//315558692
package asssix;

import assthree.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The background of level 1.
 */
public class DirectHitBackground implements Sprite {
    private DrawSurface drawSurface;

    /**
     * Constructor.
     *
     * @param drawSurface which draws.
     */
    public DirectHitBackground(DrawSurface drawSurface) {
        this.drawSurface = drawSurface;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the surface we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLUE);
        d.drawCircle(400, 230, 20);
        d.drawCircle(400, 230, 60);
        d.drawCircle(400, 230, 100);
        d.drawCircle(400, 230, 140);
        d.drawLine(300, 230, 500, 230);
        d.drawLine(400, 130, 400, 330);

    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }


}
