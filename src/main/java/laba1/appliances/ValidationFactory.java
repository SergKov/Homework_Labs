package laba1.appliances;

import laba1.Room;
import laba1.sokets.Soket;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by koval on 27.11.2016.
 */
public class ValidationFactory {

    private static final ValidationFactory instance = new ValidationFactory();

    public static ValidationFactory getInstance() {
        return instance;
    }

    public static final String NO_APPLIANCE = "No such appliance in a flat";
    private static final String APPLIANCE_NULL = "An appliance can not be a null";
    private static final String PLUG_TYPE_NULL = "A plug can not be a null";
    private static final String MARK_INCORRECT = "A mark can not be a null or empty";
    private static final String AMPERAGE_INCORRECT = "An amperage can not be less then 0";
    private static final String AMPERAGE_COOKER_INCORRECT = "A cooker can not have bigger amperage then 25";
    private static final String AMPERAGE_FRIDGE_INCORRECT = "A fridge can not have bigger amperage then 10";
    private static final String AMPERAGE_COMPUTER_INCORRECT = "A computer can not have bigger amperage then 5";
    private static final String AMPERAGE_TV_INCORRECT = "A TV can not have bigger amperage then 5";
    private static final String AMPERAGE_IRON_INCORRECT = "An iron can not have bigger amperage then 5";
    private static final String AMPERAGE_KETTLE_INCORRECT = "A kettle can not have bigger amperage then 5";
    private static final String AMPERAGE_DRILL_INCORRECT = "A drill can not have bigger amperage then 5";
    private static final String APPLIANCE_TURNED_ON = "This appliance is turned on yet";
    private static final String APPLIANCE_TURNED_OFF = "This appliance is turned off";
    private static final String APPLIANCE_NUMBER_INCORRECT = "This appliance number is incorrect";
    private static final String ROOM_HAS_NO_FREE_SOKETS = "This room does not have free sokets";
    private static final String SOKET_IS_HAVING_A_PLUG = "This soket is having a plug";
    private static final String SOKET_IS_NOT_HAVING_A_PLUG = "This soket is not having a plug";
    private static final String SOKET_NUMBER_INCORRECT = "This soket's number is incorrect";


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

    public void validate(final String mark) {
        if (StringUtils.isEmpty(mark)) {
            throw new IllegalArgumentException(MARK_INCORRECT);
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

    public void validateTurnedOn(final AbstractAppliance appliance) {
        if (!appliance.isTurnedOn) {
            throw new IllegalArgumentException(APPLIANCE_TURNED_OFF);
        }
    }

    public void validateTurnedOff(final AbstractAppliance appliance) {
        if (appliance.isTurnedOn) {
            throw new IllegalArgumentException(APPLIANCE_TURNED_ON);
        }
    }

    public void validateSoketInsertedPlug(final Soket soket) {
        if (soket.getIsHavingPlug()) {
            throw new IllegalArgumentException(SOKET_IS_HAVING_A_PLUG);
        }
    }

    public void validateSoketNotInsertedPlug(final Soket soket) {
        if (!soket.getIsHavingPlug()) {
            throw new IllegalArgumentException(SOKET_IS_NOT_HAVING_A_PLUG);
        }
    }

    public void validateSoketNumber(final int number, final List<Soket> sokets) {
        if (number >= sokets.size()) {
            throw new IllegalArgumentException(SOKET_NUMBER_INCORRECT);
        }
    }

    public void validateApplianceNumber(final int number, final List<AbstractAppliance> appliances) {
        if (number >= appliances.size()) {
            throw new IllegalArgumentException(APPLIANCE_NUMBER_INCORRECT);
        }
    }

    public void validate(final boolean isRemoved) {
        if (!isRemoved) {
            throw new IllegalArgumentException(NO_APPLIANCE);
        }
    }

}
