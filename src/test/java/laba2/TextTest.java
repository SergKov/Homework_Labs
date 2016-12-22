package laba2;

import laba2.controller.Console;
import laba2.controller.Controller;
import laba2.controller.File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by koval on 18.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TextTest {

    private static final String PATH_TO_FILE = "D:/tmp/test.txt";
    private static final String SOME_TEXT = "A B C.a b c.1 2 33!!!";

    @Spy
    private final Controller consoleController = new Console();

    @Spy
    private final Controller fileController = new File();

    @Test
    public void requireResultFromConsoleWithAllMarks() throws IOException {

        final Text text = new Text(consoleController);
        final List<Sentence> sentences = text.read("A B C.1 2 3...a b c!!!A B C???");

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        text.write(sentences);
        final String output = new String(baos.toByteArray());

        assertEquals("C B A.3 2 1...c b a!!!C B A???", output);
    }

    @Test
    public void requireResultFromConsoleWithLongSentence() throws IOException {

        final Text text = new Text(consoleController);
        final List<Sentence> sentences = text.read("A B C D E F G.1 2 3...a b c d e f g, h i j : k l m " +
                "; n!!!A B C D 123 11 5 7 10???");

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        text.write(sentences);
        final String output = new String(baos.toByteArray());

        assertEquals("G B C D E F A.3 2 1...n b c d e f g, h i j : k l m ; a!!!10 B C D 123 11 5 7 A???", output);
    }

    @Test
    public void requireResultFromFileWithAllMarks() throws IOException {

        final Text text = new Text(fileController);
        final List<Sentence> sentences = text.read(PATH_TO_FILE);

        text.write(PATH_TO_FILE, sentences);

        final List<Sentence> output = text.read(PATH_TO_FILE);

        final StringBuilder sb = new StringBuilder();

        output.forEach(sentence -> {
            sb.append(sentence.toString());
        });

        assertEquals("C B A.C B A.c b a.5 2 3 4 1.", sb.toString());
    }

    @Test
    public void requireArgumentWithReadFromConsole() throws IOException {

        final Text text = new Text(consoleController);
        final Text textSpy = spy(text);

        textSpy.read(SOME_TEXT);
        verify(consoleController).read(eq(SOME_TEXT));
    }

    @Test
    public void requireInvokeReadConsole() throws IOException {

        final Text text = new Text(consoleController);
        final Text textSpy = spy(text);

        textSpy.read(SOME_TEXT);
        verify(consoleController, times(1)).read(SOME_TEXT);
    }

    @Test
    public void requireNotInvokeReadFile() throws IOException {

        final Text text = new Text(consoleController);
        final Text textSpy = spy(text);

        textSpy.read(SOME_TEXT);
        verify(fileController, never()).read(SOME_TEXT);
    }

    @Test
    public void requireArgumentWithReadFromFile() throws IOException {

        final Text text = new Text(fileController);
        final Text textSpy = spy(text);

        textSpy.read(PATH_TO_FILE);
        verify(fileController).read(eq(PATH_TO_FILE));
    }

    @Test
    public void requireInvokeReadFile() throws IOException {

        final Text text = new Text(fileController);
        final Text textSpy = spy(text);

        textSpy.read(PATH_TO_FILE);
        verify(fileController, times(1)).read(PATH_TO_FILE);
    }

    @Test
    public void requireNotInvokeReadConsole() throws Exception {

        final Text text = new Text(fileController);
        final Text textSpy = spy(text);

        textSpy.read(PATH_TO_FILE);
        verify(consoleController, times(0)).read(PATH_TO_FILE);
    }
}
