package homework4.task20;

import static homework4.task20.ShapeFactory.allNames;

/**
 * Created by koval on 23.11.2016.
 */
public class ValidationFactory {

    private static final ValidationFactory instance = new ValidationFactory();

    public static ValidationFactory getInstance() {
        return instance;
    }

    private static final String SHAPE_NULL = "Shape can not be null";
    private static final String SHAPE_NOT_EXISTS = "This shape does not exist";

    public void validateNull(final String name) {
        if (name == null) {
            throw new IllegalStateException(SHAPE_NULL);
        }
    }

    public void validate(final String name) {
        if (!allNames.contains(name)) {
            throw new IllegalStateException(SHAPE_NOT_EXISTS);
        }
    }
}
