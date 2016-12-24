package laba2.view;

import laba2.Sentence;

import java.io.IOException;
import java.util.List;

/**
 * Created by koval on 23.12.2016.
 */
public interface View {

    void printRevert(List<Sentence> sentences);

    void writeRevert(String name, List<Sentence> sentences) throws IOException;
}
