package threads.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class callableDemo {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
           Future<Integer> result= service.submit(new ReturnValueThread());

           System.out.println(result.get());
           System.out.println("Main thread execution completed");
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }
}

class ReturnValueThread implements Callable <Integer> {

    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
       return 12;
    }
    
}
