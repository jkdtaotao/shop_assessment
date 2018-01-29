package com.demo.service;

import com.demo.dto.Order;
import com.demo.dto.OrderForm;
import com.demo.enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {
    public static final String BECAUSE_ORDER = ". Because Order ";
    public static final String NUMBER = " quantity:";
    public static final String EXCEEDED_STOCK_NUMBER = " exceeded quantity of stock: ";
    public static final int ZERO = 0;

    @Autowired
    StockService stockService;

    public OrderForm order(OrderForm orderForm){
        OrderForm result = new OrderForm();
        Map<String, Order> orderFormMap = new HashMap<>();
        for (Order order : orderForm.getOrders()) {
            orderFormMap.put(order.getName(), order);
        }
        List<Order> tempMapOrder = stockService.getOrders().stream().collect(Collectors.toList());
        for (Order order : tempMapOrder) {
            if(order.getQuantity() >= orderFormMap.get(order.getName()).getQuantity()){
                order.setQuantity(order.getQuantity() - orderFormMap.get(order.getName()).getQuantity());
                if(orderFormMap.get(order.getName()).getQuantity()!=0){
                    orderFormMap.get(order.getName()).setStatus(OrderStatusEnum.SUCCESS.getName());
                }
            }
            else{
                orderFormMap.get(order.getName()).setStatus(OrderStatusEnum.OUT_OF_STOCK.getName()+ BECAUSE_ORDER +order.getName()+ NUMBER + orderFormMap.get(order.getName()).getQuantity() + EXCEEDED_STOCK_NUMBER + order.getQuantity());
                orderFormMap.get(order.getName()).setQuantity(ZERO);
            }
        }
        result.setOrders(orderFormMap.values().stream().collect(Collectors.toList()));
        stockService.setOrders(tempMapOrder);
        return result;
    }



}
