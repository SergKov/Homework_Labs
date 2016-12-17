package laba2.controller;

import laba2.Sentence;

import java.io.IOException;
import java.util.List;

/**
 * Created by koval on 17.12.2016.
 */
public abstract class Controller {

    public static final String SENTENCE_DELIMITER = "[.!?]+";
    public static final String WORDS_DELIMITER = "[\\s]+";

    protected String name;

    public Controller(String name) {
        this.name = name;
    }

    public abstract List<Sentence> read() throws IOException;

    public abstract void print(List<Sentence> sentences) throws IOException;
}
