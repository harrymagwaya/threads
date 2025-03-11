package threads.concurrentColl;

import java.util.concurrent.CountDownLatch;

public class Restaurant {
    public static void main(String[] args) throws InterruptedException {
        int numOfChefs = 3;
        CountDownLatch latch = new CountDownLatch(numOfChefs);

        new Thread(new Chef("chef A", "pizza", latch)).start();
        new Thread(new Chef("chef B", "pasta", latch)).start();
        new Thread(new Chef("chef C", "posho", latch)).start();

        latch.await();
        
        System.out.println("All dishes are ready ! lets start serving customers. ");

    }
}

class Chef implements Runnable {

    private final String name;
    private final String dish;
    private final CountDownLatch latch;

    public  Chef(String name, String dish, CountDownLatch latch){
        this.name = name;
        this.dish = dish;
        this.latch = latch;
    }


    @Override
    public void run() {
        try {
            System.out.println(name + " is preparing " + dish);
            Thread.sleep(5000);
            System.out.println(dish + " is done");
            latch.countDown();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
