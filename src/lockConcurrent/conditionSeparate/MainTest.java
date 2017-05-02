package lockConcurrent.conditionSeparate;

/**
 * Created by Chen on 02/05/2017.
 */
public class MainTest {
    public static void main(String[] args) {
        try {
            MyService myService = new MyService();
            MyRunTaskA runTaskA = new MyRunTaskA(myService);
            MyRunTaskB runTaskB = new MyRunTaskB(myService);
            Thread threadA = new Thread(runTaskA);
            Thread threadB = new Thread(runTaskB);
            threadA.start();
            threadB.start();
            Thread.sleep(2000);
            myService.signalA();
            System.out.println(Thread.currentThread().getName()+" over.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
