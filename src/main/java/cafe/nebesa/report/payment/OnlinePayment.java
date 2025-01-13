package cafe.nebesa.report.payment;

// Реализация способа оплаты "Онлайн"
public class OnlinePayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата через онлайн-систему: " + amount + " рублей.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Возврат через онлайн-систему: " + amount + " рублей.");
    }
}
