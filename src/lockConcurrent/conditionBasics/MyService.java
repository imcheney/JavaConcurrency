package lockConcurrent.conditionBasics;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Chen on 02/05/2017.
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+" awaits, "+System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " over.");
        }
    }

    public void signal() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " signals, "+System.currentTimeMillis());
        condition.signal();
        lock.unlock();
    }
}
