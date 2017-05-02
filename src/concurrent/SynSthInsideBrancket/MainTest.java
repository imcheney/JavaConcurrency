package concurrent.SynSthInsideBrancket;

/**
 * 测试Synchronized(anObj) {
 * code...
 * }
 * 的用法
 *
 * Created by Chen on 24/04/2017.
 */
public class MainTest {
    public static void main(String[] args) {
        Student student = new Student();
        Service service = new Service();
        MyTask myTask = new MyTask(student, service);
        Thread threadA = new Thread(myTask);
        threadA.setName("threadA");
        Thread threadB = new Thread(myTask);
        threadB.setName("threadB");
        threadA.start();
        threadB.start();
    }
}
