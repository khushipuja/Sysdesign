package AirlineManagementSystem;

import java.util.Date;

public class Bookings {

    String id;
    Passenger passenger;
    Date date;
    Double price;
    BookingStatus status;

    public Bookings(String id, Passenger passenger, Date date, Double price) {
        this.id = id;
        this.passenger = passenger;
        this.date = date;
        this.price = price;
        this.status = BookingStatus.SUCCESS;
    }

    public void setBookingStatus(BookingStatus status) {
        this.status = status;
    }

    public void cancelBooking() {
        this.status = BookingStatus.CANCELLED;
    }
}
