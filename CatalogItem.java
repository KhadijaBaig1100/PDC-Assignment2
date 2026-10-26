public class CatalogItem {
    private String sku;
    private int stockQuantity;

    public CatalogItem(String sku, int stockQuantity) {
        this.sku = sku;
        this.stockQuantity = stockQuantity;
    }

    public String getSku() {
        return sku;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public synchronized void updateStock(int amount) {
        this.stockQuantity += amount;
    }
}