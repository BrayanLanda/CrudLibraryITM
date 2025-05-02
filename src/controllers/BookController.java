package controllers;

import models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    private List<Book> books = new ArrayList<>();

    // Create
    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added successfully.");
    }

    // Read
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("⚠️ No books available.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Update
    public boolean updateBook(int id, String newTitle, String newAuthor, double newPrice, int newStock) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setPrice(newPrice);
                book.setStock(newStock);
                System.out.println("✅ Book updated successfully.");
                return true;
            }
        }
        System.out.println("❌ Book not found.");
        return false;
    }

    // Delete
    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getId() == id);
    }

    // Search by ID (helper method)
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
