package homework4.task19;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by koval on 19.11.2016.
 */
public class ValidationFactory {

    private static final String TITLE_INCORRECT = "Title can not be a null or empty";
    private static final String ARTICLES_NULL = "The list of articles can not be null";
    private static final String PAGE_ILLEGAL = "The page can not be less than 0";
    private static final String ARTICLE_NULL = "The article can not be null";

    private static final ValidationFactory instance = new ValidationFactory();

    public static ValidationFactory getInstance() {
        return instance;
    }

    private ValidationFactory() { }

    public void validate(final String title) {
        if (StringUtils.isEmpty(title)) {
            throw new IllegalStateException(TITLE_INCORRECT);
        }
    }

    public void validate(final List<Article> articles) {
        if (articles == null) {
            throw new IllegalStateException(ARTICLES_NULL);
        }
    }

    public void validateNumber(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException(PAGE_ILLEGAL);
        }
    }

    public void validate(final Article article) {
        if (article == null) {
            throw new IllegalArgumentException(ARTICLE_NULL);
        }
    }


}
