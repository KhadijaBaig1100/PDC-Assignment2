import java.util.Map;

public class SynchronizedMapWorker implements Runnable {
    private Map<String, CatalogItem> catalog;
    private int iterations;

    public SynchronizedMapWorker(Map<String, CatalogItem> catalog, int iterations) {
        this.catalog = catalog;
        this.iterations = iterations;
    }

    @Override
    public void run() {}
}