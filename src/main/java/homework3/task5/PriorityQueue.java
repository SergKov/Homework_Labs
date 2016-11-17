package homework3.task5;

import java.util.*;

/**
 * Created by koval on 12.11.2016.
 */
public class PriorityQueue<E> implements Iterable<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    private E[] queue;
    private int numberOfItems;
    private Comparator<E> comparator;

    public PriorityQueue() {
        queue = (E[]) new Comparable[DEFAULT_INITIAL_CAPACITY];
        numberOfItems = 0;
    }

    public PriorityQueue(int capacity) {
        validate(capacity);
        this.numberOfItems = capacity;
        queue = (E[]) new Comparable[capacity];
    }

    public PriorityQueue(Comparator<E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public PriorityQueue(int capacity, Comparator<E> comparator) {
        validate(capacity);
        this.comparator = comparator;
        queue = (E[]) new Comparable[capacity];
    }

    private void validate(final int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity can not by less than one");
        }
    }

    public void offer(final E e) {
        if (e == null) {
            throw new IllegalArgumentException("Null can not be in the PriorityQueue");
        }
        insert(e);
    }

    private void insert(final E e) {
        if (numberOfItems == queue.length - 1) {
            resize();
        }

        queue[++numberOfItems] = e;
        swim(numberOfItems);
    }

    private void resize() {
        if (numberOfItems < 64) {
            queue = Arrays.copyOf(queue, numberOfItems + numberOfItems + 2);
        } else {
            queue = Arrays.copyOf(queue, numberOfItems + numberOfItems / 2);
        }
    }

    private void swim(int countElement) {
        while (countElement > 1 && greater(countElement / 2, countElement)) {
            exch(countElement, countElement / 2);
            countElement = countElement / 2;
        }
    }

    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<E>)queue[i]).compareTo(queue[j]) > 0;
        } else {
            return comparator.compare(queue[i], queue[j]) > 0;
        }
    }

    private void exch(final int i, final int j) {
        final E swap = queue[i];
        queue[i] = queue[j];
        queue[j] = swap;
    }

    public E poll() {
        if (numberOfItems > 0) {
            final E oldElem = queue[1];
            queue[1] = queue[numberOfItems];
            queue[numberOfItems] = null;
            numberOfItems--;
            sink(1);
            return oldElem;
        } else {
            return null;
        }
    }

    private void sink(int sang) {

        while (2 * sang <= numberOfItems) {

            int index = 2 * sang;

            if (index < numberOfItems && greater(index, index + 1)) {
                index++;
            }

            if (!greater(sang, index)) {
                break;
            }

            exch(sang, index);
            sang = index;
        }
    }

    public E peek() {
        return numberOfItems > 0 ? queue[1] : null;
    }

    public boolean contains(final E e) {
        if (queue.length > 1) {
            if (comparator == null) {
                if (((Comparable<E>)queue[1]).compareTo(e) > 0) {
                    return false;
                }
            }
        } else {
            if (comparator.compare(queue[1], e) > 0) {
                return false;
            }
        }

        return Arrays.asList(queue).contains(e);
    }

    public void clear() {
        Arrays.stream(queue).forEach(elem -> elem = null);
        numberOfItems = 0;
    }

    @Override
    public Iterator<E> iterator() {
        class QueueItr<E> implements Iterator<E> {
            private int count;

            @Override
            public boolean hasNext() {
                return count < numberOfItems;
            }

            @Override
            public E next() {
                if (count > numberOfItems) {
                    throw new NoSuchElementException(" Size : " + numberOfItems);
                } else {
                    return (E) queue[++count];
                }
            }
        }
        return new QueueItr<E>();
    }

    public int size() {
        return numberOfItems;
    }
}
