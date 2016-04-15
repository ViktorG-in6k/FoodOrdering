package com.controllers;

import com.DTOLayer.DTOEntity.EventDTO;
import com.DTOLayer.DTOEntity.orderDTO.OrderDTOList;
import com.DTOLayer.DTOEntity.OrderDTO;
import com.model.Entity.Event;
import com.model.Entity.Order;
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
    OrderDTOList get_my_order_by_event(HttpSession session, @PathVariable("event") int eventId) {
        int userId = (int) session.getAttribute("userId");
        return new OrderDTOList(orderService.orderListOfUserByEvent(userId,eventId));
    }

    @RequestMapping("/CommonOrderJson_{event}")
    public  @ResponseBody
    OrderDTOList get_common_order_by_event(@PathVariable("event") int eventId) {
        return new OrderDTOList(orderService.orderListOfEvent(eventId));
    }

    @RequestMapping("/eventsJson/")
    public @ResponseBody
    Set<EventDTO> getEvent() {
        Set<EventDTO> EventDTOs = new HashSet<>();
        for (Event e: eventService.getListOfAllEvents()) {
            EventDTOs.add(new EventDTO(e));
        }
        return EventDTOs;
    }
}
