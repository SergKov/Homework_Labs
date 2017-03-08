package homework6.task37;

/**
 * Created by koval on 07.03.2017.
 */
public class Worker extends Thread {

    private final RunnableQueue<Runnable> tasks;

    public Worker(RunnableQueue<Runnable> tasks) {
        this.tasks = tasks;
        this.setDaemon(true);
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
