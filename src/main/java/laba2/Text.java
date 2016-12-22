package laba2;

import laba2.controller.Controller;

import java.io.IOException;
import java.util.List;

/**
 * Created by koval on 17.12.2016.
 */
public class Text {

    private final Controller controller;

    private List<Sentence> sentences;

    public Text(Controller controller) {
        this.controller = controller;
    }

    public List<Sentence> read(final String string) throws IOException {
        sentences = controller.read(string);
        return sentences;
    }

    public void write(final List<Sentence> sentences) throws IOException {
        controller.printRevert(sentences);
    }

    public void write(final String name, final List<Sentence> sentences) throws IOException {
        controller.writeRevert(name, sentences);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
