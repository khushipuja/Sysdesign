package CarRentalSystem.reservation;

import CarRentalSystem.Vehicle.Vehicle;

import java.util.Date;

public class Reservation {

    Vehicle vehicle;
    Date reservationDate;
    Date startDate;
    Date endDate;
    double price;
    ReservationStatus reservationStatus;

    public Reservation(Vehicle vehicle, Date reservationDate, Date startDate, Date endDate, double price) {
        this.vehicle = vehicle;
        this.reservationDate = reservationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.reservationStatus = ReservationStatus.RESERVED;
    }
}
