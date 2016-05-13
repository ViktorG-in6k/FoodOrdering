package com.dataLayer.entity.DTO.restaurantDTO;

import com.dataLayer.entity.base.Restaurant;

public class RestaurantDTOforOrder {
    private String name;

    public RestaurantDTOforOrder(Restaurant restaurant) {
        name = restaurant.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

