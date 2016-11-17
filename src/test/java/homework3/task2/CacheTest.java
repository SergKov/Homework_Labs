package homework3.task2;

import org.junit.Test;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by koval on 15.11.2016.
 */
public class CacheTest {

    private Cache cache = new Cache();

    @Test
    public void requireResultWithPut() throws IOException {
        cache.put("D:/tmp/1.txt");
        final byte[] result = cache.get("D:/tmp/1.txt");
        assertNotNull(result);
    }

    @Test
    public void requireEqualsResultWithReadFromFileAndCache() throws IOException {
        final String nameOfFile = "D:/tmp/1.txt";

        cache.put(nameOfFile);

        final byte[] readFromCache = cache.get(nameOfFile);

        Path pathToFile = Paths.get(nameOfFile);
        final byte[] readFromFile = Files.readAllBytes(pathToFile);

        assertArrayEquals(readFromFile, readFromCache);
    }

    @Test(timeout = 15L)
    public void requireResultWithRepeatableReadFromCache() throws IOException {
        final String nameOfFile = "D:/tmp/2.txt";
        cache.put(nameOfFile);

        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
        cache.get(nameOfFile);
    }

    @Test
    public void requireResultWithOutOfMemory() throws IOException {
        cache.put("D:/tmp/1.txt");
        cache.put("D:/tmp/2.txt");
        cache.put("D:/tmp/1txt.txt");
        cache.put("D:/tmp/json.txt");

        final Collection<SoftReference<byte[]>> values = cache.getCache().values();

        values.forEach(value -> assertNotNull(value.get()));

        final List<Byte> listForOutOfMemory = new ArrayList<>();

        for (SoftReference softReference : values) {
            if (softReference.get() != null) {
                listForOutOfMemory.addAll(Arrays.asList(new Byte[5]));
            } else {
                return;
            }
        }
    }


}
