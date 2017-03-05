package homework5.task28.corman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by koval on 05.03.2017.
 */
public class RedBlackTreeTest {
    private static final int COUNT_PUT = 1_000_000;

    private RedBlackTree<String, Integer> redBlackTree;

    @Before
    public void setUp() {
        redBlackTree = new RedBlackTree<>();
    }

    @Test
    public void requireSizeWithEmptyTree() {
        final Integer expected = 0;
        final Integer result = redBlackTree.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterPut() {
        redBlackTree.put("A", 1);

        final Integer expected = 1;
        final Integer result = redBlackTree.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterTwoPutWithEqualsKeys() {
        final String KEY = "A";

        redBlackTree.put(KEY, 1);
        redBlackTree.put(KEY, 2);

        final Integer expected = 1;
        final Integer result = redBlackTree.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithPut() {
        final Integer result = redBlackTree.put("A", 5);
        assertNull(result);
    }

    @Test
    public void requireResultAfterTwoPutWithEqualsKeys() {
        final String KEY = "A";

        redBlackTree.put(KEY, 1);

        final Integer expected = 1;
        final Integer result = redBlackTree.put(KEY, 2);

        assertEquals(expected, result);
    }

    @Test
    public void requireContainsAfterPut() {
        final String KEY = "A";

        redBlackTree.put(KEY, 1);
        final boolean exists = redBlackTree.contains(KEY);

        assertTrue(exists);
    }

    @Test
    public void requireContainsAfterTwoPutWithEqualsKeys() {
        final String KEY = "A";

        redBlackTree.put(KEY, 1);
        redBlackTree.put(KEY, 2);

        final boolean exists = redBlackTree.contains(KEY);

        assertTrue(exists);
    }

    @Test
    public void requireGetElementAfterTwoPutWithEqualsKeys() {
        final String KEY = "A";

        redBlackTree.put(KEY, 1);
        redBlackTree.put(KEY, 2);

        final int expected = 2;
        final int result = redBlackTree.get(KEY);

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterManyPut() {
        for (int i = 0; i < COUNT_PUT; i++) {
            redBlackTree.put("A" + i, i);
        }

        final int expected = COUNT_PUT;
        final int result = redBlackTree.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireTreeBalance() {
        for (int i = 0; i < 1_000; i++) {
            redBlackTree.put("A" + i, i);
        }

        System.out.println(redBlackTree.size());

        final int height = redBlackTree.getHeight();
        System.out.println(height);
        final int calculateLog = (int) (Math.log(redBlackTree.size()) / Math.log(2.));
        final int expectedMaxHeight = 2 * (calculateLog + 1);
        System.out.println(expectedMaxHeight);

//        assertTrue(height <= expectedMaxHeight);
    }

    @Test
    public void requireResultAfterPutRemoveWithTheSameKeys() {
        redBlackTree.put("A", 23);

        final int expected = 23;
        final int result = redBlackTree.remove("A");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterPutRemoveWithDifferentKeys() {
        redBlackTree.put("A", 250);
        redBlackTree.remove("B");

        final int expected = 1;
        final int result = redBlackTree.size();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterPutRemoveWithTheSameKeys() {
        final String KEY = "A";

        redBlackTree.put(KEY, 1023);
        redBlackTree.remove(KEY);

        final int expected = 0;
        final int result = redBlackTree.size();

        Assert.assertEquals(expected, result);
    }
}