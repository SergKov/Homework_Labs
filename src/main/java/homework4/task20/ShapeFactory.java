package homework4.task20;

/**
 * Created by koval on 23.11.2016.
 */
public class ShapeFactory {

    private static final ShapeFactory instance = new ShapeFactory();

    public ShapeFactory getInstance() {
        return instance;
    }

    private ShapeFactory() { }

    public Shape createShape(final int x, final int y) {
        ValidationFactory.getInstance().validatePositive(x, y);
        ValidationFactory.getInstance().validateNotZero(x, y);
        ValidationFactory.getInstance().validateBigParameters(x, y);
        return new Shape(x, y);
    }
}
