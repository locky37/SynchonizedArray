
//Help link
//https://stackoverflow.com/questions/5066160/java-threads-and-main-thread
//

package ru.locky37;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();
        List<Integer> synchroList = Collections.synchronizedList(new ArrayList());

        synchroList.add(1);
        synchroList.add(2);
        synchroList.add(3);
        synchroList.add(4);
        synchroList.add(5);
        synchroList.add(6);
        synchroList.add(7);

        long start = System.currentTimeMillis();

        synchronized (synchroList) {
            for (Integer integer : synchroList) {
                Thread t = new PrintExample(integer);
                t.start();
                threads.add(t);
            }
        }

        for (Thread t : threads) t.join();
        System.out.println("");
        System.out.println("Check all Threads is done");

        System.out.println("");
        long end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start) + " milliseconds");
    }
}