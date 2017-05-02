package communication.toNotify;

/**
 * Created by Chen on 24/04/2017.
 */
public class Waiter implements Runnable {
    public Food food;

    public Waiter(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        try {
            synchronized (food) {
                System.out.println("before wait...");
                System.out.println(Thread.currentThread().getName() + " start waiting for food...");
                food.wait();  //waiter waits for dish
                System.out.println("after wait, I finally got food...");
                System.out.println(Thread.currentThread().getName()+"'s work done!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
