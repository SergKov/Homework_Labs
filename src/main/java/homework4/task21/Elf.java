package homework4.task21;

import org.apache.log4j.Logger;

/**
 * Created by koval on 24.11.2016.
 */
public class Elf {

    private static final Logger LOG = Logger.getLogger(Elf.class);

    private static final String ELF_GOING = "Elf is going";
    private static final String ELF_FLYING = "Elf is flying";

    private FlyStrategy flyStrategy;
    private GoStrategy goStrategy;

    public Elf(FlyStrategy flyStrategy, GoStrategy goStrategy) {
        this.flyStrategy = flyStrategy;
        this.goStrategy = goStrategy;
    }

    public void executeStrategy() {
        flyStrategy.move();
        LOG.debug(ELF_GOING);
        goStrategy.move();
        LOG.debug(ELF_FLYING);
    }

    public GoStrategy getGoStrategy() {
        return goStrategy;
    }

    public void setGoStrategy(GoStrategy goStrategy) {
        this.goStrategy = goStrategy;
    }
}
