package com.serviceLayer.service;

import com.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface OrderService {
    public void save(Order order);

    public void saveByRequest(HttpServletRequest req, HttpSession session);
}