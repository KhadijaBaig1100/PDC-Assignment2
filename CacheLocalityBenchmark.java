public class CacheLocalityBenchmark {
    public static void main(String[] args) {
        System.out.println("=== CPU Cache Locality & Memory Traversal Profiler ===\n");

        int size = 2000;
        System.out.println("Allocating " + size + "x" + size + " double matrix (4,000,000 elements)...");
        MatrixProcessor processor = new MatrixProcessor(size);
        System.out.println("Matrix initialization complete.\n");
    }
}