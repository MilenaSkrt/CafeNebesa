package cafe.nebesa.loyalty;

import cafe.nebesa.loyalty.LoyaltyComponent;
import cafe.nebesa.loyalty.LoyaltyLevel;

import java.util.ArrayList;
import java.util.List;

// Класс LoyaltyProgram
public class LoyaltyProgram implements LoyaltyComponent {
    private String programName;
    private List<LoyaltyComponent> loyaltyComponents;

    public LoyaltyProgram(String programName) {
        this.programName = programName;
        this.loyaltyComponents = new ArrayList<>();
    }

    public void addComponent(LoyaltyComponent component) {
        loyaltyComponents.add(component);
    }

    @Override
    public void addPoints(double points) {
        System.out.println("[" + programName + "] Начисление " + points + " баллов всем компонентам программы.");
        for (LoyaltyComponent component : loyaltyComponents) {
            component.addPoints(points);
        }
    }

    @Override
    public void subtractPoints(double points) {
        System.out.println("[" + programName + "] Списание " + points + " баллов со всех компонентов программы.");
        for (LoyaltyComponent component : loyaltyComponents) {
            component.subtractPoints(points);
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("[" + programName + "] Проверка баланса всех компонентов программы.");
        for (LoyaltyComponent component : loyaltyComponents) {
            component.checkBalance();
        }
    }
}