package homework4.task19;

import org.junit.Assert;
import org.junit.Test;

import static homework4.task19.ArticleFactory.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by koval on 19.11.2016.
 */
public class WikiLinksTest {

    private static final String TITLE = "About Java";
    private static final String TEXT = "Java is a general-purpose computer programming";

    private final WikiLinks wikiLinks = new WikiLinks();

    private final Article articleFull = ARTICLE_FACTORY.getArticle(TITLE, TEXT);


    @Test
    public void requireResultGetArticle() {

        wikiLinks.addArticle(articleFull);
        final Article articleClone = wikiLinks.getArticle(0);

        assertEquals(articleFull, articleClone);
    }
}
