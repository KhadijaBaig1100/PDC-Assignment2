public class AsyncWebEngineApp {
    public static void main(String[] args) {
        System.out.println("=== Async Web Engine Starting ===\n");

        TelemetryThread telemetryWorker = new TelemetryThread("Telemetry-Thread");
        Thread logWorker = new Thread(new LogProcessorTask(), "LogProcessor-Thread");

        System.out.println("Telemetry Thread State before start: " + telemetryWorker.getState());
        System.out.println("Log Worker Thread State before start: " + logWorker.getState());

        System.out.println("\nSpawning concurrent workers...\n");
        telemetryWorker.start();
        logWorker.start();
    }
}