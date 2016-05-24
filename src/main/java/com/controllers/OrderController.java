package com.controllers;

import com.dataLayer.entity.DTO.itemDTO.ItemDTO;
import com.dataLayer.entity.DTO.orderDTO.OrderDTO;
import com.dataLayer.entity.DTO.orderDTO.OrderPlacementStatus;
import com.dataLayer.entity.DTO.userDTO.UserDTO;
import com.dataLayer.entity.base.Order;
import com.dataLayer.entity.base.Status;
import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Set;

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
    public String changeOrderStatus(@PathVariable int orderId, @RequestParam("status") Status status, @RequestParam("splitBillId") int splitBillId) throws IOException {
        orderService.changeOrderStatus(orderId, status, splitBillId);
        return "{\"status\":\"200\"}";
    }

    @RequestMapping(value = "api/orders/{id}", method = RequestMethod.GET)
    public OrderDTO getOrderById(@PathVariable("id") int id) {
        return new OrderDTO(orderService.getOrderById(id));
    }

    @RequestMapping(value = "api/orders", method = RequestMethod.POST)
    public OrderDTO createOrder(@RequestParam("eventId") int eventId, @RequestParam("restaurantId") int restaurantId,
                              Authentication authentication) {
        Order order = orderService.createOrder(eventId, restaurantId);
        setResponsibleUser(authentication, order.getId());
        return new OrderDTO(order);
    }

    private int getCurrentUserId(Authentication authentication) {
        return ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
    }

    @RequestMapping("api/orderPlacementStatus/{orderId}")
    private OrderPlacementStatus getOrderPlacementStatus(@PathVariable("orderId") int orderId, Authentication authentication){
        Order order = orderService.getOrderById(orderId);
        return orderService.getOrderPlacementStatusByOrderId(order, authentication);
    }
}

