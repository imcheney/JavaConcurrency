package communication.toNotify;

/**
 * 饭店问题: 展现wait和notify方法
 * obj.wait, obj.notify调用的都是food.wait, food.notify, 分别于waiter线程和chef线程
 * Created by Chen on 24/04/2017.
 */
public class MainTest1_Notify {
    public static void main(String[] args) {
        Food food = new Food();
        Waiter waiter = new Waiter(food);
        Chef chef = new Chef(food);
        Thread threadA = new Thread(waiter);
        threadA.setName("ThreadWaiter");
        Thread threadB = new Thread(chef);
        threadB.setName("ThreadChef");
        threadA.start();
        threadB.start();
        System.out.println("Main Thread over...");
    }
}
