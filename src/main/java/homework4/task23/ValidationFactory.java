package homework4.task23;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * Created by koval on 04.12.2016.
 */
public class ValidationFactory {

    private static final Logger LOG = Logger.getLogger(ValidationFactory.class);

    private static final ValidationFactory instance = new ValidationFactory();

    public static ValidationFactory getInstance() {
        return instance;
    }

    private static final String STATE_ILLEGAL = "You can not move to this state %s";

    public void validate(GrantOrder to, GrantOrder.State... states) {
        Arrays.stream(states).forEach(state -> {
            if (to.getState() == state) {
                final String STATE_ILLEGAL_ = String.format(STATE_ILLEGAL, to);
                LOG.warn(STATE_ILLEGAL_);
                throw new IllegalArgumentException(STATE_ILLEGAL_);
            }
        });
    }
}
