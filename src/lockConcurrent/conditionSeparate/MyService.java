package lockConcurrent.conditionSeparate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Chen on 02/05/2017.
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    public void awaitA() {
        try {
            lock.lock();
            System.out.println(String.format("%s awaits...", Thread.currentThread().getName()));
            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(String.format("%s end await",Thread.currentThread().getName()));
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println(String.format("%s awaits",Thread.currentThread().getName()));
            conditionB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(String.format("%s end await",Thread.currentThread().getName()));
        }
    }

    public void signalA() {
        try {
            lock.lock();
            System.out.println(String.format("%s signalAll",Thread.currentThread().getName()));
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalB() {
        try {
            lock.lock();
            System.out.println(String.format("%s signalAll",Thread.currentThread().getName()));
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
