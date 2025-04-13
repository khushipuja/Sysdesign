package ThreadPool;

public interface TaskSchduler {
    void submit(Runnable task);
    Runnable fetchTask() throws InterruptedException;
}
