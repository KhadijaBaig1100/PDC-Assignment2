import java.util.*;
import java.util.concurrent.*;

public class InventoryCatalogManager {
    private static final int NUM_THREADS = 10;
    private static final int UPDATES_PER_THREAD = 10000;

    private static double testSynchronizedMap() throws InterruptedException {
        Map<String, CatalogItem> syncMap = Collections.synchronizedMap(new HashMap<>());
        for (int i = 0; i < 10; i++) {
            syncMap.put("SKU_" + i, new CatalogItem("SKU_" + i, 100));
        }

        Thread[] threads = new Thread[NUM_THREADS];
        long startTime = System.nanoTime();

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new SynchronizedMapWorker(syncMap, UPDATES_PER_THREAD));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    private static double testConcurrentHashMap() throws InterruptedException {
        ConcurrentMap<String, CatalogItem> concMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            concMap.put("SKU_" + i, new CatalogItem("SKU_" + i, 100));
        }

        Thread[] threads = new Thread[NUM_THREADS];
        long startTime = System.nanoTime();

        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new ConcurrentHashMapWorker(concMap, UPDATES_PER_THREAD));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    public static void main(String[] args) {
        System.out.println("=== Inventory Catalog Concurrency Benchmark ===");
    }
}