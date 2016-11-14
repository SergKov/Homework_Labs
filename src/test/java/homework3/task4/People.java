package homework3.task4;

import java.util.Comparator;

/**
 * Created by koval on 13.11.2016.
 */
abstract class Monkey implements Comparable<Monkey> {
    private int age;

    public Monkey() { }

    public Monkey(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(final Monkey other) {
        return this.getAge() - other.getAge();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public abstract class People extends Monkey {
    private int age;

    public int getAge() {
        return age;
    }
}

class Boy extends People {
    private int age;

    public Boy() { }

    public Boy(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Girl extends People {
    private int age;

    public Girl() { }

    public Girl(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

