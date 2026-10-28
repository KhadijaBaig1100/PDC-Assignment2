public abstract class TradeEvent {
    protected String senderId;
    protected long timestamp;
    protected double basePrice;

    public TradeEvent(String senderId, double basePrice) {
        this.senderId = senderId;
        this.basePrice = basePrice;
        this.timestamp = System.currentTimeMillis();
    }

    public String getSenderId() {
        return senderId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public abstract void dispatch();
}