package homework4.task23;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Created by koval on 02.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestOrder {

    @Spy
    private final Order order = new Order();

    @Mock
    private GrantOrder grantOrder;

    @Test
    public void requireResultWithChangeState() {

        final Order order = new Order();

        order.changeState(new WithdrawnGrantOrder(order));

        final GrantOrder.State expected = GrantOrder.State.WITHDRAWN;
        final GrantOrder.State result = order.getCurrentState().getState();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultVerifyGrantOrderWithChangeState() {
        order.setCurrentState(grantOrder);
        order.changeState(grantOrder);
        verify(order).setCurrentState(grantOrder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireResultWithIllegalChangeState() {

        final GrantOrder currentState = new DeclinedGrantOrder(order);
        order.setCurrentState(currentState);

        order.changeState(new CreatedGrantOrder(order));
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireResultWithRepeatState() {

        final GrantOrder currentState = new DeclinedGrantOrder(order);
        order.setCurrentState(currentState);

        order.changeState(currentState);
    }
}
