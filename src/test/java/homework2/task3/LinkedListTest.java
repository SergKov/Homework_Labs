package homework2.task3;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by koval on 07.11.2016.
 */
public class LinkedListTest {

    private final LinkedList<Integer> list = new LinkedList<>();

    @Test
    public void requireResultWithEmptyListSize() {
        final int expected = 0;
        final int result = list.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultEmptyListWithIsEmpty() {
        final boolean expected = true;
        final boolean result = list.isEmpty();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultNotEmptyListWithIsEmpty() {
        list.add(54);
        final boolean expected = false;
        final boolean result = list.isEmpty();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultEmptyListWithIsEmptyAfterContains() {
        list.contains(null);
        final boolean expected = true;
        final boolean result = list.isEmpty();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAdd() {
        list.add(34);
        list.add(37);
        list.add(87);
        list.add((int)-0.8);
        list.add(null);
        final int expected = 5;
        final int result = list.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAddByFinishIndex() {
        list.add(45);
        list.add(Integer.MAX_VALUE);
        list.add(32);
        list.add(2, 56);
        final int expected = 4;
        final int result = list.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAddByStartIndex() {
        list.add(45);
        list.add(Integer.MIN_VALUE);
        list.add(32);
        list.add(0, 56);
        final int expected = 4;
        final int result = list.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAddByIndexInTheMiddle() {
        list.add(56);
        list.add(76);
        list.add(76);
        list.add(65);
        list.add(54);
        list.add(2, -56);
        final int expected = 6;
        final int result = list.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithGet() {
        list.add(56);
        list.add(null);
        list.add(5);
        list.add(67);
        list.add(76);
        final Integer expected = null;
        final Integer result = list.get(1);
        assertEquals(expected, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void requireException() {
        list.add(6);
        list.get(1);
    }

    @Test
    public void requireResultWithSet() {
        list.add(78);
        list.add(67);
        list.add(Integer.MIN_VALUE);
        list.add(67);
        list.set(0, 56);
        final int expected = 4;
        final int result = list.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithContainsTrue() {
        list.add(78);
        list.add(456);
        list.add(67);
        final boolean expected = true;
        final boolean result = list.contains(456);
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithContainsFalse() {
        list.add(78);
        list.add(456);
        list.add(67);
        final boolean result = list.contains(598);
        final boolean expected = false;
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithRemoveByIndexInTheMiddle() {
        list.add(23);
        list.add(54);
        list.add(45);
        final Integer expected = 54;
        final Integer result = list.remove(1);
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithRemoveByIndexInTheMiddleTrue() {
        list.add(23);
        list.add(54);
        list.add(45);
        final boolean expected = true;
        final boolean result = list.remove(new Integer(54));
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithRemoveByIndexFalse() {
        list.add(23);
        list.add(54);
        list.add(45);
        final boolean result = list.remove(new Integer(458));
        final boolean expected = false;
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithRemoveByIndexTrue() {
        list.add(23);
        list.add(54);
        list.add(45);
        list.add(Integer.MIN_VALUE);
        list.add(Integer.MIN_VALUE);
        list.add(Integer.MAX_VALUE);
        final boolean result = list.remove(new Integer(Integer.MAX_VALUE));
        final boolean expected = true;
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithRemoveContainsTrue() {
        list.add(23);
        list.add(54);
        list.add(45);
        list.add(Integer.MIN_VALUE);
        list.add(Integer.MAX_VALUE);
        list.remove(new Integer(45));
        final boolean expected = false;
        final boolean result = list.contains(new Integer(45));
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAddAll() {
        list.add(65);
        list.addAll(new CopyOnWriteArrayList<Integer>() {{
            add(65);
            add(45);
            add(34);
            add(22);
            add(11);
        }});
        final boolean expected = true;
        final boolean result = list.contains(11);
        assertEquals(expected, result);
    }
}
