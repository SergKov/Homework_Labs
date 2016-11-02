package homework1;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by koval on 02.11.2016.
 */
public class CaracubaMultipleTest {

    private final CaracubaMultiple caracubaMultiple = new CaracubaMultiple();

    @Test
    public void testPositiveNumbers() {
        final BigInteger first = new BigInteger("5");
        final BigInteger second = new BigInteger("8");
        final BigInteger expected = new BigInteger("40");
        assertWithExpectedNumber(first, second, expected);
    }

    @Test
    public void testNegativeNumbers() {
        final BigInteger first = new BigInteger("-5");
        final BigInteger second = new BigInteger("-90");
        final BigInteger expected = new BigInteger("450");
        assertWithExpectedNumber(first, second, expected);
    }

    @Test
    public void testZeroNumbers() {
        final BigInteger first = new BigInteger("0");
        final BigInteger second = new BigInteger("0");
        final BigInteger expected = new BigInteger("0");
        assertWithExpectedNumber(first, second, expected);
    }

    @Test
    public void testNegativePositiveNumbers() {
        final BigInteger first = new BigInteger("-6000000");
        final BigInteger second = new BigInteger("6000000");
        final BigInteger expected = new BigInteger("-36000000000000");
        assertWithExpectedNumber(first, second, expected);
    }

    private void assertWithExpectedNumber(final BigInteger first, final BigInteger second, final BigInteger expected) {
        final BigInteger result = caracubaMultiple.getMultipleRec(first, second);
        Assert.assertEquals(result, expected);
    }
}
