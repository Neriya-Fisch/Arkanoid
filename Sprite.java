//ID 315558692
package assthree;

import biuoop.DrawSurface;

/**
 * The sprite interface Sprites can be drawn on the screen, and can be notified that time has passed.
 * For us, all of the game objects (Ball, Block, Paddle, ...) are Sprites.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d the surface we draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}