package laba2.controller;

import laba2.PunctualMark;
import laba2.Sentence;
import laba2.utils.Sentences;

import java.util.*;

/**
 * Created by koval on 17.12.2016.
 */
public class Console extends Controller {

    private final Queue<PunctualMark> queue = new ArrayDeque<>();

    public Console(String string) {
        super(string);
    }

    @Override
    public List<Sentence> read() {

        name.chars().forEach(value -> {
            if (value == DOT || value == EXCLAMATION_MARK || value == QUESTION_MARK) {
                queue.offer(new PunctualMark((char) value));
            }
        });

        final String[] allSentences = name.split(SENTENCE_DELIMITER);
        return Sentences.toListSentence(allSentences);
    }

    @Override
    public void print(List<Sentence> sentences) {
        sentences.forEach(sentence -> {
            System.out.print(Sentences.swapWords(sentence).addMark(queue.poll()));
        });
    }
}
