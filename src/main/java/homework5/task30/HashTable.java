package homework5.task30;

import java.util.Arrays;

/**
 * Created by koval on 10.12.2016.
 */
public class HashTable<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private float loadFactor;
    private int size;
    private int threshold;
    private Entry<K, V>[] table;

    public HashTable() {
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.threshold = (int) (capacity * loadFactor);
    }

    public V put(final K key, final V value) {
        if (size > threshold) {
            resizeTable();
        }
        return putToHashTable(key, value, table);
    }

    public V get(final K key) {
        final Entry<K, V> entry = findEntry(key);
        return entry != null ? entry.value : null;
    }

    public V remove(final K key) {
        return removeEntry(key);
    }

    private V removeEntry(final K key) {

        for (int i = 0; i < table.length; i++) {

            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                Entry<K, V> entryPrev = null;

                while (entry != null) {

                    final Entry<K, V> entryNext = entry.next;

                    if (entry.key.equals(key)) {
                        if (entryPrev != null) {
                            entryPrev.next = entryNext;
                        } else {
                            table[i] = entryNext;
                        }
                        size--;
                        return entry.value;
                    }
                    entryPrev = entry;
                    entry = entry.next;
                }
            }
        }
        return null;
    }

    private Entry<K, V> findEntry(final K key) {

        for (int i = 0; i < table.length; i++) {

            if (table[i] != null) {
                Entry<K, V> entry = table[i];

                while (entry != null) {

                    if (entry.key.equals(key)) {
                        return entry;
                    }
                    entry = entry.next;
                }
            }
        }
        return null;
    }

    private V putToHashTable(final K key, final V value, final Entry<K, V>[] table) {

        if (key == null) {
            return putNullKey(key, value, table);
        }

        final int positionToInsert = Math.abs(key.hashCode() % table.length);
        Entry<K, V> entry = table[positionToInsert];

        if (entry == null) {
            return putToHashTableIfEntryNull(key, value, table, positionToInsert);
        }

        V prev = null;
        Entry<K, V> prevNode = null;

        while (entry != null) {
            if (entry.key.equals(key)) {
                prev = entry.value;
                entry.value = value;
                return prev;
            }
            prevNode = entry;
            entry = entry.next;
        }

        prevNode.next = new Entry<>(key.hashCode(), key, value, null);
        size++;
        return prev;
    }


    private V putToHashTableIfEntryNull(final K key, final V value, final Entry<K, V>[] table, int positionToInsert) {
        table[positionToInsert] = new Entry<>(key.hashCode(), key, value, null);
        size++;
        return null;
    }

    private V putNullKey(final K key, final V value, final Entry<K, V>[] table) {

        if (table[0] != null) {

            Entry<K, V> entry = table[0];
            V prev = null;
            Entry<K, V> prevNode = null;

            while (entry != null) {
                if (entry.key == null) {
                    prev = entry.value;
                    entry.value = value;
                    return prev;
                }
                prevNode = entry;
                entry = entry.next;
            }

            prevNode.next = new Entry<>(0, key, value, null);
            size++;
            return prev;
        }

        table[0] = new Entry<>(0, key, value, null);
        size++;
        return null;

    }

    private void resizeTable() {
        size = 0;
        capacity *= 2;
        threshold = (int) (capacity * loadFactor);
        final Entry<K, V>[] newTable = new Entry[capacity];

        Arrays.stream(table).forEach(entry -> {
            if (entry != null) {
                putToHashTable(entry.key, entry.value, newTable);
                while (entry.next != null) {
                    putToHashTable(entry.next.key, entry.next.value, newTable);
                    entry = entry.next;
                }
            }
        });

        this.table = newTable;
    }


    public int size() {
        return size;
    }

    static class Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


}
