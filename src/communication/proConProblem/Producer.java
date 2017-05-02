package communication.proConProblem;

/**
 * Created by Chen on 24/04/2017.
 */
public class Producer {
    private Plate plate;

    public Producer(Plate plate) {
        this.plate = plate;
    }

    public void putEgg() {
        try {
            synchronized (plate) {
                if (plate.getEgg()==0) {
                    System.out.println("Pro: no eggs, start producing...");
                    plate.setEgg(1);  //put an egg in
                    plate.notify();
                    System.out.println("Pro: produced an egg, notified others...");
                } else {
                    System.out.println("Pro: producer found an egg exists, producer starts waiting...");
                    plate.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
