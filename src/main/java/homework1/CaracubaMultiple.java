package homework1;

/**
 * Created by koval on 30.10.2016.
 */
public class CaracubaMultiple {

    public long getMultiple(final long first, final long second) {
        final int firstNumberFirstPart = getFirstPart(first);
        final long firstNumberSecondPart = first - getFirstAdd(first);

        final int secondNumberFirstPart = getFirstPart(second);
        final long secondNumberSecondPart = second - getFirstAdd(second);

        return firstNumberFirstPart * secondNumberFirstPart * getFirstAdd(first) * getFirstAdd(second)
                + ((getFirstAdd(first) + firstNumberSecondPart) * (getFirstAdd(second) + secondNumberSecondPart))
                - (getFirstPart(first) * getFirstPart(second) - firstNumberFirstPart * firstNumberSecondPart
                - firstNumberSecondPart * secondNumberSecondPart);

    }

    private int getFirstPart(final long number) {
        return (int) (number - getFirstAdd(number));
    }

    private long getFirstAdd(final long number) {
        return (long) Math.pow(10, getPower(number));
    }

    private int getPower(long number) {
        int power = 0;
        while (number < 10) {
            power++;
            number /= 10;
        }
        return power;
    }


}
