package concurrent.SynSthInsideBrancket;

/**
 * Created by Chen on 24/04/2017.
 */
public class Service {
    public void addAge(Student stu) {
        synchronized (stu) {  //要求stu对象只能每次被一个线程访问
            try {
                System.out.println("go in "+Thread.currentThread().getName()+":"+System.currentTimeMillis());
                Thread.currentThread().sleep(2000);
                System.out.println("go out "+Thread.currentThread().getName()+":"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
