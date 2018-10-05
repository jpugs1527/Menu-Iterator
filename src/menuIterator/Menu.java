package menuIterator;

/**
 * @author jordanpuglisi
 */

import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

public class Menu {
    private MenuItem first_item;
    
    int index = 0;
    MenuItem[] arr; //Initialize an array of type MenuItem to hold MenuItem objs
    public static final int APPETIZER = 1;
    public static final int MAIN_DISH = 2;
    public static final int DESSERT = 3;
    public static final boolean HEARTHEALTHY = true;
    public static final boolean NOTHEARTHEALTHY = false;
    
    public Menu() {
        arr = new MenuItem[5];
    }
    
    public void append(MenuItem item) {
        arr[index] = item;
        index++;
    }
    
    public void delete(MenuItem item) {
        arr = ArrayUtils.removeElement(arr, item);
    }
    
    
}
