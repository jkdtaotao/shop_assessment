package com.demo.dto;

import javax.validation.Valid;
import java.util.List;

public class OrderForm {

    @Valid
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderForm{");
        sb.append("items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
