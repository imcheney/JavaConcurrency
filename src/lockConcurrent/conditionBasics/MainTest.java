package lockConcurrent.conditionBasics;

/**
 * 测试Condition和Lock的配合
 * condition.await ~ obj.wait
 * condition.signal ~ obj.notify
 * Created by Chen on 02/05/2017.
 */
public class MainTest {
    public static void main(String[] args) {
        try {
            MyService myService = new MyService();
            MyRunTask runTask = new MyRunTask(myService);
            Thread threadA = new Thread(runTask);
            threadA.start();
            Thread.currentThread().sleep(3000);
            myService.signal();
            System.out.println("Main over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
