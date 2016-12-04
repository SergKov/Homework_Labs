package homework4.task17;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by koval on 04.12.2016.
 */
public class EvaluateTest {

    private static final double DELTA = .05;
    private static final String EXPRESSION = "(1+2)+4";

    private final Evaluate evaluate = new Evaluate();

    @Test
    public void requireResult() {
        double expected = 7;
        double result = evaluate.evaluate(EXPRESSION);

        Assert.assertEquals(expected, result, DELTA);
    }
}
