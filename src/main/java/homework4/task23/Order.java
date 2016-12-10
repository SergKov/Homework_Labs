package homework4.task23;

/**
 * Created by Sergey on 19.11.2016.
 */
public class Order {

    private GrantOrder state;

    public Order() {
        this.state = new CreatedGrantOrder(this);
    }

    public void create() {
        state.create();
    }

    public void process() {
        state.process();
    }

    public void postpone() {
        state.postpone();
    }

    public void decline() {
        state.decline();
    }

    public void confirm() {
        state.confirm();
    }

    public void withdraw() {
        state.withdraw();
    }

    public GrantOrder.State getState() {
        return state.getState();
    }

    public void setState(GrantOrder grantOrder) {
        this.state = grantOrder;
    }
}
