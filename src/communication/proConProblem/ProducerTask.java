package communication.proConProblem;

/**
 * Created by Chen on 24/04/2017.
 */
public class ProducerTask implements Runnable{
    private Producer producer;

    public ProducerTask(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true) {
            producer.putEgg();
        }
    }
}
