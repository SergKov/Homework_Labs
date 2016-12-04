package homework4.task23;

import org.apache.log4j.Logger;

/**
 * Created by koval on 19.11.2016.
 */
public class CreatedGrantOrder extends GrantOrder {

    private static final Logger LOG = Logger.getLogger(CreatedGrantOrder.class);

    public CreatedGrantOrder(Order order) {
        super(order);
        LOG.debug(order.getClass().getSimpleName() + State.CREATED);
    }

    @Override
    public void changeState(GrantOrder to) {
        ValidationFactory.getInstance().validate(to, State.CREATED);
        order.setCurrentState(to);
        LOG.debug(String.format(CHANGED_TO, this.getState(), to.getState()));
    }

    @Override
    public State getState() {
        return State.CREATED;
    }
}
