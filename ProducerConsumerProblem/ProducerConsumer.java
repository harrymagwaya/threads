package threads.ProducerConsumerProblem;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
        public static void main(String[] args) {
            Worker worker = new Worker(5, 0);

            Thread producer = new Thread(()->{
                try {
                    worker.produce();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });

            Thread consumer = new Thread(()->{
                try {
                    worker.consumer();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });

            producer.start();
            consumer.start();
        } 
    
}

    class Worker {

    private static Object lock = new Object();
    private int sequence = 0;
    private final Integer top;
    private final Integer bottom;
    private final List<Integer> list;

    public Worker(Integer top, Integer bottom) {
        this.top = top;
        this.bottom = bottom;
        this.list = new ArrayList<>();
    }

    public void produce() throws InterruptedException {

        synchronized (lock) {
            while (true) {
                if (list.size() == top) {
                    System.out.println("The list is full please wait stop producing");
                    lock.wait();
                } else {
                    System.out.println(sequence + " added to the container");
                    list.add(sequence++);
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consumer() throws InterruptedException {

        synchronized (lock) {
            while (true) {
                if (list.size() == bottom) {
                    System.out.println("Nothing to consume waiting for an item to be added to list");
                    lock.wait();
                } else {
                    System.out.println(list.removeFirst() + " removed from the container");
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

}
