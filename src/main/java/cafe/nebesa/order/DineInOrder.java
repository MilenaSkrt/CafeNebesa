package cafe.nebesa.order;

public class DineInOrder extends OrderType {
    public DineInOrder(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }

    @Override
    public void process(Order order) {
        System.out.println("Заказ на месте:");
        orderProcessor.processOrder(order);
    }
}
