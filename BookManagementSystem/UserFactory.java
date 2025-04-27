package BookManagementSystem;


public class UserFactory {

    public static User createUser(String username) {
        return new User(username);
    }
}
