package cafe.nebesa.order;

public class DineInOrderProcessor implements OrderProcessor {
    @Override
    public void processOrder(Order order) {
        System.out.println("Обработка заказа на месте. Номер заказа: " + order.getId());
    }
}
