package homework2.task1;

import org.junit.Test;

import static homework2.task1.ShapeTest.DELTA;
import static org.junit.Assert.assertEquals;

/**
 * Created by koval on 07.11.2016.
 */
public class TrapeziumTest {

    private final Trapezium trapezium = new Trapezium();

    @Test(expected = IllegalStateException.class)
    public void requireExceptionWithNoParameters() {
        trapezium.getSquare();
    }

    @Test
    public void requireResultWithIntegerDoubleDouble() {
        final int base = 10;
        trapezium.setBase(base);
        final double oppositeBase = 87.8;
        trapezium.setOppositeBase(oppositeBase);
        final double height = 65.1;
        trapezium.setHeight(height);
        final double expected = 3183.39;
        final double result = trapezium.getSquare();
        assertWithExpected(expected, result);
    }

    @Test
    public void requireResultWithDoubleDoubleDouble() {
        trapezium.setBase(678.05);
        trapezium.setOppositeBase(87.67);
        trapezium.setHeight(1007.25);
        final double expected = 385635.735;
        final double result = trapezium.getSquare();
        assertWithExpected(expected, result);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultZeroZeroZero() {
        trapezium.setBase(0);
        trapezium.setOppositeBase(0);
        trapezium.setHeight(0);
        trapezium.getSquare();
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultZeroDoubleDouble() {
        trapezium.setBase(0);
        trapezium.setOppositeBase(87.98);
        trapezium.setHeight(89.977);
        trapezium.getSquare();
    }

    @Test
    public void requireResultWithDoubleDoubleInteger() {
        trapezium.setBase(.8);
        trapezium.setOppositeBase(.2);
        trapezium.setHeight(new Integer(2));
        final double expected = 1;
        final double result = trapezium.getSquare();
        assertWithExpected(expected, result);
    }

    @Test
    public void requireResultWithIntegerIntegerInteger() {
        trapezium.setBase(Integer.valueOf("890"));
        trapezium.setOppositeBase(56);
        trapezium.setHeight(Integer.valueOf(8));
        final double expected = 3784;
        final double result = trapezium.getSquare();
        assertWithExpected(expected, result);
    }

    private void assertWithExpected(final double expected, final double result) {
        assertEquals(expected, result, DELTA);
    }
}
