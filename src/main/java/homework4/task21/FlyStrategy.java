package homework4.task21;

import org.apache.log4j.Logger;

/**
 * Created by koval on 24.11.2016.
 */
public class FlyStrategy implements Strategy {

    private static final Logger LOG = Logger.getLogger(FlyStrategy.class);

    private static final String FLYING = "I am flying";

    @Override
    public void move() {
        LOG.debug(FLYING);
    }
}
