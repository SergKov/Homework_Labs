package laba1.appliances;

import laba1.sokets.Soket;

/**
 * Created by koval on 27.11.2016.
 */
public class TV extends AbstractAppliance {

    private final double amperage;
    private final String mark;
    private PlugType plugType;

    TV(double amperage, String mark, PlugType plugType) {
        this.amperage = amperage;
        this.mark = mark;
        this.plugType = plugType;
    }

    @Override
    public void turnOn(final Soket soket) {
        adaptPlugAndTurnOn(plugType, soket);
    }

    @Override
    public double getPower() {
        return amperage * soket.getVoltage();
    }

    @Override
    public Appliance getName() {
        return Appliance.TV;
    }

    public double getAmperage() {
        return amperage;
    }

    public PlugType getPlugType() {
        return plugType;
    }

    public String getMark() {
        return mark;
    }
}
