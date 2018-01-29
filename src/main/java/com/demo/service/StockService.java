package com.demo.service;

import com.demo.dto.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    private static List<Order> orders = new ArrayList<>();
    public static final String A = "A";
    public static final String B = "B";
    public static final int INIT_NUMBER_20 = 20;
    public static final int INIT_NUMBER_10 = 10;

    static {
        orders.add(new Order(A, INIT_NUMBER_20));
        orders.add(new Order(B, INIT_NUMBER_10));
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        StockService.orders = orders;
    }
}
