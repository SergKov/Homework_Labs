package homework3.task3;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by koval on 14.11.2016.
 */
public class QuickSort {

    private QuickSort() { }

    public static <E> void sortList(final List<E> list, final Comparator<? super E> comparator) {
        validate(list);
        quickSort(list, 0, list.size() - 1, comparator);
    }

    private static <E> void quickSort(final List<E> list, final int left, final int right,
                                                                    final Comparator<? super E> comparator) {

        final int indexPartition = partition(list, left, right, comparator);

        if (left < indexPartition - 1) {
            quickSort(list, left, indexPartition - 1, comparator);
        }

        if (indexPartition < right) {
            quickSort(list, indexPartition, right, comparator);
        }
    }

    @SuppressWarnings("unchecked")
    private static <E> int partition(final List<E> list, int left, int right,
                                                                   final Comparator<? super E> comparator) {

        final int middle = (left + right) / 2;
        final E pivot = list.get(middle);

        while (left <= right) {
            if (comparator != null) {
                while (comparator.compare(list.get(left), pivot) < 0) {
                    left++;
                }
                while (comparator.compare(list.get(right), pivot) > 0) {
                    right--;
                }
            } else {
                while (((Comparable<? super E>)list.get(left)).compareTo(pivot) < 0) {
                    left++;
                }
                while (((Comparable<? super E>)list.get(right)).compareTo(pivot) > 0) {
                    right--;
                }
            }

            if (left <= right) {
                Collections.swap(list, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static <E> void validate(final List<E> list) {
        if (CollectionUtils.isEmpty(list)) {
            throw new IllegalArgumentException("List can not be empty or null");
        }
    }

}
