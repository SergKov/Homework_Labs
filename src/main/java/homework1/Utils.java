package homework1;

/**
 * Created by koval on 01-Nov-16.
 */
public class Utils {

    private Utils () { }

    public static long addLongs(long a, long b) {
        long result;
        long carry;

        do {
            result = a ^ b;
            carry = (a & b) << 1;
            a = result;
            b = carry;
        } while (carry != 0);

        return result;
    }

    public static int addInts(int a, int b) {
        int result;
        int carry;

        do {
            result = a ^ b;
            carry = (a & b) << 1;
            a = result;
            b = carry;
        } while (carry != 0);

        return result;

    }

    public static boolean isLongMoreZero(final long number) {
        return (number & Long.MIN_VALUE) == 0;
    }

    public static boolean isIntMoreZero(final int number) {
        return (number & Integer.MIN_VALUE) == 0;
    }
}
