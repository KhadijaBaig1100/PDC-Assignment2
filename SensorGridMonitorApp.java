import java.util.Random;

public class SensorGridMonitorApp {
    public static void main(String[] args) {
        System.out.println("=== IoT Sensor Grid Parallel Search Engine ===\n");

        int gridSize = 100000;
        double[] sensorArray = new double[gridSize];
        Random rand = new Random(101);

        for (int i = 0; i < gridSize; i++) {
            sensorArray[i] = -50.0 + (rand.nextDouble() * 200.0);
        }

        System.out.println("Generated " + gridSize + " temperature/vibration sensor readings.");

        int mid = gridSize / 2;

        ParallelMinSearch minTask1 = new ParallelMinSearch(sensorArray, 0, mid);
        ParallelMinSearch minTask2 = new ParallelMinSearch(sensorArray, mid, gridSize);
        ParallelMaxSearch maxTask1 = new ParallelMaxSearch(sensorArray, 0, mid);
        ParallelMaxSearch maxTask2 = new ParallelMaxSearch(sensorArray, mid, gridSize);

        Thread t1 = new Thread(minTask1, "MinWorker-1");
        Thread t2 = new Thread(minTask2, "MinWorker-2");
        Thread t3 = new Thread(maxTask1, "MaxWorker-1");
        Thread t4 = new Thread(maxTask2, "MaxWorker-2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}