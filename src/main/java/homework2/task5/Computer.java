package homework2.task5;

/**
 * Created by koval on 17.11.2016.
 */
public class Computer {

    private static final String PARAMETERS_NULL = "These parameters can not be null";
    private static final String ILLEGAL_ARGUMENTS = "Illegal Arguments";

    private RAM ram;
    private CPU cpu;
    private OS os;

    public Computer(RAM ram, CPU cpu, OS os) {
        validate(ram, cpu, os);
        this.ram = ram;
        this.cpu = cpu;
        this.os = os;
    }

    private static void validate(final RAM ram, final CPU cpu, final OS os) {
        if (ram == null || os == null || cpu == null) {
            throw new IllegalStateException(PARAMETERS_NULL);
        }
    }

    static class RAM {
        private final Maker maker;
        private final int space;
        private final int speed;

        public RAM(Maker maker, int space, int speed) {
            validate(maker, space, speed);
            this.maker = maker;
            this.space = space;
            this.speed = speed;
        }

        private static void validate(final Maker maker, final int space, final int speed) {
            if (maker == null || space <= 0 || speed <= 0) {
                throw new IllegalStateException(ILLEGAL_ARGUMENTS);
            }
        }

        enum Maker {
            KINGSTON, GOODRAM, SAMSUNG, KORSAIR, TRANSCEND, G_SKILL
        }

        public Maker getMaker() {
            return maker;
        }

        public int getSpace() {
            return space;
        }

        public int getSpeed() {
            return speed;
        }
    }

    static class OS {

        private static final String ILLEGAL_TYPE_OF_OS = "Type of OS can not be null";

        private final Type type;

        public OS(Type type) {
            validate(type);
            this.type = type;
        }

        private static void validate(final Type type) {
            if (type == null) {
                throw new IllegalStateException(ILLEGAL_TYPE_OF_OS);
            }
        }

        enum Type {
            WINDOWS, LINUX, MAC_OS
        }

        public Type getType() {
            return type;
        }
    }

    static class CPU {
        private final Maker maker;
        private final int speed;

        public CPU(Maker maker, int speed) {
            validate(maker, speed);
            this.maker = maker;
            this.speed = speed;
        }

        private static void validate(final Maker maker, final int speed) {
            if (maker == null || speed <= 0) {
                throw new IllegalStateException(ILLEGAL_ARGUMENTS);
            }
        }

        enum Maker {
            INTEL, AMD
        }

        public Maker getMaker() {
            return maker;
        }

        public int getSpeed() {
            return speed;
        }
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
}
