package homework4.task19;

import org.junit.Assert;
import org.junit.Test;

import static homework4.task19.ArticleFactory.*;
import static org.junit.Assert.*;

/**
 * Created by koval on 19.11.2016.
 */
public class ArticleTest {

    private static final String TITLE = "About Java";
    private static final String TEXT =
            "Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented";
    private static final String TEXT_CHANGED =
            "The original and reference implementation Java compilers, virtual machines, and class libraries were originally released by Sun under proprietary licences";

    private final Article article = ARTICLE_FACTORY.getArticle(TITLE, TEXT);

    @Test
    public void requireResultFullArticleWithClone() {
        assertEquals(article, article.clone());
    }

    @Test
    public void requireResultArticleTextChangedWithClone() {
        article.setText(TEXT_CHANGED);
        assertEquals(article, article.clone());
    }
}
