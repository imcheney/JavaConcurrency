package lockConcurrent.lockUseBasics;

/**
 * Created by Chen on 02/05/2017.
 */
public class MyTask implements Runnable{
    private MyService myService;

    public MyTask(MyService myService) {
        this.myService = myService;
    }

    public MyTask() {
    }

    @Override
    public void run() {
        myService.generateNum();
    }
}
