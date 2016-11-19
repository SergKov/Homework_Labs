package homework1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by koval on 30.10.2016.
 */
public class EvklidAlgorithmTest {

    private final EvklidAlgorithm evklidAlgorithm = new EvklidAlgorithm();

    @Test
    public void testZeroNumber() {
        final int first = 0;
        final int second = 0;
        final int expected = 0;
        assertWithExpectedNumber(first, second, expected);
    }

    @Test
    public void testPositiveNumbers() {
        final int first = 81;
        final int second = 27;
        final int expected = 27;
        assertWithExpectedNumber(first, second, expected);
    }

    @Test
    public void testNegativeNumbers() {
        final int first = -81;
        final int second = -27;
        final int expected = 27;
        assertWithExpectedNumber(first, second, expected);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testOverflow() {
        final long first = Long.MIN_VALUE;
        final long second = Long.MIN_VALUE - 20;
        evklidAlgorithm.findGreatestCommonDivisor(first, second);
    }

    private void assertWithExpectedNumber(final long first, final long second, final long expected) {
        final long result = evklidAlgorithm.findGreatestCommonDivisor(first, second);
        assertEquals(expected, result);
    }
}
