package laba1;

import laba1.appliances.AbstractAppliance;
import laba1.appliances.Appliance;
import laba1.sokets.Soket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sergey on 27.11.2016.
 */
public class Room {

    private static final String NO_APPLIANCE = "No such appliance in a flat";

    private final String name;
    private List<AbstractAppliance> appliances;
    private List<Soket> sokets;

    public Room(String name) {
        this.name = name;
        this.appliances = new ArrayList<>();
        this.sokets = new ArrayList<>();
    }

    public Room(String name, List<Soket> sokets) {
        this(name);
        this.sokets = sokets;
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

    public void addSoket(final Soket soket) {
        sokets.add(soket);
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

    public AbstractAppliance findByMark(final Appliance name, final String mark) {
        return appliances.stream()
                .filter(appliance -> appliance.getName() == name)
                .filter(appliance -> appliance.getMark().equals(mark))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_APPLIANCE));
    }

    public int countSockets() {
        return sokets.size();
    }

    public List<AbstractAppliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<AbstractAppliance> appliances) {
        this.appliances = appliances;
    }

    public List<Soket> getSokets() {
        return sokets;
    }
}
