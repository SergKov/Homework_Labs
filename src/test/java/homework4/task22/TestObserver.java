package homework4.task22;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by koval on 20.11.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestObserver {

    @Spy
    private PostOffice postOffice = PostOffice.getInstance();

    @Spy
    private Subscriber subscriberDima = new Subscriber("Dima");

    @Spy
    private Subscriber subscriberVasa = new Subscriber("Vasa");

    @Spy
    private Publisher publisherBBC = new Publisher("BBC");

    @Test
    public void requireResultWithAddPublisher() {
        postOffice.addPublisher(publisherBBC);
        subscriberDima.subscribe(publisherBBC);
    }

    @Test(expected = IllegalArgumentException.class)
    public void requireResultSubscribeWithNotExistPublisher() {
        subscriberDima.subscribe(publisherBBC);
    }

    @Test
    public void requireResultWithNotifySubscribers() {
        postOffice.addPublisher(publisherBBC);

        subscriberDima.subscribe(publisherBBC);
        subscriberVasa.subscribe(publisherBBC);

        postOffice.notifySubscribers(publisherBBC);

        verify(subscriberDima, times(1)).update(publisherBBC);
        verify(subscriberVasa, times(1)).update(publisherBBC);
    }
}
