package homework5.task28;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by koval on 21.12.2016.
 */
public class RedBlackTreeTest {

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

        for (int i = 0; i < 100; i++) {
            redBlackTree.put("A" + i, i);
        }

        final int expected = 100;
        final int result = redBlackTree.size();

        assertEquals(expected, result);
    }
}
