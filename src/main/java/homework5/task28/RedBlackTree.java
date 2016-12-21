package homework5.task28;

import java.util.Comparator;
import java.util.HashMap;

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
        V prevElem = null;

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
                    leftOf(node).color = RED;
                    insert(node);
                    size++;
                }

            } else {

                if (node.right != null) {
                    parent = node;
                    node = node.right;
                } else {
                    node.right = new Node<>(key, value, node);
                    rightOf(node).color = RED;
                    insert(node);
                    size++;
                }
            }
        }

        final int cmp = compare(key, parent.key);

        if (cmp < 0) {
            parent.left = new Node<>(key, value, parent);
            leftOf(parent).color = RED;
            insert(parent);
        } else {
            parent.right = new Node<>(key, value, parent);
            rightOf(parent).color = RED;
            insert(parent);
        }
        size++;
        return prevElem;
    }

    private void insert(Node<K, V> node) {

        while (parentOf(node).color == RED) {

            if (parentOf(node) == leftOf(grandparentOf(node))) {

                final Node<K, V> rightGrantParentNode = rightOf(grandparentOf(node));
                if (isRed(rightGrantParentNode)) {
                    parentOf(node).color = BLACK;
                    rightGrantParentNode.color = BLACK;
                    grandparentOf(node).color = RED;
                    node = grandparentOf(node);
                } else if (node == rightOf(parentOf(node))) {
                    node = parentOf(node);
                    leftRotate(node);
                } else {
                    parentOf(node).color = BLACK;
                    grandparentOf(node).color = RED;
                    rightRotate(node);
                }
            } else {

                final Node<K, V> leftGrantParentNode = leftOf(grandparentOf(node));
                if (isRed(leftGrantParentNode)) {
                    parentOf(node).color = BLACK;
                    leftGrantParentNode.color = BLACK;
                    grandparentOf(node).color = RED;
                    node = grandparentOf(node);
                } else if (node == leftOf(parentOf(node))) {
                    node = parentOf(node);
                    rightRotate(node);
                } else {
                    parentOf(node).color = BLACK;
                    grandparentOf(node).color = RED;
                    leftRotate(node);
                }
            }
        }
        root.color = BLACK;
    }

    private void leftRotate(final Node<K, V> node) {

        final Node<K, V> rightNode = rightOf(node);
        node.right = leftOf(rightNode);

        if (leftOf(rightNode) != null) {
            leftOf(rightNode).parent = node;
        }
        rightOf(node).parent = rightOf(node);

        if (node.parent == null) {
            root = rightNode;
        } else if (node.parent.left == node) {
            parentOf(node).left = rightNode;
        } else {
            parentOf(node).right = rightNode;
        }

        rightNode.left = node;
        node.parent = rightNode;
    }

    private void rightRotate(final Node<K, V> node) {

        final Node<K, V> leftNode = leftOf(node);
        node.left = rightOf(leftNode);

        if (rightOf(leftNode) != null) {
            rightOf(leftNode).parent = node;
        }
        rightOf(node).parent = rightOf(node);

        if (node.parent == null) {
            root = leftNode;
        } else if (parentOf(node).right == leftNode) {
            parentOf(leftNode).right = node;
        } else {
            parentOf(node).left = leftNode;
        }

        leftNode.right = node;
        node.parent = leftNode;
    }

    public V get(final K key) {
        return get(root, key);
    }

    private V get(Node<K, V> node, final K key) {

        while (node != null) {

            final int cmp = compare(key, node.key);

            if (cmp < 0) {
                node = leftOf(node);
            } else if (cmp > 0) {
                node = rightOf(node);
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

    private Node leftOf(final Node<K, V> node) {
        return node == null ? null : node.left;
    }

    private Node rightOf(final Node<K, V> node) {
        return node == null ? null : node.right;
    }

    private V putRoot(final K key, final V value) {
        root = new Node<>(key, value, null);
        return null;
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
