package laba2;

import laba2.controller.Console;
import laba2.controller.Controller;
import laba2.controller.File;

import java.io.IOException;
import java.util.List;

/**
 * Created by koval on 17.12.2016.
 */
public class Text {

    private final Controller controller;

    public Text(Controller controller) {
        this.controller = controller;
    }

    public List<Sentence> read(final String string) throws IOException {
        return controller.read(string);
    }

    public void write(final List<Sentence> sentences) throws IOException {
        controller.printRevert(sentences);
    }

    public static void main(String[] args) throws IOException {
//        Controller controller = new Console();
//        final List<Sentence> sentences = controller.read("A B C. 1 2 3... a b c!!! A B C ?");
//        controller.printRevert(sentences);

        Controller controller1 = new File();
        final List<Sentence> sentences1 = controller1.read("D:/tmp/test.txt");
        controller1.writeRevert("D:/tmp/test.txt", sentences1);
    }
}
