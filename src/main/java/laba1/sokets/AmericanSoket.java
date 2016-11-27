package laba1.sokets;

import laba1.appliances.PlugType;

/**
 * Created by koval on 27.11.2016.
 */
public class AmericanSoket implements Soket {

    private static final int AMERICAN_VOLTAGE = 120;

    @Override
    public int getVoltage() {
        return AMERICAN_VOLTAGE;
    }

    @Override
    public PlugType getPlugType() {
        return PlugType.AMERICAN;
    }
}
