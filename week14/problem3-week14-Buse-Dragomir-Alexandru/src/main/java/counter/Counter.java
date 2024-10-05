package counter;

import utility.LockUtility;

import java.util.concurrent.locks.Lock;

public class Counter {

    private Lock lock;
    private int currentCount;
    private LockUtility lockUtility;

    public Counter(Lock lock) {
        this.lock = lock;
        this.currentCount = 0;
        this.lockUtility = new LockUtility();
    }

    public void nonAtomicIncrement() {
        this.lockUtility.withLock(this.lock, () -> {
            int temp;
            temp = this.currentCount;
            this.currentCount = temp + 1;
        });
    }

    public int getCurrentCount() {
        return this.currentCount;
    }
}
