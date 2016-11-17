package homework2.task5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by koval on 11.11.2016.
 */
public class Payment {
    private final Purchase purchase;
    private final double price;

    private Payment(Purchase purchase, double price) {
        this.purchase = purchase;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public static class Purchase {
        private List<Goods> cart;
        private double price;

        public Purchase() {
            cart = new ArrayList<>();
        }

        public Purchase(List<Goods> goods) {
            cart = goods;
            cart.forEach(good -> price += good.getPrice());
        }

        public void addGood(final Goods good) {
            cart.add(good);
            price += good.getPrice();
        }

        public void removeGood(final Goods good) {
            if (cart.contains(good)) {
                cart.remove(good);
                price -= good.getPrice();
            }
        }

        public void addAllGoods(final Collection<Goods> goods) {
            cart.addAll(goods);
            goods.forEach(good -> price += good.getPrice());
        }

        public Payment builtPayment() {
            return new Payment(this, price);
        }
    }

    public enum Goods {
        MEAT(100), MILK(10), ICE_CREAM(8), BEAR(15), FISH(60), WATER(5);

        private final double price;

        Goods(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }
}
