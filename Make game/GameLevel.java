//ID 315558692
package assthree;

import assfive.BallRemover;
import assfive.BlockRemover;
import assfive.Counter;
import assfive.ScoreTrackingListener;
import assfive.ScoreIndicator;
import asssix.AnimationRunner;
import asssix.Animation;
import asssix.LevelInformation;
import asssix.CountdownAnimation;
import asssix.PauseScreen;
import asssix.KeyPressStoppableAnimation;
import asssix.GameOver;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;

/**
 * Define the game object that actually organize the game and sets it off.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private biuoop.GUI gui;
    private int width;
    private int height;
    private biuoop.KeyboardSensor keyboardSensor;
    private Counter blocksCounter = new Counter();
    private Counter ballsCounter = new Counter();
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation levelInformation;
    private DrawSurface drawSurface;

    /**
     * Constructor.
     *
     * @param levelInformation the information about the specific level we play.
     * @param gui              the GUI screen.
     * @param width            of the gui.
     * @param height           of the screen.
     * @param drawSurface      draws on the gui.
     * @param keyboardSensor   of the user.
     * @param score            of the game.
     */
    public GameLevel(LevelInformation levelInformation, GUI gui, int width, int height, DrawSurface drawSurface
            , KeyboardSensor keyboardSensor, Counter score) {
        this.levelInformation = levelInformation;
        this.gui = gui;
        this.drawSurface = drawSurface;
        this.keyboardSensor = keyboardSensor;
        this.width = width;
        this.height = height;
        this.score = score;
    }

    /**
     * add the collidable to environment that keep a list of them.
     *
     * @param c the collidable we want to add to the list.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * add the sprite to sprites that keep a list of them.
     *
     * @param s the sprite we want to add to the list.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * make 4 blocks that use as the frame of the game.
     */
    public void drawFrame() {
        Rectangle rectangle = new Rectangle(new Point(0, 20), 770, 30);
        Block block1 = new Block(rectangle, Color.GRAY);
        Rectangle rectangle2 = new Rectangle(new Point(0, 50), 30, 550);
        Block block2 = new Block(rectangle2, java.awt.Color.GRAY);
        Rectangle rectangle3 = new Rectangle(new Point(770, 20), 30, 580);
        Block block3 = new Block(rectangle3, java.awt.Color.GRAY);
        Block[] blocksFrame = new Block[]{block1, block2, block3, block3};
        for (Block block : blocksFrame) {
            block.addToGame(this);
        }
    }

    /**
     * creates a blocks for a given row (in a gradual order).
     *
     * @param blockRemover          helps to remove blocks if got hit.
     * @param scoreTrackingListener allows to track and raise the score.
     */
    public void createBlocks(BlockRemover blockRemover, ScoreTrackingListener scoreTrackingListener) {
        List<Block> blocks = this.levelInformation.blocks();
        for (Block block : blocks) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            blocksCounter.increase(1);
            block.addHitListener(scoreTrackingListener);
        }
    }


    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        sprites.addSprite(this.levelInformation.getBackground(this.drawSurface));
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(width / 2, height - 100, 5, Color.YELLOW);
            ball.setVelocity(levelInformation.initialBallVelocities().get(i));
            ball.addToGame(this);
            ball.setGameEnvironment(this.environment);
        }
        Paddle paddle = new Paddle(new Rectangle(new Point(width / 2 - levelInformation.paddleWidth() / 2, height - 30)
                , levelInformation.paddleWidth(), 22), Color.YELLOW, keyboardSensor, levelInformation.paddleSpeed());
        paddle.addToGame(this);
        drawFrame();
        BlockRemover blockRemover = new BlockRemover(this, blocksCounter);
        ballsCounter.increase(levelInformation.numberOfBalls());
        BallRemover ballRemover = new BallRemover(this, ballsCounter);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);
        createBlocks(blockRemover, scoreTrackingListener);
        Block deathBlock = new Block(new Rectangle(new Point(-100, 610), 1000, 10), Color.YELLOW);
        deathBlock.addToGame(this);
        deathBlock.addHitListener(ballRemover);
        ScoreIndicator scoreIndicator = new ScoreIndicator(score, levelInformation.levelName());
        scoreIndicator.addToGame(this);

    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        this.running = true;
        this.runner = new AnimationRunner(this.gui, 60, sleeper);
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.runner.run(this);
    }

    /**
     * remove the collidiable from the list.
     *
     * @param c the collidable.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * remove the sprite from the list.
     *
     * @param s the sprite.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        boolean flag = false;
        while (!shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            d = gui.getDrawSurface();
            d.setColor(Color.blue);
            d.fillRectangle(0, 0, 800, 600);
            this.sprites.drawAllOn(d);
            this.sprites.notifyAllTimePassed();
            gui.show(d);
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
            if (flag) {
                this.running = false;
                sleeper.sleepFor(100);
            }
            if (blocksCounter.getValue() == 0) {
                flag = true;
            }
            if (this.ballsCounter.getValue() == 0) {
                flag = true;
            }
            if (this.keyboardSensor.isPressed("p")) {
                Animation pause = new PauseScreen();
                Animation a1 = new KeyPressStoppableAnimation(keyboardSensor, keyboardSensor.SPACE_KEY, pause);
                this.runner.run(a1);
            }
        }

        if (ballsCounter.getValue() == 0) {
            Animation gameOver = new GameOver(width, height, score);
            Animation a2 = new KeyPressStoppableAnimation(keyboardSensor, keyboardSensor.SPACE_KEY, gameOver);
            this.runner.run(a2);
            gui.close();
        }
        this.score.increase(100);
        return;
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}