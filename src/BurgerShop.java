import com.sun.source.tree.WhileLoopTree;

import java.util.*;

class ListCus {

    private int nextIndex;
    private customer[] dataArray;

    ListCus(int size) {
        nextIndex = 0;
        dataArray = new customer[size];
    }

    private boolean isFull() {
        return nextIndex >= dataArray.length;
    }

    public boolean isEmpty() {
        return nextIndex <= 0;
    }

    public void add(customer data) {
        if (isFull()) {
            extendsArray();
        }
        dataArray[nextIndex++] = data;
    }

    public void add(int index, customer data) {
        if (index >= 0 && index <= nextIndex) {
            if (isFull()) {
                extendsArray();
            }
            for (int i = nextIndex; i >= index; i--) {
                dataArray[i] = dataArray[i - 1];
            }
            dataArray[index] = data;
            nextIndex++;
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < nextIndex) {
            for (int i = index; i < nextIndex - 1; i++) {
                dataArray[i] = dataArray[i + 1];
            }
            nextIndex--;
        }
    }

    private void extendsArray() {
        customer[] tempDataArray = new customer[(int) (dataArray.length * 1.5)];
        for (int i = 0; i < dataArray.length; i++) {
            tempDataArray[i] = dataArray[i];
        }
        dataArray = tempDataArray;
    }

    public customer get(int index) {
        if (index >= 0 && index < nextIndex) {
            return dataArray[index];
        } else {
            return null;
        }
    }

    public boolean contains(String data) {
        for (int i = 0; i < nextIndex; i++) {
            if (dataArray[i].getCustomerId() == data) {
                return true;
            }
        }
        return false;
    }

    public customer peek() {
        if (isEmpty()) {
            return null;
        }
        return dataArray[0];
    }

    public customer poll() {
        if (isEmpty()) {
            return null;
        } else {
            customer frontData = dataArray[0];
            remove(0);
            return frontData;
        }
    }

    public void printList() {
        System.out.println("[");
        for (int i = 0; i < nextIndex; i++) {
            System.out.println(dataArray[i] + ",");
        }
        System.out.println(isEmpty() ? "empty]" : "\b\b]");
    }

    public customer[] toArray() {
        customer[] temp = new customer[nextIndex];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = dataArray[i];
        }
        return temp;
    }

    public int size() {
        return nextIndex;
    }

    public void clear() {
        nextIndex = 0;
    }

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }
}

class ListOrd {

    private int nextIndex;
    private orders[] dataArray;

    ListOrd(int size) {
        nextIndex = 0;
        dataArray = new orders[size];
    }

    private boolean isFull() {
        return nextIndex >= dataArray.length;
    }

    public boolean isEmpty() {
        return nextIndex <= 0;
    }

    public void add(orders data) {
        if (isFull()) {
            extendsArray();
        }
        dataArray[nextIndex++] = data;
    }

    public void add(int index, orders data) {
        if (index >= 0 && index <= nextIndex) {
            if (isFull()) {
                extendsArray();
            }
            for (int i = nextIndex; i >= index; i--) {
                dataArray[i] = dataArray[i - 1];
            }
            dataArray[index] = data;
            nextIndex++;
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < nextIndex) {
            for (int i = index; i < nextIndex - 1; i++) {
                dataArray[i] = dataArray[i + 1];
            }
            nextIndex--;
        }
    }

    private void extendsArray() {
        orders[] tempDataArray = new orders[(int) (dataArray.length * 1.5)];
        for (int i = 0; i < dataArray.length; i++) {
            tempDataArray[i] = dataArray[i];
        }
        dataArray = tempDataArray;
    }

    public orders get(int index) {
        if (index >= 0 && index < nextIndex) {
            return dataArray[index];
        } else {
            return null;
        }
    }

    public boolean contains(String data) {
        for (int i = 0; i < nextIndex; i++) {
            if (dataArray[i].getOrderId() == data) {
                return true;
            }
        }
        return false;
    }

