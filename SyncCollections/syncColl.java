package threads.SyncCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class syncColl {
    public static void main(String[] args) throws InterruptedException {
        List <Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread one  = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
        });

        Thread two = new Thread(()->{
            for (int i = 11; i < 30; i++) {
                list.add(i);
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println("Size of list is : " + list.size());

    }
}
