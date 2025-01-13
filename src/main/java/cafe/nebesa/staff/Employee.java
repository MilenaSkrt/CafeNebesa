package cafe.nebesa.staff;

import cafe.nebesa.order.Order;

// Абстрактный класс Employee
public abstract class Employee {
    protected String name;
    protected String role;
    protected int experience;

    // Ссылка на следующего сотрудника в цепочке
    protected Employee nextEmployee;

    public Employee(String name, String role, int experience) {
        this.name = name;
        this.role = role;
        this.experience = experience;
    }

    // Установка следующего сотрудника в цепочке
    public void setNextEmployee(Employee nextEmployee) {
        this.nextEmployee = nextEmployee;
    }

    // Выполнение задачи
    public void handleTask(Order order, String task) {
        if (canHandleTask(task)) {
            performTask(order, task);
        } else if (nextEmployee != null) {
            System.out.println(role + " не может выполнить задачу: " + task + ". Передача задачи следующему сотруднику...");
            nextEmployee.handleTask(order, task);
        } else {
            System.out.println("Задача не может быть выполнена. Нет подходящего сотрудника.");
        }
    }

    // Метод для проверки, может ли сотрудник выполнить задачу
    protected abstract boolean canHandleTask(String task);

    // Метод для выполнения задачи
    protected abstract void performTask(Order order, String task);
}

