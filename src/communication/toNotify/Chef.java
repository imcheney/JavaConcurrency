package communication.toNotify;

/**
 * Created by Chen on 24/04/2017.
 */
public class Chef implements Runnable{
    public Food food;

    public Chef(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        try {
            synchronized (food) {
                System.out.println("before notify...");
                Thread.currentThread().sleep(5000);  //chef prepared dish for 5 sec
                food.notifyAll();  //chef notify waiter
                System.out.println("after notify, I put knife and fork into it and take 3 more sec...");
                Thread.currentThread().sleep(3000);
                System.out.println("chef's work done!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
