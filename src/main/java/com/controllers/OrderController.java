package com.controllers;

import com.model.Order;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.OrderService;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    EventService eventService;
    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "/ordersJson/{event}")
    public  @ResponseBody
    List<Order> get_my_order_by_event(HttpSession session, @PathVariable("event") int eventId) {
        int userId = (int) session.getAttribute("userId");
        List<Order>orders = orderService.orderListOfUserByEvent(userId,eventId);

        return orders;
    }


}
