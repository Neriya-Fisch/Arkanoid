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
 * The class of level 1.
 */
public class DirectHit implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        Velocity velocity = new Velocity(0, -5);
        velocities.add(velocity);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 120;
    }

    @Override
    public String levelName() {
        String str = "Direct Hit";
        return str;
    }

    @Override
    public Sprite getBackground(DrawSurface d) {
        DirectHitBackground directHitBackground = new DirectHitBackground(d);
        return directHitBackground;
    }

    @Override
    public List<Block> blocks() {
        Block block = new Block(new Rectangle(new Point(390, 220), 20, 20), Color.red);
        List<Block> blocks = new ArrayList<>();
        blocks.add(block);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
