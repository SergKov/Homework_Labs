package homework4.task18.factory;

import homework4.task18.abstract_classes.Movie;

/**
 * Created by Sergey on 20.11.2016.
 *
 * AbstractFactory
 */
public interface MovieFactory {

    Movie getMovie(Language language);
}
