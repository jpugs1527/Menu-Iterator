package menuIterator;

import java.util.Scanner;

public class MenuClient {

    public static void main(String[] args) {
        Menu menu = new Menu();

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
        // displayMenu();
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
                        item = itr.next();
                        if (item.getCategory() == Menu.APPETIZER) {

                            System.out.println(item.getItemName() + " $" + item.getPrice());
                        }

                    }
                    break;
                case 3:
                    itr = menu.itemIterator(Menu.MAIN_DISH);
                    System.out.println("-----DISPLAY ALL MAIN DISHES---------");
                    while (itr.hasNext()) {
                        item = itr.next();
                        if (item.getCategory() == Menu.MAIN_DISH) {

                            System.out.println(item.getItemName() + " $" + item.getPrice());
                        }

                    }
                    break;
                case 4:
                    itr = menu.itemIterator(Menu.DESSERT);
                    System.out.println("--------DISPLAY ALL DESSERTS-----");
                    while (itr.hasNext()) {
                        item = itr.next();
                        if (item.getCategory() == Menu.DESSERT) {

                            System.out.println(item.getItemName() + " $" + item.getPrice());
                        }

                    }
                    break;
                case 5:
                    itr = menu.heartHealthyIterator();
                    // display(itr, item);
                    while (itr.hasNext()) {
                        item = itr.next();
                        if (item.getHeartHealthy()) {
                            System.out.println(item.getItemName() + " $" + item.getPrice());
                        }

                    }

                    System.out.println("ALL MENU ITEMS");
                    break;
                case 6:
                    System.out.print("Enter a specified price: ");
                    double p = scan.nextDouble();

                    itr = menu.priceIterator(p);
                    while (itr.hasNext()) {
                        item = itr.next();
                        System.out.println(item.getItemName() + " $" + item.getPrice());

                    }
                    break;
                case 7:
                    String newItemName = "";
                    System.out.print("Enter item name: ");
                    String name = scan.next();
                    System.out.println();
                    
                    double newItemPrice = 0.0;
                    System.out.print("Enter item price: ");
                    double price = scan.nextDouble();
                    System.out.println();
                    
                    int newItemCategory = 0;
                    System.out.print("Enter item category (1 - Appetizer, 2 - Main Dish, 3 - Dessert): ");
                    int category = scan.nextInt();
                    System.out.println();
                    if (category != 1 || category != 2 || category != 3) {
                        System.err.println("Invalid entry...Try again...(1 - Appetizer, 2 - Main Dish, 3 - Dessert)");
                        category = scan.nextInt();
                        System.out.println();
                    }
                    
                    
                    boolean newItemHealthy = false;
                    String response = "";
                    System.out.print("Is the new item heart healthy? Y/N: ");
                    response = scan.next();
                    System.out.println();
                    if (response.toLowerCase() == "y") {
                        newItemHealthy = true;
                    } else if (response.toLowerCase() == "n") {
                        newItemHealthy = false;
                    } else {
                        System.err.println("Invalid entry...Try again...(Y/N): ");
                        response = scan.next();
                        System.out.println();
                    }
                    
                    menu.append(new MenuItem(newItemName, newItemPrice, newItemCategory, newItemHealthy));
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
        System.out.println("7-Add menu item");
        System.out.println("8-Remove menu item");
        System.out.print("Choose an option: ");
    }

}
