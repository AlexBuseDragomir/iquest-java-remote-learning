package utility;

import runnable.CheckedRunnable;
import runnable.UncheckedRunnable;

import java.util.concurrent.locks.Lock;
import java.util.logging.Logger;

public class LockUtility {

    private static final Logger LOGGER =
            Logger.getLogger(LockUtility.class.getName());

    public <T> void withLock(Lock lock, Runnable runnable) {
        lock.lock();

        try {
            runnable.run();
        } finally {
            lock.unlock();
        }
    }

    public <T> void withLockCheckedException(Lock lock, CheckedRunnable runnable) {
        lock.lock();

        try {
            runnable.run();
        } catch (Exception e) {
            LOGGER.warning("Exception encountered while running!");
        }
        finally {
            lock.unlock();
        }
    }

    public <T> void withLockUncheckedException(Lock lock, UncheckedRunnable runnable) {
        lock.lock();

        try {
            runnable.run();
        }
        finally {
            lock.unlock();
        }
    }
}
