package basicControl.interruptToEnd;

/**
 * 如何正确地停止一个线程: 使用myth.isInterrupted方法以及try catch结合, 在main中调用myth.interrupt()
 * Created by Chen on 2017/3/25.
 */
public class MainTest {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.setName("myThread");
            myThread.start();  //start: async without order run: sync with order
            Thread.currentThread().sleep(1000);  //sleep使得**当前main线程**sleep 1000ms
            myThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("===enters main thread catch!");
            e.printStackTrace();
        }
        System.out.println("===main thread end.");
    }
}
