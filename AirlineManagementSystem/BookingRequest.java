package AirlineManagementSystem;

import java.util.Date;

public class BookingRequest {

    private FlightSchedules flightSchedules;
    int seat;


    public BookingRequest(FlightSchedules flightSchedules, int seat) {
        this.flightSchedules = flightSchedules;
        this.seat = seat;
    }

}
