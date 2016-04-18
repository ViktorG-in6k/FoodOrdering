package com.DTOLayer.DTOEntity.restaurantDTO;

import com.model.Entity.Restaurant;
import com.sun.org.apache.regexp.internal.RE;

public class RestaurantDTOforOrder {
    private String name;

    public RestaurantDTOforOrder(Restaurant restaurant){
        name = restaurant.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
