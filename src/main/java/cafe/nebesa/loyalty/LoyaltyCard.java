package cafe.nebesa.loyalty;

import cafe.nebesa.loyalty.LoyaltyComponent;

// Класс LoyaltyCard - "лист" в структуре Composite
public class LoyaltyCard implements LoyaltyComponent {
    private String clientName;
    private double balancePoints;

    public LoyaltyCard(String clientName, double initialPoints) {
        this.clientName = clientName;
        this.balancePoints = initialPoints;
    }

    @Override
    public void addPoints(double points) {
        balancePoints += points;
        System.out.println(clientName + ": Начислено " + points + " баллов. Текущий баланс: " + balancePoints);
    }

    @Override
    public void subtractPoints(double points) {
        if (balancePoints >= points) {
            balancePoints -= points;
            System.out.println(clientName + ": Списано " + points + " баллов. Текущий баланс: " + balancePoints);
        } else {
            System.out.println(clientName + ": Недостаточно баллов для списания.");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println(clientName + ": Баланс баллов: " + balancePoints);
    }
}
