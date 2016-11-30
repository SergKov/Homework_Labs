package laba1.appliances;

import laba1.Room;
import laba1.sokets.Soket;

/**
 * Created by koval on 27.11.2016.
 */
public class Iron extends AbstractAppliance {

    private final double amperage;
    private final String mark;
    private PlugType plugType;

    Iron(double amperage, String mark, PlugType plugType) {
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
    public void setPlugType(PlugType plugType) {
        this.plugType = plugType;
    }

    @Override
    public Appliance getName() {
        return Appliance.IRON;
    }

    @Override
    public String toString() {
        return "Iron{" +
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
}
