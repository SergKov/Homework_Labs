package homework4.task26;

import org.junit.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

/**
 * Created by koval on 24.11.2016.
 */
public class BacteriaTest {

    private final Bacteria bacteria = new Bacteria();

    private final BacteriaColony bacteriaColony = BacteriumColonyFactory.getInstance().createBacteriaColony(bacteria);

    @Test(expected = IllegalArgumentException.class)
    public void requireResultWithNull() {
        BacteriumColonyFactory.getInstance().createBacteriaColony(null);
    }

    @Test
    public void requireResultWithOneBacteria() {
        assertNotNull(bacteriaColony);
    }

    @Test
    public void requireResultWithCross() {

        final int sizeBeforeCross = bacteriaColony.size();
        bacteriaColony.cross();

        final int expectedSizeAfterCross = sizeBeforeCross + 1;
        final int result = bacteriaColony.size();

        assertEquals(expectedSizeAfterCross, result);
    }

    @Test
    public void requireResultWithRandom() {

        bacteriaColony.cross();
        bacteriaColony.cross();
        bacteriaColony.cross();

        final Bacteria bacteria = bacteriaColony.getRandomBactery();
        assertNotNull(bacteria);
    }

}
