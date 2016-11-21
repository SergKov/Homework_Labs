package homework4.task18.movies;

import homework4.task18.abstract_classes.Movie;
import homework4.task18.factory.Language;
import org.apache.log4j.Logger;

import static homework4.task18.factory.ValidationFactory.VALIDATION_FACTORY;

/**
 * Created by koval on 20.11.2016.
 */
public class UkrainianComedy extends Movie {

    private static final Logger LOG = Logger.getLogger(UkrainianComedy.class);

    private Language soundTrackLanguage;
    private Language subtitlesLanguage;

    public UkrainianComedy() {
        soundTrackLanguage = Language.UK;
        subtitlesLanguage = Language.UK;
    }

    @Override
    public void show() {
        LOG.debug(soundTrackLanguage.toString() + " "  + subtitlesLanguage);
    }

    public void changeLanguage(final Language toLanguage) {

        VALIDATION_FACTORY.validate(toLanguage);

        if (this.soundTrackLanguage != toLanguage) {
            LOG.debug("You will change a language from " + toLanguage);

            this.soundTrackLanguage = toLanguage;
            this.subtitlesLanguage = toLanguage;

            LOG.debug("To" + toLanguage);
        }
    }

    public Language getSoundTrackLanguage() {
        return soundTrackLanguage;
    }

    public Language getSubtitlesLanguage() {
        return subtitlesLanguage;
    }
}
