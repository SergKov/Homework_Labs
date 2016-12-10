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

    private final PhantomReferenceFactory phantomReferenceFactory = PhantomReferenceFactory.getInstance(5);

    @Test
    public void requireResultWithEightReference() throws InterruptedException {

        A a1 = phantomReferenceFactory.createReference();
        A a2 = phantomReferenceFactory.createReference();
        A a3 = phantomReferenceFactory.createReference();
        A a4 = phantomReferenceFactory.createReference();
        A a5 = phantomReferenceFactory.createReference();

        a3 = null;
        a4 = null;
        a5 = null;

        System.gc();
        Thread.sleep(1000);
        System.gc();

        A a6 = phantomReferenceFactory.createReference();

        System.gc();
        Thread.sleep(1000);
        System.gc();

        A a7 = phantomReferenceFactory.createReference();

        System.gc();
        Thread.sleep(1000);
        System.gc();

        A a8 = phantomReferenceFactory.createReference();

        System.gc();
        Thread.sleep(1000);
        System.gc();

        final ReferenceQueue<A> referenceQueue = phantomReferenceFactory.getReferenceQueue();

        a1 = null;
        a2 = null;
        a6 = null;
        a7 = null;
        a8 = null;

        System.gc();
        Thread.sleep(1000);
        System.gc();

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


