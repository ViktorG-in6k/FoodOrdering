package com.serviceLayer.implementation;

import com.dataLayer.DAO.MenuDAO;
import com.dataLayer.DAO.OrderDAO;
import com.model.Menu;
import com.model.Order;
import com.serviceLayer.service.MenuService;
import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    public void save(Order order) {
        orderDAO.save(order);
    }
}