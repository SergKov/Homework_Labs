package laba1;

import laba1.appliances.AbstractAppliance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sergey on 27.11.2016.
 */
public class Room {

    private static final String NO_APPLIANCE = "No such appliance in a flat";

    private List<AbstractAppliance> appliances;

    public Room() {
        this.appliances = new ArrayList<>();
    }

    public void addAppliance(final AbstractAppliance appliance) {
        appliances.add(appliance);
    }

    public void removeAppliance(final Appliance byAppliance) {

        final boolean isRemoved = appliances.removeIf(appliance ->
                appliance.getName() == byAppliance);

        if (!isRemoved) {
            throw new IllegalArgumentException(NO_APPLIANCE);
        }
    }

    public List<AbstractAppliance> findAllByName(final Appliance byAppliance) {
        return appliances.stream()
                .filter(appliance -> appliance.getName() == byAppliance)
                .collect(Collectors.toList());
    }

    public List<AbstractAppliance> findAllByPower(final double power) {
        return appliances.stream()
                .filter(appliance -> appliance.getPower() == power)
                .collect(Collectors.toList());
    }

    public List<AbstractAppliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<AbstractAppliance> appliances) {
        this.appliances = appliances;
    }
}
