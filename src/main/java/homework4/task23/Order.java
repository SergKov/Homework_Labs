package homework4.task23;

/**
 * Created by koval on 19.11.2016.
 *
 * State
 */
public class Order implements GrantOrder {

    private GrantOrder state;

    @Override
    public void create() {
        state.create();
    }

    @Override
    public void process() {
        state.process();
    }

    @Override
    public void postpone() {
        state.postpone();
    }

    @Override
    public void decline() {
        state.decline();
    }

    @Override
    public void confirm() {
        state.confirm();
    }

    @Override
    public void withdraw() {
        state.withdraw();
    }

    @Override
    public void getState() {
        state.getState();
    }
}
