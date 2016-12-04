package homework4.task23;

import org.apache.log4j.Logger;

/**
 * Created by koval on 19.11.2016.
 */
public class ConfirmedGrantOrder extends GrantOrder {

    private static final Logger LOG = Logger.getLogger(ConfirmedGrantOrder.class);

    public ConfirmedGrantOrder(Order order) {
        super(order);
        LOG.debug(order.getClass().getSimpleName() + State.WITHDRAWN);
    }

    @Override
    public void changeState(GrantOrder to) {
        ValidationFactory.getInstance().validate(to, State.CREATED, State.PROCESSED, State.POSTPONED, State.CONFIRMED);
        LOG.debug(String.format(CHANGED_TO, this.getState(), to.getState()));
        order.setCurrentState(to);
    }

    @Override
    public State getState() {
        return State.CONFIRMED;
    }
}
