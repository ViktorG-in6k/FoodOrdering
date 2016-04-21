package com.dataLayer.DAO;

import com.model.Entity.Item;

import java.math.BigDecimal;

public interface ItemDAO {
    public void save(Item item);

    public Item getItemById(int id);

    void updatePrice(int id, BigDecimal price);

    void updateName(int id, String name);
}
