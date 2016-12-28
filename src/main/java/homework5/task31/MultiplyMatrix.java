package homework5.task31;

import java.util.stream.IntStream;

/**
 * Created by koval on 27.12.2016.
 */
public class MultiplyMatrix {

    public static final String ILLEGAL_PARAMETERS =
            "We can't multiple matrix A with count columns = %d and B with count rows = %d";
    public static final String ILLEGAL_THREADS_COUNT = "Thread's count can not be less than 1";

    private final int threadsCount;
    private final double first[][];
    private final double second[][];


    public MultiplyMatrix(int threadsCount, double[][] first, double[][] second) {

        if (first[0].length != second.length) {
            throw new IllegalArgumentException(String.format(ILLEGAL_PARAMETERS, first[0].length, second.length));
        }

        if (threadsCount < 1) {
            throw new IllegalArgumentException(ILLEGAL_THREADS_COUNT);
        }

        this.threadsCount = threadsCount;
        this.first = first;
        this.second = second;
    }

    public double[][] getResult() throws InterruptedException {

        final Thread[] threads = new Thread[threadsCount];
        final double[][] result = new double[first.length][second[0].length];
        int threadscount = 0;

        for (int row = 0; row < first.length; row++) {
            threads[threadscount] = new Thread(new MultiplyThread(row, first, second, result));
            threads[threadscount].start();
            threads[threadscount].join();
            threadscount++;
        }

        return result;

    }
}
