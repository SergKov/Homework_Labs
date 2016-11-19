package homework3.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by koval on 13.11.2016.
 */
public class Union<T> {
    private List<T> first;
    private List<T> second;

    public Union() { }

    public Union(List<T> first, List<T> second) {
        this.first = first;
        this.second = second;
    }

    public List<T> getUnion(final List<? extends T> dst, final List<? extends T> src,
                                    final Comparator<? super T> comparator) {

        if (dst == null || src == null) {
            throw new IllegalArgumentException("Lists can not be null");
        }

        final List<? super T> unioned = new ArrayList<>(dst);

        unioned.addAll(src);

        if (comparator == null) {
            Collections.sort((List<? extends Comparable>) unioned);
        } else {
            Collections.sort((List<T>) unioned, comparator);
        }

        return (List<T>) unioned;
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
