package homework4.task23;

import org.apache.log4j.Logger;

/**
 * Created by koval on 19.11.2016.
 */
public class DeclinedGrantOrder extends GrantOrder {

    private static final Logger LOG = Logger.getLogger(DeclinedGrantOrder.class);

    public DeclinedGrantOrder(Order order) {
        super(order);
        LOG.debug(order.getClass().getSimpleName() + State.DECLINED);
    }

    @Override
    public void changeState(GrantOrder to) {
        ValidationFactory.getInstance().validate(to, State.values());
        LOG.debug(String.format(CHANGED_TO, this.getState(), to.getState()));
        order.setCurrentState(to);
    }

    @Override
    public State getState() {
        return State.DECLINED;
    }


}
