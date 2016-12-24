package laba2.service;

import laba2.Sentence;
import laba2.utils.Sentences;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 17.12.2016.
 */
public abstract class Reader {

    public static final String SENTENCE_DELIMITER = "(?=(?!^)[\\.!\\?])(?<![\\.!\\?])|(?![\\.!\\?])(?<=[\\.!\\?])";
    public static final String WORDS_DELIMITER = "((?<=\\s)|(?=\\s))";

    public abstract List<Sentence> read(final String string) throws IOException;
}
