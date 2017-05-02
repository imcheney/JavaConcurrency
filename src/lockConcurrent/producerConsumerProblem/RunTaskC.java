package lockConcurrent.producerConsumerProblem;

/**
 * Created by Chen on 02/05/2017.
 */
public class RunTaskC implements Runnable{
    private MyService myService;

    public RunTaskC(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        while(true) {
            myService.get();
        }
    }
}
