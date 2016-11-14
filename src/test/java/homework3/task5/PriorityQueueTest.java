package homework3.task5;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by koval on 12.11.2016.
 */
public class PriorityQueueTest {

    private final PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

    @Test
    public void requireResultSizeWithEmptyQueue() {
        final int expected = 0;
        final int result = priorityQueue.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultOffer() {
        final Long elem = Long.MAX_VALUE;
        priorityQueue.offer(elem);

        final int expected = 1;
        final int result = priorityQueue.size();

        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireResultOfferWithNull() {
        priorityQueue.offer(null);
    }

    @Test
    public void requireResultPollWithEmptyQueue() {
        final Long result = priorityQueue.poll();
        assertNull(result);
    }

    @Test
    public void requireResultPoll() {
        priorityQueue.offer(78L);
        priorityQueue.offer(65L);
        priorityQueue.offer(43L);
        priorityQueue.offer(12L);
        priorityQueue.offer(176L);
        priorityQueue.offer(12L);

        final Long expected = 12L;
        final Long result = priorityQueue.poll();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultSizeWithPoll() {
        priorityQueue.offer(78L);
        priorityQueue.offer(65L);
        priorityQueue.offer(43L);
        priorityQueue.offer(12L);
        priorityQueue.offer(176L);
        priorityQueue.offer(12L);

        priorityQueue.poll();

        final int expected = 5;
        final int result = priorityQueue.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultPeek() {
        priorityQueue.offer(78L);
        priorityQueue.offer(65L);
        priorityQueue.offer(176L);
        priorityQueue.offer(12L);

        final Long expected = 12L;
        final Long result = priorityQueue.peek();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultPeekWithTwoEqualsTops() {
        priorityQueue.offer(-1878L);
        priorityQueue.offer(565L);
        priorityQueue.offer(1176L);
        priorityQueue.offer(1176L);

        final Long expected = 1176L;
        final Long result = priorityQueue.peek();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultSizeWithPeek() {
        priorityQueue.offer(-1878L);
        priorityQueue.offer(565L);
        priorityQueue.offer(1176L);
        priorityQueue.offer(1176L);

        priorityQueue.peek();

        final int expected = 4;
        final int result = 4;

        assertEquals(expected, result);
    }

    @Test
    public void requireResultClear() {
        priorityQueue.offer(23L);
        priorityQueue.offer(67L);
        priorityQueue.offer(65L);

        priorityQueue.clear();

        final int expected = 0;
        final int result = priorityQueue.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultContains() {
        priorityQueue.offer(76L);
        priorityQueue.offer(35L);
        priorityQueue.offer(Long.MAX_VALUE);
        priorityQueue.offer(-7L);
        priorityQueue.offer(23L);
        priorityQueue.offer(32L);
        priorityQueue.offer(Long.MIN_VALUE);

        final boolean result = priorityQueue.contains(Long.MAX_VALUE);

        assertTrue(result);
    }

    @Test
    public void requireResultClearWithEmptyQueue() {
        priorityQueue.clear();

        final int expected = 0;
        final int result = priorityQueue.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultSortWithIterator() {
        priorityQueue.offer(-1878L);
        priorityQueue.offer(565L);
        priorityQueue.offer(1176L);
        priorityQueue.offer(1176L);
        priorityQueue.offer(76L);
        priorityQueue.offer(35L);
        priorityQueue.offer(Long.MAX_VALUE);
        priorityQueue.offer(-7L);
        priorityQueue.offer(23L);
        priorityQueue.offer(32L);
        priorityQueue.offer(Long.MIN_VALUE);

        final Iterator<Long> iter = priorityQueue.iterator();
        Long currentNumber = iter.next();
        while (iter.hasNext()) {
            final Long next = iter.next();
            assertTrue(currentNumber.compareTo(next) >= 0);
            currentNumber = next;
        }
    }

}
