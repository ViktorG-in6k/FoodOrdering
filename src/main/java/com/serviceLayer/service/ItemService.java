//this
package com.serviceLayer.service;

import com.model.Entity.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;


public interface ItemService {
    public void save(Item item);

    public void saveByRequest(HttpServletRequest req, HttpSession session);

    public Item getItemById(int id);

    void updateItemPrice(int id, BigDecimal price);
}
