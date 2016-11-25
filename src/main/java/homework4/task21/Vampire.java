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

    private boolean isMagic;

    public Vampire(GoStrategy goStrategy) {
        this.goStrategy = goStrategy;
    }

    public Vampire(GoStrategy goStrategy, FlyStrategy flyStrategy) {
        this.goStrategy = goStrategy;
        this.flyStrategy = flyStrategy;
    }

    public void executeStrategy() {
        if (isMagic) {
            flyStrategy.move();
            LOG.debug(VAMPIRE_FLYING);
        } else {
            goStrategy.move();
            LOG.debug(VAMPIRE_GOING);
        }
    }

    public boolean isMagic() {
        return isMagic;
    }

    public void setMagic(boolean magic) {
        isMagic = magic;
    }

    public Strategy getStrategy() {
        return isMagic ? flyStrategy : goStrategy;
    }
}
