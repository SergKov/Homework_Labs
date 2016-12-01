package laba1.appliances;

/**
 * Created by koval on 27.11.2016.
 */
public class ApplianceFactory {

    private static final ApplianceFactory instance = new ApplianceFactory();

    public static ApplianceFactory getInstance() {
        return instance;
    }

    private static final String ILLEGAL_APPLIANCE = "Illegal Appliance";

    public AbstractAppliance createAppliance(final Appliance appliance, final String mark, final double amperage,
                                             final PlugType plugType) {

        ValidationFactory.getInstance().validate(appliance);
        ValidationFactory.getInstance().validate(mark);
        ValidationFactory.getInstance().validate(plugType);

        switch (appliance) {

            case COMPUTER :
                ValidationFactory.getInstance().validateComputer(amperage);
                return new Computer(amperage, mark, plugType);
            case COOKER :
                ValidationFactory.getInstance().validateCooker(amperage);
                return new Cooker(amperage, mark, plugType);
            case FRIDGE :
                ValidationFactory.getInstance().validateFridge(amperage);
                return new Fridge(amperage, mark, plugType);
            case TV :
                ValidationFactory.getInstance().validateTV(amperage);
                return new TV(amperage, mark, plugType);
            case DRILL :
                ValidationFactory.getInstance().validateDrill(amperage);
                return new Drill(amperage, mark, plugType);
            case IRON :
                ValidationFactory.getInstance().validateIron(amperage);
                return new Iron(amperage, mark, plugType);
            case KETTLE :
                ValidationFactory.getInstance().validateKettle(amperage);
                return new Kettle(amperage, mark, plugType);
            default :
                throw new IllegalArgumentException(ILLEGAL_APPLIANCE);
        }

    }
}
