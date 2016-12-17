package homework5.task28;

import sun.invoke.empty.Empty;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by koval on 13.12.2016.
 */
public class RedBlackTree<K, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node<K, V> root;
    private int size;

    private Comparator<K> comparator;

    public RedBlackTree() { }

    public RedBlackTree(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public V put(final K key, final V value) {
        if (root == null) {
            putRoot(key, value);
            size++;
        } else {
            Node<K, V> node = root;

            while (true) {

                final int cmp = compare(key, node.key);

                if (cmp == 0) {
                    node.value = value;
                    return value;
                } else if (cmp < 0) {
                    if (node.left == null) {
                        node.left = new Node<>(key, value, node, null, null);

                    }
                }
            }

        }


        return null;
    }

    private void adjustAfterInsertion(Node<K, V> node) {

//        node.color = RED;
//
//        while (true) {
//            if (node != root && isRed(node.parent)) {
//                node.parent.color = BLACK;
//                node.parent.left =
//                adjustAfterInsertion(node.left);
//                siblingOf(parentOf(node)).color = BLACK;
//                grandparentOf(node).color = RED;
//            } else if (parentOf(node).equals(leftOf(grandparentOf(node))))
//        }
    }

    public V get(final K key) {
        return get(root, key);
    }

    private V get(Node<K, V> node, final K key) {

        while (node != null) {

            final int cmp = compare(key, node.key);

            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    private int compare(final K key, final K compare) {
        return comparator == null ? ((Comparable<K>) key).compareTo(compare) : comparator.compare(key, compare);
    }

    public boolean contains(final K key) {
        return get(key) != null;
    }

    public V remove(final K key) {
        //TODO
        return null;
    }

    public int size() {
        return size;
    }

    private boolean isRed(final Node node) {
        return node != null && node.color == RED;
    }

    private Node parentOf(final Node<K, V> node) {
        return node == null ? null : node.parent;
    }

    private Node grandparentOf(final Node<K, V> node) {
        return (node == null || node.parent == null) ? null : node.parent.parent;
    }

    private Node siblingOf(final Node<K, V> node) {
        if (node == null || node.parent == null) {
            return null;
        } else if (node == node.parent.left) {
            return node.parent.right;
        } else {
            return node.parent.left;
        }
    }

    private Node leftOf(final Node<K, V> node) {
        return node == null ? null : node.left;
    }

    private Node rightOf(final Node<K, V> node) {
        return node == null ? null : node.right;
    }

    private void putRoot(final K key, final V value) {
        root = new Node<>(key, value, null, null, null);
    }

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;
        boolean color = BLACK;

        public Node(K key, V value, Node<K, V> parent, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }


}
