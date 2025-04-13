package ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

// Singleton Thread Pool

public class ThreadPool {
    private static ThreadPool instance;
    private BlockingQueue<Runnable> taskQueue;
    private Thread[] workers;
    private AtomicBoolean isShutDownInitiated;
    private TaskSchduler taskSchduler;

    private ThreadPool(int numThread,TaskSchduler taskSchduler) {
        taskQueue = new LinkedBlockingQueue<>();
        isShutDownInitiated = new AtomicBoolean(false);
        workers = new Thread[numThread];
        this.taskSchduler = taskSchduler;

        for (int i = 0; i < numThread; i++) {
            workers[i] = new Worker(isShutDownInitiated,taskSchduler);
            workers[i].start();
        }
    }

    public static ThreadPool getInstance(int numThread,TaskSchduler taskSchduler) {
        if (instance == null) {
            instance = new ThreadPool(numThread,taskSchduler);
        }
        return instance;
    }

    public void submit(Runnable task) {
        if(!isShutDownInitiated.get()) {
            taskSchduler.submit(task);
        }
    }

    public void shutdown() {
        isShutDownInitiated.set(true);
        for (Thread worker : workers) {
            worker.interrupt();
        }
    }
}
