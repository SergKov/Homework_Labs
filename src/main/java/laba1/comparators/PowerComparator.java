package laba1.comparators;

import laba1.appliances.AbstractAppliance;

import java.util.Comparator;

/**
 * Created by koval on 27.11.2016.
 */
public class PowerComparator implements Comparator<AbstractAppliance> {

    private static final double DELTA = .05;

    @Override
    public int compare(AbstractAppliance o1, AbstractAppliance o2) {

        if (o1.getPower() - o2.getPower() > DELTA) {
            return 1;
        } else if (o2.getPower() - o1.getPower() < DELTA) {
            return -1;
        } else {
            return 0;
        }
    }
}
