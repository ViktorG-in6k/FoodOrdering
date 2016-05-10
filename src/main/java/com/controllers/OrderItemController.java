package com.controllers;

import com.DTOLayer.DTOEntity.orderItemDTO.OrderItemDTO;
import com.serviceLayer.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping(value = "/add_one_item_to_order", method = RequestMethod.POST)
    public String addOneItemToOrder(HttpServletRequest req, Authentication authentication,
                                    @RequestParam("order_id") int orderId,
                                    @RequestParam("item_id") int itemId) {
        orderItemService.addOneItemToOrder(authentication, itemId, orderId);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/update_number_item_to_order", method = RequestMethod.POST)
    public String updateNumberItemToOrder(HttpServletRequest req, Authentication authentication,
                                          @RequestParam("number") int number,
                                          @RequestParam("event_id") int eventId,
                                          @RequestParam("item_id") int itemId) {
        orderItemService.updateItemAmountInOrder(authentication, eventId, itemId, number);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/order_list_of_user", method = RequestMethod.POST)
    public
    @ResponseBody
    List<OrderItemDTO> getOrderListByCurrentUser(HttpSession session,
                                                 @RequestParam("order_id") int orderId) {
        return orderItemService.getOrderListByOrderIdAndUserId(orderId,(int) session.getAttribute("userId"));
    }
}
