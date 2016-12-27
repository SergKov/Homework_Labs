package homework5.task31;

import java.util.stream.IntStream;

/**
 * Created by koval on 27.12.2016.
 */
public class MultiplyThread implements Runnable {

    private final int row;
    private final int col;
    private final double[][] first;
    private final double[][] second;
    private final double[][] result;

    public MultiplyThread(int row, int col, double[][] first, double[][] second, double[][] result) {
        this.row = row;
        this.col = col;
        this.first = first;
        this.second = second;
        this.result = result;
    }

    @Override
    public void run() {
        IntStream.range(0, second.length).forEach(value -> result[row][col] += first[row][value] * second[value][col]);
    }
}
