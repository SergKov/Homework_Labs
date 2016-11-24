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
    private static final String ILLEGAL_BACTERIAS_NUMBERS = "Colony can not have less than 2 bacterias";

    public void validateNull(final Bacteria... bacterias) {
        if (bacterias == null) {
            throw new IllegalStateException(NULL_VALUE);
        }
    }

    public void validate(final Bacteria... bacterias) {
        if (bacterias.length < 2) {
            throw new IllegalArgumentException(ILLEGAL_BACTERIAS_NUMBERS);
        }
    }
}
