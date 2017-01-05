package homework6.task35;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by koval on 05.01.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MySemaphoreTest {

    private MySemaphore semaphore;

    @Before
    public void setUp() {
        semaphore = new MySemaphore(2);
    }

    @Test
    public void requireResult() throws InterruptedException {
        semaphore.acquire();
        semaphore.acquire();
        semaphore.release();
        semaphore.release();
        semaphore.acquire();
        semaphore.acquire();
        semaphore.release();
        semaphore.release();
        semaphore.acquire();
        semaphore.acquire();
    }
}
