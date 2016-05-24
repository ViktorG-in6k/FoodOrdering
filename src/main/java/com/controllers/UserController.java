package com.controllers;

import com.dataLayer.entity.DTO.orderItemDTO.OrderItemDTO;
import com.dataLayer.entity.DTO.userDTO.UserDTO;
import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/orders/{orderId}/items/{itemId}/users/{name}", method = RequestMethod.GET)
    public
    @ResponseBody
    Set<UserDTO> getOrderListByCurrentUser(@PathVariable("orderId") int orderId,
                                           @PathVariable("itemId") int itemId,
                                           @PathVariable("name") String name) {
        return userService.getUnusedUsersFromItemOrder(orderId, itemId, name);
    }
}
