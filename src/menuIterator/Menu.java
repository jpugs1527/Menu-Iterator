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

    public Menu(int menuSize) {
        arr = new MenuItem[menuSize];
    }

    //Maybe refactor to use an ArrayUtils method
    public void append(MenuItem item) {

        arr[index] = item;
        index++;
    }

    public void remove(MenuItem item) {

    }

    public MenuIterator allItemsIterator() {

        this.index = 0;
        return new MenuIterator() {
            @Override
            public boolean hasNext() {
                return index < arr.length;
            }

            @Override
            public MenuItem next() {
                if (index >= arr.length) {
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
        final int itemType = category;

        return new MenuIterator() {
            @Override
            public boolean hasNext() {
                return index < arr.length;
            }

            @Override
            public MenuItem next() {
                if (index >= arr.length) {
                    throw new NoSuchElementException();
                } else if (itemType == arr[index].getCategory()) {
                    MenuItem nextItem = arr[index];
                    index++;
                    return nextItem;
                } else if (this.hasNext()){
                    index++;
                    return next();
                }
                throw new NoSuchElementException();
            }
        };

    }

    public MenuIterator heartHealthyIterator() {

        this.index = 0;

        return new MenuIterator() {
            @Override
            public boolean hasNext() {
                return index < arr.length;
            }

            @Override
            public MenuItem next() {
                MenuItem item = arr[index];
                index++;
                    if (!(index < arr.length)) {
                        throw new NoSuchElementException();
                    }else if (item.getHeartHealthy()) {

                        return item;
                    } else if (this.hasNext()) {
                        return next();
                    }
                index = 0;
                throw new NoSuchElementException();
            }
        };

    }

    public MenuIterator priceIterator(double passedPrice) {

        this.index = 0;
        final double price = passedPrice;

        return new MenuIterator() {
            @Override
            public boolean hasNext() {
                return index < arr.length;
            }

            @Override
            public MenuItem next() {
                MenuItem item = arr[index];
                if (!(index < arr.length)) {
                    throw new NoSuchElementException();
                }else if (item.getPrice() < price) {
                    index++;
                    return item;
                } else if (this.hasNext()) {
                    index++;
                    return next();
                }
                index = 0;
                throw new NoSuchElementException();

            }
        };
    }
}