package laba1.appliances;

import laba1.Appliance;
import laba1.sokets.Soket;

/**
 * Created by koval on 27.11.2016.
 */
public class TV extends AbstractAppliance {

    private final double amperage;
    private PlugType plugType;

    public TV(double amperage, PlugType plugType) {
        this.amperage = amperage;
        this.plugType = plugType;
    }

    @Override
    public void turnOn(final Soket soket) {
        if (plugType != soket.getPlugType()) {
            plugType = soket.getPlugType();
            isTurnedOn = true;
        }
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
}
