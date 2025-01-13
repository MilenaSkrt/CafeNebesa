package cafe.nebesa.menu;

public abstract class MenuItemDecorator implements MenuItem {
    protected MenuItem baseItem;

    public MenuItemDecorator(MenuItem baseItem) {
        this.baseItem = baseItem;
    }

    @Override
    public String getName() {
        return baseItem.getName();
    }

    @Override
    public double getPrice() {
        return baseItem.getPrice();
    }
}
