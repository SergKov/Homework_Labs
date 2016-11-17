package homework3.task3;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by koval on 15.11.2016.
 */
public class QuickSortTest {

    @Test(expected = IllegalArgumentException.class)
    public void requireResultWithEmptyList() {
        QuickSort.sortList(Collections.EMPTY_LIST, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireResultWithNull() {
        QuickSort.sortList(null, null);
    }

    @Test
    public void requireResultWithSize() {
        final List<Long> list = new ArrayList<Long>(){{
            add(12L);
            add(67L);
            add(-15L);
            add(65L);
            add(67L);
        }};

        QuickSort.sortList(list, null);

        final int expected = 5;
        final int result = list.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultSortList() {
        final List<Long> list = new ArrayList<Long>(){{
            add(12L);
            add(67L);
            add(-15L);
            add(65L);
            add(67L);
            add(Long.MAX_VALUE);
            add(Long.MIN_VALUE);
            add(76L);
            add(78L);
            add(-Long.MIN_VALUE);
        }};

        QuickSort.sortList(list, null);

        final Iterator<Long> iter = list.iterator();
        Long current = iter.next();
        while (iter.hasNext()) {
            final Long next = iter.next();
            assertTrue(current.compareTo(next) <= 0);
            current = next;
        }
    }

    @Test
    public void requireResultSortListWithOwnComparator() {
        final List<Integer> list = new ArrayList<Integer>(){{
            add(12);
            add(67);
            add(-15);
            add(65);
            add(67);
            add(Integer.MAX_VALUE);
            add(Integer.MIN_VALUE);
            add(76);
            add(78);
            add(Integer.MIN_VALUE);
            add(Integer.MAX_VALUE);
            add(54);
            add(67);
            add(652);
        }};

        QuickSort.sortList(list, (o1, o2) -> new BigInteger(String.valueOf(o2.intValue()))
                .compareTo(new BigInteger(String.valueOf(o1.intValue()))));

        final Iterator<Integer> iter = list.iterator();
        Integer current = iter.next();
        while (iter.hasNext()) {
            final Integer next = iter.next();
            assertTrue(current.compareTo(next) >= 0);
            current = next;
        }
    }
}
