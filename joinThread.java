package threads;

public class joinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(()->{
            for (int i = 0; i < 6; i++) {
                System.out.println("Thread 1 : " + Thread.currentThread().getName() + " value : " + i);
            }
        });


        Thread two = new Thread(()->{
            for (int i = 6; i < 12; i++) {
                System.out.println("Thread 2 : " + Thread.currentThread().getName() + " value : " + i);
            }
        });

        one.start();
        one.join(); // changes order of execution aslong main to wait and follow the order of execution prescribed by user ie one then main then two
        two.start();
        
        System.out.println("Done executing thread 1");
    }
}
