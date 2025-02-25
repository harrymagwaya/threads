package threads;

// extend threads example
public class extThr {
    public static void main(String[] args) {
        Thread one = new threadOne();
        Thread two = new threadTwo();
        one.start();
        
        two.start();

    }
}

class threadOne extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("Thread one " + i);
        }
    }

}

class threadTwo extends Thread {

    @Override
    public void run() {
        for (int i = 7; i < 10; i++) {
            System.out.println("Thread two " + i);
        }
    }

}