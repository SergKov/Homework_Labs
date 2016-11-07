package homework2.task1;

import static java.lang.Math.*;

/**
 * Created by koval on 06.11.2016.
 */
public class Trapezium extends Shape {

    private static final double MAX_VALUE = sqrt(Double.MAX_VALUE);

    private double base;
    private double oppositeBase;
    private double height;

    public Trapezium() { }

    public Trapezium(double base, double oppositeBase, double height) {
        this.base = base;
        this.oppositeBase = oppositeBase;
        this.height = height;
    }

    @Override
    public double getSquare() {
        validate(base, oppositeBase, height);
        return (base + oppositeBase) * .5 * height;
    }

    private void validate(final double base, final double oppositeBase, final double height) {
        if (base <= 0 || oppositeBase <= 0 || height <= 0) {
            throw new IllegalStateException("Values must be > 0");
        }

        if (MAX_VALUE - base <  DELTA || MAX_VALUE - oppositeBase < DELTA || MAX_VALUE - height < DELTA) {
            throw new UnsupportedOperationException("One of the values are very big");
        }
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getOppositeBase() {
        return oppositeBase;
    }

    public void setOppositeBase(double oppositeBase) {
        this.oppositeBase = oppositeBase;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
