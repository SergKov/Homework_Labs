package homework4.task22;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sergey on 20.11.2016.
 *
 * Observer
 */
public class PostOffice {

    private static final PostOffice instance = new PostOffice();

    private static final String ILLEGAL_ARGUMENTS = "Illegal Arguments";

    private static final Logger LOG = Logger.getLogger(PostOffice.class);

    private final Map<Publisher, List<Subscriber>> subscriptions = new HashMap<>();

    private PostOffice() { }

    public static PostOffice getInstance() {
        return instance;
    }

    public void addPublisher(final Publisher publisher) {
        LOG.debug("Adding new publisher");

        if (publisher == null || subscriptions.keySet().contains(publisher)) {
            LOG.warn(ILLEGAL_ARGUMENTS);
            throw new IllegalArgumentException(ILLEGAL_ARGUMENTS);
        }

        subscriptions.put(publisher, new ArrayList<>());
    }

    public void addSubscription(final Publisher publisher, final Subscriber subscriber) {
        LOG.debug("Adding new subscription");

        if (publisher == null || subscriber == null || subscriptions.get(publisher) == null) {
            LOG.warn(ILLEGAL_ARGUMENTS);
            throw new IllegalArgumentException(ILLEGAL_ARGUMENTS);
        }

        subscriptions.get(publisher).add(subscriber);
    }

    public void removeSubscription(final Publisher publisher, Subscriber subscriber) {
        LOG.debug("Remove subscription");

        if (publisher == null || subscriber == null || subscriptions.get(publisher) == null) {
            LOG.warn(ILLEGAL_ARGUMENTS);
            throw new IllegalArgumentException(ILLEGAL_ARGUMENTS);
        }

        subscriptions.get(publisher).remove(subscriber);
    }

    public void notifySubscribers(final Publisher publisher) {
        LOG.debug("Update all publishers");
        final List<Subscriber> subscribers = subscriptions.get(publisher);
        if (CollectionUtils.isNotEmpty(subscribers)) {
            subscribers.forEach(subscriber -> subscriber.update(publisher));
        }
    }
}
