package homework4.task23;

import org.apache.log4j.Logger;

/**
 * Created by koval on 19.11.2016.
 */
public class PostponedGrantOrder extends GrantOrder {

    private static final Logger LOG = Logger.getLogger(PostponedGrantOrder.class);

    public PostponedGrantOrder(Order order) {
        super(order);
        LOG.debug(order.getClass().getSimpleName() + State.POSTPONED);
    }

    @Override
    public void changeState(GrantOrder to) {
        ValidationFactory.getInstance().validate(to, State.CREATED, State.PROCESSED, State.POSTPONED);
        LOG.debug(String.format(CHANGED_TO, this.getState(), to.getState()));
        order.setCurrentState(to);
    }

    @Override
    public State getState() {
        return State.POSTPONED;
    }
}
