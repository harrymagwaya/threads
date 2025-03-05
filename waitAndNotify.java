package threads;

public class waitAndNotify {

    private static Object lock = new Object();
    public static void main(String[] args) {
        Thread one = new Thread(()->{
            try {
                one();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                throw new RuntimeException(e);
            }
        });

        Thread two  = new Thread(()->{
            try {
                two();
            } catch (Exception e) {
                // TODO: handle exception
                throw new RuntimeException(e);
            }
        });

        one.start();
        two.start();
    }


    private static void one() throws InterruptedException{
        synchronized(lock){
            System.out.println("1 have it now ");
            lock.wait();
            System.out.println("1 back in control");
        }
    }

    private static void two() throws InterruptedException{
        synchronized(lock){
            System.out.println("This is method 2");
            lock.notify(); // notifies threads that are in lock to be able to resume
            System.out.println("Still here iam method 2 ");
        }
    }
}
