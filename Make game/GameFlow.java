//315558692
package asssix;

import assfive.Counter;
import assthree.GameLevel;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * This class will be in charge of creating the different levels, and moving from one level to the next.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private GUI gui;
    private DrawSurface drawSurface;
    private int width;
    private int height;

    /**
     * Constructor.
     *
     * @param ar          the AnimationRunner of the game.
     * @param ks          the keyboard of the game.
     * @param gui         the screen of the game.
     * @param width       the width of the gui screen.
     * @param height      the height of the screen.
     * @param drawSurface the drawsurface which draws on the screen.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui, int width, int height, DrawSurface drawSurface) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui;
        this.drawSurface = this.gui.getDrawSurface();
        this.width = width;
        this.height = height;
    }

    /**
     * support of moving from one level to the next.
     *
     * @param levels list of the game's level.
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter score = new Counter();
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, gui, width, height, drawSurface, keyboardSensor, score);
            level.initialize();
            while (level.shouldStop()) {
                level.run();
                if (level.shouldStop()) {
                    break;
                }
            }
        }
        //if we came to here it means we end all levels successfully.
        Animation youWin = new WinGame(width, height, score);
        Animation a1 = new KeyPressStoppableAnimation(keyboardSensor, keyboardSensor.SPACE_KEY, youWin);
        this.animationRunner.run(a1);
        gui.close();
    }
}
