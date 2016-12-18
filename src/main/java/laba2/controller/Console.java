package laba2.controller;

import laba2.Sentence;
import laba2.Word;
import laba2.utils.Sentences;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 17.12.2016.
 */
public class Console extends Controller {

    @Override
    public List<Sentence> read(final String string) {
        final String[] allSentences = string.split(SENTENCE_DELIMITER);
        return Sentences.toListSentence(allSentences);
    }

    @Override
    public void printRevert(final List<Sentence> sentences) {

        final List<Sentence> result = swapWords(sentences);

        result.forEach(System.out::print);
    }

    @Override
    public void writeRevert(String src, List<Sentence> sentences) {
        throw new UnsupportedOperationException();
    }
}
