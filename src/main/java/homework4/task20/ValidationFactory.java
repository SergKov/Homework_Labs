package homework4.task20;

import static homework4.task20.ShapeFactory.ALL_FIGURES;

/**
 * Created by koval on 23.11.2016.
 */
public class ValidationFactory {

    private static final ValidationFactory instance = new ValidationFactory();

    public static ValidationFactory getInstance() {
        return instance;
    }

    private static final String SHAPE_NULL = "Shape can not be null";

    public void validateNull(final Figure name) {
        if (name == null) {
            throw new IllegalStateException(SHAPE_NULL);
        }
    }
}
