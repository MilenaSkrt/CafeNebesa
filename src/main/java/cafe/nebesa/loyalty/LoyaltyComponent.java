package cafe.nebesa.loyalty;

import java.util.ArrayList;
import java.util.List;

// Интерфейс LoyaltyComponent
public interface LoyaltyComponent {
    void addPoints(double points);
    void subtractPoints(double points);
    void checkBalance();
}



