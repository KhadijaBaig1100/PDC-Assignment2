import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPortfolioApp {
    public static void main(String[] args) {
        System.out.println("=== Fork Join Asset Portfolio Engine ===\n");

        int size = 10000;
        double[] assets = new double[size];
        Random random = new Random(42);

        for (int i = 0; i < size; i++) {
            assets[i] = 100 + random.nextDouble() * 900;
        }

        try (ForkJoinPool pool = new ForkJoinPool()) {
            long startTime = System.nanoTime();

            ParallelRiskCalculator initialRiskTask = new ParallelRiskCalculator(assets, 0, assets.length);
            double initialTotalRisk = pool.invoke(initialRiskTask);

            double riskCap = 800.0;
            PortfolioThresholdTask stressTask = new PortfolioThresholdTask(assets, 0, assets.length, riskCap);
            pool.invoke(stressTask);

            ParallelRiskCalculator postStressRiskTask = new ParallelRiskCalculator(assets, 0, assets.length);
            double postStressTotalRisk = pool.invoke(postStressRiskTask);

            long endTime = System.nanoTime();
            double elapsedTimeMs = (endTime - startTime) / 1e6;

            System.out.println("Generated Assets            : " + size);
            System.out.println("Initial Cumulative Risk     : $" + String.format("%.2f", initialTotalRisk));
            System.out.println("Applied Risk Cap Threshold  : $" + riskCap);
            System.out.println("Post-Stress Cumulative Risk : $" + String.format("%.2f", postStressTotalRisk));
            System.out.println("Execution Time              : " + String.format("%.3f", elapsedTimeMs) + " ms");
        }
    }
}