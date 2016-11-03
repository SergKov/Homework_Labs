package homework1;

import java.math.BigInteger;

import static homework1.Utils.*;

/**
 * Created by koval on 30.10.2016.
 */
public class CaracubaMultiple {

    public static BigInteger getMultipleRec(final BigInteger first, final BigInteger second) {

        int N = Math.max(first.bitLength(), second.bitLength());

        if (!isIntMoreZero(addInts(N, -2000))) {
            return first.multiply(second);
        }

        N = addInts(N >> 1, N % 2);

        final BigInteger b = first.shiftRight(N);
        final BigInteger a = first.subtract(b.shiftLeft(N));
        final BigInteger d = second.shiftRight(N);
        final BigInteger c = second.subtract(d.shiftLeft(N));

        final BigInteger ac = getMultipleRec(a, c);
        final BigInteger bd = getMultipleRec(b, d);

        final BigInteger abcd = getMultipleRec(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(N >> 1));
    }
}
