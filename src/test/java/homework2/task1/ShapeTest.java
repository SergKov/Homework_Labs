package homework2.task1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;

/**
 * Created by koval on 07.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ShapeTest {

    public static final double DELTA = .05;

    @Mock
    private Circle circle;

    @Mock
    private Trapezium trapezium;

    @Mock
    private Triangle triangle;

    @Mock
    private Parallelogram parallelogram;

    private Collection<Shape> shapes;

    @Test
    public void requireSumSquare() {
        when(circle.getSquare()).thenReturn(5d);
        when(trapezium.getSquare()).thenReturn(46.25);
        when(triangle.getSquare()).thenReturn(24.8);
        when(parallelogram.getSquare()).thenReturn(678.67);
        shapes = Arrays.asList(circle, trapezium, triangle, parallelogram);
        final BigDecimal expected = new BigDecimal("754.72");
        final BigDecimal result = Shape.getSumSquares(shapes);
        Assert.assertEquals(expected, result);
    }
}
