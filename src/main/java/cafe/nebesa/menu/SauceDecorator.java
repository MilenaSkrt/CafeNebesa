package cafe.nebesa.menu;

public class SauceDecorator extends MenuItemDecorator {
    private String sauce;
    private double saucePrice;

    public SauceDecorator(MenuItem baseItem, String sauce, double saucePrice) {
        super(baseItem);
        this.sauce = sauce;
        this.saucePrice = saucePrice;
    }

    @Override
    public String getName() {
        return baseItem.getName() + " with " + sauce;
    }

    @Override
    public double getPrice() {
        return baseItem.getPrice() + saucePrice;
    }
}
