package com.controllers;

import com.dataLayer.entity.DTO.orderDTO.OrderDTO;
import com.dataLayer.entity.base.Status;
import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/orders/{orderId}/responsibility", method = RequestMethod.POST)
    public String setResponsibleUser(Authentication authentication, @PathVariable("orderId") int orderId) {
        orderService.setPayerById(orderId, getCurrentUserId(authentication));
        return "{\"status\":\"200\"}";
    }

    @RequestMapping(value = "/orders/{orderId}/responsibility", method = RequestMethod.DELETE)
    public String removeResponsibleUser(@PathVariable("orderId") int orderId) {
        orderService.removePayer(orderId);
        return "{\"status\":\"200\"}";
    }

    @RequestMapping(value = "orders/{orderId}/status", method = RequestMethod.PUT)
    public String changeOrderStatus(@PathVariable int orderId, @RequestParam("status") Status status) throws IOException {
        orderService.changeOrderStatus(orderId, status);
        return "{\"status\":\"200\"}";
    }

    @RequestMapping(value = "api/orders/{id}", method = RequestMethod.GET)
    public OrderDTO getOrderById(@PathVariable("id") int id) {
        return new OrderDTO(orderService.getOrderById(id));
    }

    private int getCurrentUserId(Authentication authentication) {
        return ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
    }
}

