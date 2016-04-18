package com.controllers;

import com.DTOLayer.DTOEntity.orderDTO.OrderDTOList;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.OrderService;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
    OrderDTOList get_my_order_by_event(HttpSession session, @PathVariable("event") int eventId) {
        int userId = (int) session.getAttribute("userId");
        return new OrderDTOList(orderService.orderListOfUserByEvent(userId,eventId));
    }

    @RequestMapping("/CommonOrderJson_{event}")
    public  @ResponseBody
    OrderDTOList get_common_order_by_event(@PathVariable("event") int eventId) {
        return new OrderDTOList(orderService.orderListOfEvent(eventId));
    }

    @RequestMapping("/update_ordered{event}_{item}_{ordered}")
    public  @ResponseBody
    OrderDTOList updateOrdered(HttpSession session,@PathVariable("event") int eventId, @PathVariable("item") int itemId,
                               @PathVariable("ordered") boolean ordered) {
        int userId = (int) session.getAttribute("userId");
        orderService.updateOrderedOfOrder(ordered, eventId, itemId);
        return new OrderDTOList(orderService.orderListOfUserByEvent(userId,eventId));
    }

    @RequestMapping("/remote_from_order{item}_{event}")
    public  @ResponseBody
    OrderDTOList get_common_order_by_event(HttpSession session,@PathVariable("event") int eventId,@PathVariable("item") int itemId) {
        int userId = (int) session.getAttribute("userId");
        orderService.deleteItemFromOrder(userId,eventId,itemId);
        return new OrderDTOList(orderService.orderListOfUserByEvent(userId,eventId));
    }
}
