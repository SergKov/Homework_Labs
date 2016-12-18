package laba2;

/**
 * Created by Sergey on 15.12.2016.
 */
public class PunctualMark {

    private final char mark;

    public PunctualMark(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    public String getMarkAsString() {
        return "" + mark;
    }
}
