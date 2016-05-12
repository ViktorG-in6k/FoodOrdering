package com.controllers;

import com.dataLayer.entity.DTO.RequestItemDTO;
import com.dataLayer.entity.DTO.itemDTO.ItemDTO;
import com.dataLayer.entity.DTO.itemDTO.ItemRequest;
import com.serviceLayer.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/update_name_of_item", method = RequestMethod.POST)
    public ResponseEntity<ItemDTO> updateNameOfItem(@RequestBody RequestItemDTO item) {
        itemService.updateItemName(item);
        ItemDTO itemDTO = itemService.getItemDTOById(item.getId());
        return new ResponseEntity<>(itemDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/update_price_of_item", method = RequestMethod.POST)
    public ResponseEntity<ItemDTO> updatePriceOfItem(@RequestBody RequestItemDTO item) {
        itemService.updateItemPrice(item);
        ItemDTO itemDTO = itemService.getItemDTOById(item.getId());
        return new ResponseEntity<>(itemDTO, HttpStatus.OK);
    }
}

