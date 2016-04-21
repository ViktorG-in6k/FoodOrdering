package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.RequestItemDTO;
import com.model.Entity.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public interface ItemService {
    public void save(Item item);

    public void saveByRequest(HttpServletRequest req, HttpSession session);

    public Item getItemById(int id);

    void updateItemPrice(RequestItemDTO item);

    void updateItemName(RequestItemDTO item);
}

