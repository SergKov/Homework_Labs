package laba1;

import laba1.appliances.AbstractAppliance;
import laba1.appliances.Appliance;
import laba1.appliances.ApplianceFactory;
import laba1.appliances.PlugType;
import laba1.sokets.Soket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static laba1.appliances.PlugType.AMERICAN;
import static laba1.appliances.PlugType.EUROPEAN;
import static laba1.appliances.comparators.PowerComparator.DELTA;
import static laba1.sokets.AmericanSoket.AMERICAN_VOLTAGE;
import static laba1.sokets.EuropeanSoket.EUROPIAN_VOLTAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by koval on 01.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplianceTest {

    final AbstractAppliance appliance = ApplianceFactory.getInstance().createAppliance(Appliance.COMPUTER, "HP", 4,
            EUROPEAN);

    @Mock
    private Soket soket;

    @Test
    public void requireStartResult() {
        assertTrue(!appliance.isTurnedOn());
    }

    @Test
    public void requireResultWithTurnOn() {
        appliance.turnOn(soket);
        assertTrue(appliance.isTurnedOn());
    }

    @Test(expected = IllegalStateException.class)
    public void requiredResultTurnOffWithoutTurnOn() {
        appliance.turnOff();
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultWithTurnOnTurnOn() {
        appliance.turnOn(soket);
        appliance.turnOn(soket);
    }

    @Test
    public void requireResultWithTurnOnTurnOff() {
        appliance.turnOn(soket);
        appliance.turnOff();
        assertTrue(!appliance.isTurnedOn());
    }

    @Test
    public void requreResultPlugTypeWithTurnOn() {

        when(soket.getPlugType()).thenReturn(EUROPEAN);

        appliance.turnOn(soket);

        final PlugType expected = EUROPEAN;
        final PlugType result = appliance.getPlugType();

        assertEquals(expected, result);
    }

    @Test
    public void requireResultWithAnotherPlugType() {

        when(soket.getPlugType()).thenReturn(AMERICAN);
        appliance.turnOn(soket);

        assertTrue(appliance.isTurnedOn());
    }

    @Test
    public void requireResultEuropianSoketWithGetPower() {

        when(soket.getVoltage()).thenReturn(EUROPIAN_VOLTAGE);
        when(soket.getPlugType()).thenReturn(EUROPEAN);

        appliance.turnOn(soket);

        final double expected = 220 * 4;
        final double result = appliance.getPower();

        assertEquals(expected, result, DELTA);
    }

    @Test
    public void requireResultAmericanSoketWithGetPower() {

        when(soket.getVoltage()).thenReturn(AMERICAN_VOLTAGE);
        when(soket.getPlugType()).thenReturn(AMERICAN);

        appliance.turnOn(soket);

        final double expected = 120 * 4;
        final double result = appliance.getPower();

        assertEquals(expected, result, DELTA);
    }
}
