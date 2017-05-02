package basicControl.interruptToEnd;

/**
 * Created by Chen on 2017/3/25.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i=0; i<5000000; i++) {
                if (this.isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " is interrupted!");
                    throw new InterruptedException();
                }
                System.out.println("i = "+i);
            }
            System.out.println("I am the leftover code.");  //will not print this
        } catch (InterruptedException e) {
            System.out.println("enters "+Thread.currentThread().getName()+"'s catch");
            e.printStackTrace();   //这个会导致异常的显示, 如果去掉就会显得程序很正常
            System.out.println("在MyThreadB的catch块里, 一切结束了.");
        }
    }
}
