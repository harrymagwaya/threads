package threads;

public class lockWithCustomObj {
    private static int count1 = 0;
    private static int count2 = 0;

    private static Object lock1 = new Object(); //  private is done to prevent exposure of lock obj
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread one = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                increment1();
            }
        }); 
        Thread two = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                increment2();
            }
        });
        
        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
        System.out.println(count1 + " -- "+ count2);
    }

    private static void increment1(){
        // helps lock the threads so that no other thread has access to resource untill one thread is done suing it
        synchronized(lock1){
            count1++;
        }
    }
    private static void increment2(){

        synchronized(lock2){
            count2++;
        }
    }
}
