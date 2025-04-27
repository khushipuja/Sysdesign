package BookManagementSystem;

public class Main {

    public static void main(String[] args) {
        BookManagementSystem bms = new BookManagementSystem();
        Book book1 = new Book("Book 1", "Author 1", 2000);
        Book book2 = new Book("Book 2", "Author 2", 2000);
        User user1 = new User("kp");
        User user2 = new User("nico");
        bms.addBook(book1);
        bms.addBook(book2);

        bms.listBooks();

        // Test case1 :  Try to book book1 by user1
        bms.issueBook(book1, user1);

        // Test case2 : Try to book book1 by user2
        bms.issueBook(book1, user2);

        bms.returnBook(user1);

        // Test case3 : Try to book book1 by user2 when user1 has returned it
        bms.issueBook(book1, user2);

    }
}
