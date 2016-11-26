package homework4.task19;

/**
 * Created by Sergey on 19.11.2016.
 */
public class Article implements Cloneable {

    private final String title;
    private String text;

    Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public Article clone() {

        Article article = null;

        try {
            article = (Article) super.clone();
        } catch (final CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return article;
    }

    @Override
    public boolean equals(Object other) {

        if (this == other) {
            return true;
        }

        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }

        Article article = (Article) other;

        if (title != null ? !title.equals(article.title) : article.title != null) {
            return false;
        }

        return text != null ? text.equals(article.text) : article.text == null;

    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
