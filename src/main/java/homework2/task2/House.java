package homework2.task2;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * Created by koval on 17.11.2016.
 */
public class House {

    private static final String INCORRECT_LISTS = "Lists can not be null or empty";
    private static final String INCORRECT_WINDOW_TYPE = "Type of window can not be null";
    private static final String INCORRECT_ARGUMENTS = "Arguments can not be null";

    private final List<Door> doors;
    private final List<Window> windows;

    public House(List<Door> doors, List<Window> windows) {
        validate(doors, windows);
        this.doors = doors;
        this.windows = windows;
    }

    static class Door {
        private final Type type;
        private final Colour colour;

        public Door(Type type, Colour colour) {
            validate(type, colour);
            this.type = type;
            this.colour = colour;
        }

        enum Type {
            PARTICLEBOARD, WOOD, GLASS
        }

        enum Colour {
            WHITE, GREEN, BLACK, BROWN
        }

        public Type getType() {
            return type;
        }

        public Colour getColour() {
            return colour;
        }

        private void validate(final Type type, final Colour colour) {
            if (type == null || colour == null) {
                throw new IllegalStateException(INCORRECT_ARGUMENTS);
            }
        }
    }

    static class Window {
        private final Type type;

        public Window(Type type) {
            validate(type);
            this.type = type;
        }

        enum Type {
            METAL_PLASTIC, GLASS
        }

        public Type getType() {
            return type;
        }

        private void validate(final Type type) {
            if (type == null) {
                throw new IllegalStateException(INCORRECT_WINDOW_TYPE);
            }
        }
    }

    public List<Door> getDoors() {
        return doors;
    }

    public List<Window> getWindows() {
        return windows;
    }

    private void validate(final List<Door> doors, final List<Window> windows) {
        if (CollectionUtils.isEmpty(doors) || CollectionUtils.isEmpty(windows)) {
            throw new IllegalStateException(INCORRECT_LISTS);
        }
    }
}
