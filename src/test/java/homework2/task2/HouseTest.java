package homework2.task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by koval on 17.11.2016.
 */
public class HouseTest {

    @Test(expected = IllegalStateException.class)
    public void requireResultWithEmptyLists() {
        final House house = new House(Collections.EMPTY_LIST, Collections.EMPTY_LIST);
    }

    @Test
    public void requireResultWithCorrectParameters() {
        final House.Window window1 = new House.Window(House.Window.Type.GLASS);
        final House.Window window2 = new House.Window(House.Window.Type.METAL_PLASTIC);

        final List<House.Window> windows = new ArrayList<House.Window>() {{
            add(window1);
            add(window2);
        }};

        final House.Door door1 = new House.Door(House.Door.Type.GLASS, House.Door.Colour.BLACK);

        final List<House.Door> doors = new ArrayList<House.Door>() {{
            add(door1);
        }};

        final House house = new House(doors, windows);

        assertNotNull(house);
    }

    @Test(expected = IllegalStateException.class)
    public void requireResultWithOneEmptyParameter() {
        final House.Window window1 = new House.Window(House.Window.Type.GLASS);
        final House.Window window2 = new House.Window(House.Window.Type.METAL_PLASTIC);

        final List<House.Window> windows = new ArrayList<House.Window>() {{
            add(window1);
            add(window2);
        }};

        final House.Door door1 = new House.Door(House.Door.Type.GLASS, null);

        final List<House.Door> doors = new ArrayList<House.Door>() {{
            add(door1);
        }};

        final House house = new House(doors, windows);
    }
}
