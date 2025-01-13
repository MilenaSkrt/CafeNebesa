package cafe.nebesa.report.payment;

// Интерфейс для способов оплаты
public interface PaymentMethod {
    void pay(double amount);
    void refund(double amount);
}
