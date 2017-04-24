package communication.comBySharedData;

import java.util.*;

/**
 * Created by Chen on 24/04/2017.
 */
public class MyList {
    private List list = new ArrayList();

    public int getSize() {
        return list.size();
    }

    public void addProduct() {
        list.add("aProduct");
    }
}
