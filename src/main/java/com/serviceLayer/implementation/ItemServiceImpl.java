package com.serviceLayer.implementation;

import com.DTOLayer.DTOEntity.itemDTO.ItemDTO;
import com.DTOLayer.DTOEntity.itemDTO.RequestItemDTO;
import com.dataLayer.DAO.ItemDAO;
import com.model.Entity.Item;
import com.model.Entity.Restaurant;
import com.serviceLayer.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDAO itemDAO;

    @Override
    public void save(Item item) {
        if (item.getImageURL().equals("")) {
            item.setImageURL("/resources/image/shief.jpg");
        }
        itemDAO.save(item);
    }

    @Override
    public void saveByRequest(HttpServletRequest req, HttpSession session) {
        String name = req.getParameter("name");
        String description = req.getParameter("discript");
        String URLimage = req.getParameter("image");
        BigDecimal price = new BigDecimal(req.getParameter("price"));

        Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");

        Item item = new Item(name, description, URLimage, price, restaurant);
        if (item.getImageURL().equals("")) {
            item.setImageURL("/resources/image/shief.jpg");
        }
        itemDAO.save(item);
    }

    @Override
    public Item getItemById(int id) {
        return itemDAO.getItemById(id);
    }

    @Override
    public ItemDTO getItemDTOById(int id) {
        return new ItemDTO(itemDAO.getItemById(id));
    }

    @Override
    public void updateItemPrice(RequestItemDTO item) {
        itemDAO.updatePrice(item.getId(), item.getPrice());
    }

    @Override
    public void updateItemName(RequestItemDTO item) {
        itemDAO.updateName(item.getId(), item.getName());
    }

    @Override
    public void updateItemDescription(RequestItemDTO item) {
        itemDAO.updateDescription(item.getId(), item.getDescription());
    }
}

