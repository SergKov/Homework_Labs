package homework3.task3;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * Created by koval on 14.11.2016.
 */
public class QuickSort {

    private QuickSort() { }

    public static <E extends Comparable<E>> void sortList(final List<E> list) {
        validate(list);
        quickSort(list, 0, list.size() - 1);
    }

    private static <E extends Comparable<E>> void quickSort(final List<E> list, final int left, final int right) {

        final int indexPartition = partition(list, left, right);

        if (left < indexPartition - 1) {
            quickSort(list, left, indexPartition - 1);
        }

        if (indexPartition < right) {
            quickSort(list, indexPartition, right);
        }
    }

    private static <E extends Comparable<E>> int partition(final List<E> list, int left, int right) {

        final int middle = (left + right) / 2;

        final E pivot = list.get(middle);

        while (left <= right) {

            while (list.get(left).compareTo(pivot) < 0) {
                left++;
            }

            while (list.get(right).compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                Collections.swap(list, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static <E extends Comparable<E>> void validate(final List<E> list) {
        if (CollectionUtils.isEmpty(list)) {
            throw new IllegalArgumentException("List can not be empty or null");
        }
    }

}
