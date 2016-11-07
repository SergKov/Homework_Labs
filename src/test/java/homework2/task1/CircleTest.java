package homework2.task1;

import org.junit.Test;

import static homework2.task1.ShapeTest.DELTA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by koval on 06.11.2016.
 */
public class CircleTest {

    private final Circle circle = new Circle();

    @Test
    public void requireResultWithZeroRadius() {
        circle.setRadius(0);
        final double expected = 0;
        final double result = circle.getSquare();
        assertWithExpected(expected, result);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultWithNegativeRadius() {
        circle.setRadius(-98.6);
        circle.getSquare();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void requireResultWithBigNumber() { // 5.722235e+306   -- 50.722235e+306 ???
        circle.setRadius(60.722235e+306);
        circle.getSquare();
    }

    @Test
    public void requireResultWithIntegerNumber() {
        final int radius = 5_000;
        circle.setRadius(radius);
        final int moreExpected = 100_000_000;
        final double result = circle.getSquare();
        assertTrue(result < moreExpected);
    }

    private void assertWithExpected(final double expected, final double result) {
        assertEquals(expected, result, DELTA);
    }
}
