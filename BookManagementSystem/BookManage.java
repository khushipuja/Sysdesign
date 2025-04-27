package BookManagementSystem;

import java.util.List;

public interface BookManage {
    public void issueBook(Book book,User user);
    public void returnBook(User user);
    public void addBook(Book book);
    public List<String> listBooks();
}
