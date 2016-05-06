package com.serviceLayer.implementation;

import com.dataLayer.DAO.OrderDAO;
import com.model.Entity.Order;
import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO orderDAO;

    @Override
    public void save(Order order) {
        orderDAO.save(order);
    }


}
