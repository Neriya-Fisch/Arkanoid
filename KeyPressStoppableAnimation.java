//315558692
package asssix;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * class that wraps an existing animation and add a "waiting-for-key" behavior to it.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private Animation animation;
    private String key;
    private boolean stop = false;
    private boolean isAlreadyPressed;

    /**
     * Constructor.
     *
     * @param sensor    the given keyboard.
     * @param key       the button who stop.
     * @param animation the animation of the game.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.keyboardSensor = sensor;
        this.key = key;
        isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (keyboardSensor.isPressed(key) && !isAlreadyPressed) {
            this.stop = true;
        }
        if (!keyboardSensor.isPressed(key)) {
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop || animation.shouldStop();
    }
}
