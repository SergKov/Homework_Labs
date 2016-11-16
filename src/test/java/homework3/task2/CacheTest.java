package homework3.task2;

import org.hamcrest.core.StringContains;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

/**
 * Created by koval on 15.11.2016.
 */
public class CacheTest {

    private Cache cache = new Cache();

    @Test
    public void requireResultWithPut() {
        cache.put("D:/tmp/1.txt");
        final byte[] result = cache.get("D:/tmp/1.txt");
        assertNotNull(result);
    }

    @Ignore
    @Test
    public void requireResultWithPutAfterOutOfMemory() {
        cache.put("D:/tmp/1.txt");
        cache.put("D:/tmp/2.txt");
        cache.put("D:/tmp/json.txt");
        cache.put("D:/tmp/from.txt");
        cache.put("D:/tmp/1txt.txt");
        cache.put("D:/tmp/serial.txt");

        assertFalse(cache.getCache().values().contains(null));

        List<Long> list = new ArrayList<>();
        while (true) {
            list.addAll(Arrays.asList(new Long[5]));

            if (cache.getCache().values().contains(null)) {
                break;
            }
        }

        assertTrue(cache.getCache().values().contains(null));
    }


}
