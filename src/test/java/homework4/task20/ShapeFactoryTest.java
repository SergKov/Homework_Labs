package homework4.task20;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by koval on 24.11.2016.
 */
public class ShapeFactoryTest {

    private final ShapeFactory shapeFactory = ShapeFactory.getInstance();

    @Test(expected = IllegalStateException.class)
    public void requireResultWithZeroParaters() {
        shapeFactory.createShape(0, 0);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultWithTooBigParameters() {
        shapeFactory.createShape(12, 280);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultWithBigNormalParameters() {
        shapeFactory.createShape(12, 2);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultWithNormalBigParameters() {
        shapeFactory.createShape(1, 12);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultWithNegativeParameters() {
        shapeFactory.createShape(-1, -1);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultWithPositiveNegativeParameters() {
        shapeFactory.createShape(1, -2);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultWithNegativePositiveParameters() {
        shapeFactory.createShape(-1, 2);
    }

    @Test
    public void requireResultWithZeroNonZeroParameters() {
        final int expectedX = 0;
        final int expectedY = 2;

        final Shape shape = shapeFactory.createShape(0, 2);
        final int resultX = shape.getX();
        final int resultY = shape.getY();

        assertEquals(expectedX, resultX);
        assertEquals(expectedY, resultY);
    }

    @Test
    public void requireResultWithNonZeroZeroParameters() {
        final int expectedX = 1;
        final int expectedY = 0;

        final Shape shape = shapeFactory.createShape(1, 0);
        final int resultX = shape.getX();
        final int resultY = shape.getY();

        assertEquals(expectedX, resultX);
        assertEquals(expectedY, resultY);
    }

    @Test
    public void requireResultWithValidatedParameters() {
        final int expectedX = 1;
        final int expectedY = 2;

        final Shape shape = shapeFactory.createShape(1, 2);
        final int resultX = shape.getX();
        final int resultY = shape.getY();

        assertEquals(expectedX, resultX);
        assertEquals(expectedY, resultY);
    }
}
