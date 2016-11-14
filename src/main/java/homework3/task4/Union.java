package homework3.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by koval on 13.11.2016.
 */
public class Union<T extends Comparable<? super T>> {
    private List<T> first;
    private List<T> second;

    public Union() { }

    public Union(List<T> first, List<T> second) {
        this.first = first;
        this.second = second;
    }

    public List<? super T> getUnion(final List<? super T> dst, final List<? extends T> src) {
        if (dst == null || src == null) {
            throw new IllegalArgumentException("Lists can not be null");
        }

        final List<? super T> union = new ArrayList<>(dst);
        union.addAll(src);
        return union;
    }

    public void sortUnion(final List<? extends T> union) {
        Collections.sort(union);
    }

    public <E extends Comparator<? super E>> void sortUnionWithOwnComparator(final List<? extends E> union,
                                                                             final Comparator<? super E> comparator) {
        Collections.sort(union, comparator);
    }

    public List<T> getFirst() {
        return first;
    }

    public void setFirst(List<T> first) {
        this.first = first;
    }

    public List<T> getSecond() {
        return second;
    }

    public void setSecond(List<T> second) {
        this.second = second;
    }
}
