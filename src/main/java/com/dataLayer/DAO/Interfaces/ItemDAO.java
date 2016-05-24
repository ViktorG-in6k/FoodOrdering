package com.dataLayer.DAO.Interfaces;

import com.dataLayer.entity.base.Item;

import java.math.BigDecimal;
import java.util.List;

public interface ItemDAO {
    public void save(Item item);

    public Item getItemById(int id);

    List<Item> getItemsByRestaurantId(int restaurantId);

    void updatePrice(int id, BigDecimal price);

    void updateName(int id, String name);

    void updateDescription(int id, String description);
}

