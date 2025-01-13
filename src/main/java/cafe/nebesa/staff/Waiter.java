package cafe.nebesa.staff;

import cafe.nebesa.order.Order;

// Класс официанта (Waiter)
public class Waiter extends Employee {
    public Waiter(String name, int experience) {
        super(name, "Официант", experience);
    }

    @Override
    protected boolean canHandleTask(String task) {
        return task.equalsIgnoreCase("обработка заказа");
    }

    @Override
    protected void performTask(Order order, String task) {
        System.out.println(role + " " + name + " выполняет задачу: " + task);
        // Логика обработки заказа (например, передача на кухню)
        order.changeStatus("Передан на кухню");
    }
}
