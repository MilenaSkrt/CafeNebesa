package cafe.nebesa.reservation;

import java.time.LocalDateTime;

public class ReservationFactoryImpl implements ReservationFactory {
    @Override
    public Reservation createReservation(LocalDateTime time, int numberOfPeople, String reservationType) {
        switch (reservationType) {
            case "Banquet":
                return new Reservation(time, numberOfPeople, "Banquet");
            case "Standard":
                return new Reservation(time, numberOfPeople, "Standard");
            case "VIP":
                return new Reservation(time, numberOfPeople, "VIP");
            default:
                throw new IllegalArgumentException("Unknown reservation type: " + reservationType);
        }
    }
}
