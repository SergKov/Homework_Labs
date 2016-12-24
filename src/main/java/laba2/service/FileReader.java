package laba2.service;

import laba2.Sentence;
import laba2.utils.Sentences;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by koval on 17.12.2016.
 */
public class FileReader extends Reader {

    @Override
    public List<Sentence> read(final String name) throws IOException {

        final Path pathToFile = Paths.get(name);
        final byte[] allBytes = Files.readAllBytes(pathToFile);
        final String resultString = new String(allBytes);
        final String[] allSentences = resultString.split(SENTENCE_DELIMITER);

        return Sentences.toListSentence(allSentences);
    }
}
