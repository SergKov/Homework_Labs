package homework4.task23;

import org.apache.log4j.Logger;

/**
 * Created by koval on 19.11.2016.
 */
public class ProcessedGrantOrder extends GrantOrder {

    private static final Logger LOG = Logger.getLogger(ProcessedGrantOrder.class);

    public ProcessedGrantOrder(Order order) {
        super(order);
        LOG.debug(order.getClass().getSimpleName() + State.PROCESSED);
    }

    @Override
    public void changeState(GrantOrder to) {
        ValidationFactory.getInstance().validate(to, State.CREATED, State.PROCESSED);
        LOG.debug(String.format(CHANGED_TO, this.getState(), to.getState()));
        order.setCurrentState(to);
    }

    @Override
    public State getState() {
        return State.PROCESSED;
    }
}
