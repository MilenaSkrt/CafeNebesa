package cafe.nebesa.inventory;

public class RegularRestock implements RestockStrategy {
    @Override
    public void restock(Inventory inventory) {
        System.out.println("Регулярное пополнение началась, пополняем на 10 едениц");
        inventory.setQuantity(inventory.getQuantity() + 10); // регулярное пополнение допустим на 10 единиц
    }
}
