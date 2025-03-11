package threads.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class fixedThreadpool {
    public static void main(String[] args) {
        try (ExecutorService service  = Executors.newFixedThreadPool(2)) {
            for (int i = 0; i < 7; i++) {
                service.execute(new Task(i));
            }
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }
}

class Task implements Runnable{
    private final int workId;

    public Task(int workId){
        this.workId = workId;
    }

    @Override
    public void run(){
        System.out.println("Work id " + workId + " being executed by " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }
}
