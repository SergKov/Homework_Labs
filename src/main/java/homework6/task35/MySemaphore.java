package homework6.task35;

/**
 * Created by koval on 05.01.2017.
 */
public class MySemaphore {

    private final int bound;
    private int signals;

    public MySemaphore(int bound) {
        this.bound = bound;
    }

    public synchronized void acquire() throws InterruptedException {
        while (bound == signals) {
            this.wait();
        }
        signals++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (signals == 0) {
            this.wait();
        }
        signals--;
        this.notify();
    }
}
