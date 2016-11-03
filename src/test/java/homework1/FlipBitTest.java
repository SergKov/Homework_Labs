package homework1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by koval on 30.10.2016.
 */
public class FlipBitTest {

    private final FlipBit flipBit = new FlipBit();

    @Test
    public void testPositiveNumber() {
        final int number = 1;
        final int pos = 1;
        final int expected = 3;
        assertWithExpectedNumber(number, pos, expected);
    }

    @Test
    public void testMaxVerge() {
        final int number = Integer.MAX_VALUE;
        final int pos = 31;
        final int expected = -1;
        assertWithExpectedNumber(number, pos, expected);
    }

    @Test
    public void testMinVerge() {
        final int number = Integer.MIN_VALUE;
        final int pos = 31;
        final int expected = 0;
        assertWithExpectedNumber(number, pos, expected);
    }

    @Test
    public void testZeroNumber() {
        final int number = 0;
        final int pos = 31;
        final int expected = Integer.MIN_VALUE;
        assertWithExpectedNumber(number, pos, expected);
    }

    @Test
    public void testNegativeNumber() {
        final int number = -1;
        final int pos = 2;
        final int expected = -5;
        assertWithExpectedNumber(number, pos, expected);
    }

    @Test(expected = ArithmeticException.class)
    public void testNegativePosition() {
        final int number = 140;
        final int pos = -2;
        flipBit.flipBit(number, pos);
    }


    private void assertWithExpectedNumber(final int number, final int pos, final int expected) {
        final int result = flipBit.flipBit(number, pos);
        assertEquals(result, expected);
    }

}
