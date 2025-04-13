package ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class DynamicThreadPool {

    private BlockingQueue<Runnable> queue;
    private List<Thread> workers;
    int maxThreads;
    int minThreads;
    AtomicBoolean isShutdownInitiated;
    int currentThreads;

    public DynamicThreadPool(int maxThreads, int minThreads) {
        this.maxThreads = maxThreads;
        this.minThreads = minThreads;
        this.workers = new ArrayList<Thread>(minThreads);
        this.isShutdownInitiated = new AtomicBoolean(false);
        this.currentThreads = maxThreads;
        for(int i=0;i<minThreads;i++){
            workers.add(new Worker());
            workers.get(i).start();
        }
        monitorLoad();
    }

    private void monitorLoad() {
        new Thread(()->{
            try{
                while(!isShutdownInitiated.get()){
                    if(queue.size() > workers.size() && currentThreads < maxThreads){
                        addWorder();
                    }else if(queue.size() < workers.size()){
                        removeWorker();
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }

    public void addWorder(){
        workers.add(new Worker());
        currentThreads++;
    }

    public void removeWorker(){
        if(currentThreads > minThreads){
            Thread worker = workers.get(workers.size()-1);
            currentThreads--;
            worker.interrupt();
        }
    }
}
