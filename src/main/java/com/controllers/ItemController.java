package com.controllers;

import com.DTOLayer.DTOEntity.RequestItemDTO;
import com.DTOLayer.DTOEntity.itemDTO.ItemDTO;
import com.DTOLayer.DTOEntity.itemDTO.ItemRequest;
import com.DTOLayer.DTOEntity.restaurantDTO.RestaurantDTO;
import com.serviceLayer.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/new_item", method = RequestMethod.POST)
    public
    @ResponseBody
    RestaurantDTO newItem(HttpSession session,
                          @RequestBody ItemRequest item,
                          @RequestParam("event_id") int eventId) {
        itemService.saveByRequest(item);
        return itemService.getItemsByRestaurant(eventId,item.getRestaurantId(),session);
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

