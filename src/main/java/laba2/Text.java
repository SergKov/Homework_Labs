package laba2;

import laba2.controller.Console;
import laba2.controller.Controller;
import laba2.utils.Sentences;

import java.io.IOException;
import java.util.*;

/**
 * Created by koval on 17.12.2016.
 */
public class Text {

    private final Controller controller;

    public Text(Controller controller) {
        this.controller = controller;
    }

    public List<Sentence> read() throws IOException {
        return controller.read();
    }

    public void write(final List<Sentence> sentences) throws IOException {
        controller.print(sentences);
    }

    public static void main(String[] args) throws IOException {
        final Text text = new Text(new Console("Abs def. Shjk dhjkl?AAA BBB CCCC! GGG"));
        final List<Sentence> sentenceList = text.read();

        text.write(sentenceList);

//        Text text1 = new Text(new File("D:/tmp/test.txt"));
//        final List<Sentence> result1 = new ArrayList<>();
//
//        final List<Sentence> sentenceList1 = text1.read();
//        sentenceList1.forEach(sentence -> {
//            result1.add(Sentences.swapWords(sentence.getWords()).addMark(new PunctualMark(DOT)));
//        });
//
//        text1.write(sentenceList1);
    }

}
