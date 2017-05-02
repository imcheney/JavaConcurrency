package lockConcurrent.producerConsumerProblem;

import java.util.concurrent.locks.*;

/**
 * note: 调用condition.await的时候, 该线程必须获得了lock,
 * 否则将造成java.lang.IllegalMonitorStateException
 * Created by Chen on 02/05/2017.
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public MyService() {
    }

    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                condition.await();  //await会自动释放lock
            }
            {
                hasValue = true;  // put egg in
                Thread.currentThread().sleep(1000);
            }
            condition.signalAll();  //通知, 然后执行完剩余代码, 再交出lock
            System.out.println(String.format("%s put done", Thread.currentThread().getName()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (!hasValue) {
                condition.await();  //await会自动释放lock
            }
            {
                hasValue = false;  // eat egg out
                Thread.currentThread().sleep(1000);
            }
            condition.signalAll();  //通知, 然后执行完剩余代码, 再交出lock
            System.out.println(String.format("%s get done", Thread.currentThread().getName()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
