package AirlineManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
    List<Flight> flightSchedulesList;
    public SearchService(List<Flight> flightSchedulesList) {
        flightSchedulesList = this.flightSchedulesList;
    }

    public List<Flight> getFlightSchedulesList(SearchRequest searchRequest) {

        String from = searchRequest.from;
        String to = searchRequest.to;
        String date = String.valueOf(searchRequest.fromDate);

        return flightSchedulesList.stream().filter(flight -> flight.getDepartureTime().equals(from)).collect(Collectors.toList());

    }
}
