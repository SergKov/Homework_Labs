package laba1.sokets;

import laba1.appliances.PlugType;

/**
 * Created by koval on 27.11.2016.
 */
public class EuropeanSoket extends Soket {

    public static final int EUROPIAN_VOLTAGE = 220;

    @Override
    public int getVoltage() {
        return EUROPIAN_VOLTAGE;
    }

    @Override
    public PlugType getPlugType() {
        return PlugType.EUROPEAN;
    }
}
