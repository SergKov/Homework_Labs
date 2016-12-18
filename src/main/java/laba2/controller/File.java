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

    public File(String name) {
        super(name);
    }

    @Override
    public List<Sentence> read() throws IOException {

        final Path pathToFile = Paths.get(name);
        final byte[] allBytes = Files.readAllBytes(pathToFile);
        final String resultString = new String(allBytes);
        final String[] allSentence = resultString.split(SENTENCE_DELIMITER);

        return Sentences.toListSentence(allSentence);
    }

    @Override
    public void print(List<Sentence> src) throws IOException {

        FileWriter fileWriter = new FileWriter(name);
        for (Sentence sentence : src) {
            fileWriter.write(sentence.toString());
        }
        fileWriter.close();
    }
}
