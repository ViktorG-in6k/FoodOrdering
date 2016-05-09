package com.controllers;

import com.DTOLayer.DTOEntity.orderItemDTO.OrderItemRequest;
import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/add_to_order", method = RequestMethod.POST)
    public String addToOrder(@RequestBody OrderItemRequest itemRequest, HttpServletRequest req,HttpSession session) {
        orderService.save(itemRequest, session);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }
}

