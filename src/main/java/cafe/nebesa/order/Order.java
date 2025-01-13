package cafe.nebesa.order;

import cafe.nebesa.client.Observer;
import cafe.nebesa.menu.Dish;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order implements cafe.nebesa.order.SubjectInterface {
    private List<Dish> dishList;
    private LocalDateTime creationTime;
    private String status;
    private List<Observer> observers;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order() {
        this.dishList = new ArrayList<>();
        this.creationTime = LocalDateTime.now();
        this.status = "Pending";
        this.observers = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishList.add(dish);
    }

    public void changeStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }
}
