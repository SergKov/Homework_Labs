package homework3.task1;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by koval on 17.11.2016.
 */
public class PhantomReferenceFactoryTest {

    @Test
    public void requireResultWithEightReference() throws InterruptedException {
        final PhantomReferenceFactory phantomReferenceFactory = PhantomReferenceFactory.getInstance(5);

        final PhantomReference<A> phantomReference1 = phantomReferenceFactory.createPhantomReference(new A());
        final PhantomReference<A> phantomReference2 = phantomReferenceFactory.createPhantomReference(new A());
        final PhantomReference<A> phantomReference3 = phantomReferenceFactory.createPhantomReference(new A());
        final PhantomReference<A> phantomReference4 = phantomReferenceFactory.createPhantomReference(new A());
        final PhantomReference<A> phantomReference5 = phantomReferenceFactory.createPhantomReference(new A());

        System.gc();
        Thread.sleep(1000);

        final PhantomReference<A> phantomReference6 = phantomReferenceFactory.createPhantomReference(new A());

        System.gc();
        Thread.sleep(1000);

        final PhantomReference<A> phantomReference7 = phantomReferenceFactory.createPhantomReference(new A());

        System.gc();
        Thread.sleep(1000);

        final PhantomReference<A> phantomReference8 = phantomReferenceFactory.createPhantomReference(new A());

        System.gc();
        Thread.sleep(1000);

        final ReferenceQueue<A> referenceQueue = phantomReferenceFactory.getReferenceQueue();

        assertNotNull(referenceQueue.poll());
        assertNotNull(referenceQueue.poll());
        assertNotNull(referenceQueue.poll());
        assertNotNull(referenceQueue.poll());
        assertNotNull(referenceQueue.poll());
        assertNull(referenceQueue.poll());
        assertNull(referenceQueue.poll());
        assertNull(referenceQueue.poll());
        assertNull(referenceQueue.poll());
        assertNull(referenceQueue.poll());
        assertNull(referenceQueue.poll());
        assertNull(referenceQueue.poll());
        assertNull(referenceQueue.poll());
    }
}


