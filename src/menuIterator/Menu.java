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
    public static boolean HEARTHEALTHY = true;
    public static final boolean NOTHEARTHEALTHY = false;

    public Menu() {
        arr = new MenuItem[50];
    }

    //Maybe refactor to use an ArrayUtils method
    public void append(MenuItem item) {
        arr[index] = item;
        index++;
    }

    public void remove(MenuItem item) {
        arr = ArrayUtils.removeElement(arr, item);
    }

    public MenuIterator allItemsIterator() {

        this.index = 0;
        int end = arr.length;
        MenuItem item;
        return new MenuIterator() {
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
        };
    }

    public MenuIterator itemIterator(int category) {

        this.index = 0;
        int end = arr.length;
        int itemType = category;

        return new MenuIterator() {
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
        };

    }

    public MenuIterator heartHealthyIterator() {

        this.index = 0;
        int end = arr.length;

        return new MenuIterator() {
            @Override
            public boolean hasNext() {
                return index <= end;
            }

            @Override
            public MenuItem next() {
                MenuItem item = arr[index];
                while (index < arr.length) {
                    if (item.getHeartHealthy()) {
                        index++;
                        return item;
                    } else {
                        index++;
                        next();
                    }
                }
                throw new NoSuchElementException();
            }
        };

    }

    public MenuIterator priceIterator(double passedPrice) {

        this.index = 0;
        int end = arr.length;
        double price = passedPrice;

        return new MenuIterator() {
            @Override
            public boolean hasNext() {
                return index <= end;
            }

            @Override
            public MenuItem next() {
                MenuItem item = arr[index];
                while (index < arr.length) {
                    if (item.getPrice() < price) {
                        index++;
                        return item;
                    } else {
                        index++;
                        next();
                    }
                }
                throw new NoSuchElementException();
            }
        };
    }
}
