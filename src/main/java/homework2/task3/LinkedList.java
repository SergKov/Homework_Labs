package homework2.task3;

import java.util.*;

/**
 * Created by koval on 07.11.2016.
 */
public class LinkedList<E> implements Iterable {
    private Node<E> first;
    private int size;

    public LinkedList() { }

    public LinkedList(Collection<E> c) {
        addAll(c);
    }

    public boolean addAll(final Collection<E> c) {

        final int collectionSize = c.size();

        if (collectionSize == 0) {
            return false;
        }

        c.forEach(this::add);

        size += collectionSize;
        return true;
    }

    public E get(final int index) {

        checkPositionIndex(index);

        if (index == 0) {
            return first.value;
        } else {
            return getElement(index, first).value;
        }
    }

    public boolean add(final E elem) {
        if (first == null) {
            first = new Node<>(null, elem);
        } else {
            final Node<E> head = findHead(first);
            head.next = new Node<>(null, elem);
        }

        size++;
        return true;
    }

    private Node<E> findHead(final Node<E> first) {
        return first.next == null ? first : findHead(first.next);
    }

    public int size() {
        return size;
    }

    public boolean add(final int index, final E elem) {

        checkPositionIndex(index);

        if (index == size - 1) {
            final Node<E> head = findHead(first);
            head.next = new Node<>(null, elem);
        } else if (index == 0) {
            final Node<E> tail = first;
            tail.next = first;
            first = tail;
        } else {
            final Node<E> current = getElement(index, first);
            final Node<E> prev = getElement(index - 1, first);
            final Node<E> newNode = new Node<>(null, elem);
            newNode.next = current;
            prev.next = newNode;
        }

        size++;
        return true;
    }

    public boolean remove(final E elem) {
        if (!this.contains(elem)) {
            return false;
        } else {
            final Node<E> prevNode = findPrevNode(elem, first);
            if (prevNode == null) {
                first = first.next;
            } else {
                prevNode.next = prevNode.next.next;
            }
            size--;
            return true;
        }
    }

    private Node<E> findPrevNode(final E value, final Node<E> current) {
        if (current == null || current.next == null) {
            return null;
        } else {
            return value.equals(current.next.value) ? current : findPrevNode(value, current.next);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(final int index) {

        checkPositionIndex(index);

        Node<E> removedNode;
        if (index == 0) {
            removedNode = first;
            first = first.next;
        } else if (index == size - 1) {
            removedNode = findNodeByIndex(size - 1, first);
            final Node<E> newLastNode = findNodeByIndex(size - 2, first);
            newLastNode.next = null;
        } else {
            removedNode = findNodeByIndex(index, first);
            Node<E> prevNode = findNodeByIndex(index - 1, first);
            prevNode.next = prevNode.next.next;
        }

        size--;
        return removedNode.value;
    }

    private Node<E> findNodeByIndex(final int index, final Node<E> first) {
        return index == 0 ? first : findNodeByIndex(index - 1, first.next);
    }

    public boolean contains(final E e) {
        return containsValue(e, first);
    }

    private boolean containsValue(final E value, final Node<E> current) {

        if (current == null) {
            return false;
        }

        return current.value.equals(value) || containsValue(value, current.next);
    }

    public void set(final int index, final E elem) {
        checkPositionIndex(index);
        final Node<E> current = getElement(index, first);
        current.value = elem;
    }

    public int indexOf(final E elem) {
        if (!this.contains(elem)) {
            return -1;
        } else {
            return findIndexByElement(0, elem, first);
        }
    }

    private int findIndexByElement(final int index, final E elem, final Node<E> current) {
        return elem.equals(current.value) ? index : findIndexByElement(index + 1, elem, current.next);
    }

    private Node<E> getElement(final int index, final Node<E> node) {
        return index == 0 ? node : getElement(index - 1, node.next);
    }

    private void checkPositionIndex(final int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    private boolean isPositionIndex(final int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundMsg(final int index) {
        return " Index : " + index + ", Size : " + size;
    }

    @Override
    public Iterator<E> iterator() {

        class ListItr implements Iterator<E> {
            private Node<E> current = first;
            private int nextIndex;

            @Override
            public boolean hasNext() {
                return nextIndex < size - 1;
            }

            @Override
            public E next() {
                if (nextIndex == size) {
                    throw new NoSuchElementException(" Size : " + size);
                } else if (nextIndex == 0) {
                    nextIndex++;
                    return current.value;
                } else {
                    current = current.next;
                    nextIndex++;
                    return current.value;
                }
            }
        }

        return new ListItr();
    }

    private class Node<E> {
        private Node<E> next;
        private E value;

        public Node(Node<E> next, E value) {
            this.next = next;
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }
}
