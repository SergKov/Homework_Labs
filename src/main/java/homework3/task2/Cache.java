package homework3.task2;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by koval on 15.11.2016.
 */
public class Cache {

    private final Map<String, SoftReference<byte[]>> cache;

    public Cache() {
        cache = new HashMap<>();
    }

    public void put(final String key) {
        cache.put(key, new SoftReference<>(getFromFile(key)));
    }

    public byte[] get(final String key) {
        final Optional<SoftReference<byte[]>> optionalValue = Optional.of(cache.get(key));
        if (optionalValue.isPresent()) {
            final byte[] value = cache.get(key).get();
            return value != null ? value : findFromFileAndPutToCache(key);
        } else {
            return findFromFileAndPutToCache(key);
        }
    }

    private byte[] getFromFile(final String string) {
        final Path path = Paths.get(string);
        try {
            return Files.readAllBytes(path);
        } catch (final IOException e) {
            throw new IllegalArgumentException("Incorrect parameters");
        }
    }

    private byte[] findFromFileAndPutToCache(final String key) {
        final byte[] fromFile = getFromFile(key);
        cache.put(key, new SoftReference<>(fromFile));
        return fromFile;
    }

    public Map<String, SoftReference<byte[]>> getCache() {
        return cache;
    }
}
