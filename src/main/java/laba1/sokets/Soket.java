package laba1.sokets;

import laba1.appliances.PlugType;

/**
 * Created by koval on 27.11.2016.
 */
public abstract class Soket {

    protected boolean hasPlug;

    public abstract int getVoltage();

    public abstract PlugType getPlugType();

    public boolean getIsHavingPlug() {
        return hasPlug;
    }

    public void setIsHavingPlug(boolean hasPlug) {
        this.hasPlug = hasPlug;
    }
}
