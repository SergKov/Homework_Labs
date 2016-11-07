package homework2.task1;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by koval on 05.11.2016.
 */
public abstract class Shape {

    public static final double DELTA = .05;

    public abstract double getSquare();

    public static BigDecimal getSumSquares(final Collection<Shape> shapes) {
        BigDecimal sum = new BigDecimal("0");

        for (Shape shape : shapes) {
            final BigDecimal shapeSquare = new BigDecimal("" + shape.getSquare());
            sum = sum.add(shapeSquare);
        }

        return sum;
    }

}
