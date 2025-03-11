package AirlineManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirlineManagementSystem {
    private final List<Flight> flights;
    private final List<Aircraft> aircrafts;
    private final SearchService flightSearch;
    private final BookingSystemManager bookingManager;
    private final PaymentProcessor paymentProcessor;

    public AirlineManagementSystem() {
        flights = new ArrayList<>();
        aircrafts = new ArrayList<>();
        flightSearch = new SearchService(flights);
        bookingManager = BookingSystemManager.getInstance();
        paymentProcessor = PaymentProcessor.getInstance();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public List<Flight> searchFlights(String source, String destination, Date date) {
        return flightSearch.getFlightSchedulesList(new SearchRequest(source,destination,date));
    }

//    public Bookings bookFlight(Flight flight, Passenger passenger, Seat seat, double price) {
////        return bookingManager.createBooking(flight, passenger, seat, price);
//    }

}