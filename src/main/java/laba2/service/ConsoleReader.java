package laba2.service;

import laba2.Sentence;
import laba2.utils.Sentences;

import java.util.List;

/**
 * Created by koval on 17.12.2016.
 */
public class ConsoleReader extends Reader {

    @Override
    public List<Sentence> read(final String string) {
        final String[] allSentences = string.split(SENTENCE_DELIMITER);
        return Sentences.toListSentence(allSentences);
    }
}
