package BookManagementSystem;

public class User implements Comparable<User>{
    String name;
    Book activeBook;
    int priority;

    public User(String name) {
        this.name = name;
        this.activeBook = null;
    }

    public void setActiveBook(Book activeBook) {
        this.activeBook = activeBook;
    }

    @Override
    public int compareTo(User other){
        return Integer.compare(other.priority,this.priority); // Higher priority first
    }
}
