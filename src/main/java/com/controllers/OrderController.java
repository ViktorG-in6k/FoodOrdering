package com.controllers;

import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
}

