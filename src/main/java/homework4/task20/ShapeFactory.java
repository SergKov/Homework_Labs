package homework4.task20;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by koval on 23.11.2016.
 */
public class ShapeFactory {

    private static final ShapeFactory instance = new ShapeFactory();

    public static ShapeFactory getInstance() {
        return instance;
    }

    public static final String S_SHAPE = "S-shape";
    public static final String Z_SHAPE = "Z-shape";
    public static final String T_SHAPE = "T-shape";
    public static final String L_SHAPE = "L-shape";
    public static final String LINE_SHAPE = "Line-shape";
    public static final String MIRROREDL_SHAPE = "MirroredL-shape";
    public static final String SQUARE_SHAPE = "Square-shape";

    public static final Set<String> allNames = new HashSet<>(Arrays.asList(S_SHAPE, Z_SHAPE, T_SHAPE, L_SHAPE,
            LINE_SHAPE, MIRROREDL_SHAPE, SQUARE_SHAPE));

    private ShapeFactory() { }

    public Shape createShape(final String name) {
        ValidationFactory.getInstance().validateNull(name);
        ValidationFactory.getInstance().validate(name);
        return new Shape(name);
    }
}
