package cafe.nebesa.inventory;

public class AutomaticRestock implements RestockStrategy {
    private static final int REORDER_LEVEL = 5; // минимальный уровень для пополнения
    private static final int REPLENISH_AMOUNT = 20; // количество для пополнения

    @Override
    public void restock(Inventory inventory) {
        if (inventory.getQuantity() <= REORDER_LEVEL) {
            System.out.println("Автоматическое пополнение завершено, пополнили на 20. ");
            // Вместо добавления фиксированного числа, мы пополняем до определенного уровня
            inventory.setQuantity(inventory.getQuantity() + REPLENISH_AMOUNT);
        }
    }
}
