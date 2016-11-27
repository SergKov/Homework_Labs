package laba1.factories.create;

import laba1.Appliance;
import laba1.appliances.AbstractAppliance;
import laba1.appliances.PlugType;
import laba1.appliances.Computer;
import laba1.appliances.Cooker;
import laba1.appliances.Fridge;
import laba1.appliances.TV;
import laba1.appliances.Drill;
import laba1.appliances.Iron;
import laba1.appliances.Kettle;
import laba1.factories.validate.ValidationFactory;

/**
 * Created by koval on 27.11.2016.
 */
public class ApplianceFactory {

    private static final ApplianceFactory instance = new ApplianceFactory();

    public ApplianceFactory getInstance() {
        return instance;
    }

    private static final String ILLEGAL_APPLIANCE = "Illegal Appliance";

    public AbstractAppliance createAppliance(final Appliance appliance, final double amperage,
                                             final PlugType plugType) {

        ValidationFactory.getInstance().validate(appliance);
        ValidationFactory.getInstance().validate(plugType);

        switch (appliance) {

            case COMPUTER :
                ValidationFactory.getInstance().validateComputer(amperage);
                return new Computer(amperage, plugType);
            case COOKER :
                ValidationFactory.getInstance().validateCooker(amperage);
                return new Cooker(amperage, plugType);
            case FRIDGE :
                ValidationFactory.getInstance().validateFridge(amperage);
                return new Fridge(amperage, plugType);
            case TV :
                ValidationFactory.getInstance().validateTV(amperage);
                return new TV(amperage, plugType);
            case DRILL :
                ValidationFactory.getInstance().validateDrill(amperage);
                return new Drill(amperage, plugType);
            case IRON :
                ValidationFactory.getInstance().validateIron(amperage);
                return new Iron(amperage, plugType);
            case KETTLE :
                ValidationFactory.getInstance().validateKettle(amperage);
                return new Kettle(amperage, plugType);
            default :
                throw new IllegalArgumentException(ILLEGAL_APPLIANCE);
        }

    }
}
