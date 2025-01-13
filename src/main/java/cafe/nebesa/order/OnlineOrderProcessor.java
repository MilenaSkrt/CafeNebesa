package cafe.nebesa.order;

public class OnlineOrderProcessor implements OrderProcessor {
    @Override
    public void processOrder(Order order) {
        System.out.println("Обработка онлайн-заказа. Номер заказа: " + order.getId());
    }
}
