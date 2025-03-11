package AirlineManagementSystem;

import java.time.LocalDate;
import java.util.Date;
public class SearchRequest {
    String from;
    String to;
    Date fromDate;

    public SearchRequest(String from, String to, Date fromDate) {
        this.from = from;
        this.to = to;
        this.fromDate = fromDate;
    }

}
