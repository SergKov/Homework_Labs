package homework1;

import static homework1.Utils.addLongs;
import static homework1.Utils.isLongMoreZero;

/**
 * Created by koval on 30.10.2016.
 */
public class EvklidAlgorithm {

    public long findGreatestCommonDivisor(long a, long b) {

        if (addLongs(a, -Long.MIN_VALUE) == 0 || addLongs(b, -Long.MIN_VALUE) == 0) {
            throw new UnsupportedOperationException("Very small number");
        }

        if (!isLongMoreZero(a)) {
            a = -a;
        }

        if (!isLongMoreZero(b)) {
            b = -b;
        }

        return findGreatestCommonDivisorRec(a, b);

    }

    private long findGreatestCommonDivisorRec(final long a, final long b) {

        if (a == 0) {
            return b;
        }

        if (b == 0 || addLongs(a, -b) == 0) {
            return a;
        }

        if ((a & 1) == 0 && (b & 1) == 0) {
            return findGreatestCommonDivisorRec(a >> 1, b >> 1) << 1;
        }

        if ((a & 1) == 0 && (b & 1) != 0) {
            return findGreatestCommonDivisorRec(a >> 1, b);
        }

        if ((a & 1) != 0 && (b & 1) == 0) {
            return findGreatestCommonDivisorRec(a, b >> 1);
        }

        return (isLongMoreZero(addLongs(a, -b))) ?
                findGreatestCommonDivisorRec(addLongs(a, -b), b) : findGreatestCommonDivisorRec(a, addLongs(a, -b));
    }

}
