package com.DTOLayer.DTOEntity.itemDTO;

import java.math.BigDecimal;

public class ItemRequest {
    private String name;
    private BigDecimal price;
    private int restaurantId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

