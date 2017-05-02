package communication.proConProblem;

/**
 * Created by Chen on 24/04/2017.
 */
public class Consumer {
    private Plate plate;

    public Consumer(Plate plate) {
        this.plate = plate;
    }

    public void eatEgg() {
        try {
            synchronized (plate) {
                if (plate.getEgg()==1) {
                    System.out.println("Con: found an egg, start consuming...");
                    plate.setEgg(0);  //eat an egg
                    plate.notify();
                    System.out.println("Con: Egg eaten, notified others...");
                } else {
                    System.out.println("Con: consumer found no egg exists, consumer starts waiting...");
                    plate.wait();  //wait for an egg
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
