package homework1;

/**
 * Created by koval on 30.10.2016.
 */
public class EvklidAlgorithm {

    public long findGreatestCommonDivisor(long a, long b) {

        if (a == Long.MIN_VALUE || b == Long.MIN_VALUE) {
            throw new UnsupportedOperationException("Very small number");
        }

        if (a < 0) {
            a = -a;
        }

        if (b < 0) {
            b = -b;
        }

        return findGreatestCommonDivisorRec(a, b);

    }

    private long findGreatestCommonDivisorRec(final long a, final long b) {

        if (a == 0) {
            return b;
        }

        if (b == 0 || a == b) {
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

        return (a > b) ? findGreatestCommonDivisorRec(a - b, b) : findGreatestCommonDivisorRec(a, b - a);
    }

}
