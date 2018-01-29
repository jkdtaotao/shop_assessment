package com.demo.controller;

import com.demo.dto.*;
import com.demo.service.OrderService;
import com.demo.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
    OrderService orderService;

	@Autowired
    StockService stockService;

	@GetMapping("/")
	public ModelAndView init() {
	    Stock stock = new Stock();
        stock.setOrders(stockService.getOrders());
        return new ModelAndView("index" , "stock", stock);
    }

	@PostMapping("/order")
	public ModelAndView buy(@Valid @ModelAttribute("orderForm") OrderForm orderForm) {
        logger.info("buy request: {}", orderForm.toString());
        OrderForm result = orderService.order(orderForm);
        return new ModelAndView("summary", "orderForm", result);
    }
}