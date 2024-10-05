package utility;

import counter.Counter;
import org.junit.Before;
import org.junit.Test;
import thread.IncrementingThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LockUtilityTest {

    private Counter counter;
    private Thread[] threads;

    private static final int NUMBER_OF_COUNT_CYCLES = 2000000;
    private static final Logger LOGGER =
            Logger.getLogger(LockUtilityTest.class.getName());

    @Before
    public void setUp() {
        Lock lock = new ReentrantLock();

        this.counter = new Counter(lock);

        this.threads = new Thread[2];

        this.threads[0] = new Thread(new IncrementingThread(this.counter, NUMBER_OF_COUNT_CYCLES));
        this.threads[1] = new Thread(new IncrementingThread(this.counter, NUMBER_OF_COUNT_CYCLES));
    }

    @Test
    public void testLockInNonAtomicCounting() {
        this.threads[0].start();
        this.threads[1].start();

        try {
            this.threads[0].join();
            this.threads[1].join();
        } catch (InterruptedException e) {
            LOGGER.warning("Could not wait for threads with join() method");
        }

        assertThat(this.counter.getCurrentCount(), is(2 * NUMBER_OF_COUNT_CYCLES));
    }
}