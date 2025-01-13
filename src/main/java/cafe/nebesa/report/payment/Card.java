package cafe.nebesa.report.payment;

// Реализация способа оплаты "Карта"
public class Card implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата картой: " + amount + " рублей.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Возврат на карту: " + amount + " рублей.");
    }
}
