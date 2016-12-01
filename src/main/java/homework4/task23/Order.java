package homework4.task23;

/**
 * Created by Sergey on 19.11.2016.
 */
public class Order implements GrantOrder {

    private GrantOrder state;

    @Override
    public void create() {
        state = new CreatedGrantOrder();
        state.create();
    }

    @Override
    public void process() {
        state = new ProcessedGrantOrder();
        state.process();
    }

    @Override
    public void postpone() {
        state = new PostponedGrantOrder();
        state.postpone();
    }

    @Override
    public void decline() {
        state = new DeclinedGrantOrder();
        state.decline();
    }

    @Override
    public void confirm() {
        state = new ConfirmedGrantOrder();
        state.confirm();
    }

    @Override
    public void withdraw() {
        state = new WithdrawnGrantOrder();
        state.withdraw();
    }

    @Override
    public State getState() {
        return state.getState();
    }
}
