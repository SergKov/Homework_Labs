package laba2;

/**
 * Created by Sergey on 15.12.2016.
 */
public class Word {

    private String symbols;

    public Word(String symbols) {
        this.symbols = symbols;
    }

    public String getSymbols() {
        return symbols;
    }

    public Word addMark(final PunctualMark mark) {
        if (mark != null) {
            return new Word(new StringBuilder().append(new Word(mark.getMarkAsString())).toString());
        } else {
            return new Word("");
        }
    }

    @Override
    public String toString() {
        return symbols;
    }
}
