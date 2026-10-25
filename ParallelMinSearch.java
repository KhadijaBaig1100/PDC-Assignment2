public class ParallelMinSearch implements Runnable {
    private double[] sensorArray;
    private int start;
    private int end;
    private double minValue;

    public ParallelMinSearch(double[] sensorArray, int start, int end) {
        this.sensorArray = sensorArray;
        this.start = start;
        this.end = end;
        this.minValue = Double.MAX_VALUE;
    }
}