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

    private final Shape shape = shapeFactory.createShape(ShapeFactory.L_SHAPE);

    @Test(expected = IllegalStateException.class)
    public void requireResultWithNullParameter() {
        shapeFactory.createShape(null);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultWithIncorrectParameter() {
        shapeFactory.createShape("Lshape");
    }

    @Test
    public void requireResultWithLShape() {
        assertNotNull(shape);
    }
}
