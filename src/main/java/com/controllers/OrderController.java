package com.controllers;

import com.model.Event;
import com.model.Order;
import com.model.ResponseEntity.ResponseEvent;
import com.model.ResponseEntity.ResponseOrder;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.OrderService;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    EventService eventService;
    @Autowired
    RestaurantService restaurantService;

    @RequestMapping("/MyOrderJson_{event}")
    public  @ResponseBody
    List<ResponseOrder> get_my_order_by_event(HttpSession session, @PathVariable("event") int eventId) {
        int userId = (int) session.getAttribute("userId");
        List<ResponseOrder>responseOrders = new ArrayList<ResponseOrder>();
        for (Order order: orderService.orderListOfUserByEvent(userId,eventId)) {
            responseOrders.add(new ResponseOrder(order));
        }
        return responseOrders;
    }

    @RequestMapping("/CommonOrderJson_{event}")
    public  @ResponseBody
    List<ResponseOrder> get_common_order_by_event(HttpSession session, @PathVariable("event") int eventId) {

        List<ResponseOrder>responseOrders = new ArrayList<ResponseOrder>();
        for (Order order: orderService.orderListOfEvent(eventId)) {
            responseOrders.add(new ResponseOrder(order));
        }
        return responseOrders;
    }

    @RequestMapping("/eventsJson/")
    public @ResponseBody
    Set<ResponseEvent> getEvent() {
        Set<ResponseEvent>responseEvents = new HashSet<>();
        for (Event e: eventService.getListOfAllEvents()) {
            System.out.println(e.getName());
            responseEvents.add(new ResponseEvent(e));
        }
        return responseEvents;
    }
}
