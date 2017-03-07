package homework6.task37;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by koval on 07.03.2017.
 */
public class BlockingQueue<E> {

    private final Queue<E> queue = new LinkedList<E>();
    private final int limit;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public void enqueue(final E element) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == limit) {
                queue.wait();
            }

            if (queue.size() == 0) {
                queue.notifyAll();
            }
            queue.add(element);
        }
    }

    public E dequeue() throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == 0) {
                queue.wait();
            }

            if (queue.size() == limit) {
                queue.notifyAll();
            }
            return queue.remove();
        }
    }
}
