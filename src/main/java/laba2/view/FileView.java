package laba2.view;

import laba2.Sentence;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by koval on 23.12.2016.
 */
public class FileView implements View {

    @Override
    public void printRevert(List<Sentence> sentences) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeRevert(String src, List<Sentence> sentences) throws IOException {

        final FileWriter fileWriter = new FileWriter(src);

        for (Sentence sentence : sentences) {
            fileWriter.write(sentence.toString());
        }

        fileWriter.close();
    }
}
