import java.util.concurrent.RecursiveTask;

public class ParallelRiskCalculator extends RecursiveTask<Double> {
    private static final int THRESHOLD = 1000;
    private double[] assetValues;
    private int start;
    private int end;

    public ParallelRiskCalculator(double[] assetValues, int start, int end) {
        this.assetValues = assetValues;
        this.start = start;
        this.end = end;
    }
}