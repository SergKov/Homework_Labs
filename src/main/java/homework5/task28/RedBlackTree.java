package homework5.task28;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by koval on 13.12.2016.
 */
public class RedBlackTree<K, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private final Comparator<? super K> comparator;

    private Node<K, V> root;
    private int size;

    public RedBlackTree() {
        comparator = null;
    }

    public RedBlackTree(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    public V put(final K key, final V value) {

        if (root == null) {
            size++;
            return putRoot(key, value);
        }

        Node<K, V> node = root;
        Node<K, V> parent = null;
        V prevElem;

        while (node != null) {

            final int cmp = compare(key, node.key);

            if (cmp == 0) {
                prevElem = node.value;
                node.value = value;
                return prevElem;
            } else if (cmp < 0) {

                if (node.left != null) {
                    parent = node;
                    node = node.left;
                } else {
                    node.left = new Node<>(key, value, node);
                    insert(node.left);
                    size++;
                    return null;
                }

            } else {

                if (node.right != null) {
                    parent = node;
                    node = node.right;
                } else {
                    node.right = new Node<>(key, value, node);
                    insert(node.right);
                    size++;
                    return null;
                }
            }
        }

        final int cmp = compare(key, parent.key);
        final Node<K, V> insertNode = new Node<>(key, value, parent);
        if (cmp < 0) {
            parent.left = insertNode;
        } else {
            parent.right = insertNode;
        }
        insert(insertNode);
        size++;
        return null;
    }

    private void insert(Node<K, V> node) {

        node.color = RED;

        while (node != null && node != root && node.parent.color == RED) {

            if (node.parent == node.parent.parent.left) {

                final Node<K, V> rightGrantParentNode = node.parent.parent.right;

                if (colorOf(rightGrantParentNode) == RED) {
                    setColor(node.parent, BLACK);
                    setColor(rightGrantParentNode, BLACK);
                    setColor(node.parent.parent, RED);
                    node = node.parent.parent;
                } else {

                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }

                    setColor(node.parent, BLACK);
                    node.parent.parent.color = RED;
                    rightRotate(node);
                }

            } else {

                final Node<K, V> leftGrantParentNode = node.parent.parent.left;
                if (colorOf(node) == RED) {
                    setColor(node.parent, BLACK);
                    setColor(leftGrantParentNode, BLACK);
                    setColor(node.parent.parent, RED);
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    setColor(node.parent, BLACK);
                    setColor(node.parent.parent, RED);
                    leftRotate(node.parent.parent);
                }
            }
        }

        root.color = BLACK;
    }

    private void leftRotate(final Node<K, V> node) {

        if (node != null && node.right != null) {

            final Node<K, V> rightNode = node.right;
            node.right = rightNode.left;

            if (rightNode.left != null) {
                rightNode.left.parent = node;
            }

            rightNode.parent = node.parent;

            if (node.parent == null) {
                root = rightNode;
            } else if (node.parent.left == node) {
                node.parent.left = rightNode;
            } else {
                node.parent.right = rightNode;
            }

            rightNode.left = node;
            node.parent = rightNode;

        }
    }

    private void rightRotate(final Node<K, V> node) {

        if (node != null && node.left != null) {

            final Node<K, V> leftNode = node.left;
            node.left = leftNode.right;

            if (leftNode.right != null) {
                leftNode.right.parent = node;
            }

            leftNode.parent = node.right;

            if (node.parent == null) {
                root = leftNode;
            } else if (leftNode.parent != null && node.parent.right == leftNode) {
                node.parent.right = node;
            } else {
                node.parent.left = leftNode;
            }

            leftNode.right = node;
            node.parent = leftNode;
        }

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

    private V putRoot(final K key, final V value) {
        root = new Node<>(key, value, null);
        return null;
    }

    private boolean colorOf(final Node<K,V> node) {
        return (node == null ? BLACK : node.color);
    }

    private void setColor(final Node<K,V> node, final boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;
        boolean color = BLACK;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }


}
