package homework4.task20;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.Assert.assertNotNull;

/**
 * Created by koval on 24.11.2016.
 */
public class ShapeFactoryTest {

    private final ShapeFactory shapeFactory = ShapeFactory.getInstance();

    @Test(expected = IllegalStateException.class)
    public void requireResultWithNullParameter() {
        shapeFactory.createShape(null);
    }

    @Test
    public void requireResultWithLShape() {
        final Shape shape = shapeFactory.createShape(Figure.L_SHAPE);
        assertNotNull(shape);
    }
}
