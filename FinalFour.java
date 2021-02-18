//315558692
package asssix;

import assthree.Block;
import assthree.Point;
import assthree.Sprite;
import assthree.Velocity;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The class of level 2.
 */
public class FinalFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        double angle = 315;
        for (int i = 0; i < numberOfBalls(); i++) {
            velocities.add(Velocity.fromAngleAndSpeed(angle, 13));
            angle += 45;
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 13;
    }

    @Override
    public int paddleWidth() {
        return 120;
    }

    @Override
    public String levelName() {
        String str = "Final Four";
        return str;
    }

    @Override
    public Sprite getBackground(DrawSurface d) {
        FinalFourBackground finalFourBackground = new FinalFourBackground(d);
        return finalFourBackground;
    }

    /**
     * create a row of blocks.
     *
     * @param color of the block.
     * @param row   number of the row.
     * @return a list of all the block.
     */
    public List<Block> createRow(Color color, int row) {
        List<Block> rowBlocks = new ArrayList<>();
        for (double i = 30; i < 770; i = i + 50) {
            double j = 150 + (row - 1) * 22;
            assthree.Rectangle rectangleRow = new assthree.Rectangle(new Point(i, j), 49, 22);
            Block blockRow = new Block(rectangleRow, color);
            rowBlocks.add(blockRow);
        }
        return rowBlocks;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.addAll(createRow(Color.gray, 1));
        blocks.addAll(createRow(Color.red, 2));
        blocks.addAll(createRow(Color.yellow, 3));
        blocks.addAll(createRow(Color.green, 4));
        blocks.addAll(createRow(Color.white, 5));
        blocks.addAll(createRow(Color.pink, 6));
        blocks.addAll(createRow(Color.CYAN, 7));
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
