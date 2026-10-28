import java.util.concurrent.RecursiveAction;

public class PortfolioThresholdTask extends RecursiveAction {
    private static final int THRESHOLD = 1000;
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

    @Override
    protected void compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                if (assetValues[i] > thresholdLimit) {
                    assetValues[i] *= 1.05; // 5% stress volatility penalty
                }
            }
        } else {
            int mid = start + (length / 2);
            PortfolioThresholdTask left = new PortfolioThresholdTask(assetValues, start, mid, thresholdLimit);
            PortfolioThresholdTask right = new PortfolioThresholdTask(assetValues, mid, end, thresholdLimit);
            invokeAll(left, right);
        }
    }
}