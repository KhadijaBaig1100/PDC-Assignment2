public class TelemetryThread extends Thread {
    public TelemetryThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[" + getName() + "] Collecting CPU & Memory Metrics (" + i + "/5)");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                System.out.println("Telemetry thread interrupted: " + e.getMessage());
            }
        }
    }
}