package homework4.task22;

import homework4.task19.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 20.11.2016.
 */
public class Subscriber {

    private static final String PUBLISHER_NULL = "Publisher is null";

    private final PostOffice postOffice = PostOffice.getInstance();
    private final List<Article> articles = new ArrayList<>();

    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(final Publisher publisher) {
        final Article article = publisher.getArticle();

        if (article != null) {
            articles.add(article);
        }
    }

    public void subscribe(final Publisher publisher) {
        if (publisher == null) {
            throw new IllegalArgumentException(PUBLISHER_NULL);
        }

        postOffice.addSubscription(publisher, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriber that = (Subscriber) o;

        if (postOffice != null ? !postOffice.equals(that.postOffice) : that.postOffice != null) return false;
        if (articles != null ? !articles.equals(that.articles) : that.articles != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = postOffice != null ? postOffice.hashCode() : 0;
        result = 31 * result + (articles != null ? articles.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
