package cafe.nebesa;

import cafe.nebesa.client.Client;
import cafe.nebesa.inventory.AutomaticRestock;
import cafe.nebesa.inventory.Inventory;
import cafe.nebesa.inventory.RegularRestock;
import cafe.nebesa.inventory.Supplier;
import cafe.nebesa.loyalty.LoyaltyCard;
import cafe.nebesa.loyalty.LoyaltyLevel;
import cafe.nebesa.loyalty.LoyaltyProgram;
import cafe.nebesa.menu.*;
import cafe.nebesa.order.*;
import cafe.nebesa.report.payment.Card;
import cafe.nebesa.report.payment.Cash;
import cafe.nebesa.report.payment.OnlinePayment;
import cafe.nebesa.report.payment.PaymentSystem;
import cafe.nebesa.report.OrderReport;
import cafe.nebesa.reservation.*;
import cafe.nebesa.staff.Chef;
import cafe.nebesa.staff.Employee;
import cafe.nebesa.staff.Manager;
import cafe.nebesa.staff.Waiter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Получение экземпляра MenuManager (Singleton)
        MenuManager menuManager = MenuManager.getInstance();

        // Создание блюд и напитков
        Dish pizza = new Dish("Пицца", "Основное блюдо", 8.50);
        Drink cola = new Drink("Кола", "Безалкогольный", 2.00);

        // Добавление их в меню
        menuManager.addDish(pizza);
        menuManager.addDrink(cola);

        // Декорирование блюда соусом и гарниром
        MenuItem pizzaWithCheese = new SauceDecorator(pizza, "Сырный соус", 1.00);
        MenuItem pizzaWithCheeseAndFries = new SideDishDecorator(pizzaWithCheese, "Картофель фри", 2.50);

        // Добавление декорированного блюда в меню
        menuManager.addDish(pizzaWithCheeseAndFries);

        // Отображение меню
        System.out.println("Блюда:");
        for (MenuItem dish : menuManager.getDishes()) {
            System.out.println("- " + dish.getName() + " ($" + dish.getPrice() + ")");
        }

        System.out.println("\nНапитки:");
        for (MenuItem drink : menuManager.getDrinks()) {
            System.out.println("- " + drink.getName() + " ($" + drink.getPrice() + ")");
        }

        // Создание клиента
        Client client = new Client("Джон Доу", "johndoe@example.com");

        // Создание заказа
        Order order = new Order();
        order.setId(1);
        order.addObserver(client);

        // Добавление блюда в заказ
        Dish pasta = new Dish("Паста", "Основное блюдо", 12.00);
        order.addDish(pasta);

        // Изменение статуса заказа
        System.out.println("\nОбновления статуса заказа:");
        order.changeStatus("Готовится");
        order.changeStatus("Готов к выдаче");

        // Создание сотрудников
        Employee waiter = new Waiter("Иван", 2);
        Employee chef = new Chef("Анна", 5);
        Employee manager = new Manager("Ольга", 10);

        // Установка цепочки ответственности
        waiter.setNextEmployee(chef);
        chef.setNextEmployee(manager);
        System.out.println("\n--- Задача 1: Обработка заказа ---");
        waiter.handleTask(order, "Обработка заказа");

        System.out.println("\n--- Задача 2: Приготовление блюда ---");
        waiter.handleTask(order, "Приготовление блюда");

        System.out.println("\n--- Задача 3: Управление заказом ---");
        waiter.handleTask(order, "Управление заказом");

        // Создание фабрик ФАБРИЧНЫЙ МЕТОД
        ReservationFactory factory = new ReservationFactoryImpl();
        Reservation banquetReservation = factory.createReservation(LocalDateTime.now(), 50, "Banquet");
        Reservation standardReservation = factory.createReservation(LocalDateTime.now(), 2, "Standard");
        Reservation vipReservation = factory.createReservation(LocalDateTime.now(), 10, "VIP");

        // Вывод созданных резервирований
        System.out.println(standardReservation);
        System.out.println(vipReservation);
        System.out.println(banquetReservation);
        Inventory flourInventory = new Inventory("Flour", 3, new AutomaticRestock());
        Inventory sugarInventory = new Inventory("Sugar", 20, new RegularRestock());

        Supplier supplier = new Supplier();

        flourInventory.checkInventory();
        sugarInventory.checkInventory();

        // Поставщик пополняет запасы
        supplier.supply(flourInventory); // автоматически пополнит до 20
        supplier.supply(sugarInventory); // пополнение по расписанию
        flourInventory.checkInventory();
        sugarInventory.checkInventory();

        // Проверка системы лояльности
        System.out.println("\n--- Система лояльности ---");
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram("Джон Доу");
        LoyaltyCard loyaltyCard = new LoyaltyCard("Джон Доу", 0);

        LoyaltyLevel silverLevel = new LoyaltyLevel("Silver");
        silverLevel.addComponent(loyaltyCard);

        loyaltyProgram.addComponent(silverLevel);

        // Начисление и списание баллов
        loyaltyProgram.addPoints(100);
        loyaltyProgram.subtractPoints(30);

        loyaltyProgram.checkBalance();

        // Создание платежной системы
        PaymentSystem paymentSystem = new PaymentSystem(new Cash());

        // Оплата наличными
        System.out.println("--- Оплата наличными ---");
        paymentSystem.pay(1500,order);
        paymentSystem.refund(500);

        // Переключение на оплату картой
        System.out.println("\n--- Оплата картой ---");
        paymentSystem.setPaymentMethod(new Card());
        paymentSystem.pay(2500,order);
        paymentSystem.refund(1000);

        // Переключение на онлайн-оплату
        System.out.println("\n--- Онлайн-оплата ---");
        paymentSystem.setPaymentMethod(new OnlinePayment());
        paymentSystem.pay(3000,order);
        paymentSystem.refund(1200);

        // Оплата заказа наличными
        System.out.println("--- Оплата заказа ---");
        paymentSystem.pay(2500, order);

        // Генерация отчета о заказах
        System.out.println("\n--- Генерация отчета о заказах ---");
        OrderReport orderReport = new OrderReport(LocalDate.now().minusDays(30), LocalDate.now());
        orderReport.createReport();

        // ПАТТЕРН МОСТ НА КУРСОВУЮ
        // Выбор процессора обработки
        OrderProcessor dineInProcessor = new DineInOrderProcessor();
        OrderProcessor takeawayProcessor = new TakeawayOrderProcessor();
        OrderProcessor onlineProcessor = new OnlineOrderProcessor();

        // Создание типов заказов
        OrderType dineInOrder = new DineInOrder(dineInProcessor);
        OrderType takeawayOrder = new TakeawayOrder(takeawayProcessor);
        OrderType onlineOrder = new OnlineOrder(onlineProcessor);

        // Обработка заказов
        System.out.println("\n--- Обработка заказа на месте ---");
        dineInOrder.process(order);

        System.out.println("\n--- Обработка заказа на вынос ---");
        takeawayOrder.process(order);

        System.out.println("\n--- Обработка онлайн-заказа ---");
        onlineOrder.process(order);

    }
}
