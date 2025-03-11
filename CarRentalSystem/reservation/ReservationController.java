package CarRentalSystem.reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationController {

    private List<Reservation> reservations;
    public ReservationController() {
        this.reservations = new ArrayList<>();
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
