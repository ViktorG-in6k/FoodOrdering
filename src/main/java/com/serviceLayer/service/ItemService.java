package com.serviceLayer.service;

import com.dataLayer.entity.DTO.RequestItemDTO;
import com.dataLayer.entity.DTO.itemDTO.ItemDTO;
import com.dataLayer.entity.DTO.itemDTO.ItemRequest;
import com.dataLayer.entity.Item;


public interface ItemService {
    public void save(Item item);

    public void saveByRequest(ItemRequest itemRequest);

    abstract Item getItemById(int id);

    public ItemDTO getItemDTOById(int id);

    void updateItemPrice(RequestItemDTO item);

    void updateItemName(RequestItemDTO item);
}

