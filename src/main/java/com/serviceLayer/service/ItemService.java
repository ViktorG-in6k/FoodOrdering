package com.serviceLayer.service;

import com.dataLayer.entity.DTO.itemDTO.ItemDTO;
import com.dataLayer.entity.DTO.itemDTO.ItemRequest;
import com.dataLayer.entity.base.Item;

import java.util.Set;


public interface ItemService {
    public void save(Item item);

    public void saveByRequest(ItemRequest itemRequest);

    abstract Item getItemById(int id);

    public ItemDTO getItemDTOById(int id);

    void updateItemPrice(int id, double price);

    Set<ItemDTO> getUnusedItems(int orderId, String name);

    void updateItemName(int id , String title);
}

