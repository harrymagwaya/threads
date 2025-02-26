package threads;

public class SyncDemo {
    private static int count = 0;
    public static void main(String[] args) {
        Thread one = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                increment();
                //System.out.println(count);
            }
        });

        Thread two  = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                increment();
              //  System.out.println(count);
            }
        });

        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Interupted");
        }
        System.out.println(count);
    }

    private synchronized static void increment(){
        count++;
    }
}
