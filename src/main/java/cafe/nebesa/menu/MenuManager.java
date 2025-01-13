package cafe.nebesa.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private static MenuManager instance;
    private List<MenuItem> dishes;
    private List<MenuItem> drinks;

    private MenuManager() {
        dishes = new ArrayList<>();
        drinks = new ArrayList<>();
    }

    public static MenuManager getInstance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    public void addDish(MenuItem dish) {
        dishes.add(dish);
    }

    public void removeDish(MenuItem dish) {
        dishes.remove(dish);
    }

    public List<MenuItem> getDishes() {
        return new ArrayList<>(dishes);
    }

    public void addDrink(MenuItem drink) {
        drinks.add(drink);
    }

    public void removeDrink(MenuItem drink) {
        drinks.remove(drink);
    }

    public List<MenuItem> getDrinks() {
        return new ArrayList<>(drinks);
    }
}
