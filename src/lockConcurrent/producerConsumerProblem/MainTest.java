package lockConcurrent.producerConsumerProblem;

/**
 * Producer / Consumer problem with Lock & Condition
 * Created by Chen on 02/05/2017.
 * 实现起来有一个坑, 就是condition.await()使用的时候线程必须获得了资源的锁
 * 代码的安排也比较有讲究: try紧跟着lock, finally中才unlock
 */
public class MainTest {
    public static void main(String[] args) {
        MyService myService = new MyService();
        RunTaskP runTaskP = new RunTaskP(myService);
        RunTaskC runTaskC = new RunTaskC(myService);
        Thread threadP = new Thread(runTaskP);
        Thread threadC = new Thread(runTaskC);
        threadP.start();
        threadC.start();
    }
}
