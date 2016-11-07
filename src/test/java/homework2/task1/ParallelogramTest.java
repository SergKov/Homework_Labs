package homework2.task1;

import org.junit.Test;

import static homework2.task1.ShapeTest.DELTA;
import static org.junit.Assert.assertEquals;

/**
 * Created by koval on 07.11.2016.
 */
public class ParallelogramTest {

    private final Parallelogram parallelogram = new Parallelogram();

    @Test(expected = IllegalStateException.class)
    public void requireExceptionWithNoParameters() {
        parallelogram.getSquare();
    }

    @Test
    public void requireResultWithIntegerDouble() {
        parallelogram.setBase(10);
        parallelogram.setSide(65.2);
        final double expected = 652;
        final double result = parallelogram.getSquare();
        assertWithExpected(expected, result);
    }

    @Test
    public void requireResultWithDoubleDouble() {
        parallelogram.setBase(578.05);
        parallelogram.setSide(503.125);
        final double expected = 290831.40625;
        final double result = parallelogram.getSquare();
        assertWithExpected(expected, result);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultZeroZero() {
        parallelogram.setBase(0);
        parallelogram.setSide(0);
        parallelogram.getSquare();
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultZeroDouble() {
        parallelogram.setBase(0);
        parallelogram.setSide(89.977);
        parallelogram.getSquare();
    }

    @Test
    public void requireResultWithDoubleInteger() {
        parallelogram.setBase(.8);
        parallelogram.setSide(2);
        final double expected = 1.6;
        final double result = parallelogram.getSquare();
        assertWithExpected(expected, result);
    }

    @Test
    public void requireResultWithIntegerInteger() {
        parallelogram.setBase(Integer.valueOf("90"));
        parallelogram.setSide(Integer.valueOf(8));
        final double expected = 720;
        final double result = parallelogram.getSquare();
        assertWithExpected(expected, result);
    }

    private void assertWithExpected(final double expected, final double result) {
        assertEquals(expected, result, DELTA);
    }
}
