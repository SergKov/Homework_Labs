package homework4.task18.factory;

import org.apache.log4j.Logger;

/**
 * Created by koval on 20.11.2016.
 */
public class ValidationFactory {

    private static final Logger LOG = Logger.getLogger(ValidationFactory.class);

    private static final String LANGUAGE_NULL = "Language can not be null";

    public static final ValidationFactory VALIDATION_FACTORY = new ValidationFactory();

    private ValidationFactory() { }

    public void validate(final Language language) {
        if (language == null) {
            LOG.warn(LANGUAGE_NULL);
            throw new IllegalArgumentException(LANGUAGE_NULL);
        }
    }
}
