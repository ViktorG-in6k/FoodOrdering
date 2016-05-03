package com.controllers;

import com.DTOLayer.DTOEntity.orderDTO.OrderDTOList;
import com.DTOLayer.DTOEntity.orderDTO.OrderDTOListOfEachUser;
import com.model.Entity.Event;
import com.model.Entity.Item;
import com.model.Entity.Order;
import com.model.Entity.User;
import com.serviceLayer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    UserService userService;
    @Autowired
    ItemService itemService;

    @RequestMapping("/MyOrderJson_{event}")
    public
    @ResponseBody
    OrderDTOList getMyOrderByEvent(HttpSession session, @PathVariable("event") int eventId) {
        int userId = (int) session.getAttribute("userId");
        return orderService.orderListOfUserByEvent(userId, eventId);
    }

    @RequestMapping("/CommonOrderJson_{event}")
    public
    @ResponseBody
    OrderDTOList getCommonOrderByEvent(@PathVariable("event") int eventId) {
        return orderService.orderListOfEvent(eventId);
    }

    @RequestMapping("/CommonOrderJson_{event}/{restaurant}")
    public
    @ResponseBody
    OrderDTOList getCommonOrderByEventAndRestaurant(@PathVariable("event") int eventId, @PathVariable("restaurant") int restaurantId) {
        return orderService.orderListOfUserByRestaurant(eventId, restaurantId);
    }

    @RequestMapping("/CommonOrder_{event}")
    public
    @ResponseBody
    List<OrderDTOListOfEachUser> getCommonOrderForResponsible(@PathVariable("event") int eventId) {
        return orderService.orderDTOListOfEachUser(eventId);
    }

    @RequestMapping("/update_ordered{event}_{item}_{ordered}")
    public
    @ResponseBody
    OrderDTOList updateOrdered(HttpSession session, @PathVariable("event") int eventId,
                               @PathVariable("item") int itemId,
                               @PathVariable("ordered") boolean ordered) {
        int userId = (int) session.getAttribute("userId");
        orderService.updateOrderedOfOrder(ordered, eventId, itemId);
        return orderService.orderListOfUserByEvent(userId, eventId);
    }

    @RequestMapping("/remote_from_order{item}_{event}")
    public
    @ResponseBody
    OrderDTOList remoteItemFromMyOrder(HttpSession session, @PathVariable("event") int eventId, @PathVariable("item") int itemId) {
        int userId = (int) session.getAttribute("userId");
        orderService.deleteItemFromOrder(userId, eventId, itemId);
        return orderService.orderListOfUserByEvent(userId, eventId);
    }

    @RequestMapping("/remote_one_item_from_order{item}_{event}")
    public
    @ResponseBody
    OrderDTOList remoteOneItem(HttpSession session, @PathVariable("event") int eventId, @PathVariable("item") int itemId) {
        int userId = (int) session.getAttribute("userId");
        orderService.deleteOneItemFromOrder(userId, eventId, itemId);
        return orderService.orderListOfUserByEvent(userId, eventId);
    }

    @RequestMapping(value = "/add_to_order", method = RequestMethod.POST)
    public String addToOrder(HttpServletRequest req, HttpSession session) {
        orderService.saveByRequest(req, session);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping("/remote_item_from_order{item}_{event}_{number}")
    public
    @ResponseBody
    OrderDTOList remoteNumberItem(HttpSession session, @PathVariable("event") int eventId, @PathVariable("item") int itemId, @PathVariable("number") int number) {
        int userId = (int) session.getAttribute("userId");
        for(int i = 0; i < number; i++){
            orderService.deleteOneItemFromOrder(userId, eventId, itemId);
        }
        return orderService.orderListOfUserByEvent(userId, eventId);
    }

    @RequestMapping(value = "/add_number_item_to_order", method = RequestMethod.POST)
    public String addToOrder(HttpServletRequest req, HttpSession session, @RequestParam("number") int number, @RequestParam("event_id") int eventId, @RequestParam("item_id") int itemId) {
        User user = userService.getUser((int) session.getAttribute("userId"));
        Event event = eventService.getEventById(eventId);
        Item item = itemService.getItemById(itemId);
        for(int i = 0; i < number; i++){
        orderService.save( new Order(user, item, event));
        }
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

}

