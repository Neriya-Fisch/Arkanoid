//315558692
package asssix;

import assthree.Velocity;
import assthree.Sprite;
import assthree.Rectangle;
import assthree.Point;
import assthree.Block;

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * * The class of level 4.
 */
public class WideEasy implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        double angle = 310;
        for (int i = 0; i < 5; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(angle, 9));
            angle += 10;
        }
        angle = 10;
        for (int i = 0; i < 5; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(angle, 8));
            angle += 10;
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 470;
    }

    @Override
    public String levelName() {
        String str = "Wide Easy";
        return str;
    }

    @Override
    public Sprite getBackground(DrawSurface d) {
        WideEasyBackground wideEasyBackground = new WideEasyBackground(d);
        return wideEasyBackground;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int x = 30;
        for (int i = 0; i < 2; i++) {
            blocks.add(new Block(new Rectangle(new Point(x, 250), 48, 22), Color.RED));
            x += 49;
        }
        for (int i = 0; i < 2; i++) {
            blocks.add(new Block(new Rectangle(new Point(x, 250), 48, 22), Color.ORANGE));
            x += 49;
        }
        for (int i = 0; i < 2; i++) {
            blocks.add(new Block(new Rectangle(new Point(x, 250), 48, 22), Color.YELLOW));
            x += 49;
        }
        for (int i = 0; i < 3; i++) {
            blocks.add(new Block(new Rectangle(new Point(x, 250), 48, 22), Color.GREEN));
            x += 49;
        }
        for (int i = 0; i < 2; i++) {
            blocks.add(new Block(new Rectangle(new Point(x, 250), 48, 22), Color.BLUE));
            x += 49;
        }
        for (int i = 0; i < 2; i++) {
            blocks.add(new Block(new Rectangle(new Point(x, 250), 48, 22), Color.PINK));
            x += 49;
        }
        for (int i = 0; i < 2; i++) {
            blocks.add(new Block(new Rectangle(new Point(x, 250), 51, 22), Color.cyan));
            x += 52;
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
