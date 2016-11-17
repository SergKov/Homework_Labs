package homework3.task4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by koval on 13.11.2016.
 */
public class UnionTest {

    private final List<? super People> ukrainian = new ArrayList<>();
    private final List<Girl> english = new ArrayList<>();
    private final Union<People> union = new Union<>();

    @Test
    public void requireResultUnionWithEmptyLists() {

        final List<? super People> people = union.getUnion(ukrainian, english, null);

        final int expected = 0;
        final int result = people.size();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultUnionWithNotEmptyLists() {
        ukrainian.add(new Girl(24));
        ukrainian.add(new Girl(67));
        ukrainian.add(new Girl(37));
        ukrainian.add(new Boy(24));
        ukrainian.add(new Boy(62));

        english.add(new Girl(45));
        english.add(new Girl(32));
        english.add(new Girl(56));

        final List<? super People> unioned = union.getUnion(ukrainian, english, null);

        final int expected = ukrainian.size() + english.size();
        final int result = unioned.size();

        assertEquals(expected, result);
    }


    @Test
    public void requireResultSortUnion() {
        ukrainian.add(new Girl(24));
        ukrainian.add(new Girl(67));
        ukrainian.add(new Girl(37));
        ukrainian.add(new Boy(28));
        ukrainian.add(new Boy(62));

        english.add(new Girl(45));
        english.add(new Girl(32));
        english.add(new Girl(56));

        final List<People> unioned = union.getUnion(ukrainian, english, null);

        final Iterator<People> iter = unioned.iterator();
        People currentPerson = iter.next();
        while (iter.hasNext()) {
            final People person = iter.next();
            assertTrue(currentPerson.compareTo(person) <= 0);
            currentPerson = person;
        }
    }

    @Test
    public void requireResultContainsAllElements() {
        ukrainian.add(new Girl(24));
        ukrainian.add(new Girl(67));
        ukrainian.add(new Girl(37));
        ukrainian.add(new Boy(28));
        ukrainian.add(new Boy(62));

        english.add(new Girl(45));
        english.add(new Girl(32));
        english.add(new Girl(56));

        final List<People> unioned = union.getUnion(ukrainian, english, null);

        ukrainian.forEach(person -> assertTrue(unioned.contains(person)));
        english.forEach(person -> assertTrue(unioned.contains(person)));
    }

    @Test
    public void requireResultSortUnionWithOwnComparator() {
        ukrainian.add(new Girl(24));
        ukrainian.add(new Girl(67));
        ukrainian.add(new Girl(37));
        ukrainian.add(new Boy(28));
        ukrainian.add(new Boy(62));

        english.add(new Girl(45));
        english.add(new Girl(32));
        english.add(new Girl(56));

        final List<People> unioned = union.getUnion(ukrainian, english, (o1, o2) -> o2.getAge() - o1.getAge());

        final Iterator<People> iter = unioned.iterator();
        People currentPerson = iter.next();
        while (iter.hasNext()) {
            final People person = iter.next();
            assertTrue(currentPerson.compareTo(person) >= 0);
            currentPerson = person;
        }
    }

}
