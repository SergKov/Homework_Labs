package laba1.appliances;

import laba1.Room;
import laba1.sokets.Soket;

/**
 * Created by koval on 27.11.2016.
 */
public abstract class AbstractAppliance {

    protected boolean isTurnedOn;
    protected Soket soket;

    private static int countTurnedOn;

    public abstract void turnOn(Soket soket, final Room room);

    protected void adaptPlugAndTurnOn(PlugType plugType, final Soket soket, final Room room) {

        checkAndIncrementTurnedOn(room);

        if (!isTurnedOn) {
            if (plugType != soket.getPlugType()) {
                this.setPlugType(plugType);
                isTurnedOn = true;
            } else {
                isTurnedOn = true;
            }
        }
    }

    private void checkAndIncrementTurnedOn(final Room room) {
        ValidationFactory.getInstance().validateTurnedOn(isTurnedOn);
        ValidationFactory.getInstance().validateCountTurnedOnInTheRoom(countTurnedOn, room);
        countTurnedOn++;
    }

    public void turnOff() {
        ValidationFactory.getInstance().validateTurnedOff(isTurnedOn);
        countTurnedOn--;
        isTurnedOn = false;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public abstract double getPower();

    public abstract Appliance getName();

    public abstract String getMark();

    public abstract void setPlugType(PlugType type);
}
