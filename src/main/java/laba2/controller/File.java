package laba2.controller;

import laba2.Sentence;
import laba2.utils.Sentences;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by koval on 17.12.2016.
 */
public class File extends Controller {

    @Override
    public List<Sentence> read(final String name) throws IOException {

        final Path pathToFile = Paths.get(name);
        final byte[] allBytes = Files.readAllBytes(pathToFile);
        final String resultString = new String(allBytes);
        final String[] allSentences = resultString.split(SENTENCE_DELIMITER);

        return Sentences.toListSentence(allSentences);
    }

    @Override
    public void printRevert(List<Sentence> sentences) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeRevert(String src, List<Sentence> sentences) throws IOException {

        final List<Sentence> sentenceList = swapWords(sentences);

        FileWriter fileWriter = new FileWriter(src);
        for (Sentence sentence : sentenceList) {
            fileWriter.write(sentence.toString());
        }
        fileWriter.close();
    }
}
