package com.model.ResponseEntity;

import com.model.Item;
import com.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class ResponseRestaurant {
    private int id;
    private String name;
    private String description;
    private String imageURL;
    private List<ResponseItem> item;

    public ResponseRestaurant(String name, String description, String imageURL) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
    }

    public ResponseRestaurant(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.description = restaurant.getDescription();
        this.imageURL = restaurant.getImageURL();
        this.item = new ArrayList<>();
        for (Item itemOfRestaurant: restaurant.getItem()) {
            this.item.add(new ResponseItem(itemOfRestaurant));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
