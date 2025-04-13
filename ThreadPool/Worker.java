package ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Worker extends Thread {
    private AtomicBoolean isShutDownInitiated;
    private TaskSchduler taskSchduler;

//    public Worker(BlockingQueue<Runnable> taskQueue, AtomicBoolean isShutDownInitiated) {
//        this.taskQueue = taskQueue;
//        this.isShutDownInitiated = isShutDownInitiated;
//    }

    public Worker(AtomicBoolean isShutDownInitiated,TaskSchduler taskSchduler) {
        this.isShutDownInitiated = isShutDownInitiated;
        this.taskSchduler = taskSchduler;
    }

    public Worker() {
        this.isShutDownInitiated = new AtomicBoolean(false);
        this.taskSchduler = new FIFOSchedulingStrategy();
    }

    @Override
    public void run() {
        while (!isShutDownInitiated.get()) {
            try{
                Runnable task = taskSchduler.fetchTask();
                task.run();
            } catch (InterruptedException e) {
                if(isShutDownInitiated.get()) {
                    Thread.currentThread().interrupt();
                    break;
                }
                throw new RuntimeException(e);
            }
        }
    }
}
