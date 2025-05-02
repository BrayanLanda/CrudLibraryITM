package controllers;

import models.Order;

import java.util.ArrayList;
import java.util.List;

public class OderController {
    private List<Order> orders = new ArrayList<>();

    // Create
    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("✅ Order created successfully.");
    }

    // Read
    public void listOrders() {
        if (orders.isEmpty()) {
            System.out.println("⚠️ No orders found.");
            return;
        }
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    // Delete
    public boolean deleteOrder(int id) {
        return orders.removeIf(order -> order.getId() == id);
    }
}
