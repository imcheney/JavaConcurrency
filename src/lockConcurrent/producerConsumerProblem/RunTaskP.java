package lockConcurrent.producerConsumerProblem;

/**
 * Created by Chen on 02/05/2017.
 */
public class RunTaskP implements Runnable{
    private MyService myService;

    public RunTaskP(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        while (true) {
            myService.set();
        }
    }
}
