package cafe.nebesa.report.payment;

import cafe.nebesa.order.Order;

// Класс PaymentSystem - контекст, использующий стратегию
public class PaymentSystem {
    private PaymentMethod paymentMethod;

    public PaymentSystem(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay(double amount, Order order) {
        if (paymentMethod != null) {
            paymentMethod.pay(amount);

            // Связь с заказом
            System.out.println("Оплата связана с заказом: " + order.getId());
        } else {
            System.out.println("Способ оплаты не выбран.");
        }
    }

    public void refund(double amount) {
        if (paymentMethod != null) {
            paymentMethod.refund(amount);
        } else {
            System.out.println("Способ возврата средств не выбран.");
        }
    }
}
