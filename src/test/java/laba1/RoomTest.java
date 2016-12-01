package laba1;

import laba1.appliances.AbstractAppliance;
import laba1.appliances.Appliance;
import laba1.appliances.ApplianceFactory;
import laba1.appliances.PlugType;
import laba1.sokets.AmericanSoket;
import laba1.sokets.EuropeanSoket;
import laba1.sokets.Soket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static laba1.appliances.Appliance.COMPUTER;
import static laba1.appliances.Appliance.IRON;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by koval on 01.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class RoomTest {

    private final Room room = new Room("First");

    @Spy
    private final List<AbstractAppliance> appliances = room.getAppliances();

    @Spy
    private final List<Soket> sokets = room.getSokets();

    @Mock
    private AbstractAppliance firstAppliance;

    @Mock
    private AbstractAppliance secondAppliance;

    @Mock
    private Soket firstSoket;

    @Mock
    private Soket secondSoket;

    @Test
    public void requireResultWithEmptyList() {
        final List<AbstractAppliance> appliances = room.getAppliances();
        assertThat(appliances, hasSize(0));
    }

    @Test
    public void requireResultWithAddOneElement() {
        room.addAppliance(firstAppliance);
        final List<AbstractAppliance> appliances = room.getAppliances();

        assertThat(appliances, hasSize(1));
    }

    @Test
    public void requireRemoveAppliance() {
        room.addAppliance(firstAppliance);
        room.removeAppliance(firstAppliance.getName());
        final List<AbstractAppliance> appliances = room.getAppliances();

        assertThat(appliances, hasSize(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireRemoveWithNotExistsAppliance() {

        when(firstAppliance.getName()).thenReturn(COMPUTER);
        room.addAppliance(firstAppliance);

        when(secondAppliance.getName()).thenReturn(IRON);
        room.removeAppliance(secondAppliance.getName());
    }

    @Test
    public void requireResultWithNoSokets() {
        final List<Soket> sokets = room.getSokets();
        assertThat(sokets, hasSize(0));
    }

    @Test
    public void requireResultWithAddSoket() {
        room.addSoket(firstSoket);
        final List<Soket> sokets = room.getSokets();

        assertThat(sokets, hasSize(1));
    }

    @Test
    public void requireResultWithTurnOn() {

        room.addSoket(firstSoket);
        room.addSoket(secondSoket);

        final AbstractAppliance firstAppliance = ApplianceFactory.getInstance().createAppliance(Appliance.COOKER,
                "Philips", 23, PlugType.AMERICAN);
        room.addAppliance(firstAppliance);

        final AbstractAppliance secondAppliance = ApplianceFactory.getInstance().createAppliance(Appliance.COOKER,
                "Philips", 23, PlugType.AMERICAN);
        room.addAppliance(secondAppliance);

        room.turnOn(1, 0);

        assertTrue(secondAppliance.isTurnedOn());
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultWithTurnOffWithoutTurnOn() {

        room.addSoket(firstSoket);
        room.addSoket(secondSoket);

        final AbstractAppliance firstAppliance = ApplianceFactory.getInstance().createAppliance(Appliance.COOKER,
                "Philips", 23, PlugType.AMERICAN);
        room.addAppliance(firstAppliance);

        final AbstractAppliance secondAppliance = ApplianceFactory.getInstance().createAppliance(Appliance.COOKER,
                "Philips", 23, PlugType.AMERICAN);
        room.addAppliance(secondAppliance);

        room.turnOff(1, 0);

        assertTrue(secondAppliance.isTurnedOn());
    }

    @Test
    public void requireResultTurnOffWithTurnOn() {

        final Soket firstSoket = new AmericanSoket();
        room.addSoket(firstSoket);

        final Soket secondSoket = new EuropeanSoket();
        room.addSoket(secondSoket);

        final AbstractAppliance firstAppliance = ApplianceFactory.getInstance().createAppliance(Appliance.COOKER,
                "Philips", 20, PlugType.AMERICAN);
        room.addAppliance(firstAppliance);

        final AbstractAppliance secondAppliance = ApplianceFactory.getInstance().createAppliance(Appliance.COOKER,
                "Philips", 17, PlugType.AMERICAN);
        room.addAppliance(secondAppliance);

        room.turnOn(0, 1);
        room.turnOff(0, 1);

        assertFalse(secondAppliance.isTurnedOn());
    }

    @Test
    public void requireResultWithFindAllByName() {

        final AbstractAppliance firstAppliance = ApplianceFactory.getInstance().createAppliance(Appliance.COOKER,
                "Philips", 20, PlugType.AMERICAN);

        final AbstractAppliance secondAppliance = ApplianceFactory.getInstance().createAppliance(Appliance.COOKER,
                "Philips", 17, PlugType.AMERICAN);

        room.addAppliance(firstAppliance);
        room.addAppliance(secondAppliance);

        assertThat(room.findAllByName(Appliance.COOKER), hasItem(firstAppliance));
    }

    @Test
    public void requireResultWithFindAllTurnedOn() {

        final Soket firstSoket = new AmericanSoket();
        room.addSoket(firstSoket);

        final Soket secondSoket = new EuropeanSoket();
        room.addSoket(secondSoket);

        final AbstractAppliance firstAppliance = ApplianceFactory.getInstance().createAppliance(Appliance.COOKER,
                "Philips", 20, PlugType.AMERICAN);
        room.addAppliance(firstAppliance);

        final AbstractAppliance secondAppliance = ApplianceFactory.getInstance().createAppliance(Appliance.COOKER,
                "Philips", 17, PlugType.AMERICAN);
        room.addAppliance(secondAppliance);

        room.turnOn(0, 1);
        room.turnOn(1, 0);

        assertThat(room.findAllTurnedOn(), hasItems(firstAppliance, secondAppliance));
    }

}
