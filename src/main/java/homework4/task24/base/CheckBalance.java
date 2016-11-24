package homework4.task24.base;

import homework4.task24.ValidationFactory;
import homework4.task24.CreditCart;
import org.apache.log4j.Logger;
import org.joda.money.Money;

import java.math.RoundingMode;

/**
 * Created by koval on 24.11.2016.
 */
public class CheckBalance extends AbstractOperation {

    private static final Logger LOG = Logger.getLogger(CheckBalance.class);

    private static final String CHECKED_BALANCE = "Current ballance was chacked successfully";
    private static final String NOT_ENOUGH = "Current ballance does not have enough money";

    public CheckBalance(AbstractOperation nextOperation) {
        super(nextOperation);
    }

    @Override
    public void doOperation(final CreditCart creditCart, final Money money) {
        getValidationFactory().validateNull(money);
        final Money percent = money.dividedBy(10, RoundingMode.FLOOR);
        final Money priceWithPercent = money.plus(percent);
        final Money expectedBalance = creditCart.getBalance().minus(priceWithPercent);
        if (expectedBalance.isPositive()) {
            LOG.debug(CHECKED_BALANCE);
            if (getNextOperation() != null) {
                getNextOperation().doOperation(creditCart, priceWithPercent);
            }
        } else {
            LOG.warn(NOT_ENOUGH);
        }
    }

    private boolean isAppropriateBalance(final Money balance) {
        return balance.isPositive();
    }
}
