package concurrent.SynSthInsideBrancket;

/**
 * Created by Chen on 24/04/2017.
 */
public class MyTask implements Runnable{
    private Student student;
    private Service service;

    public MyTask(Student student, Service service) {
        this.student = student;
        this.service = service;
    }

    @Override
    public void run() {
        service.addAge(student);
    }

}
