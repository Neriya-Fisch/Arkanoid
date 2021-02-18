package assfive;

/**
 * A simple class to describe the Counter object.
 */
public class Counter {
    private int counter;

    /**
     * constructor.
     */
    public Counter() {
        counter = 0;
    }

    /**
     * add number to current count.
     *
     * @param number we add.
     */
    public void increase(int number) {
        counter = counter + number;
    }

    /**
     * subtract number from current count.
     *
     * @param number we subtract.
     */
    public void decrease(int number) {
        counter = counter - number;
    }

    /**
     * get current count.
     *
     * @return the value.
     */
    public int getValue() {
        return counter;
    }
}