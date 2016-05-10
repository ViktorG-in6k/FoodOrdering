package com.controllers;

import com.DTOLayer.DTOEntity.orderItemDTO.OrderItemRequest;
import com.serviceLayer.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping(value = "/add_one_item_to_order", method = RequestMethod.POST)
    public String addOneItemToOrder(HttpServletRequest req, HttpSession session,
                                    @RequestBody OrderItemRequest itemRequest) {
        orderItemService.addOneItemToOrder(session, itemRequest.getItem().getId(), itemRequest.getOrder().getId());
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/update_number_item_to_order", method = RequestMethod.POST)
    public String updateNumberItemToOrder(HttpServletRequest req, HttpSession session,
                                          @RequestParam("number") int number,
                                          @RequestParam("event_id") int eventId,
                                          @RequestParam("item_id") int itemId) {
        orderItemService.updateItemAmountInOrder(session, eventId, itemId, number);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }
}
