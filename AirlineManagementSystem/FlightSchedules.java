package AirlineManagementSystem;

import java.util.List;
import java.util.Date;

public class FlightSchedules {

    Aircraft aircraft;
    List<Crew> crewList;
    List<Seat> seatList;
    Date from;
    Date to;

    public FlightSchedules(Aircraft aircraft,Date from, Date to) {
        this.aircraft = aircraft;
        this.from = new Date();
    }
}
