package homework5.task29;

/**
 * Created by koval on 05.01.2017.
 */
public class AvlTree<K extends Comparable<? super K>, V> {

    private Entry<K, V> root;
    private int size;

    public V get(final K key) {
        if (root == null) {
            return null;
        } else {
            return getValue(root, key);
        }
    }

    private V getValue(final Entry<K, V> entry, final K key) {

        if (key.compareTo(entry.key) > 0) {
            return getValue(entry.right, entry.right.key);
        } else if (key.compareTo(entry.key) < 0) {
            return getValue(entry.left, entry.left.key);
        } else {
            return entry.value;
        }
    }

    public int size() {
        return size;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> left;
        private Entry<K, V> right;
        private Entry<K, V> parent;

        public Entry(K key, V value, Entry<K, V> left, Entry<K, V> right, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
