package homework4.task21;

import org.apache.log4j.Logger;

/**
 * Created by koval on 24.11.2016.
 */
public class Orc {

    private static final Logger LOG = Logger.getLogger(Orc.class);

    private static final String ORC_GOING = "Orc is going";

    private GoStrategy goStrategy;

    public Orc(GoStrategy goStrategy) {
        this.goStrategy = goStrategy;
    }

    public void executeStrategy() {
        goStrategy.move();
        LOG.debug(ORC_GOING);
    }

    public GoStrategy getStrategy() {
        goStrategy.move();
        return goStrategy;
    }

    public void setStrategy(GoStrategy goStrategy) {
        this.goStrategy = goStrategy;
    }
}
