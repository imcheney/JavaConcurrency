package communication.comBySharedData;

import java.util.*;

/**
 * Created by Chen on 24/04/2017.
 */
public class MyList {
    volatile private List list = new ArrayList(); //volatile关键字必须加在这里

    public int getSize() {
        return list.size();
    }

    public void addProduct() {
        list.add("aProduct");
    }
}
