package runnable;

@FunctionalInterface
public interface CheckedRunnable {

    void run() throws Exception;
}
