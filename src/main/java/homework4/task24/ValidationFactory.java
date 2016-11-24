package homework4.task24;

import org.apache.log4j.Logger;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

/**
 * Created by koval on 24.11.2016.
 */
public class ValidationFactory {

    private static final Logger LOG = Logger.getLogger(ValidationFactory.class);

    private static final ValidationFactory instance = new ValidationFactory();

    public static ValidationFactory getInstance() {
        return instance;
    }

    private static final String BALANCE_NULL = "Balance can not be a null";
    private static final String BALANCE_INCORRECT = String.format("Balance can not be less than 0 %s", CurrencyUnit.USD);

    public void validateNull(final Money money) {
        if (money == null) {
            LOG.warn(BALANCE_NULL);
            throw new IllegalStateException(BALANCE_NULL);
        }
    }

    public void validate(final Money money) {
        if (money.isNegative()) {
            LOG.warn(BALANCE_INCORRECT);
            throw new IllegalArgumentException(BALANCE_INCORRECT);
        }
    }
}
