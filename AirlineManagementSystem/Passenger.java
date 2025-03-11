package AirlineManagementSystem;

public class Passenger extends User {

    public Passenger(String name, String email) {
        super(name, email, UserType.PASSENGER);
    }
}
