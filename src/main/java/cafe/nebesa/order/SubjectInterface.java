package cafe.nebesa.order;

import cafe.nebesa.client.Observer;

public interface SubjectInterface {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
