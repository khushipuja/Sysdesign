package AirlineManagementSystem;

public class Seat {

    int id;
    SeatStatus status;
    SeatType seatType;

    public Seat(int id, SeatStatus status,SeatType seatType) {
        this.id = id;
        this.status = status;
        this.seatType = seatType;
    }
}
