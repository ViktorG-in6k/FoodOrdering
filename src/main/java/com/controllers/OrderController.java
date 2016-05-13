package com.controllers;

import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}

