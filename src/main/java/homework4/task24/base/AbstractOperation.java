package homework4.task24.base;

import homework4.task24.CreditCart;
import homework4.task24.ValidationFactory;
import org.joda.money.Money;

/**
 * Created by koval on 24.11.2016.
 */
public abstract class AbstractOperation {

    private ValidationFactory validationFactory = ValidationFactory.getInstance();

    private final AbstractOperation nextOperation;

    public AbstractOperation(AbstractOperation nextOperation) {
        this.nextOperation = nextOperation;
    }

    public abstract void doOperation(CreditCart creditCart, Money money);

    public AbstractOperation getNextOperation() {
        return nextOperation;
    }

    public ValidationFactory getValidationFactory() {
        return validationFactory;
    }
}
