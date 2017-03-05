package homework5.task28.corman;

import org.jetbrains.annotations.Nullable;

/**
 * Created by koval on 04.03.2017.
 */
public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private final Node nil;
    private int size;

    @SuppressWarnings("unchecked")
    public RedBlackTree() {
        nil = new Node(null, null);
        nil.parent = nil.left = nil.right = nil;
        nil.color = BLACK;
        root = nil;
    }

    public V put(final K key, final V value) {
        final Node<K, V> newNode = new Node<>(key, value);
        return insert(newNode);
    }

    @Nullable
    private V insert(final Node<K, V> newNode) {
        Node<K, V> tempRoot = root;
        Node<K, V> tempParent = nil;

        while (tempRoot != nil) {
            tempParent = tempRoot;
            final int cmp = newNode.key.compareTo(tempRoot.key);
            if (cmp < 0) {
                tempRoot = tempRoot.left;
            } else if (cmp > 0) {
                tempRoot = tempRoot.right;
            } else {
                final V oldValue = tempRoot.value;
                tempRoot.value = newNode.value;
                return oldValue;
            }
        }
        newNode.parent = tempParent;

        if (tempParent == nil) {
            root = newNode;
        } else {
            if (newNode.key.compareTo(tempParent.key) < 0) {
                tempParent.left = newNode;
            } else {
                tempParent.right = newNode;
            }
        }
        newNode.left = nil;
        newNode.right = nil;
        newNode.color = RED;
        insertFixup(newNode);
        size++;
        return null;
    }

    private void insertFixup(Node<K, V> newNode) {
        while (newNode.parent.color == RED) {
            if (newNode.parent == newNode.parent.parent.left) {
                final Node<K, V> temp = newNode.parent.parent.right;
                if (temp.color == RED) {
                    newNode.parent.color = BLACK;
                    temp.color = BLACK;
                    newNode.parent.parent.color = RED;
                    newNode = newNode.parent.parent;
                } else {
                    if (newNode == newNode.parent.right) {
                        newNode = newNode.parent;
                        leftRotate(newNode);
                    }
                    newNode.parent.color = BLACK;
                    newNode.parent.parent.color = RED;
                    rightRotate(newNode.parent.parent);
                }
            } else {
                final Node<K, V> temp = newNode.parent.parent.left;
                if (temp.color == RED) {
                    newNode.parent.color = BLACK;
                    temp.color = BLACK;
                    newNode.parent.parent.color = RED;
                    newNode = newNode.parent.parent;
                } else {
                    if (newNode == newNode.parent.left) {
                        newNode = newNode.parent;
                        rightRotate(newNode);
                    }
                    newNode.parent.color = BLACK;
                    newNode.parent.parent.color = RED;
                    leftRotate(newNode.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    private void leftRotate(final Node<K, V> node) {
        final Node<K, V> temp = node.right;
        node.right = temp.left;

        if (temp.left != nil) {
            temp.left.parent = node;
        }
        temp.parent = node.parent;

        if (node.parent == nil) {
            root = temp;
        } else if (node == node.parent.left) {
            node.parent.left = temp;
        } else {
            node.parent.right = temp;
        }
        temp.left = node;
        node.parent = temp;
    }

    private void rightRotate(final Node<K, V> node) {
        final Node<K, V> temp = node.left;
        node.left = temp.right;

        if (temp.right != nil) {
            temp.right.parent = node;
        }
        temp.parent = node.parent;

        if (node.parent == nil) {
            root = temp;
        } else if (node.parent.right == node) {
            node.parent.right = temp;
        } else {
            node.parent.left = temp;
        }
        temp.right = node;
        node.parent = temp;
    }

    public V get(final K key) {
        final Node<K, V> searchNode = search(key);
        return searchNode != null ? searchNode.value : null;
    }

    @Nullable
    private Node<K, V> search(final K key) {
        Node<K, V> temp = root;
        while (temp != nil) {
            final int cmp = key.compareTo(temp.key);
            if (cmp < 0) {
                temp = temp.left;
            } else if (cmp > 0) {
                temp = temp.right;
            } else {
                return temp;
            }
        }
        return null;
    }

    @Nullable
    public V remove(final K key) {
        final Node<K, V> oldNode = search(key);
        return oldNode != null ? delete(oldNode) : null;
    }

    private V delete(Node<K, V> oldNode) {
        Node<K, V> deleteNode = oldNode;
        Node<K, V> temp;

        boolean deleteOriginalColor = deleteNode.color;
        if (oldNode.left == nil) {
            temp = oldNode.right;
            transplant(oldNode, oldNode.right);
        } else if (oldNode.right == nil) {
            temp = oldNode.left;
            transplant(oldNode, oldNode.left);
        } else {
            deleteNode = treeMinimum(oldNode.right);
            deleteOriginalColor = deleteNode.color;
            temp = deleteNode.right;

            if (deleteNode.parent == oldNode) {
                temp.parent = deleteNode;
            } else {
                transplant(deleteNode, deleteNode.right);
                deleteNode.right = oldNode.right;
                deleteNode.right.parent = deleteNode;
            }

            transplant(oldNode, deleteNode);
            deleteNode.left = oldNode.left;
            deleteNode.left.parent = deleteNode;
            deleteNode.color = oldNode.color;
        }

        if (deleteOriginalColor == BLACK) {
            deleteFixUp(temp);
        }
        size--;
        return deleteNode.value;
    }

    private void deleteFixUp(Node<K, V> node) {
        while (node != root && !node.color) {
            if (node == node.parent.left) {
                Node<K, V> temp = node.parent.right;
                if (temp.color) {
                    temp.color = BLACK;
                    node.parent.color = RED;
                    leftRotate(node.parent);
                    temp = node.parent.right;
                }
                if (!temp.left.color && !temp.right.color) {
                    temp.color = RED;
                    node = node.parent;
                } else {
                    if (!temp.right.color) {
                        temp.left.color = BLACK;
                        temp.color = RED;
                        rightRotate(node);
                        temp = node.parent.right;
                    }
                    temp.color = node.parent.color;
                    node.parent.color = BLACK;
                    temp.right.color = BLACK;
                    leftRotate(node.parent);
                    node = root;
                }
            } else {
                Node<K, V> temp = node.parent.right;
                if (temp.color) {
                    temp.color = BLACK;
                    node.parent.color = RED;
                    rightRotate(node.parent);
                    temp = node.parent.left;
                }
                if (!temp.right.color && !temp.left.color) {
                    temp.color = RED;
                    node = node.parent;
                } else {
                    if (!temp.right.color) {
                        temp.right.color = BLACK;
                        temp.color = RED;
                        leftRotate(node);
                        temp = node.parent.left;
                    }
                    temp.color = node.parent.color;
                    node.parent.color = BLACK;
                    temp.left.color = BLACK;
                    rightRotate(node.parent);
                    node = root;
                }
            }
        }
    }

    private Node treeMinimum(Node<K, V> node) {
        while (node.left != nil) {
            node = node.left;
        }
        return node;
    }

    private void transplant(final Node<K, V> oldNode, final Node<K, V> newNode) {
        if (oldNode.parent == nil) {
            root = newNode;
        } else if (oldNode == oldNode.parent.left) {
            oldNode.parent.left = newNode;
        } else {
            oldNode.parent.right = newNode;
        }
        oldNode.parent = newNode.parent;
    }

    public boolean contains(final K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    protected int getHeight() {
        int height = 0;
        Node<K, V> temp = root;
        while (temp != nil) {
            height++;
            temp = temp.right;
        }
        return height;
    }

    private class Node<K extends Comparable<K>, V> {
        private K key;
        private V value;
        private Node<K, V> parent;
        private Node<K, V> left;
        private Node<K, V> right;
        private boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.parent = nil;
            this.left = nil;
            this.right = nil;
            this.color = RED;
        }

        public V setValue(final V value) {
            final V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
