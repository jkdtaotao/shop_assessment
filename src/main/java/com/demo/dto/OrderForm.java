package com.demo.dto;

import javax.validation.Valid;
import java.util.List;

public class OrderForm {

    @Valid
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderForm{");
        sb.append("orders=").append(orders);
        sb.append('}');
        return sb.toString();
    }
}
