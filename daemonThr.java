package threads;

public class daemonThr {
   
    public static void main(String[] args) {
        Thread bgThread = new Thread(new daemonHelper());
        Thread usrThread = new Thread(new userThreadHelper());
        bgThread.setDaemon(true);

        bgThread.start();
        usrThread.start();
        System.out.println(bgThread.getState());
        System.out.println(bgThread.isAlive());
        if (!bgThread.isAlive()) {
            System.out.println("Daemon put to sleep"); 
        }
    }
}

class daemonHelper implements Runnable {

    @Override
    public void run() {
       int count = 0;
       while (count < 500) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            count ++;
            System.out.println("Daemon helper running ...");
       }
       
    }

}


class userThreadHelper implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(" User thread done with execution ");
        
    }
    
}
