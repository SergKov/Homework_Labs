package laba2.utils;

import laba2.Sentence;
import laba2.Word;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static laba2.controller.Controller.WORDS_DELIMITER;

/**
 * Created by koval on 17.12.2016.
 */
public class Sentences {

    private Sentences() { }

    public static List<Word> toListWords(String sentence) {

        final List<Word> wordsList = new ArrayList<>();
        final String[] words = sentence.split(WORDS_DELIMITER);

        Arrays.stream(words).forEach(word -> {
            wordsList.add(new Word(word));
        });

        return wordsList;
    }

    public static List<Sentence> toListSentence(final String[] sentences) {

        final List<Sentence> sentenceList = new ArrayList<>();

        Arrays.stream(sentences).forEach(sentence -> {
            sentenceList.add(new Sentence(sentence));
        });

        return sentenceList;
    }

    public static Sentence swapWords(final List<Word> words) {

        if (!CollectionUtils.isEmpty(words)) {
            Collections.swap(words, 0, words.size() - 1);
        }

        return new Sentence(words);
    }
}
