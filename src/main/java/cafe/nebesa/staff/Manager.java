package cafe.nebesa.staff;

import cafe.nebesa.order.Order;

// Класс менеджера (Manager)
public class Manager extends Employee {
    public Manager(String name, int experience) {
        super(name, "Менеджер", experience);
    }

    @Override
    protected boolean canHandleTask(String task) {
        return task.equalsIgnoreCase("управление меню") || task.equalsIgnoreCase("управление заказом");
    }

    @Override
    protected void performTask(Order order, String task) {
        System.out.println(role + " " + name + " выполняет задачу: " + task);
        // Логика управления меню или заказами
        if (task.equalsIgnoreCase("управление заказом")) {
            order.changeStatus("Управление завершено");
        }
    }
}
