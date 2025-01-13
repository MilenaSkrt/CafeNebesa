package cafe.nebesa.inventory;

public class Supplier {
    public void supply(Inventory inventory) {
        inventory.restock(); // инициирует пополнение в зависимости от стратегии
    }
}
