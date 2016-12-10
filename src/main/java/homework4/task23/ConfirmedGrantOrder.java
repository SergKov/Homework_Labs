package homework4.task23;

import org.apache.log4j.Logger;

/**
 * Created by koval on 19.11.2016.
 */
public class ConfirmedGrantOrder extends GrantOrder {

    private static final Logger LOG = Logger.getLogger(ConfirmedGrantOrder.class);

    public ConfirmedGrantOrder(Order order) {
        super(order);
    }

    @Override
    public void create() {
        final String ILLEGAL_STATE = String.format(CHANGED_TO, this.getState(), State.CREATED);
        LOG.warn(ILLEGAL_STATE);
        throw new UnsupportedOperationException(ILLEGAL_STATE);
    }

    @Override
    public void process() {
        final String ILLEGAL_STATE = String.format(CHANGED_TO, this.getState(), State.PROCESSED);
        LOG.warn(ILLEGAL_STATE);
        throw new UnsupportedOperationException(ILLEGAL_STATE);
    }

    @Override
    public void postpone() {
        final String ILLEGAL_STATE = String.format(CHANGED_TO, this.getState(), State.POSTPONED);
        LOG.warn(ILLEGAL_STATE);
        throw new UnsupportedOperationException(ILLEGAL_STATE);
    }

    @Override
    public void decline() {
        final String ILLEGAL_STATE = String.format(CHANGED_TO, this.getState(), State.DECLINED);
        LOG.warn(ILLEGAL_STATE);
        throw new UnsupportedOperationException(ILLEGAL_STATE);
    }

    @Override
    public void confirm() {
        final String ILLEGAL_STATE = String.format(CHANGED_TO, this.getState(), State.CONFIRMED);
        LOG.warn(ILLEGAL_STATE);
        throw new UnsupportedOperationException(ILLEGAL_STATE);
    }

    @Override
    public void withdraw() {
        final WithdrawnGrantOrder withdrawnGrantOrder = new WithdrawnGrantOrder(order);
        order.setState(withdrawnGrantOrder);
        LOG.debug(String.format(STATE_CHANGED, this.getClass().getSimpleName() , State.WITHDRAWN));
    }

    @Override
    public State getState() {
        return State.CONFIRMED;
    }
}
