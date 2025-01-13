package cafe.nebesa.loyalty;

import cafe.nebesa.loyalty.LoyaltyComponent;

import java.util.ArrayList;
import java.util.List;

public class LoyaltyLevel implements LoyaltyComponent {
    private String levelName;
    private List<LoyaltyComponent> loyaltyComponents;

    public LoyaltyLevel(String levelName) {
        this.levelName = levelName;
        this.loyaltyComponents = new ArrayList<>();
    }

    public void addComponent(LoyaltyComponent component) {
        loyaltyComponents.add(component);
    }

    @Override
    public void addPoints(double points) {
        System.out.println("[" + levelName + "] Начисление " + points + " баллов на все компоненты.");
        for (LoyaltyComponent component : loyaltyComponents) {
            component.addPoints(points);
        }
    }

    @Override
    public void subtractPoints(double points) {
        System.out.println("[" + levelName + "] Списание " + points + " баллов с всех компонентов.");
        for (LoyaltyComponent component : loyaltyComponents) {
            component.subtractPoints(points);
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("[" + levelName + "] Проверка баланса всех компонентов.");
        for (LoyaltyComponent component : loyaltyComponents) {
            component.checkBalance();
        }
    }
}