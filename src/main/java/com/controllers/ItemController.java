package com.controllers;

import com.dataLayer.entity.DTO.itemDTO.ItemRequest;
import com.serviceLayer.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Controller
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public String newItem(HttpServletRequest req,
                          @RequestParam("name") String name,
                          @RequestParam("price") BigDecimal price,
                          @RequestParam("restaurant_id") int restaurantId) {
        ItemRequest item = new ItemRequest(name, price, restaurantId);
        itemService.saveByRequest(item);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value ="/api/items/{itemId}/price", method = RequestMethod.PUT)
    public @ResponseBody String changeItemPrice(@PathVariable("itemId") int id, @RequestParam("price") double price){
        itemService.updateItemPrice(id, price);
        return "{\"status\":\"200\"}";
    }

    @RequestMapping(value = "api/items/{itemId}/title",method = RequestMethod.PUT)
    public @ResponseBody String changeItemTitle(@PathVariable("itemId")int id, @RequestParam("title") String title){
        itemService.updateItemName(id, title);
        return "{\"status\":\"200\"}";
    }
}


