package com.serviceLayer.implementation;

import com.dataLayer.entity.DTO.itemDTO.ItemDTO;
import com.dataLayer.entity.DTO.RequestItemDTO;
import com.dataLayer.entity.DTO.itemDTO.ItemRequest;
import com.dataLayer.DAO.Interfaces.ItemDAO;
import com.dataLayer.entity.base.Item;
import com.serviceLayer.service.ItemService;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

