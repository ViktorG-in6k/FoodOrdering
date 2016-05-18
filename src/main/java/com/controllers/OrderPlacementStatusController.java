package com.controllers;

import com.dataLayer.entity.DTO.orderDTO.OrderPlacementStatus;
import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class OrderPlacementStatusController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "api/orderPlacementStatus/", method = RequestMethod.GET)
    public List<OrderPlacementStatus> getOrderPlacementStatus(Authentication authentication, @RequestParam("eventId") int evenId,
                                                              @RequestParam("restaurantId") int restaurantId) {
        return orderService.getOrderPlacementStatusByEventIdAndRestaurantId(evenId, restaurantId, authentication);
    }
}
