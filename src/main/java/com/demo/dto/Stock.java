package com.demo.dto;

import java.util.List;

public class Stock {

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stock{");
        sb.append("orders=").append(orders);
        sb.append('}');
        return sb.toString();
    }
}
