//315558692
package asssix;

import assthree.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The background of level 3.
 */
public class Green3Background implements Sprite {
    private DrawSurface drawSurface;

    /**
     * Constructor.
     *
     * @param drawSurface which draws.
     */
    public Green3Background(DrawSurface drawSurface) {
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
        d.setColor(Color.gray);
        d.fillRectangle(80, 450, 75, 150);
        d.setColor(Color.WHITE);
        int x = 90;
        int y = 460;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(x, y, 8, 20);
                x = x + 12;
            }
            x = 90;
            y = y + 30;
        }
        d.setColor(Color.gray);
        d.fillRectangle(100, 400, 35, 50);
        d.fillRectangle(112, 280, 10, 120);
        d.setColor(Color.orange);
        d.fillCircle(116, 260, 15);
        d.setColor(Color.yellow);
        d.fillCircle(116, 260, 10);
        d.setColor(Color.white);
        d.fillCircle(116, 260, 5);

    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }

}
