package homework4.task21;

import org.apache.log4j.Logger;

/**
 * Created by koval on 25.11.2016.
 */
public class Harpy {

    private static final Logger LOG = Logger.getLogger(Harpy.class);

    private static final String HARPY_FLYING = "Harpy is flying";

    private FlyStrategy flyStrategy;

    public Harpy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }

    public void executeStrategy() {
        flyStrategy.move();
        LOG.debug(HARPY_FLYING);
    }

    public FlyStrategy getStrategy() {
        return flyStrategy;
    }

    public void setStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }
}
