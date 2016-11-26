package homework4.task20;

import java.util.Arrays;
import java.util.EnumSet;
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

    public static final EnumSet<Figure> ALL_FIGURES = EnumSet.of(Figure.S_SHAPE, Figure.Z_SHAPE, Figure.T_SHAPE,
            Figure.L_SHAPE, Figure.LINE_SHAPE, Figure.MIRROREDL_SHAPE, Figure.SQUARE_SHAPE);

    private ShapeFactory() { }

    public Shape createShape(final Figure name) {
        ValidationFactory.getInstance().validateNull(name);
        return new Shape(name);
    }
}
