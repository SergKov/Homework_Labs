package homework4.task23;

/**
 * Created by Sergey on 19.11.2016.
 *
 * State
 */
public interface GrantOrder {

    String CREATED = "CREATED";
    String PROCESSED = "PROCESSED";
    String POSTPONED = "POSTPONED";
    String DECLINED = "DECLINED";
    String CONFIRMED = "CONFIRMED";
    String WITHDRAWN = "WITHDRAWN";

    enum State {
        CREATED, PROCESSED, POSTPONED, DECLINED, CONFIRMED, WITHDRAWN;
    }

    void create();

    void process();

    void postpone();

    void decline();

    void confirm();

    void withdraw();

    State getState();
}