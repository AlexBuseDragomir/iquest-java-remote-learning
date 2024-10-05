package thread;

import counter.Counter;

public class IncrementingThread implements Runnable {

    private Counter counter;
    private int numberOfCounts;

    public IncrementingThread(Counter counter, int numberOfCounts)
    {
        this.counter = counter;
        this.numberOfCounts = numberOfCounts;
    }

    @Override
    public void run()
    {
        for(int index = 0; index < this.numberOfCounts; index ++)
        {
            this.counter.nonAtomicIncrement();
        }
    }
}
