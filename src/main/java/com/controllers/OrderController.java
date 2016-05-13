package com.controllers;

import com.dataLayer.entity.DTO.orderDTO.OrderDTO;
import com.dataLayer.entity.base.Status;
import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/orders/{orderId}/responsibility", method = RequestMethod.POST)
    public String setResponsibleUser(HttpServletRequest req, Authentication authentication,
                                     @PathVariable("orderId") int orderId) {
        orderService.setPayerById(orderId, getCurrentUserId(authentication));
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/orders/{orderId}/responsibility", method = RequestMethod.DELETE)
    public String removeResponsibleUser(HttpServletRequest req,
                                        @PathVariable("orderId") int orderId) {
        orderService.removePayer(orderId);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    private int getCurrentUserId(Authentication authentication) {
        return ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
    }

    @RequestMapping(value = "orders/{orderId}/status", method = RequestMethod.PUT)
    public
    @ResponseBody
    String changeOrderStatus(@PathVariable int orderId, @RequestParam("status") Status status) {
        orderService.changeOrderStatus(orderId, status);
        return "{\"status\":\"ok\"}";
    }

    @RequestMapping(value = "api/orders/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    OrderDTO getOrderById(@PathVariable("id") int id) {
        return new OrderDTO(orderService.getOrderById(id));
    }
}

