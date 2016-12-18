package laba2;

import laba2.controller.Console;
import laba2.controller.Controller;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by koval on 18.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class SwapWordsTest {

    @Spy
    private final Controller controller = new Console();

    @Mock
    private Sentence sentence;

    @Test
    public void requireResult() {

        Mockito.when(sentence.getWords()).thenReturn(Arrays.asList(new Word("ABC"), new Word("DEG"),
                new Word("1"), new Word("23"), new Word("4")));

        final List<Sentence> sentences = new ArrayList<>();
        sentences.add(sentence);
        final List<Sentence> result = controller.swapWords(sentences);

        Assert.assertEquals(new ArrayList<Sentence>(){{
            add(new Sentence("4 DEG 1 23 ABC"));
        }}, result);

    }
}
