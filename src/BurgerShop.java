import java.util.*;

class ListCus {
    //---------Inner Class---------
    class Node {
        private customer data;
        private Node next;

        Node(customer data) {
            this.data = data;
        }
    }

    private Node first;

    private boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void add(customer data) {
        Node n1 = new Node(data);
        if (isEmpty()) {
            first = n1;
        } else {
            Node lastNode = first;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = n1;
        }
    }

    public void add(int index, customer data) {
        Node n1 = new Node(data);
        if (index >= 0 && index <= size()) {
            if (index == 0) {
                first = n1;
            } else {
                int count = 0;
                Node temp = first;
                while (count < index - 1) {
                    temp = temp.next;
                    count++;
                }
                n1.next = temp.next;
                temp.next = n1;
            }
        }
    }

    public customer get(int index) {
        if (index >= 0 && index < size()) {
            int count = 0;
            Node temp = first;
            while (count < index) {
                temp = temp.next;
                count++;
            }
            return temp.data;
        }
        return null;
    }

    public int search(customer data) {
        Node temp = first;
        int index = 0;
        while (temp != null) {
            if (temp.data == data) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public boolean contains(customer data) {
        return search(data) != -1;
    }

    public void printList() {
        Node temp = first;
        System.out.print("[");
        while (temp != null) {
            System.out.println(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println(first == null ? "empty]" : "\b\b]");
    }

    public customer[] toArray() {
        customer[] tempArray = new customer[size()];
        int i = 0;
        Node temp = first;
        while (temp != null) {
            tempArray[i++] = temp.data;
            temp = temp.next;
        }
        return tempArray;
    }

    //Removing the first element
    public void remove() {
        if (first != null) {
            first = first.next;
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < size()) {
            Node temp = first;
            int count = 0;
            while (count < index - 1) {
                temp = temp.next;
                count++;
            }
            Node temp2 = temp.next;
            temp = temp2.next;
        }
    }

    public void clear() {
        first = null;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }
}
class ListOrd {
    //---------Inner Class---------
    class Node {
        private orders data;
        private Node next;

        Node(orders data) {
            this.data = data;
        }
    }

    private Node first;

    private boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void add(orders data) {
        Node n1 = new Node(data);
        if (isEmpty()) {
            first = n1;
        } else {
            Node lastNode = first;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = n1;
        }
    }

    public void add(int index, orders data) {
        Node n1 = new Node(data);
        if (index >= 0 && index <= size()) {
            if (index == 0) {
                first = n1;
            } else {
                int count = 0;
                Node temp = first;
                while (count < index - 1) {
                    temp = temp.next;
                    count++;
                }
                n1.next = temp.next;
                temp.next = n1;
            }
        }
    }

    public orders get(int index) {
        if (index >= 0 && index < size()) {
            int count = 0;
            Node temp = first;
            while (count < index) {
                temp = temp.next;
                count++;
            }
            return temp.data;
        }
        return null;
    }

    public int search(orders data) {
        Node temp = first;
        int index = 0;
        while (temp != null) {
            if (temp.data == data) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public boolean contains(orders data) {
        return search(data) != -1;
    }

    public void printList() {
        Node temp = first;
        System.out.print("[");
        while (temp != null) {
            System.out.println(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println(first == null ? "empty]" : "\b\b]");
    }

    public orders[] toArray() {
        orders[] tempArray = new orders[size()];
        int i = 0;
        Node temp = first;
        while (temp != null) {
            tempArray[i++] = temp.data;
            temp = temp.next;
        }
        return tempArray;
    }

    //Removing the first element
    public void remove() {
        if (first != null) {
            first = first.next;
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < size()) {
            Node temp = first;
            int count = 0;
            while (count < index - 1) {
                temp = temp.next;
                count++;
            }
            Node temp2 = temp.next;
            temp = temp2.next;
        }
    }

    public void clear() {
        first = null;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
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

    public orders() {

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

class Controller {
    public static ListCus dbcus = new ListCus();
    public static ListOrd dbord = new ListOrd();

    final static double BURGERPRICE = 500;
    public static final int PREPARING = 0;
    public static final int DELIVERED = 1;
    public static final int CANCEL = 2;

    public static String generateOrderId() {
        if (dbcus.size() == 0) {
            return "B0001";
        }
        String lastOrderId = dbord.get(dbord.size() - 1).getOrderId();
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
            for (int i = 0; i < dbcus.size(); i++) {
                if (cusId.equals(dbcus.get(i).getCustomerId())) {
                    isExistCustomer = true;
                    System.out.println("Enter Customer Name: " + dbcus.get(i).getCustomerName());
                    cusName = dbcus.get(i).getCustomerName();
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
                            dbcus.add(new customer(cusId, cusName));
                            dbord.add(new orders(orderId, 0, qty, (qty * BURGERPRICE)));
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
        for (int i = 0; i < dbcus.size(); i++) {
            if (!(search(dbcus.get(i).getCustomerId(), idArrayDupRemoved))) {
                customer[] tempIdArray = new customer[idArrayDupRemoved.length + 1];
                for (int j = 0; j < idArrayDupRemoved.length; j++) {
                    tempIdArray[j] = new customer(idArrayDupRemoved[j].getCustomerId(), idArrayDupRemoved[j].getCustomerName());
                }
                tempIdArray[tempIdArray.length - 1] = new customer(dbcus.get(i).getCustomerId(), dbcus.get(i).getCustomerName());
                idArrayDupRemoved = tempIdArray;
            }
        }
        return idArrayDupRemoved;
    }

    public static void calculateTotalOrderValues(customer[] idArrayDupRemoved) {
        for (int k = 0; k < idArrayDupRemoved.length; k++) {
            int total = 0;
            for (int m = 0; m < dbcus.size(); m++) {
                if (idArrayDupRemoved[k].getCustomerId().equals(dbcus.get(m).getCustomerId())) {
                    total += dbord.get(m).getOrderValue();
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
            for (int i = 0; i < dbord.size(); i++) {
                if (orderId.equals(dbord.get(i).getOrderId())) {
                    System.out.println("_____________________________________________________________________________________");
                    System.out.println("OrderID\t\tCustomerID\t\t Name\t\tQuantity\t\tOrderValue\t\tOrderStatus |");
                    System.out.println("_____________________________________________________________________________________");
                    System.out.println(dbord.get(i).getOrderId() + "\t\t" + dbcus.get(i).getCustomerId() + "\t\t" + dbcus.get(i).getCustomerName() + "\t\t\t\t" + dbord.get(i).getOrderQty() + "\t\t\t\t" + dbord.get(i).getOrderValue() + "\t\t\t\t" + getStatusText(dbord.get(i).getOrderStatus()) + "  |");
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
            for (int j = 0; j < dbcus.size(); j++) {
                if (res5.equals(dbcus.get(j).getCustomerId())) {
                    customerFound = true;
                }
            }
            if (customerFound) {
                for (int i = 0; i < dbcus.size(); i++) {
                    if (res5.equals(dbcus.get(i).getCustomerId())) {
                        System.out.println("\nCustomerID - " + dbcus.get(i).getCustomerId());
                        System.out.println("Name - " + dbcus.get(i).getCustomerName());
                        System.out.println("\nCustomer Order Details");
                        System.out.println("==========================");
                        System.out.println("\n");

                        System.out.println("---------------------------------------------------------------------------------");
                        System.out.println("Order_ID\t\t\t\t\tOrder_Quantity\t\t\t\t\tTotal");
                        System.out.println("---------------------------------------------------------------------------------");
                        for (int j = 0; j < dbcus.size(); j++) {
                            if (res5.equals(dbcus.get(j).getCustomerId())) {
                                System.out.println(dbord.get(j).getOrderId() + "\t\t\t\t\t\t\t" + dbord.get(j).getOrderQty() + "\t\t\t\t\t\t\t" + (dbord.get(j).getOrderQty() * BURGERPRICE));
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
                    for (int i = 0; i < dbord.size(); i++) {
                        if (dbord.get(i).getOrderStatus() == 1) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(dbord.get(i).getOrderId() + "\t\t" + dbcus.get(i).getCustomerId() + "\t\t" + dbcus.get(i).getCustomerName() + "\t\t\t" + dbord.get(i).getOrderQty() + "\t\t\t " + (dbord.get(i).getOrderQty() * BURGERPRICE) + "  |");
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
                    for (int i = 0; i < dbord.size(); i++) {
                        if (dbord.get(i).getOrderStatus() == 0) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(dbord.get(i).getOrderId() + "\t\t" + dbcus.get(i).getCustomerId() + "\t\t" + dbcus.get(i).getCustomerName() + "\t\t\t" + dbord.get(i).getOrderQty() + "\t\t\t " + (dbord.get(i).getOrderQty() * BURGERPRICE) + "  |");
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
                    for (int i = 0; i < dbord.size(); i++) {
                        if (dbord.get(i).getOrderStatus() == 2) {
                            System.out.println("______________________________________________________________________");
                            System.out.println(dbord.get(i).getOrderId() + "\t\t" + dbcus.get(i).getCustomerId() + "\t\t" + dbcus.get(i).getCustomerName() + "\t\t\t" + dbord.get(i).getOrderQty() + "\t\t\t " + (dbord.get(i).getOrderQty() * BURGERPRICE) + "  |");
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

            for (int i = 0; i < dbord.size(); i++) {
                if (oid2.equals(dbord.get(i).getOrderId())) {
                    System.out.println("\nOrderID     - " + dbord.get(i).getOrderId());
                    System.out.println("CustomerID  - " + dbcus.get(i).getCustomerId());
                    System.out.println("Name        - " + dbcus.get(i).getCustomerName());
                    System.out.println("Quantity    - " + dbord.get(i).getOrderQty());
                    System.out.println("OrderValue  - " + (dbord.get(i).getOrderQty() * BURGERPRICE));
                    System.out.println("OrderStatus - " + getStatusText(dbord.get(i).getOrderStatus()));
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
                            System.out.println("\nOrderID     - " + dbord.get(i).getOrderId());
                            System.out.println("CustomerID  - " + dbcus.get(i).getCustomerId());
                            System.out.println("Name        - " + dbcus.get(i).getCustomerName());

                            System.out.print("\nEnter your quantity update value : ");
                            int value = input6.nextInt();
                            dbord.get(i).setOrderQty(value);
                            dbord.get(i).setOrderValue(value * BURGERPRICE);
                            System.out.println("\n\t***Update order quantity successfully***");
                            System.out.println("\nnew order quantity - " + dbord.get(i).getOrderQty());
                            System.out.printf("new order value - %.2f", (dbord.get(i).getOrderQty() * BURGERPRICE));

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
                            System.out.println("\nOrderID     - " + dbord.get(i).getOrderId());
                            System.out.println("CustomerID  - " + dbcus.get(i).getCustomerId());
                            System.out.println("Name        - " + dbcus.get(i).getCustomerName());

                            Scanner input5 = new Scanner(System.in);
                            L12:
                            while (true) {
                                if (dbord.get(i).getOrderStatus() == 0) {

                                    L15:
                                    while (true) {
                                        System.out.println("\n(1)Delivered");
                                        System.out.println("(2)Cancel");
                                        System.out.print("\nEnter new order status : ");
                                        int value2 = input5.nextInt();

                                        if (value2 == 1) {
                                            dbord.get(i).setOrderStatus(value2);
                                            System.out.println("\n\tUpdate order status successfully");
                                            System.out.println("\nnew order status - " + getStatusText(dbord.get(i).getOrderStatus()));
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
                                            dbord.get(i).setOrderStatus(value2);
                                            System.out.println("\n\t***Update order status successfully***");
                                            System.out.println("\nnew order status - " + getStatusText(dbord.get(i).getOrderStatus()));
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

                                } else if (dbord.get(i).getOrderStatus() == 1) {
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
}

class View {
    public static void run() {

        Controller cntrl = new Controller();

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
                    cntrl.clearConsole();
                    cntrl.placeOrder();
                    break;

                case '2':
                    cntrl.clearConsole();
                    cntrl.bestCustomer();
                    break;

                case '3':
                    cntrl.clearConsole();
                    cntrl.searchOrder();
                    break;

                case '4':
                    cntrl.clearConsole();
                    cntrl.searchCustomer();
                    break;

                case '5':
                    cntrl.clearConsole();
                    cntrl.viewOrders();
                    break;

                case '6':
                    cntrl.clearConsole();
                    cntrl.updateOrderDetails();
                    break;

                case '7':
                    cntrl.clearConsole();
                    cntrl.exit();
                    break;
            }
            cntrl.clearConsole();
        } while (true);
    }
}

class BurgerShop {
    public static void main(String args[]) {
        View.run();
    }
}
