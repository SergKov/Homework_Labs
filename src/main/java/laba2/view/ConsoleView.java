package laba2.view;

import laba2.Sentence;

import java.util.List;

/**
 * Created by koval on 23.12.2016.
 */
public class ConsoleView implements View {

    @Override
    public void printRevert(List<Sentence> sentences) {
        sentences.forEach(System.out::print);
    }

    @Override
    public void writeRevert(String name, List<Sentence> sentences) {
        throw new UnsupportedOperationException();
    }
}
