package homework2.task1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
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
    private Triangle triangle1;
    
    @Mock
    private Triangle triangle2;

    @Mock
    private Parallelogram parallelogram;

    private Collection<Shape> shapes;

    @Test
    public void requireSumSquare() {
        when(circle.getSquare()).thenReturn(5d);
        when(trapezium.getSquare()).thenReturn(46.25);
        when(triangle1.getSquare()).thenReturn(24.8);
        when(triangle2.getSquare()).thenReturn(11.1);
        when(parallelogram.getSquare()).thenReturn(678.67);
        shapes = Arrays.asList(circle, trapezium, triangle1, triangle2, parallelogram);
        final BigDecimal expected = new BigDecimal("765.82");
        final BigDecimal result = Shape.getSumSquares(shapes);
        assertEquals(expected, result);
    }
}
