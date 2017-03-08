package homework6.task37;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by koval on 07.03.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ThreadPoolTest {

    private final ThreadPool threadPool = new ThreadPool(5);

    @Test
    public void testExecute() throws Exception {
        for (int i = 0; i < 100; i++) {
            final int k = i;
            threadPool.execute(() -> System.out.println(k));
        }
        threadPool.setClosed(true);
    }

}