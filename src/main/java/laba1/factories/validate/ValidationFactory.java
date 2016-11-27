package laba1.factories.validate;

import laba1.Appliance;
import laba1.appliances.PlugType;

/**
 * Created by koval on 27.11.2016.
 */
public class ValidationFactory {

    private static final ValidationFactory instance = new ValidationFactory();

    public static ValidationFactory getInstance() {
        return instance;
    }

    private static final String APPLIANCE_NULL = "An appliance can not be a null";
    private static final String PLUG_TYPE_NULL = "A plug can not be a null";
    private static final String AMPERAGE_INCORRECT = "An amperage can not be less then 0";
    private static final String AMPERAGE_COOKER_INCORRECT = "A cooker can not have bigger amperage then 25";
    private static final String AMPERAGE_FRIDGE_INCORRECT = "A fridge can not have bigger amperage then 10";
    private static final String AMPERAGE_COMPUTER_INCORRECT = "A computer can not have bigger amperage then 5";
    private static final String AMPERAGE_TV_INCORRECT = "A TV can not have bigger amperage then 5";
    private static final String AMPERAGE_IRON_INCORRECT = "An iron can not have bigger amperage then 5";
    private static final String AMPERAGE_KETTLE_INCORRECT = "A kettle can not have bigger amperage then 5";
    private static final String AMPERAGE_DRILL_INCORRECT = "A drill can not have bigger amperage then 5";


    public void validate(final Appliance appliance) {
        if (appliance == null) {
            throw new IllegalArgumentException(APPLIANCE_NULL);
        }
    }

    public void validate(final PlugType plugType) {
        if (plugType == null) {
            throw new IllegalArgumentException(PLUG_TYPE_NULL);
        }
    }

    public void validate(final double amperage) {
        if (amperage < 0) {
            throw new IllegalArgumentException(AMPERAGE_INCORRECT);
        }
    }

    public void validateCooker(final double amperage) {
        if (amperage > 25) {
            throw new IllegalArgumentException(AMPERAGE_COOKER_INCORRECT);
        }
    }

    public void validateFridge(final double amperage) {
        if (amperage > 10) {
            throw new IllegalArgumentException(AMPERAGE_FRIDGE_INCORRECT);
        }
    }

    public void validateComputer(final double amperage) {
        if (amperage > 5) {
            throw new IllegalArgumentException(AMPERAGE_COMPUTER_INCORRECT);
        }
    }

    public void validateTV(final double amperage) {
        if (amperage > 5) {
            throw new IllegalArgumentException(AMPERAGE_TV_INCORRECT);
        }
    }

    public void validateIron(final double amperage) {
        if (amperage > 5) {
            throw new IllegalArgumentException(AMPERAGE_IRON_INCORRECT);
        }
    }

    public void validateKettle(final double amperage) {
        if (amperage > 5) {
            throw new IllegalArgumentException(AMPERAGE_KETTLE_INCORRECT);
        }
    }

    public void validateDrill(final double amperage) {
        if (amperage > 5) {
            throw new IllegalArgumentException(AMPERAGE_DRILL_INCORRECT);
        }
    }


}
