package cafe.nebesa.inventory;

public class Inventory {
    private String productName;
    private int quantity;
    private RestockStrategy restockStrategy;

    public Inventory(String productName, int quantity, RestockStrategy restockStrategy) {
        this.productName = productName;
        this.quantity = quantity;
        this.restockStrategy = restockStrategy;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void checkInventory() {
        System.out.println("Checking inventory for " + productName + ": " + quantity + " units available.");
    }

    public void restock() {
        restockStrategy.restock(this);
    }
}
