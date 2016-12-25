package homework6.task35;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by koval on 25.12.2016.
 */
public class MyCyclingBarrier {

    private final Runnable barrierAction;

    private int count;
    private int repeatCount;

    public MyCyclingBarrier(int count, Runnable barrierAction) {
        this.count = count;
        this.repeatCount = count;
        this.barrierAction = barrierAction;
    }

    public MyCyclingBarrier(int count) {
        this(count, null);
    }

    public synchronized void await() {

        while (count > 0) {
            --count;
            try {
                wait();
            } catch (final InterruptedException e) { }
        }

        if (barrierAction != null) {
            barrierAction.run();
        }
        notifyAll();
        count = repeatCount;
    }

    public static void main(String[] args) {
        final MyCyclingBarrier myCyclingBarrier = new MyCyclingBarrier(3);
        Thread thread1 = new Thread(new MyRunner(myCyclingBarrier));
        thread1.start();
        Thread thread2 = new Thread(new MyRunner(myCyclingBarrier));
        thread2.start();
        Thread thread3 = new Thread(new MyRunner(myCyclingBarrier));
        thread3.start();
    }
}

class MyRunner implements Runnable {

    private MyCyclingBarrier myCyclingBarrier;

    public MyRunner(MyCyclingBarrier myCyclingBarrier) {
        this.myCyclingBarrier = myCyclingBarrier;
    }

    @Override
    public void run() {
        System.out.println("start" + Thread.currentThread().getName());
        myCyclingBarrier.await();
        System.out.println(Thread.currentThread().getName() + " done!");
    }
}

