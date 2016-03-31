package com.serviceLayer.implementation;

import com.dataLayer.DAO.MenuDAO;
import com.model.Menu;
import com.serviceLayer.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    MenuDAO menuDAO;

    public void save(Menu item) {
        menuDAO.save(item);
    }
}
