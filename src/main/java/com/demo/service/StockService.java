package com.demo.service;

import com.demo.dto.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    private static List<Item> items = new ArrayList<>();
    public static final String A = "A";
    public static final String B = "B";
    public static final int INIT_NUMBER_20 = 20;
    public static final int INIT_NUMBER_10 = 10;

    static {
        items.add(new Item(A, INIT_NUMBER_20));
        items.add(new Item(B, INIT_NUMBER_10));
    }

    public List<Item> getOrders() {
        return items;
    }

    public void setOrders(List<Item> items) {
        StockService.items = items;
    }
}
