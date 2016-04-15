package com.model.ResponseEntity;

import com.model.Restaurant;

public class ResponseRestaurant {
    private int id;
    private String name;
    private String description;
    private String imageURL;

    public ResponseRestaurant(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.description = restaurant.getDescription();
        this.imageURL = restaurant.getImageURL();
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
}
