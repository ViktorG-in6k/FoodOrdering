package com.controllers;

import com.DTOLayer.DTOEntity.orderDTO.OrderDTOList;
import com.DTOLayer.DTOEntity.orderDTO.OrderDTOListOfEachUser;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.OrderService;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/MyOrderJson_{event}")
    public  @ResponseBody
    OrderDTOList getMyOrderByEvent(HttpSession session, @PathVariable("event") int eventId) {
        int userId = (int) session.getAttribute("userId");
        return orderService.orderListOfUserByEvent(userId,eventId);
    }

    @RequestMapping("/CommonOrderJson_{event}")
    public  @ResponseBody
    OrderDTOList getCommonOrderByEvent(@PathVariable("event") int eventId) {
        return new OrderDTOList(orderService.orderListOfEvent(eventId));
    }

    @RequestMapping("/CommonOrder_{event}")
    public  @ResponseBody
    List<OrderDTOListOfEachUser> getCommonOrderForResponsible(@PathVariable("event") int eventId) {
        return orderService.orderDTOListOfEachUser(eventId);
    }

    @RequestMapping("/update_ordered{event}_{item}_{ordered}")
    public  @ResponseBody
    OrderDTOList updateOrdered(HttpSession session,@PathVariable("event") int eventId,
                               @PathVariable("item") int itemId,
                               @PathVariable("ordered") boolean ordered) {
        int userId = (int) session.getAttribute("userId");
        orderService.updateOrderedOfOrder(ordered, eventId, itemId);
        return orderService.orderListOfUserByEvent(userId,eventId);
    }

    @RequestMapping("/remote_from_order{item}_{event}")
    public  @ResponseBody
    OrderDTOList remoteItemFromMyOrder(HttpSession session,@PathVariable("event") int eventId,@PathVariable("item") int itemId) {
        int userId = (int) session.getAttribute("userId");
        orderService.deleteItemFromOrder(userId,eventId,itemId);
        return orderService.orderListOfUserByEvent(userId,eventId);
    }

    @RequestMapping("/remote_one_item_from_order{item}_{event}")
    public  @ResponseBody
    OrderDTOList remoteOneItem(HttpSession session,@PathVariable("event") int eventId,@PathVariable("item") int itemId) {
        int userId = (int) session.getAttribute("userId");
        orderService.deleteOneItemFromOrder(userId,eventId,itemId);
        return orderService.orderListOfUserByEvent(userId,eventId);
    }

    @RequestMapping(value = "/add_to_order", method = RequestMethod.POST)
    public String addToOrder(HttpServletRequest req, HttpSession session) {
        orderService.saveByRequest(req, session);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }
}
