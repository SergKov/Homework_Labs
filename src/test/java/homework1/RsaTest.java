package homework1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by koval on 03.11.2016.
 */
public class RsaTest {

    final RSA rsa = new RSA();

    @Test
    public void test() {
        final String testString = "Encrypted String is Hello World";
        final byte[] encrypted = rsa.encrypt(testString.getBytes());
        final byte[] decryped = rsa.decrypt(encrypted);
        assertEquals(testString, new String(decryped));
    }
}
