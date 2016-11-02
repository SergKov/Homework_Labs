package homework1;

import static homework1.Utils.isIntMoreZero;

/**
 * Created by koval on 30.10.2016.
 */
public class FlipBit {

    public int flipBit(final int value, final int pos) {

        if (!isIntMoreZero(pos)) {
            throw new ArithmeticException("pos is negative");
        }

        return value ^ (1 << pos);
    }
}
