package homework4.task23;

import org.apache.log4j.Logger;

/**
 * Created by Sergey on 19.11.2016.
 */
public class WithdrawnGrantOrder extends GrantOrder {

    private static final Logger LOG = Logger.getLogger(WithdrawnGrantOrder.class);

    public WithdrawnGrantOrder(Order order) {
        super(order);
        LOG.debug(order.getClass().getSimpleName() + State.WITHDRAWN);
    }

    @Override
    public void changeState(GrantOrder to) {
        ValidationFactory.getInstance().validate(to, State.values());
        LOG.debug(String.format(CHANGED_TO, this.getState(), to.getState()));
        order.setCurrentState(to);
    }

    @Override
    public State getState() {
        return State.WITHDRAWN;
    }
}
