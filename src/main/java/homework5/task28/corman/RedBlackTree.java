package homework5.task28.corman;

import org.jetbrains.annotations.Nullable;

/**
 * Created by koval on 04.03.2017.
 */
public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Entry root;
    private final Entry nil;
    private int size;

    @SuppressWarnings("unchecked")
    public RedBlackTree() {
        nil = new Entry(null, null);
        nil.parent = nil.left = nil.right = nil;
        nil.color = BLACK;
        root = nil;
    }

    public V put(final K key, final V value) {
        final Entry<K, V> newEntry = new Entry<>(key, value);
        return insert(newEntry);
    }

    @Nullable
    private V insert(final Entry<K, V> newEntry) {
        Entry<K, V> tempRoot = root;
        Entry<K, V> tempParent = nil;

        while (tempRoot != nil) {
            tempParent = tempRoot;
            final int cmp = newEntry.key.compareTo(tempRoot.key);
            if (cmp < 0) {
                tempRoot = tempRoot.left;
            } else if (cmp > 0) {
                tempRoot = tempRoot.right;
            } else {
                final V oldValue = tempRoot.value;
                tempRoot.value = newEntry.value;
                return oldValue;
            }
        }
        newEntry.parent = tempParent;

        if (tempParent == nil) {
            root = newEntry;
        } else {
            if (newEntry.key.compareTo(tempParent.key) < 0) {
                tempParent.left = newEntry;
            } else {
                tempParent.right = newEntry;
            }
        }
        newEntry.left = nil;
        newEntry.right = nil;
        newEntry.color = RED;
        insertFixup(newEntry);
        size++;
        return null;
    }

    private void insertFixup(Entry<K, V> newEntry) {
        while (newEntry.parent.color == RED) {
            if (newEntry.parent == newEntry.parent.parent.left) {
                final Entry<K, V> temp = newEntry.parent.parent.right;
                if (temp.color == RED) {
                    newEntry.parent.color = BLACK;
                    temp.color = BLACK;
                    newEntry.parent.parent.color = RED;
                    newEntry = newEntry.parent.parent;
                } else {
                    if (newEntry == newEntry.parent.right) {
                        newEntry = newEntry.parent;
                        leftRotate(newEntry);
                    }
                    newEntry.parent.color = BLACK;
                    newEntry.parent.parent.color = RED;
                    rightRotate(newEntry.parent.parent);
                }
            } else {
                final Entry<K, V> temp = newEntry.parent.parent.left;
                if (temp.color == RED) {
                    newEntry.parent.color = BLACK;
                    temp.color = BLACK;
                    newEntry.parent.parent.color = RED;
                    newEntry = newEntry.parent.parent;
                } else {
                    if (newEntry == newEntry.parent.left) {
                        newEntry = newEntry.parent;
                        rightRotate(newEntry);
                    }
                    newEntry.parent.color = BLACK;
                    newEntry.parent.parent.color = RED;
                    leftRotate(newEntry.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    private void leftRotate(final Entry<K, V> entry) {
        final Entry<K, V> temp = entry.right;
        entry.right = temp.left;

        if (temp.left != nil) {
            temp.left.parent = entry;
        }
        temp.parent = entry.parent;

        if (entry.parent == nil) {
            root = temp;
        } else if (entry == entry.parent.left) {
            entry.parent.left = temp;
        } else {
            entry.parent.right = temp;
        }
        temp.left = entry;
        entry.parent = temp;
    }

    private void rightRotate(final Entry<K, V> entry) {
        final Entry<K, V> temp = entry.left;
        entry.left = temp.right;

        if (temp.right != nil) {
            temp.right.parent = entry;
        }
        temp.parent = entry.parent;

        if (entry.parent == nil) {
            root = temp;
        } else if (entry.parent.right == entry) {
            entry.parent.right = temp;
        } else {
            entry.parent.left = temp;
        }
        temp.right = entry;
        entry.parent = temp;
    }

    public V get(final K key) {
        final Entry<K, V> searchEntry = search(key);
        return searchEntry != null ? searchEntry.value : null;
    }

    @Nullable
    private Entry<K, V> search(final K key) {
        Entry<K, V> temp = root;
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
        final Entry<K, V> oldEntry = search(key);
        return oldEntry != null ? delete(oldEntry) : null;
    }

    private V delete(Entry<K, V> oldEntry) {
        Entry<K, V> deleteEntry = oldEntry;
        Entry<K, V> temp;

        boolean deleteOriginalColor = deleteEntry.color;
        if (oldEntry.left == nil) {
            temp = oldEntry.right;
            transplant(oldEntry, oldEntry.right);
        } else if (oldEntry.right == nil) {
            temp = oldEntry.left;
            transplant(oldEntry, oldEntry.left);
        } else {
            deleteEntry = treeMinimum(oldEntry.right);
            deleteOriginalColor = deleteEntry.color;
            temp = deleteEntry.right;

            if (deleteEntry.parent == oldEntry) {
                temp.parent = deleteEntry;
            } else {
                transplant(deleteEntry, deleteEntry.right);
                deleteEntry.right = oldEntry.right;
                deleteEntry.right.parent = deleteEntry;
            }

            transplant(oldEntry, deleteEntry);
            deleteEntry.left = oldEntry.left;
            deleteEntry.left.parent = deleteEntry;
            deleteEntry.color = oldEntry.color;
        }

        if (deleteOriginalColor == BLACK) {
            deleteFixUp(temp);
        }
        size--;
        return deleteEntry.value;
    }

    private void deleteFixUp(Entry<K, V> entry) {
        while (entry != root && !entry.color) {
            if (entry == entry.parent.left) {
                Entry<K, V> temp = entry.parent.right;
                if (temp.color) {
                    temp.color = BLACK;
                    entry.parent.color = RED;
                    leftRotate(entry.parent);
                    temp = entry.parent.right;
                }
                if (!temp.left.color && !temp.right.color) {
                    temp.color = RED;
                    entry = entry.parent;
                } else {
                    if (!temp.right.color) {
                        temp.left.color = BLACK;
                        temp.color = RED;
                        rightRotate(entry);
                        temp = entry.parent.right;
                    }
                    temp.color = entry.parent.color;
                    entry.parent.color = BLACK;
                    temp.right.color = BLACK;
                    leftRotate(entry.parent);
                    entry = root;
                }
            } else {
                Entry<K, V> temp = entry.parent.right;
                if (temp.color) {
                    temp.color = BLACK;
                    entry.parent.color = RED;
                    rightRotate(entry.parent);
                    temp = entry.parent.left;
                }
                if (!temp.right.color && !temp.left.color) {
                    temp.color = RED;
                    entry = entry.parent;
                } else {
                    if (!temp.right.color) {
                        temp.right.color = BLACK;
                        temp.color = RED;
                        leftRotate(entry);
                        temp = entry.parent.left;
                    }
                    temp.color = entry.parent.color;
                    entry.parent.color = BLACK;
                    temp.left.color = BLACK;
                    rightRotate(entry.parent);
                    entry = root;
                }
            }
        }
    }

    private Entry treeMinimum(Entry<K, V> entry) {
        while (entry.left != nil) {
            entry = entry.left;
        }
        return entry;
    }

    private void transplant(final Entry<K, V> oldEntry, final Entry<K, V> newEntry) {
        if (oldEntry.parent == nil) {
            root = newEntry;
        } else if (oldEntry == oldEntry.parent.left) {
            oldEntry.parent.left = newEntry;
        } else {
            oldEntry.parent.right = newEntry;
        }
        oldEntry.parent = newEntry.parent;
    }

    public boolean contains(final K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    protected int getHeight() {
        int height = 0;
        Entry<K, V> temp = root;
        while (temp != nil) {
            height++;
            temp = temp.right;
        }
        return height;
    }

    private class Entry<K extends Comparable<K>, V> {
        private K key;
        private V value;
        private Entry<K, V> parent;
        private Entry<K, V> left;
        private Entry<K, V> right;
        private boolean color;

        public Entry(K key, V value) {
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
