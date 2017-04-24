package communication.comBySharedData;

/**
 * 线程间通信
 * 共享资源方式
 * P线程生产, Con线程采用死循环轮训模式进行检查
 * 缺点: 轮询的死循环本身是一种浪费CPU的资源, 做没有用的工作的行为.
 * Created by Chen on 24/04/2017.
 */
public class MyTest {
    public static void main(String[] args) {
        MyList myList = new MyList();
        ThreadPro pro = new ThreadPro(myList);
        pro.setName("Producer");
        ThreadCon con = new ThreadCon(myList);
        con.setName("Consumer");
        pro.start();
        con.start();
    }
}
