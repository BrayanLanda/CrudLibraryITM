package controllers;

import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private List<Customer> customers = new ArrayList<>();

    // Create
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("✅ Customer added successfully.");
    }

    // Read
    public void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("⚠️ No customers found.");
            return;
        }
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    // Update
    public boolean updateCustomer(int id, String newName, String newEmail, String newPhone) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customer.setName(newName);
                customer.setEmail(newEmail);
                customer.setPhone(newPhone);
                System.out.println("✅ Customer updated successfully.");
                return true;
            }
        }
        System.out.println("❌ Customer not found.");
        return false;
    }

    // Delete
    public boolean deleteCustomer(int id) {
        return customers.removeIf(customer -> customer.getId() == id);
    }

    // Search by ID (helper method)
    public Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
