package laba2.controller;

import laba2.Sentence;
import laba2.utils.Sentences;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 17.12.2016.
 */
public abstract class Controller {

    public static final String SENTENCE_DELIMITER = "(?=(?!^)[\\.!\\?])(?<![\\.!\\?])|(?![\\.!\\?])(?<=[\\.!\\?])";
    public static final String WORDS_DELIMITER = "((?<=\\s)|(?=\\s))";

    public abstract List<Sentence> read(String src) throws IOException;

    public abstract void printRevert(List<Sentence> sentences) throws IOException;

    public abstract void writeRevert(String name, List<Sentence> sentences) throws IOException;

    public List<Sentence> swapWords(final List<Sentence> sentences) {

        final List<Sentence> result = new ArrayList<>();

        sentences.forEach(sentence -> {
            result.add(Sentences.swapWords(sentence.getWords()));
        });

        return result;
    }
}
