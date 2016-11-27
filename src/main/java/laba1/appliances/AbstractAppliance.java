package laba1.appliances;

import laba1.sokets.Soket;

/**
 * Created by koval on 27.11.2016.
 */
public abstract class AbstractAppliance {

    protected boolean isTurnedOn;
    protected Soket soket;

    public abstract void turnOn(Soket soket);

    protected void adaptPlugAndTurnOn(PlugType plugType, final Soket soket) {
        if (!isTurnedOn) {
            if (plugType != soket.getPlugType()) {
                plugType = soket.getPlugType();
                isTurnedOn = true;
            } else {
                isTurnedOn = true;
            }
        }
    }

    public void turnOff() {
        isTurnedOn = false;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public abstract double getPower();

    public abstract Appliance getName();

    public abstract String getMark();
}
