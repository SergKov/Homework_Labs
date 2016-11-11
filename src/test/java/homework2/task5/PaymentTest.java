package homework2.task5;

import org.junit.Test;

import java.util.ArrayList;

import static homework2.task5.Payment.Goods.*;
import static org.junit.Assert.*;

/**
 * Created by koval on 11.11.2016.
 */
public class PaymentTest {

    private static final double DELTA = .05;

    private Payment.Purchase goods = new Payment.Purchase();

    @Test
    public void requireResultWithEmptyCart() {
        final Payment payment = goods.builtPayment();

        final double expected = 0;
        final double result = payment.getPrice();
        assertEquals(expected, result, DELTA);
    }

    @Test
    public void requireResultWithAddGoods() {
        goods.addGood(MILK);
        goods.addGood(ICE_CREAM);
        final Payment payment = goods.builtPayment();

        final double expected = 18;
        final double result = payment.getPrice();
        assertEquals(expected, result, DELTA);
    }

    @Test
    public void requireResultWithAddCollectionGoods() {
        goods.addGood(MILK);
        goods.addAllGoods(new ArrayList<Payment.Goods>() {{
            add(MILK);
            add(MEAT);
            add(WATER);
        }});
        final Payment payment = goods.builtPayment();

        final double expected = 125;
        final double result = payment.getPrice();
        assertEquals(expected, result, DELTA);
    }

    @Test
    public void requireResultWithRemoveGoods() {
        goods.addGood(BEAR);
        goods.addGood(WATER);
        goods.addGood(FISH);

        goods.removeGood(WATER);
        final Payment payment = goods.builtPayment();

        final double expected = 75;
        final double result = payment.getPrice();
        assertEquals(expected, result, DELTA);
    }
}
