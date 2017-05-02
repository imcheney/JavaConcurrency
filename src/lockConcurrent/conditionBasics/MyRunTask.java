package lockConcurrent.conditionBasics;

/**
 * Created by Chen on 02/05/2017.
 */
public class MyRunTask implements Runnable {
    private MyService myService;

    public MyRunTask(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.await();
    }
}
