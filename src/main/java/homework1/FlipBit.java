package homework1;

/**
 * Created by koval on 30.10.2016.
 */
public class FlipBit {

    public int flipBit(final int value, final int pos) {

        if (pos < 0) {
            throw new ArithmeticException("pos is negative");
        }

        return value ^ (1 << pos);
    }
}
