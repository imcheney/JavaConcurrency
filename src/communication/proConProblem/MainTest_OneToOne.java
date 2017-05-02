package communication.proConProblem;

/**
 * 生产者-消费者问题
 * 此处情形是一个生产者一个消费者.
 * 盘子的容量为1.
 * Created by Chen on 24/04/2017.
 */
public class MainTest_OneToOne {
    public static void main(String[] args) {
        Plate plate = new Plate();
        Producer producer = new Producer(plate);
        Consumer consumer = new Consumer(plate);
        ProducerTask producerTask = new ProducerTask(producer);
        Thread threadPro = new Thread(producerTask);
        ConsumerTask consumerTask = new ConsumerTask(consumer);
        Thread threadCon = new Thread(consumerTask);

        threadPro.start();
        threadCon.start();
    }
}
