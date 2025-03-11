package threads.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class scheduledThread {
    public static void main(String[] args) {
        ScheduledExecutorService service  = Executors.newScheduledThreadPool(1);
            for (int i = 0; i < 1; i++) {
              
                    service.scheduleAtFixedRate(new Task(i), 100, 2000, TimeUnit.MILLISECONDS);
                    try {
                        if (!service.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                            service.shutdownNow();
                            
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;    
            }

            // service.scheduleAtFixedRate(new Task(1), 100, 2000, TimeUnit.MILLISECONDS);
            // try {
            //     if (!service.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
            //         service.shutdownNow();
            //         boolean terminated = service.awaitTermination(10000, TimeUnit.MILLISECONDS);

            //     }
            // } catch (InterruptedException e) {
            //     // TODO Auto-generated catch block
            //     service.shutdownNow();
            // }  
        
    }
}

class Task implements Runnable{
    private final int taskId;

    Task(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run(){
        System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}