package homework6.task37;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by koval on 07.03.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ThreadPoolTest {

    private final BlockingQueue blockingQueue = new BlockingQueue(5);

    private final ThreadPool threadPool = new ThreadPool(5);

    @Test
    public void testExecute() throws Exception {
        for (int i = 0; i < 100; i++) {
            final int k = i;
            threadPool.execute(() -> System.out.println(k));
        }
    }

}