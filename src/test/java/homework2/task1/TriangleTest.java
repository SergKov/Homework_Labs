package homework2.task1;

import org.junit.Test;

import static homework2.task1.ShapeTest.DELTA;
import static org.junit.Assert.assertEquals;

/**
 * Created by koval on 05.11.2016.
 */
public class TriangleTest {

    private final Triangle triangle = new Triangle();

    @Test(expected = IllegalStateException.class)
    public void requireExceptionWithNoParameters() {
        triangle.getSquare();
    }

    @Test
    public void requireResultWithIntegerDouble() {
        triangle.setBase(10);
        triangle.setHeight(65.1);
        final double expected = 325.5;
        final double result = triangle.getSquare();
        assertWithExpected(expected, result);
    }

    @Test
    public void requireResultWithDoubleDouble() {
        triangle.setBase(578.05);
        triangle.setHeight(1007.25);
        final double expected = 291120.43125;
        final double result = triangle.getSquare();
        assertWithExpected(expected, result);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultZeroZero() {
        triangle.setBase(0);
        triangle.setHeight(0);
        triangle.getSquare();
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultZeroDouble() {
        triangle.setBase(0);
        triangle.setHeight(89.977);
        triangle.getSquare();
    }

    @Test
    public void requireResultWithDoubleInteger() {
        triangle.setBase(.8);
        triangle.setHeight(2);
        final double expected = .8;
        final double result = triangle.getSquare();
        assertWithExpected(expected, result);
    }

    @Test
    public void requireResultWithIntegerInteger() {
        triangle.setBase(Integer.valueOf("890"));
        triangle.setHeight(Integer.valueOf(8));
        final double expected = 3560;
        final double result = triangle.getSquare();
        assertWithExpected(expected, result);
    }

    private void assertWithExpected(final double expected, final double result) {
        assertEquals(expected, result, DELTA);
    }
}
