package ThreadPool;

public class ThreadPoolExample {

    public static void main(String[] args) {
        Task task1  = new Task("task1");
        Task task2  = new Task("task2");

        TaskSchduler fIFOSchedulingStrategy = new FIFOSchedulingStrategy();
        TaskSchduler priorityScheduler = new PriorityScheduler();

        ThreadPool threadPool = ThreadPool.getInstance(2,fIFOSchedulingStrategy);
        threadPool.submit(task1);
        threadPool.submit(task2);
        threadPool.shutdown();

        ThreadPool threadPool2 = ThreadPool.getInstance(2,priorityScheduler);
        threadPool2.submit(task1);
        threadPool2.submit(task2);
        threadPool2.shutdown();

    }
}
