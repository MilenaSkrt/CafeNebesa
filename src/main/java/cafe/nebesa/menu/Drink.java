package cafe.nebesa.menu;

public class Drink implements MenuItem {
    private String name;
    private String type; // e.g., "Alcoholic", "Non-Alcoholic"
    private double price;

    public Drink(String name, String type, double price) {
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
