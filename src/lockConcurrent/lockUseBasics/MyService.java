package lockConcurrent.lockUseBasics;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Chen on 02/05/2017.
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    public void generateNum() {
        System.out.println("before lock");
        lock.lock();
        String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 5; i++) {
            System.out.println(String.format("%s ---- num: %d", threadName, i));
        }
        lock.unlock();
        System.out.println("after lock");
    }
}
