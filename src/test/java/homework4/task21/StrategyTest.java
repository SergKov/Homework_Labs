package homework4.task21;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by koval on 25.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class StrategyTest {

    @Mock
    private FlyStrategy flyStrategy;

    @Mock
    private GoStrategy goStrategy;

    @Test
    public void requireResultVampireStrategyWithMagic() {
        final Vampire vampire = new Vampire(goStrategy, flyStrategy);
        vampire.setMagic(true);
        vampire.executeStrategy();
        verify(flyStrategy).move();
    }

    @Test
    public void requireResultVampireStrategyGoStrategyWithoutMagic() {
        final Vampire vampire = new Vampire(goStrategy, flyStrategy);
        vampire.setMagic(false);
        vampire.executeStrategy();
        verify(goStrategy).move();
    }

    @Test
    public void requireResultVampireStrategyByDefault() {
        final Vampire vampire = new Vampire(goStrategy, flyStrategy);
        vampire.executeStrategy();
        verify(goStrategy).move();
    }

    @Test
    public void requireResultElfStrategyGoStrategyWithFlying() {
        final Elf elf = new Elf(goStrategy, flyStrategy);
        elf.setFlying(true);
        elf.executeStrategy();
        verify(flyStrategy).move();
    }

    @Test
    public void requireResultElfStrategyGoStrategyWithGoing() {
        final Elf elf = new Elf(goStrategy, flyStrategy);
        elf.setFlying(false);
        elf.executeStrategy();
        verify(goStrategy).move();
    }

    @Test
    public void requireResultElfStrategyGoStrategyByDefault() {
        final Elf elf = new Elf(goStrategy, flyStrategy);
        elf.executeStrategy();
        verify(flyStrategy).move();
    }

    @Test
    public void requireResultHarpy() {
        final Harpy harpy = new Harpy(flyStrategy);
        harpy.executeStrategy();
        verify(flyStrategy).move();
    }

    @Test
    public void requireResultOrc() {
        final Orc orc = new Orc(goStrategy);
        orc.executeStrategy();
        verify(goStrategy).move();
    }

    @Test
    public void requireResultTroll() {
        final Troll troll = new Troll(goStrategy);
        troll.executeStrategy();
        verify(goStrategy).move();
    }
}
