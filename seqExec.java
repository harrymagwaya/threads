package threads;

// threads first example
class seqExec{
    public static void main(String[] args) {
       
        Thread one = new Thread(new threadOne());
        Thread two = new Thread(new threadTwo());

        one.start();
        System.out.println("Waiting ");
        //Thread.sleep(100);
        two.start();
    }

}

class threadOne implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("Thread one " + i);
        }
    }
    
}
class threadTwo implements Runnable{

    @Override
    public void run() {
        for (int i = 7; i < 10; i++) {
          System.out.println("Thread two " + i);
        }
    }
    
}