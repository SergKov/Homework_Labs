package homework6.task37;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 07.03.2017.
 */
public class ThreadPool {

    private final RunnableQueue<Runnable> taskQueue;
    private final List<Thread> threads = new ArrayList<>();

    private volatile boolean isClosed = true;

    public ThreadPool(int maxThreads) {

        taskQueue = new RunnableQueue(maxThreads);

        for (int i = 0; i < maxThreads; i++) {
            threads.add(new Worker(taskQueue, this));
        }

        threads.forEach(Thread::start);
    }

    public void execute(final Runnable task) throws InterruptedException {
        taskQueue.enqueue(task);
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public boolean isClosed() {
        return isClosed;
    }
}
