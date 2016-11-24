package homework4.task21;

import org.apache.log4j.Logger;

/**
 * Created by koval on 24.11.2016.
 */
public class Vampire {
    private static final Logger LOG = Logger.getLogger(Vampire.class);

    private static final String VAMPIRE_GOING = "Vampire is going";
    private static final String VAMPIRE_FLYING = "Vampire is flying";

    private GoStrategy goStrategy;
    private FlyStrategy flyStrategy;

    public Vampire(GoStrategy goStrategy, FlyStrategy flyStrategy) {
        this.goStrategy = goStrategy;
        this.flyStrategy = flyStrategy;
    }

    public void executeStrategy() {
        goStrategy.move();
        LOG.debug(VAMPIRE_GOING);
    }

    public void executeMagic() {
        flyStrategy.move();
        LOG.debug(VAMPIRE_FLYING);
    }

    public GoStrategy getGoStrategy() {
        return goStrategy;
    }

    public void setGoStrategy(GoStrategy goStrategy) {
        this.goStrategy = goStrategy;
    }
}
