package homework4.task23;

import org.apache.log4j.Logger;

/**
 * Created by koval on 19.11.2016.
 */
public class ProcessedGrantOrder implements GrantOrder {

    private static final Logger LOG = Logger.getLogger(ProcessedGrantOrder.class);

    @Override
    public void create() {
        LOG.debug(this.getClass().getSimpleName() + CREATED);
    }

    @Override
    public void process() {
        LOG.debug(this.getClass().getSimpleName() + PROCESSED);
    }

    @Override
    public void postpone() {
        LOG.debug(this.getClass().getSimpleName() + POSTPONED);
    }

    @Override
    public void decline() {
        LOG.debug(this.getClass().getSimpleName() + DECLINED);
    }

    @Override
    public void confirm() {
        LOG.debug(this.getClass().getSimpleName() + CONFIRMED);
    }

    @Override
    public void withdraw() {
        LOG.debug(this.getClass().getSimpleName() + WITHDRAWN);
    }

    @Override
    public State getState() {
        return State.PROCESSED;
    }
}
