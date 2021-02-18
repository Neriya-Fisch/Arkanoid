//315558692
package asssix;

import biuoop.DrawSurface;

/**
 * The interface helps to separate the GUI and frame-rate management code.
 * (which is general, and can be used in other places) from the actual loop body (which is specific to the Game class).
 */
public interface Animation {
    /**
     * Handle the game-specific logic.
     *
     * @param d the Drawsurface helps to draw on the screen.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Handle the stopping conditions.
     *
     * @return if the game should be stopped or not.
     */
    boolean shouldStop();
}