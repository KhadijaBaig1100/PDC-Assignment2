public abstract class TradeEvent {
    protected String senderId;
    protected long timestamp;
    protected double basePrice;

    public TradeEvent(String senderId, double basePrice) {
        this.senderId = senderId;
        this.basePrice = basePrice;
        this.timestamp = System.currentTimeMillis();
    }
}