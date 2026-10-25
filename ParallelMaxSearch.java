public class ParallelMaxSearch implements Runnable {
    private double[] sensorArray;
    private int start;
    private int end;
    private double maxValue;

    public ParallelMaxSearch(double[] sensorArray, int start, int end) {
        this.sensorArray = sensorArray;
        this.start = start;
        this.end = end;
        this.maxValue = -Double.MAX_VALUE;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (sensorArray[i] > maxValue) {
                maxValue = sensorArray[i];
            }
        }
    }

    public double getMaxValue() {
        return maxValue;
    }
}