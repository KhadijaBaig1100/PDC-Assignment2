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
}