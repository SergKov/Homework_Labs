package laba2;

import laba2.utils.Sentences;

import java.util.List;

/**
 * Created by Sergey on 15.12.2016.
 */
public class Sentence {

    private List<Word> words;

    public Sentence() { }

    public Sentence(List<Word> words) {
        this.words = words;
    }

    public Sentence(String words) {
        this.words = Sentences.toListWords(words);
    }

    public List<Word> getWords() {
        return words;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        words.forEach(sb::append);
        return sb.toString();
    }
}
