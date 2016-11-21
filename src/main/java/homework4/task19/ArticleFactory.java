package homework4.task19;

import java.util.List;

import static homework4.task19.ValidationFactory.*;

/**
 * Created by koval on 19.11.2016.
 */
public class ArticleFactory {

    public static final ArticleFactory ARTICLE_FACTORY = new ArticleFactory();

    public Article getArticle(final String title, final String text) {
        ValidationFactory.getInstance().validate(title);
        return new Article(text, title);
    }

    public WikiLinks getWikiLinks(final List<Article> articles) {
        ValidationFactory.getInstance().validate(articles);
        return new WikiLinks(articles);
    }
}
