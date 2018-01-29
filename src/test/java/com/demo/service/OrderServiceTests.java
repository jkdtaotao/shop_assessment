package com.demo.service;

import com.demo.dto.Order;
import com.demo.dto.OrderForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {
    public static final String A = "A";
    public static final String B = "B";
    public static final int INIT_NUMBER_20 = 20;
    public static final int INIT_NUMBER_10 = 10;
    Logger logger = LoggerFactory.getLogger(OrderServiceTests.class);

    @Autowired
    OrderService orderService;

    @Autowired
    StockService stockService;

    @Before
    public void init(){
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(A, INIT_NUMBER_20));
        orders.add(new Order(B, INIT_NUMBER_10));
        stockService.setOrders(orders);
    }

    @Test
    public void orderServiceOrderSuccess() throws Exception {
        OrderForm inputOrderData = generateInputOrderForm(11,9);
        OrderForm result = orderService.order(inputOrderData);
        Map<String, Integer> orderResultMap = result.getOrders().stream().collect(
                Collectors.toMap(Order::getName, Order::getQuantity));
        Assert.assertEquals(11, java.util.Optional.ofNullable(orderResultMap.get(A)).get().intValue());
        Assert.assertEquals(9, java.util.Optional.ofNullable(orderResultMap.get(B)).get().intValue());
    }

    @Test
    public void orderServiceOrderOutOfStock() throws Exception {
        OrderForm inputOrderData = generateInputOrderForm(11,11);
        OrderForm result = orderService.order(inputOrderData);
        Map<String, Integer> orderResultMap = result.getOrders().stream().collect(
                Collectors.toMap(Order::getName, Order::getQuantity));
        Assert.assertEquals(11, java.util.Optional.ofNullable(orderResultMap.get(A)).get().intValue());
        Assert.assertEquals(0, java.util.Optional.ofNullable(orderResultMap.get(B)).get().intValue());
    }

    private OrderForm generateInputOrderForm(int aOrderCount, int bOrderCount) {
        OrderForm inputOrderData = new OrderForm();
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(A,aOrderCount));
        orders.add(new Order(B,bOrderCount));
        inputOrderData.setOrders(orders);
        return inputOrderData;
    }
}
