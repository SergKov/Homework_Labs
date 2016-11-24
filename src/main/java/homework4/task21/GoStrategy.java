package homework4.task21;

import org.apache.log4j.Logger;

/**
 * Created by koval on 24.11.2016.
 */
public class GoStrategy implements Strategy {

    private static final Logger LOG = Logger.getLogger(GoStrategy.class);

    private static final String GOING = "I am going";

    @Override
    public void move() {
        LOG.debug(GOING);
    }
}
