package homework1;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by koval on 30.10.2016.
 */
public class QuantityBitsTest {
    
    private final QuantityBits quantityBits = new QuantityBits();

    @Test
    public void testQuantityBitsByte() {
        final byte number = 12;
        final int expected = 8;
        final int result = quantityBits.getQuantityBits(number);
        assertEquals(result, expected);
    }

    @Test
    public void testQuantityBitsShort() {
        final short number = Short.MAX_VALUE;
        final int expected = 16;
        final int result = quantityBits.getQuantityBits(number);
        assertEquals(result, expected);
    }

    @Test
    public void testQuantityBitsInt() {
        final int number = Integer.MAX_VALUE;
        final int expected = 32;
        final int result = quantityBits.getQuantityBits(number);
        assertEquals(result, expected);
    }

    @Test
    public void testQuantityBitsLong() {
        final long number = Long.MIN_VALUE;
        final int expected = 64;
        final int result = quantityBits.getQuantityBits(number);
        assertEquals(result, expected);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testQuantityBitsChar() {
        final char letter = 'z';
        quantityBits.getQuantityBits(letter);
    }
    
}
