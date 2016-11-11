package homework2.task4;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

import static org.junit.Assert.*;

/**
 * Created by koval on 10.11.2016.
 */
public class LinkedListTest {

    private final LinkedList<String> linkedList = new LinkedList<>();

    @Test
    public void requireResultWithEmptyListSize() {
        final int expected = 0;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithNotEmptyListSize() {

        final Collection<String> collection = new ConcurrentSkipListSet<String>() {{
            add("A");
            add("B");
        }};
        final LinkedList<String> linkedListWithCollection = new LinkedList<>(collection);

        final int unexpected = 0;
        final int result = linkedListWithCollection.size();
        assertNotEquals(unexpected, result);
    }

    @Test
    public void requireResultWithAddAll() {
        linkedList.addAll(new TreeSet<String>() {{
            add("A");
            add("B");
        }});

        final int expected = 2;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAddAllByIndex() {
        linkedList.addAll(new java.util.LinkedList<String>() {{
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
        }});

        linkedList.addAll(2, new LinkedHashSet<String>() {{
            add("inserted 1");
            add("inserted 2");
            add("inserted 3");
            add("inserted 4");
        }});

        final int expected = 9;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAdd() {
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("c");

        final int expected = 3;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAddFirst() {
        linkedList.add("A");
        linkedList.addFirst("B");
        linkedList.add("C");
        linkedList.addFirst("D");

        final int expected = 4;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAddLast() {
        linkedList.add("A");
        linkedList.addLast("B");
        linkedList.add("C");
        linkedList.addLast(null);

        final int expected = 4;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAddByIndexAtStart() {
        linkedList.add("AAA");
        linkedList.add("BBBB");
        linkedList.add("CCCCC");
        linkedList.add("DDDDDD");

        linkedList.add(0, "AA");
        final int expected = 5;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAddByIndexAtTheEnd() {
        linkedList.add("AAA");
        linkedList.add("BBBB");
        linkedList.add("CCCCC");

        linkedList.add(3, "AA");
        final int expected = 4;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAddByIndexInTheMiddle() {
        linkedList.add("111");
        linkedList.add("22222");
        linkedList.add("33333");
        linkedList.add("444444444");
        linkedList.add("555555555555555");
        linkedList.add("66666666666666666");

        linkedList.add(2, "AA");
        final int expected = 7;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }


    @Test
    public void requireResultWithClear() {
        linkedList.add("111");
        linkedList.add("22222");
        linkedList.add("33333");
        linkedList.add("444444444");

        linkedList.clear();
        final int expected = 0;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultFalseWithContains() {
        linkedList.add("111");
        linkedList.add("22222");
        linkedList.add("33333");
        linkedList.add("444444444");

        final boolean result = linkedList.contains("456");
        assertFalse(result);
    }

    @Test
    public void requireResultWithContainsNullValue() {
        linkedList.add("111");
        linkedList.add(null);
        linkedList.add("33333");
        linkedList.add(null);

        final boolean result = linkedList.contains(null);
        assertTrue(result);
    }

    @Test
    public void requireResultTrueWithContains() {
        linkedList.add("111");
        linkedList.add("22222");
        linkedList.add("33333");
        linkedList.add("444444444");

        final boolean result = linkedList.contains("444444444");
        assertTrue(result);
    }

    @Test
    public void requireResultWithIndexOf() {
        linkedList.add("111");
        linkedList.add("22222");
        linkedList.add("33333");
        linkedList.add("444444444");

        final int expected = 0;
        final int result = linkedList.indexOf("111");
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithLastIndexOf() {
        linkedList.add("111");
        linkedList.add("111");
        linkedList.add("1111");
        linkedList.add("111");

        final int expected = 3;
        final int result = linkedList.lastIndexOf("111");
        assertEquals(expected, result);
    }


    @Test
    public void requireResultMinusOneWithIndexOf() {
        linkedList.add("111");
        linkedList.add("22222");
        linkedList.add("33333");
        linkedList.add("444444444");

        final int expected = -1;
        final int result = linkedList.indexOf("1111");
        assertEquals(expected, result);
    }

    @Test
    public void requireResultMinusOneWithLastIndexOf() {
        linkedList.add("111");
        linkedList.add("22222");
        linkedList.add("33333");
        linkedList.add("444444444sd");

        final int expected = -1;
        final int result = linkedList.lastIndexOf("111df");
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithLastIndexOfWithNullValues() {
        linkedList.add(null);
        linkedList.add(null);
        linkedList.addLast("sD");
        linkedList.addFirst(null);
        linkedList.add("SFSD");

        final int expected = 2;
        final int result = linkedList.lastIndexOf(null);
        assertEquals(expected, result);
    }

    @Test
    public void requireResultTrueWithRemove() {
        linkedList.add("546");

        final boolean expected = true;
        final boolean result = linkedList.remove("546");
        assertEquals(expected, result);
    }

    @Test
    public void requireResultFalseWithRemove() {
        linkedList.add("546");

        final boolean expected = false;
        final boolean result = linkedList.remove("345");
        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterRemoveNotExists() {
        linkedList.add("546");
        linkedList.remove("345");

        final int expected = 1;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterRemoveExists() {
        linkedList.add("546");
        linkedList.remove("546");

        final int expected = 0;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithSet() {
        linkedList.add("546");
        linkedList.add("AAAAAAA");
        linkedList.add("BCGHJSDOJKL00");

        linkedList.set(1, "SetValue");
        final int expected = 3;
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void requireResultWithSetByNotExistsIndex() {
        linkedList.add("546");
        linkedList.add("AAsA12A");
        linkedList.add("BCGHJSDdsdOJKL00");

        linkedList.set(3, "SetValue");
    }

    @Test
    public void requireResultWithGet() {
        linkedList.add("546");
        linkedList.add("AAAAAAA");
        linkedList.add("BCGHJSDOJKL00");

        final String expected = "BCGHJSDOJKL00";
        final String result = linkedList.get(2);;
        assertEquals(expected, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void requireResultWithGetByNotExistsIndex() {
        linkedList.add("546");
        linkedList.add("AAsA12A");
        linkedList.add("BCGHJSDdsdOJKL00");

        linkedList.get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void requireResultWithRemoveByNotExistsIndex() {
        linkedList.add("546");
        linkedList.add("AAsA12A");
        linkedList.add("BCGHJSDdsdOJKL00");

        linkedList.remove(3);
    }

    @Test
    public void requireResultWithRemoveByExistsIndex() {
        linkedList.add("546");
        linkedList.add("AAsA12A");
        linkedList.add("BCGHJSDdsdOJKL00");

        final String expected = "AAsA12A";
        final String result = linkedList.remove(1);
        assertEquals(expected, result);
    }

    @Test
    public void requireResultSizeWithRemoveByExistsIndex() {
        linkedList.add("546");

        final int expected = 0;
        linkedList.remove(0);
        final int result = linkedList.size();
        assertEquals(expected, result);
    }

    @Test
    public void requireResultEmptyArrayWithToArrayTest() {
        final Object[] expected = {};
        final Object[] result = linkedList.toArray();

        assertArrayEquals(expected, result);
    }

    @Test
    public void requireResultNotEmptyArrayWithToArray() {
        linkedList.addAll(new ArrayList<String>(){{
            add("A");
            add("B");
            add("C");
            add("D");
        }});

        final Object[] expected = {"A", "B", "C", "D"};
        final Object[] result = linkedList.toArray();
        assertArrayEquals(expected, result);
    }

    @Test(expected = ArrayStoreException.class)
    public void requireExceptionWithToArrayWithIncorrectType() {
        linkedList.add("A");
        linkedList.toArray(new Integer[]{1}, Integer.class);
    }

    @Test
    public void requireResultIteratorWithNull() {
        Iterator<String> iterator = linkedList.iterator();
        assertNotNull(iterator);
    }

    @Test
    public void requireResultArrayWithToArrayByTypeWithArrayLessSize() {
        final String[] expected = {"A", "B", "C", "D", "E"};
        linkedList.addAll(Arrays.asList(expected));

        final String[] result = linkedList.toArray(new String[]{"12", "32", "34", "87", "2"}, String.class);
        assertArrayEquals(expected, result);
    }
}
