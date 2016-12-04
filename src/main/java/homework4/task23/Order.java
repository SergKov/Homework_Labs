package homework4.task23;

/**
 * Created by Sergey on 19.11.2016.
 */
public class Order {

    private GrantOrder currentState;

    public Order() {
        currentState = new CreatedGrantOrder(this);
    }

    public GrantOrder getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GrantOrder currentState) {
        this.currentState = currentState;
    }

    public void changeState(GrantOrder grantOrder) {
        currentState.changeState(grantOrder);
    }
}
