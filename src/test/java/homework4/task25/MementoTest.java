package homework4.task25;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * Created by koval on 15.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MementoTest {

    @Mock
    private TicTacToy ticTacToy;

    @Mock
    private Memento memento;

    @Test
    public void requireResultWithSaveState() {
        when(ticTacToy.saveStateToMemento()).thenReturn(memento);
        ticTacToy.startGame();
        verify(ticTacToy, times(0)).saveStateToMemento();
        verify(ticTacToy, times(1)).startGame();
    }
}
