package homework4.task24.base;

import homework4.task24.CreditCart;
import homework4.task24.ValidationFactory;
import org.apache.log4j.Logger;
import org.joda.money.Money;

import java.math.RoundingMode;

/**
 * Created by koval on 24.11.2016.
 */
public class WithdrawMoney extends AbstractOperation {

    private static final Logger LOG = Logger.getLogger(WithdrawMoney.class);

    private static final String WITHDRAWN_MONEY = "We have withdrawn money";

    public WithdrawMoney(AbstractOperation nextOperation) {
        super(nextOperation);
    }

    @Override
    public void doOperation(final CreditCart creditCart, final Money money) {

        getValidationFactory().validateNull(money);

        final Money percent = money.dividedBy(10, RoundingMode.FLOOR);
        final Money priceWithPercent = money.plus(percent);

        getValidationFactory().validate(money.minus(priceWithPercent));

        creditCart.withdrawMoney(priceWithPercent);

        LOG.debug(WITHDRAWN_MONEY);
    }
}
