package homework3.task1;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 17.11.2016.
 */
class A { /* for tests*/ }

public class PhantomReferenceFactory {

    private static PhantomReferenceFactory factory;

    public static PhantomReferenceFactory getInstance(final int limit) {

        if (factory == null) {
            return new PhantomReferenceFactory(limit);
        }

        return factory;
    }

    private final ReferenceQueue queue = new ReferenceQueue();
    private final List<Reference> phantomReferenceList = new ArrayList<>();

    private int count;
    private int limit;

    private PhantomReferenceFactory(int limit) {
        this.limit = limit;
    }

    public A createReference() throws InterruptedException {
        while (true) {
            if (count < limit) {
                final A obj = new A();
                phantomReferenceList.add(initPhantomReference(obj));
                return obj;
            } else {
                final Reference ref = queue.remove(500);
                if (ref != null) {
                    phantomReferenceList.remove(ref);
                    count--;
                }
            }
        }
    }

    private PhantomReference initPhantomReference(final Object obj) {
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

