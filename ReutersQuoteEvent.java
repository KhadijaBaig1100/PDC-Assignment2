public class ReutersQuoteEvent extends TradeEvent {
    private String symbol;
    private double bidAskSpread;

    public ReutersQuoteEvent(String senderId, double basePrice, String symbol, double bidAskSpread) {
        super(senderId, basePrice);
        this.symbol = symbol;
        this.bidAskSpread = bidAskSpread;
    }

    @Override
    public void dispatch() {
        System.out.println("[Reuters Quote Dispatched] Ticker: " + symbol + 
                           " | Price: $" + basePrice + " | Spread: $" + bidAskSpread + 
                           " | Sender: " + senderId);
    }
}