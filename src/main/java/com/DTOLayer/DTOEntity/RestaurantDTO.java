package com.DTOLayer.DTOEntity;

import com.model.Entity.Item;
import com.model.Entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDTO {
    protected int id;
    protected String name;
    protected String phone;
    protected String link;

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDTO> itemList) {
        this.itemList = itemList;
    }

    private List<ItemDTO> itemList = new ArrayList<ItemDTO>();

    public RestaurantDTO(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.phone = restaurant.getPhone();
        this.link = restaurant.getLink();
        for (Item item : restaurant.getItem()) {
            this.itemList.add(new ItemDTO(item));
        }
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLink() {
        return link;
    }

    public int getId() {
        return id;
    }
}

