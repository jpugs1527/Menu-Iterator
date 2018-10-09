package menuIterator;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class MenuClient {

    public static void main(String[] args) {
        Menu menu = new Menu(9);


        menu.append(new MenuItem("Salad", 4.99, Menu.APPETIZER, Menu.HEARTHEALTHY));
        menu.append(new MenuItem("Mac N Cheese Bites", 11.99, Menu.APPETIZER, Menu.NOTHEARTHEALTHY));
        menu.append(new MenuItem("Nachos", 9.99, Menu.APPETIZER, Menu.NOTHEARTHEALTHY));

        menu.append(new MenuItem("Pizza", 19.99, Menu.MAIN_DISH, Menu.NOTHEARTHEALTHY));
        menu.append(new MenuItem("Grilled Chicken", 14.99, Menu.MAIN_DISH, Menu.HEARTHEALTHY));
        menu.append(new MenuItem("Lobster Tail", 29.99, Menu.MAIN_DISH, Menu.HEARTHEALTHY));

        menu.append(new MenuItem("Fruit Cup", 4.99, Menu.DESSERT, Menu.HEARTHEALTHY));
        menu.append(new MenuItem("Cheesecake", 7.89, Menu.DESSERT, Menu.NOTHEARTHEALTHY));
        menu.append(new MenuItem("Cookie Skillet", 9.99, Menu.DESSERT, Menu.NOTHEARTHEALTHY));
        
        MenuItem item;
        int option;
        Scanner scan = new Scanner(System.in);
        MenuIterator itr;

        // display options
        do {
            displayMenu();
            option = scan.nextInt();
            switch (option) {

                case 1:
                    itr = menu.allItemsIterator();
                    while (itr.hasNext()) {
                        item = itr.next();

                        System.out.println(item.getItemName() + " $" + item.getPrice());

                    }

                    break;
                case 2:
                    itr = menu.itemIterator(Menu.APPETIZER);
                    while (itr.hasNext()) {
                        try {
                            item = itr.next();
                            System.out.println(item.getItemName() + " $" + item.getPrice());
                        } catch (NoSuchElementException e) {}
                    }
                    break;
                case 3:
                    itr = menu.itemIterator(Menu.MAIN_DISH);
                    System.out.println("-----DISPLAY ALL MAIN DISHES---------");

                    while (itr.hasNext()) {
                        try {
                            item = itr.next();
                            System.out.println(item.getItemName() + " $" + item.getPrice());
                        } catch (NoSuchElementException e){}
                        }


                    break;
                case 4:
                    itr = menu.itemIterator(Menu.DESSERT);
                    System.out.println("--------DISPLAY ALL DESSERTS-----");
                    while (itr.hasNext()) {
                        try {
                            item = itr.next();

                            System.out.println(item.getItemName() + " $" + item.getPrice());
                        } catch (NoSuchElementException e){}
                    }
                    break;
                case 5:
                    itr = menu.heartHealthyIterator();
                    while (itr.hasNext()) {
                        try {
                            item = itr.next();
                            System.out.println(item.getItemName() + " $" + item.getPrice());
                        } catch (NoSuchElementException e){}
                        }

                    System.out.println("ALL MENU ITEMS");
                    break;
                case 6:
                    try {
                        System.out.print("Enter a specified price: ");
                        String p = scan.next();

                        double passedPrice = Double.parseDouble(p);
                        itr = menu.priceIterator(passedPrice);
                        while (itr.hasNext()) {
                            item = itr.next();
                            System.out.println(item.getItemName() + " $" + item.getPrice());
                        }
                    } catch (NoSuchElementException e){}
                    break;
            }
        } while (option != 0);

    }

    public static void displayMenu() {
        System.out.println("---------MENU OPTIONS--------------");
        System.out.println("1-Display all menu items");
        System.out.println("2-Display all appetizers");
        System.out.println("3-Display all main dishes");
        System.out.println("4-Display all desserts");
        System.out.println("5-Display all heart healthy items");
        System.out.println("6-Display all main dishes under a specified price");
        System.out.println("0-quit");
        System.out.print("Choose an option: ");
    }

}
