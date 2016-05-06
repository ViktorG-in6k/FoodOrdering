package com.serviceLayer.implementation;

import com.DTOLayer.DTOEntity.restaurantDTO.RestaurantDTO;
import com.DTOLayer.DTOEntity.itemDTO.ItemDTO;
import com.DTOLayer.DTOEntity.RequestItemDTO;
import com.DTOLayer.DTOEntity.itemDTO.ItemRequest;
import com.dataLayer.DAO.ItemDAO;
import com.model.Entity.Item;
import com.model.Entity.Restaurant;
import com.serviceLayer.service.ItemService;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDAO itemDAO;
    @Autowired
    RestaurantService restaurantService;

    @Override
    public void save(Item item) {
        itemDAO.save(item);
    }

    @Override
    public void saveByRequest(ItemRequest itemRequest) {
        Item item = new Item(itemRequest.getName(), itemRequest.getPrice(), restaurantService.getRestaurantById(itemRequest.getRestaurantId()));
        itemDAO.save(item);
    }

    @Override
    public void saveByRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Restaurant restaurant = restaurantService.getRestaurantById(Integer.parseInt(req.getParameter("restaurantId")));
        Item item = new Item(name, price, restaurant);
        itemDAO.save(item);
    }

    @Override
    public RestaurantDTO getItemsByRestaurant(int id) {
       return restaurantService.getRestaurantDTOById(id);

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
}

