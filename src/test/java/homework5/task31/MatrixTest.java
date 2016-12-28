package homework5.task31;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by koval on 27.12.2016.
 */
public class MatrixTest {

    @Test
    public void requireResultWithTwoToTwoMatrices() throws InterruptedException {

        final MultiplyMatrix matrix = new MultiplyMatrix(2, new double[][]{{1, 1}, {1, 1}},
                new double[][] {{1, 1}, {1, 1}});

        final double[][] expected = {{2, 2}, {2, 2}};
        final double[][] result = matrix.getResult();

        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void requireResultWithThreeToThreeMatrices() throws InterruptedException {

        final MultiplyMatrix matrix = new MultiplyMatrix(3, new double[][]{{1, 2, 3}, {3, 2, 1}, {0, 1, 2}},
                new double[][] {{0, 1, 2}, {1, 0, 5}, {3, 7, 2}});

        final double[][] expected = {{11, 22, 18}, {5, 10, 18}, {7, 14, 9}};
        final double[][] result = matrix.getResult();

        Assert.assertArrayEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireExceptionWithIllegalParameters() {

        final MultiplyMatrix matrix = new MultiplyMatrix(3, new double[][]{{1, 1}, {1, 1}},
                new double[][] {{1, 1}, {1, 1}, {1, 1}});
    }
}
