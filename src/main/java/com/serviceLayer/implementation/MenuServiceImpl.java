package com.serviceLayer.implementation;

import com.dataLayer.DAO.MenuDAO;
import com.model.Entity.Item;
import com.model.Entity.Restaurant;
import com.serviceLayer.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDAO itemDAO;

    public void save(Item item) {
        if (item.getImageURL().equals("")) {
            item.setImageURL("/resources/image/shief.jpg");
        }
        itemDAO.save(item);
    }

    public void saveByRequest(HttpServletRequest req, HttpSession session) {
        String name = req.getParameter("name");
        String description = req.getParameter("discript");
        String URLimage = req.getParameter("image");
        BigDecimal price = new BigDecimal(req.getParameter("price"));

        Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");

        Item item = new Item( name, description, URLimage, price, restaurant);
        if (item.getImageURL().equals("")) {
            item.setImageURL("/resources/image/shief.jpg");
        }
        itemDAO.save(item);
    }

    public Item getItemById(int id){
        return itemDAO.getItemById(id);
    }
}
