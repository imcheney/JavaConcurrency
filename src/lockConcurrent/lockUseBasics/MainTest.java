package lockConcurrent.lockUseBasics;

/**
 * 测试Lock的基本用法;
 * 用lock.lock(), lock.unlock()划定critical section,
 * 所有相关thread都需要竞争lock
 * Created by Chen on 02/05/2017.
 */
public class MainTest {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyTask myTask = new MyTask(myService);
        Thread threadA = new Thread(myTask);
        Thread threadB = new Thread(myTask);
        Thread threadC = new Thread(myTask);
        Thread threadD = new Thread(myTask);
        Thread threadE = new Thread(myTask);
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
    }
}
