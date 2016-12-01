package laba1.appliances;

import laba1.Room;
import laba1.sokets.Soket;

/**
 * Created by koval on 27.11.2016.
 */
public class Kettle extends AbstractAppliance {

    private final double amperage;
    private final String mark;
    private PlugType plugType;

    Kettle(double amperage, String mark, PlugType plugType) {
        this.amperage = amperage;
        this.mark = mark;
        this.plugType = plugType;
    }

    @Override
    public void turnOn(final Soket soket) {
        super.soket = soket;
        adaptPlugAndTurnOn(plugType, soket);
    }

    @Override
    public double getPower() {
        return isTurnedOn ? amperage * soket.getVoltage() : 0;
    }

    @Override
    public Appliance getName() {
        return Appliance.KETTLE;
    }

    @Override
    public String toString() {
        return "Kettle{" +
                "amperage=" + amperage +
                ", mark='" + mark + '\'' +
                ", plugType=" + plugType +
                '}';
    }

    public double getAmperage() {
        return amperage;
    }

    @Override
    public String getMark() {
        return mark;
    }

    public PlugType getPlugType() {
        return plugType;
    }

    @Override
    public void setPlugType(PlugType plugType) {
        this.plugType = plugType;
    }
}
