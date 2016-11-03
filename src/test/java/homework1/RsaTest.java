package homework1;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(testString, new String(decryped));
    }
}
