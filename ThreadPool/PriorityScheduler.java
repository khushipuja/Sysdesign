package ThreadPool;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityScheduler implements TaskSchduler{

    private PriorityBlockingQueue<Runnable> priorityQueue;

    public PriorityScheduler() {
        this.priorityQueue = new PriorityBlockingQueue<Runnable>(10, Comparator.comparingInt(o -> o.hashCode()));
    }

    @Override
    public void submit(Runnable task) {
        priorityQueue.add(task);
    }

    @Override
    public Runnable fetchTask() throws InterruptedException {
        return priorityQueue.take();
    }
}
