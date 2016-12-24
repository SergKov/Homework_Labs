package laba2;

import laba2.service.ConsoleReader;
import laba2.service.FileReader;
import laba2.service.Reader;
import laba2.view.ConsoleView;
import laba2.view.FileView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
    private final Reader consoleReader = new ConsoleReader();

    @Spy
    private final Reader fileReader = new FileReader();

    @Mock
    private ConsoleView console;

    @Mock
    private FileView file;

    @Test
    public void requireResultFromConsoleWithAllMarks() throws IOException {

        final ConsoleView console = spy(new ConsoleView());
        final Text text = new Text(consoleReader, console);
        final List<Sentence> sentences = text.read("A B C.1 2 3...a b c!!!A B C???");

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        final List<Sentence> revertSentences = text.swapWords(sentences);
        text.print(revertSentences);
        final String output = new String(baos.toByteArray());

        assertEquals("C B A.3 2 1...c b a!!!C B A???", output);
    }

    @Test
    public void requireResultFromConsoleWithLongSentence() throws IOException {

        final ConsoleView console = spy(new ConsoleView());
        final Text text = new Text(consoleReader, console);
        final List<Sentence> sentences = text.read("A B C D E F G.1 2 3...a b c d e f g, h i j : k l m " +
                "; n!!!A B C D 123 11 5 7 10???");

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        final List<Sentence> revertSentences = text.swapWords(sentences);
        text.print(revertSentences);
        final String output = new String(baos.toByteArray());

        assertEquals("G B C D E F A.3 2 1...n b c d e f g, h i j : k l m ; a!!!10 B C D 123 11 5 7 A???", output);
    }

    @Test
    public void requireResultFromFileWithAllMarks() throws IOException {

        final FileView fileView = spy(new FileView());
        final Text text = new Text(fileReader, fileView);
        final List<Sentence> sentences = text.read(PATH_TO_FILE);

        text.write(PATH_TO_FILE, text.swapWords(sentences));

        final List<Sentence> output = text.read(PATH_TO_FILE);

        final StringBuilder sb = new StringBuilder();

        output.forEach(sentence -> {
            sb.append(sentence.toString());
        });

        assertEquals("C B A.C B A.c b a.5 2 3 4 1.", sb.toString());
    }

    @Test
    public void requireArgumentWithReadFromConsole() throws IOException {

        final Text text = new Text(consoleReader, console);
        final Text textSpy = spy(text);

        textSpy.read(SOME_TEXT);
        verify(consoleReader).read(eq(SOME_TEXT));
    }

    @Test
    public void requireInvokeReadConsole() throws IOException {

        final Text text = new Text(consoleReader, console);
        final Text textSpy = spy(text);

        textSpy.read(SOME_TEXT);
        verify(consoleReader, times(1)).read(SOME_TEXT);
    }

    @Test
    public void requireNotInvokeReadFile() throws IOException {

        final Text text = new Text(consoleReader, console);
        final Text textSpy = spy(text);

        textSpy.read(SOME_TEXT);
        verify(fileReader, never()).read(SOME_TEXT);
    }

    @Test
    public void requireArgumentWithReadFromFile() throws IOException {

        final Text text = new Text(fileReader, file);
        final Text textSpy = spy(text);

        textSpy.read(PATH_TO_FILE);
        verify(fileReader).read(eq(PATH_TO_FILE));
    }

    @Test
    public void requireInvokeReadFile() throws IOException {

        final Text text = new Text(fileReader, file);
        final Text textSpy = spy(text);

        textSpy.read(PATH_TO_FILE);
        verify(fileReader, times(1)).read(PATH_TO_FILE);
    }

    @Test
    public void requireNotInvokeReadConsole() throws Exception {

        final Text text = new Text(fileReader, file);
        final Text textSpy = spy(text);

        textSpy.read(PATH_TO_FILE);
        verify(consoleReader, times(0)).read(PATH_TO_FILE);
    }

    @Test
    public void requireArgumentWithWriteToConsole() throws IOException {

        final Text text = new Text(consoleReader, console);
        final Text textSpy = spy(text);
        final List<Sentence> sentences = text.read(SOME_TEXT);

        textSpy.print(sentences);
        verify(consoleReader).read(eq(SOME_TEXT));
    }

    @Test
    public void requireInvokeWriteToConsole() throws IOException {

        final Text text = new Text(consoleReader, console);
        final Text textSpy = spy(text);
        final List<Sentence> sentences = text.read(SOME_TEXT);

        textSpy.print(sentences);
        verify(consoleReader, times(1)).read(SOME_TEXT);
    }

    @Test
    public void requireArgumentWithWriteToFile() throws IOException {

        final Text text = new Text(fileReader, file);
        final Text textSpy = spy(text);
        final List<Sentence> sentences = text.read(PATH_TO_FILE);

        textSpy.write(PATH_TO_FILE, sentences);
        verify(file).writeRevert(eq(PATH_TO_FILE), eq(sentences));
    }

    @Test
    public void requireInvokeWriteToFile() throws IOException {

        final Text text = new Text(fileReader, file);
        final Text textSpy = spy(text);
        final List<Sentence> sentences = text.read(PATH_TO_FILE);

        textSpy.write(PATH_TO_FILE, sentences);
        verify(file).writeRevert(PATH_TO_FILE, sentences);
    }

    @Test
    public void requireNotInvokeWriteToConsole() throws Exception {

        final Text text = new Text(fileReader, file);
        final Text textSpy = spy(text);
        final List<Sentence> sentences = text.read(PATH_TO_FILE);

        textSpy.write(PATH_TO_FILE, sentences);
        verify(console, never()).printRevert(sentences);
    }
}
