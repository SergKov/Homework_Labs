package homework4.task18;

import homework4.task18.abstract_classes.Movie;
import homework4.task18.factory.ComedyFactory;
import homework4.task18.factory.Language;
import homework4.task18.factory.MovieFactory;
import homework4.task18.factory.ThrillerFactory;
import homework4.task18.movies.EnglishComedy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by koval on 20.11.2016.
 */
public class TestMovieFactory {

    final MovieFactory comedyFactory = ComedyFactory.COMEDY_FACTORY;
    final MovieFactory thrillerFactory = ThrillerFactory.THRILLER_FACTORY;

    @Test
    public void requireResultWithUkrainianComedyMovie() {
        final Movie ukrainianComedy = thrillerFactory.getMovie(Language.UK);
        ukrainianComedy.show();
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireResultWithNull() {
        final Movie ukrainianThriller = thrillerFactory.getMovie(null);
        ukrainianThriller.show();
    }

    @Test
    public void requireResultWithChangeLanguage() {
        final Movie movie = comedyFactory.getMovie(Language.EN);
        final EnglishComedy englishComedy = (EnglishComedy) movie;
        englishComedy.changeLanguage(Language.UK);

        final Language expected = Language.UK;
        final Language result = englishComedy.getSoundTrackLanguage();

        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireResultChangeWithNull() {
        final Movie movie = comedyFactory.getMovie(Language.EN);
        final EnglishComedy englishComedy = (EnglishComedy) movie;
        englishComedy.changeLanguage(null);
    }
}
