package runnable;

@FunctionalInterface
public interface UncheckedRunnable {

    void run() throws RuntimeException;
}
