package homework4.task23;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by koval on 02.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestOrder {

    private Order order;

    private Order spyOrder;

    @Mock
    private GrantOrder grantOrder;

    @Before
    public void setUp() {
        order = new Order();
        spyOrder = spy(order);
    }

    @Test
    public void requireResultWithChangeState() {

        order.changeState(new WithdrawnGrantOrder(order));

        final GrantOrder.State expected = GrantOrder.State.WITHDRAWN;
        final GrantOrder.State result = order.getCurrentState().getState();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultVerifyGrantOrderWithChangeState() {
        spyOrder.setCurrentState(grantOrder);
        spyOrder.changeState(grantOrder);
        verify(spyOrder).setCurrentState(grantOrder);
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
