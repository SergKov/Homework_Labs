package homework2.task1;

import static java.lang.Math.sqrt;

/**
 * Created by koval on 06.11.2016.
 */
public class Parallelogram extends Shape {

    private static final double MAX_VALUE = sqrt(Double.MAX_VALUE);

    private double base;
    private double side;

    public Parallelogram() { }

    public Parallelogram(double base, double side) {
        this.base = base;
        this.side = side;
    }

    public double getSquare() {
        validate(base, side);
        return base * side;
    }

    private void validate(final double base, final double side) {
        if (base <= 0 || side <= 0) {
            throw new IllegalStateException("Values must be > 0");
        }

        if (MAX_VALUE - base < DELTA || MAX_VALUE - side < DELTA) {
            throw new UnsupportedOperationException("One of the values are very big");
        }
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
