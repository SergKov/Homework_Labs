package homework4.task17;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by koval on 18.12.2016.
 */
@RunWith(Parameterized.class)
public class PolishTest {

    public static final double DELTA = .05;

    @Parameterized.Parameter(value = 0)
    public String expression;

    @Parameterized.Parameter(value = 1)
    public Double expected;

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"2 * ( 3 + 4 ) ", 14.0},
                {"( 5 + 4 ) * 2", 18.0},
                {"5 + 4  + 5 + 4  * 2 ", 22.0},
                {"5 + 4  + ( 5 + 4 )  * 2 ", 27.0},
                {"( 6 - 7 ) / 4 + ( 2 - 3 ) * 5", 1.0},
                {"( 6 - 7 ) / ( 8 - 4 ) + ( 2 - 3 ) * 5", 1.0}
        });
    }

    @Test
    public void requireResult() {
        assertEquals(expected, ReversePolishNotation.getResult(expression), DELTA);
    }

}
