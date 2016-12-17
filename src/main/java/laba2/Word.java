package laba2;

import java.util.List;

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

    @Override
    public String toString() {
        return symbols + " ";
    }
}
