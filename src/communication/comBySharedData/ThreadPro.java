package communication.comBySharedData;
import java.util.*;
/**
 * Created by Chen on 24/04/2017.
 */
public class ThreadPro extends Thread{
    private MyList myList;

    public ThreadPro(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                myList.addProduct();
                System.out.println("a product put into myList;");
                Thread.sleep(1000);  //当前线程睡1秒
            }
        } catch (InterruptedException e) {
            System.out.println("生产者已经退出.");
        }
    }
}
