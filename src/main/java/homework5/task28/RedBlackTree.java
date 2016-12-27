package homework5.task28;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by Sergey on 13.12.1992.
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
        Node<K, V> parent;

        int cmp;

        do {
            parent = node;
            cmp = compare(key, node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.setValue(value);
            }
        } while (node != null);

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
                    setColor(node.parent.parent, RED);
                    rightRotate(node.parent.parent);
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

        if (node != null) {

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

        if (node != null) {

            final Node<K, V> leftNode = node.left;
            node.left = leftNode.right;

            if (leftNode.right != null) {
                leftNode.right.parent = node;
            }

            leftNode.parent = node.parent;

            if (node.parent == null) {
                root = leftNode;
            } else if (node.parent.right == node) {
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

        int cmp;

        while (node != null) {

            cmp = compare(key, node.key);

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

        final Node<K,V> node = getNode(key);

        if (node == null) {
            return null;
        }

        final V oldValue = node.value;

        deleteNode(node);

        return oldValue;
    }

    private void deleteNode(Node<K,V> node) {

        size--;

        if (node.left != null && node.right != null) {
            Node<K,V> s = successor(node);
            node.key = s.key;
            node.value = s.value;
            node = s;
        }

        final Node<K,V> replacement = (node.left != null ? node.left : node.right);

        if (replacement != null) {
            replacement.parent = node.parent;
            if (node.parent == null) {
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left  = replacement;
            } else {
                node.parent.right = replacement;
            }

            node.parent = null;
            node.right = null;
            node.left = null;

            if (node.color == BLACK) {
                fixAfterDeletion(replacement);
            }

        } else if (node.parent == null) {
            root = null;
        } else {

            if (node.color == BLACK) {
                fixAfterDeletion(node);
            }


            if (node.parent != null) {

                if (node == node.parent.left) {
                    node.parent.left = null;
                } else if (node == node.parent.right) {
                    node.parent.right = null;
                }

                node.parent = null;
            }
        }
    }

    private void fixAfterDeletion(Node<K,V> node) {
        while (node != root && colorOf(node) == BLACK) {
            if (node == node.parent.left) {
                Node<K,V> sib = node.parent.right;

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(node.parent, RED);
                    leftRotate(node.parent);
                    sib = node.parent.right;
                }

                if (colorOf(sib.left)  == BLACK && colorOf(sib.right) == BLACK) {
                    setColor(sib, RED);
                    node = node.parent;
                } else {
                    if (colorOf(sib.right) == BLACK) {
                        setColor(sib.left, BLACK);
                        setColor(sib, RED);
                        rightRotate(sib);
                        sib = node.parent.right;
                    }
                    setColor(sib, colorOf(node.parent));
                    setColor(node.parent, BLACK);
                    setColor(sib.right, BLACK);
                    leftRotate(node.parent);
                    node = root;
                }
            } else {
                Node<K,V> sib = node.parent.left;

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(node.parent, RED);
                    rightRotate(node.parent);
                    sib = node.parent.left;
                }

                if (colorOf(sib.right) == BLACK && colorOf(sib.left) == BLACK) {
                    setColor(sib, RED);
                    node = node.parent;
                } else {
                    if (colorOf(sib.left) == BLACK) {
                        setColor(sib.right, BLACK);
                        setColor(sib, RED);
                        rightRotate(sib);
                        sib = node.parent.left;
                    }
                    setColor(sib, colorOf(node.parent));
                    setColor(node.parent, BLACK);
                    setColor(sib.left, BLACK);
                    rightRotate(node.parent);
                    node = root;
                }
            }
        }

        setColor(node, BLACK);
    }

    private Node<K,V> successor(Node<K,V> node) {
        if (node == null) {
            return null;
        } else if (node.right != null) {

            Node<K,V> rightNode = node.right;

            while (rightNode.left != null) {
                rightNode = rightNode.left;
            }

            return rightNode;
        } else {
            Node<K,V> nodeParent = node.parent;
            Node<K,V> nodeChild = node;
            while (nodeParent != null && nodeChild == nodeParent.right) {
                nodeChild = nodeParent;
                nodeParent = nodeParent.parent;
            }
            return nodeParent;
        }
    }

    public Node<K,V> getNode(final K key) {

        Node<K,V> node = root;

        int cmp;

        while (node != null) {

            cmp = compare(key, node.key);

            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private V putRoot(final K key, final V value) {
        root = new Node<>(key, value, null);
        return null;
    }

    private boolean colorOf(final Node<K, V> node) {
        return (node == null ? BLACK : node.color);
    }

    private void setColor(final Node<K, V> node, final boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    private static class Node<K, V> {
        K key;
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

        public V setValue(final V value) {
            final V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }


}
