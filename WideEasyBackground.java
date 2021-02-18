//315558692
package asssix;

import assthree.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * * The background of level 4.
 */
public class WideEasyBackground implements Sprite {
    private DrawSurface drawSurface;

    /**
     * Constructor.
     *
     * @param d draws on the screen.
     */
    public WideEasyBackground(DrawSurface d) {
        this.drawSurface = d;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the surface we draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLUE);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.white);
        d.fillCircle(400, 300, 200);
        d.setColor(Color.black);
        d.fillCircle(320, 250, 40);
        d.fillCircle(480, 250, 40);
        d.drawLine(320, 400, 350, 430);
        d.drawLine(350, 430, 450, 430);
        d.drawLine(450, 430, 480, 400);
        d.drawText(230, 200, "Give a smile- everything has a reason!", 20);


    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
