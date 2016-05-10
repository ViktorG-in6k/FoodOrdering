package com.controllers;

import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "setResponsibleUser")
    public String setOrderResponsibleUser(@RequestParam("orderId") int orderId){

    return null;
    }

}

