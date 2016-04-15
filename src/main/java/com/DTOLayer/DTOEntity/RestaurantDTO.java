package com.DTOLayer.DTOEntity;

import com.model.Entity.Item;
import com.model.Entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDTO {
    protected int id;
    protected String name;
    protected String description;
    protected String imageURL;

    private List<ItemDTO> itemList = new ArrayList<ItemDTO>();

    public RestaurantDTO(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.description = restaurant.getDescription();
        this.imageURL = restaurant.getImageURL();
        for (Item item:restaurant.getItem()) {
            this.itemList.add(new ItemDTO(item));
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getId() {
        return id;
    }

    public List<ItemDTO> getItemList() {
        return itemList;
    }
}
