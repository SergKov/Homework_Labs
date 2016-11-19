package homework2.task5;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by koval on 17.11.2016.
 */
public class ComputerTest {

    @Test(expected = IllegalStateException.class)
    public void requireResultWithEmptyParameters() {
        final Computer computer = new Computer(null, null, null);
    }


    @Test
    public void requireResultWithParameters() {
        final Computer.RAM ram = new Computer.RAM(Computer.RAM.Maker.G_SKILL, 4, 1028);
        final Computer.CPU cpu = new Computer.CPU(Computer.CPU.Maker.INTEL, 2);
        final Computer.OS os = new Computer.OS(Computer.OS.Type.LINUX);

        final Computer computer = new Computer(ram, cpu, os);

        assertNotNull(computer);
    }
}
