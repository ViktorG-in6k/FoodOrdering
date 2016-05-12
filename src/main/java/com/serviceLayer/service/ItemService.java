package com.serviceLayer.service;

import com.dataLayer.entity.DTO.restaurantDTO.RestaurantDTO;
import com.dataLayer.entity.DTO.itemDTO.ItemDTO;
import com.dataLayer.entity.DTO.RequestItemDTO;
import com.dataLayer.entity.DTO.itemDTO.ItemRequest;
import com.dataLayer.entity.Item;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;


public interface ItemService {
    public void save(Item item);

    public void saveByRequest(ItemRequest itemRequest);

    public void saveByRequest(HttpServletRequest req);

    RestaurantDTO getItemsByRestaurant(int eventId, int id, Authentication authentication);

    abstract Item getItemById(int id);

    public ItemDTO getItemDTOById(int id);

    void updateItemPrice(RequestItemDTO item);

    void updateItemName(RequestItemDTO item);
}

