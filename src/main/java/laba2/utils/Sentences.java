package laba2.utils;

import laba2.PunctualMark;
import laba2.Sentence;
import laba2.Word;

import java.util.*;

import static laba2.controller.Controller.*;

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

    public static Sentence swapWords(final Sentence words) {

        final List<Word> listWords = words.getWords();

        if (words.getWords().size() > 1) {
            Word tmp = words.getWords().get(0);
            listWords.set(0, listWords.get(listWords.size() - 1));
            listWords.set(listWords.size() - 1, tmp);
        }

        return new Sentence(listWords);
    }
}
