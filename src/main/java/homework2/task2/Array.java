package homework2.task2;

import java.util.Arrays;

/**
 * Created by koval on 10.11.2016.
 */
public class Array<E extends Number> {

    private Element<E>[] array;

    public Array() {
        array = new Element[10];
    }

    public Array(Element<E>[] array) {
        this.array = array;
    }

    public void print() {
        System.out.println(toString());
    }

    public void add(final Element<E>[] other) {
        checkArraysSize(other);
        for (int i = 0; i < array.length; i++) {
            final Double sum = array[i].element.doubleValue() + other[i].element.doubleValue();
            array[i].setElement((E)sum);
        }
    }

    public void minus(final Element<E>[] other) {
        checkArraysSize(other);
        for (int i = 0; i < array.length; i++) {
            final Double sum = array[i].element.doubleValue() - other[i].element.doubleValue();
            array[i].setElement((E)sum);
        }
    }

    public void multiply(final Element<E>[] other) {
        checkArraysSize(other);
        for (int i = 0; i < array.length; i++) {
            final Double sum = array[i].element.doubleValue() * other[i].element.doubleValue();
            array[i].setElement((E)sum);
        }
    }

    public void devide(final Element<E>[] other) {
        checkArraysSize(other);
        for (int i = 0; i < array.length; i++) {
            final Double sum = array[i].element.doubleValue() / other[i].element.doubleValue();
            array[i].setElement((E)sum);
        }
    }

    private void checkArraysSize(final Element<E>[] current) {
        if (array.length != current.length) {
            throw new IllegalArgumentException("Arrays have different sizes");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                sb.append("[ ");
            }

            sb.append(array[i]);

            if (i == array.length - 1) {
                sb.append(" ]");
            }

        }
        return sb.toString();
    }



    static class Element<E extends Number> {

        private E element;

        public Element() { }

        public Element(E element) {
            this.element = element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        @Override
        public String toString() {
            return "element = " + element + " ";
        }
    }

    public Element<E>[] getArray() {
        return array;
    }

    public void setArray(Element<E>[] array) {
        this.array = array;
    }
}
