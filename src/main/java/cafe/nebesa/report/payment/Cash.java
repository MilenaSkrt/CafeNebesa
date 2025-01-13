package cafe.nebesa.report.payment;

// Реализация способа оплаты "Наличные"
public class Cash implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата наличными: " + amount + " рублей.");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Возврат наличных: " + amount + " рублей.");
    }
}
