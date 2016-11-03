package homework1;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by koval on 03.11.2016.
 */
public class RSA {

    private final static int BIT_LENGTH = 128;

    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger v;
    private BigInteger k;
    private BigInteger d;
    private Random random;

    public RSA() {
        random = new Random();
        p = BigInteger.probablePrime(BIT_LENGTH, random);
        q = BigInteger.probablePrime(BIT_LENGTH, random);
        N = p.multiply(q);
        v = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        k = BigInteger.probablePrime(BIT_LENGTH >> 1, random);

        while (v.gcd(k).compareTo(BigInteger.ONE) > 0 && k.compareTo(v) < 0 ) {
            k.add(BigInteger.ONE);
        }

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
        return (new BigInteger(message)).modPow(k, N).toByteArray();
    }

    public byte[] decrypt(final byte[] message) {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }

}
