package communication.toNotify;

/**
 * 如果chef只是使用food.notify, 那么只有一个waiter可以被唤醒并结束, 其他两个waiter都会处于无限期的等待中
 * 这时候, 应该使用的是food.notifyAll()方法
 * Created by Chen on 24/04/2017.
 */
public class MainTest2_NotifyAll {
    public static void main(String[] args) {
        Food food = new Food();
        Waiter waiter = new Waiter(food);
        Chef chef = new Chef(food);

        // we have many waiters
        Thread threadA1 = new Thread(waiter);
        threadA1.setName("ThreadWaiter1");
        Thread threadA2 = new Thread(waiter);
        threadA2.setName("ThreadWaiter2");
        Thread threadA3 = new Thread(waiter);
        threadA3.setName("ThreadWaiter3");

        //only one chef
        Thread threadB = new Thread(chef);
        threadB.setName("ThreadChef");

        //concurrent start
        threadA1.start();
        threadA2.start();
        threadA3.start();
        threadB.start();

        System.out.println("Main Thread over...");
    }
}
