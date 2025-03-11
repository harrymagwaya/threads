package threads.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - startTime;
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            for (int i = 0; i < 5; i++) {
                service.execute(new Task(i));      
            }
            System.out.println("System counted " + 5 + "in " + (elapsedTime / 1000));   
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        } 
    }
}

class Task implements Runnable {

    private final int taskId;
    Task(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run(){
        System.out.println("Task with ID " + taskId + " being executed by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }

}
