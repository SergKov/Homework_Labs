package homework4.task22;

import homework4.task19.Article;

/**
 * Created by koval on 21.11.2016.
 */
public class Publisher {

    private final PostOffice postOffice = PostOffice.getInstance();

    private final String name;
    private Article article;

    public Publisher(String name) {
        this.name = name;
    }

    public void updateArticle(final Article article) {
        if (article != null) {
            this.article = article;
            postOffice.notifySubscribers(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (postOffice != null ? !postOffice.equals(publisher.postOffice) : publisher.postOffice != null) return false;
        if (article != null ? !article.equals(publisher.article) : publisher.article != null) return false;
        return name != null ? name.equals(publisher.name) : publisher.name == null;

    }

    @Override
    public int hashCode() {
        int result = postOffice != null ? postOffice.hashCode() : 0;
        result = 31 * result + (article != null ? article.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Article getArticle() {
        return article;
    }

    public String getName() {
        return name;
    }
}
