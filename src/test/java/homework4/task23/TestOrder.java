package homework4.task23;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

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

        order.confirm();

        final GrantOrder.State expected = GrantOrder.State.CONFIRMED;
        final GrantOrder.State result = order.getState();

        assertEquals(expected, result);
    }

//    @Test // ???
//    public void requireResultVerifyGrantOrderWithChangeState() {
//        order.create();
//        when(order.getGrantOrder()).thenReturn(grantOrder);
//        verify(grantOrder).create();
//    }
}
