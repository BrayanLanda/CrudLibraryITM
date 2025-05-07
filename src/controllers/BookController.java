package controllers;

import models.Book;

public class BookController {
    private Book[] books;
    private int count;

    public BookController(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    // Create
    public void addBook(Book book) {
        if (count >= books.length) {
            System.out.println("⚠️ The library is full. Cannot add more books.");
            return;
        }
        books[count] = book;
        count++;
        System.out.println("✅ Book added successfully.");
    }

    // Read
    public void listBooks() {
        if (count == 0) {
            System.out.println("⚠️ No books available.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    // Update
    public boolean updateBook(int id, String newTitle, String newAuthor, double newPrice, int newStock) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                books[i].setTitle(newTitle);
                books[i].setAuthor(newAuthor);
                books[i].setPrice(newPrice);
                books[i].setStock(newStock);
                System.out.println("✅ Book updated successfully.");
                return true;
            }
        }
        System.out.println("❌ Book not found.");
        return false;
    }

    // Delete
    public boolean deleteBook(int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[count - 1] = null;
                count--;
                System.out.println("✅ Book deleted successfully.");
                return true;
            }
        }
        System.out.println("❌ Book not found.");
        return false;
    }

    // Search by ID
    public Book findBookById(int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                return books[i];
            }
        }
        return null;
    }

    // Search by Title
    public void sortBooksByPrice() {
        if (count == 0) {
            System.out.println("⚠️ No books to sort.");
            return;
        }
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (books[j].getPrice() > books[j + 1].getPrice()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
        System.out.println("✅ Books sorted by price (ascending).");
    }

    // Sort by Title
    public void sortByTitle() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (books[j].getTitle().compareToIgnoreCase(books[j + 1].getTitle()) > 0) {
                    // Swap
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
        System.out.println("✅ Books sorted by title.");
    }
}
