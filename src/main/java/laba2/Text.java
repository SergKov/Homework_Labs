package laba2;

import laba2.service.Reader;
import laba2.utils.Sentences;
import laba2.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 17.12.2016.
 */
public class Text {

    private final Reader reader;
    private final View view;

    private List<Sentence> sentences;

    public Text(Reader reader, View view) {
        this.reader = reader;
        this.view = view;
    }

    public List<Sentence> read(final String string) throws IOException {
        sentences = reader.read(string);
        return sentences;
    }

    public List<Sentence> swapWords(final List<Sentence> sentences) {

        final List<Sentence> result = new ArrayList<>();

        sentences.forEach(sentence -> {
            result.add(Sentences.swapWords(sentence.getWords()));
        });

        return result;
    }

    public void print(final List<Sentence> sentences) throws IOException {
        view.printRevert(sentences);
    }

    public void write(final String name, final List<Sentence> sentences) throws IOException {
        view.writeRevert(name, sentences);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
