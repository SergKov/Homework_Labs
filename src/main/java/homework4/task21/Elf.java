package homework4.task21;

import org.apache.log4j.Logger;

/**
 * Created by koval on 24.11.2016.
 */
public class Elf {

    private static final Logger LOG = Logger.getLogger(Elf.class);

    private static final String ELF_GOING = "Elf is going";
    private static final String ELF_FLYING = "Elf is flying";

    private GoStrategy goStrategy;
    private FlyStrategy flyStrategy;


    private boolean isFlying;

    public Elf(GoStrategy goStrategy, FlyStrategy flyStrategy) {
        this.goStrategy = goStrategy;
        this.flyStrategy = flyStrategy;
        isFlying = true;
    }

    public void executeStrategy() {
        if (isFlying) {
            flyStrategy.move();
            LOG.debug(ELF_FLYING);
        } else {
            goStrategy.move();
            LOG.debug(ELF_GOING);
        }
    }

    public Strategy getStrategy() {
        return isFlying ? flyStrategy : goStrategy;
    }

    public boolean isFlying() {
        return isFlying;
    }
}
