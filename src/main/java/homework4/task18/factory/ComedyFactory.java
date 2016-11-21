package homework4.task18.factory;

import homework4.task18.movies.EnglishComedy;
import homework4.task18.abstract_classes.Movie;
import homework4.task18.movies.UkrainianComedy;

import static homework4.task18.factory.ValidationFactory.VALIDATION_FACTORY;

/**
 * Created by koval on 20.11.2016.
 */
public class ComedyFactory implements MovieFactory {

    public static final ComedyFactory COMEDY_FACTORY = new ComedyFactory();

    @Override
    public Movie getMovie(final Language language) {

        VALIDATION_FACTORY.validate(language);

        if (language == Language.UK) {
            return new UkrainianComedy();
        } else {
            return new EnglishComedy();
        }
    }
}