    public orders peek() {
        if (isEmpty()) {
            return null;
        }
        return dataArray[0];
    }

    public orders poll() {
        if (isEmpty()) {
            return null;
        } else {
            orders frontData = dataArray[0];
            remove(0);
            return frontData;
        }
    }

    public void printList() {
        System.out.println("[");
        for (int i = 0; i < nextIndex; i++) {
            System.out.println(dataArray[i] + ",");
        }
        System.out.println(isEmpty() ? "empty]" : "\b\b]");
    }

    public orders[] toArray() {
        orders[] temp = new orders[nextIndex];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = dataArray[i];
        }
        return temp;
    }

    public int size() {
        return nextIndex;
    }

    public void clear() {
        nextIndex = 0;
    }

    public int getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex) {
        this.nextIndex = nextIndex;
    }
}

class customer {
    private String customerId;
    private String customerName;
    private double total;

    public customer(String customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public customer(String customerId, String customerName, double total) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.total = total;
    }

    public customer() {

    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

class orders {
    private String orderId;
    private int orderStatus;
    private int orderQty;
    private double orderValue;

    public orders(String orderId, int orderStatus, int orderQty, double orderValue) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderQty = orderQty;
        this.orderValue = orderValue;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }
}

class BurgerShop {

    final static double BURGERPRICE = 500;
    public static ListCus cus = new ListCus(10);
    public static ListOrd ord = new ListOrd(10);

    public static final int PREPARING = 0;
    public static final int DELIVERED = 1;
    public static final int CANCEL = 2;


    public static String generateOrderId() {
        if (cus.size() == 0) {
            return "B0001";
        }
        String lastOrderId = ord.get(ord.getNextIndex() - 1).getOrderId();
        int number = Integer.parseInt(lastOrderId.split("B")[1]);
        number++;
        return String.format("B%04d", number);
    }

    public static String getStatusText(int orderStatus) {
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
            //Handle any exceptions.
        }
    }

