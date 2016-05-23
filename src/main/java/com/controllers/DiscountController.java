package com.controllers;

import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiscountController {
    @Autowired
    OrderService orderService;

    @RequestMapping( value = "api/orders/{orderId}/percentageDiscount", method = RequestMethod.PUT)
    public @ResponseBody String updatePercentageDiscount(@PathVariable("orderId")int orderId, @RequestParam("percentage") double percentage){
        orderService.updatePercentageDiscount(orderId, percentage);
        return "{\"status\":\"200\"}";
    }

    @RequestMapping( value = "api/orders/{orderId}/amountDiscount", method = RequestMethod.PUT)
    public @ResponseBody String updateAmountDiscount(@PathVariable("orderId")int orderId, @RequestParam("amount") double amount){
        orderService.updateAmountDiscount(orderId, amount);
        return "{\"status\":\"200\"}";
    }
}


