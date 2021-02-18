//315558692

import asssix.LevelInformation;
import asssix.AnimationRunner;
import asssix.DirectHit;
import asssix.WideEasy;
import asssix.Green3;
import asssix.FinalFour;
import asssix.GameFlow;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class that create and run the game.
 */
public class Ass6Game {

    /**
     * play a game.
     *
     * @param args contain nothing.
     */
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        biuoop.GUI gui = new biuoop.GUI("Arkanoid", width, height);
        biuoop.KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        DrawSurface drawSurface = gui.getDrawSurface();
        Sleeper sleeper = new Sleeper();
        AnimationRunner animationRunner = new AnimationRunner(gui, 60, sleeper);
        List<LevelInformation> levels = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        DirectHit directHit = new DirectHit();
        WideEasy wideEasy = new WideEasy();
        Green3 green3 = new Green3();
        FinalFour finalFour = new FinalFour();
        GameFlow gameFlow = new GameFlow(animationRunner, keyboardSensor, gui, width, height, drawSurface);
        //if there are levels that the user enter we play them by order. else- play levels 1-4 game.
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1") || args[i].equals("2") || args[i].equals("3") || args[i].equals("4")) {
                    input.add(Integer.parseInt(args[i]));
                }
            }
            if (input.size() == 0) {
                levels.add(directHit);
                levels.add(wideEasy);
                levels.add(green3);
                levels.add(finalFour);
            }
            for (int i = 0; i < input.size(); i++) {
                if (input.get(i) == 1) {
                    levels.add(directHit);
                }
                if (input.get(i) == 2) {
                    levels.add(wideEasy);
                }
                if (input.get(i) == 3) {
                    levels.add(green3);
                }
                if (input.get(i) == 4) {
                    levels.add(finalFour);
                }
            }
        } else {

            levels.add(directHit);
            levels.add(wideEasy);
            levels.add(green3);
            levels.add(finalFour);
        }
        gameFlow.runLevels(levels);


    }
}
