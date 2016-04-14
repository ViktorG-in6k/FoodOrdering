package com.dataLayer.DAO;

import com.model.Item;

public interface MenuDAO {
    public void save(Item item);
    public Item getItemById(int id);
}
