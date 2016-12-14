package homework5.task30;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by koval on 10.12.2016.
 */
public class HashTableTest {

    private HashTable<String, String> hashTable;

    @Before
    public void setUp() {
        hashTable = new HashTable<>();
    }

    @Test
    public void requireSizeWithEmptyHashTable() {

        final int expected = 0;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterPut() {

        hashTable.put("A", "ABC");

        final int expected = 1;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterPutNullKeyValue() {

        hashTable.put(null, null);

        final int expected = 1;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterPutNullKey() {

        hashTable.put(null, "null");

        final int expected = 1;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterTwoPutNullKey() {

        hashTable.put(null, "null");
        hashTable.put(null, "null1");

        final int expected = 1;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterPutNullValue() {

        hashTable.put("1", null);

        final int expected = 1;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultAfterPutValue() {

        final String value = hashTable.put("1", "A");

        final String expected = "A";
        final String result = value;

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterTwoTheSamePut() {

        hashTable.put("1", "A");
        hashTable.put("1", "A");

        final int expected = 1;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultAfterTwoPutWithTheSameKeysAndDifferentValues() {

        hashTable.put("1", "A");
        hashTable.put("1", "AB");

        final String expected = "AB";
        final String result = hashTable.get("1");

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterTwoPutWithCollisions() {

        hashTable.put("AaAa", "1");
        hashTable.put("BBBB", "2");
        hashTable.put("AaBB", "7");
        hashTable.put("BBAa", "19");

        final int expected = 4;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultAfterTwoPutWithCollisions() {

        hashTable.put("AaAa", "1");
        hashTable.put("BBBB", "2");
        hashTable.put("AaBB", "7");
        hashTable.put("BBAa", "19");

        final String expected = "7";
        final String result = hashTable.get("AaBB");

        assertEquals(expected, result);
    }

    @Test
    public void requireResultAfterPutValueNull() {

        final String value = hashTable.put("1", null);

        assertNull(value);
    }

    @Test
    public void requireSizeAfterFourteenPut() {

        hashTable.put("A", "A");
        hashTable.put("B", "AB");
        hashTable.put("C", "ABC");
        hashTable.put("D", "ABCD");
        hashTable.put("E", "ABCDE");
        hashTable.put("F", "ABCDEF");
        hashTable.put("G", "ABCDEFG");
        hashTable.put("H", "ABCDEFGH");
        hashTable.put("I", "ABCDEFGHI");
        hashTable.put("J", "ABCDEFGHIJ");
        hashTable.put("K", "ABCDEFGHIJK");
        hashTable.put("L", "ABCDEFGHIJKL");
        hashTable.put("M", "ABCDEFGHIJKLM");
        hashTable.put("N", "ABCDEFGHIJKLMN");

        final int expected = 14;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterPutRemove() {

        hashTable.put("1", "A");
        hashTable.remove("1");

        final int expected = 0;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterPutNotExistsRemove() {

        hashTable.put("1", "A");
        hashTable.remove("2");

        final int expected = 1;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterFourteenPutAndOneRemove() {

        hashTable.put("A", "A");
        hashTable.put("B", "AB");
        hashTable.put("C", "ABC");
        hashTable.put("D", "ABCD");
        hashTable.put("E", "ABCDE");
        hashTable.put("F", "ABCDEF");
        hashTable.put("G", "ABCDEFG");
        hashTable.put("H", "ABCDEFGH");
        hashTable.put("I", "ABCDEFGHI");
        hashTable.put("J", "ABCDEFGHIJ");
        hashTable.put("K", "ABCDEFGHIJK");
        hashTable.put("L", "ABCDEFGHIJKL");
        hashTable.put("M", "ABCDEFGHIJKLM");
        hashTable.put("N", "ABCDEFGHIJKLMN");

        hashTable.remove("C");

        final int expected = 13;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultAfterFourteenPutRemoveFromTheMiddle() {

        hashTable.put("A", "A");
        hashTable.put("B", "AB");
        hashTable.put("C", "ABC");
        hashTable.put("D", "ABCD");
        hashTable.put("E", "ABCDE");
        hashTable.put("F", "ABCDEF");
        hashTable.put("G", "ABCDEFG");
        hashTable.put("H", "ABCDEFGH");
        hashTable.put("I", "ABCDEFGHI");
        hashTable.put("J", "ABCDEFGHIJ");
        hashTable.put("K", "ABCDEFGHIJK");
        hashTable.put("L", "ABCDEFGHIJKL");
        hashTable.put("M", "ABCDEFGHIJKLM");
        hashTable.put("N", "ABCDEFGHIJKLMN");

        final String value = hashTable.remove("G");

        final String expected = "ABCDEFG";
        final String result = value;

        assertEquals(expected, result);
    }

    @Test
    public void requireResultAfterPutRemoveWithCollisions() {

        hashTable.put("AaAa", "1");
        hashTable.put("BBBB", "2");
        hashTable.put("AaBB", "7");
        hashTable.put("BBAa", "19");

        final String expected = "19";
        final String result = hashTable.remove("BBAa");

        assertEquals(expected, result);
    }

    @Test
    public void requireSizeAfterPutRemoveWithCollisions() {

        hashTable.put("AaAa", "1");
        hashTable.put("BBBB", "2");
        hashTable.put("AaBB", "7");
        hashTable.put("BBAa", "19");

        hashTable.remove("BBAa");

        final int expected = 3;
        final int result = hashTable.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultAfterGetWithNotExistsKey() {
        final String value = hashTable.get("125");
        assertNull(value);
    }

    @Test
    public void requireResultAfterPutGetValueNull() {

        hashTable.put("1", null);

        final String value = hashTable.get("1");

        assertNull(value);
    }

    @Test
    public void requireResultAfterFourteenPutGetEnd() {

        hashTable.put("A", "A");
        hashTable.put("B", "AB");
        hashTable.put("C", "ABC");
        hashTable.put("D", "ABCD");
        hashTable.put("E", "ABCDE");
        hashTable.put("F", "ABCDEF");
        hashTable.put("G", "ABCDEFG");
        hashTable.put("H", "ABCDEFGH");
        hashTable.put("I", "ABCDEFGHI");
        hashTable.put("J", "ABCDEFGHIJ");
        hashTable.put("K", "ABCDEFGHIJK");
        hashTable.put("L", "ABCDEFGHIJKL");
        hashTable.put("M", "ABCDEFGHIJKLM");
        hashTable.put("N", "ABCDEFGHIJKLMN");

        final String value = hashTable.get("N");

        final String expected = "ABCDEFGHIJKLMN";
        final String result = value;

        assertEquals(expected, result);
    }

    @Test
    public void requireResultAfterFourteenPutGetStart() {

        hashTable.put("A", "A");
        hashTable.put("B", "AB");
        hashTable.put("C", "ABC");
        hashTable.put("D", "ABCD");
        hashTable.put("E", "ABCDE");
        hashTable.put("F", "ABCDEF");
        hashTable.put("G", "ABCDEFG");
        hashTable.put("H", "ABCDEFGH");
        hashTable.put("I", "ABCDEFGHI");
        hashTable.put("J", "ABCDEFGHIJ");
        hashTable.put("K", "ABCDEFGHIJK");
        hashTable.put("L", "ABCDEFGHIJKL");
        hashTable.put("M", "ABCDEFGHIJKLM");
        hashTable.put("N", "ABCDEFGHIJKLMN");

        final String value = hashTable.get("A");

        final String expected = "A";
        final String result = value;

        assertEquals(expected, result);
    }

    @Test
    public void requireResultAfterFourteenPutGetMiddle() {

        hashTable.put("A", "A");
        hashTable.put("B", "AB");
        hashTable.put("C", "ABC");
        hashTable.put("D", "ABCD");
        hashTable.put("E", "ABCDE");
        hashTable.put("F", "ABCDEF");
        hashTable.put("G", "ABCDEFG");
        hashTable.put("H", "ABCDEFGH");
        hashTable.put("I", "ABCDEFGHI");
        hashTable.put("J", "ABCDEFGHIJ");
        hashTable.put("K", "ABCDEFGHIJK");
        hashTable.put("L", "ABCDEFGHIJKL");
        hashTable.put("M", "ABCDEFGHIJKLM");
        hashTable.put("N", "ABCDEFGHIJKLMN");

        final String value = hashTable.get("G");

        final String expected = "ABCDEFG";
        final String result = value;

        assertEquals(expected, result);
    }

}
