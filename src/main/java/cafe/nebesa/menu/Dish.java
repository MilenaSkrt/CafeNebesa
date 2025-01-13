package cafe.nebesa.menu;

public class Dish implements MenuItem {
    private String name;
    private String type; // e.g., "Main Course", "Dessert"
    private double price;

    public Dish(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
