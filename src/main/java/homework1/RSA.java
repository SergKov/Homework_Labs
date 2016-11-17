package homework1;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by koval on 03.11.2016.
 */
public class RSA {

    private final static int BIT_LENGTH = 1024;

    private final BigInteger p;
    private final BigInteger q;
    private final BigInteger N;
    private final BigInteger v;
    private final BigInteger k;
    private final BigInteger d;
    private final Random random;

    public RSA() {
        random = new Random();
        p = BigInteger.probablePrime(BIT_LENGTH, random);
        q = BigInteger.probablePrime(BIT_LENGTH, random);
        N = p.multiply(q);
        v = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        k = BigInteger.probablePrime(BIT_LENGTH >> 1, random);
        d = k.modInverse(v);
    }

    public static String bytesToString(final byte[] encrypted) {
        String test = "";

        for (final byte b : encrypted) {
            test += Byte.toString(b);
        }

        return test;

    }

    public byte[] encrypt(final byte[] message) {

        if (message.length > N.intValue()) {
            throw new IllegalArgumentException("Too big string");
        }

        return (new BigInteger(message)).modPow(k, N).toByteArray();
    }

    public byte[] decrypt(final byte[] message) {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }

}
