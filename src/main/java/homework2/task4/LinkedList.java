package homework2.task4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Created by koval on 10.11.2016.
 */
public class LinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedList() {
    }

    public LinkedList(Collection<E> c) {
        addAll(c);
    }

    public void addAll(final Collection<E> c) {
        c.forEach(this::add);
    }

    public boolean add(final E elem) {

        if (size == 0) {
            first = new Node<>(elem, null, null);
            last = first;
            size++;
        } else {
            add(size, elem);
        }

        return true;
    }

    public void add(final int index, final E elem) {

        checkIndexIsInBoundsIsEqualsToSize(index);

        if (index == 0) {
            addFirst(elem);
        } else if (index == size) {
            addLast(elem);
        } else {
            insertInTheMiddle(index, elem);
        }
    }

    private boolean checkIndexIsInBoundsIsEqualsToSize(final int index) {
        if (index != size) {
            checkPositionIndex(index);
        }
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(final E elem) {
        final Node<E> oldFirst = first;
        first = new Node<>(elem, oldFirst, null);
        oldFirst.prev = first;
        size++;
    }


    public void addLast(final E elem) {
        final Node<E> oldLast = last;
        last = new Node<>(elem, null, oldLast);
        oldLast.next = last;
        size++;
    }

    private void insertInTheMiddle(final int index, final E elem) {
        final Node<E> prevNode = getNode(index - 1);
        final Node<E> current = getNode(index);
        final Node<E> inserted = new Node<>(elem, current, prevNode);
        prevNode.next = inserted;
        current.prev = inserted;
        size++;
    }

    public boolean addAll(final int index, final Collection<E> c) {

        checkIndexIsInBoundsIsEqualsToSize(index);

        c.forEach(this::add);

        return true;
    }

    public void clear() {
        first = new Node<>(null, null, null);
        last = first;
        size = 0;
    }

    public boolean contains(final Object o) {
        Node<E> temp = first;
        while (temp != null) {
            final E elem = temp.element;
            if (isNullElements(elem, o)) {
                return true;
            } else {
                if (elem.equals(o)) {
                    return true;
                } else {
                    temp = temp.next;
                }
            }
        }
        return false;
    }

    public int indexOf(final Object o) {
        if (!this.contains(o)) {
            return -1;
        } else {
            return findFirstIndex(o);
        }
    }

    private int findFirstIndex(final Object o) {
        Node<E> temp = first;
        int index = 0;

        while (temp != null) {
            final E elem = temp.element;
            if (isNullElements(elem, o)) {
                return index;
            } else {
                if (elem.equals(o)) {
                    return index;
                } else {
                    temp = temp.next;
                }
            }
            index++;
        }

        return index;
    }

    public int lastIndexOf(final Object o) {
        if (!this.contains(o)) {
            return -1;
        } else {
            return findLastIndex(o);
        }
    }

    private int findLastIndex(final Object o) {
        Node<E> temp = first;
        int index = 0;
        int lastPos = 0;

        while (temp != null) {
            final E elem = temp.element;

            if (isNullElements(elem, o)) {
                lastPos = index;
            } else {
                if (temp.element.equals(o)) {
                    lastPos = index;
                }
            }
            index++;
            temp = temp.next;
        }

        return lastPos;
    }

    public E remove(final int index) {
        checkPositionIndex(index);

        if (this.isEmpty()) {
            return null;
        } else {
            if (index == 0) {
                final Node<E> oldFirst = first;
                first = first.next;
                size--;
                return oldFirst.element;
            } else if (index == size - 1) {
                final Node<E> oldLast = last;
                last = last.prev;
                size--;
                return oldLast.element;
            } else {
                final Node<E> removedNode = getNode(index);
                final Node<E> prevNode = getNode(index - 1);
                prevNode.next = removedNode.next;
                size--;
                return removedNode.element;
            }
        }
    }

    public boolean remove(final Object o) {
        if (this.isEmpty()) {
            return false;
        } else {
            Node<E> start = first;
            while (start != null) {
                final E elem = start.element;
                if (isNullElements(elem, o)) {
                    start.prev = start.next;
                    size--;
                    return true;
                } else if (elem.equals(o)) {
                    start.prev = start.next;
                    start.next = start.prev;
                    size--;
                    return true;
                } else {
                    start = start.next;
                }
            }
        }
        return false;
    }

    public E get(final int index) {
        checkPositionIndex(index);
        return getNode(index).element;
    }

    private Node<E> getNode(final int index) {
        if (index < size / 2) {
            Node<E> tempFirst = first;

            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    return tempFirst;
                } else {
                    tempFirst = tempFirst.next;
                }
            }

            return tempFirst;

        } else {
            Node<E> tempLast = last;

            for (int i = size - 1; i >= index; i--) {
                if (i == index) {
                    return tempLast;
                } else {
                    tempLast = tempLast.prev;
                }
            }

            return tempLast;
        }
    }


    public void set(final int index, final E elem) {
        checkPositionIndex(index);
        final Node<E> current = getNode(index);
        current.element = elem;
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        final Object[] array = new Object[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = this.get(i);
        }
        return array;
    }

    public <T> T[] toArray(final T[] array, final Class<T> clazz) {

        if (size > 0) {

            if (array.length < size) {
                throw new IllegalArgumentException("Array's size is less than list");
            }

            if (!clazz.isInstance(first.element)) {
                throw new ArrayStoreException("This type is not compatible");
            }

            int i = 0;
            Node<E> node = first;
            while (node != null) {
                array[i] = clazz.cast(node.element);
                i++;
                node = node.next;
            }
        }

        return array;
    }

    private void checkPositionIndex(final int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    private boolean isNullElements(final Object first, final Object second) {
        return first == null && second == null;
    }

    private boolean isPositionIndex(final int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundMsg(final int index) {
        return " Index : " + index + ", Size : " + size;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
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
                } else if (nextIndex > 0) {
                    current = current.next;
                }
                nextIndex++;
                return current.element;
            }
        }

        return new ListItr();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        if (first != null) {
            Node<E> current = first;
            while (current != null) {
                action.accept(current.element);
                current = current.next;
            }
        }
    }
}
