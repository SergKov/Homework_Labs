package laba1;

import laba1.appliances.AbstractAppliance;
import laba1.appliances.Appliance;
import laba1.appliances.ValidationFactory;
import laba1.sokets.Soket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static laba1.appliances.ValidationFactory.NO_APPLIANCE;
import static laba1.appliances.comparators.PowerComparator.DELTA;

/**
 * Created by Sergey on 27.11.2016.
 */
public class Room {

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

        ValidationFactory.getInstance().validate(isRemoved);
    }

    public void addSoket(final Soket soket) {
        sokets.add(soket);
    }

    public void turnOn(final int applianceNumber, final int soketNumber) {

        ValidationFactory.getInstance().validateApplianceNumber(applianceNumber, appliances);
        final AbstractAppliance appliance = appliances.get(applianceNumber);

        ValidationFactory.getInstance().validateTurnedOff(appliance);
        ValidationFactory.getInstance().validateSoketNumber(soketNumber, sokets);
        final Soket soket = sokets.get(soketNumber);

        ValidationFactory.getInstance().validateSoketNotInsertedPlug(soket);
        appliance.turnOn(soket);
        soket.setIsHavingPlug(true);
    }

    public void turnOff(final int applianceNumber, final int soketNumber) {

        ValidationFactory.getInstance().validateApplianceNumber(applianceNumber, appliances);
        final AbstractAppliance appliance = appliances.get(applianceNumber);

        ValidationFactory.getInstance().validateTurnedOn(appliance);
        ValidationFactory.getInstance().validateSoketNumber(soketNumber, sokets);
        final Soket soket = sokets.get(soketNumber);

        ValidationFactory.getInstance().validateSoketInsertedPlug(soket);
        appliance.turnOff();
        soket.setIsHavingPlug(false);
    }

    public List<AbstractAppliance> findAllByName(final Appliance byAppliance) {
        return appliances.stream()
                .filter(appliance -> appliance.getName() == byAppliance)
                .collect(Collectors.toList());
    }

    public List<AbstractAppliance> findAllByPower(final double power) {
        return appliances.stream()
                .filter(appliance -> appliance.getPower() - power < DELTA)
                .collect(Collectors.toList());
    }

    public AbstractAppliance findByMark(final Appliance name, final String mark) {
        return appliances.stream()
                .filter(appliance -> appliance.getName() == name)
                .filter(appliance -> appliance.getMark().equals(mark))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_APPLIANCE));
    }

    public List<AbstractAppliance> findAllTurnedOn() {
        return appliances.stream()
                .filter(AbstractAppliance::isTurnedOn)
                .collect(Collectors.toList());
    }

    public List<AbstractAppliance> findAllTurnedOff() {
        return appliances.stream()
                .filter(appliance -> !appliance.isTurnedOn())
                .collect(Collectors.toList());
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
