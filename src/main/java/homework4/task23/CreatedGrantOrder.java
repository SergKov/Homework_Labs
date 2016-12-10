package homework4.task23;

import org.apache.log4j.Logger;

/**
 * Created by koval on 19.11.2016.
 */
public class CreatedGrantOrder extends GrantOrder {

    private static final Logger LOG = Logger.getLogger(CreatedGrantOrder.class);

    public CreatedGrantOrder(Order order) {
        super(order);
        LOG.debug(String.format(STATE_CHANGED, this.getClass().getSimpleName(), State.CREATED));
    }

    @Override
    public void create() {
        final String ILLEGAL_STATE = String.format(CHANGED_TO, this.getState(), State.CREATED);
        LOG.warn(ILLEGAL_STATE);
        throw new UnsupportedOperationException(ILLEGAL_STATE);
    }

    @Override
    public void process() {
        final ProcessedGrantOrder processedGrantOrder = new ProcessedGrantOrder(order);
        order.setState(processedGrantOrder);
        LOG.debug(String.format(STATE_CHANGED, this.getClass().getSimpleName(), State.PROCESSED));
    }

    @Override
    public void postpone() {
        final PostponedGrantOrder postponedGrantOrder = new PostponedGrantOrder(order);
        order.setState(postponedGrantOrder);
        LOG.debug(String.format(STATE_CHANGED, this.getClass().getSimpleName(), State.POSTPONED));
    }

    @Override
    public void decline() {
        final DeclinedGrantOrder declinedGrantOrder = new DeclinedGrantOrder(order);
        order.setState(declinedGrantOrder);
        LOG.debug(String.format(STATE_CHANGED, this.getClass().getSimpleName() , State.DECLINED));
    }

    @Override
    public void confirm() {
        final ConfirmedGrantOrder confirmedGrantOrder = new ConfirmedGrantOrder(order);
        order.setState(confirmedGrantOrder);
        LOG.debug(String.format(STATE_CHANGED, this.getClass().getSimpleName() , State.CONFIRMED));
    }

    @Override
    public void withdraw() {
        final String ILLEGAL_STATE = String.format(CHANGED_TO, this.getState(), State.WITHDRAWN);
        LOG.warn(ILLEGAL_STATE);
        throw new UnsupportedOperationException(ILLEGAL_STATE);
    }


    @Override
    public State getState() {
        return State.CREATED;
    }
}
