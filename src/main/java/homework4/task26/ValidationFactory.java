package homework4.task26;

/**
 * Created by koval on 24.11.2016.
 */
public class ValidationFactory {

    private static final ValidationFactory instance = new ValidationFactory();

    public static ValidationFactory getInstance() {
        return instance;
    }

    private static final String NULL_VALUE = "Colony can not be null";

    public void validate(final Bacteria bacteria) {
        if (bacteria == null) {
            throw new IllegalArgumentException(NULL_VALUE);
        }
    }
}
