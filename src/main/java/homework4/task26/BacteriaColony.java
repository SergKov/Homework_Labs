package homework4.task26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by koval on 24.11.2016.
 */
public class BacteriaColony {

    private final List<Bacteria> bacterias = new ArrayList<>();

    BacteriaColony(Bacteria... bacteria) {
        bacterias.addAll(Arrays.asList(bacteria));
    }

    public void cross() {
        bacterias.add(new Bacteria());
    }

    public List<Bacteria> getBacterias() {
        return bacterias;
    }

    public int size() {
        return bacterias.size();
    }

    public Bacteria getRandomBactery() {
        return bacterias.get((int)(Math.random() * size()));
    }
}
