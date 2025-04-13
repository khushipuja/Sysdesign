class DistributedThreadPool{

  private final Jedis jedis = new Jedis("localhost");

  public void submitTask(string task){
    jedis.lpush("taskQueue",task);
  }

  public void executeTasks(){
    new Thread(()->{
      while(true){
        String task = jedis.rpop("taskQueu");
        if(task != null){
          System.out.print("Exceuting tasks " + taks);
        }
      }
      
    }).start();
  }

}
