package threads.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class cachedThreadPool {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 8; i++) {
                service.execute(new Task(i));
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }
}

class Task implements Runnable{
    private final int taskId;

    Task (int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run (){
        System.out.println("Task " + taskId + " being executed by " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }
}
