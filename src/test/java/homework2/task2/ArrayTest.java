package homework2.task2;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by koval on 10.11.2016.
 */
public class ArrayTest {

    private Array<Integer> array = new Array<>();

    @Test(expected = IllegalArgumentException.class)
    public void requireResultWithAdd() {
        array.add(new Array.Element[]{new Array.Element(new Integer(1)), new Array.Element(new Integer(2))});
    }

    @Test
    public void requireResultWithMinus() {
        array.setArray(new Array.Element[]{new Array.Element(new Integer(1)),
                new Array.Element(new Integer(2)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(4)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1))});

        array.minus(new Array.Element[]{new Array.Element(new Integer(1)),
                new Array.Element(new Integer(2)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(4)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1))});

        assertNotNull(array);
    }

    @Test
    public void requireResultWithMultiply() {
        array.setArray(new Array.Element[]{new Array.Element(new Integer(1)),
                new Array.Element(new Integer(2)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(4)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1))});

        array.multiply(new Array.Element[]{new Array.Element(new Integer(1)),
                new Array.Element(new Integer(2)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(4)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1))});

        assertNotNull(array);
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireResultWithDevide() {
        array.devide(new Array.Element[]{new Array.Element(new Integer(1)),
                new Array.Element(new Integer(2)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(4)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1)),
                new Array.Element(new Integer(1))});
        assertNotNull(array);
    }
}
