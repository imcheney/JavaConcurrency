package lockConcurrent.conditionSeparate;

/**
 * Created by Chen on 02/05/2017.
 */
public class MyRunTaskB implements Runnable {
    private MyService myService;

    public MyRunTaskB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.awaitB();
    }
}
