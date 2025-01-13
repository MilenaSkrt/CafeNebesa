package cafe.nebesa.staff;

import cafe.nebesa.order.Order;

// Класс повара (Chef)
public class Chef extends Employee {
    public Chef(String name, int experience) {
        super(name, "Повар", experience);
    }

    @Override
    protected boolean canHandleTask(String task) {
        return task.equalsIgnoreCase("приготовление блюда");
    }

    @Override
    protected void performTask(Order order, String task) {
        System.out.println(role + " " + name + " выполняет задачу: " + task);
        // Логика приготовления блюда
        order.changeStatus("Готовится");
    }
}
