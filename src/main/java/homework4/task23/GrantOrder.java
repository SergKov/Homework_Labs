package homework4.task23;

/**
 * Created by Sergey on 19.11.2016.
 *
 * State
 */
public abstract class GrantOrder {

    public static final String CHANGED_TO = "%s changed to %s";

    protected Order order;

    public GrantOrder(Order order) {
        this.order = order;
    }

    enum State {
        CREATED, PROCESSED, POSTPONED, DECLINED, CONFIRMED, WITHDRAWN;
    }

    public abstract void changeState(GrantOrder to);

    public abstract State getState();
}