package basicControl.runnableToStart;

/**
 * sina的笔试题
 * 如何实现1000个线程, 每个耗时0.2秒, 但是总体在1秒内完成所有任务.
 * 用一个myTask
 * 用循环初始化1000个new Thread(myTask)
 * Created by Chen on 23/04/2017.
 */
public class MyTaskTest {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();  //task可以只有一个
        for (int i=0; i<1000; i++) {
            Thread t = new Thread(myTask);  //但是必须open 1000个独特的threads
            t.start();  //使用start方法就可以并发运行.
        }
        System.out.println("=====main thread over======");
    }
}
