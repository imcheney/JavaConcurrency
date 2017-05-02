package lockConcurrent.conditionSeparate;

/**
 * Created by Chen on 02/05/2017.
 */
public class MyRunTaskA implements Runnable {
    private MyService myService;

    public MyRunTaskA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.awaitA();
    }
}
