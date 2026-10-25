import java.util.concurrent.RecursiveAction;

public class PortfolioThresholdTask extends RecursiveAction {
    private double[] assetValues;
    private int start;
    private int end;
    private double thresholdLimit;

    public PortfolioThresholdTask(double[] assetValues, int start, int end, double thresholdLimit) {
        this.assetValues = assetValues;
        this.start = start;
        this.end = end;
        this.thresholdLimit = thresholdLimit;
    }
}