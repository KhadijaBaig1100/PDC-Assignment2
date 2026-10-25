import java.util.Random;

public class ForkJoinPortfolioApp {
    public static void main(String[] args) {
        System.out.println("=== Fork Join Asset Portfolio Engine ===\n");

        int size = 10000;
        double[] assets = new double[size];
        Random random = new Random(42);

        for (int i = 0; i < size; i++) {
            assets[i] = 100 + random.nextDouble() * 900;
        }
    }
}