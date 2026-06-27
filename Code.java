import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] books = {
                "Java",
                "C Programming",
                "Data Structures",
                "Python",
                "DBMS"
        };

        boolean[] issued = {false, false, false, false, false};
        boolean[] bought = {false, false, false, false, false};

        int[] price = {500, 400, 600, 550, 450};

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Display All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Buy Book");
            System.out.println("6. Count Available Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n----- BOOK LIST -----");

                    for (int i = 0; i < books.length; i++) {

                        System.out.print((i + 1) + ". " + books[i]);

                        if (issued[i])
                            System.out.println(" (Issued)");
                        else if (bought[i])
                            System.out.println(" (Bought)");
                        else
                            System.out.println(" (Available)");
                    }
                    break;

                case 2:
                    sc.nextLine();

                    System.out.print("Enter book name to search: ");
                    String search = sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < books.length; i++) {

                        if (books[i].equalsIgnoreCase(search)) {

                            found = true;
                            System.out.println("Book Found: " + books[i]);

                            if (issued[i])
                                System.out.println("Status: Issued");
                            else if (bought[i])
                                System.out.println("Status: Bought");
                            else
                                System.out.println("Status: Available");
                        }
                    }

                    if (!found)
                        System.out.println("Book not found.");

                    break;

                case 3:
                    System.out.print("Enter book number to issue: ");
                    int issue = sc.nextInt() - 1;

                    if (issue >= 0 && issue < books.length) {

                        if (issued[issue]) {
                            System.out.println("Book already issued.");
                        } else if (bought[issue]) {
                            System.out.println("Book already bought.");
                        } else {
                            issued[issue] = true;
                            System.out.println("Book issued successfully.");
                        }

                    } else {
                        System.out.println("Invalid book number.");
                    }

                    break;

                case 4:
                    System.out.print("Enter book number to return: ");
                    int ret = sc.nextInt() - 1;

                    if (ret >= 0 && ret < books.length) {

                        if (issued[ret]) {

                            issued[ret] = false;
                            System.out.println("Issued book returned successfully.");

                        } else if (bought[ret]) {

                            bought[ret] = false;
                            System.out.println("Purchased book returned successfully.");

                        } else {

                            System.out.println("Book was neither issued nor bought.");
                        }

                    } else {

                        System.out.println("Invalid book number.");
                    }

                    break;

                case 5:

                    System.out.println("\n----- BOOKS AVAILABLE FOR PURCHASE -----");

                    for (int i = 0; i < books.length; i++) {

                        if (!bought[i]) {
                            System.out.println((i + 1) + ". "
                                    + books[i]
                                    + " - Rs." + price[i]);
                        }
                    }

                    System.out.print("Enter book number to buy: ");
                    int buy = sc.nextInt() - 1;

                    if (buy >= 0 && buy < books.length) {

                        if (bought[buy]) {

                            System.out.println("Book already bought.");

                        } else {

                            bought[buy] = true;

                            System.out.println("\n----- BILL -----");
                            System.out.println("Book Name : " + books[buy]);
                            System.out.println("Price : Rs." + price[buy]);
                            System.out.println("Purchase Successful!");
                        }

                    } else {

                        System.out.println("Invalid book number.");
                    }

                    break;

                case 6:

                    int count = 0;

                    for (int i = 0; i < books.length; i++) {

                        if (!issued[i] && !bought[i])
                            count++;
                    }

                    System.out.println("Available Books Count: " + count);

                    break;

                case 7:

                    System.out.println("Thank you for using Library Management System.");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}
