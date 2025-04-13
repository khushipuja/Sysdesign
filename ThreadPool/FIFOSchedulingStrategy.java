package ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FIFOSchedulingStrategy implements TaskSchduler{

    private final BlockingQueue<Runnable> queue;

    public FIFOSchedulingStrategy() {
        this.queue = new LinkedBlockingQueue<>();
    }
    @Override
    public void submit(Runnable task) {
        queue.add(task);
    }

    @Override
    public Runnable fetchTask() throws InterruptedException {
        return queue.take();
    }
}
