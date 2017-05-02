package communication.comBySharedData;

import java.util.List;

/**
 *
 * Created by Chen on 24/04/2017.
 */
public class ThreadCon extends Thread{
    private MyList myList;

    public ThreadCon(MyList myList) {
        this.myList = myList;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" run starts...");
        try {
            while (true) {
//                System.out.println("myList size:"+myList.getSize());  //注释本句后, 会出现退不出来的情况
                //原因是IO操作是比较慢的, 而循环操作非常快, 在多核cpu中, 会出现cpu不断使用寄存器中的值, 而非去内存中取数的问题.
                if (myList.getSize()==5) {
                    System.out.println("已经有5个产品了, 准备退出...");
                    throw new InterruptedException();  //线程退出专用异常`IE`
                }
            }
        } catch (InterruptedException e) {
            System.out.println("消费者已经退出.");
        }
    }
}
