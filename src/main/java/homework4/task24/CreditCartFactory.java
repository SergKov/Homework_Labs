package homework4.task24;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

/**
 * Created by koval on 24.11.2016.
 */
public class CreditCartFactory {

    private static final CreditCartFactory instance = new CreditCartFactory();

    public static CreditCartFactory getInstance() {
        return instance;
    }

    public static CreditCart createCreditCart() {
        return new CreditCart(Money.zero(CurrencyUnit.USD));
    }

    public static CreditCart createCreditCart(final Money money) {
        ValidationFactory.getInstance().validateNull(money);
        ValidationFactory.getInstance().validate(money);
        return new CreditCart(money);
    }
}
