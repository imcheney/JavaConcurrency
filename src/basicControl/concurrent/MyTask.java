package basicControl.concurrent;

/**
 * Created by Chen on 23/04/2017.
 */
public class MyTask implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String tname = Thread.currentThread().getName();
        System.out.println("a task over, name:"+tname);
    }
}
