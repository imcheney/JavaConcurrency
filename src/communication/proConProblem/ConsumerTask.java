package communication.proConProblem;

/**
 * Created by Chen on 24/04/2017.
 */
public class ConsumerTask implements Runnable{
    private Consumer consumer;

    public ConsumerTask(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            consumer.eatEgg();
        }
    }
}
