package homework6.task37;

/**
 * Created by koval on 07.03.2017.
 */
public class Worker extends Thread {

    private final BlockingQueue<Runnable> tasks;

    public Worker(BlockingQueue<Runnable> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (true) {
            try {
                final Runnable runnable = tasks.dequeue();
                runnable.run();
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
