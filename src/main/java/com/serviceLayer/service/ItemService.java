package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.restaurantDTO.RestaurantDTO;
import com.DTOLayer.DTOEntity.itemDTO.ItemDTO;
import com.DTOLayer.DTOEntity.RequestItemDTO;
import com.DTOLayer.DTOEntity.itemDTO.ItemRequest;
import com.model.Entity.Item;

import javax.servlet.http.HttpServletRequest;


public interface ItemService {
    public void save(Item item);

    public void saveByRequest(ItemRequest itemRequest);

    public void saveByRequest(HttpServletRequest req);

    RestaurantDTO getItemsByRestaurant(int id);

    abstract Item getItemById(int id);

    public ItemDTO getItemDTOById(int id);

    void updateItemPrice(RequestItemDTO item);

    void updateItemName(RequestItemDTO item);
}

