package communication.proConProblem;

/**
 * 在多个生产者, 多个消费者的情形下
 * 如果仍然使用plate.notify(), 容易造成僵局, 即6个线程都处在等待状态...
 * 应当使用plate.notifyAll(), 这样每次都是唤醒所有线程, 不至于消费者叫醒消费者, 生产者叫醒生产者
 * 而能够实现生产者和消费者能互相叫醒的效果
 * Created by Chen on 24/04/2017.
 */
public class MainTest_ManyToMany {
    public static void main(String[] args) {
        Plate plate = new Plate();
        Producer producer = new Producer(plate);
        Consumer consumer = new Consumer(plate);
        ProducerTask producerTask = new ProducerTask(producer);
        ConsumerTask consumerTask = new ConsumerTask(consumer);

        Thread threadPro1 = new Thread(producerTask);
        Thread threadCon1 = new Thread(consumerTask);
        Thread threadPro2 = new Thread(producerTask);
        Thread threadCon2 = new Thread(consumerTask);
        Thread threadPro3 = new Thread(producerTask);
        Thread threadCon3 = new Thread(consumerTask);

        threadPro1.start();
        threadCon1.start();
        threadPro2.start();
        threadCon2.start();
        threadPro3.start();
        threadCon3.start();
    }
}
