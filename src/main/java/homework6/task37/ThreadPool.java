package homework6.task37;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 07.03.2017.
 */
public class ThreadPool {

    private final BlockingQueue<Runnable> taskQueue;
    private final List<Thread> threads = new ArrayList<>();

    public ThreadPool(int max){

        taskQueue = new BlockingQueue(max);

        for (int i = 0; i < max; i++) {
            threads.add(new Worker(taskQueue));
        }

        threads.forEach(Thread::start);
    }

    public void execute(final Runnable task) throws InterruptedException {
        synchronized (taskQueue) {
            taskQueue.enqueue(task);
        }
    }
}
