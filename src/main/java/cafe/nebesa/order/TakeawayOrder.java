package cafe.nebesa.order;

public class TakeawayOrder extends OrderType {
    public TakeawayOrder(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }

    @Override
    public void process(Order order) {
        System.out.println("Заказ на вынос:");
        orderProcessor.processOrder(order);
    }
}