    public static void placeOrder() {
        L2:
        do {
            System.out.println("_________________________________________________________________________________");
            System.out.println("|                                 PLACE ORDER                                   |");
            System.out.println("---------------------------------------------------------------------------------");
            Scanner input2 = new Scanner(System.in);
            System.out.print("ORDER ID : ");
            String orderId = generateOrderId();
            System.out.println(orderId + "\n================\n");
            System.out.print("Enter Customer ID (Your Phone Number) : ");
            String cusId = input2.nextLine();
            if (cusId.charAt(0) != '0' || cusId.length() != 10) {
                System.out.println("!!!Please Enter a Valid Customer ID!!!");
                continue L2;
            }
            boolean isExistCustomer = false;
            String cusName = "";
            for (int i = 0; i < cus.getNextIndex(); i++) {
                if (cusId.equals(cus.get(i).getCustomerId())) {
                    isExistCustomer = true;
                    System.out.println("Enter Customer Name: " + cus.get(i).getCustomerName());
                    cusName = cus.get(i).getCustomerName();
                    break;
                }
            }
            if (!isExistCustomer) {
                System.out.print("Customer Name : ");
                cusName = input2.nextLine();
            }
            L5:
            while (true) {
                System.out.print("Enter Burger Quantity : ");
                int qty;
                try {
                    qty = Integer.parseInt(input2.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("***Please Enter a Valid Quantity (Numeric)***");
                    continue L5;
                }
                if (qty > 0) {
                    System.out.println("Total value : " + (qty * BURGERPRICE));
                    L4:
                    while (true) {
                        System.out.print("\tDo you want to place this order?(Y/N) : ");
                        char res1 = input2.next().toUpperCase().charAt(0);
                        if (res1 == 'Y') {
                            cus.add(new customer(cusId, cusName));
                            ord.add(new orders(orderId, 0, qty, (qty * BURGERPRICE)));
                            System.out.println("Your Order is Enter to the System Successfully");
                            System.out.println("");
                            L3:
                            while (true) {
                                System.out.print("Do you want to place another order? : ");
                                char res3 = input2.next().toUpperCase().charAt(0);
                                if (res3 == 'Y') {
                                    clearConsole();
                                    continue L2;
                                } else if (res3 == 'N') {
                                    break L2;
                                } else {
                                    System.out.println("***Please Enter a Valid Input***");
                                    continue L3;
                                }
                            }
                        } else if (res1 == 'N') {
                            continue L2;
                        } else {
                            System.out.println("***Please Enter a Valid Input***");
                            continue L4;
                        }
                    }
                } else {
                    System.out.println("***Please Enter a Valid Quantity***");
                    continue L5;
                }
            }
        } while (true);
    }


    public static void bestCustomer() {
        L20:
        while (true) {
            // Removing duplicate customer id's and names
            customer[] idArrayDupRemoved = removeDuplicates();

            // Summing the total order values for each customer id
            calculateTotalOrderValues(idArrayDupRemoved);

            // Sort the objects according to the order value using bubble sort
            bubbleSort(idArrayDupRemoved);

            displayBestCustomers(idArrayDupRemoved);

            // Prompt user to go back to the main menu
            System.out.print("Do you want to go back to the main menu? (Y/N): ");
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

    public static customer[] removeDuplicates() {
        customer[] idArrayDupRemoved = new customer[0];
        for (int i = 0; i < cus.getNextIndex(); i++) {
            if (!(search(cus.get(i).getCustomerId(), idArrayDupRemoved))) {
                customer[] tempIdArray = new customer[idArrayDupRemoved.length + 1];
                for (int j = 0; j < idArrayDupRemoved.length; j++) {
                    tempIdArray[j] = new customer(idArrayDupRemoved[j].getCustomerId(), idArrayDupRemoved[j].getCustomerName());
                }
                tempIdArray[tempIdArray.length - 1] = new customer(cus.get(i).getCustomerId(), cus.get(i).getCustomerName());
                idArrayDupRemoved = tempIdArray;
            }
        }
        return idArrayDupRemoved;
    }

    public static void calculateTotalOrderValues(customer[] idArrayDupRemoved) {
        for (int k = 0; k < idArrayDupRemoved.length; k++) {
            int total = 0;
            for (int m = 0; m < cus.getNextIndex(); m++) {
                if (idArrayDupRemoved[k].getCustomerId().equals(cus.get(m).getCustomerId())) {
                    total += ord.get(m).getOrderValue();
                }
            }
            idArrayDupRemoved[k].setTotal(total);
        }
    }

    public static void bubbleSort(customer[] idArrayDupRemoved) {
        for (int i = 0; i < idArrayDupRemoved.length - 1; i++) {
            for (int j = 0; j < idArrayDupRemoved.length - 1; j++) {
                if (idArrayDupRemoved[j].getTotal() < idArrayDupRemoved[j + 1].getTotal()) {
                    customer temp = new customer(idArrayDupRemoved[j].getCustomerId(), idArrayDupRemoved[j].getCustomerName(), idArrayDupRemoved[j].getTotal());
                    idArrayDupRemoved[j] = idArrayDupRemoved[j + 1];
                    idArrayDupRemoved[j + 1] = temp;
                }
            }
        }
    }

    public static void displayBestCustomers(customer[] idArrayDupRemoved) {
        System.out.println("________________________________________________________________________________");
        System.out.println("|                                 BEST CUSTOMER                                 |");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("CustomerID\t\t\t\t\tName\t\t\t\t\tTotal");
        System.out.println("---------------------------------------------------------------------------------");

        for (customer aCustomer : idArrayDupRemoved) {
            System.out.println(aCustomer.getCustomerId() + "\t\t\t\t\t" + aCustomer.getCustomerName() + "\t\t\t\t\t" + aCustomer.getTotal());
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

    public static boolean search(String customerId, customer[] idArrayDupRemoved) {
        for (customer aCustomer : idArrayDupRemoved) {
            if (aCustomer.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }


    public static void searchOrder() {
        L6:
        while (true) {
            System.out.println("_________________________________________________________________________________");
            System.out.println("|                             SEARCH ORDER DETAILS                               |");
            System.out.println("----------------------------------------------------------------------------------");
            Scanner input3 = new Scanner(System.in);
            System.out.print("Enter Order Id : ");
            String orderId = input3.next();
            boolean orderFound = false;
            for (int i = 0; i < ord.getNextIndex(); i++) {
                if (orderId.equals(ord.get(i).getOrderId())) {
                    System.out.println("_____________________________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue\t\tOrderStatus |");
                    System.out.println("_____________________________________________________________________________________");
                    System.out.println(ord.get(i).getOrderId() + "\t\t" + cus.get(i).getCustomerId() + "\t\t" + cus.get(i).getCustomerName() + "\t\t\t\t" + ord.get(i).getOrderQty() + "\t\t\t\t" + ord.get(i).getOrderValue() + "\t\t\t\t" + getStatusText(ord.get(i).getOrderStatus()) + "  |");
                    System.out.println("_____________________________________________________________________________________");
                    orderFound = true;
                    L7:
                    while (true) {
                        System.out.print("\nDo you want to search another order details (Y/N) : ");
                        char res4 = input3.next().toUpperCase().charAt(0);
                        if (res4 == 'Y') {
                            continue L6;
                        } else if (res4 == 'N') {
                            break L6;
                        } else {
                            System.out.print("\n***Please Enter a Valid Input***");
                            continue L7;
                        }
                    }
                }
            }
            if (!orderFound) {
                System.out.println("\n***Please Enter a Valid Order ID***");
                continue L6;
            }
        }

    }

    public static void searchCustomer() {
        L8:
        while (true) {
            System.out.println("________________________________________________________________________________");
            System.out.println("|                             SEARCH CUSTOMER DETAILS                           |");
            System.out.println("---------------------------------------------------------------------------------");
            Scanner input4 = new Scanner(System.in);

            System.out.print("Enter Customer Id (Or Type 'exit' To Mainmenu) : ");
            String res5 = input4.nextLine();
            boolean customerFound = false;
            for (int j = 0; j < cus.getNextIndex(); j++) {
                if (res5.equals(cus.get(j).getCustomerId())) {
                    customerFound = true;
                }
            }
            if (customerFound) {
                for (int i = 0; i < cus.getNextIndex(); i++) {
                    if (res5.equals(cus.get(i).getCustomerId())) {
                        System.out.println("\nCustomerID - " + cus.get(i).getCustomerId());
                        System.out.println("Name - " + cus.get(i).getCustomerName());
                        System.out.println("\nCustomer Order Details");
                        System.out.println("==========================");
                        System.out.println("\n");

                        System.out.println("---------------------------------------------------------------------------------");
                        System.out.println("Order_ID\t\t\t\t\tOrder_Quantity\t\t\t\t\tTotal");
                        System.out.println("---------------------------------------------------------------------------------");
                        for (int j = 0; j < cus.getNextIndex(); j++) {
                            if (res5.equals(cus.get(j).getCustomerId())) {
                                System.out.println(ord.get(j).getOrderId() + "\t\t\t\t\t\t\t" + ord.get(j).getOrderQty() + "\t\t\t\t\t\t\t" + (ord.get(j).getOrderQty() * BURGERPRICE));
                            }
                        }
                        L9:
                        while (true) {
                            System.out.print("\nDo you want to search another customer? (Y/N) : ");
                            char res6 = input4.next().toUpperCase().charAt(0);
                            if (res6 == 'Y') {
                                continue L8;
                            } else if (res6 == 'N') {
                                break L8;
                            } else {
                                System.out.println("***Please Enter a Valid Input***");
                                continue L9;
                            }
                        }
                    }
                }
            } else if (res5.equals("exit")) {
                break L8;
            } else {
                System.out.println("***Please Enter a Valid Customer Id***");
                continue L8;
            }
        }
    }

    public static void viewOrders() {
        L4:
        while (true) {
            System.out.println("__________________________________________________________________________________");
            System.out.println("|                                VIEW ORDER DETAILS                               |");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("\n[1] Delivered Order");
            System.out.println("[2] Preparing Order");
            System.out.println("[3] Cancel Order");

            Scanner input5 = new Scanner(System.in);
            L5:
            while (true) {
                System.out.print("\nEnter an option to continue : ");
                int ans2 = input5.nextInt();

                if (ans2 == 1) {
                    System.out.println("________________________________________________________________________________");
                    System.out.println("|                                DELIVERED ORDERS                              |");
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("______________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue |");
                    for (int i = 0; i < ord.getNextIndex(); i++) {
                        if (ord.get(i).getOrderStatus() == 1) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(ord.get(i).getOrderId() + "\t\t" + cus.get(i).getCustomerId() + "\t\t" + cus.get(i).getCustomerName() + "\t\t\t" + ord.get(i).getOrderQty() + "\t\t\t " + (ord.get(i).getOrderQty() * BURGERPRICE) + "  |");
                        } else {
                            continue;
                        }

                    }
                    L3:
                    while (true) {
                        System.out.print("\nDo you want to go to home page? (Y/N) : ");
                        char ans3 = input5.next().toUpperCase().charAt(0);
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
                    System.out.println("");
                    System.out.println("______________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue |");
                    for (int i = 0; i < ord.getNextIndex(); i++) {
                        if (ord.get(i).getOrderStatus() == 0) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(ord.get(i).getOrderId() + "\t\t" + cus.get(i).getCustomerId() + "\t\t" + cus.get(i).getCustomerName() + "\t\t\t" + ord.get(i).getOrderQty() + "\t\t\t " + (ord.get(i).getOrderQty() * BURGERPRICE) + "  |");
                        } else {
                            continue;
                        }

                    }
                    L7:
                    while (true) {
                        System.out.print("\nDo you want to go to home page? (Y/N) : ");
                        char ans4 = input5.next().toUpperCase().charAt(0);
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
                    System.out.println("");
                    System.out.println("______________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue |");
                    for (int i = 0; i < ord.getNextIndex(); i++) {
                        if (ord.get(i).getOrderStatus() == 2) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(ord.get(i).getOrderId() + "\t\t" + cus.get(i).getCustomerId() + "\t\t" + cus.get(i).getCustomerName() + "\t\t\t" + ord.get(i).getOrderQty() + "\t\t\t " + (ord.get(i).getOrderQty() * BURGERPRICE) + "  |");
                        } else {
                            continue;
                        }

                    }
                    L8:
                    while (true) {
                        System.out.print("\nDo you want to go to home page? (Y/N) : ");
                        char ans4 = input5.next().toUpperCase().charAt(0);
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
            System.out.println("________________________________________________________________________________");
            System.out.println("|                                UPDATE ORDER DETAILS                           |");
            System.out.println("---------------------------------------------------------------------------------");
            Scanner input6 = new Scanner(System.in);
            System.out.print("\nEnter order Id : ");
            String oid2 = input6.nextLine();

            boolean orderFound2 = false;

            for (int i = 0; i < ord.getNextIndex(); i++) {
                if (oid2.equals(ord.get(i).getOrderId())) {
                    System.out.println("\nOrderID     - " + ord.get(i).getOrderId());
                    System.out.println("CustomerID  - " + cus.get(i).getCustomerId());
                    System.out.println("Name        - " + cus.get(i).getCustomerName());
                    System.out.println("Quantity    - " + ord.get(i).getOrderQty());
                    System.out.println("OrderValue  - " + (ord.get(i).getOrderQty() * BURGERPRICE));
                    System.out.println("OrderStatus - " + getStatusText(ord.get(i).getOrderStatus()));
                    orderFound2 = true;

                    L10:
                    while (true) {
                        System.out.println("\nWhat do you want to update ?");
                        System.out.println("\t(1) Quantity");
                        System.out.println("\t(2) Status");

                        System.out.print("\nEnter your option : ");
                        int ans5 = input6.nextInt();


                        if (ans5 == 1) {
                            System.out.println("");
                            System.out.println("Quantity Update");
                            System.out.println("===============");
                            System.out.println("\nOrderID     - " + ord.get(i).getOrderId());
                            System.out.println("CustomerID  - " + cus.get(i).getCustomerId());
                            System.out.println("Name        - " + cus.get(i).getCustomerName());

                            System.out.print("\nEnter your quantity update value : ");
                            int value = input6.nextInt();
                            ord.get(i).setOrderQty(value);
                            ord.get(i).setOrderValue(value * BURGERPRICE);
                            System.out.println("\n\t***Update order quantity successfully***");
                            System.out.println("\nnew order quantity - " + ord.get(i).getOrderQty());
                            System.out.printf("new order value - %.2f", (ord.get(i).getOrderQty() * BURGERPRICE));

                            L11:
                            while (true) {
                                System.out.print("\n\nDo you want to update another order detail? (Y/N) : ");
                                char ans6 = input6.next().toUpperCase().charAt(0);
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
                            System.out.println("\nOrderID     - " + ord.get(i).getOrderId());
                            System.out.println("CustomerID  - " + cus.get(i).getCustomerId());
                            System.out.println("Name        - " + cus.get(i).getCustomerName());

                            Scanner input5 = new Scanner(System.in);
                            L12:
                            while (true) {
                                if (ord.get(i).getOrderStatus() == 0) {

                                    L15:
                                    while (true) {
                                        System.out.println("\n(1)Delivered");
                                        System.out.println("(2)Cancel");
                                        System.out.print("\nEnter new order status : ");
                                        int value2 = input5.nextInt();

                                        if (value2 == 1) {
                                            ord.get(i).setOrderStatus(value2);
                                            System.out.println("\n\tUpdate order status successfully");
                                            System.out.println("\nnew order status - " + getStatusText(ord.get(i).getOrderStatus()));
                                            L13:
                                            while (true) {
                                                System.out.print("\n\nDo you want to update another order detail? (Y/N) : ");
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
                                            ord.get(i).setOrderStatus(value2);
                                            System.out.println("\n\t***Update order status successfully***");
                                            System.out.println("\nnew order status - " + getStatusText(ord.get(i).getOrderStatus()));
                                            L13:
                                            while (true) {
                                                System.out.print("\n\nDo you want to update another order details (Y/N) : ");
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

                                } else if (ord.get(i).getOrderStatus() == 1) {
                                    System.out.println("***Order Already Delivered.Cannot Edit The Status***");
                                    L14:
                                    while (true) {
                                        System.out.print("\n\nDo you want to update another order detail? (Y/N) : ");
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
                                        System.out.print("\n\nDo you want to update another order detail? (Y/N) : ");
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
                }
            }
            if (!orderFound2) {
                System.out.println("\n***Please Enter a Valid OrderId***");
                continue L9;
            }
        }
    }

    public static void exit() {
        clearConsole();
        System.out.println("\n\t\t***Thanks For Coming. Have a Nice Day***\n");
        System.exit(0);
    }

    public static void main(String args[]) {
        L1:
        do {
            System.out.println("_________________________________________________________________________________");
            System.out.println("|                                 iHungry Burger                                |");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("\n[1] Place Order\t\t\t[2] Search Best Customer");
            System.out.println("[3] Search Order\t\t[4] Search Customer");
            System.out.println("[5] View Orders\t\t\t[6] Update Order Details");
            System.out.println("[7] Exit");
            System.out.print("\nEnter an option to continue : ");
            Scanner input1 = new Scanner(System.in);
            char option1 = input1.next().charAt(0);

            switch (option1) {
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
                    searchOrder();
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
                    clearConsole();
                    exit();
                    break;
            }
            clearConsole();
        } while (true);
    }
}
