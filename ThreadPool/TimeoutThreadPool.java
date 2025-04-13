package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// Implementing timeout mechanism for tasks in thread pool
public class TimeoutThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<?> f =  executorService.submit(()->{
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       });

        try{
            f.get(2, TimeUnit.MILLISECONDS); // Tiemout after 2 seconds
        }catch (Exception e) {
            f.cancel(true);
            System.out.println("Task timed out and was cancelled.");
            e.printStackTrace();
        }


    }
}
