package AirlineManagementSystem;

public class Crew extends User{
    public Crew(String name, String email) {
        super(name, email, UserType.CREW);
    }
}
