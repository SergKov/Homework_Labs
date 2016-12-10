package homework4.task23;

/**
 * Created by Sergey on 19.11.2016.
 * <p>
 * State
 */

public abstract class GrantOrder {

    public static final String CHANGED_TO = "%s can not changed to %s";
    public static final String STATE_CHANGED = "%s %s";

    protected Order order;

    public enum State {
        CREATED, PROCESSED, POSTPONED, DECLINED, CONFIRMED, WITHDRAWN;
    }

    public GrantOrder(Order order) {
        this.order = order;
    }

    public abstract void create();

    public abstract void process();

    public abstract void postpone();

    public abstract void decline();

    public abstract void confirm();

    public abstract void withdraw();

    public abstract State getState();
}
