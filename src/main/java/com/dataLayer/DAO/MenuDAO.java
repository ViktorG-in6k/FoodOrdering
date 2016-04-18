package com.dataLayer.DAO;

import com.model.Entity.Item;

public interface MenuDAO {
    public void save(Item item);
    public Item getItemById(int id);
}
