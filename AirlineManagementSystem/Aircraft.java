package AirlineManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Aircraft {

    List<Seat> seatList;
    String name;

    public Aircraft(String name, List<Seat> seatList) {
        this.seatList = seatList;
        this.name = name;

    }
}
