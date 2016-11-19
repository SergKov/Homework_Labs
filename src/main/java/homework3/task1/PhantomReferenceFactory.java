package homework3.task1;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by koval on 17.11.2016.
 */
class A {
    // for tests
}

public class PhantomReferenceFactory { // get object

    private static final ReferenceQueue queue = new ReferenceQueue();

    private static int count;
    private static PhantomReferenceFactory factory;

    private int limit;

    private PhantomReferenceFactory(int limit) {
        this.limit = limit;
    }

    public static PhantomReferenceFactory getInstance(final int limit) {

        if (factory == null) {
            return new PhantomReferenceFactory(limit);
        }

        return factory;
    }

    public PhantomReference createPhantomReference(final Object obj) throws InterruptedException {
        while (true) {
            if (count < limit) {
                return initPhantomReference(obj);
            } else {
                final Reference ref = queue.remove(500);
                if (ref != null) {
                    count--;
                }
            }
        }
    }

    private static PhantomReference initPhantomReference(final Object obj) {
        final PhantomReference phantomRef = new PhantomReference(obj, queue);
        count++;
        return phantomRef;
    }

    public int getCount() {
        return count;
    }

    public ReferenceQueue getReferenceQueue() {
        return queue;
    }
}

