package homework4.task24;

import org.joda.money.Money;

/**
 * Created by koval on 24.11.2016.
 */
public class CreditCart {

    private Money balance;

    CreditCart(Money balance) {
        this.balance = balance;
    }

    public Money getBalance() {
        return balance;
    }

    public void withdrawMoney(final Money money) {
        balance = balance.minus(money);
    }
}
