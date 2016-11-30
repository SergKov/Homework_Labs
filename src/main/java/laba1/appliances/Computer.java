package laba1.appliances;

import laba1.Room;
import laba1.sokets.Soket;

/**
 * Created by koval on 27.11.2016.
 */
public class Computer extends AbstractAppliance {

    private final double amperage;
    private final String mark;
    private PlugType plugType;

    Computer(double amperage, String mark, PlugType plugType) {
        this.amperage = amperage;
        this.mark = mark;
        this.plugType = plugType;
    }

    @Override
    public void turnOn(final Soket soket, final Room room) {
        adaptPlugAndTurnOn(plugType, soket, room);
    }

    @Override
    public double getPower() {
        return amperage * soket.getVoltage();
    }

    @Override
    public Appliance getName() {
        return Appliance.COMPUTER;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "amperage=" + amperage +
                ", mark='" + mark + '\'' +
                ", plugType=" + plugType +
                '}';
    }

    public double getAmperage() {
        return amperage;
    }

    public PlugType getPlugType() {
        return plugType;
    }

    @Override
    public void setPlugType(PlugType plugType) {
        this.plugType = plugType;
    }

    public String getMark() {
        return mark;
    }
}
