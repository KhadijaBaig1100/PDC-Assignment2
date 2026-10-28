import java.util.Map;

public class SynchronizedMapWorker implements Runnable {
    private Map<String, CatalogItem> catalog;
    private int iterations;

    public SynchronizedMapWorker(Map<String, CatalogItem> catalog, int iterations) {
        this.catalog = catalog;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            String key = "SKU_" + (i % 10);
            synchronized (catalog) {
                CatalogItem item = catalog.get(key);
                if (item != null) {
                    item.updateStock(1);
                }
            }
        }
    }
}