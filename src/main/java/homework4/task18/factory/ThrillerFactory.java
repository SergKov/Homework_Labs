package homework4.task18.factory;

import homework4.task18.movies.EnglishThriller;
import homework4.task18.abstract_classes.Thriller;
import homework4.task18.movies.UkrainianThriller;

import static homework4.task18.factory.ValidationFactory.*;

/**
 * Created by Sergey on 20.11.2016.
 */
public class ThrillerFactory implements MovieFactory {

    public static final ThrillerFactory THRILLER_FACTORY = new ThrillerFactory();

    private ThrillerFactory() { }

    @Override
    public Thriller getMovie(Language language) {

        VALIDATION_FACTORY.validate(language);

        if (language == Language.UK) {
            return new UkrainianThriller();
        } else {
            return new EnglishThriller();
        }
    }
}
