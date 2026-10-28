public class FIXOrderEvent extends TradeEvent {
    private String orderId;
    private int quantity;

    public FIXOrderEvent(String senderId, double basePrice, String orderId, int quantity) {
        super(senderId, basePrice);
        this.orderId = orderId;
        this.quantity = quantity;
    }

    @Override
    public void dispatch() {
        double totalValue = basePrice * quantity;
        System.out.println("[FIX Order Dispatched] ID: " + orderId + " | Qty: " + quantity + 
                           " | Price: $" + basePrice + " | Total: $" + totalValue + 
                           " | Sender: " + senderId);
    }
}