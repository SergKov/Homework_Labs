package homework5.task31;

/**
 * Created by koval on 27.12.2016.
 */
public class MultiplyThread implements Runnable {

    private final int matrixRow;
    private final double[][] first;
    private final double[][] second;
    private final double[][] result;

    public MultiplyThread(int matrixRow, double[][] first, double[][] second, double[][] result) {
        this.matrixRow = matrixRow;
        this.first = first;
        this.second = second;
        this.result = result;
    }

    @Override
    public void run() {
        for (int col = 0; col < first.length; col++) {
            for (int row = 0; row < first[col].length; row++) {
                result[matrixRow][col] +=  first[matrixRow][row] * second[row][col];
            }
        }
    }
}
