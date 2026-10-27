import java.util.Random;

public class MatrixProcessor {
    private double[][] matrix;
    private int rows;
    private int cols;

    public MatrixProcessor(int size) {
        this.rows = size;
        this.cols = size;
        this.matrix = new double[size][size];

        Random rand = new Random(42);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextDouble() * 100.0;
            }
        }
    }
}