package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.ItemDTO;
import com.DTOLayer.DTOEntity.RequestItemDTO;
import com.DTOLayer.DTOEntity.itemDTO.RequestItem;
import com.model.Entity.Item;

import javax.servlet.http.HttpServletRequest;


public interface ItemService {
    public void save(Item item);

    public void saveByRequest(RequestItem requestItem);

    public void saveByRequest(HttpServletRequest req);

    abstract Item getItemById(int id);

    public ItemDTO getItemDTOById(int id);

    void updateItemPrice(RequestItemDTO item);

    void updateItemName(RequestItemDTO item);
}

