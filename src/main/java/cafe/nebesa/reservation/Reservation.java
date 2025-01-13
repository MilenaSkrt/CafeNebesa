package cafe.nebesa.reservation;

import java.time.LocalDateTime;

public class Reservation {
    private LocalDateTime time;
    private int numberOfPeople;
    private String reservationType;

    public Reservation(LocalDateTime time, int numberOfPeople, String reservationType) {
        this.time = time;
        this.numberOfPeople = numberOfPeople;
        this.reservationType = reservationType;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public String getReservationType() {
        return reservationType;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "time=" + time +
                ", numberOfPeople=" + numberOfPeople +
                ", reservationType='" + reservationType + '\'' +
                '}';
    }
}

