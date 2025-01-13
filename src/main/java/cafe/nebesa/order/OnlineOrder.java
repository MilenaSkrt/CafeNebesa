package cafe.nebesa.order;

public class OnlineOrder extends OrderType {
    public OnlineOrder(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }

    @Override
    public void process(Order order) {
        System.out.println("Онлайн-заказ:");
        orderProcessor.processOrder(order);
    }
}
