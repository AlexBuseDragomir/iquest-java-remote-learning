package main;

import counter.Counter;
import thread.IncrementingThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class MainLauncher {

    private static final int NUMBER_OF_COUNT_CYCLES = 2000000;
    private static final Logger LOGGER =
            Logger.getLogger(MainLauncher.class.getName());

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Counter counter = new Counter(lock);
        Thread[] threads = new Thread[2];

        threads[0] = new Thread(new IncrementingThread(counter, NUMBER_OF_COUNT_CYCLES));
        threads[1] = new Thread(new IncrementingThread(counter, NUMBER_OF_COUNT_CYCLES));

        threads[0].start();
        threads[1].start();

        try {
            threads[0].join();
            threads[1].join();
        } catch (InterruptedException e) {
            LOGGER.warning("Could not wait for threads with join() method");
        }

        System.out.println("After counting 2000000 times with each thread:");
        System.out.println("The value of the counter is: " + counter.getCurrentCount());
    }
}
