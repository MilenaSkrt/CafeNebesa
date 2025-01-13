package cafe.nebesa.menu;

public class SideDishDecorator extends MenuItemDecorator {
    private String sideDish;
    private double sideDishPrice;

    public SideDishDecorator(MenuItem baseItem, String sideDish, double sideDishPrice) {
        super(baseItem);
        this.sideDish = sideDish;
        this.sideDishPrice = sideDishPrice;
    }

    @Override
    public String getName() {
        return baseItem.getName() + " with side dish: " + sideDish;
    }

    @Override
    public double getPrice() {
        return baseItem.getPrice() + sideDishPrice;
    }
}
