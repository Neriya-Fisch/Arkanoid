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
 * The class of level 3.
 */
public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        double angle = 310;
        for (int i = 0; i < numberOfBalls(); i++) {
            velocities.add(Velocity.fromAngleAndSpeed(angle, 11));
            angle += 100;
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 11;
    }

    @Override
    public int paddleWidth() {
        return 120;
    }

    @Override
    public String levelName() {
        String str = "Green 3";
        return str;
    }

    @Override
    public Sprite getBackground(DrawSurface d) {
        Green3Background green3Background = new Green3Background(d);
        return green3Background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocksRow = new ArrayList<>();
        int row = 0;
        for (double i = 320 + (row - 1) * 50; i < 770; i = i + 50) {
            double j = 150 + (row - 1) * 22;
            Rectangle rectangleRow = new Rectangle(new Point(i, j), 50, 22);
            Block blockRow = new Block(rectangleRow, Color.gray);
            blocksRow.add(blockRow);
        }
        row++;
        for (double i = 320 + (row - 1) * 50; i < 770; i = i + 50) {
            double j = 150 + (row - 1) * 22;
            Rectangle rectangleRow = new Rectangle(new Point(i, j), 50, 22);
            Block blockRow = new Block(rectangleRow, Color.red);
            blocksRow.add(blockRow);
        }
        row++;
        for (double i = 320 + (row - 1) * 50; i < 770; i = i + 50) {
            double j = 150 + (row - 1) * 22;
            Rectangle rectangleRow = new Rectangle(new Point(i, j), 50, 22);
            Block blockRow = new Block(rectangleRow, Color.yellow);
            blocksRow.add(blockRow);
        }
        row++;
        for (double i = 320 + (row - 1) * 50; i < 770; i = i + 50) {
            double j = 150 + (row - 1) * 22;
            Rectangle rectangleRow = new Rectangle(new Point(i, j), 50, 22);
            Block blockRow = new Block(rectangleRow, Color.blue);
            blocksRow.add(blockRow);
        }
        row++;
        for (double i = 320 + (row - 1) * 50; i < 770; i = i + 50) {
            double j = 150 + (row - 1) * 22;
            Rectangle rectangleRow = new Rectangle(new Point(i, j), 50, 22);
            Block blockRow = new Block(rectangleRow, Color.white);
            blocksRow.add(blockRow);
        }
        return blocksRow;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
