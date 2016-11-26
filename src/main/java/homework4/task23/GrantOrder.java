package homework4.task23;

/**
 * Created by Sergey on 19.11.2016.
 */
public interface GrantOrder {

    enum State {
        CREATED, PROCESSED, POSTPONED, DECLINED, CONFIRMED, WITHDRAWN;
    }

    void create();

    void process();

    void postpone();

    void decline();

    void confirm();

    void withdraw();

    void getState();
}

/*abstract class C {
    public class D {

    }
}

class E extends C {
    public static void main(String[] args) {
        new E().new D();
    }
}*/