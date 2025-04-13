package ThreadPool;

public class Task implements Runnable {

    private final String taskName;
    public Task(String taskName) {
        this.taskName = taskName;
    }
    @Override
    public void run() {
        System.out.println("Executing TASK " + taskName);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Task " + taskName + " executed");
    }
}
