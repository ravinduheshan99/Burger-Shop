import com.sun.source.tree.WhileLoopTree;
import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;
import java.util.*;

class BurgerShop {

    public static String[] customerIds = new String[0];
    public static String[] orderIds = new String[0];
    public static String[] names = new String[0];
    public static int[] qtys = new int[0];
    public static int[] status = new int[0];

    public static final double PRICE = 500.00;

    public static final int PREPARING = 0;
    public static final int DELIVERED = 1;
    public static final int CANCEL = 2;

    public static Scanner input = new Scanner(System.in);

    public static String generateId() {
        if (orderIds.length > 0) {
            String lastId = orderIds[orderIds.length - 1]; //B001

            String[] ar = lastId.split("[B]"); //["","001"]
            int num = Integer.parseInt(ar[1]); //1
            num++; //2

            return String.format("B%03d", num);
        }
        return "B001";
    }

    public static int search(String key, String[] ar) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].equalsIgnoreCase(key)) {
                return i;
            }
        }
        return -1;
    }

    public static void extendAllArrays() {
        String[] tempCustIds = new String[customerIds.length + 1];
        String[] tempOrderIds = new String[customerIds.length + 1];
        String[] tempNames = new String[customerIds.length + 1];
        int[] tempQtys = new int[customerIds.length + 1];
        int[] tempStatus = new int[customerIds.length + 1];

        for (int i = 0; i < customerIds.length; i++) {
            tempCustIds[i] = customerIds[i];
            tempOrderIds[i] = orderIds[i];
            tempNames[i] = names[i];
            tempQtys[i] = qtys[i];
            tempStatus[i] = status[i];
        }

        customerIds = tempCustIds;
        orderIds = tempOrderIds;
        names = tempNames;
        qtys = tempQtys;
        status = tempStatus;
    }

    private static String getStatusText(int orderStatus) {
        switch (orderStatus) {
            case PREPARING:
                return "Preparing";
            case DELIVERED:
                return "Delivered";
            case CANCEL:
                return "Cancelled";
            default:
                return "Unknown";
        }
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }


    public static void placeOrder() {
        L1:
        do {
            System.out.println("_________________________________________________________________________________");
            System.out.println("|                                 PLACE ORDER                                   |");
            System.out.println("---------------------------------------------------------------------------------");
            String orderId = generateId();
            Scanner sc = new Scanner(System.in);
            System.out.println("Order ID : " + orderId);
            System.out.println("=================");
            System.out.print("\nEnter Customer ID : ");
            String custId = input.next();
            if (custId.charAt(0) != '0' || custId.length() != 10) {
                System.out.println("!!!Please Enter a Valid Customer ID!!!");
                continue L1;
            }
            boolean isExist = false;
            String name = "";

            for (int i = 0; i < orderIds.length; i++) {
                if (customerIds[i].equals(custId)) {
                    name = names[i];
                    isExist = true;
                }
            }

            if (!isExist) {
                System.out.print("Customer Name : ");
                name = input.next();
            } else {
                System.out.println("Customer Name : " + name);
            }

            L100:
            while (true) {
                System.out.print("Enter Burger QTY : ");
                int qty;

                try {
                    qty = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("***Please Enter a Valid Quantity (Numeric)***");
                    continue L100;
                }

                if (qty > 0) {
                    System.out.printf("Total value : %.2f%n", (qty * PRICE));

                    System.out.print("\n\tDo you want to place this order? (Y/N) : ");
                    char confirmation = input.next().toUpperCase().charAt(0);

                    if (confirmation == 'Y') {
                        extendAllArrays();

                        orderIds[orderIds.length - 1] = orderId;
                        customerIds[orderIds.length - 1] = custId;
                        names[orderIds.length - 1] = name;
                        qtys[orderIds.length - 1] = qty;
                        //default value is 0

                        System.out.print("\t***Order Placed successfully***");
                        while (true) {
                            System.out.print("\n\tDo you want to place another order? (Y/N) : ");
                            char option = input.next().toUpperCase().charAt(0);
                            if (option == 'Y') {
                                clearConsole();
                                continue L1;
                            } else if (option == 'N') {

                                return;
                            }
                            System.out.println("\n\t\t!!Invalid input!!");
                        }
                    } else if (confirmation == 'N') {
                        while (true) {
                            System.out.print("\n\tDo you want to place another order? (Y/N) : ");
                            char option = input.next().toUpperCase().charAt(0);
                            if (option == 'Y') {
                                clearConsole();
                                continue L1;
                            } else if (option == 'N') {
                                return;
                            }
                            System.out.println("\n\t\t!!Invalid input!!");
                        }
                    }
                } else {
                    System.out.println("***Please Enter a Valid Quantity***");
                    continue L100;
                }
            }
        } while (true);
    }

    public static void bestCustomer() {
        L20:
        while (true) {
            String[] idArrayDupRemoved = new String[0];
            for (int i = 0; i < customerIds.length; i++) {
                if (search(customerIds[i], idArrayDupRemoved) == -1) {
                    String[] tempIdArray = new String[idArrayDupRemoved.length + 1];
                    for (int j = 0; j < idArrayDupRemoved.length; j++) {
                        tempIdArray[j] = idArrayDupRemoved[j];
                    }
                    tempIdArray[tempIdArray.length - 1] = customerIds[i];
                    idArrayDupRemoved = tempIdArray;
                }
            }
            //------------------------------------------------

            String[] nameArrayDupRemoved = new String[0];
            for (int i = 0; i < names.length; i++) {
                if (search(names[i], nameArrayDupRemoved) == -1) {
                    String[] tempnameArray = new String[nameArrayDupRemoved.length + 1];
                    for (int j = 0; j < nameArrayDupRemoved.length; j++) {
                        tempnameArray[j] = nameArrayDupRemoved[j];
                    }
                    tempnameArray[tempnameArray.length - 1] = names[i];
                    nameArrayDupRemoved = tempnameArray;
                }
            }
            //------------------------------------------------
            int[] totalPrice = new int[idArrayDupRemoved.length];
            for (int j = 0; j < idArrayDupRemoved.length; j++) {
                int total = 0;
                for (int i = 0; i < customerIds.length; i++) {
                    if (idArrayDupRemoved[j].equalsIgnoreCase(customerIds[i])) {
                        total += PRICE * qtys[i];
                    }
                }
                totalPrice[j] = total;
            }
            //----------------------------------------------
            for (int i = totalPrice.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (totalPrice[j] < totalPrice[j + 1]) {
                        int temp = totalPrice[j];
                        totalPrice[j] = totalPrice[j + 1];
                        totalPrice[j + 1] = temp;

                        String tempStr = idArrayDupRemoved[j];
                        idArrayDupRemoved[j] = idArrayDupRemoved[j + 1];
                        idArrayDupRemoved[j + 1] = tempStr;

                        String tempStr2 = nameArrayDupRemoved[j];
                        nameArrayDupRemoved[j] = nameArrayDupRemoved[j + 1];
                        nameArrayDupRemoved[j + 1] = tempStr2;

                    }
                }
            }

            System.out.println("_________________________________________________________________________________");
            System.out.println("|                                 BEST CUSTOMER                                 |");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("\n");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("CustomerID\t\t\t\t\tName\t\t\t\t\tTotal");
            System.out.println("---------------------------------------------------------------------------------");

            for (int i = 0; i < idArrayDupRemoved.length; i++) {
                System.out.println(idArrayDupRemoved[i] + "\t\t\t\t\t" + nameArrayDupRemoved[i] + "\t\t\t\t\t  " + totalPrice[i]);
                System.out.println("---------------------------------------------------------------------------------");
            }
            System.out.print("Do you want to go back to main menu? (Y/N) : ");
            Scanner sc = new Scanner(System.in);
            char res = sc.next().toUpperCase().charAt(0);
            if (res == 'Y') {
                break L20;
            } else if (res == 'N') {
                continue L20;
            } else {
                System.out.println("***Please enter a valid input (Y OR N)***");
                continue L20;
            }
        }
    }

    public static void searchOrders() {
        L1:
        while (true) {
            System.out.println("_________________________________________________________________________________");
            System.out.println("|                             SEARCH ORDER DETAILS                               |");
            System.out.println("---------------------------------------------------------------------------------");
            Scanner input2 = new Scanner(System.in);
            System.out.print("\nEnter order Id : ");
            String oid = input2.nextLine();

            boolean orderFound = false;

            for (int i = 0; i < orderIds.length; i++) {
                if (oid.equals(orderIds[i])) {
                    System.out.println("_____________________________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue\t\tOrderStatus |");
                    System.out.println("_____________________________________________________________________________________");
                    System.out.println(orderIds[i] + "\t\t" + customerIds[i] + "\t\t" + names[i] + "\t\t\t" + qtys[i] + "\t\t\t " + (qtys[i] * PRICE) + "\t\t\t " + getStatusText(status[i]) + "  |");
                    System.out.println("_____________________________________________________________________________________");
                    orderFound = true;

                    L2:
                    while (true) {
                        System.out.print("\nDo you want to search another order details? (Y/N) : ");
                        char ans1 = input2.next().toUpperCase().charAt(0);
                        if (ans1 == 'Y') {
                            continue L1;
                        } else if (ans1 == 'N') {
                            break L1;
                        } else {
                            System.out.print("\n***Please Enter a Valid Input***");
                            continue L2;
                        }
                    }

                }
            }

            if (!orderFound) {
                System.out.println("!!Invalid Order Id!!");
                continue L1;
            }
        }
    }

    public static void searchCustomer() {
        Scanner scanner = new Scanner(System.in);

        boolean continueSearching = true;

        L20:
        while (continueSearching) {
            System.out.println("_________________________________________________________________________________");
            System.out.println("|                             SEARCH CUSTOMER DETAILS                           |");
            System.out.println("---------------------------------------------------------------------------------");

            System.out.print("Enter Customer Id (Or Type 'exit' To Mainmenu) : ");
            String res1 = scanner.nextLine();

            if (res1.equalsIgnoreCase("exit")) {
                continueSearching = false;
                break L20;
            }

            boolean customerFound = false;

            for (int a = 0; a < customerIds.length; a++) {
                if (res1.equals(customerIds[a])) {
                    System.out.println("\nCustomerID - " + customerIds[a]);
                    System.out.println("Name - " + names[a]);
                    System.out.println("\nCustomer Order Details");
                    System.out.println("==========================");
                    System.out.println("\n");

                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println("Order_ID\t\t\t\t\tOrder_Quantity\t\t\t\t\tTotal");
                    System.out.println("---------------------------------------------------------------------------------");
                    for (int b = 0; b < customerIds.length; b++) {
                        if (res1.equals(customerIds[b])) {
                            System.out.println(orderIds[b] + "\t\t\t\t\t\t\t" + qtys[b] + "\t\t\t\t\t\t\t" + (qtys[b] * PRICE));
                        }
                    }

                    customerFound = true;
                    break; // No need to continue searching if customer is found
                }
            }

            if (!customerFound) {
                System.out.println("\n\t\t***This customer ID is not added yet***");
            }
        }

        System.out.println("Exiting the search.");
    }

    public static void viewOrders() {
        L4:
        while (true) {
            System.out.println("___________________________________________________________________________________");
            System.out.println("|                                VIEW ORDER DETAILS                               |");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("\n[1] Delivered Order");
            System.out.println("[2] Preparing Order");
            System.out.println("[3] Cancel Order");

            Scanner input3 = new Scanner(System.in);
            L5:
            while (true) {
                System.out.print("\nEnter an option to continue : ");
                int ans2 = input3.nextInt();

                if (ans2 == 1) {
                    System.out.println("________________________________________________________________________________");
                    System.out.println("|                                DELIVERED ORDERS                              |");
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n\n");
                    System.out.println("______________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue |");
                    for (int i = 0; i < orderIds.length; i++) {
                        if (status[i] == 1) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(orderIds[i] + "\t\t" + customerIds[i] + "\t\t" + names[i] + "\t\t\t" + qtys[i] + "\t\t\t " + (qtys[i] * PRICE) + "  |");
                        } else {
                            continue;
                        }

                    }
                    L3:
                    while (true) {
                        System.out.print("\nDo you want to go to home page? (Y/N) : ");
                        char ans3 = input3.next().toUpperCase().charAt(0);
                        if (ans3 == 'Y') {
                            break L4;
                        } else if (ans3 == 'N') {
                            break L5;
                        } else {
                            System.out.print("\n***Please Enter a Valid Input***");
                            continue L3;
                        }
                    }


                } else if (ans2 == 2) {
                    System.out.println("________________________________________________________________________________");
                    System.out.println("|                                PREPARING ORDERS                              |");
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n\n");
                    System.out.println("______________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue |");
                    for (int i = 0; i < orderIds.length; i++) {
                        if (status[i] == 0) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(orderIds[i] + "\t\t" + customerIds[i] + "\t\t" + names[i] + "\t\t\t" + qtys[i] + "\t\t\t " + (qtys[i] * PRICE) + "  |");
                        } else {
                            continue;
                        }

                    }
                    L7:
                    while (true) {
                        System.out.print("\nDo you want to go to home page? (Y/N) : ");
                        char ans4 = input3.next().toUpperCase().charAt(0);
                        if (ans4 == 'Y') {
                            break L4;
                        } else if (ans4 == 'N') {
                            break L5;
                        } else {
                            System.out.print("\n***Please Enter a Valid Input***");
                            continue L7;
                        }
                    }

                } else if (ans2 == 3) {
                    System.out.println("________________________________________________________________________________");
                    System.out.println("|                                CANCEL ORDERS                                 |");
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\n\n");
                    System.out.println("______________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue |");
                    for (int i = 0; i < orderIds.length; i++) {
                        if (status[i] == 2) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(orderIds[i] + "\t\t" + customerIds[i] + "\t\t" + names[i] + "\t\t\t" + qtys[i] + "\t\t\t " + (qtys[i] * PRICE) + "  |");
                        } else {
                            continue;
                        }

                    }
                    L8:
                    while (true) {
                        System.out.print("\nDo you want to go to home page? (Y/N) : ");
                        char ans4 = input3.next().toUpperCase().charAt(0);
                        if (ans4 == 'Y') {
                            break L4;
                        } else if (ans4 == 'N') {
                            break L5;
                        } else {
                            System.out.print("\n***Please Enter a Valid Input***");
                            continue L8;
                        }
                    }

                } else {
                    System.out.print("\n***Please Enter a Valid Input***");
                    continue L5;
                }
            }

        }

    }

    public static void updateOrderDetails() {

        L9:
        while (true) {
            System.out.println("_________________________________________________________________________________");
            System.out.println("|                                UPDATE ORDER DETAILS                           |");
            System.out.println("---------------------------------------------------------------------------------");
            Scanner input4 = new Scanner(System.in);
            System.out.print("\nEnter order Id : ");
            String oid2 = input4.nextLine();

            boolean orderFound2 = false;

            for (int i = 0; i < orderIds.length; i++) {
                if (oid2.equals(orderIds[i])) {
                    System.out.println("\nOrderID     - " + orderIds[i]);
                    System.out.println("CustomerID  - " + customerIds[i]);
                    System.out.println("Name        - " + names[i]);
                    System.out.println("Quantity    - " + qtys[i]);
                    System.out.println("OrderValue  - " + (qtys[i] * PRICE));
                    System.out.println("OrderStatus - " + getStatusText(status[i]));
                    orderFound2 = true;

                    L10:
                    while (true) {
                        System.out.println("\nWhat do you want to update ?");
                        System.out.println("\t(1) Quantity");
                        System.out.println("\t(2) Status");

                        System.out.print("\nEnter your option : ");
                        int ans5 = input4.nextInt();


                        if (ans5 == 1) {
                            System.out.println("");
                            System.out.println("Quantity Update");
                            System.out.println("===============");
                            System.out.println("\nOrderID     - " + orderIds[i]);
                            System.out.println("CustomerID  - " + customerIds[i]);
                            System.out.println("Name        - " + names[i]);

                            System.out.print("\nEnter your quantity update value : ");
                            int value = input4.nextInt();
                            qtys[i] = value;
                            System.out.println("\n\t***Update order quantity successfully***");
                            System.out.println("\nnew order quantity - " + qtys[i]);
                            System.out.printf("\nnew order value - %.2f", (qtys[i] * PRICE));

                            L11:
                            while (true) {
                                System.out.print("\nDo you want to update another order detail? (Y/N) : ");
                                char ans6 = input4.next().toUpperCase().charAt(0);
                                if (ans6 == 'Y') {
                                    continue L9;
                                } else if (ans6 == 'N') {
                                    break L9;
                                } else {
                                    System.out.print("\n***Please Enter a Valid Input***");
                                    continue L11;
                                }
                            }

                        } else if (ans5 == 2) {
                            System.out.println("");
                            System.out.println("Status Update");
                            System.out.println("===============");
                            System.out.println("\nOrderID     - " + orderIds[i]);
                            System.out.println("CustomerID  - " + customerIds[i]);
                            System.out.println("Name        - " + names[i]);

                            Scanner input5 = new Scanner(System.in);
                            L12:
                            while (true) {
                                if (status[i] == 0) {

                                    L15:
                                    while (true) {
                                        System.out.println("\n(1)Delivered");
                                        System.out.println("(2)Cancel");
                                        System.out.print("\nEnter new order status : ");
                                        int value2 = input5.nextInt();

                                        if (value2 == 1) {
                                            status[i] = value2;
                                            System.out.println("\n\t***Update order status successfully***");
                                            System.out.println("\nnew order status - " + getStatusText(status[i]));
                                            L13:
                                            while (true) {
                                                System.out.print("\n\nDo you want to update another order details? (Y/N) : ");
                                                char ans7 = input5.next().toUpperCase().charAt(0);
                                                if (ans7 == 'Y') {
                                                    continue L9;
                                                } else if (ans7 == 'N') {
                                                    break L9;
                                                } else {
                                                    System.out.println("\n***Please Enter a Valid Input***");
                                                    continue L13;
                                                }
                                            }
                                        } else if (value2 == 2) {
                                            status[i] = value2;
                                            System.out.println("\n\t***Update order status successfully***");
                                            System.out.println("\nnew order status - " + getStatusText(status[i]));
                                            L13:
                                            while (true) {
                                                System.out.print("\n\nDo you want to update another order details? (Y/N) : ");
                                                char ans7 = input5.next().toUpperCase().charAt(0);
                                                if (ans7 == 'Y') {
                                                    continue L9;
                                                } else if (ans7 == 'N') {
                                                    break L9;
                                                } else {
                                                    System.out.print("\n***Please Enter a Valid Input***");
                                                    continue L13;
                                                }
                                            }
                                        } else {
                                            System.out.print("\n***Please Enter a Valid Input***");
                                            continue L12;
                                        }
                                    }

                                } else if (status[i] == 1) {
                                    System.out.println("***Order Already Delivered.Cannot Edit The Status***");
                                    L14:
                                    while (true) {
                                        System.out.print("\n\nDo you want to update another order details? (Y/N) : ");
                                        char ans8 = input5.next().toUpperCase().charAt(0);
                                        if (ans8 == 'Y') {
                                            continue L9;
                                        } else if (ans8 == 'N') {
                                            break L9;
                                        } else {
                                            System.out.print("\n***Please Enter a Valid Input***");
                                            continue L14;
                                        }
                                    }
                                } else {
                                    System.out.println("***Order was canceled.Cannot Edit The Status***");
                                    L15:
                                    while (true) {
                                        System.out.print("\n\nDo you want to update another order details? (Y/N) : ");
                                        char ans9 = input5.next().toUpperCase().charAt(0);
                                        if (ans9 == 'Y') {
                                            continue L9;
                                        } else if (ans9 == 'N') {
                                            break L9;
                                        } else {
                                            System.out.print("\n***Please Enter a Valid Input***");
                                            continue L15;
                                        }
                                    }
                                }
                            }

                        } else {
                            System.out.println("\n***Please Enter a Valid Option***");
                            continue L10;
                        }
                    }
                } else {
                    System.out.println("\n***Please Enter a Valid OrderId***");
                    continue L9;
                }
            }
        }
    }

    public static void exit() {
        clearConsole();
        System.out.println("\n\t\t***Thanks For Coming. Have a Nice Day***\n");
        System.exit(0);
    }


    public static void home() {
        do {
            System.out.println("_________________________________________________________________________________");
            System.out.println("|                                 iHungry Burger                                |");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("\n[1] Place Order\t\t\t[2] Search Best Customer");
            System.out.println("[3] Search Order\t\t[4] Search Customer");
            System.out.println("[5] View Orders\t\t\t[6] Update Order Details");
            System.out.println("[7] Exit");
            System.out.print("\nEnter an option to continue : ");
            char option = input.next().charAt(0);

            switch (option) {
                case '1':
                    clearConsole();
                    placeOrder();
                    break;

                case '2':
                    clearConsole();
                    bestCustomer();
                    break;

                case '3':
                    clearConsole();
                    searchOrders();
                    break;

                case '4':
                    clearConsole();
                    searchCustomer();
                    break;

                case '5':
                    clearConsole();
                    viewOrders();
                    break;

                case '6':
                    clearConsole();
                    updateOrderDetails();
                    break;

                case '7':
                    exit();
                    break;
            }
            clearConsole();
        } while (true);
    }


    public static void main(String args[]) {
        home();
    }
}
