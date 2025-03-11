package AirlineManagementSystem;

public abstract  class User {

    public String name;
    public String id;
    public String email;
    public UserType userType;

    public User(String name, String email, UserType userType) {
        this.name = name;
        this.email = email;
        this.userType = userType;
    }
}
