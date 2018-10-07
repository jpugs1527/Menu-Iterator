package menuIterator;

/**
 * @author jordanpuglisi
 */
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

public class Menu {

    //private MenuItem first_item;
    int index = 0;
    MenuItem[] arr; //Initialize an array of type MenuItem to hold MenuItem objs
    public static final int APPETIZER = 1;
    public static final int MAIN_DISH = 2;
    public static final int DESSERT = 3;
    public static boolean HEARTHEALTHY = false;
    //public static final boolean NOTHEARTHEALTHY = false;

    public Menu() {
        arr = new MenuItem[5];
    }

    //Maybe refactor to use an ArrayUtils method
    public void append(MenuItem item) {
        arr[index] = item;
        index++;
    }

    public void remove(MenuItem item) {
        arr = ArrayUtils.removeElement(arr, item);
    }

    private class AllItemsIterator implements MenuIterator {

        int index = 0;
        int end;
        MenuItem item;

        public AllItemsIterator(int end) {
            this.end = arr.length;
        }

        @Override
        public boolean hasNext() {
            return index <= end;
        }

        @Override
        public MenuItem next() {
            if (index < 0) {
                throw new NoSuchElementException();
            } else {
                MenuItem nextItem = arr[index];
                index++;
                return nextItem;
            }
        }
    }

    private class ItemIterator implements MenuIterator {

        int index = 0;
        int end;
        int itemType;

        public ItemIterator(int end, int itemType) {
            this.end = arr.length;
            this.itemType = itemType;
        }

        @Override
        public boolean hasNext() {
            return index <= end;
        }

        @Override
        public MenuItem next() {
            MenuItem item = arr[index];
            while (index < arr.length) {
                if (item.getCategory() == itemType) {
                    index++;
                    return item;
                } else {
                    index++;
                    next();
                }
            }
            throw new NoSuchElementException();
        }

    }

}
