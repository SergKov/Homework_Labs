package homework4.task26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by koval on 24.11.2016.
 */
public class BacteriaColony {

    private final List<Bacteria> bacterias = new ArrayList<>();

    BacteriaColony(Bacteria bacteria) {
        bacterias.add(bacteria);
    }

    public void cross() {
        final Bacteria bacteria = bacterias.get(0);
        bacterias.add(bacteria);
    }

    public int size() {
        return bacterias.size();
    }

    public Bacteria getRandomBactery() {
        return bacterias.get((int)(Math.random() * size()));
    }
}
