package homework1;

import static homework1.Utils.*;

/**
 * Created by koval on 29.10.2016.
 */
public class QuantityBits {

    public int getQuantityBits(final int number) {
        final int inverse = ~number;
        final int maskNumber = number | inverse;
        int count = 0;
        int tmp = maskNumber;
        while (tmp != 0) {
            count = addInts(count, 1);
            tmp >>>= 1;
        }
        return count;
    }

    public int getQuantityBits(final long number) {
        final long inverse = ~number;
        final long maskNumber = number | inverse;
        int count = 0;
        long tmp = maskNumber;
        while (tmp != 0) {
            count = addInts(count, 1);
            tmp >>>= 1;
        }
        return count;
    }

    public int getQuantityBits(final byte number) {
        final byte inverse = (byte) ~number;
        final byte maskNumber = (byte) (number | inverse);
        int count = 0;
        byte tmp = maskNumber;
        while (tmp != 0) {
            count = addInts(count, 1);
            tmp <<= 1;
        }
        return count;
    }

    public int getQuantityBits(final short number) {
        final short inverse = (short) ~number;
        final short maskNumber = (short) (number | inverse);
        int count = 0;
        short tmp = maskNumber;
        while (tmp != 0) {
            count = addInts(count, 1);
            tmp <<= 1;
        }
        return count;
    }

    public static int getQuantityBits(final char number) {
        throw new UnsupportedOperationException("Char is unsupported");
    }
}
