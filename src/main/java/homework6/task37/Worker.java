package homework6.task37;

/**
 * Created by koval on 07.03.2017.
 */
public class Worker extends Thread {

    private final RunnableQueue<Runnable> tasks;
    private final ThreadPool threadPool;

    public Worker(RunnableQueue<Runnable> tasks, ThreadPool threadPool) {
        this.tasks = tasks;
        this.threadPool = threadPool;
    }

    @Override
    public void run() {
        while (threadPool.isClosed()) {
            try {
                final Runnable runnable = tasks.dequeue();
                runnable.run();
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
