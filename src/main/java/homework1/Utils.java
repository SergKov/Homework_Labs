package homework1;

/**
 * Created by koval on 01-Nov-16.
 */
public class Utils {

    private Utils () { }

    public static long addLongs(final long a, final long b) {
        final long result = a ^ b;
        final long carry = (a & b) << 1;

        if (!(carry == 0)) {
            return addLongs(result, carry);
        }

        return result;
    }

    public static int addInts(final int a, final int b) {
        final int result = a ^ b;
        final int carry = (a & b) << 1;

        if (!(carry == 0)) {
            return addInts(result, carry);
        }

        return result;
    }

    public static boolean isLongMoreZero(final long number) {
        return (number & Long.MIN_VALUE) == 0;
    }

    public static boolean isIntMoreZero(final int number) {
        return (number & Integer.MIN_VALUE) == 0;
    }
}
