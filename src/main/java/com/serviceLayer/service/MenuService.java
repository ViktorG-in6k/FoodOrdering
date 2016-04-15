package com.serviceLayer.service;

import com.model.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public interface MenuService {
    public void save(Item item);

    public void saveByRequest(HttpServletRequest req, HttpSession session);

    public Item getItemById(int id);
}
