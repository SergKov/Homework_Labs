package homework3.task5;

import java.util.*;

/**
 * Created by koval on 12.11.2016.
 */
public class PriorityQueue<E extends Comparable<E>> implements Iterable<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    private E[] queue;
    private int capacity;
    private int size;
    private Comparator<E> comparator;

    public PriorityQueue() {
        queue = (E[]) new Comparable[DEFAULT_INITIAL_CAPACITY];
        capacity = DEFAULT_INITIAL_CAPACITY;
    }

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        queue = (E[]) new Comparable[capacity];
    }

    public PriorityQueue(Comparator<E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public PriorityQueue(int capacity, Comparator<E> comparator) {
        this.capacity = capacity;
        this.comparator = comparator;
        queue = (E[]) new Comparable[capacity];
    }

    public void offer(final E e) {
        if (e == null) {
            throw new IllegalArgumentException("Null can not be in the PriorityQueue");
        }
        insert(e);
    }

    private void insert(final E e) {
        if (capacity == size) {
            resize();
        }

        queue[size] = e;
        final int countElement = size;
        size++;

        swim(countElement);
    }

    private void resize() {

        if (capacity < 64) {
            capacity = capacity + (capacity + 2);
        } else {
            capacity = capacity + capacity / 2;
        }

        queue = Arrays.copyOf(queue, capacity);
    }

    private void swim(int countElement) {
        while (countElement > 1 && less(countElement / 2, countElement)) {
            exch(countElement, countElement / 2);
            countElement = countElement / 2;
        }
    }

    private boolean less(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<E>)queue[i]).compareTo(queue[j]) < 0;
        } else {
            return comparator.compare(queue[i], queue[j]) < 0;
        }
    }

    private void exch(final int i, final int j) {
        final E swap = queue[i];
        queue[i] = queue[j];
        queue[j] = swap;
    }

    public E poll() {
        if (size > 0) {
            final E oldElem = queue[size - 1];
            queue[size - 1] = null;
            size--;
            return oldElem;
        } else {
            return null;
        }
    }

    public E peek() {
        return size > 0 ? queue[size - 1] : null;
    }

    public boolean remove(final E e) {
        //TODO
        return false;
    }

    public boolean contains(final E e) {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            return queue[size - 1] == e;
        } else {
            return isBinarySearched(e);
        }
    }

    private boolean isBinarySearched(final E e) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (e.compareTo(queue[middle]) > 0) {
                right = middle - 1;
            } else if (e.compareTo(queue[middle]) < 0) {
                left = middle + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public void clear() {
        Arrays.stream(queue).forEach(elem -> elem = null);
        size = 0;
    }

    public Iterator<E> iterator() {
        class QueueItr<E> implements Iterator<E> {
            private int count;

            @Override
            public boolean hasNext() {
                return count < size - 1;
            }

            @Override
            public E next() {
                if (count > size) {
                    throw new NoSuchElementException(" Size : " + size);
                } else {
                    final E current = (E) queue[count];
                    count++;
                    return current;
                }
            }
        }
        return new QueueItr<E>();
    }

    public int size() {
        return size;
    }
}
