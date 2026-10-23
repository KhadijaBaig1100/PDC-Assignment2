import java.util.ArrayList;
import java.util.List;

public class TradingEngineApp {
    public static void main(String[] args) {
        System.out.println("=== Financial CEP Engine Starting ===\n");

        List<TradeEvent> eventQueue = new ArrayList<>();

        eventQueue.add(new FIXOrderEvent("SNDR-01", 150.00, "ORD-881", 500));
        eventQueue.add(new ReutersQuoteEvent("SNDR-02", 2800.50, "GOOGL", 0.25));
        eventQueue.add(new FIXOrderEvent("SNDR-03", 420.75, "ORD-882", 1200));
        eventQueue.add(new ReutersQuoteEvent("SNDR-04", 175.20, "AAPL", 0.10));

        for (TradeEvent event : eventQueue) {
            System.out.print("Timestamp [" + event.getTimestamp() + "] ");
            event.dispatch();
        }

        System.out.println("\nAll events processed successfully.");
    }
}