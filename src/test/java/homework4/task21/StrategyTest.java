package homework4.task21;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by koval on 25.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class StrategyTest {

    @Spy
    private final Vampire vampire = new Vampire(new GoStrategy(), new FlyStrategy());

    @Mock
    private FlyStrategy flyStrategy;

    @Mock
    private Troll troll;

    @Mock
    private Orc orc;

    @Mock
    private Elf elf;

    @Mock
    private Harpy harpy;

    @Test
    public void requireResultWithHarpy() {
        vampire.executeStrategy();
        vampire.setMagic(true);
        verify(flyStrategy, times(1)).move();
//        when(vampire.getGoStrategy()).thenReturn(new GoStrategy());
//        when(troll.getGoStrategy()).thenReturn(new GoStrategy());
//        when(orc.getGoStrategy()).thenReturn(new GoStrategy());
//        when(harpy.getFlyStrategy()).thenReturn(new FlyStrategy());
//        when(elf.getGoStrategy()).thenReturn(new GoStrategy());
    }
}
