package homework2.task1;

import static java.lang.Math.*;

/**
 * Created by koval on 05.11.2016.
 */
public class Triangle extends Shape {

    private static final double MAX_VALUE = sqrt(Double.MAX_VALUE);

    private double base;
    private double height;

    public Triangle() { }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getSquare() {
        validate(base, height);
        return base * height * .5;
    }

    private void validate(final double base, final double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalStateException("Values must be > 0");
        }

        if (MAX_VALUE - base <  DELTA || MAX_VALUE - height < DELTA) {
            throw new UnsupportedOperationException("One of the values are very big");
        }
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
