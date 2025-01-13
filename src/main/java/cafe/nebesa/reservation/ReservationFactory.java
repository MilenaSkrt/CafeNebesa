package cafe.nebesa.reservation;

import java.time.LocalDateTime;

public interface ReservationFactory {
    Reservation createReservation(LocalDateTime time, int numberOfPeople, String reservationType);
}
