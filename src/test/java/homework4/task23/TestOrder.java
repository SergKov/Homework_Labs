package homework4.task23;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

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

    @Test(expected = UnsupportedOperationException.class)
    public void requireResultWithCreate() {
        spyOrder.create();
    }

    @Test
    public void requireResultVerifyGrantOrderWithChangeState() {
        spyOrder.setState(grantOrder);
        spyOrder.process();
        verify(spyOrder).process();
    }

    @Test
    public void requireResultWithChangeStates() {
        order.process();
        order.postpone();
        order.confirm();
        order.withdraw();
    }

    @Test
    public void requireResultChangeStatesWithVerify() {

        spyOrder.setState(grantOrder);

        spyOrder.process();
        spyOrder.postpone();
        spyOrder.confirm();
        spyOrder.withdraw();

        verify(spyOrder, times(1)).process();
        verify(spyOrder, times(1)).postpone();
        verify(spyOrder, times(1)).confirm();
        verify(spyOrder, times(1)).withdraw();

        verify(spyOrder, never()).decline();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void requireResultWithDeclineWithdrawState() {
        order.decline();
        order.withdraw();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void requireResultWithConfirmPostponeState() {
        order.confirm();
        order.postpone();
    }
}
