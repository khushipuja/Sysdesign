package BookManagementSystem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BookManagementSystem implements BookManage{

    // priority queue for active users
    private final PriorityQueue<User> usersToAssign;
    private final ConcurrentHashMap<User,Boolean> usersAssigned;
    private Map<String , Book> bookMap;

    private int MAX_ACTIVE_USERS;

    public BookManagementSystem() {
        usersToAssign = new PriorityQueue<>(Comparator.reverseOrder());
        usersAssigned = new ConcurrentHashMap<>();
        MAX_ACTIVE_USERS = 1;
        bookMap = new HashMap<>();
    }

    @Override
    public synchronized void issueBook(Book book,User user) {
        if(!usersAssigned.containsKey(user)) {
            if(usersAssigned.size() < MAX_ACTIVE_USERS) {
                book.setStatus(Status.ISSUED);
                user.setActiveBook(book);
                usersAssigned.put(user, true);
                System.out.println("User " + user.name + " being assigned new book");
            }else{
                System.out.println("MAX_ACTIVE_USERS reached");
            }

        }else{
            System.out.println("User already assigned to active book");
        }
    }

    @Override
    public synchronized void returnBook(User user) {
        Book activeBook = user.activeBook;
        if(activeBook != null) {
            activeBook.setStatus(Status.NOT_ISSUES);
            user.setActiveBook(null);
            usersAssigned.remove(user);
        }else{
            System.out.println("User does not have active book");
        }
    }

    @Override
    public void addBook(Book book) {
        bookMap.putIfAbsent(book.getTitle(), book);
    }

    @Override
    public List<String> listBooks() {
        return bookMap.keySet().stream().toList();
    }
}
