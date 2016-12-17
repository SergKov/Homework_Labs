package laba2.controller;

import laba2.Sentence;
import laba2.utils.Sentences;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by koval on 17.12.2016.
 */
public class Console extends Controller {

    public Console(String string) {
        super(string);
    }

    @Override
    public List<Sentence> read() {
        final String[] allSentences = name.split(SENTENCE_DELIMITER);
        return Sentences.toListSentence(allSentences);
    }

    @Override
    public void print(List<Sentence> sentences) {
        sentences.forEach(System.out::println);
    }
}
