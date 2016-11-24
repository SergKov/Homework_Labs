package homework4.task20;

/**
 * Created by koval on 23.11.2016.
 */
public class ValidationFactory {

    private static final ValidationFactory instance = new ValidationFactory();

    public static ValidationFactory getInstance() {
        return instance;
    }

    private static final String NEGATIVE_PARAMETERS = "Coordinates of a shape must be positive";
    private static final String ZERO_PARAMETERS = "Both coordinates of a shape can not be 0";
    private static final String TOO_BIG_PARAMETERS = "Coordinates of the shape are too big";

    public void validatePositive(final int x, final int y) {
        if (x < 0 || y < 0) {
            throw new IllegalStateException(NEGATIVE_PARAMETERS);
        }
    }

    public void validateNotZero(final int x, final int y) {
        if (x == 0 && y == 0) {
            throw new IllegalStateException(ZERO_PARAMETERS);
        }
    }

    public void validateBigParameters(final int x, final int y) {
        if (x > 5 || y > 4) {
            throw new IllegalStateException(TOO_BIG_PARAMETERS);
        }
    }
}
