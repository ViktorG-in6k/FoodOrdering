package com.controllers;

import com.dataLayer.entity.DTO.orderItemDTO.OrderItemDTO;
import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.serviceLayer.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping(value = "/orders/{orderId}/items/{itemId}", method = RequestMethod.POST)
    public String addOneItemToOrder(HttpServletRequest req, Authentication authentication,
                                    @PathVariable("orderId") int orderId,
                                    @PathVariable("itemId") int itemId) {
        orderItemService.addOneItemToOrder(authentication, itemId, orderId);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/orders/{orderId}/items/{itemId}", method = RequestMethod.DELETE)
    public String deleteOneItemFromOrder(HttpServletRequest req, Authentication authentication,
                                         @PathVariable("orderId") int orderId,
                                         @PathVariable("itemId") int itemId) {
        orderItemService.remoteOneItemFromOrder(authentication, itemId, orderId);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/orders/{orderId}/items/{itemId}/all", method = RequestMethod.DELETE)
    public String deletePositionFromOrder(HttpServletRequest req, Authentication authentication,
                                          @PathVariable("orderId") int orderId,
                                          @PathVariable("itemId") int itemId) {
        orderItemService.remotePositionFromOrder(authentication, itemId, orderId);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/orders/{orderId}/items/{itemId}/{number}", method = RequestMethod.PUT)
    public String updateNumberItemToOrder(HttpServletRequest req, Authentication authentication,
                                          @PathVariable("number") int number,
                                          @PathVariable("orderId") int orderId,
                                          @PathVariable("itemId") int itemId) {
        orderItemService.updateItemAmountInOrder(authentication, orderId, itemId, number);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    public
    @ResponseBody
    List<OrderItemDTO> getOrderListByCurrentUser(Authentication authentication,
                                                 @PathVariable("orderId") int orderId) {
        return orderItemService.getOrderListByOrderIdAndUserId(orderId,
                ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId());
    }
}

