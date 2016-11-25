package homework4.task21;

import org.apache.log4j.Logger;

/**
 * Created by koval on 24.11.2016.
 */
public class Troll {

    private static final Logger LOG = Logger.getLogger(Troll.class);

    private static final String TROLL_GOING = "Troll is going";

    private GoStrategy goStrategy;

    public Troll(GoStrategy goStrategy) {
        this.goStrategy = goStrategy;
    }

    public void executeStrategy() {
        LOG.debug(TROLL_GOING);
    }

    public GoStrategy getStrategy() {
        return goStrategy;
    }

    public void setStrategy(GoStrategy goStrategy) {
        this.goStrategy = goStrategy;
    }
}
