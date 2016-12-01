package homework4.task26;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by koval on 24.11.2016.
 */
public class BacteriaTest {

    private final Bacteria first = new Bacteria();

    private final Bacteria second = new Bacteria();

    private final BacteriaColony bacteriaColony = BacteriumColonyFactory.getInstance().createBacteriaColony(first, second);

    @Test(expected = IllegalStateException.class)
    public void requireResultWithNull() {
        BacteriumColonyFactory.getInstance().createBacteriaColony(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireResultWithEmptyColony() {
        BacteriumColonyFactory.getInstance().createBacteriaColony(first);
    }

    @Test
    public void requireResultWithOneBacteria() {
        assertNotNull(bacteriaColony);
    }

    @Test
    public void requireResultWithCross() {

        final int sizeBeforeCross = bacteriaColony.getBacterias().size();
        bacteriaColony.cross();
        final int expectedSizeAfterCross = sizeBeforeCross + 1;

        assertThat(bacteriaColony.getBacterias(), hasSize(expectedSizeAfterCross));
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
