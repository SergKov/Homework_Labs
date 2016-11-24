package homework4.task24;

import homework4.task24.base.CheckBalance;
import homework4.task24.base.WithdrawMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by koval on 25.11.2016.
 */
public class ChainOfResponsibilityTest {

    private CreditCart creditCart = CreditCartFactory.createCreditCart(Money.of(CurrencyUnit.USD, 100));

    @Test
    public void requireResultWithCreditCard() {

        final WithdrawMoney withdrawMoney = new WithdrawMoney(null);
        final CheckBalance checkBalance = new CheckBalance(withdrawMoney);

        withdrawMoney.doOperation(creditCart, Money.of(CurrencyUnit.USD, 10));

        assertEquals(creditCart.getBalance(), Money.of(CurrencyUnit.USD, 89));
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireResultWithOverflow() {

        final WithdrawMoney withdrawMoney = new WithdrawMoney(null);
        final CheckBalance checkBalance = new CheckBalance(withdrawMoney);

        withdrawMoney.doOperation(creditCart, Money.of(CurrencyUnit.USD, 200));
    }

}
