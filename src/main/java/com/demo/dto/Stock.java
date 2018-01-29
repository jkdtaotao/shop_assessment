package com.demo.dto;

import java.util.List;

public class Stock {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Stock{");
        sb.append("items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
