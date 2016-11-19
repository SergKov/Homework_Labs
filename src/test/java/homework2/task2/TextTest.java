package homework2.task2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by koval on 08.11.2016.
 */
public class TextTest {

    private final Text text = new Text();

    @Test
    public void requireResultWithSetTitle() {
        text.setTitle("Java");
        final String result = text.getTitle();
        final String title = "Java";
        assertEquals(result, title);
    }

    @Test
    public void requireResultWithAddSentence() {

        final Text.Word word1Sentence1 = new Text.Word("About");
        final Text.Word word2Sentence1 = new Text.Word("Java");

        final Text.Sentence sentence1 = new Text.Sentence(Arrays.asList(word1Sentence1, word2Sentence1));

        final Text.Word word1Sentence2 = new Text.Word("And");
        final Text.Word word2Sentence2 = new Text.Word("JS");

        final Text.Sentence sentence2 = new Text.Sentence(Arrays.asList(word1Sentence2, word2Sentence2));

        final Text text = new Text("Java", Arrays.asList(sentence1, sentence2));

//        text.setTitle("Java");
//        text.addSentence(sentence1);
//        text.addSentence(sentence2);


        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        text.printAllText();
        final String output = new String(baos.toByteArray());

        assertTrue(output.contains("Java"));
    }

    @Test
    public void requireResultWithClone() throws CloneNotSupportedException {
        text.equals(text.clone());
    }
}
