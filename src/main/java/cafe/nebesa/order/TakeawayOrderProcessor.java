package cafe.nebesa.order;

public class TakeawayOrderProcessor implements OrderProcessor {
    @Override
    public void processOrder(Order order) {
        System.out.println("Обработка заказа на вынос. Номер заказа: " + order.getId());
    }
}
