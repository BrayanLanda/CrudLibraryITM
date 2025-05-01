package models;

public class Order {
    private int id;
    private Customer customer;
    private Book book;
    private int quantity;
    private double totalPrice;

    // Constructor
    public Order(int id, Customer customer, Book book, int quantity) {
        this.id = id;
        this.customer = customer;
        this.book = book;
        this.quantity = quantity;
        this.totalPrice = book.getPrice() * quantity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer.getName() +
                ", book=" + book.getTitle() +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
