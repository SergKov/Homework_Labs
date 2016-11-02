package homework1;

import java.math.BigInteger;

import static homework1.Utils.*;

/**
 * Created by koval on 30.10.2016.
 */
public class CaracubaMultiple {

    public static BigInteger getMultipleRec(final BigInteger first, final BigInteger second) {

        int max = Math.max(first.bitLength(), second.bitLength());

        if (!isIntMoreZero(addInts(max, -2000))) {
            return first.multiply(second);
        }

        max = addInts(max >> 1, max % 2);

        final BigInteger b = first.shiftRight(max);
        final BigInteger a = first.subtract(b.shiftLeft(max));
        final BigInteger d = second.shiftRight(max);
        final BigInteger c = second.subtract(d.shiftLeft(max));

        final BigInteger ac = getMultipleRec(a, c);
        final BigInteger bd = getMultipleRec(b, d);

        final BigInteger abcd = getMultipleRec(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(max)).add(bd.shiftLeft(max >> 1));
    }
}
