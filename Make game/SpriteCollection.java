//ID 315558692
package assthree;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * define the spriteCollection- a list of sprites.
 */
public class SpriteCollection {
    private List<Sprite> sprites = new ArrayList<Sprite>();

    /**
     * add a sprite to the sprite collection.
     *
     * @param s the sprite we add.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * remove a sprite to the sprite collection.
     *
     * @param s the sprite we remove.
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> copySprites = new ArrayList<>(this.sprites);
        for (Sprite s : copySprites) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d the surface we draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}