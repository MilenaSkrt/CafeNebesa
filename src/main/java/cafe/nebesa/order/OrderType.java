package cafe.nebesa.order;

public abstract class OrderType {
    protected OrderProcessor orderProcessor;

    public OrderType(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    public abstract void process(Order order);
}
