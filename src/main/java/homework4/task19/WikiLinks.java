package homework4.task19;

import java.util.ArrayList;
import java.util.List;

import static homework4.task19.ValidationFactory.*;

/**
 * Created by Sergey on 19.11.2016.
 *
 * Pattern Prototype
 */
public class WikiLinks {

    private final List<Article> articles;

    public WikiLinks() {
        this.articles = new ArrayList<>();
    }

    public WikiLinks(List<Article> articles) {
        this.articles = articles;
    }

    public Article getArticle(final int number) {
        ValidationFactory.getInstance().validateNumber(number);
        return articles.get(number).clone();
    }

    public void addArticle(final Article article) {
        articles.add(article);
    }

    public List<Article> getArticles() {
        return articles;
    }
}
