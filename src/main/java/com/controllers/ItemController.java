package com.controllers;

import com.DTOLayer.DTOEntity.RequestItemDTO;
import com.DTOLayer.DTOEntity.orderDTO.OrderDTOList;
import com.serviceLayer.service.ItemService;
import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ItemController {
    @Autowired
    ItemService itemService;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/new_item", method = RequestMethod.POST)
    public String newItem(HttpServletRequest req, HttpSession session) {
        itemService.saveByRequest(req, session);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/update_item_price", method = RequestMethod.POST)
    public ResponseEntity<OrderDTOList> updateItemPrice(@RequestBody RequestItemDTO item) {
        itemService.updateItemPrice(item);
        OrderDTOList commonOrder = orderService.orderListOfEvent(item.getEventId());
        return new ResponseEntity<OrderDTOList>(commonOrder,HttpStatus.OK);
    }

    @RequestMapping(value = "/update_item_name", method = RequestMethod.POST)
    public ResponseEntity<OrderDTOList> updateItemName(@RequestBody RequestItemDTO item) {
        itemService.updateItemName(item);
        OrderDTOList commonOrder = orderService.orderListOfEvent(item.getEventId());
        return new ResponseEntity<OrderDTOList>(commonOrder,HttpStatus.OK);
    }
}

