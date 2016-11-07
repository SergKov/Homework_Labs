package homework2.task1;

import static java.lang.Math.*;

/**
 * Created by koval on 06.11.2016.
 */
public class Circle extends Shape {

    private static final double MAX_VALUE = Double.MAX_VALUE / PI;

    private double radius;

    public Circle() { }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        validate(radius);
        return PI * radius * radius;
    }

    private void validate(final double radius) {
        if (radius < 0) {
            throw new IllegalStateException("Radius can not be less 0");
        }

        if ((MAX_VALUE - radius) < DELTA) {
            throw new UnsupportedOperationException("This number is very big");
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
