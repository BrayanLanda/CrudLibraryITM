package views;

import controllers.BookController;
import controllers.CustomerController;
import controllers.OderController;
import models.Book;
import models.Customer;
import models.Order;

import java.util.Scanner;

public class LibraryView {
    private final BookController bookController;
    private final CustomerController customerController;
    private final OderController orderController;
    private final Scanner scanner;

    public LibraryView() {
        this.bookController = new BookController(20);
        this.customerController = new CustomerController();
        this.orderController = new OderController();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1️⃣ Manage Books");
            System.out.println("2️⃣ Manage Customers");
            System.out.println("3️⃣ Manage Orders");
            System.out.println("0️⃣ Exit");
            System.out.print("Choose an option: ");
            option = readInt();

            switch (option) {
                case 1 -> manageBooks();
                case 2 -> manageCustomers();
                case 3 -> manageOrders();
                case 0 -> System.out.println("👋 Exiting...");
                default -> System.out.println("❌ Invalid option. Try again.");
            }
        } while (option != 0);
    }

    // ===== BOOKS MENU =====
    private void manageBooks() {
        int option;
        do {
            System.out.println("\n--- Manage Books ---");
            System.out.println("1️⃣ Add Book");
            System.out.println("2️⃣ List Books");
            System.out.println("3️⃣ Update Book");
            System.out.println("4️⃣ Delete Book");
            System.out.println("5️⃣ Sort Books by Price");
            System.out.println("6️⃣ Sort Books by Title");
            System.out.println("0️⃣ Back");
            System.out.print("Choose an option: ");
            option = readInt();

            switch (option) {
                case 1 -> addBook();
                case 2 -> bookController.listBooks();
                case 3 -> updateBook();
                case 4 -> deleteBook();
                case 5 -> {
                    bookController.sortBooksByPrice();
                    bookController.listBooks();
                }
                case 6 -> {
                    bookController.sortByTitle();
                    bookController.listBooks();
                }
                case 0 -> System.out.println("🔙 Back to main menu.");
                default -> System.out.println("❌ Invalid option.");
            }
        } while (option != 0);
    }

    private void addBook() {
        System.out.print("Enter ID: ");
        int id = readInt();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = readDouble();
        System.out.print("Enter Stock: ");
        int stock = readInt();

        Book book = new Book(id, title, author, price, stock);
        bookController.addBook(book);
    }

    private void updateBook() {
        System.out.print("Enter Book ID to update: ");
        int id = readInt();
        System.out.print("New Title: ");
        String title = scanner.nextLine();
        System.out.print("New Author: ");
        String author = scanner.nextLine();
        System.out.print("New Price: ");
        double price = readDouble();
        System.out.print("New Stock: ");
        int stock = readInt();

        bookController.updateBook(id, title, author, price, stock);
    }

    private void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = readInt();
        boolean removed = bookController.deleteBook(id);
        if (removed) {
            System.out.println("✅ Book deleted.");
        } else {
            System.out.println("❌ Book not found.");
        }
    }

    // ===== CUSTOMERS MENU =====
    private void manageCustomers() {
        int option;
        do {
            System.out.println("\n--- Manage Customers ---");
            System.out.println("1️⃣ Add Customer");
            System.out.println("2️⃣ List Customers");
            System.out.println("3️⃣ Update Customer");
            System.out.println("4️⃣ Delete Customer");
            System.out.println("0️⃣ Back");
            System.out.print("Choose an option: ");
            option = readInt();

            switch (option) {
                case 1 -> addCustomer();
                case 2 -> customerController.listCustomers();
                case 3 -> updateCustomer();
                case 4 -> deleteCustomer();
                case 0 -> System.out.println("🔙 Back to main menu.");
                default -> System.out.println("❌ Invalid option.");
            }
        } while (option != 0);
    }

    private void addCustomer() {
        System.out.print("Enter ID: ");
        int id = readInt();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(id, name, email, phone);
        customerController.addCustomer(customer);
    }

    private void updateCustomer() {
        System.out.print("Enter Customer ID to update: ");
        int id = readInt();
        System.out.print("New Name: ");
        String name = scanner.nextLine();
        System.out.print("New Email: ");
        String email = scanner.nextLine();
        System.out.print("New Phone: ");
        String phone = scanner.nextLine();

        customerController.updateCustomer(id, name, email, phone);
    }

    private void deleteCustomer() {
        System.out.print("Enter Customer ID to delete: ");
        int id = readInt();
        boolean removed = customerController.deleteCustomer(id);
        if (removed) {
            System.out.println("✅ Customer deleted.");
        } else {
            System.out.println("❌ Customer not found.");
        }
    }

    // ===== ORDERS MENU =====
    private void manageOrders() {
        int option;
        do {
            System.out.println("\n--- Manage Orders ---");
            System.out.println("1️⃣ Create Order");
            System.out.println("2️⃣ List Orders");
            System.out.println("3️⃣ Delete Order");
            System.out.println("0️⃣ Back");
            System.out.print("Choose an option: ");
            option = readInt();

            switch (option) {
                case 1 -> createOrder();
                case 2 -> orderController.listOrders();
                case 3 -> deleteOrder();
                case 0 -> System.out.println("🔙 Back to main menu.");
                default -> System.out.println("❌ Invalid option.");
            }
        } while (option != 0);
    }

    private void createOrder() {
        System.out.print("Enter Order ID: ");
        int orderId = readInt();
        System.out.print("Enter Customer ID: ");
        int customerId = readInt();
        System.out.print("Enter Book ID: ");
        int bookId = readInt();
        System.out.print("Enter Quantity: ");
        int quantity = readInt();

        Customer customer = customerController.findCustomerById(customerId);
        Book book = bookController.findBookById(bookId);

        if (customer == null || book == null) {
            System.out.println("❌ Customer or Book not found.");
            return;
        }

        if (book.getStock() < quantity) {
            System.out.println("❌ Not enough stock.");
            return;
        }

        book.setStock(book.getStock() - quantity);  // Reduce stock
        Order order = new Order(orderId, customer, book, quantity);
        orderController.addOrder(order);
    }

    private void deleteOrder() {
        System.out.print("Enter Order ID to delete: ");
        int id = readInt();
        boolean removed = orderController.deleteOrder(id);
        if (removed) {
            System.out.println("✅ Order deleted.");
        } else {
            System.out.println("❌ Order not found.");
        }
    }

    // ===== Helper methods =====
    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("❌ Invalid input. Enter a number:");
            scanner.next();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    private double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("❌ Invalid input. Enter a decimal number:");
            scanner.next();
        }
        double number = scanner.nextDouble();
        scanner.nextLine();
        return number;
    }
}
